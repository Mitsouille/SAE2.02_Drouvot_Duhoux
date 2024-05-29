import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestGraphe {
    @Test
    public void test_ConstructeurArc() throws Exception{
        //Préparation des données
        Arc arc = new Arc("A", 5.5);
        //Vérification
        assertEquals("A", arc.getDest(), "La destination doit etre A");
        assertEquals(5.5, arc.getCout(), "Le cout doit etre de 5.5");
    }

    @Test
    public void test_Arcs() throws Exception{
        //Préparation des données
        Arcs arcs = new Arcs();
        Arc arc = new Arc("A", 5.5);
        //Utilisation de la méthode ajouterArc
        arcs.ajouterArc(arc);

        //Vérification
        assertEquals("A", arcs.getArcs().get(0).getDest());
        assertEquals(5.5, arcs.getArcs().get(0).getCout());
        assertEquals(1, arcs.getArcs().size(), "La liste doit avoir une taille de 1");
    }

    @Test
    public void test_ArcCoutNegatif(){
        //Préparation des données
        boolean exception = false;
        try{
            Arc arc = new Arc("A",-5);
        }catch(Exception e){
            exception = true;
        }
        //Vérification
        assertEquals(true,exception,"Une erreur doit etre throw car un arc de cout négatif est impossible");
    }

    @Test
    public void test_GrapheListe_suivants_noeudInexistant() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals( null, graphe.suivants("B") );
    }

    @Test
    public void test_GrapheListe_suivants_noeudExistant() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals( "B", graphe.suivants("A").get(0) );
    }

    @Test
    public void test_GrapheAjoutNegatif(){
        //Préparation des données
        boolean exception = false;
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        try{
            graphe.ajouterArc("A","B",-5);
        }catch (Exception e){
            exception = true;
        }
        //Vérification
        assertEquals(true,exception,"Une erreur doit etre throw car l'arc a un cout négatif");
    }

    @Test
    public void test_GrapheListe_ajout() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals( "B", graphe.suivants("A").get(0).getDest() );
        assertEquals( 5.5, graphe.suivants("A").get(0).getCout() );
    }

    @Test
    public void test_BellmanFord_resoudre() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",2);
        graphe.ajouterArc("B","C",8);
        graphe.ajouterArc("A","D",1);
        graphe.ajouterArc("D","C",2);
        graphe.ajouterArc("C","E",3);
        //utilisation de resoudre
        Valeur v = BellmanFord.resoudre(graphe,"A");
        //Vérification
        assertEquals("D",v.getParent("C"));
        assertEquals(6,v.getValeur("E"));
    }
    @Test
    public void test_GrapheListe_SommetInexistant() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Vérification
        assertEquals(-1,graphe.getIndice("A"),"-1 doit etre retourner car ce sommet n'est pas présent");
    }

    @Test
    public void test_GrapheSommetNonPresent_BellmanFord(){
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        boolean exception = false;
        //Utilisation de la méthode
        try{
            Valeur v = BellmanFord.resoudre(graphe,"G");
        }catch (SommetInexistantException e){
            exception = true;
        }

        //Vérification
        assertEquals(true,exception,"Une exception doit etre retourner car le sommet n'est pas dans le graphe");
    }

    @Test
    public void test_GrapheSommetNonPresent_Dijkstra(){
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        boolean exception = false;
        //Utilisation de la méthode
        try{
            Valeur v = Dijkstra.resoudre(graphe,"G");
        }catch (SommetInexistantException e){
            exception = true;
        }

        //Vérification
        assertEquals(true,exception,"Une exception doit etre retourner car le sommet n'est pas dans le graphe");
    }

    /**
     * Grosse douille dijkstra fonctionne pas trop des barres
     * @throws Exception
     */

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


        //Utilisation de résoudre
        Valeur v = Dijkstra.resoudre(graphe,"A");
        System.out.println(v.getParent("B"));

        //Vérification des chemins


    }



}
