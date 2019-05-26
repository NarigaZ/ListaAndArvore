import br.com.AVL.AvlTree;
import br.com.FileManager.FileManager;
import br.com.Lista.Lista;

public class Main {
    public static void main(String[] args) {
        Lista list = new Lista("Professores");
        FileManager.OpenArq("./src/Files/Professores.csv");
        String linha = "";
        AvlTree t = new AvlTree();
        t.insert("Zebra");
        t.insert("Sol");
        t.insert("Loja");
        t.insert("Baliza");
        t.insert("Alfa");
        t.displayTree();

        t.displayTree();
        while(linha!=null){
            linha = FileManager.Llinha();
            if (linha!=null){
                list.insereNoFim(linha);
            }
        }
        //list.print();

    }
}
