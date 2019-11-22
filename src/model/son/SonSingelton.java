package model.son;

import java.applet.AudioClip;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class SonSingelton {
    private static SonSingelton ourInstance = null;
    private Path path;
    private String  allPath;
    private AudioClip hero;
    private AudioClip attack;
    private AudioClip deplacement;
    private URL sonUrl;
    private SonSingelton() {
        path = FileSystems.getDefault().getPath(".").toAbsolutePath();
        allPath =path.toString()+"/src/model/son/sons/";

      //  sonUrl = SonsJeu.class.getResource(allPath+"hero.wav");
       // hero = Applet.newAudioClip(sonUrl);

        //  sonUrl = SonsJeu.class.getResource(allPath+"attack.wav");
        // attack = Applet.newAudioClip(sonUrl);

        //  sonUrl = SonsJeu.class.getResource(allPath+"deplacement.wav");
        // deplacement = Applet.newAudioClip(sonUrl);

    }

    public static SonSingelton getInstance() {
        return ourInstance;
    }
}
