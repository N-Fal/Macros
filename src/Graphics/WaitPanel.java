package Graphics;

import MacroComponents.MacroComponent;
import MacroComponents.WaitComponent;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;

public class WaitPanel extends MacroPanel
{
    private JTextField waitField;

    public WaitPanel(MacroComponent m)
    {
        super(m);
        int indexIncrementer = 2; // 2 accounts for the "numListLabel" and the classname label

        // separating label from field
        this.add(Box.createRigidArea(new Dimension(70, 0)), indexIncrementer++);

        this.add(new JLabel("Time (ms): "), indexIncrementer++);
        waitField = new JTextField();
        waitField.setPreferredSize(new Dimension(103, 20));
        this.add(waitField, indexIncrementer++);

        // separating exit button from field
        this.add(Box.createRigidArea(new Dimension(329, 0)), indexIncrementer);
    }

    @Override
    public void updateMacro()
    {
        WaitComponent temp = (WaitComponent)(this.getMacro());

        try
        {
            temp.setTime(Integer.parseInt(waitField.getText()));
        }
        catch (InputMismatchException e)
        {
            temp.setTime(0);
        }
    }

    public void updateFields()
    {
        WaitComponent temp = (WaitComponent)(this.getMacro());

        waitField.setText(temp.getTime() + "");
    }
}