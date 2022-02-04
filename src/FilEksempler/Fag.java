package FilEksempler;

public class Fag {
    private int fagnr;
    private String fagnavn;

    public Fag() {
    }

    public Fag(int fagnr, String fagnavn) {
        this.fagnr = fagnr;
        this.fagnavn = fagnavn;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public String getFagnavn() {
        return fagnavn;
    }

    public void setFagnavn(String fagnavn) {
        this.fagnavn = fagnavn;
    }
}
