package model.creationLabyrinthe;

import model.Labyrinthe;
import model.cases.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class CreationFichierTexte implements CreationLabyrinthe {

    private String nomFichier;

    public CreationFichierTexte(String nomFichier){
        super();
        this.nomFichier = nomFichier;
    }


    @Override
    public void creerLabyrinthe(Labyrinthe l) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("niveaux/" + nomFichier));
            String line = br.readLine();
            int largeur = Integer.valueOf(line);
            line = br.readLine();
            int hauteur = Integer.valueOf(line);
            Case[][] labyrinthe = new Case[largeur][hauteur];
            boolean heroPlace = false;
            int posHeroX = -1;
            int posHeroY = -1;
            for(int y = 0; y < hauteur; y++){
                line = br.readLine();
                for(int x = 0; x < largeur; x++){
                   char c = line.charAt(x);
                    switch (c){
                        case '.':
                            labyrinthe[x][y] = new Sol();
                            break;

                        case 'M':
                            labyrinthe[x][y] = new CaseMagique();
                            break;

                        case 'P' :
                            labyrinthe[x][y] = new Piege();
                            break;

                        case 'T' :
                            labyrinthe[x][y] = new Tresor(l);
                            break;

                        case 'H':
                            labyrinthe[x][y] = new Sol();
                            if(!heroPlace){
                                heroPlace = true;
                                posHeroX = x;
                                posHeroY = y;
                            }
                            break;

                        default:
                            labyrinthe[x][y] = new Mur();
                            break;
                    }
                }

            }

            br.close();

            l.setCases(labyrinthe);

            if(heroPlace){
                l.setPositionHero(posHeroX, posHeroY);
            }else{
                int[] pos = l.getCordTraversable();
                l.setPositionHero(pos[0], pos[1]);
            }




        }catch (Exception e){
            System.out.println(e);
        }
    }
}


