import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrudCliente {

    ArrayList<Cliente> cliente = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
   
    // 1. Criar as funcionalidades de Incluir Cliente, alterar Cliente, Excluir Cliente e listar Cliente.
    
    public void incluirCliente () {
        
        System.out.println("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        if(!ValidaId(id)){return;}

        System.out.println("Digite o código postal do cliente: ");
        int postalCode = scanner.nextInt();
        String aux = Integer.toString(postalCode);
        if(!ValidaPostalCode(aux)){return;}

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.next();
        if(!ValidaPalavra(nome)){return;}
                   
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.next();
        if(!ValidaPalavra(endereco)){return;}

        System.out.println("Digite o país do cliente: ");
        String pais = scanner.next();
        if(!ValidaPalavra(pais)){return;}

        System.out.println("Digite o CPF do cliente: ");
        int cpf = scanner.nextInt();
        String aux2 = Integer.toString(cpf);
        if(!ValidaCpf(aux2)){return;}

        System.out.println("Digite o passaporte do cliente: ");
        String passaporte = scanner.next();
        if(!ValidaPassaporte(passaporte)){return;}

        System.out.println("Digite o e-mail do cliente: ");
        String email = scanner.nextLine();
        if(!ValidaEmail(email)){return;}

        System.out.print("Digite a data (no formato DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();            
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate.parse(dataNascimento, formatter);
        if(!ValidaData(dataNascimento)){return;}

        Cliente i = new Cliente(id, nome, endereco, postalCode, pais, cpf, passaporte, email, dataNascimento);
        cliente.add(i);

    }

    public void alterarCliente (int id){
        
        System.out.println("Digite o novo nome do cliente: ");
        String nome = scanner.nextLine();
        if(!ValidaPalavra(nome)){return;}
        
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        if(!ValidaPalavra(endereco)){return;}
        
        System.out.println("Digite o código postal do cliente: ");
        int postalCode = scanner.nextInt();
        String aux = Integer.toString(postalCode);
        if(!ValidaPostalCode(aux)){return;}
        
        System.out.println("Digite o país do cliente: ");
        String pais = scanner.nextLine();
        if(!ValidaPalavra(pais)){return;}
        
        System.out.println("Digite o CPF do cliente: ");
        int cpf = scanner.nextInt();
        String aux2 = Integer.toString(cpf);
        if(!ValidaCpf(aux2)){return;}
        
        System.out.println("Digite o passaporte do cliente: ");
        String passaporte = scanner.nextLine();
        if(!ValidaPassaporte(passaporte)){return;}

        System.out.println("Digite o e-mail do cliente: ");
        String email = scanner.nextLine();
        if(!ValidaEmail(email)){return;}
      
        System.out.print("Digite a data (no formato DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate novaData = LocalDate.parse(dataNascimento, formatter2);
        System.out.println("Data inserida: " + novaData);
        if(!ValidaData(dataNascimento)){return;}

        for (Cliente i: cliente){
            if (i.getId() == id) {
                Cliente cliente2 = new Cliente(id, nome, endereco, postalCode, pais, cpf, passaporte, email, dataNascimento);
                cliente.set(cliente.indexOf(i), (cliente2));
                System.out.println("Cliente atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");

    }
    
    public void excluirCliente (int id){

        for (int i = 0; i < cliente.size(); i++){
            if (cliente.get(i).getId() == id){
                cliente.remove(i);
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");

    }
    
    public void listarClientes (){

        System.out.println("Clientes:");
        for (Cliente i: cliente) {
            System.out.println();
            System.out.println("ID: " + i.getId());
            System.out.println("Nome: " + i.getNome());
            System.out.println("Endereço: " + i.getEndereco());
            System.out.println("Código Postal: " + i.getPostalCode());
            System.out.println("País: " + i.getPais());
            System.out.println("CPF: " + i.getCpf());
            System.out.println("Passaporte: " + i.getPassaporte());
            System.out.println("E-mail: " + i.getEmail());
            System.out.println("Data de Nascimento: " + i.getDataNascimento());
            System.out.println();
        }

    }

    // Validar dados

    public Boolean ValidaId (int IdAux){
            
        if (IdAux > 0) {
            return true;
        } 
            
        else {
            System.out.println("Digite um ID válido");
            return false;
        }
        
    }

    public Boolean ValidaPostalCode (String postal){

        String regex = "^[0-9]{5}(?:-[0-9]{3})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(postal);
        boolean matchFound = matcher.find();
        return matchFound;

    }

    public Boolean ValidaPalavra (String palavra){

        String regex = "^[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palavra);
        return matcher.matches();

    }

    public Boolean ValidaCpf (String cpf){

        String regex = "^[0-9]{9}(?:-[0-9]{2})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cpf);
        boolean matchFound = matcher.find();
        return matchFound;
    
    }

    public Boolean ValidaPassaporte (String pass){
        
        String regex = "^[A-Z]+[0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);
        boolean matchFound = matcher.find();
        return matchFound;

    }

    public boolean ValidaEmail(String email) {
     
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Boolean ValidaData (String data){

        Pattern pattern = Pattern.compile("^[0-3][0-9]/[0-1][0-2]/[1-2][0-9]{3}$");
        Matcher matcher = pattern.matcher(data);
        boolean matchFound = matcher.find();
        return matchFound;
    }

}
