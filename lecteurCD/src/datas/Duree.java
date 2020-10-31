package datas;

public class Duree{
    /**
     *La durée s'exprime en millisecondes.
     */
    private long leTemps;

    /**
     *Constructeur avec initialisation en millisecondes.
     *@param millisec la durée s'exprime en millisecondes.
     */
    public Duree(long millisec){
        if(millisec > 0){
            this.leTemps = millisec;
        }
        else{
            System.out.println("impossible le temps es negtif");
        }
    }

    /**
     Constructeur à partir des données heures, minutes , secondes.
     *@param heures nombre d'heures
     *@param minutes nombre de minutes
     *@param secondes nombre de secondes
     */
    public Duree(int heures,int minutes,int secondes){
        if((heures==0 && minutes==0 && secondes==0) || (heures<0 || minutes<0 || secondes<0)){
            System.out.println("impossible, le temps est négatif ou nul");
        }
        else{
            this.leTemps=(3600*1000*heures)+(60*1000*minutes)+(1000*secondes);
        }
    }

    /**
     *Construction par copie d'une duree passé en paramètre.
     *@param autreDuree la durée à copier
     */
    public Duree (Duree autreDuree){
        if(this.leTemps > 0){
            this.leTemps = autreDuree.getLeTemps();
        }
    }

    /**
     *Accesseur qui retourne la valeur de la durée courante en millisecondes.
     *@return la durée en millisecondes
     */
    public long getLeTemps(){
        return this.leTemps;
    }

    /**
     *Accesseur qui effectue une comparaison entre la durée courante et une autre durée.
     *@param autreDuree durée a comparer à la durée courante
     *@return un entier qui prend la valeur suivante:
     *<UL>
     *<LI> -1: si la durée courante est + petite que autreDuree
     *<LI> 0: si la durée courante est égale à autre durée
     *<LI> 1: si la durée courante est + grande que autreDuree
     *</UL>
     */
    public int compareA (Duree autreDuree){
        int resultat = 0;
        if (this.leTemps < autreDuree.getLeTemps()){
            resultat = -1;
        }
        else if (this.leTemps == autreDuree.getLeTemps()){
            resultat = 0;
        }
        else{
            resultat = 1;
        }
        return resultat;
    }

    /**
     *Accesseur qui renvoie sous la forme d'une chaine de caractères la durée courante.
     *@param mode décide de la forme donnée à la chaine de caractères.
     *La forme de la chaine de caractères dépend du "mode" (caractère passé en paramètre)choisi:
     *<UL> 
     *<LI> si mode == 'J'  chaine de caractères de la forme "JJJ jours HH h"
     *<LI> si mode == 'H'  chaine de caractères de la forme "HHH:MM:SS"
     *<LI> si mode == 'S'  chaine de caractères de la forme "SSSS.MMM sec"
     *<LI> si mode == 'M'  chaine de caractères de la forme "MMMMMM millisec"
     *</UL>
     *@return La durée sous la forme d'une chaine de caractères.
     *La méthode utilise la méthode privé enJHMS() pour extraire dans un tableau d'entiers
     *séparément le nombre de jours, le nombre d'heures, le nombre de minutes, le nombre de
     *secondes et le nombre de millisecondes que contient la durée courante(leTemps).
     */
    public java.lang.String enTexte(char mode){
       String resp = "";
        switch (mode) {
            case 'J':
                resp= (String) ""+this.enJHMS()[0]+" jours "+this.enJHMS()[1]+" h";
                System.out.println("case J:"+resp);
                break;
            case 'H':
                int nbHeures = this.enJHMS()[1] + (this.enJHMS()[0]*24);
                resp=""+nbHeures+":"+this.enJHMS()[2]+":"+this.enJHMS()[3];
                System.out.println("case H:"+resp);
                break;
            case 'S':
                int nbSecondes = this.enJHMS()[3] + this.enJHMS()[2]*60 + this.enJHMS()[1]*3600 + this.enJHMS()[0]*3600*24;
                resp=""+nbSecondes+"."+this.enJHMS()[4]+" sec";
                System.out.println("case S:"+resp);
                break;
            case 'M':
                int nbMillisecondes = this.enJHMS()[4] + this.enJHMS()[3]*1000 + this.enJHMS()[2]*60000 + this.enJHMS()[1]*3600000 + 
                this.enJHMS()[0]*3600000*24;
                resp=""+nbMillisecondes+" millisec";
                System.out.println("case M:"+resp);
                break;
            default:
                resp = "Mode entré non correct : choisissez parmi J, H, S,M";
                break;
        }
        return resp;
    }

    /**
     *Modificateur qui ajoute une durée à la durée courante.
     *@param autreDuree durée à rajouter.
     */
    public void ajoute(Duree autreDuree){
        this.leTemps += autreDuree.getLeTemps();
    }

    /**
     *Méthode privée qui effectue un découpage de la durée courante en intervalles(jours,heures,minutes,secondes,millisecondes).
     *La durée courant (leTemps) est analysée pour fabriquer un tableau d'entiers (taille 5) 
     *dont chaque élément a la signification suivante:
     *<UL>
     *<LI> ret[0] contient le nombre de jours
     *<LI> ret[1] contient le nombre d'heures (24h)
     *<LI> ret[2] contient le nombre de minutes (60min)
     *<LI> ret[3] contient le nombre de secondes (60s)
     *<LI> ret[4] contient le nombre de millisecondes (1000millisec)
     *</UL>
     *@return un tableau d'entiers
     */
    private int[] enJHMS(){
        int jours= (int) Math.floor(this.leTemps/86400000);
        //reste1 = nb de millisec restant une fois le nombre de jours retiré//
        int reste1 = (int) this.leTemps - (jours*86400000);
        int heures = (int) Math.floor(reste1/3600000);
        //reste2 = nb de millisec restant une fois le nombre de jours et heures retirés//
        int reste2 =  reste1 - (heures*3600000);
        int minutes= (int) Math.floor(reste2/60000);
        //reste3 = nb de millisec restant une fois le nombre de jours et heures et minutes retirés//
        int reste3 =  reste2 - (minutes*60000);
        int secondes = (int) Math.floor(reste3/1000);
        //reste4 = nb de millisec restant une fois le nombre de jours et heures et minutes et secondes retirés//
        int reste4 = reste3-(secondes*1000);
        int millisecondes= (int) reste4;
        int[] tableau = {jours, heures, minutes, secondes, millisecondes};
        return tableau;
    }
    
}