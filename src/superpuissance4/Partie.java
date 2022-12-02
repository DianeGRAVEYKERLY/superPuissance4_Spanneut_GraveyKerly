/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4;

import java.util.Random;

/**
 *
 * @author dia12
 */
public class Partie {
  private Joueur[] listeJoueurs= new Joueur[2];
 private Joueur joueurcourant;
 private PlateauDeJeu  plateau;
      public void Partie (Joueur joueur1, Joueur joueur2){
          listeJoueurs[0]=joueur1;
          joueur2=listeJoueurs[2];
          PlateauDeJeu plateau = new PlateauDeJeu();
          
}
public void attribuerCouleurAuxJoueurs() {
    Random n=new Random();
    int nbr = n.nextInt(2);
    
   
   
    
    
    if (nbr==1){
        listeJoueurs[0].AffecterCouleur("rouge");
        listeJoueurs[1].AffecterCouleur("jaune");
        
    }
    else {
       listeJoueurs[0].AffecterCouleur("jaune");
       listeJoueurs[1].AffecterCouleur("rouge");
    }
}   
    public void creerEtAffecterJeton(Joueur j){
        for (int i=1;i<30;i++){
            Jeton jetoni= new Jeton (j.lireCouleur());
            j.AjouterJeton(jetoni);
            
        }
        
        
    }
    public void  placerTrousNoirsEtDesintegrateurs() {
        Random n=new Random();
    int i = n.nextInt(2);
     Random m=new Random();
    int j = m.nextInt(2);
    }
    
    
    
    
    
}
}
