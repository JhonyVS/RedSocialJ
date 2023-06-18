/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Graphics;
import java.awt.Image; 
import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class ImagePanel extends ShadowPanel{
    protected Image fondo;
    protected File file;

    public ImagePanel() {
        super();
    }
    @Override
    public void paint(Graphics g){     
        g.drawImage(fondo,0,0, null);  
        super.paint(g);
    }

    public void setBackgroundImage(String img) {
        try {
            URL imgURL = getClass().getResource("/img/"+img);
            file = new File(System.getProperty("user.dir")+"//"+"src/img/"+img);
            fondo = (new ImageIcon(imgURL)).getImage();
            
        } catch (Exception e) {
            System.out.println("No se encontro la imagen");
        }
    }
    public Icon getIcon(){
        return new ImageIcon(fondo);
    }
    public void setBackgroundImageResource(String img) {
        try {
            URL imgURL = getClass().getResource("/resource/"+img);
            file = new File(System.getProperty("user.dir")+"//"+"src/resource/"+img);
            fondo = (new ImageIcon(imgURL)).getImage();
            
        } catch (Exception e) {
            System.out.println("No se encontro la imagen");
        }
    }
}
