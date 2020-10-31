package datas;


public class LecteurCD extends java.lang.Object{

    /**
     * Le lecteur renferme-t-il un CD
     */
    private boolean estCharge;

    /**
     * L'index de la plage courante (1 index nbrePlages ou zéro si aucun CD Chargé)
     */
    private int indexPlage;

    /**
     * leCdCourant(qui se trouve dans le lecteur)
     */
    private CD leCdCourant;

    private java.util.ArrayList<Plage> lesPlages;


    /**
     * Construction d'un lecteur de CD
     *A l'issue de la construction, il n'y a aucun CD dans le lecteur
     *(le CDCourant=null). Le chargement d'un CD se fait à l'aide de la méthode "chargerUnCD()".
     */
    public LecteurCD(){
        this.leCdCourant=null;
        this.estCharge = false;
    }

    
    /**
     * Accesseur qui renvoie vrai si le lecteur contient un CD
     *@return vrai si il y a un CD dans le lecteur
     */
    public boolean estCharge(){
        return this.estCharge;
    }

    /**
     * Accesseur qui renvoie le CD chargé dans le lecteur ou null si aucun CD chargé
     *@return le CD courant ou null si aucun CD dans le lecteur.
     */
    public CD getCD(){
        return this.leCdCourant;
    }

    /**
     * Accesseur qui renvoie l'index de la plage du CD en cours de lecture. Cet index est compris entre 1 et nbrePlages.
     * @return l'index de la plage courante (zéro si aucun CD chargé)
     */
    public int getIndexCourant() {
        int indexCourant = 0;
        if(this.estCharge()){
            indexCourant = this.indexPlage;
        }
        return indexCourant;
    }

    /**
     * Accesseur qui renvoie le nombre de plages que contient le CD.
     * @return le nombre de plages (-1 si aucun CD chargé)
     */
    public int getNbrePlages() {
        int nbrePlages = -1;
        if(this.estCharge()){
            nbrePlages = this.leCdCourant.getNbrePlages();
        }
        return nbrePlages;
    }

     /**
     * Accesseur qui renvoie le temps total du CD chargé sous forme d'une chaîne de caractères.
     * @return le temps total du CD
     */
    public String getTempsTotal() {
        String tempsTotal = "00:00:00";
        if(this.estCharge()){
            tempsTotal = this.leCdCourant.getDureeTotale().enTexte('H');
        }
        return tempsTotal;
    }

    /**
     * Accesseur qui renvoie la plage en cours de lecture.
     * @return la plage courante (null si aucun CD chargé)
     */
    public Plage getPlageCourante() {
        Plage plageCourante = null;
        if(this.estCharge()){
            plageCourante = this.leCdCourant.getUnePlage(this.getIndexCourant());
        }
        return plageCourante;
    }


    /**
     * Modificateur qui force le lecteur à se décharger du CD qu'il contient.
     * Le booléen estCharge devient faux et leCdCourant devient null.
     */
    public void setDecharger() {
        this.estCharge = false;
        this.leCdCourant = null;
    }

    /**
     * Modificateur qui simule la touche STOP. 
     * Cela a pour conséquence de simplement remettre l'index des plages sur 1.
     * (Et éventuellement d'arrêter le timer de lecture de plage en cours).
     * Il ne se passe rien si aucun CD chargé.
     */
    public void stop(){
        if(this.estCharge()){
            this.indexPlage = 1;
        }
    }

    /**
     * Modificateur qui simule le touche PLAY.
     * Cela a pour conséquence de simplement remettre l'index des plages sur 1.
     * (Et éventuellement de démarrer le timer de lecture de la 1ere plage).
     * Il ne se passe rien si aucun CD chargé.
     */
    public void play() {
        if(this.estCharge()){
            this.indexPlage = 1;
        }
    }

    /**
     * Modificateur qui simule le touche NEXT.
     * Cela a pour conséquence de simplement incrémenter l'index des plages.
     * (Et éventuellement de démarrer le timer de lecture de la plage suivante).
     * Il ne se passe rien si aucun CD chargé.
     */
    public void next() {
        if(this.estCharge() && indexPlage<this.leCdCourant.getNbrePlages()){
            this.indexPlage++;
        }
    }

    /**
     * Modificateur qui simule le touche NEXT.
     * Cela a pour conséquence de simplement décrémenter l'index des plages.
     * (Et éventuellement de démarrer le timer de lecture de la plage précédente).
     * Il ne se passe rien si aucun CD chargé.
     */
    public void previous() {
        if(this.estCharge() && indexPlage>1){
            this.indexPlage--;
        }
    }

    /**
     * Modificateur dont le rôle est de charger un CD dans le lecteur.
     * Pour simplifier, il s'agira toujours du même CD pour cette version de la méthode. 
     * La méthode doit construire le CD et mettre le booléen à vrai.
     */
    public void chargerUnCD(){
        this.leCdCourant = new CD ("we don't need to whisper","Angels and Airwaves");
        this.estCharge=true;
       
    }

    /**
     * Modificateur dont le rôle est de charger un CD dans le lecteur.
     * Pour cette version, le CD est construit à partir d'un fichier texte.
     * @param leFich - le nom du fichier texte à lire
     */
    public void chargerUnCD(String leFich){
        this.leCdCourant= new CD(leFich);
        this.estCharge=true;
    }
}