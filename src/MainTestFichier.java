public class MainTestFichier {
    public static void main(String[] args) {
        String pathGraphe = "./data/";
        GrapheListe graphe = new GrapheListe(pathGraphe+"Graphe5.txt");
        Valeur v = Dijkstra.resoudre(graphe,"1");
        System.out.println(v.getValeur("3"));
    }
}
