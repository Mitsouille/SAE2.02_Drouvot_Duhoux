import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestGraphe {

    /**
     * Test ajout d'un arc a un graphe
     * @throws Exception
     */
    @Test
    public void test_GrapheListe_ajout() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals("B", graphe.suivants("A").get(0).getDest());
        assertEquals(5.5, graphe.suivants("A").get(0).getCout());
    }

    /**
     * Test ajout d'un arc négatif au graphe
     */
    @Test
    public void test_GrapheAjoutArcNegatif(){
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

    /**
     * Test un suivants sur un noeud qui n'est pas dans le graphe G
     * @throws Exception
     */
    @Test
    public void test_GrapheListe_suivants_noeudInexistant() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        ArrayList<Arc> listeVide = new ArrayList<Arc>();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals( listeVide, graphe.suivants("B"),"Une liste vide doit être renvoyé");
    }

    /**
     * Test suivant sur un noeud dans le graphe
      * @throws Exception
     */
    @Test
    public void test_GrapheListe_suivants_noeudExistant() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Utilisation de la méthode
        graphe.ajouterArc("A","B",5.5);
        //Vérification
        assertEquals( "B", graphe.suivants("A").get(0).getDest(),"La destination doit être B");
    }

    /**
     * Test graphe obtenir l'indice d'un sommet pas présent dans le graphe
     * @throws Exception
     */
    @Test
    public void test_GrapheListe_SommetInexistant() {
        //Préparation des données
        GrapheListe graphe = new GrapheListe();
        //Vérification
        assertEquals(-1,graphe.getIndice("A"),"-1 doit etre retourner car ce sommet n'est pas présent");
    }

    /**
     * Test chargement d'un graphe OK
     */
    @Test
    public void test_ChargerGrapheFichierOK() throws Exception{
        //Préparation des données
        String[] listeSommetReponse = {"1","2","3"};
        Arc a1 = new Arc("2",18);
        Arc a2 = new Arc("1",12);
        Arc a3 = new Arc("3",13);
        Arc a4 = new Arc("2",20);
        //Test
        GrapheListe g = new GrapheListe("./data/graphe_test/Graphe_TestNormal.txt");
        ArrayList<String> listeSommet = (ArrayList<String>) g.listeNoeuds();
        ArrayList<Arc> listeArc = (ArrayList<Arc>) g.suivants("1");
        ArrayList<Arc> listeArc2 = (ArrayList<Arc>) g.suivants("2");
        ArrayList<Arc> listeArc3 = (ArrayList<Arc>) g.suivants("3");
        
        for(int i = 0; i < listeSommet.size(); i++){
            assertEquals(listeSommetReponse[i], listeSommet.get(i),"Le sommet numéro : " + i + "doit être " + listeSommetReponse[i]);
        }


        //Vérification
        assertEquals(a1.getCout(),listeArc.get(0).getCout(),"L'arc doit etre présent dans le graphe");
        assertEquals(a1.getDest(),listeArc.get(0).getDest(),"L'arc doit etre présent dans le graphe");
        assertEquals(a2.getCout(),listeArc2.get(0).getCout(),"L'arc doit etre présent dans le graphe");
        assertEquals(a2.getDest(),listeArc2.get(0).getDest(),"L'arc doit etre présent dans le graphe");
        assertEquals(a3.getCout(),listeArc2.get(1).getCout(),"L'arc doit etre présent dans le graphe");
        assertEquals(a3.getDest(),listeArc2.get(1).getDest(),"L'arc doit etre présent dans le graphe");
        assertEquals(a4.getCout(),listeArc3.get(0).getCout(),"L'arc doit etre présent dans le graphe");
        assertEquals(a4.getDest(),listeArc3.get(0).getDest(),"L'arc doit etre présent dans le graphe");




    }

    /**
     * Test le chargement du graphe avec un fichier inexistant
     * @throws Exception
     */
    @Test
    public void test_FichierInexistant() throws Exception{
        //Préparation des données
        boolean exception = false;
        //Utilisation de la méthode testée
        try{
            GrapheListe graphe = new GrapheListe("poulet");
        }catch (FileNotFoundException e){
            exception = true;
        }
        //Vérification
        assertEquals(true, exception,"Une exception doit etre throw si le fichier n'existe pas");
    }

    /**
     * Test un le chargement d'un graphe avec un fichier a valeur négative
     * @throws Exception
     */

    @Test
    public void test_FichierNeg() throws Exception{
        //Préparation des données
        boolean exception = false;
        //Utilisation de la méthode testée
        try{
            GrapheListe graphe = new GrapheListe("./data/graphe_test/Graphe_TestNeg.txt");
            graphe.toString();
        }catch (Exception e){
            exception = true;
        }
        assertEquals(true,exception,"Une erreur doit etre throw car il y a une valeur négative");
    }

    /**
     * Test chargement d'un graphe avec une valeur manquante
     */

    @Test
    public void test_FichierValManquante() {
        //Préparation des données
        boolean exception = false;
        //Utilisation de la méthode testée
        try{
            GrapheListe graphe = new GrapheListe("./data/graphe_test/Graphe_TestValManquante.txt");
        }catch (Exception e){
            exception = true;
        }
        assertEquals(true,exception,"Une erreur doit être throw car il manque une val dans le fichier");
    }

    /**
     * Test chargement d'un graphe avec une lettre a la place d'une valeur de l'arc
     */

    @Test
    public void test_FichierLettreDouble(){
        //Préparation des données
        boolean exception = false;
        //Utilisation de la méthode testée
        try{
            GrapheListe graphe = new GrapheListe("./data/graphe_test/Graphe_TestLettreDouble.txt");
        }catch (Exception e){
            exception = true;
        }
        assertEquals(true,exception,"Une erreur doit être throw car une lettre est a la place d'un chiffre");
    }

    /**
     * Test Graphe d'un sommet suivant qui n'est pas présent dans le graphe
     * @throws Exception
     */
    @Test
    public void test_SuivantNonPresent() throws Exception{
        //Préparation des données
        GrapheListe graphe = new GrapheListe("./data/graphe_test/Graphe_TestNormal.txt");
        //Utilisation des méthodes
        ArrayList<Arc> suivant = (ArrayList<Arc>) graphe.suivants("Z");
        //Vérification
        assertEquals(null,suivant,"Le sommet n'est pas présent cela doit renvoyer null");
    }
}
