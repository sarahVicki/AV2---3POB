import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                System.out.println("Digite o ID da Reserva: ");
                int id = scanner.nextInt();
                if(!reservas.ValidaId(id)){return;}

                System.out.println("Digite o ID do quarto: ");
                int idQuarto = scanner.nextInt(); 
                if(!reservas.ValidaId(idQuarto)){return;}
                
                System.out.println("Digite o ID da Cama: ");
                int idCama = scanner.nextInt(); 
                if(!reservas.ValidaId(idCama)){return;}

                System.out.println("Digite o ID do cliente: ");
                int idCliente = scanner.nextInt(); 
                if(!reservas.ValidaId(idCliente)){return;}

                System.out.print("Digite a data de entrada (no formato DD/MM/AAAA): ");
                String dataEntrada = scanner.next();            
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(dataEntrada, formatter);
                if(!reservas.ValidaData(dataEntrada)){return;}
                
                System.out.print("Digite a data de saída (no formato DD/MM/AAAA): ");
                String dataSaida = scanner.next();            
                DateTimeFormatter aux2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(dataSaida, aux2);
                if(!reservas.ValidaData(dataSaida)){return;}
            
                reservas.incluirReserva(id, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
                break;
                        
              case 2:
                System.out.println("Digite o ID da reserva a ser atualizada: ");
                int idAtualizar = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o ID do quarto: ");
                int novoIdQuarto = scanner.nextInt(); 
                
                System.out.println("Digite o ID da Cama: ");
                int novoIdCama = scanner.nextInt(); 

                System.out.println("Digite o ID do cliente: ");
                int novoIdCliente = scanner.nextInt(); 

                System.out.println("Digite a data de entrada: ");
                String novaDataEntrada = scanner.nextLine(); 

                System.out.println("Digite a data de saída: ");
                String novaDataSaida = scanner.nextLine();

                reservas.alterarReserva(idAtualizar, novoIdQuarto, novoIdCama, novoIdCliente, novaDataEntrada, novaDataSaida);
                
              case 3:
                System.out.println("Digite o ID da reserva a ser removida: ");
                int idRemover = scanner.nextInt();

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
