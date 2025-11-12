package mx.iteso.clases;

public class Hipotesis {

    protected Category category;
    protected double standardDeviation; // σ
    protected int n; // muestra
    protected double significanceLevel; // α
    protected double meanX; // x
    protected double z;
    protected double hypothesizedValue; // μo
    protected double unknownStandardDeviantion; // s
    protected double degreesOfFreedom; // v = n - 1

    Hipotesis(double hypothesizedValue, int n, double meanX, double significanceLevel, double unknownStandardDeviantion, Category category){
        setHypothesizedValue(hypothesizedValue);
        setN(n);
        setMeanX(meanX);
        setSignificanceLevel(significanceLevel);
        setUnknownStandardDeviantion(unknownStandardDeviantion);
        setCategory(category);
    }

    Hipotesis(double hypothesizedValue, int n, double meanX, double significanceLevel, double unknownStandardDeviantion, double degreesOfFreedom, Category category){
        this(hypothesizedValue, n, meanX, significanceLevel, unknownStandardDeviantion, category);
        setDegreesOfFreedom(degreesOfFreedom);

    }

    Hipotesis(double hypothesizedValue, int n, double meanX, double significanceLevel, double standardDeviation, Category category){
        setHypothesizedValue(hypothesizedValue);
        setN(n);
        setMeanX(meanX);
        setSignificanceLevel(significanceLevel);
        setStandardDeviation(standardDeviation);
        setCategory(category);
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSignificanceLevel() {
        return significanceLevel;
    }

    public void setSignificanceLevel(double significanceLevel) {
        this.significanceLevel = significanceLevel;
    }

    public double getMeanX() {
        return meanX;
    }

    public void setMeanX(double meanX) {
        this.meanX = meanX;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getHypothesizedValue() {
        return hypothesizedValue;
    }

    public void setHypothesizedValue(double hypothesizedValue) {
        this.hypothesizedValue = hypothesizedValue;
    }

    public double getUnknownStandardDeviantion() {
        return unknownStandardDeviantion;
    }

    public void setUnknownStandardDeviantion(double unknownStandardDeviantion) {
        this.unknownStandardDeviantion = unknownStandardDeviantion;
    }

    public double getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    public void setDegreesOfFreedom(double degreesOfFreedom) {
        this.degreesOfFreedom = degreesOfFreedom;
    }

    public String toString() {

        String mensaje = null;

        switch (category) {

            case CATEGORY1:
                mensaje = String.format("Hipótesis:\nμo: %lf\nMuestra (n): %d\nx̄: %lf\nσ: %lf\nCondiciones: %s",
                        this.hypothesizedValue, this.n, this.meanX, this.significanceLevel, this.standardDeviation, this.category);
                break;

            case CATEGORY2:
                mensaje = String.format("Hipótesis:\nμo: %lf\nMuestra (n): %d\nx̄: %lf\nα: %lf\ns: %lf\nCondiciones: %s",
                        this.hypothesizedValue, this.n, this.meanX, this.significanceLevel, this.unknownStandardDeviantion, this.category);
                break;

            case CATEGORY3:
                mensaje = String.format("Hipótesis:\nμo: %lf\nMuestra (n): %d\nx̄: %lf\nα: %lf\ns: %lf\nα: %lf\nCondiciones: %s",
                        this.hypothesizedValue, this.n, this.meanX, this.significanceLevel, this.standardDeviation, this.degreesOfFreedom, this.category);
                break;
        }

        return mensaje;

    }

} // Fin de la clase hipotesis
