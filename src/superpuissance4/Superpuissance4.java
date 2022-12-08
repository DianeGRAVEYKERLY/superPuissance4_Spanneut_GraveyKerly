/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package superpuissance4;

/**
 *
 * @author dia12
 */
public class Superpuissance4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Jeton PremierJeton = new Jeton("rouge");  // TEST POUR VOIR SI JETON MARCHE 
        //PremierJeton.lireCouleur();
        
       //Joueur joueur1= new Joueur("rouge","nathan", reserve<Jeton>,5);
        
        System.out.println("vous entrez dans le jeu superpuissance 4");
        Partie une_partie = new Partie();
        une_partie.lancerPartie();
    }
    
}
