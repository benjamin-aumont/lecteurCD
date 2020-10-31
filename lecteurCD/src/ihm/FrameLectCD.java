package ihm;
import datas.*;
import control.*;
import javax.swing.*;
import java.awt.*;


public class FrameLectCD extends JFrame{

    JButton onOff;
    JButton stop;
    JButton play;
    JButton next;
    JButton previous;
    JLabel tempsTotal;
    JLabel nombreDePlage;
    JTextField nomAlbum;
    JTextField time;
    JTextField numPlage;
    JTextField west;
    JTextField center;
    JTextField east;
    LecteurCD monLect = new LecteurCD();

    public FrameLectCD (String titre){
        super(titre);
        miseEnPlaceDecor();
        this.setSize(600,400);
        this.setVisible(true);
        this.attacherReactions();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void miseEnPlaceDecor(){
        this.setLayout(new GridLayout(1,2));
        JPanel panelPics = new JPanel();
        this.add(panelPics);
        panelPics.setLayout(new GridLayout(3,1));
        // 1er bloc
        JPanel panelA = new JPanel();
        panelPics.add(panelA);
        panelA.setLayout(new GridLayout(1,2));
        //1er sous bloc du 1er bloc
        JPanel sousPanel = new JPanel();
        sousPanel.setLayout(new GridLayout(3,1));
        onOff = new JButton("ChargerCD - on");
        sousPanel.add(onOff);
        tempsTotal = new JLabel("Temps total");
        sousPanel.add(tempsTotal);
        nombreDePlage = new JLabel("Nombre de plages");
        sousPanel.add(nombreDePlage);
        panelA.add(sousPanel);
        //2eme sousbloc du 1er bloc
        JPanel sousPanel2 = new JPanel();
        sousPanel2.setLayout(new GridLayout(3,1));
        nomAlbum = new JTextField("");
        sousPanel2.add(nomAlbum);
        time = new JTextField("");
        sousPanel2.add(time);
        numPlage = new JTextField("");
        sousPanel2.add(numPlage);
        numPlage.setBackground(Color.cyan);
        time.setBackground(Color.cyan);
        panelA.add(sousPanel2);
        // 2eme bloc
        JPanel panelB = new JPanel();
        panelB.setLayout(new BorderLayout());
        west = new JTextField("");
        west.setPreferredSize( new Dimension( 100, 400 ) );
        panelB.add( west, BorderLayout.WEST );
        center = new JTextField("");
        center.setPreferredSize( new Dimension( 400, 400 ) );
        panelB.add( center, BorderLayout.CENTER );
        east = new JTextField("");
        east.setPreferredSize( new Dimension( 100, 400 ) );
        panelB.add( east, BorderLayout.EAST );
        west.setBackground(Color.yellow);
        center.setBackground(Color.yellow);
        east.setBackground(Color.yellow);
        panelPics.add(panelB);
        // 3eme bloc
        JPanel panelC = new JPanel();
        panelC.setLayout(new GridLayout(1,4));
        stop = new JButton("STOP");
        panelC.add(stop);
        play = new JButton("PLAY");
        panelC.add(play);
        next = new JButton("NEXT");
        panelC.add(next);
        previous = new JButton("PREVIOUS");
        panelC.add(previous);       
        panelPics.add(panelC);
        //photo album
        ImageIcon background=new ImageIcon("..\\src\\CDJaquette/image.jpg");
	    Image img=background.getImage();
	    background=new ImageIcon(img);
	    JLabel panelSecond=new JLabel(background);
	    this.add(panelSecond);
    }
    
    private void attacherReactions(){
        this.onOff.addActionListener(new Ecouteur(this));
        this.play.addActionListener (new Ecouteur(this));
        this.stop.addActionListener (new Ecouteur(this));
        this.next.addActionListener (new Ecouteur(this));
        this.previous.addActionListener (new Ecouteur(this));
    }

    public JButton getOnOff(){
        return this.onOff;
    }

    public JButton getStop(){
        return this.stop;
    }

    public JButton getPlay(){
        return this.play;
    }

    public JButton getNext(){
        return this.next;
    }

    public JButton getPrevious(){
        return this.previous;
    }

    public JTextField getTime(){
        return this.time;
    }
    
    public JTextField getNomAlbum(){
        return this.nomAlbum;
    }
    
    public JTextField getNumPlage(){
        return this.numPlage;
    }

    public JTextField getWest(){
        return this.west;
    }

    public JTextField getCenter(){
        return this.center;
    }

    public JTextField getEast(){
        return this.east;
    }

    public static void main(String[]args){
        FrameLectCD unLect = new FrameLectCD("Mon Lecteur");
    }


}