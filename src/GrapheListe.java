import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    /**
     * liste de tous les noeuds du graphe
     */
    private ArrayList<String> noeuds;

    /**
     * liste de tous les arcs du graphe
     */
    private ArrayList<Arcs> adjacence;

    /**
     * Constructeur vide d'un GrapheListe
     */

    public GrapheListe() {
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

    /**
     * Permet de charger un graphe a partir d'un fichier
     * séparer par des tabulations
     *
     * @param nomfichier nom du fichier
     */

    public GrapheListe(String nomfichier) throws Exception {
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
        //Vérification existence fichier
        BufferedReader br = new BufferedReader(new FileReader(nomfichier));
        //Tant que non fin fichier
        try {
            while (true) {
                //On lit chaque ligne, on la sépare par tabulation
                String ligne = br.readLine();
                if (ligne == null)
                    throw new EOFException("Fin de fichier");
                String[] separation = ligne.split("\t");
                if(separation.length != 3)
                    throw new ErreurFichierException("Valeur manquante dans le fichier");
                //On tente de l'ajouter au graphe
                this.ajouterArc(separation[0], separation[1], Double.parseDouble(separation[2]));
            }
        } catch (EOFException e) {
            //On ferme le bufferedReader en fin de fichier
            br.close();
        }
    }

    /**
     * @param n est le noeud dont on recherche l'indice
     * @return l'indice du noeud n
     */
    public int getIndice(String n) {
        return noeuds.indexOf(n);
    }

    /**
     * ajoute un Arc à la liste d'arcs du graphe
     *
     * @param depart      est le nom du noeud de depart de l'arc
     * @param destination est le nom du noeud de destination de l'arc
     * @param cout        est le cout de l'arc entre les noeuds depart et destination
     */
    public void ajouterArc(String depart, String destination, double cout) throws Exception {
        // verifie que les noeuds depart et destination existent et les creent si ils n'existent pas
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }

        // ajoute l'arc au noeud depart avec destination pour noeud de destination de l'arc
        adjacence.get(noeuds.indexOf(depart)).ajouterArc(new Arc(destination, cout));
    }

    /**
     * Retourne tout les noeuds du graphe sous une forme de liste de String
     *
     * @return tout les noeuds du graphes
     */
    public List<String> listeNoeuds() {
        return noeuds;
    }

    /**
     * methode qui retourne la liste des arcs partant du noeud n
     *
     * @param n noeud passé en paramètre
     * @return la liste des arcs du noeud n
     */
    public List<Arc> suivants(String n) {
        List<Arc> l;
        if (!noeuds.contains(n)) {
            l = null;
        } else {
            l = adjacence.get(noeuds.indexOf(n)).getArcs();
        }
        return l;
    }

    /**
     * methode toString de GrapheListe
     *
     * @return une chaine affichant le nom de chaque noeud suivi des ses successeurs et leurs couts
     */
    public String toString() {
        String res = "";
        for (String n : noeuds) {
            res += n + " -> ";
            for (Arc a : suivants(n)) {
                res += a.getDest() + "(" + a.getCout() + ")" + " ";
            }
            res += "\n";
        }
        return res;
    }
}