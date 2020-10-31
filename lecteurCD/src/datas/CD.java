package datas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CD extends java.lang.Object{
    
    /**
     * Le tableau contenant toutes les plages du CD
     */
    private java.util.ArrayList<Plage> lesPlages;

    /**
     * Le titre du CD
     */
    private java.lang.String leTitreCD;

    /**
     * L'Interprète du CD
     */
    private java.lang.String lInterpreteCD;

    
    /**
     * Construction d'un CD.
     * Cette construction se fait à partir d'un fichier texte qui contient toutes les informations:
     *<UL>
     *<LI>le titre et l'interprète du CD
     *<LI>les différentes plages au format TitrePlage / InterprètePlage / Xmin. / Ysec.
     *<LI>La méthode privée "graverCD (String leFich)" effectue la lecture du fichier texte.
     *</UL>
     * @param leFich le nom du fichier texte à lire
     */
    public CD(java.lang.String leFich){
        graverCD(leFich);
    }

    /**
     * Construction d'un CD.
     * Cette construction se fait en 2 temps:
     * 1. d'abord il y a création d'un CD vierge
     * 2. ensuite il sera gravé(ajout de plages) par appel de la méthode privée "graverCD()"
     * @param interpreteCD interprète CD
     * @param titreCD titre CD
     */
    public CD(java.lang.String interpreteCD, java.lang.String titreCD){
        this.lInterpreteCD=interpreteCD;
        this.leTitreCD=titreCD;
        graverCD();
    }

    /**
     * Accesseur qui calcul et renvoie la durée totale du CD.
     * @return la durée totale.
     */
    public Duree getDureeTotale(){
        Duree resp= new Duree(0);
        for (int i=0; i<this.lesPlages.size();i++){
            resp.ajoute((this.lesPlages.get(i)).getLaDuree());
        }
        return resp;
    }

    /**
     * Accesseur qui renvoie le titre du CD.
     * @return le titre du CD
     */
    public java.lang.String getLeTitreCD(){
        return this.leTitreCD;
    }

    /**
     * Accesseur qui renvoie le(les) interprètes du CD.
     * @return le (les) interprètes
     */
    public java.lang.String getLInterpreteCD(){
        return this.lInterpreteCD;
    }

    /**
     * Accessuer qui renvoie le nombre de plages gravées sur le CD.
     * @return le nombre total de pages
     */
    public int getNbrePlages(){
        return this.lesPlages.size();
    }

    /**
     * Accesseur qui renvoie la plage n°index du CD
     * !!la première plage CD est à l'index = 1
     * @param index - le numéro de la page
     * @return la plage qui se trouve à l'emplacement( index-1) dans le tableaux des plages
     */
    public Plage getUnePlage(int index){
        return this.lesPlages.get(index-1);
    }


    /**
     * Méthode privée qui grave le CD. UN certain nombre de plages sont ajoutées au CD. 
     *Dans cette version simplifiée, les plages sont créées et ajoutées "à la main" au CD.
     */
    private void graverCD(){
        this.lesPlages = new java.util.ArrayList<Plage>();
        Plage p1 = new Plage(new Duree(15000),"the adventure","AVA");
    	Plage p2 = new Plage(new Duree(16000),"A little is enough", "AVA");
    	Plage p3 = new Plage(new Duree(18000),"It hurts", "AVA");
    	Plage p4 = new Plage(new Duree(19000),"The machine", "AVA");
    	Plage p5 = new Plage(new Duree(20000),"Good day", "AVA");
    	this.lesPlages.add(p1);
    	this.lesPlages.add(p2);
        this.lesPlages.add(p3);
        this.lesPlages.add(p4);
        this.lesPlages.add(p5);

    }

    private String readFile(String pathname){

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());        
    
        try (java.util.Scanner scanner = new java.util.Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine());
            }
            return fileContents.toString();
        }
        catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * Méthode privée qui grave le CD à partir d'un fichier. On donne un titre et un interprète au CD de même qu'une listes de plages. Les informations sont lues à partir d'un fichier texte.
     *
     * Le fichier est sous le format suivant : 
     *<UL>
     *<LI>titreCD/interpreteCD
     *<LI>titrePlage/interpretePlage/Xmin/Ysec (plage 1)
     *<LI>titrePlage/interpretePlage/Xmin/Ysec (plage n)
     *</UL>
     * @param leFich  le nom du fichier texte à lire
     */
    private void graverCD(java.lang.String leFich){
        String contenuLeFich="";
        contenuLeFich = readFile(leFich);
        //split divise la chaine en un ensemble de mots //
        //s'il y a un "/" et les mets dans un tableau infosCD //
        String[] infosCD = contenuLeFich.split("/");
        this.leTitreCD = infosCD[0];
        this.lInterpreteCD = infosCD[1];
        java.util.ArrayList<Plage> tmp_Plages = new java.util.ArrayList<Plage>();
        for(int i=2; i<(infosCD.length-3); i=i+4){
            Duree di = new Duree(0, Integer.parseInt(infosCD[i+2]), Integer.parseInt(infosCD[i+3]));
            Plage pi = new Plage(di, infosCD[i], infosCD[i+1]);
            tmp_Plages.add(pi);
        }
        this.lesPlages=tmp_Plages;
    }
}