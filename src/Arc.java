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
    public Arc(String d, double c) throws Exception {
        this.dest =  d;
        if(c >= 0)
        this.cout = c;
        else
            throw new Exception("Un arc négatif est impossible");
    }

    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }
}