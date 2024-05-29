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
        assertEquals(true,exception,"Une erreur doit etre throw car un arc de cout négatif est impossible");
    }

    @Test
    public void test_GrapheListe_ajout(){
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals("B",graphe.suivants("B").get(graphe.getIndice("B")).getDest());
        assertEquals(5.5,graphe.suivants("B").get(graphe.getIndice("B")).getCout());
    }

}
