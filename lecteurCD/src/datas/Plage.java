package datas;
public class Plage extends java.lang.Object {

    /**
     *La durée du morceau.
     */
    private Duree laDuree;
    
    /**
     *Titre du morceau de musique.
     */
    private java.lang.String leTitre;
    
    /**
     *Interprète du morceau de musique.
     */
    private java.lang.String lInterprete;

    
    /**
     *Construction d'une plage correspondant à un morceau de musique.
     *@param duree durée de la plage(!!type Duree)
     *@param titre titre du morceau de musique
     *@param interprete interprète du morceau
     */
    public Plage(Duree duree, java.lang.String titre, java.lang.String interprete){
        if(duree.getLeTemps()>0 && !titre.equals("") && !interprete.equals("")){
            this.laDuree=duree;
            this.leTitre=titre;
            this.lInterprete=interprete;
        }
        else{
            System.out.println("Impossible création plage, car paramètres non valides");
        }
    }

    /**
     *Accesseur qui renvoie la durée.*
     *@return la durée (!!type Duree)
     */
    public Duree getLaDuree(){
        return this.laDuree;
    }

    /**
     *Accesseur qui renvoie le titre du morceau
     *@return le titre
     */
    public java.lang.String getLeTitre(){
        return this.leTitre;
    }

    /**
     *Accesseur qui renvoie l'interprète du morceau
     *@return l'interprète
     */
    public java.lang.String getLInterprete(){
        return this.lInterprete;
    }

    

    public Duree setLaDuree(Duree duree){
            return this.laDuree=duree;
    }

    /**
     * Modificateur qui modifie le titre d'une plage
     *@param titre titre
     *@return le titre du CD
     */
    public java.lang.String setLeTitre(java.lang.String titre){

            return this.leTitre=titre;
        
    }

     /**
     * Modificateur qui modifie l'interprete d'une plage
     *@param interprete l'interprète
     *@return l'interprète
     */
    public java.lang.String setLInterprete(java.lang.String interprete){
       
            return this.lInterprete=interprete;
        
    }

    /**
     *Accesseur qui renvoie un texte décrivant complètement la plage sous la formesuivante:
     *<UL>
     *<LI> Titre
     *<LI> Interprète
     *<LI> Durée : HHH:MM:SS
     *</UL>
     *@return le texte qui décrit la plage
     */
    public java.lang.String getFicheComplete(){
        System.out.println("Titre: "+this.getLeTitre()+'\n'+"Interprète: "+this.getLInterprete()+'\n'+"Durée: "+this.laDuree.enTexte('H'));
        return "Titre: "+this.getLeTitre()+'\n'+"Interprète: "+this.getLInterprete()+'\n'+"Durée: "+this.laDuree.enTexte('H');
    }

    /**
     *Accesseur qui renvoie un résumé textuel de la plage sous la forme:
     *<UL>
     *<LI> titre
     *<LI> interprète
     *<LI> durée (SSS.MMM sec)
     *</UL>
     *@return la ligne de texte qui décrit la plage
     */
    @Override 
    public java.lang.String toString(){
        System.out.println(""+this.getLeTitre()+" - "+this.getLInterprete()+" - "+this.laDuree.enTexte('S'));
        return ""+this.getLeTitre()+" - "+this.getLInterprete()+" - "+this.laDuree.enTexte('S');
    }
}