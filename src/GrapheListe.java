import java.util.ArrayList;

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
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
        }

        // ajoute l'arc au noeud depart avec destination pour noeud de destination de l'arc
        adjacence.get(adjacence.indexOf(depart)).ajouterArc(new Arc(destination, cout));
    }
}