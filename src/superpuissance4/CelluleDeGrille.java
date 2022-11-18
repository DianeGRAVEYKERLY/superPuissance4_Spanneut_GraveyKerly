/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4;

/**
 *
 * @author dia12
 */
public class CelluleDeGrille {
    private Jeton jetonCourant; //premier attribut 

    
    //constructeur 
    public CelluleDeGrille(Jeton jeton, boolean TrouNoir, boolean Desintegrateur){ 
        jetonCourant=jeton;
        
        TrouNoir = false;
        Desintegrateur = false;
        
    } 
    
    //jetoncourant devient null
    public void Celluledegrille(){
        jetonCourant = null;
    }
    
    // methode pour tester si le jeton est présent ou non 
    public boolean presenceJeton(){
        if (jetonCourant != null){
            return true;
        }else{
            return false;
        }
        
    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant != null){
            return jetonCourant.lireCouleur();
        }else{
            return "vide";
        }
        
    }
    
    private boolean avoirTrouNoir;
    
    
    public void placerTrouNoir(){
        
    }
    
    
    
    private boolean avoirDesintegrateur;
}
