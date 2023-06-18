package modelo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Reproductor {
    public static Reproductor rep;
    private String file;

    public Reproductor(String fileName){
        file = fileName;
    }
    

    public void run() {
        File archivoSonido = new File(file);
        AudioInputStream sonido;
        try {
              sonido = AudioSystem.getAudioInputStream(archivoSonido);
              DataLine.Info info = new DataLine.Info(Clip.class, sonido.getFormat());
              Clip clip = (Clip) AudioSystem.getLine(info);
              clip.open(sonido);

              clip.start();
         } catch (Exception e){}

    }
   
}