/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4;

import java.util.Random;   
import java.util.Scanner;

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
          listeJoueurs[1]=joueur2;
          plateau = new PlateauDeJeu();
          
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
        
     
    for (int i=0;i<3;i++){
        
            
        
          
            Random m=new Random();
            int nb = m.nextInt(7);
            Random l=new Random();
            int mb = l.nextInt(6);
    
        if (plateau.presenceTrouNoir(nb,mb)==false && plateau.presenceDesintegrateur(nb,mb)==false)  {
              plateau.placerTrounoir(nb,mb);
              plateau.placerDesintegrateur(nb,mb);
        }
     
          }
    for(int j=0;j<2;j++){
        Random m=new Random();
            int nb = m.nextInt(7);
            Random l=new Random();
            int mb = l.nextInt(6);
             Random f=new Random();
            int nbr = f.nextInt(7);
            Random h=new Random();
            int mbr = h.nextInt(6);
            
      if (plateau.presenceTrouNoir(nb,mb)==false && plateau.presenceDesintegrateur(nb,mb)==false )  {
              plateau.placerTrounoir(nb,mb);
              
        }
     if (  plateau.presenceDesintegrateur(nbr,mbr)==false &&plateau.presenceTrouNoir(nb,mb)==false)  {
         plateau.placerDesintegrateur(nbr,mbr);
     }
    }
    
    
    
    
    
    
}
    public void initialiserPartie(){
        
                
        attribuerCouleurAuxJoueurs();
        
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs() ;
        
         
    }
    
      public void lancerPartie(){
          while (plateau.colonneGagnantePourCouleur("rouge")==false && plateau.colonneGagnantePourCouleur("jaune")==false 
                  || plateau.ligneGagnantePourCouleur("rouge")==false && plateau.ligneGagnantePourCouleur("jaune")==false
                  || plateau.diagonaleDesencanteGagnantePourCouleur("rouge")==false && plateau.diagonaleDesencanteGagnantePourCouleur("jaune")==false
                  || plateau.diagonaleMontanteGagnantePourCouleur("rouge")==false && plateau.diagonaleMontanteGagnantePourCouleur("jaune")==false){
              
              
              
              System.out.println("c'est à"+joueurcourant.Nom+ "de jouer ("+joueurcourant.couleur+")");
              
              Scanner sca =new Scanner (System.in);
              System.out.println("que voulez-vous faire ?");
              System.out.println("1 - jouer un jeton");
              System.out.println("2 - récupérer un jeton");
              System.out.println("3 - désintégrer un jeton");
              int choix = sca.nextInt();
              while (choix > 3 || choix < 1){
                  System.out.println("erreur : veuillez entrer un chiffre entre 1 et 3");
                  choix = sca.nextInt();
              }
              
              if ( choix ==1 ){ //le joueur choisit de jouer un jeton 
                  Scanner scan = new Scanner(System.in);
                  boolean action;
                  System.out.println("veuillez saisir une colonne");
                  int colonne = scan.nextInt() - 1;
                  while (colonne < 0 || colonne > 6){
                      System.out.println("erreur : veuillez entrer un chiffre valable");
                      colonne = scan.nextInt() - 1;
                  }
                  action = plateau.ajouterJetonDansColonne(joueurcourant, colonne);
                  while (!action){
                      System.out.println("la colonne est pleine, choissisez une autre colonne:");
                      colonne = scan.nextInt() - 1;
                      
                  }
              }
              
              Scanner sc = new Scanner(System.in);
              System.out.println("entrez la colonne que vous voulez jouer");
              Jeton j;
              j.affecterJeton(j);
              int colonne;
              colonne = sc.nextInt();
              plateau.ajouterJetonDansColonne(j, colonne);
          }
          
          
          
        
