/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    boolean type= false;
    BufferedImage picture;
    Point pixel;
    ArrayList<Point> p = new ArrayList<Point>();
    ArrayList<Character> c = new ArrayList<>();
    Point pnt = new Point();

    public Jcontainer() {
        super();
        
        this.setFocusable(true);
        
        //setSize(200,80);
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if(type){
                    c.add(e.getKeyChar());
                    repaint();
                }
                
                
           
            
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
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
                

        
        Point pt = e.getPoint();
        p.add(pt);
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
            } else if(e.getClickCount()== 1){
                
                if(!type){
                    type = true;
                    pnt = e.getPoint();
                }else{
                    type = false;
                }
                 repaint();
                 requestFocus();
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
            g.fillRect(0, 0, picture.getHeight(), picture.getWidth());
            g.setColor(Color.BLACK);
            if(p.size()>0){
                for(int i = 0; i<p.size();i++){
                    if(i!=0){
                        g.drawLine(p.get(i-1).x, p.get(i-1).y, p.get(i).x, p.get(i).y);
                    }
                    else{
                        g.drawLine(p.get(i).x, p.get(i).y, p.get(i).x, p.get(i).y);
                    }
                }
            }
            if(type){
                g.drawLine(pnt.x, pnt.y, pnt.x, pnt.y-10);
                
                if(c.size()>0){
                    char[] crh = new char[c.size()];
                    for(int i = 0; i < c.size(); i++){
                        crh[i]= c.get(i);
                    }
                    g.drawChars(crh, 0, crh.length, pnt.x, pnt.y);
                }
            }else{
                if(c.size()>0){
                    char[] crh = new char[c.size()];
                    for(int i = 0; i < c.size(); i++){
                        crh[i]= c.get(i);
                    }
                    g.drawChars(crh, 0, crh.length, 20, 20);
                }
                
            }
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
