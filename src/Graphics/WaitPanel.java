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

        this.add(new JLabel("Time (ms): "), indexIncrementer++);
        waitField = new JTextField();
        waitField.setPreferredSize(new Dimension(50, 20));
        this.add(waitField, indexIncrementer);
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
}