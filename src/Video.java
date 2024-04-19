public class Video extends ElementoMultimediale implements Volume, Luminosita{

    private int volume;
    private int luminosita;
    public Video(int durata, String titolo, int volume, int luminosita) {
        super(durata, titolo);
        this.volume=volume;
        this.luminosita=luminosita;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    @Override
    public void abbassaVolume() {
        if(volume>0){
            volume--;
        }
    }

    @Override
    public void alzaVolume() {
        if(volume>0){
            volume--;
        }
    }

    @Override
    public void play() {
        System.out.println("Stai riproducendo:");
        String asterischi = "!".repeat(volume);
        String esclamativi = "*".repeat(luminosita);
        for (int i = 0; i < getDurata(); i++) {
            System.out.println(getTitolo() + " " + asterischi + esclamativi);
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(luminosita>0){
            luminosita--;
        }
    }

    @Override
    public void aumentaLuminosita() {
        if (luminosita < 100) {
            luminosita++;
        }
    }
}
