import java.io.File;
import java.util.ArrayList;

public class MainDijkstra {
    public static void main(String[] args) throws Exception{
        Dijkstra dj = new Dijkstra();
        BellmanFord bf = new BellmanFord();
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
        for(String n : chemin) {
            System.out.print(n);
        }


        //Calcul du chemin le plus court vers D
        ArrayList<String> chemin2 = (ArrayList<String>) v.calculerChemin("D");
        for(String n : chemin2){
            System.out.print(n);
        }



        //Test du chargement a partir de fichier du graphe
        String pathGraphe = "./data/graphe/";
        GrapheListe grapheCharger = new GrapheListe(pathGraphe+"Graphe5.txt");
        Valeur v5 = dj.resoudre(grapheCharger,"1");
        System.out.println(v5.getValeur("3"));

        //test lecture repertoire
        File repertoire = new File("./data");
        String[] liste = repertoire.list();
        System.out.println(liste.length);
        long date_debut = System.nanoTime();
        for(int i = 0; i < liste.length; i++){
            GrapheListe g = new GrapheListe(pathGraphe + liste[i]);
            Valeur val = dj.resoudre(g,"1");
        }
        long date_fin = System.nanoTime();
        long tempsFinal = date_fin - date_debut;
        System.out.println("Temps nécéssaire : " + tempsFinal);

        long date_debut2 = System.nanoTime();
        for(int i = 0; i < liste.length; i++){
            GrapheListe g = new GrapheListe(pathGraphe + liste[i]);
            Valeur val = bf.resoudre(g,"1");
        }
        long date_fin2 = System.nanoTime();
        long tempsFinal2 = date_fin2 - date_debut2;
        System.out.println("Temps nécéssaire : " + tempsFinal2);

        GrapheListe gg = new GrapheListe(pathGraphe+"Graphe905.txt");
        Valeur vDij = dj.resoudre(gg,"3");
        Valeur vBell = bf.resoudre(gg,"3");
        System.out.println(vDij.calculerChemin("545"));
        System.out.println(vBell.calculerChemin("545"));
    }
}
