package model.son;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class SonSingleton {
    private static SonSingleton ourInstance = null;
    private Path path;
    private String  allPath;
    public AudioClip hero;
    public AudioClip attack;
    public AudioClip deplacement;
    private AudioClip piege;
    public AudioClip mur;
    private AudioClip tresor;
    public AudioClip nextLevel;
    public AudioClip magic;
    private boolean state;
    private URL sonUrl;
    private SonSingleton() {
        this.state = false;
        path = FileSystems.getDefault().getPath("").toAbsolutePath();
        allPath = "./sons/";
        System.out.println(allPath);

        sonUrl = SonSingleton.class.getResource(allPath + "pas.wav");
        hero = Applet.newAudioClip(sonUrl);

        sonUrl = SonSingleton.class.getResource(allPath + "attack.wav");
        attack = Applet.newAudioClip(sonUrl);

        sonUrl = SonSingleton.class.getResource(allPath + "deplacer.mp3");
        deplacement = Applet.newAudioClip(sonUrl);

        // sonUrl = SonSingleton.class.getResource(allPath+"piege.wav");
        // piege = Applet.newAudioClip(sonUrl);

         sonUrl = SonSingleton.class.getResource(allPath+"mur.wav");
         mur = Applet.newAudioClip(sonUrl);

         sonUrl = SonSingleton.class.getResource(allPath+"Magique.wav");
         magic = Applet.newAudioClip(sonUrl);

         sonUrl = SonSingleton.class.getResource(allPath+"deplacer.mp3");
         nextLevel = Applet.newAudioClip(sonUrl);

        // sonUrl = SonSingleton.class.getResource(allPath+"tresor.wav");
        // tresor= Applet.newAudioClip(sonUrl);




    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    synchronized public static SonSingleton getInstance() {
        if (ourInstance == null)
            ourInstance = new SonSingleton();
        return ourInstance;
    }
}
