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
 private Joueur[] listeJoueurs= new Joueur[2]; //on creer nos joueurs 
 private Joueur joueurcourant;
 private PlateauDeJeu  plateau;
 
      public void Partie (Joueur joueur1, Joueur joueur2){
          listeJoueurs[0]=joueur1;
          listeJoueurs[1]=joueur2;
          plateau = new PlateauDeJeu();
          
}
public void attribuerCouleurAuxJoueurs() { //on determine de quelle couleur seront les jetons de chaque joueur 
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
              plateau.placerTrouNoir(nb,mb);
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
              plateau.placerTrouNoir(nb,mb);
              
        }
     if (  plateau.presenceDesintegrateur(nbr,mbr)==false &&plateau.presenceTrouNoir(nb,mb)==false)  {
         plateau.placerDesintegrateur(nbr,mbr);
     }
    }
    
    
    
    
    
    
}
    public void initialiserPartie(){
        
        Scanner sc = new Scanner(System.in); //on demande au joueurs de choisir un pseudo
        System.out.println("Choix du pseudo du joueur1");
        Joueur joueur1 = new Joueur(sc.nextLine());
        System.out.println("Choix du pseudo du joueur2");
        Joueur joueur2 = new Joueur(sc.nextLine());
        
        
        
        Random r = new Random(); //on d??termine qui sera le premier a commencer 
        boolean le_premier = r.nextBoolean();
        if (le_premier){
            joueurcourant = listeJoueurs[0];
        }else{
            joueurcourant = listeJoueurs[1];
        }
        
                
        attribuerCouleurAuxJoueurs();
        
        System.out.println(joueur1 + " est de " + joueur1.lireCouleur());
        System.out.println(joueur2 + " est de " + joueur2.lireCouleur());
        
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs() ;
        
         
    }
    
      public void lancerPartie(){
          
        Scanner sc = new Scanner(System.in);
        this.initialiserPartie(); //utilisation methode initialiser partie
        int nbr_ligne=0;
        
        
        if (plateau.grilleRemplie()== false) { // si la grille renvoie false alors elle est vide
            
            System.out.println("Que souhaitez vous faire ?" + '\n' + " 1) Jouer un jeton." + '\n' + "2) R??cup??rer un jeton."+ '\n' + "3) Utiliser un Desintegrateur.");
            int rep_1 = sc.nextInt(); // permet d'enregistrer et lire la r??ponse de l'utilisateur
                
            switch (rep_1) {
                    
                case 1: //cas o?? le joueur veut jouer un jeton 
                    
                    System.out.println("Choisissez le num??ro de la colonne sur laquelle vous souhaitez jouer." + '\n' + "Entrez un chiffre entre 1 et 7");
                    int col = sc.nextInt(); // permet d'enregistrer et lire la r??ponse de l'utilisateur
                    
                    // si la colonne est remplie
                    while (plateau.presenceJeton(6, col)) { //regarde si il y a un jeton dans la derni??re ligne de la colonne choisie 
                        // si un jeton est pr??sent dans la derni??re ligne du haut alors la colonne est forc??ment remplie vu que les jetons se tassent par colonne 
                        System.out.println("Colonne remplie" + '\n' + "Choisissez une autre colonne");
                        col = sc.nextInt(); //on fait demande au joueur une colonne jusqu'a ce qu'elle ne soit pas remplie 
                    }
       
                    // si la colonne n'est pas remplie 
                    boolean boucle = true;
                    int i = 0;
                    while (boucle && i < 7){ 
                    //boucle while au lieu de for pour pouvoir sortir de la boucle une fois la ligne d??finie ??a ??vite d'utiliser un break
                        
                        if(!plateau.presenceJeton(i, col)){ 
                        //verifie la pr??sence d'un jeton dans chaque ligne de la colonne choisie pour definir ses coord.
                            nbr_ligne = i; 
                            // si pas de jeton alors le numero de la ligne vide sera la coordonnee du jeton ?? placer
                        } 
                        
                        if(!plateau.presenceTrouNoir(nbr_ligne, col)) {  
                        //ajouter le jeton 
                            Jeton NouveauJeton = joueurcourant.jouerJeton();
                            plateau.ajouterJetonDansColonne(NouveauJeton, col);
                        }
                        
                        if (i==nbr_ligne) boucle = false; // condition pour ne pas reboucler (remplace break)
                        i++; // i prends +1
                    
                    }

            
                        
                case 2: //si le joueur veut r??cup??rer un jeton
                    
                    System.out.println("Choisissez un de vos jetons" + '\n' + "Exprimer la coordonn??e en Ligne puis Colonne");
                    int ligneJeton = sc.nextInt(); //r??cup??re la r??ponse du joueur
                    int colJeton = sc.nextInt();
                    
                    //CAS OU IL Y A UN JETON
                    if (plateau.lireCouleurDuJeton(ligneJeton, colJeton).equals(joueurcourant.lireCouleur())) {
                        plateau.recupererJeton(ligneJeton, colJeton);
                        System.out.println("Jeton r??cup??r??.");
                        break;
                    
                    // cas si il n'y a pas de jeton              
                    } else if (plateau.presenceJeton(ligneJeton, colJeton)==false) { 
                        System.out.println("Aucun jeton sur cette case.");
                    
                    // cas si le jeton est de la mauvaise couleur et donc n'est pas ?? lui 
                    } else {
                        System.out.println("Ce n'est pas un de vos jetons.");
                    }
                        
                case 3: //cas o?? la r??ponse est utiliser un desintegrateur
                    
                    //cas si le joueur n'a pas de d??sint??grateur 
                    if (joueurcourant.NombreDesintegrateurs == 0) { 
                        System.out.println("Vous n'avez pas de desint??grateur.");
                        break;
                    
                    //cas si le joueur a un ou des d??sint??grateurs 
                    } else {
                        System.out.println("Vous devez choisir une case." );
                        System.out.println("Entrez le num??ro de la ligne entre 1 et 6 :"); 
                        int ligneDes = sc.nextInt(); //r??cup??re les coordonn??es du joueur
                        System.out.println("Entrez le num??ro de la colonne entre 1 et 7 :"); 
                        int colDes = sc.nextInt();
                        
                        if (plateau.presenceJeton(ligneDes, colDes)){ // seulement s'il y a un jeton dans la case vis??e
                            plateau.supprimerJeton(ligneDes, colDes); // vise le jeton ?? supprimer
                            joueurcourant.utiliserDesintegrateur(); // supression du jeton avec methode utiliserdesintegrateur
                            break;
                        
                        // cas si il n'y a pas de jeton
                        } else {
                            System.out.println("Il n'y a pas de jeton sur cette case.");
                        }
                    }
            }

        }
    }

}      
