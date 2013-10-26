
/**
 * Write a description of class SlikaSplit here.
 * 
 * @author Martin Turk, Andrej Okoliš, Luka Žaren 
 * @version (a version number or a date)
 */
import javax.imageio.ImageIO;  
import java.awt.image.BufferedImage;  
import java.io.*;  
import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class SlikaSplit
{
    public static void main(String[] args) throws IOException  {  

        JFrame frame = new JFrame("Test");
        JPanel panel = new JPanel();
        JButton b[] = new JButton[25];
        List<Integer> list = new ArrayList();

        frame.setBounds(300,300,800,630);
        panel.setLayout(new GridLayout(5,5,0,0));

        for (int i = 0; i < b.length; i++){
            b[i] = new ActionButton();
            panel.add(b[i]);
        }

        File file = new File("brabus.jpg"); // I have bear.jpg in my working directory  
        FileInputStream fis = new FileInputStream(file);  
        BufferedImage image = ImageIO.read(fis); //reading the image file  

        int rows = 5; //You should decide the values for rows and cols variables  
        int cols = 5;  
        int chunks = rows * cols;  

        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height  
        int chunkHeight = image.getHeight() / rows;  
        int count = 0;  
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks  
        for (int x = 0; x < rows; x++) {  
            for (int y = 0; y < cols; y++) {  
                //Initialize the image array with image chunks  
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());  

                // draws the image chunk  
                Graphics2D gr = imgs[count++].createGraphics();  
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
                gr.dispose();  

            }  
        }  
        System.out.println("Splitting done");  

        for (int i = 0; i < b.length; i++ ){
            list.add(i);
        }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        for (Integer i : list){
            BufferedImage scaledImage = new BufferedImage(chunkWidth, chunkHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            graphics2D.drawImage(imgs[i], 0, 0, chunkWidth, chunkHeight, null);
            graphics2D.dispose();
            ImageIcon myIcon = new ImageIcon(scaledImage);

            b[list.get(i)].setIcon(myIcon);
            b[i].addActionListener(new ActionButton());
            //b[i].add(new Action(imgs[i]));
            
            

        }

        //         for (int i = 0; i < 25; i++){
        //             BufferedImage scaledImage = new BufferedImage(chunkWidth, chunkHeight, BufferedImage.TYPE_INT_RGB);
        //             Graphics2D graphics2D = scaledImage.createGraphics();
        //             graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
        //             graphics2D.drawImage(imgs[i], 0, 0, chunkWidth, chunkHeight, null);
        //             graphics2D.dispose();
        //             ImageIcon myIcon = new ImageIcon(scaledImage);
        // 
        //             //             b[i].setIcon(myIcon);
        // 
        //         }

        
        
        
        
        frame.add(panel);
        
        frame.setVisible(true);
        
        
    
    }
}