package Graphics;

import MacroComponents.MacroComponent;
import MacroComponents.MouseMoveComponent;
import MacroComponents.WaitComponent;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;

public class MouseMovePanel extends MacroPanel
{
    private JTextField xField, yField;

    public MouseMovePanel(MacroComponent m)
    {
        super(m);
        int indexIncrementer = 2; // 2 accounts for the "numListLabel" and the classname label

        this.add(new JLabel("X: "), indexIncrementer++);
        xField = new JTextField();
        xField.setPreferredSize(new Dimension(50, 20));
        this.add(xField, indexIncrementer++);

        this.add(new JLabel("Y: "), indexIncrementer++);
        yField = new JTextField();
        yField.setPreferredSize(new Dimension(50, 20));
        this.add(yField, indexIncrementer);

    }

    @Override
    public void updateMacro()
    {
        MouseMoveComponent temp = (MouseMoveComponent)(this.getMacro());

        try
        {
            temp.setMouseX(Integer.parseInt(xField.getText()));
            temp.setMouseY(Integer.parseInt(yField.getText()));
        }
        catch (InputMismatchException e)
        {
            temp.setMouseX(0);
            temp.setMouseY(0);
        }
    }
}