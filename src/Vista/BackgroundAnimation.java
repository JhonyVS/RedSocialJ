/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Usuario
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 * @author Romain Guy
 */
public class BackgroundAnimation extends JFrame {


  private CurvesPanel curves;
  private Timer timer;

  public BackgroundAnimation() throws HeadlessException {
    super("MyBook");

    buildContentPane();

    startAnimation();
 
    setSize(240, 78);
    setLocationRelativeTo(null);
    setUndecorated(true);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void buildContentPane() {
    JPanel pane = new JPanel();
    pane.setOpaque(false);
    pane.setLayout(new StackLayout());

    GradientPanel gradient = new GradientPanel();
    curves = new CurvesPanel();

    ImagePanel image = new ImagePanel();
    image.setBackgroundImageResource("RS2.png");
    pane.add(gradient, StackLayout.TOP);
    pane.add(image,StackLayout.TOP);
    pane.add(curves, StackLayout.TOP);

    add(pane);
  }
  private void startAnimation() {
    timer = new Timer(50, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        curves.animate();
        curves.repaint();
      }
    });
    timer.start();
  }
  public void cerrar(){
      try {
          new Thread().sleep(2000);
          timer.stop();
          new Login().setVisible(true);  
          this.dispose();
          
      } catch (Exception e) {
      }
  }
  public static void main(String[] args) {
    try {
      
        //UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
    } catch (Exception ex) {}

    SwingUtilities.invokeLater(new Runnable() {
        @Override
      public void run() {
        BackgroundAnimation tester = new BackgroundAnimation();
        tester.setVisible(true);
      }
    });
  }
}


final class CurvesPanel extends JPanel {
  protected RenderingHints hints;

  protected int counter = 0;

  protected Color start = new Color(255, 255, 255, 200);

  protected Color end = new Color(255, 255, 255, 0);

  public CurvesPanel() {
      
    this(new BorderLayout());
  }

  public CurvesPanel(LayoutManager manager) {
    super(manager);
    hints = createRenderingHints();
  }

  protected RenderingHints createRenderingHints() {
    RenderingHints renHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    renHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    renHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    return renHints;
  }

  public void animate() {
    counter++;
  }

  @Override
  public boolean isOpaque() {
    return false;
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    RenderingHints oldHints = g2.getRenderingHints();
    g2.setRenderingHints(hints);

    float width = getWidth();
    float height = getHeight();

    g2.translate(0, -30);

    drawCurve(g2, 20.0f, -10.0f, 20.0f, -10.0f, width / 2.0f - 40.0f, 10.0f, 0.0f, -5.0f,
        width / 2.0f + 40, 1.0f, 0.0f, 5.0f, 50.0f, 5.0f, false);

    g2.translate(0, 30);
    g2.translate(0, height - 60);

    drawCurve(g2, 30.0f, -15.0f, 50.0f, 15.0f, width / 2.0f - 40.0f, 1.0f, 15.0f, -25.0f,
        width / 2.0f, 1.0f / 2.0f, 0.0f, 25.0f, 15.0f, 9.0f, false);

    g2.translate(0, -height + 60);

    drawCurve(g2, height - 35.0f, -5.0f, height - 50.0f, 10.0f, width / 2.0f - 40.0f, 1.0f,
        height - 35.0f, -25.0f, width / 2.0f, 1.0f / 2.0f, height - 20.0f, 25.0f, 25.0f, 7.0f, true);

    g2.setRenderingHints(oldHints);
  }

  protected void drawCurve(Graphics2D g2, float y1, float y1_offset, float y2, float y2_offset,
      float cx1, float cx1_offset, float cy1, float cy1_offset, float cx2, float cx2_offset,
      float cy2, float cy2_offset, float thickness, float speed, boolean invert) {
    float width = getWidth();

    float offset = (float) Math.sin(counter / (speed * Math.PI));

    float start_x = 0.0f;
    float start_y = offset * y1_offset + y1;
    float end_x = width;
    float end_y = offset * y2_offset + y2;

    float ctrl1_x = offset * cx1_offset + cx1;
    float ctrl1_y = offset * cy1_offset + cy1;
    float ctrl2_x = offset * cx2_offset + cx2;
    float ctrl2_y = offset * cy2_offset + cy2;

    GeneralPath thickCurve = new GeneralPath();
    thickCurve.moveTo(start_x, start_y);
    thickCurve.curveTo(ctrl1_x, ctrl1_y, ctrl2_x, ctrl2_y, end_x, end_y);
    thickCurve.lineTo(end_x, end_y + thickness);
    thickCurve.curveTo(ctrl2_x, ctrl2_y + thickness, ctrl1_x, ctrl1_y + thickness, start_x, start_y
        + thickness);
    thickCurve.lineTo(start_x, start_y);

    Rectangle bounds = thickCurve.getBounds();
    if (!bounds.intersects(g2.getClipBounds())) {
      return;
    }

    GradientPaint painter = new GradientPaint(0, bounds.y, invert ? end : start, 0, bounds.y
        + bounds.height, invert ? start : end);

    Paint oldPainter = g2.getPaint();
    g2.setPaint(painter);
    g2.fill(thickCurve);

    g2.setPaint(oldPainter);
  }
}

/*
 * Copyright (c) 2007, Romain Guy All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. * Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. * Neither the name of the
 * TimingFramework project nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
class GradientPanel extends JPanel {
  protected BufferedImage gradientImage;

  protected Color gradientStart = new Color(0, 0, 0);

  protected Color gradientEnd = new Color(50, 50,60);

  public GradientPanel() {
    this(new BorderLayout());
  }

  public GradientPanel(LayoutManager layout) {
    super(layout);
    addComponentListener(new GradientCacheManager());
  }

  @Override
  protected void paintComponent(Graphics g) {
    createImageCache();

    if (gradientImage != null) {
      g.drawImage(gradientImage, 0, 0, getWidth(), getHeight(), null);
    }
  }

  protected void createImageCache() {
    int width = 2;
    int height = getHeight();

    if (width == 0 || height == 0) {
      return;
    }

    if (gradientImage == null || width != gradientImage.getWidth()
        || height != gradientImage.getHeight()) {

      gradientImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

      Graphics2D g2 = gradientImage.createGraphics();
      GradientPaint painter = new GradientPaint(0, 0, gradientEnd, 0, height / 2, gradientStart);
      g2.setPaint(painter);

      Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height / 2.0);
      g2.fill(rect);

      painter = new GradientPaint(0, height / 2, gradientStart, 0, height, gradientEnd);
      g2.setPaint(painter);

      rect = new Rectangle2D.Double(0, (height / 2.0) - 1.0, width, height);
      g2.fill(rect);

      g2.dispose();
    }
  }

  private void disposeImageCache() {
    synchronized (gradientImage) {
      gradientImage.flush();
      gradientImage = null;
    }
  }

  private class GradientCacheManager implements ComponentListener {
      @Override
    public void componentResized(ComponentEvent e) {
    }

      @Override
    public void componentMoved(ComponentEvent e) {
    }

      @Override
    public void componentShown(ComponentEvent e) {
    }

      @Override
    public void componentHidden(ComponentEvent e) {
      disposeImageCache();
    }
  }
}

/*
 * Copyright (c) 2007, Romain Guy All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. * Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. * Neither the name of the
 * TimingFramework project nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * 
 * @author Romain Guy <romain.guy@mac.com>
 */
class StackLayout implements LayoutManager2 {
  public static final String BOTTOM = "bottom";

  public static final String TOP = "top";

  private List<Component> components = new LinkedList<Component>();

    @Override
  public void addLayoutComponent(Component comp, Object constraints) {
    synchronized (comp.getTreeLock()) {
      if (BOTTOM.equals(constraints)) {
        components.add(0, comp);
      } else if (TOP.equals(constraints)) {
        components.add(comp);
      } else {
        components.add(comp);
      }
    }
  }

    @Override
  public void addLayoutComponent(String name, Component comp) {
    addLayoutComponent(comp, TOP);
  }

    @Override
  public void removeLayoutComponent(Component comp) {
    synchronized (comp.getTreeLock()) {
      components.remove(comp);
    }
  }

    @Override
  public float getLayoutAlignmentX(Container target) {
    return 0.5f;
  }

    @Override
  public float getLayoutAlignmentY(Container target) {
    return 0.5f;
  }

    @Override
  public void invalidateLayout(Container target) {
  }

    @Override
  public Dimension preferredLayoutSize(Container parent) {
    synchronized (parent.getTreeLock()) {
      int width = 0;
      int height = 0;

      for (Component comp : components) {
        Dimension size = comp.getPreferredSize();
        width = Math.max(size.width, width);
        height = Math.max(size.height, height);
      }

      Insets insets = parent.getInsets();
      width += insets.left + insets.right;
      height += insets.top + insets.bottom;

      return new Dimension(width, height);
    }
  }

    @Override
  public Dimension minimumLayoutSize(Container parent) {
    synchronized (parent.getTreeLock()) {
      int width = 0;
      int height = 0;

      for (Component comp : components) {
        Dimension size = comp.getMinimumSize();
        width = Math.max(size.width, width);
        height = Math.max(size.height, height);
      }

      Insets insets = parent.getInsets();
      width += insets.left + insets.right;
      height += insets.top + insets.bottom;

      return new Dimension(width, height);
    }
  }

    @Override
  public Dimension maximumLayoutSize(Container target) {
    return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
  }

    @Override
  public void layoutContainer(Container parent) {
    synchronized (parent.getTreeLock()) {
      int width = parent.getWidth();
      int height = parent.getHeight();

      Rectangle bounds = new Rectangle(0, 0, width, height);

      int componentsCount = components.size();

      for (int i = 0; i < componentsCount; i++) {
        Component comp = components.get(i);
        comp.setBounds(bounds);
        parent.setComponentZOrder(comp, componentsCount - i - 1);
      }
    }
  }
}
