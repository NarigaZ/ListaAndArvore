import br.com.FileManager.FileManager;
import br.com.Lista.Lista;

public class Main {
    public static void main(String[] args) {
        Lista list = new Lista("Professores");
        FileManager.OpenArq("./src/Files/Professores.csv");
        String linha = "";
        while(linha!=null){
            linha = FileManager.Llinha();
            if (linha!=null){
                list.insereNoFim(linha);
            }
        }
        list.print();
    }
}
