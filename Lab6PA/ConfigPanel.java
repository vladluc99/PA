import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1)); //am setat minimul la 3 deoarece e minimul de laturi
        //sidesField.setValue(6);
        String[] colors = {"Random", "Black"};
        colorCombo = new JComboBox(colors);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

}
