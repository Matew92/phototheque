/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author mattiachenet
 */
public class ProjectProgramming extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new ProjectProgramming();
    }

    public ProjectProgramming() {
        JFrame window = new setWindow();
        window.setSize(400, 400);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Dimension frameSize = window.getSize();
        
         if(frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
         if(frameSize.width > screenSize.width)
            frameSize.height = screenSize.width;
        
        window.setLocation((screenSize.width - frameSize.width)/2,
                (screenSize.height - frameSize.height)/2);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        
    }

    private static class setWindow extends JFrame {

        public setWindow() {
            
            //layout winodow
            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel upperPanel = new JPanel(new GridBagLayout());
            JPanel centerPanel = new JPanel(new GridBagLayout());
            JPanel bottomPanel = new JPanel(new GridBagLayout());
            JToggleButton familyBtn = new JToggleButton("Family");
            JToggleButton vacaionBtn = new JToggleButton("Vacation");
            JToggleButton schoolBtn = new JToggleButton("School");
            
            GridBagConstraints lim = new GridBagConstraints();
            
            bottomPanel.setBackground(Color.white);
         
            final JLabel status = new JLabel("status");
            
            JMenuBar menubar = new BuiltMenu(status, this);
            
            //bottomBar
            
            lim.gridx = 1;
            lim.gridy = 0;
            bottomPanel.add(status,lim);
            
            //upperBar
            
            lim.gridx = 1;
            lim.gridy = 0;
            upperPanel.add(familyBtn,lim);
            lim.gridx = 2;
            lim.gridy = 0;
            upperPanel.add(vacaionBtn,lim);
            lim.gridx = 3;
            lim.gridy = 0;
            upperPanel.add(schoolBtn,lim);
            
      
            
            
            mainPanel.add(upperPanel,BorderLayout.NORTH);
            mainPanel.add(centerPanel,BorderLayout.CENTER);
            mainPanel.add(bottomPanel,BorderLayout.SOUTH);
            
                    
            this.setJMenuBar(menubar);
            this.setContentPane(mainPanel);
            
                    
                
            
        }
    }

    private static class BuiltMenu extends JMenuBar {
        
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    JFileChooser filechooser;

        public BuiltMenu(final JLabel label,final JFrame winodw) {
            
            
            filechooser = new JFileChooser();
            menu = new JMenu("File");
            menuItem = new JMenuItem("Import",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
            menuItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Select Import");
                    
                    int returnVal = filechooser.showOpenDialog(winodw);
                    if (returnVal == filechooser.APPROVE_OPTION) {
                        java.io.File file = filechooser.getSelectedFile();
                        label.setText("File Selected :" + file.getName());
                    }
                    else{
                        label.setText("Open command cancelled by user." );
                    }
                }
            });
            
            menu.add(menuItem);
            menuItem = new JMenuItem("Delete",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("Delete a photo");
            menuItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Not yet implemented!");
                }
            });
            menu.add(menuItem);
            menuItem = new JMenuItem("Quit",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("Quit program");
            menuItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Quitting...");
                    System.exit(0);
                }
            });
            menu.add(menuItem);
            this.add(menu);
            
            menu = new JMenu("View");
            ButtonGroup group = new ButtonGroup();
            rbMenuItem = new JRadioButtonMenuItem("Photo viewer");
            rbMenuItem.setSelected(true);
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);
            rbMenuItem = new JRadioButtonMenuItem("Browser");
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);
            rbMenuItem = new JRadioButtonMenuItem("Split mode");
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);
            this.add(menu);
        }
    }
    
    
}
