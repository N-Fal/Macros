package Graphics;

import MacroComponents.MacroComponent;
import MacroComponents.TypeComponent;

import javax.swing.*;
import java.awt.*;

public class TypePanel extends MacroPanel
{
    private JTextField phraseField = new JTextField();

    public TypePanel(MacroComponent m)
    {
        super(m);
        int indexIncrementer = 1;

        // Label for ID
        this.add(new JLabel(this.toString()), indexIncrementer++);

        phraseField.setPreferredSize(new Dimension(100, 20));
        this.add(phraseField, indexIncrementer);
    }

    @Override
    public void updateMacro()
    {
        TypeComponent temp = (TypeComponent)(this.getMacro());
        temp.setPhrase(phraseField.getText());
    }
}