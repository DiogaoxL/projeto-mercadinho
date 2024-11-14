# Projeto Mercadinho
Este projeto é uma aplicação simples de gerenciamento de produtos e carrinho de compras. O sistema permite que o usuário cadastre produtos, visualize os produtos cadastrados, adicione itens ao carrinho, verifique o conteúdo do carrinho e finalize a compra. A aplicação foi desenvolvida como parte de um estudo prático sobre manipulação de dados em uma estrutura de carrinho de compras.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Cadastrar produtos**: Permite que o usuário cadastre novos produtos, informando detalhes como nome, descrição e preço.
2. **Listar produtos**: Exibe todos os produtos cadastrados no sistema.
3. **Adicionar ao carrinho**: O usuário pode adicionar um ou mais produtos ao seu carrinho de compras utilizando o ID do produto.
4. **Ver carrinho e finalizar compra**: Exibe os itens presentes no carrinho e permite que o usuário finalize a compra.
5. **Finalizar programa**: Permite encerrar o sistema de maneira controlada.

## Aprendizados e Maior Desafio

Durante o desenvolvimento do projeto, aprendi sobre como manipular listas e mapas para gerenciar dados de produtos e itens no carrinho de compras. A parte mais desafiadora foi a implementação da lógica de **adicionar produtos ao carrinho a partir de um ID**. O desafio estava em garantir que o produto fosse corretamente localizado pelo ID e, caso já existisse no carrinho, sua quantidade fosse incrementada de forma eficiente. Essa parte do código envolveu o uso de exceções e a manipulação de dados em um `Map`, onde a chave é o produto e o valor é a quantidade.

Esse desafio me ajudou a entender como melhorar o tratamento de dados em coleções e também a simplificar a lógica de verificação de existência de itens no carrinho.
