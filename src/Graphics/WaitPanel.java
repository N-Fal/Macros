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
        int indexIncrementer = 1;

        // Label for ID
        this.add(new JLabel(this.toString()), indexIncrementer++);

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