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

        // separating the label from the X field
        this.add(Box.createRigidArea(new Dimension(28, 0)), indexIncrementer++);

        this.add(new JLabel("X Coordinate: "), indexIncrementer++);
        xField = new JTextField();
        xField.setPreferredSize(new Dimension(65, 20));
        this.add(xField, indexIncrementer++);

        // separating the X field from the Y field
        this.add(Box.createRigidArea(new Dimension(84, 0)), indexIncrementer++);

        this.add(new JLabel("Y Coordinate: "), indexIncrementer++);
        yField = new JTextField();
        yField.setPreferredSize(new Dimension(65, 20));
        this.add(yField, indexIncrementer++);

        // separating the exit button from the fields
        this.add(Box.createRigidArea(new Dimension(99, 0)), indexIncrementer);

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

    @Override
    public void updateFields()
    {
        MouseMoveComponent temp = (MouseMoveComponent)(this.getMacro());

        xField.setText(temp.getMouseX() + "");
        yField.setText(temp.getMouseY() + "");
    }
}