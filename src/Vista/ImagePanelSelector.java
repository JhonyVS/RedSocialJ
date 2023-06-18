/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author Usuario
 */
public class ImagePanelSelector extends ImagePanel{
    private JButton selector;
    private JFileChooser selectorImagen;
    public ImagePanelSelector() {
        super();
        initComponents();
    }

    private void initComponents() {
        selector = new JButton("Cambiar");
        selectorImagen = new JFileChooser(new File(System.getProperty("user.dir")+"//"+"src/img/"));
        selectorImagen.setFileSelectionMode(0);
        selector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int s = selectorImagen.showOpenDialog(new ShadowPanel()); 
                if(s == JFileChooser.APPROVE_OPTION){ 
                    file = selectorImagen.getSelectedFile(); 
                    System.out.println(file.getPath()); 
                    fondo =new ImageIcon(file.getPath()).getImage(); 
                    repaint(); 
                }
                
            }           
        });
        selector.setBounds(0,0,90,25);
        this.add(selector);
    }
    public String getFilePath(){
        return file.getPath();
    }
    public void reducirBoton(){
        selector.setSize(20,10);
    }

    public String getDir() {
        String res = getFilePath();
        while(!res.startsWith("src\\img\\")){
            res = res.substring(1);
        }
        res = res.substring(8);
        return res;
    }
}
