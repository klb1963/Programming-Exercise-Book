package excepton;

public class NoSolutionException extends Exception {
    // checked exception
    public NoSolutionException(){}

    public NoSolutionException(String message){
        super(message);
    }
}
