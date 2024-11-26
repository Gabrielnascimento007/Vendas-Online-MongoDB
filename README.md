Sistema de Vendas Online - Mongo

Descrição do Projeto
Este é um sistema de gerenciamento de vendas online que permite controlar produtos, clientes e pedidos. 
O projeto utiliza MongoDB como banco de dados não relacional para armazenar e gerenciar informações. 
Além disso, o sistema fornece relatórios de vendas por categoria e cliente, facilitando a gestão das operações comerciais de forma eficiente.

Funcionalidades
Cadastro e gerenciamento de produtos: Adição, edição, exclusão e listagem de produtos.
Cadastro e gerenciamento de clientes: Gerenciamento completo de clientes com dados como nome, e-mail, telefone e endereço.
Criação e gerenciamento de pedidos: Criação e rastreamento de pedidos associados a clientes e produtos.
Interface amigável: Navegação simplificada via terminal para realizar operações no sistema.

Tecnologias Utilizadas
Java: Linguagem de programação principal para desenvolver o sistema.
MongoDB: Banco de dados NoSQL para armazenamento de dados.
MongoDB Driver: Biblioteca para comunicação com o MongoDB.
Visual Studio Code: IDE utilizada para o desenvolvimento.


src/: Contém o código-fonte do projeto.
vendasOline/: Classes principais relacionadas às entidades do sistema (Cliente, Produto, Pedido).
controle/: Classes responsáveis pelo gerenciamento de operações relacionadas ao banco de dados MongoDB.
utils/: Configurações do MongoDB, como conexão e constantes gerais.

Instalação
Instale o MongoDB: Baixe e configure o servidor MongoDB.
Instale o MongoDB Compass (opcional): Para explorar visualmente as coleções do MongoDB.
MongoDB Driver para Java:
Certifique-se de que o driver MongoDB está configurado no seu projeto. Caso esteja usando um editor sem Maven, adicione manualmente o .jar no build path do projeto.
Visual Studio Code (VS Code): Utilize o VS Code como IDE principal.

Estrutura do Banco de Dados MongoDB
Banco de Dados: meu_banco_mongo
Coleções:
clientes: Armazena os dados dos clientes, como nome, e-mail, telefone e endereço.
produtos: Contém informações de produtos, incluindo nome, descrição, preço e estoque.
pedidos: Armazena informações de pedidos, como data, valor total e o cliente associado.

Observações
Certifique-se de que o MongoDB está em execução antes de iniciar o sistema.
O projeto é completamente funcional com o banco de dados MongoDB e não depende mais do MySQL.
