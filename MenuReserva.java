import java.util.Scanner;

public class MenuReserva {
    public void processamento() {

        CrudReserva reservas = new CrudReserva();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("===== CRUD de Reserva =====");
            System.out.println("1. Adicionar Reserva");
            System.out.println("2. Atualizar Reserva");
            System.out.println("3. Remover Reserva");
            System.out.println("4. Listar Reservas");
            System.out.println("5. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
      
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
              
              case 1:
                reservas.incluirReserva();
                break;
                        
              case 2:
                System.out.println("Digite o ID da reserva a ser atualizada: ");
                int idAtualizar = scanner.nextInt();
                scanner.nextLine();
                if(!reservas.ValidaId(idAtualizar)){return;}

                reservas.alterarReserva(idAtualizar);
                
              case 3:
                System.out.println("Digite o ID da reserva a ser removida: ");
                int idRemover = scanner.nextInt();
                if(!reservas.ValidaId(idRemover)){return;}

                reservas.excluirReserva(idRemover);
                break;

              case 4:
                reservas.listarReservas();
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
