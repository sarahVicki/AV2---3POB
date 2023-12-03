import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrudQuarto {
    
    ArrayList<Quarto> quartos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 2. Criar as funcionalidades de Incluir Quarto, alterar Quarto, Excluir Quarto e listar Quarto.

    public void incluirQuarto () {

        System.out.println("Digite o ID do quarto: ");
        int id = scanner.nextInt();
        if (!ValidaId(id)){return;}
        
        System.out.println("Digite o nome do quarto: ");
        String nomeQuarto = scanner.next(); 
        if (!ValidaNomeQuarto(nomeQuarto)){return;}
                
        System.out.println("Digite a quantidade de camas: ");
        int qtdeCamas = scanner.nextInt(); 
        if (!ValidaQtdCamas(qtdeCamas)){return;}
        
        System.out.println("Tem banheiro? ");
        boolean temBanheiro = scanner.nextBoolean(); 
        
        System.out.println("Digite a descricao: ");
        String descricao = scanner.nextLine(); 
        if (!ValidaDescricao(descricao)){return;}

        Quarto i = new Quarto(id, nomeQuarto, qtdeCamas, temBanheiro, descricao);
        quartos.add(i);

    } 

    public void alterarQuarto (int id) {

        System.out.println("Digite o nome do quarto: ");
        String nomeQuarto = scanner.next(); 
        if (!ValidaNomeQuarto(nomeQuarto)){return;}
                
        System.out.println("Digite a quantidade de camas: ");
        int qtdeCamas = scanner.nextInt();
        if (!ValidaQtdCamas(qtdeCamas)){return;} 

        System.out.println("Tem banheiro? ");
        boolean temBanheiro = scanner.nextBoolean(); 

        System.out.println("Digite a descricao: ");
        String descricao = scanner.nextLine(); 
        if (!ValidaDescricao(descricao)){return;}

        for (Quarto i: quartos){
            if (i.getId() == id) {
                Quarto quarto2 = new Quarto(id, nomeQuarto, qtdeCamas, temBanheiro, descricao);
                quartos.set(quartos.indexOf(i), (quarto2));
                System.out.println("Quarto atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Quarto não encontrado.");

    } 

    public void excluirQuarto (int id) {

        for (int i = 0; i < quartos.size(); i++){
            if (quartos.get(i).getId() == id){
                quartos.remove(i);
                System.out.println("Quarto removido com sucesso.");
                return;
            }
        }
        System.out.println("Quarto não encontrado.");

    } 

    public void listarQuartos () {

        System.out.println("Quartos:");
        for (Quarto i: quartos) {
            System.out.println();
            System.out.println("ID: " + i.getId());
            System.out.println("Nome do quarto: " + i.getNomeQuarto());
            System.out.println("Quantidade de camas: " + i.getQtdeCamas());
            System.out.println("Tem banheiro? " + i.getTemBanheiro());
            System.out.println("Descricao: " + i.getDescricao());
            System.out.println();
        }

    }

    // validar dados

    public Boolean ValidaId (int id){
        
        if (id > 0) {
            return true;
        } 
            
        else {
            System.out.println("Digite um id válido");
            return false;
        }
    }

    public Boolean ValidaNomeQuarto (String nomeQuarto){
        
        String regex = "^[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nomeQuarto);
        return matcher.matches();
    }
    
    public Boolean ValidaQtdCamas (int qtdeCamas){
        
        if (qtdeCamas > 0) {
            return true;
        } 
            
        else {
            System.out.println("Digite uma quantidade válida");
            return false;
        }
    }
    
    public Boolean ValidaDescricao (String descricao){
        
        if (descricao == ""){
            return false;
        }
        else {
            System.out.println("Digite uma descrição válida");
            return true;
        }
    }

}
