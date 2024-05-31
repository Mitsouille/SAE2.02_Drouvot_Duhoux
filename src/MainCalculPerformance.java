import java.io.File;

public class MainCalculPerformance {
    public static void main(String[] args) throws Exception {
        //Initialisation des algos
        Dijkstra dj = new Dijkstra();
        BellmanFord bf = new BellmanFord();
        //Path pour les graphes
        String pathGraphe = "./data/graphe/";
        //Lecture repertoire
        File repertoire = new File(pathGraphe);
        //Liste des noms dans le repertoire
        String[] liste = repertoire.list();
        System.out.println("Nombre de graphes présent dans le dossier : " + liste.length);
        //Début du chrono
        long date_debut = System.nanoTime();
        for (int i = 0; i < liste.length; i++) {
            GrapheListe g = new GrapheListe(pathGraphe + liste[i]);
            Valeur val = dj.resoudre(g, "1");
        }

        //Fin du chrono
        long date_fin = System.nanoTime();
        //Calcul de la différence
        long tempsFinal = date_fin - date_debut;
        System.out.println("Temps nécéssaire pour 2 répétitions pour résoudre tout les graphes \n avec algo de Dijkstra : " + tempsFinal + " en nanosecondes");
        System.out.println("Ce qui représente : " + tempsFinal * 1E-9 + " secondes");
        //Début du chrono
        long date_debut2 = System.nanoTime();
        for (int i = 0; i < liste.length; i++) {
            GrapheListe g = new GrapheListe(pathGraphe + liste[i]);
            Valeur val = bf.resoudre(g, "1");
        }

        //Fin du chrono
        long date_fin2 = System.nanoTime();
        //Calcul de la différence
        long tempsFinal2 = date_fin2 - date_debut2;
        System.out.println("Temps nécéssaire pour 2 répétitions pour résoudre tout les graphes \n avec algo de BellmanFord : " + tempsFinal2 + " en nanosecondes");
        System.out.println("Ce qui représente : " + tempsFinal2 * 1E-9 + " secondes");


    }

}
