package control;
import ihm.*;
import datas.*;
import java.awt.event.*;

public class Ecouteur implements ActionListener{
    private static LecteurCD test = null;
    private FrameLectCD maF;

    public Ecouteur (FrameLectCD f){
        this.maF = f;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == maF.getOnOff()){
            test = new LecteurCD();
        	test.chargerUnCD();
            String tempsTotal = test.getCD().getDureeTotale().enTexte('H');
            maF.getTime().setText(tempsTotal);
            String nomAlbum = test.getCD().getLInterpreteCD();
            maF.getNomAlbum().setText(nomAlbum);
            int numPlage = test.getCD().getNbrePlages();
            maF.getNumPlage().setText(Integer.toString(numPlage));
        }
        
        else if (e.getSource() == maF.getPlay()) {
            test.play();
            int indexPlageCourante = test.getIndexCourant();
            indexPlageCourante = test.getIndexCourant();
        	maF.getWest().setText(Integer.toString(indexPlageCourante));
        	String infoChansonCourante = test.getPlageCourante().getLeTitre();
        	maF.getCenter().setText(infoChansonCourante);
        	String infoDureeChansonEnCours = test.getCD().getUnePlage(indexPlageCourante).getLaDuree().enTexte('H');
            maF.getEast().setText(infoDureeChansonEnCours);
        }

        else if (e.getSource() == maF.getNext()) {
        	int indexPlageCourante = test.getIndexCourant();
        	if(indexPlageCourante < test.getNbrePlages()){
        	    test.next();
        	    indexPlageCourante = test.getIndexCourant();
        	    maF.getWest().setText(Integer.toString(indexPlageCourante));
        	    String infoChansonCourante = test.getPlageCourante().getLeTitre();
        	    maF.getCenter().setText(infoChansonCourante);
        	    String infoDureeChansonEnCours = test.getCD().getUnePlage(indexPlageCourante).getLaDuree().enTexte('H');
                maF.getEast().setText(infoDureeChansonEnCours);
        	}
        }

        else if (e.getSource() == maF.getPrevious()) {
        	int indexPlageCourante = test.getIndexCourant();
        	if(indexPlageCourante <= test.getNbrePlages() && indexPlageCourante >1) {
        	    test.previous();
    		    indexPlageCourante = test.getIndexCourant();
                maF.getWest().setText(Integer.toString(indexPlageCourante));
                String infoChansonCourante = test.getPlageCourante().getLeTitre();
                maF.getCenter().setText(infoChansonCourante);
                String infoDureeChansonEnCours = test.getCD().getUnePlage(indexPlageCourante).getLaDuree().enTexte('H');
                maF.getEast().setText(infoDureeChansonEnCours);
        	}
        
        }
        
        else if(e.getSource() == maF.getStop()){
    	test.setDecharger();
    	test.stop();
   	 	maF.getWest().setText("");
   	 	maF.getCenter().setText("");
   	 	maF.getEast().setText("");
        }
    }
}