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
        this.setLayout(new FlowLayout());
        this.setBackground(Color.GRAY);

        listNumLabel = new JLabel();
        this.add(listNumLabel, 0);

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

    public void setListNumber(int i)
    {
        listNumLabel.setText(i + ".");
    }

    public String toString()
    {
        String name = this.getClass().getSimpleName();
        return name.substring(0, name.length() - 5);
    }
}
