
/**
 * Write a description of class Action here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.image.BufferedImage;  
import javax.swing.*;
import java.awt.event.*;

public class ActionButton extends JButton implements ActionListener
{
    BufferedImage selected1;
    BufferedImage selected2;
    int nrClicked = 0;             //št. pritisnjenih gumbov

    /*public ActionButton(ImageIcon imgs){
    super(imgs);    
    addActionListener(this);
    }*/

    public ActionButton(){
        super();    
        //addActionListener(this);
    }

    //private ImageIcon i1, i2;
    void checkClk(){
        System.out.println(nrClicked);
        switch (nrClicked){
            case 0: nrClicked++;
            //this.setEnabled(false);
            break;
            case 1: 
            nrClicked=0;
            System.out.println("dva");
            break;
        }
        

        /*if (nrClicked == 2){
        nrClicked=0;
        } else

        if (nrClicked == 1){
        selected2 = this;
        nrClicked++;
        System.out.println("dva");
        } else

        if (nrClicked == 0){
        selected1 = this;
        nrClicked++;
        }*/

    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        //checkClk();
        JButton source = (JButton)e.getSource();
        System.out.println(source);
        
        
        }
            
        //this.setEnabled(false);
        /*try {
            Image img1 = ImageIO.read(this.getClass().getResource("selected1"));
            Image img2 = ImageIO.read(this.getClass().getResource("selected2"));

            i1 = new ImageIcon(img1);
            i2 = new ImageIcon(img2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        addActionListener(this);
        setIcon(i1);
        System.out.println(e);*/
    }