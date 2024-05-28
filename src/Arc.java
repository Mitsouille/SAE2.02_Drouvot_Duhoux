public class Arc {
    /**
     * chaine correspondant au nom du noeud de destination de l'arc
     */
    private String dest;

    /**
     * attribut correspondant au cout de l'arc
     */
    private double cout;

    /**
     * constructeur d'Arc
     * @param d est une chaine
     * @param c est un reel
     */
    public void Arc(String d, double c) {
        this.dest =  d;
        this.cout = c;
    }
}