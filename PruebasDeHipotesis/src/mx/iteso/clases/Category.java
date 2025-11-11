package mx.iteso.clases;

public enum Category {

    CATEGORY1 ("μ≥μ0|μ<μ0"),
    CATEGORY2 ("μ≤μ0|μ>μ0"),
    CATEGORY3 ("μ=μ0|μ≠μ0");

    private final String categoryName;

    private Category(String nombre) {
        this.categoryName = nombre;
    }

    public String toString() {
        return this.categoryName;
    }
}