import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlgo {
    @Test
    public void test_BellmanFord_resoudre() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("E","D",43);

        //utilisation de resoudre
        Valeur v = BellmanFord.resoudre(graphe,"A");
        //Vérification
        assertEquals(0,v.getValeur("A"),"Le cout de A doit etre de 0");
        assertEquals(12,v.getValeur("B"),"Le cout de B doit etre de 12");
        assertEquals(76,v.getValeur("C"),"Le cout de C doit etre de 76");
        assertEquals(66,v.getValeur("D"),"Le cout de D doit etre de 66");
        assertEquals(23,v.getValeur("E"),"Le cout de E doit etre de 23");

        assertEquals(null,v.getParent("A"),"Le parent de A doit etre null");
        assertEquals("A",v.getParent("B"),"Le parent de B doit etre A");
        assertEquals("B",v.getParent("E"),"Le parent de E doit etre B");
        assertEquals("E",v.getParent("D"),"Le parent de D doit etre E");
        assertEquals("D",v.getParent("C"),"Le parent de C doit etre D");
    }

    @Test
    public void test_CalculerCheminBellman() throws Exception{
        //Préparation des données
        String[] cheminVerif = {"1","2","3"};
        GrapheListe g = new GrapheListe("./data/graphe_test/Graphe_TestNormal.txt");
        Valeur v = BellmanFord.resoudre(g,"1");

        //Utilisation des méthodes
        ArrayList<String> chemin = (ArrayList<String>) v.calculerChemin("3");
        //Vérification
        for(int i = 0; i < chemin.size(); i++){
            assertEquals(cheminVerif[i],chemin.get(i),"Le chemin doit comporter " + cheminVerif[i] + " à la " + i + "position");
        }
    }
    @Test
    public void test_GrapheSommetVide_BellmanFord(){
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        Valeur v = BellmanFord.resoudre(graphe,"G");
        double valeurV = v.getValeur("G");
        //Vérification
        assertEquals(0.0,valeurV,"La valeur du chemin doit être de 0");
    }

    @Test
    public void test_GrapheResoudre_Dijkstra() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("E","D",43);


        //Utilisation de résoudre
        Valeur v = Dijkstra.resoudre(graphe,"A");
        //Vérification des chemins
        assertEquals(0,v.getValeur("A"),"Le cout de A doit etre de 0");
        assertEquals(12,v.getValeur("B"),"Le cout de B doit etre de 12");
        assertEquals(76,v.getValeur("C"),"Le cout de C doit etre de 76");
        assertEquals(66,v.getValeur("D"),"Le cout de D doit etre de 66");
        assertEquals(23,v.getValeur("E"),"Le cout de E doit etre de 23");

        assertEquals(null,v.getParent("A"),"Le parent de A doit etre null");
        assertEquals("A",v.getParent("B"),"Le parent de B doit etre A");
        assertEquals("B",v.getParent("E"),"Le parent de E doit etre B");
        assertEquals("E",v.getParent("D"),"Le parent de D doit etre E");
        assertEquals("D",v.getParent("C"),"Le parent de C doit etre D");
    }

    @Test
    public void test_CalculerCheminDjikstra() throws Exception{
        //Préparation des données
        GrapheListe g = new GrapheListe("./data/graphe_test/Graphe_TestNormal.txt");
        Valeur v = Dijkstra.resoudre(g,"1");
        ArrayList<String> chemin = (ArrayList<String>) v.calculerChemin("3");
        String[] cheminVerif = {"1","2","3"};
        for(int i = 0; i < chemin.size(); i++){
            assertEquals(cheminVerif[i],chemin.get(i),"Le chemin doit comporter " + cheminVerif[i] + " à la " + i + "position");
        }
    }
    @Test
    public void test_GrapheVide_Dijkstra(){
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        Valeur v = Dijkstra.resoudre(graphe,"G");
        double valeurG = v.getValeur("G");

        //Vérification
        assertEquals(0.0,valeurG,"La valeur du chemin doit être de 0");
    }

    @Test
    public void test_Djikstra_finGraphe() throws Exception{
        //Préparation des données
        GrapheListe g = new GrapheListe("./data/graphe_test/Graphe_testFin.txt");
        //Utilisation de la méthode
        Valeur v = Dijkstra.resoudre(g,"4");
        //Vérification
        assertEquals(0.0,v.getValeur("4"),"Le chemin doit valoir 0");
        assertEquals(Double.MAX_VALUE,v.getValeur("1"),"Le chemin doit valoir +infini");
        assertEquals(Double.MAX_VALUE,v.getValeur("2"),"Le chemin doit valoir +infini");
        assertEquals(Double.MAX_VALUE,v.getValeur("3"),"Le chemin doit valoir +infini");


    }




}
