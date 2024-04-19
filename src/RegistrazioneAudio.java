public class RegistrazioneAudio extends ElementoMultimediale implements Volume{

    private int volume;

    public RegistrazioneAudio(int durata, String titolo, int volume) {
        super(durata, titolo);
        this.volume=volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    @Override
    public void alzaVolume() {
        if(volume<100){
            volume++;
        }
    }

    @Override
    public void abbassaVolume() {
        if(volume>0){
            volume--;
        }
    }

    @Override
    public void play() {
        System.out.println("Stai riproducendo:");
        String asterischi = "*".repeat(volume);
        for (int i = 0; i < getDurata(); i++) {
            System.out.println(getTitolo() + " " + asterischi);
        }
    }

}
