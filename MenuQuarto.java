import java.util.Scanner;

public class MenuQuarto {
   
    public void processamento() {

        CrudQuarto quartos = new CrudQuarto();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("===== CRUD de Quarto =====");
            System.out.println("1. Adicionar Quarto");
            System.out.println("2. Atualizar Quarto");
            System.out.println("3. Remover Quarto");
            System.out.println("4. Listar Quartos");
            System.out.println("5. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
      
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
              
            case 1:

                quartos.incluirQuarto();
                break;
                        
            case 2:
                System.out.println("Digite o ID do quarto a ser atualizado: ");
                int idAtualizar = scanner.nextInt();
                if (!quartos.ValidaId(idAtualizar)){return;}

                quartos.alterarQuarto(idAtualizar);
                break;
                
            case 3:
                System.out.println("Digite o ID do quarto a ser removido: ");
                int idRemover = scanner.nextInt();
                 if (!quartos.ValidaId(idRemover)){return;}

                quartos.excluirQuarto(idRemover);
                break;
                
            case 4:
                quartos.listarQuartos();
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

