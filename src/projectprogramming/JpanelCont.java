/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramming;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author mattiachenet
 */
class JpanelCont extends JPanel{
    Jcontainer image;

    public JpanelCont(File file) throws IOException {
        //setSize(200,80);
        setLayout(new GridLayout(1,1));
        //setBorder(BorderFactory.createLineBorder(Color.black));
        image = new Jcontainer();
        
        image.getImage(file);
        
        add(image);
        
        //repaint();
    }

    
   
    
}
