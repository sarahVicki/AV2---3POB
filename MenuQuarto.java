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

                System.out.println("Digite o ID do quarto: ");
                int id = scanner.nextInt();
                if (!quartos.ValidaId(id)){return;}
        
                System.out.println("Digite o nome do quarto: ");
                String nomeQuarto = scanner.next(); 
                if (!quartos.ValidaNomeQuarto(nomeQuarto)){return;}
                
                System.out.println("Digite a quantidade de camas: ");
                int qtdeCamas = scanner.nextInt(); 
                if (!quartos.ValidaQtdCamas(qtdeCamas)){return;}
        
                System.out.println("Tem banheiro? ");
                boolean temBanheiro = scanner.nextBoolean(); 
        
                System.out.println("Digite a descricao: ");
                String descricao = scanner.nextLine(); 
                if (!quartos.ValidaDescricao(descricao)){return;}

                quartos.incluirQuarto(id, nomeQuarto, qtdeCamas, temBanheiro, descricao);
                break;
                        
            case 2:
                System.out.println("Digite o ID do quarto a ser atualizado: ");
                int idAtualizar = scanner.nextInt();
                scanner.nextLine();
                if (!quartos.ValidaId(idAtualizar)){return;}

                System.out.println("Digite o nome do quarto: ");
                String novoNomeQuarto = scanner.next(); 
                if (!quartos.ValidaNomeQuarto(novoNomeQuarto)){return;}
                
                System.out.println("Digite a quantidade de camas: ");
                int novaQtdeCamas = scanner.nextInt();
                if (!quartos.ValidaQtdCamas(novaQtdeCamas)){return;} 

                System.out.println("Tem banheiro? ");
                boolean novoTemBanheiro = scanner.nextBoolean(); 

                System.out.println("Digite a descricao: ");
                String novaDescricao = scanner.nextLine(); 
                if (!quartos.ValidaDescricao(novaDescricao)){return;}

                quartos.alterarQuarto(idAtualizar, novoNomeQuarto, novaQtdeCamas, novoTemBanheiro, novaDescricao);
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
