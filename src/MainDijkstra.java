import java.io.File;
import java.util.ArrayList;

public class MainDijkstra {
    public static void main(String[] args) throws Exception{
        Dijkstra dj = new Dijkstra();
        //Test simple de fonctionnement
        //Création du graphe
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("E","D",43);

        //Test résolution du graphe en partant de A
        Valeur v = dj.resoudre(graphe, "A");
        //Calcul du chemin le plus court vers C
        ArrayList<String> chemin = (ArrayList<String>) v.calculerChemin("C");
        System.out.println("Chemin le plus court vers C : ");
        for(String n : chemin) {
            System.out.print(n);
        }


        //Calcul du chemin le plus court vers D
        ArrayList<String> chemin2 = (ArrayList<String>) v.calculerChemin("D");
        System.out.println("Chemin le plus court vers D : ");
        for(String n : chemin2){
            System.out.print(n);
        }

    }
}
