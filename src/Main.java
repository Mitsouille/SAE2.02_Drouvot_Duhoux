import javax.print.DocPrintJob;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BellmanFord bf = new BellmanFord();
        Dijkstra dj = new Dijkstra();
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("E","D",43);

        System.out.println(graphe.toString());

        Valeur vals = bf.resoudre(graphe,"Z");
        System.out.println(vals.toString());

        Valeur vals2 = dj.resoudre(graphe,"Z");
        System.out.println(vals.toString());

        ArrayList<String> chemin = (ArrayList<String>) vals.calculerChemin("D");
        for(String n : chemin) {
            System.out.print(n);
        }
    }
}
