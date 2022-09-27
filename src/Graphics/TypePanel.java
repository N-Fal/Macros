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
        int indexIncrementer = 2; // 2 accounts for the "numListLabel" and the classname label

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