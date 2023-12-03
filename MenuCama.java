import java.util.Scanner;

public class MenuCama {

    public void processamento() {

        CrudCama camas = new CrudCama();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("===== CRUD de Cama =====");
            System.out.println("1. Adicionar Cama");
            System.out.println("2. Atualizar Cama");
            System.out.println("3. Remover Cama");
            System.out.println("4. Listar Camas");
            System.out.println("5. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    camas.incluirCama();
                    break;

                case 2:
                    System.out.println("Digite o ID da cama a ser atualizada: ");
                    int idAtualizar = scanner.nextInt();
                    if (!camas.ValidaId(idAtualizar)){return;}

                    camas.alterarCama(idAtualizar);
                    break;
                
                case 3:
                    System.out.println("Digite o ID da cama a ser removida: ");
                    int idRemover = scanner.nextInt();
                    if (!camas.ValidaId(idRemover)){return;}

                    camas.excluirCama(idRemover);
                    break;

                case 4:
                    camas.listarCamas();
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Digite um número válido");
                    break;
            }
        }
    }
}