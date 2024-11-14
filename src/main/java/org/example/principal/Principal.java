package org.example.principal;

import org.example.modelo.Produtos;

import java.util.*;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private List<Produtos> listaDeProdutos = new ArrayList<>();

    private Map<Produtos, Integer> carrinho = new HashMap<>();

    public void menu() {

        var menu = """
                ------------- Mercadinho 2 irmãos -----------------
                1 - Cadastrar produtos
                2 - Listar Produtos
                3 - Adicionar ao carrinho
                4 - Ver carrinho e finalizar compra
                5 - Finalizar programa
                ---------------------------------------------------
                """;
        System.out.println(menu);
        System.out.println("Digite uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                cadastrarProduto();
                break;
            case 2:
                mostrarProdutos();
                break;
            case 3:
                adicionarAoCarrinho();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                System.out.println("Saindo do programa!");
                System.exit(0);
            default:
                System.out.println("Opção invalida");
                break;
        }
    }

    private void finalizarCompra() {
        Double valorTotal = 0.0;

        System.out.println("------------ Seus produtos ----------------");
        for (Produtos p : carrinho.keySet()) {
            int quantidade = carrinho.get(p);
            valorTotal += p.getPreco() * quantidade;

            System.out.println(p);
            System.out.println("Quantidade: " + quantidade);
            System.out.println("-------------------------------");
        }

        System.out.println("O valor total da compra " + valorTotal);
        carrinho.clear();

        System.out.println("Obrigado pela preferencia!");
        menu();

    }

    private void verCarrinho() {
        System.out.println("------------------- Produtos no carrinho --------------------");
        if (carrinho.size() > 0) {
            for (Produtos p : carrinho.keySet()) {
                System.out.println("Produto " + p);
                System.out.println("Quantidade " + carrinho.get(p));
            }
        } else {
            System.out.println("Seu carrinho esta vazio");
            menu();
        }
    }

    private void adicionarAoCarrinho() {
        /* Esse método faz o seguinte:
         * Primeiro verificamos se existe produtos dentro da lista
         * Imprimimos os itens da lista
         * Verifico se o codigo do produto que o usuario digitou existe na minha lista
         * adiciono meu produto a quantidade e envio para meu map de carrinho
         * No caso não vai existir nenhum produto o que vai causar uma exceção entao trato com try/catch passando no catch um produto
         * pergunto ao usuario se ele quer adicionar mais produtos no carrinho ou finalizar a compra
         * */

        if (listaDeProdutos.size() > 0) {
            System.out.println("----------------- Produtos Disponiveis ---------------------");
            for (Produtos p : listaDeProdutos) {
                System.out.println(p.getId() + " - " + p + "\n");
            }

            System.out.println("Digite o código do produto: ");
            var codigoProduto = sc.nextInt();

            boolean produtoEncontrado = false;
            for (Produtos p : listaDeProdutos) {
                if (p.getId() == codigoProduto) {
                    produtoEncontrado = true;
                    try {
                        // agora vou trabalhar com carrinho, entao preciso colocar como
                        //atributo pois vou precisar listar ele em outro metodo
                        int quantidade = carrinho.get(p); //coletando o produto
                        carrinho.put(p, quantidade + 1); //cada vez que for adicionado sera incrementado a quantidade
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1); // se o produto for o primeiro do carrinho
                    }

                    System.out.println(p.getNome() + " foi adicionado com sucesso ao carrinho");

                    if (produtoEncontrado) {
                        System.out.println("Deseja adionar mais produtos ao carrinho?");
                        System.out.println("Digite 1 se sim ou 0 para finalizar a compra");
                        int opcao = Integer.parseInt(sc.next());

                        switch (opcao) {
                            case 1:
                                adicionarAoCarrinho();
                                System.out.println(p.getNome() + " foi adicionado com sucesso ao carrinho");
                                break;
                            case 0:
                                finalizarCompra();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                menu();
                                break;
                        }
                    }

                }
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado");
                menu();
            }

        } else {
            System.out.println("Não existem produtos cadastrados!");
            menu();
        }
    }

    private void mostrarProdutos() {
        if (listaDeProdutos.size() > 0) {
            for (Produtos p : listaDeProdutos) {
                System.out.println(p);
            }
            menu();
        } else {
            System.out.println("Nenhum produto encontrado!");
            menu();
        }
    }

    private void cadastrarProduto() {

        System.out.println("Qual produto deseja cadastrar? ");
        String produto = sc.nextLine();
        System.out.println("Qual o valor do produto? ");
        Double preco = sc.nextDouble();

        Produtos produtos = new Produtos(produto, preco);
        listaDeProdutos.add(produtos);

        System.out.println(produtos.getNome() + " foi cadastrado com sucesso! ");
        menu();

    }

}