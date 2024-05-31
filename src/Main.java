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

        System.out.println("Graphe : " + graphe.toString());

        Valeur vals = bf.resoudre(graphe,"A");
        System.out.println("Valeurs du graphe avec BellmanFord : " + vals.toString());

        Valeur vals2 = dj.resoudre(graphe,"A");
        System.out.println("Valeurs du graphe avec Dijkstra : " + vals2.toString());

        ArrayList<String> chemin = (ArrayList<String>) vals.calculerChemin("D");
        System.out.println("Chemin le plus court vers D ");
        for(String n : chemin) {
            System.out.print(n);
        }
    }
}
