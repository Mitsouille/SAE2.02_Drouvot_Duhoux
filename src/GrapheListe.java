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

    public GrapheListe() {
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
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
     * @param depart est le nom du noeud de depart de l'arc
     * @param destination est le nom du noeud de destination de l'arc
     * @param cout est le cout de l'arc entre les noeuds depart et destination
     */
    public void ajouterArc(String depart, String destination, double cout) {
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
     * @return tout les noeuds du graphes
     */
    public List<String> listeNoeuds() {
        return noeuds;
    }

    /**
     * methode qui retourne la liste des arcs partant du noeud n
     * @param n noeud passé en paramètre
     * @return la liste des arcs du noeud n
     */
    public List<Arc> suivants(String n) {
        return adjacence.get(adjacence.indexOf(n)).getArcs();
    }


    public String toString() {
        String res = "";
        for(String n : noeuds) {
            res += n + " -> ";
            for(Arc a : suivants(n)) {
                res += a.getDest() + " ";
            }
        }
        return res;
    }
}