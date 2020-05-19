import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame(){
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        designPanel = new DesignPanel(this);
        controlPanel = new ControlPanel(this, designPanel);
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
