import java.util.Scanner;

public class MenuCliente {
    
    public void processamento() {

        CrudCliente clientes = new CrudCliente();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("===== CRUD de Cliente =====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
      
            int opcao = scanner.nextInt();
            scanner.nextLine();
      
            switch (opcao) {
              
                case 1:
                    clientes.incluirCliente();
                    break;
                        
                case 2:
                    System.out.println("Digite o ID do cliente a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    if(!clientes.ValidaId(idAtualizar)){return;}
                    
                    clientes.alterarCliente(idAtualizar);
                    break;
                
                case 3:
                    System.out.println("Digite o ID do cliente a ser removido: ");
                    int idExcluir = scanner.nextInt();
                    if(!clientes.ValidaId(idExcluir)){return;}

                    clientes.excluirCliente(idExcluir);
                    break;
                
                case 4:
                    clientes.listarClientes();
                    break; 

                case 5:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    break;
                
                default:
                    System.out.println("Digite um número válido");
                    break;
            }
        }
    }
}