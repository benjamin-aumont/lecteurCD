package datas;
public class TestPlage {

    public static void main(String[]args){

        //Test Constructeur Plage //
        testPlage();
        //Test getLaDuree()/ getLeTitre() / getLInterprete //
        testAllGet();        
        //Test setLaDuree() //
        testSetLaDuree();
        //Test setLeTitre() //
        testSetLeTitre();
        //Test setLInterprete //
        testSetLInterprete();
        //Test getFicheComplete() //
        testGetFicheComplete();
        //Test toString(); //
        testToString();    
    }

    private static void testPlage(){
        System.out.println("***********Test cas normal***********");
        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        Duree duree1 = p1.getLaDuree();
        long temps1 = duree1.getLeTemps();
        String titre1 = p1.getLeTitre();
        String interprete1 = p1.getLInterprete();
        if (temps1==10000 && titre1.equals("titre") && interprete1.equals("interprete")){
          System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }

       /*System.out.println("***********Test cas erreur***********");  
        Duree d2 = new Duree(10000);
        Plage p2 = new Plage(d2,"","");
        Duree duree2 = p2.getLaDuree();
        long temps2 = duree2.getLeTemps();
        String titre2 = p2.getLeTitre();
        String interprete2 = p2.getLInterprete();
        if (temps2 != -10000 && !titre2.equals("") && !interprete2.equals("")){
          System.out.println("Test OK");  
        }
        else {
          System.out.println("Test non ok");  
        }*/
    }

    private static void testAllGet(){

        System.out.println("***********Test getLaDuree/getLeTitre/getLInterprete***********");
        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        Duree duree1 = p1.getLaDuree();
        long temps1 = duree1.getLeTemps();
        String titre1 = p1.getLeTitre();
        String interprete1 = p1.getLInterprete();

        if(temps1==10000 && titre1.equals("titre") && interprete1.equals("interprete")){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test non OK");
        }
    }

    private static void testSetLaDuree(){

        System.out.println("***********Test setLaDuree***********");

        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        Duree d2 = new Duree(15000);
        p1.setLaDuree(d2);
        Duree duree1 = p1.getLaDuree();
        long temps1 = duree1.getLeTemps();
        
        if(temps1==15000){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test non OK");
        }
    }

    private static void testSetLeTitre(){

        System.out.println("***********Test setLeTitre***********");

        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        Duree duree1 = p1.getLaDuree();
        p1.setLeTitre("nouveauTitre");

        if(p1.getLeTitre().equals("nouveauTitre")){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test non OK");
        }
    }

    private static void testSetLInterprete(){

        System.out.println("***********Test setLInterprete***********");

        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        Duree duree1 = p1.getLaDuree();
        p1.setLInterprete("nouveauInterprete");

        if(p1.getLInterprete().equals("nouveauInterprete")){
            System.out.println("Test OK");
        }
        else{
            System.out.println("Test non OK");
        }
    }

    private static void testGetFicheComplete(){

        System.out.println("***********Test getFicheComplete()***********");

        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        if (p1.getFicheComplete().equals("Titre: titre"+'\n'+"Interprète: interprete"+'\n'+"Durée: 0:0:10")){
            System.out.println("Test OK");
        }
        else {
            System.out.println("Test non OK");
        }
    }

    private static void testToString(){
    
        System.out.println("***********Test toString()***********");
        Duree d1 = new Duree(10000);
        Plage p1 = new Plage(d1, "titre", "interprete");
        String newLine = System.getProperty("line.separator");
        if (p1.toString().equals("titre - interprete - 10.0 sec")){
            System.out.println("Test OK");
        }
        else {
            System.out.println("Test non OK");
        }
    }
}