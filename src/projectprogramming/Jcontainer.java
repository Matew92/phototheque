/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mattiachenet
 */
class Jcontainer extends JComponent{

    
    boolean flip = false;
    boolean annotation = false;
    BufferedImage picture;
    Point pixel;
    ArrayList<Point> p = new ArrayList<Point>();

    public Jcontainer() {
        super();
        //setSize(200,80);
        
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            if(flip){
//                pixel = new Point();
//                
//                p.add(pixel);
//                pixel = e.getPoint();
//                annotation = true;
                //repaint();
                
                Graphics g = getGraphics();

        
        g.setColor(Color.black);
        Point p = e.getPoint();
        g.fillRect(p.x,p.y,1,1);

        g.dispose();
        
        repaint();
            }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
        
            
            
            }
        });
        
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(e.getClickCount()>1){
                     if(!flip)
                         flip = true;
                     else 
                         flip = false;
                     repaint();
            } 
                
                                        
                                    
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    
            
    public void getImage(File image) throws IOException {
        picture = ImageIO.read(image);
        flip = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(!flip){
           g.drawImage(picture, 0, 0, null);
           //System.out.print("passatoPIc");
        }
        else{
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, super.getHeight(), super.getWidth());
            //System.out.print("passatoflip");
        }
        
        if(annotation && flip){
           
//            g.setColor(Color.BLACK);
//            for(int i=0; i<p.size();i++){
//                 g.drawLine( p.get(i).x, p.get(i).y,p.get(i).x , p.get(i).y);
//            }
           
            
        }
    }
    
    
    
    
}
