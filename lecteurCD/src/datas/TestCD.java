package datas;
import java.io.IOException;

public class TestCD{

    public static void main(String[]args) throws IOException{
    
        // Test du Constructeur
        // testCD1();
        // Test du second Constructeur
        //testCD2();
        // Test getDureeTotale
        testGetDureeTotale();
        // // Test getLeTitreCD()
        testGetLeTitreCD();
        // // Test getLInterpreteCD()
        testGetLInterpreteCD();
        // // Test getNbrePlages()
        testGetNbrePlages();
        // // Test getUnePlage(int index)
        testGetUnePlage();
    }

    /*
    private static void testCD2() throws IOException{

        System.out.println("***********Test Constructeur***********");

        CD cd = new CD("../src/datas/CDTest.txt");
        Plage p1= CD.lesPlages.get(0);
        Duree d1 = p1.getLaDuree();
        long temps1 = d1.getLeTemps();
        String t1 = p1.getLeTitre();
        String i1 = p1.getLInterprete();

        Plage p2= CD.lesPlages.get(1);
        Duree d2 = p2.getLaDuree();
        long temps2 = d2.getLeTemps();
        String t2 = p2.getLeTitre();
        String i2 = p2.getLInterprete();

        if (cd.leTitreCD.equals("TitreCD ") && cd.lInterpreteCD.equals(" InterpreteCD") && temps1==5000 && t1.equals("Chanson1 ") &&
        i1.equals(" Interprete ")
        && temps2==111000 && t2.equals("Chanson2 ") && i2.equals(" Interprete2 ")){
          System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }
    }*/

    private static void testGetDureeTotale()throws IOException{

        System.out.println("***********Test getDureeTotale()***********");

        CD cd = new CD("../src/datas/CDTest.txt");
        if ((cd.getDureeTotale()).getLeTemps()==116000){
            System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }

    }

    private static void testGetLeTitreCD() throws IOException{
        
        System.out.println("***********Test getLeTitreCD()***********");

        CD cd = new CD("../src/datas/CDTest.txt");
        if ((cd.getLeTitreCD().equals("TitreCD "))){
            System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }

    }

    private static void testGetLInterpreteCD() throws IOException{

        System.out.println("***********Test getLInterpreteCD()***********");
        CD cd = new CD("../src/datas/CDTest.txt");
        if ((cd.getLInterpreteCD().equals(" InterpreteCD"))){
            System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }
    }

    private static void testGetNbrePlages() throws IOException{

        System.out.println("***********Test getNbrePlages()***********");
        CD cd = new CD("../src/datas/CDTest.txt");
        if ((cd.getNbrePlages()==2)){
            System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }
    }

    private static void testGetUnePlage() throws IOException{
        System.out.println("***********Test getUnePlage(index)***********");
        CD cd = new CD("../src/datas/CDTest.txt");
        if (cd.getUnePlage(1).getLaDuree().getLeTemps()==5000 && cd.getUnePlage(2).getLaDuree().getLeTemps()==111000
        && cd.getUnePlage(1).getLeTitre().equals("Chanson1 ") && cd.getUnePlage(2).getLeTitre().equals("Chanson2 ")
        && cd.getUnePlage(1).getLInterprete().equals(" Interprete ")&& cd.getUnePlage(2).getLInterprete().equals(" Interprete2 ")){
            System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }
    }
}




