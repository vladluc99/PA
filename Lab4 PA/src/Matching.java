public class Matching <Resident,Hospital> {   //se va crea o lista cu elemente de acest tip si in ea va fi returnat rezultatul, adica rezidentul si spitalul la care a fost asociat
    private Resident rezident;
    private Hospital spital;

    public Matching(Resident rezident, Hospital spital) {
        this.rezident = rezident;
        this.spital = spital;
    }

    public Resident getRezident() {
        return rezident;
    }

    public Hospital getSpital() {
        return spital;
    }

    public void setRezident(Resident rezident) {
        this.rezident = rezident;
    }

    public void setSpital(Hospital spital) {
        this.spital = spital;
    }

    @Override
    public String toString() {
        return "Matching{" +
                "rezident=" + rezident +
                ", spital=" + spital +
                '}';
    }
}
