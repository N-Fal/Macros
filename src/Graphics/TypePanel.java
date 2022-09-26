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

        // Label for ID
        this.add(new JLabel(this.getClass().getSimpleName()), 1);

        phraseField.setPreferredSize(new Dimension(100, 20));
        this.add(phraseField, 2);
    }

    @Override
    public void updateMacro()
    {
        TypeComponent temp = (TypeComponent)(this.getMacro());
        temp.setPhrase(phraseField.getText());
    }
}