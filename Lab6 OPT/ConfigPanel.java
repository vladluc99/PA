import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;
    JComboBox shapesCombo;

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

        String[] shapes = {"Polygon","Circle"};
        shapesCombo = new JComboBox(shapes);

        add(shapesCombo);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
        shapesCombo.addActionListener(this::shape); //pentru a ascunde spinnerul/labelul pentru sides cand nu e nevoie de el
    }
    private void shape(ActionEvent actionEvent){
        if(Objects.equals(shapesCombo.getSelectedItem(),"Polygon")){
            sidesField.setVisible(true);
            sidesLabel.setVisible(true);
        }
        else{
            sidesField.setVisible(false);
            sidesLabel.setVisible(false);
        }
    }

}
