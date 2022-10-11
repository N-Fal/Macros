package Graphics;

import Backend.Main;
import MacroComponents.MacroComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MacroPanel extends JPanel
{
    private MacroComponent macro;
    private JLabel listNumLabel;


    public MacroPanel(MacroComponent macro)
    {
        this.macro = macro;

        this.setMaximumSize(new Dimension(680, 40));
        this.setPreferredSize(new Dimension(680, 40));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.GRAY);

        listNumLabel = new JLabel();
        this.add(listNumLabel, 0);

        this.add(new JLabel(this.toString()), 1);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                removeSelf();

                Main.gui.updateScrollBarMax();
            }
        });

        exitButton.setMaximumSize(new Dimension(20, 20));
        exitButton.setPreferredSize(new Dimension(20, 20));
        this.add(exitButton);

        // temporary ID for MacroPanels
        // this.add(new JLabel(this.getMacro().getClass().getSimpleName()));
    }

    public void removeSelf()
    {
        Main.gui.removeFromPanelList(this);
    }

    public MacroComponent getMacro()
    {
        return macro;
    }

    public abstract void updateMacro();

    public abstract void updateFields();

    // lots of extra code to make sure the increasing number of digits doesn't push every component back
    public void setListNumber(int i)
    {
        String text = i + 1 + ".";
        int digits = 0;

        // counts the number of digits in i
        int j = i + 1;
        while (j < 1000)
        {
            j *= 10;
            digits++;
        }

        // adds 2 spaces for every missing digit
        for (int k = 0; k + 1 < digits * 2; k++)
        {
            text += " ";
        }

        listNumLabel.setText(text);
    }

    public String getListNumber()
    {
        return listNumLabel.getText();
    }

    public String toString()
    {
        String name = this.getClass().getSimpleName();
        return name.substring(0, name.length() - 5);
    }
}
