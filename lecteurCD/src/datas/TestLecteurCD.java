package datas;

public class TestLecteurCD{
  public static void main(String[]args){
    TestLecteurCD();
  
}

private static void TestLecteurCD(){

        System.out.println("***********TestLecteurCD()***********");

        LecteurCD lectcd1 = new LecteurCD();
        lectcd1.chargerUnCD();

        if(lectcd1.getCD().getLeTitreCD().equals("TitreCD ") && lectcd1.getCD().getLInterpreteCD().equals(" InterpreteCD") 
        && lectcd1.getCD().getUnePlage(1).getLeTitre().equals("Chanson1 ") 
        && lectcd1.getCD().getUnePlage(1).getLInterprete().equals(" Interprete ") && lectcd1.getCD().getUnePlage(1).getLaDuree().getLeTemps()==5000
        && lectcd1.getCD().getUnePlage(2).getLeTitre().equals("Chanson2 ") && lectcd1.getCD().getUnePlage(2).getLInterprete().equals(" Interprete2 ") 
        && lectcd1.getCD().getUnePlage(2).getLaDuree().getLeTemps()==111000){
          System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }
    }
}