public class Immagine extends ElementoMultimediale implements Luminosita{
    private int luminosita;

    public Immagine( String titolo, int luminosita) {
        super(0,titolo);
        this.luminosita = luminosita;
    }

    @Override
    public void aumentaLuminosita() {
        if (luminosita < 100) {
            luminosita++;
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(luminosita>0){
            luminosita--;
        }
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public void show(){
        System.out.println("Stampa titolo: ");
        String asterischi = "*".repeat(luminosita);
        for (int i=0; i<getLuminosita(); i++){
            System.out.println(getTitolo() + " " + asterischi);
        }
    }


}
