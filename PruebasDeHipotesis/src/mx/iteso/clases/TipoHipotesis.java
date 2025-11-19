package mx.iteso.clases;

public enum TipoHipotesis {

    BILATERAL ("μ = μ₀"),
    UNILATERAL_IZQUIERDA ("μ < μ₀"),
    UNILATERAL_DERECHA ("μ > μ₀");

    private final String typeName;

    private TipoHipotesis(String nombre) {
        this.typeName = nombre;
    }

    public String toString() {
        return this.typeName;
    }
}
