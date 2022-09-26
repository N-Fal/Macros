package Graphics;

import MacroComponents.KeyComponent;
import MacroComponents.MacroComponent;
import MacroComponents.TypeComponent;

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

        // Label for ID
        this.add(new JLabel(this.getClass().getSimpleName()), 1);


        this.add(new JLabel("Key Code:"), 2);
        keyCodeField = new JTextField();
        keyCodeField.setPreferredSize(new Dimension(50, 20));
        this.add(keyCodeField, 3);

        this.add(new JLabel("Press: "), 4);
        pressCheck = new JCheckBox();
        this.add(pressCheck, 5);

        this.add(new JLabel("Release: "), 6);
        releaseCheck = new JCheckBox();
        this.add(releaseCheck, 7);


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
}
