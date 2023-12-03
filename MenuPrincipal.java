import java.util.Scanner;

public class MenuPrincipal {
    public void processamento() {

        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.println("===== Escolha o CRUD que deseja acessar: =====");
            System.out.println("1. CRUD Cliente");
            System.out.println("2. CRUD Quarto");
            System.out.println("3. CRUD Cama");
            System.out.println("4. CRUD Reserva");
            System.out.println("5. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    MenuCliente menuCliente = new MenuCliente();
                    menuCliente.processamento();
                    break;
                
                case 2:
                    MenuQuarto menuQuarto = new MenuQuarto();
                    menuQuarto.processamento();
                    break;
                
                case 3:
                    MenuCama menuCama = new MenuCama();
                    menuCama.processamento();
                    break;
                
                case 4:
                    MenuReserva menuReserva = new MenuReserva();
                    menuReserva.processamento();
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