import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArcs {
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
}
