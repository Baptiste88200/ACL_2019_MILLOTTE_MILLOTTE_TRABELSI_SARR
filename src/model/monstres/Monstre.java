/*     */ package model.monstres;
/*     */ 
/*     */

import model.Labyrinthe;
import model.Personnage;
import model.cases.Sol;

import java.awt.*;

/*     */
/*     */
/*     */
/*     */ 
/*     */ public abstract class Monstre
/*     */   implements Personnage {
/*     */   protected int x;
/*     */   protected int y;
/*     */   protected int score;
/*     */   protected Labyrinthe labyrinthe;
    /*     */   protected Deplacement deplacement;

    /*     */
/*     */   public Monstre(int x, int y, Labyrinthe labyrinthe) {
/*  17 */     this.x = x;
/*  18 */     this.y = y;
/*  19 */     this.labyrinthe = labyrinthe;
/*  20 */     this.score = 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  26 */   public boolean enVie() { return (this.score > 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   public void attaquer(Personnage p) { p.subirDegat(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void afficher(Graphics2D paramGraphics2D);
/*     */ 
/*     */ 
/*     */   
/*     */   public void deplacer() {
/*  40 */     int direction = (int)(Math.random() * 4.0D);
/*  41 */     switch (direction) {
/*     */       case 0:
/*  43 */         if (this.labyrinthe.estTraversable(this.x, this.y - 1)) {
/*  44 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(true);
/*  45 */           this.y--;
/*  46 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(false);
/*     */         } 
/*     */         break;
/*     */       case 1:
/*  50 */         if (this.labyrinthe.estTraversable(this.x, this.y + 1)) {
/*  51 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(true);
/*  52 */           this.y++;
/*  53 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(false);
/*     */         } 
/*     */         break;
/*     */       case 2:
/*  57 */         if (this.labyrinthe.estTraversable(this.x - 1, this.y)) {
/*  58 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(true);
/*  59 */           this.x--;
/*  60 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(false);
/*     */         } 
/*     */         break;
/*     */       case 3:
/*  64 */         if (this.labyrinthe.estTraversable(this.x + 1, this.y)) {
/*  65 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(true);
/*  66 */           this.x++;
/*  67 */           ((Sol)this.labyrinthe.getCase(this.x, this.y)).setTraversable(false);
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deplacer2() {
/*  77 */     this.deplacement = new DeplacementAEtoile(this.labyrinthe, this);
/*  78 */     int[] pos = this.deplacement.deplacer();
/*  79 */     this.x = pos[0];
/*  80 */     this.y = pos[1];
/*     */   }
/*     */ 
/*     */   
/*  84 */   public int getX() { return this.x; }
/*     */ 
/*     */ 
/*     */   
/*  88 */   public void setX(int x) { this.x = x; }
/*     */ 
/*     */ 
/*     */   
/*  92 */   public int getY() { return this.y; }
/*     */ 
/*     */ 
/*     */   
/*  96 */   public void setY(int y) { this.y = y; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void subirDegat() {
/* 101 */     System.out.println("Score:" + this.score);
/* 102 */     this.score--;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 107 */   public int getScore() { return this.score; }
/*     */ }


/* Location:              /home/mobis/Bureau/ACL_2019_MILLOTTE_MILLOTTE_TRABELSI_SARR/!/model/monstres/Monstre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */