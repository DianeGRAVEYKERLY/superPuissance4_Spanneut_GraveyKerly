/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4;

/**
 *
 * @author dia12
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille [6][7];
    public PlateauDeJeu (){
        for (int i=0;i<7;i++){
            for(int j=0; j<6;j++){
               grille[i][j] = new CelluleDeGrille();
            }
        
            
        }
        
        
        
    }
    
    
    public int ajouterJetonDansColonne(Jeton notre_jeton, int colonne){
        for (int i=0; i<7; i++){
            if (grille[i][colonne].presenceJeton()== false){
                grille[i][colonne].affecterJeton(notre_jeton);
                return i;
            }
            
        }
        
return -1;
    }
    
    
    public boolean grilleRemplie(){
        int compteur = 0;
        for (int i=0;i<8;i++){
            for(int j=0; j<7;j++){
               if (grille[i][j]!= null){
                   compteur +=1; //ajoute +1 à chaque fois qu'une case est remplie 
               }     
               }
        }
        //compteur = 42 si toute la grille est remplie
        if (compteur == 42){   
            return true;
        }else{
            return false;
        }
         
    }

    public String afficherGrilleSurConsole() {
        return "PlateauDeJeu{" + "grille=" + grille + '}'; //methode to string
    }
    
    
    public boolean presenceJeton(int x, int y){
        if (grille[x][y] != null){ //on regarde si la cellule est vide ou pas 
            return true;
        }else{
            return false;
        }
    }
    
    public String lireCouleurDuJeton(int x, int y){ //on lit la couleur du jeton présent dans la case s'il y en a un 
        grille[x][y].lireCouleurDuJeton();
        return grille[x][y].lireCouleurDuJeton();
    }
    
    public boolean etreGagnantePourCouleur(String couleur){
        
        public boolean ligneGagnantePourCouleur(String couleur){
            for (int i=0;i<4;i++){
                for(int j=0; j<6;j++){
                    if (grille[i][j].lireCouleurDuJeton()==grille[i+1][j].lireCouleurDuJeton()){
                        if(grille[i+1][j].lireCouleurDuJeton()==grille[i+2][j].lireCouleurDuJeton()){
                            if (grille[i+2][j].lireCouleurDuJeton()==grille[i+3][j].lireCouleurDuJeton()){
                                return true;
                            }
                        }
                    }
                }     
            } 
        }
        
        public boolean colonneGagnantePourCouleur(String couleur){
            
        }
        
        public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
            
        }
        
        
        public boolean diagonaleDesencanteGagnantePourCouleur(String couleur){
            
        }

        
        
    }

public void tasserColonne(int j){

}
    
}

