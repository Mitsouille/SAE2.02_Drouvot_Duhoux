public class ErreurFichierException extends Exception{
    public ErreurFichierException(String e){
        super(e);
    }

    public String toString(){
        return "Erreur dans la conception du fichier";
    }
}
