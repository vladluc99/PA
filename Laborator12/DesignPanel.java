import javax.swing.*;

public class DesignPanel extends JPanel {
    final MainFrame mainFrame;

    public DesignPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    void addBtn(JButton btn){
        add(btn);
    }
    void addLabel(JLabel lbl){
        add(lbl);
    }
    void addTextField(JTextField fld){
        add(fld);
    }
}
