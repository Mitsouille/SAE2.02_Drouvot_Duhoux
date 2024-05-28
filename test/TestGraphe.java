import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestGraphe {
        @Test
        public void test_ConstructeurArc(){
            //Préparation des données
            Arc arc = new Arc("A",5.5);
            //Vérification
            assertEquals("A",arc.getDest(),"La destination doit etre A");
            assertEquals(5.5,arc.getCout(),"Le cout doit etre de 5.5");
        }
        @Test
        public void test_Arcs(){
            //Préparation des données
            Arcs arcs = new Arcs();
            Arc arc = new Arc("A",5.5);
            arcs.ajouterArc(arc);

            assertEquals("A",arcs.getArcs().get(0).getDest());
            assertEquals(5.5,arcs.getArcs().get(0).getCout());
        }

}
