package vendasOline;

import controle.ClienteControle;
import controle.PedidoControle;
import controle.ProdutoControle;
import utils.SplashScreen;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializando as classes de controle para MongoDB
        ClienteControle clienteControle = new ClienteControle();
        PedidoControle pedidoControle = new PedidoControle();
        ProdutoControle produtoControle = new ProdutoControle();

        // Exibindo o SplashScreen
        System.out.println(SplashScreen.getSplashScreen());

        // Menu principal
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Pedidos");
            System.out.println("3. Gerenciar Produtos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarClientes(clienteControle, scanner);
                    break;
                case 2:
                    gerenciarPedidos(pedidoControle, scanner);
                    break;
                case 3:
                    gerenciarProdutos(produtoControle, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void gerenciarClientes(ClienteControle controller, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciar Clientes:");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    controller.inserirCliente(new Cliente(nome, email, telefone, endereco));
                    break;
                case 2:
                    System.out.print("ID do Cliente a ser atualizado: ");
                    String idAtualizar = scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = scanner.nextLine();
                    controller.atualizarCliente(idAtualizar,
                            new Cliente(novoNome, novoEmail, novoTelefone, novoEndereco));
                    break;
                case 3:
                    System.out.print("ID do Cliente a ser excluído: ");
                    String idExcluir = scanner.nextLine();
                    controller.excluirCliente(idExcluir);
                    break;
                case 4:
                    controller.listarClientes();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void gerenciarPedidos(PedidoControle controller, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciar Pedidos:");
            System.out.println("1. Inserir Pedido");
            System.out.println("2. Excluir Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Data (YYYY-MM-DD): ");
                    LocalDate data = LocalDate.parse(scanner.nextLine());
                    System.out.print("Valor Total: ");
                    BigDecimal valorTotal = new BigDecimal(scanner.nextLine());
                    System.out.print("ID do Cliente: ");
                    int clienteId = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    controller.inserirPedido(new Pedido(0, data, valorTotal, clienteId));
                    break;
                case 2:
                    System.out.print("ID do Pedido a ser excluído: ");
                    String idExcluir = scanner.nextLine();
                    controller.excluirPedido(idExcluir);
                    break;
                case 3:
                    controller.listarPedidos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void gerenciarProdutos(ProdutoControle controller, Scanner scanner) {
        while (true) {
            System.out.println("\nGerenciar Produtos:");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço: ");
                    BigDecimal preco = new BigDecimal(scanner.nextLine());
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadeEstoque = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    controller.inserirProduto(new Produto(0, nome, descricao, preco, quantidadeEstoque));
                    break;
                case 2:
                    System.out.print("ID do Produto a ser atualizado: ");
                    String idAtualizar = scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Descrição: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Novo Preço: ");
                    BigDecimal novoPreco = new BigDecimal(scanner.nextLine());
                    System.out.print("Nova Quantidade em Estoque: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    controller.atualizarProduto(idAtualizar,
                            new Produto(0, novoNome, novaDescricao, novoPreco, novaQuantidade));
                    break;
                case 3:
                    System.out.print("ID do Produto a ser excluído: ");
                    String idExcluir = scanner.nextLine();
                    controller.excluirProduto(idExcluir);
                    break;
                case 4:
                    controller.listarProdutos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
