package mx.iteso.excepciones;

public class MoreThanOneValueFoundException extends Exception {

    private double moreThanOneValueFound;

    // Constructor de la Excepción
    public MoreThanOneValueFoundException(double n) {
        super("MoreThanOneValueFoundException");
        this.moreThanOneValueFound = n;
    }

    public String toString() {
        return super.getMessage() +
                "\n More Than One Value Found: "
                + this.moreThanOneValueFound;
    }
}
