import java.util.ArrayList;
import java.util.Scanner;

public class CrudCama {
    
    ArrayList<Cama> camas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 3. Criar as funcionalidades de Incluir Cama, alterar Cama, Excluir Cama e listar Cama.

    public void incluirCama () {
        System.out.println("Digite o ID da cama: ");
        int id = scanner.nextInt();
        if (!ValidaId(id)){return;}
        
        System.out.println("Digite o código da cama: ");
        int codigoCama = scanner.nextInt();
        if (!ValidaCodigoCama(codigoCama)){return;}

        System.out.println("A cama é beliche? ");
        boolean ehBeliche = scanner.nextBoolean();

        System.out.println("Digite a posicao da cama: ");
        String posicao = scanner.nextLine();
        if (!ValidaPosicao(posicao)){return;}

        System.out.println("Digite a descrição da cama: ");
        String descricao = scanner.nextLine();
        if (!ValidaDescricao(descricao)){return;}

        Cama i = new Cama(id, codigoCama, ehBeliche, posicao, descricao);
        camas.add(i);

    } 

    public void alterarCama (int id) {

        System.out.println("Digite o novo código da cama: ");
        int codigoCama = scanner.nextInt();
        if (!ValidaCodigoCama(codigoCama)){return;}

        System.out.println("A cama é beliche? ");
        boolean ehBeliche = scanner.nextBoolean();

        System.out.println("Digite a nova posicao da cama: ");
        String posicao = scanner.nextLine();
        if (!ValidaPosicao(posicao)){return;}

        System.out.println("Digite a nova descrição da cama: ");
        String descricao = scanner.nextLine();
        if (!ValidaDescricao(descricao)){return;}

        for (Cama i: camas){
            if (i.getId() == id) {
                Cama cama2 = new Cama(id, codigoCama, ehBeliche, posicao, descricao);
                camas.set(camas.indexOf(i), (cama2));
                System.out.println("Cama atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Cama não encontrada.");

    } 

    public void excluirCama (int id) {

        for (int i = 0; i < camas.size(); i++){
            if (camas.get(i).getId() == id){
                camas.remove(i);
                System.out.println("Cama removida com sucesso.");
                return;
            }
        }
        System.out.println("Cama não encontrada.");

    } 

    public void listarCamas () {

        System.out.println("Camas:");
        for (Cama i: camas) {
            System.out.println();
            System.out.println("ID: " + i.getId());
            System.out.println("Código da cama: " + i.getCodigoCama());
            System.out.println("Eh beliche: " + i.getEhBeliche());
            System.out.println("Posicao: " + i.getPosicao());
            System.out.println("Descricao: " + i.getDescricao());
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

    public Boolean ValidaCodigoCama (int codigoCama){
         
        if(codigoCama > 0) {
            return true;
        } 
            
        else {
            System.out.println("Digite um código válido");
            return false;
        }
    }

    public Boolean ValidaPosicao (String posicao) {
        
        if (posicao == ""){
            return false;
        }
        else {
            System.out.println("Digite uma posição válida");
            return true;
        }
    }

    public Boolean ValidaDescricao (String descricao) {
        
        if (descricao == ""){
            return false;
        }
        else {
            System.out.println("Digite uma descrição válida");
            return true;
        }
    }

}
