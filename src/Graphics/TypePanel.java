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

        // separating label from field
        this.add(Box.createRigidArea(new Dimension(68, 0)), indexIncrementer++);

        this.add(new JLabel("Statement: "), indexIncrementer++);

        phraseField.setPreferredSize(new Dimension(329, 20));
        this.add(phraseField, indexIncrementer++);

        // separating exit button from field
        this.add(Box.createRigidArea(new Dimension(99, 0)), indexIncrementer);
    }

    @Override
    public void updateMacro()
    {
        TypeComponent temp = (TypeComponent)(this.getMacro());
        temp.setPhrase(phraseField.getText());
    }

    @Override
    public void updateFields()
    {
        TypeComponent temp = (TypeComponent)(this.getMacro());
        phraseField.setText(temp.getPhrase());
    }
}