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
                    System.out.println("Digite o ID da cama: ");
                    int id = scanner.nextInt();
                    if (!camas.ValidaId(id)){return;}
                    
                    System.out.println("Digite o código da cama: ");
                    int codigoCama = scanner.nextInt();
                    if (!camas.ValidaCodigoCama(codigoCama)){return;}

                    System.out.println("A cama é beliche? ");
                    boolean ehBeliche = scanner.nextBoolean();

                    System.out.println("Digite a posicao da cama: ");
                    String posicao = scanner.nextLine();
                    if (!camas.ValidaPosicao(posicao)){return;}

                    System.out.println("Digite a descrição da cama: ");
                    String descricao = scanner.nextLine();
                    if (!camas.ValidaDescricao(descricao)){return;}

                    camas.incluirCama(id, codigoCama, ehBeliche, posicao, descricao);
                    break;

                case 2:
                    System.out.println("Digite o ID da cama a ser atualizada: ");
                    int idAtualizar = scanner.nextInt();
                    if (!camas.ValidaId(idAtualizar)){return;}

                    System.out.println("Digite o novo código da cama: ");
                    int novoCodigoCama = scanner.nextInt();
                    if (!camas.ValidaCodigoCama(novoCodigoCama)){return;}

                    System.out.println("A cama é beliche? ");
                    boolean novoEhBeliche = scanner.nextBoolean();

                    System.out.println("Digite a nova posicao da cama: ");
                    String novaPosicao = scanner.nextLine();
                    if (!camas.ValidaPosicao(novaPosicao)){return;}

                    System.out.println("Digite a nova descrição da cama: ");
                    String novaDescricao = scanner.nextLine();
                    if (!camas.ValidaDescricao(novaDescricao)){return;}

                    camas.alterarCama(idAtualizar, novoCodigoCama, novoEhBeliche, novaPosicao, novaDescricao);
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
