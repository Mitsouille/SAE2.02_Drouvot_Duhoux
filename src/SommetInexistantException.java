public class SommetInexistantException extends Exception {
    public SommetInexistantException(String s){
        super(s);
    }

    public String toString(){
        return "Sommet inexistant dans ce graphe " + super.toString();
    }
}
