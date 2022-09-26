package Graphics;

import MacroComponents.MacroComponent;
import MacroComponents.MouseComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MousePanel extends MacroPanel
{
    JCheckBox leftCheck, rightCheck, pressCheck, releaseCheck;

    public MousePanel(MacroComponent m)
    {
        super(m);

        // Label for ID
        this.add(new JLabel(this.getClass().getSimpleName()), 1);

        this.add(new JLabel("Left Click: "), 2);
        leftCheck = new JCheckBox();
        leftCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (leftCheck.isSelected())
                {
                    rightCheck.setSelected(false);
                }
            }
        });
        this.add(leftCheck, 3);


        this.add(new JLabel("Right Click: "), 4);
        rightCheck = new JCheckBox();
        rightCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (rightCheck.isSelected())
                {
                    leftCheck.setSelected(false);
                }
            }
        });
        this.add(rightCheck, 5);

        this.add(new JLabel("Press: "), 6);
        pressCheck = new JCheckBox();
        this.add(pressCheck, 7);

        this.add(new JLabel("Release: "), 8);
        releaseCheck = new JCheckBox();
        this.add(releaseCheck, 9);
    }

    @Override
    public void updateMacro()
    {
        MouseComponent temp = (MouseComponent)(this.getMacro());

        boolean left = leftCheck.isSelected(), right = rightCheck.isSelected();
        boolean press = pressCheck.isSelected(), release = releaseCheck.isSelected();

        if (left)
        {
            temp.setButton(MacroComponent.Mouse.LEFT);
        }
        else
        {
            temp.setButton(MacroComponent.Mouse.RIGHT);
        }

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