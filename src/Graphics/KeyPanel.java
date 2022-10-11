package Graphics;

import MacroComponents.KeyComponent;
import MacroComponents.MacroComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.InputMismatchException;

public class KeyPanel extends MacroPanel
{
    private JTextField keyCodeField;
    private JCheckBox pressCheck, releaseCheck;

    public KeyPanel(MacroComponent m)
    {
        super(m);
        int indexIncrementer = 2; // 2 accounts for the "numListLabel" and the classname label

        // separating label from fields
        this.add(Box.createRigidArea(new Dimension(75, 0)), indexIncrementer++);

        this.add(new JLabel("Key Code:"), indexIncrementer++);
        keyCodeField = new JTextField();
        keyCodeField.setPreferredSize(new Dimension(104, 20));
        this.add(keyCodeField, indexIncrementer++);

        // separaing key field from action fields
        this.add(Box.createRigidArea(new Dimension(70, 0)), indexIncrementer++);

        this.add(new JLabel("Press: "), indexIncrementer++);
        pressCheck = new JCheckBox();
        this.add(pressCheck, indexIncrementer++);

        this.add(new JLabel("Release: "), indexIncrementer++);
        releaseCheck = new JCheckBox();
        this.add(releaseCheck, indexIncrementer++);

        // separating exit button from fields
        this.add(Box.createRigidArea(new Dimension(100, 0)), indexIncrementer);


    }

    @Override
    public void updateMacro()
    {
        KeyComponent temp = (KeyComponent)(this.getMacro());
        try
        {
            temp.setKeyCode(Integer.parseInt(keyCodeField.getText()));
        }
        catch (InputMismatchException e)
        {
            // if a non-number input was put into the field, the default keycode is X.
            temp.setKeyCode(KeyEvent.VK_X);
        }

        boolean press = pressCheck.isSelected(), release = releaseCheck.isSelected();

        if (press && !release) // Press only
        {
            temp.setAction(MacroComponent.Action.PRESS);
        }
        else if (release && !press) // Release only
        {
            temp.setAction(MacroComponent.Action.RELEASE);
        }
        else // if both are checked or both are unchecked, default to TYPE
        {
            temp.setAction(MacroComponent.Action.TYPE);
        }
    }

    @Override
    public void updateFields()
    {
        KeyComponent temp = (KeyComponent)(this.getMacro());

        keyCodeField.setText(temp.getKeyCode() + "");

        switch(temp.getAction())
        {
            case PRESS:
                pressCheck.setSelected(true);
                break;
            case RELEASE:
                releaseCheck.setSelected(true);
                break;
            case TYPE:
                pressCheck.setSelected(true);
                releaseCheck.setSelected(true);
                break;
            default:
        }
    }
}
