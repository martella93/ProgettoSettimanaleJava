import java.util.Scanner;

public class LettoreMusicale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("LETTORE MUSICALE");

        System.out.println("Crea 5 elementi nel tuo lettore musicale: ");
        ElementoMultimediale[] elementoMultimediali = new ElementoMultimediale[5];
        for (int i = 0; i < elementoMultimediali.length; i++) {
            System.out.println("Creazione elemento multimediale #" + (i + 1));
            System.out.println("Vuoi creare un video (v), una registrazione audio (a) o un immagine (i) ?");
            char sceltaTipo = scanner.next().charAt(0);
            scanner.nextLine();

            if (sceltaTipo == 'v') {
                elementoMultimediali[i] = creaVideo(scanner);
            } else if (sceltaTipo == 'a') {
                elementoMultimediali[i] = creaRegistrazioneAudio(scanner);
            } else if (sceltaTipo == 'i') {
                elementoMultimediali[i] = creazioneImmagine(scanner);
            }
            else {
                System.out.println("Scelta non valida. Riprova.");
                i--;
            }
        }

        System.out.println("Elementi creati:");
        for (int i = 0; i < elementoMultimediali.length; i++) {
            System.out.println((i + 1) + ". " + elementoMultimediali[i].getTitolo());
        }
        System.out.println("Scegli un elemento dal lettore musicale (0 se vuoi uscire dal lettore) : ");
        int scelta = scanner.nextInt();
        if (scelta == 0) {
            System.out.println("Programma terminato.");
            System.exit(0);
        }
        if (scelta >= 1 && scelta <= elementoMultimediali.length) {
            ElementoMultimediale elementoScelto = elementoMultimediali[scelta - 1];
            System.out.println("Hai scelto: " + elementoScelto.getTitolo());
            if (elementoScelto instanceof Immagine) {
                ((Immagine) elementoScelto).show();
            } else {
                elementoScelto.play();
            }

            if (elementoScelto instanceof Video) {
                Video videoScelto = (Video) elementoScelto;
                System.out.println("Vuoi alzare (+) o abbassare (-) il volume? Se non vuoi cambiare premi 'n' ");
                char sceltaVolume = scanner.next().charAt(0);
                if (sceltaVolume == '+') {
                    videoScelto.alzaVolume();
                } else if (sceltaVolume == '-') {
                    videoScelto.abbassaVolume();
                } else if (sceltaVolume == 'n') {
                }
                else {
                    System.out.println("Scelta non valida.");
                }
                System.out.println("Vuoi alzare (+) o abbassare (-) la luminosita? Se non vuoi cambiare premi 'n' ");
                char sceltaLuminosita = scanner.next().charAt(0);
                if (sceltaLuminosita == '+') {
                    videoScelto.aumentaLuminosita();
                } else if (sceltaLuminosita == '-') {
                    videoScelto.diminuisciLuminosita();
                }else if (sceltaLuminosita == 'n') {
                }
                else {
                    System.out.println("Scelta non valida.");
                }
                videoScelto.play();
            } else if (elementoScelto instanceof RegistrazioneAudio) {
                RegistrazioneAudio registrazioneScelta = (RegistrazioneAudio) elementoScelto;
                System.out.println("Vuoi alzare (+) o abbassare (-) il volume? Se non vuoi cambiare premi 'n' ");
                char sceltaVolume = scanner.next().charAt(0);
                if (sceltaVolume == '+') {
                    registrazioneScelta.alzaVolume();
                } else if (sceltaVolume == 'n') {
                }
                else if (sceltaVolume == '-') {
                    registrazioneScelta.abbassaVolume();
                } else {
                    System.out.println("Scelta non valida.");
                }
                registrazioneScelta.play();
            } else if (elementoScelto instanceof Immagine) {
                Immagine immaginescelta = (Immagine) elementoScelto;
                System.out.println("Vuoi alzare (+) o abbassare (-) la luminosità? Se non vuoi cambiare premi 'n' ");
                char sceltaLuminosita = scanner.next().charAt(0);
                if (sceltaLuminosita == '+') {
                    immaginescelta.aumentaLuminosita();
                } else if (sceltaLuminosita == '-') {
                    immaginescelta.diminuisciLuminosita();
                }else if (sceltaLuminosita == 'n') {
                }
                else {
                    System.out.println("Scelta non valida.");
                }
                immaginescelta.show();
            }
        } else {
            System.out.println("Scelta non valida.");
        }
    }

    private static Video creaVideo(Scanner scanner) {
        System.out.print("Inserisci il titolo del video: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci la durata del video (in minuti): ");
        int durata = scanner.nextInt();
        System.out.print("Inserisci il volume iniziale del video (da 0 a 100): ");
        int volume = scanner.nextInt();
        System.out.println("Inserisci la luminosità iniziale del video (da 0 100): ");
        int luminosita = scanner.nextInt();
        return new Video(durata, titolo, volume, luminosita);
    }

    private static RegistrazioneAudio creaRegistrazioneAudio(Scanner scanner) {
        System.out.print("Inserisci il titolo della registrazione audio: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci la durata della registrazione audio (in minuti): ");
        int durata = scanner.nextInt();
        System.out.print("Inserisci il volume iniziale della registrazione audio (da 0 a 100): ");
        int volume = scanner.nextInt();
        return new RegistrazioneAudio(durata, titolo, volume);
    }
    private static Immagine creazioneImmagine(Scanner scanner){
        System.out.println("Inserisci il titolo dell' immagine: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci luminosità: " );
        int luminosita = scanner.nextInt();
        return new Immagine(titolo, luminosita);
    }
}
