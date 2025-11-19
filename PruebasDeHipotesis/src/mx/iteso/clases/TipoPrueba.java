package mx.iteso.clases;

public enum TipoPrueba {

    Z_CONOCIDA ("σ conocida, n ≥ 30"),
    Z_DESCONOCIDA ("σ desconocida, n ≥ 30"),
    T_STUDENT ("σ desconocida, n < 30");

    private final String categoryName;

    private TipoPrueba(String nombre) {
        this.categoryName = nombre;
    }

    public String toString() {
        return this.categoryName;
    }

}
