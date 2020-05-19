import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ControlPanel extends JPanel {
    final MainFrame mainFrame;
    final DesignPanel designPanel;
    JComboBox<String> optionsCombo;
    JTextField defaultText;
    JButton submitBtn;

    public ControlPanel(MainFrame mainFrame, DesignPanel designPanel) {
        this.mainFrame = mainFrame;
        this.designPanel = designPanel;
        init();
    }

    public void init() {
        String[] options = {"javax.swing.JButton", "javax.swing.JLabel","javax.swing.JTextField"};
        optionsCombo = new JComboBox<>(options);
        defaultText = new JTextField(50);
        submitBtn = new JButton("Submit");

        add(optionsCombo);
        add(defaultText);
        add(submitBtn);

        submitBtn.addActionListener(this::submit);
    }

    private void submit(ActionEvent actionEvent) {
        try {
            Class clazz = designPanel.getClass();
            Class cls;
            cls = Class.forName((String) optionsCombo.getSelectedItem());
            Constructor constructor = cls.getConstructor(String.class);
            Method methodcall;

            if (optionsCombo.getSelectedItem().equals("javax.swing.JButton")) {
                JButton btn = (JButton) constructor.newInstance(defaultText.getText());
                methodcall = clazz.getDeclaredMethod("addBtn", JButton.class);
                methodcall.invoke(designPanel, btn);
            }

            if (optionsCombo.getSelectedItem().equals("javax.swing.JLabel")) {
                JLabel lbl = (JLabel) constructor.newInstance(defaultText.getText());
                methodcall = clazz.getDeclaredMethod("addLabel", JLabel.class);
                methodcall.invoke(designPanel,lbl);
            }

            if (optionsCombo.getSelectedItem().equals("javax.swing.JTextField")) {
                JTextField textField = (JTextField) constructor.newInstance(defaultText.getText());
                methodcall = clazz.getDeclaredMethod("addTextField", JTextField.class);
                methodcall.invoke(designPanel,textField);
            }

            SwingUtilities.updateComponentTreeUI(mainFrame);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
