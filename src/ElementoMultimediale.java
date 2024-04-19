public abstract class ElementoMultimediale {
    private int durata;
    private String titolo;

    public ElementoMultimediale(int durata, String titolo) {
        this.durata = durata;
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void play(){
        System.out.println("Stai riproducendo: " + titolo + " della durata di " + durata + "min");
    }
}
