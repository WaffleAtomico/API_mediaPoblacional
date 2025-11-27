package mx.iteso.excepciones;

public class NegativeNumberFoundException extends Exception {

    private double negativeNumberFound;

    // Constructor de la Excepción
    public NegativeNumberFoundException(double n) {
        super("NegativeNumberFoundException");
        this.negativeNumberFound = n;
    }

    public String toString() {
        return super.getMessage() +
                "\n Negative Number Found: "
                + this.negativeNumberFound;
    }

}
