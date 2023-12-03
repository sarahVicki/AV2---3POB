import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrudReserva {

    ArrayList<Reserva> reservas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 4. Criar as funcionalidades de Incluir Reserva, alterar Reserva, Excluir Reserva e listar Reserva.

    public void incluirReserva () {

        System.out.println("Digite o ID da Reserva: ");
        int id = scanner.nextInt();
        if(!ValidaId(id)){return;}

        System.out.println("Digite o ID do quarto: ");
        int idQuarto = scanner.nextInt(); 
        if(!ValidaId(idQuarto)){return;}
                
        System.out.println("Digite o ID da Cama: ");
        int idCama = scanner.nextInt(); 
        if(!ValidaId(idCama)){return;}

        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt(); 
        if(!ValidaId(idCliente)){return;}

        System.out.print("Digite a data de entrada (no formato DD/MM/AAAA): ");
        String dataEntrada = scanner.next();            
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate.parse(dataEntrada, formatter);
        if(!ValidaData(dataEntrada)){return;}
                
        System.out.print("Digite a data de saída (no formato DD/MM/AAAA): ");
        String dataSaida = scanner.next();            
        DateTimeFormatter aux2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate.parse(dataSaida, aux2);
        if(!ValidaData(dataSaida)){return;}      
        
        Reserva i = new Reserva(id, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
        reservas.add(i);

    } 

    public void alterarReserva (int id) {

        System.out.println("Digite o ID do quarto: ");
        int idQuarto = scanner.nextInt(); 
        if(!ValidaId(idQuarto)){return;}

        System.out.println("Digite o ID da Cama: ");
        int idCama = scanner.nextInt(); 
        if(!ValidaId(idCama)){return;}

        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt(); 
        if(!ValidaId(idCliente)){return;}

        System.out.println("Digite a data de entrada: ");
        String dataEntrada = scanner.nextLine(); 
        if(!ValidaData(dataEntrada)){return;}

        System.out.println("Digite a data de saída: ");
        String dataSaida = scanner.nextLine();
        if(!ValidaData(dataSaida)){return;}

        for (Reserva i: reservas){
            if (i.getId() == id) {
                Reserva reserva2 = new Reserva(id, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
                reservas.set(reservas.indexOf(i), (reserva2));
                System.out.println("Reserva atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");

    } 

    public void excluirReserva (int id) {

        for (int i = 0; i < reservas.size(); i++){
            if (reservas.get(i).getId() == id){
                reservas.remove(i);
                System.out.println("Reserva removida com sucesso.");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");

    } 

    public void listarReservas () {

        System.out.println("Reservas:");
        for (Reserva i: reservas) {
            System.out.println();
            System.out.println("ID: " + i.getId());
            System.out.println("ID do quarto: " + i.getIdQuarto());
            System.out.println("ID da cama: " + i.getIdCama());
            System.out.println("Data de entrada: " + i.getDataEntrada());
            System.out.println("Data de saída: " + i.getDataSaida());
            System.out.println();
        }

    }

    // validar dados
    public Boolean ValidaId (int id){
            
        if(id > 0) {
            return true;
        } 
            
        else {
            System.out.println("Digite um id válido");
            return false;
        }
        
    }

    public Boolean ValidaData (String data){

        Pattern pattern = Pattern.compile("^[0-3][0-9]/[0-1][0-2]/[1-2][0-9]{3}$");
        Matcher matcher = pattern.matcher(data);
        boolean matchFound = matcher.find();
        return matchFound;
    }
}
