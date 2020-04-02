import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    BufferedImage prevImage;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //pentru a fi mai smooth
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    ImageIO.write(frame.canvas.image, "PNG", new File("F:/test.png")); // poate fi vazut ca o functie de autosave, dar am scris asta pentru UNDO
                } catch (IOException ex) {
                    System.err.println(ex);
                }
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        int radius = (int) (Math.random() * 100);
        //int sides = (int) frame.configPanel.sidesField.getValue();
        Color color;
        if (Objects.equals(frame.configPanel.colorCombo.getSelectedItem(), "Random")) { //culoarea se va alege in functie de colorCombo
            color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random(), (float) 0.2); //am fost de parere ca 0.2 pentru alpha e o transparenta OK
        } else {
            color = new Color(0f, 0f, 0f, (float) 0.2); //asta e negru in RGB
        }
        graphics.setColor(color);
        if (Objects.equals(frame.configPanel.shapesCombo.getSelectedItem(), "Polygon")) { //desenam mereu forma selectata in spinner
            int sides = (int) frame.configPanel.sidesField.getValue();
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
        else
            if(Objects.equals(frame.configPanel.shapesCombo.getSelectedItem(), "Circle")){
                graphics.fillOval(x,y,radius,radius);
            }
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

