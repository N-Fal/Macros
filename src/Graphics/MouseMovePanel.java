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

        // Label for ID
        this.add(new JLabel(this.getClass().getSimpleName()), 1);

        this.add(new JLabel("X: "), 2);
        xField = new JTextField();
        xField.setPreferredSize(new Dimension(50, 20));
        this.add(xField, 3);

        this.add(new JLabel("Y: "), 4);
        yField = new JTextField();
        yField.setPreferredSize(new Dimension(50, 20));
        this.add(yField, 5);

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