package model.son;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class SonSingelton {
    private static SonSingelton ourInstance = null;
    private Path path;
    private String  allPath;
    public AudioClip hero;
    public AudioClip attack;
    public AudioClip deplacement;
    private AudioClip piege;
    private AudioClip mur;
    private AudioClip tresor;
    private AudioClip nextLevel;
    private AudioClip maqic;
    private boolean state;
    private URL sonUrl;
    private SonSingelton() {
        this.state= false;
        path = FileSystems.getDefault().getPath(".").toAbsolutePath();
        allPath =path.toString()+"/src/model/son/sons/";

        sonUrl = SonSingelton.class.getResource(allPath+"pas.wav");
        hero = Applet.newAudioClip(sonUrl);

        sonUrl = SonSingelton.class.getResource(allPath+"attack.wav");
        attack = Applet.newAudioClip(sonUrl);

         sonUrl = SonSingelton.class.getResource(allPath+"deplacer.wav");
         deplacement = Applet.newAudioClip(sonUrl);

        //  sonUrl = SonsJeu.class.getResource(allPath+"piege.wav");
        // piege = Applet.newAudioClip(sonUrl);

        //  sonUrl = SonsJeu.class.getResource(allPath+"mur.wav");
        // mur = Applet.newAudioClip(sonUrl);

        //  sonUrl = SonsJeu.class.getResource(allPath+"magic.wav");
        // magic = Applet.newAudioClip(sonUrl);

        //  sonUrl = SonsJeu.class.getResource(allPath+"nextLevel.wav");
        // nextLevel = Applet.newAudioClip(sonUrl);

        // sonUrl = SonsJeu.class.getResource(allPath+"tresor.wav");
        // tresor= Applet.newAudioClip(sonUrl);




    }

    public boolean getState()
    {
        return this.state;
    }

    public void setState(boolean state)
    {
        this.state =state;
    }
    public static SonSingelton getInstance() {
        return ourInstance;
    }
}
