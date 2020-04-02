import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    final JFileChooser choose = new JFileChooser();
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton undoButton = new JButton("Undo");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        add(undoButton);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        undoButton.addActionListener(this::undo);

    }

    private void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void reset(ActionEvent actionEvent) {

        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
        frame.canvas.repaint();

    }

    /*private void load(ActionEvent actionEvent) {
        try {
            frame.canvas.image = ImageIO.read(new File("F:/test.png"));
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.repaint();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("F:/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }*/
    //UPGRADE:
    private void save(ActionEvent e) {
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //putem selecta doar un folder
        if (choose.showSaveDialog(loadBtn) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(choose.getSelectedFile().getPath() + "/Desen.png")); //salvam in locul in care s-a selectat
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }


    private void load(ActionEvent actionEvent) {
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY); //putem selecta doar un fisier, nu un director
        if (choose.showOpenDialog(saveBtn) == JFileChooser.APPROVE_OPTION) {
            File file = choose.getSelectedFile(); //pentru a incarca din imaginea selectata
            try {
                frame.canvas.image = ImageIO.read(file);
                frame.canvas.graphics = frame.canvas.image.createGraphics();
                frame.canvas.repaint();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void undo(ActionEvent actionEvent) {
        try {
            frame.canvas.image = ImageIO.read(new File("F:/test.png")); //incarcam imaginea salvata anterior--->in DrawingPanel.init()
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.repaint();
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
