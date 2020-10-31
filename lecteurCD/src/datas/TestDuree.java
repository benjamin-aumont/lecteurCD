package datas;
public class TestDuree{
    public static void main(String[]args){

        //Test Constructeur Duree(millisec)//
        testDuree1();
        // Test Constructeur Duree(heures, minutes, secondes) //
        testDuree2();
        // Test Constructeur Duree(autreDuree) //
        testDuree3();
        // Test accesseurs getLeTemps //
        testGetLeTemps();
        // Test de la méthode compareA(autreDuree) //
        testCompareA();
        // Test de la Méthode ajoute(Duree) //
       testAjoute();
        // Test de la Méthode enTexte(mode) //
        testEnTexte();
    }
    
    private static void testDuree1(){

        System.out.println("***********Test cas normal***********");

        Duree d1 = new Duree(1500);
        long temps1 = d1.getLeTemps();
        if (temps1==1500){
          System.out.println("Test réussi");  
        }
        else{
          System.out.println("Echec du Test");  
        }

        System.out.println("***********Test cas erreur***********");  

        Duree d2 = new Duree(-150);
        long temps2 = d2.getLeTemps();
        if (temps2!=-150){
          System.out.println("Test OK : impossible durée négative");  
        }
        else {
          System.out.println("Test non ok");  
        }

        System.out.println("***********Test cas limite***********");  

        Duree d3 = new Duree(0);
        long temps3 = d3.getLeTemps();
        if (temps3==0){
          System.out.println("Test non OK");  
        }
        else {
          System.out.println("Test ok");  
        }

    }

    private static void testDuree2(){

      System.out.println("***********Test cas normal***********");

      Duree d1 = new Duree(1500);
      long temps1 = d1.getLeTemps();
      if (temps1==1500){
        System.out.println("Test réussi");  
      }
      else{
        System.out.println("Echec du Test");  
      }

      System.out.println("***********Test cas erreur***********");

      Duree d2 = new Duree(-150);
      long temps2 = d2.getLeTemps();
      if (temps2!=-150){
        System.out.println("Test OK: impossible durée négative");  
      }
      else {
        System.out.println("Test non ok");  
      }

      System.out.println("***********Test cas limite***********");

      Duree d3 = new Duree(0);
      long temps3 = d3.getLeTemps();
      if (temps3==0){
        System.out.println("Test  non OK : impossible durée négative ou nulle");  
      }
      else {
        System.out.println("Test ok");  
       }
    }

    private static void testDuree3(){
      Duree d1 = new Duree(1, 30, 30);
      long temps1 = d1.getLeTemps();
      if (temps1==5430000){
        System.out.println("Test réussi");  
      }
      else{
        System.out.println("Echec du Test");  
      }

      System.out.println("***********Test cas erreur***********");

      Duree d2 = new Duree(1, 300, 1000);
      long temps2 = d2.getLeTemps();
      if (temps2!=22600000){
        System.out.println("Test OK");
      }
      else{
        System.out.println("Echec tu test : revoir constructeur durée3");
      }

      Duree d20 = new Duree(1, -30, 200);
      long temps20 = d20.getLeTemps();
      if (temps20<=0){
        System.out.println("Test OK");
      }
      else{
        System.out.println("Echec tu test : revoir constructeur durée3");
      }
      

      System.out.println("***********Test cas limite***********");

      Duree d3 = new Duree(0);
      long temps3 = d3.getLeTemps();
      if (temps3==0){
        System.out.println("test non OK impossible durée négative ou nulle : gérer l'erreur");  
      }
      else {
        System.out.println("Test ok");  
       }

    }

    private static void testGetLeTemps(){

      System.out.println("***********Test getLeTemps***********");


      Duree d3 = new Duree(1500);
      long temps = d3.getLeTemps();
      if(temps==1500){
        System.out.println("Test ok");
      }
      else{
        System.out.println("Test non ok : getLeTemps fonctionne pas");
      }

    }

    private static void testCompareA(){

      System.out.println("***********Test compareA***********");

      Duree d3 = new Duree(1500); 
      Duree d2 = new Duree(4000);      
      Duree d14 = new Duree(1500);

      if(d3.compareA(d2)==-1 && d3.compareA(d14)==0 && d2.compareA(d3)==1){
        System.out.println("Test OK");
      }
      else{
        System.out.println("Echec Test : methode comparA défaillante");
      }

      
    }

    private static void testAjoute(){
      System.out.println("***********Test testAjoute()***********");

      Duree d8 = new Duree(400);
      Duree d9 = new Duree(400);
      d8.ajoute(d9);
      long temps8 = d8.getLeTemps();

      if (temps8==800){
        System.out.println("Test réussi");
      }
      else{
        System.out.println("Echec Test : methode ajoute() défaillante");
      }
    }

    private static void testEnTexte(){

      System.out.println("***********Test enTexte(mode)***********");

      Duree d10 = new Duree(215777450); //2jours, 11h, 56min, 17sec, 450msec
      
      if (d10.enTexte('J').equals("2 jours 11 h")){
        System.out.println("Test J réussi");
      }
      else{
        System.out.println("Echec Test : methode enTexte(J) défaillante");
      }

      if (d10.enTexte('H').equals("59:56:17")){
        System.out.println("Test H réussi");
      }
      else{
        System.out.println("Echec Test : methode enTexte(H) défaillante");
      }

      if (d10.enTexte('S').equals("215777.450 sec")) {
        System.out.println("Test S réussi");
      }
      else{
        System.out.println("Echec Test : methode enTexte(S) défaillante");
      }

      if (d10.enTexte('M').equals("215777450 millisec")){
        System.out.println("Test M réussi");
      }
      else{
        System.out.println("Echec Test : methode enTexte(M) défaillante");
      }


    }

}
