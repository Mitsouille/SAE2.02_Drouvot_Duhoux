import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArc {
    @Test
    public void test_ConstructeurArc() throws Exception{
        //Préparation des données
        Arc arc = new Arc("A", 5.5);
        //Vérification
        assertEquals("A", arc.getDest(), "La destination doit etre A");
        assertEquals(5.5, arc.getCout(), "Le cout doit etre de 5.5");
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
}
