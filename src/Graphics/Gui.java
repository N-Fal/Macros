package Graphics;

import Backend.Main;
import MacroComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui
{
    private JFrame frame;
    private JPanel mainPanel, controlsPanel, displayPanel, infoPanel;

    // used for the scroll bar
    private JScrollBar scroll;

    // used when adding MacroPanels via the buttons
    private MacroComponent tempComponent;

    // ArrayLiat to hold all the MacroPanels
    private ArrayList<MacroPanel> panelList = new ArrayList<MacroPanel>();

    // used to display information in the info panel
    private JLabel xPosLabel, yPosLabel, keyLabel;
    private Thread mouseLocThread = new Thread(new MouseLocation());

    public Gui()
    {
        // basic initialing of the frame
        frame = new JFrame();
        frame.setTitle("Macros");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // initializing main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 10));
        mainPanel.setSize(new Dimension(720, 480));
        mainPanel.setPreferredSize(new Dimension(720, 480));
        mainPanel.setFocusable(true);
        // mainPanel.setBackground(Color.CYAN);

        mainPanel.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                mainPanel.requestFocusInWindow();
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        // setting up the top menu bar
        JMenuBar optionsBar = new JMenuBar();

        // save/load menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveFile = new JMenuItem("Save");
        fileMenu.add(saveFile);
        JMenuItem loadFile = new JMenu(("Load"));
        fileMenu.add(loadFile);
        JMenuItem newFile = new JMenu("New");
        fileMenu.add(newFile);
        optionsBar.add(fileMenu);

        // setting up the scroll bar

        // value / 10 = number of things that aren't displayed
        // value / 10 = index of first thing that should be shown.
        scroll = new JScrollBar(JScrollBar.VERTICAL, 0, 20, 0, 20);

        scroll.addAdjustmentListener(e ->
        {
            if (scroll.getValue() % 10 == 0)
            {
                updateDisplayPanel();
            }
        });


        // setting up the panel with the software controls
        controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
        controlsPanel.setMaximumSize(new Dimension(700, 100));
        controlsPanel.setPreferredSize(new Dimension(700, 100));
        // controlsPanel.add(new JLabel("Controls"));
        controlsPanel.setBackground(Color.LIGHT_GRAY);

        // setting up the buttons in the controls panel

        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if (Main.manager.getMacroSize() <= 0)
                    {
                        throw new Exception();
                    }

                    Main.manager.runMacro();
                    mainPanel.requestFocusInWindow();
                } catch (Exception f)
                {
                    JOptionPane.showMessageDialog(frame,"Invalid Macro");
                }
            }
        });

        JButton click = new JButton("Click");
        click.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tempComponent = new MouseComponent(MacroComponent.Mouse.LEFT, MacroComponent.Action.TYPE);
                Main.manager.add(tempComponent);
                panelList.add(tempComponent.getDisplay());

                updateScrollBarMax();
                updateGui();
                mainPanel.requestFocusInWindow();
            }
        });

        JButton move = new JButton("Move");
        move.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tempComponent = new MouseMoveComponent(0, 0);
                Main.manager.add(tempComponent);
                panelList.add(tempComponent.getDisplay());

                updateScrollBarMax();
                updateGui();
                mainPanel.requestFocusInWindow();
            }
        });

        JButton type = new JButton("Type");
        type.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tempComponent = new TypeComponent("");
                Main.manager.add(tempComponent);
                panelList.add(tempComponent.getDisplay());

                updateScrollBarMax();
                updateGui();
                mainPanel.requestFocusInWindow();
            }
        });

        JButton key = new JButton("Key");
        key.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tempComponent = new KeyComponent(0, MacroComponent.Action.TYPE);
                Main.manager.add(tempComponent);
                panelList.add(tempComponent.getDisplay());

                updateScrollBarMax();
                updateGui();
                mainPanel.requestFocusInWindow();
            }
        });

        JButton wait = new JButton("Wait");
        wait.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tempComponent = new WaitComponent(0);
                Main.manager.add(tempComponent);
                panelList.add(tempComponent.getDisplay());

                updateScrollBarMax();
                updateGui();
                mainPanel.requestFocusInWindow();
            }
        });

        JButton[] controlButtons = new JButton[] {play, click, move, type, key, wait};
        for (int i = 0 ; i < controlButtons.length; i++)
        {
            controlButtons[i].setMaximumSize(new Dimension(80, 80));
            controlButtons[i].setPreferredSize(new Dimension(80, 80));
            controlsPanel.add(controlButtons[i]);
        }

        // setting up the panel that shows all the macro info
        displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        displayPanel.setMaximumSize(new Dimension(700, 300));
        displayPanel.setPreferredSize(new Dimension(700, 300));
        displayPanel.add(new JLabel("Display"));
        displayPanel.setBackground(Color.LIGHT_GRAY);


        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        infoPanel.setMaximumSize(new Dimension(700, 40));
        infoPanel.setPreferredSize(new Dimension(700, 40));
        xPosLabel = new JLabel();
        yPosLabel = new JLabel();
        keyLabel = new JLabel();
        keyLabel.setText("Key Code: ");
        infoPanel.add(xPosLabel);
        infoPanel.add(yPosLabel);
        infoPanel.add(keyLabel);
        infoPanel.setBackground(Color.LIGHT_GRAY);

        mouseLocThread.start();

        mainPanel.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                keyLabel.setText("Key Code: " + e.getKeyCode() + "");
                updateGui();
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });

        frame.add(mainPanel);

        frame.setJMenuBar(optionsBar);

        mainPanel.add(controlsPanel, BorderLayout.PAGE_START);

        mainPanel.add(displayPanel, BorderLayout.CENTER);

        mainPanel.add(infoPanel, BorderLayout.PAGE_END);

        mainPanel.add(scroll, BorderLayout.LINE_END);


        frame.pack();
        frame.setVisible(true);
    }

    private void add(MacroPanel display)
    {
        displayPanel.add(display);
        updateGui();
    }

    public void removeFromPanelList(MacroPanel macroPanel)
    {
        panelList.remove(macroPanel);
        Main.manager.remove(macroPanel.getMacro());
        displayPanel.remove(macroPanel);
        updateGui();
    }

    private void updateGui()
    {
        updateDisplayPanel();
        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void updateDisplayPanel()
    {
        for (int i = 1; i < displayPanel.getComponents().length; i++)
        {
            displayPanel.removeAll();
        }

        // System.out.println(Arrays.toString(displayPanel.getComponents()));

        int max = panelList.size();
        for (int i = scroll.getValue() / 10;(i < (scroll.getValue() / 10) + 6) && (i < max); i++)
        {
            displayPanel.add(panelList.get(i));
        }

        for (int i = 0; i < panelList.size(); i++)
        {
            panelList.get(i).setListNumber(i);
        }

        // System.out.println(panelList);
    }

    public void updateScrollBarMax()
    {
        if (Main.manager.getMacroSize() * 10 > 60)
        {
            scroll.setMaximum(Main.manager.getMacroSize() * 10 - 40);
        }
        else
        {
            scroll.setMaximum(20);
        }
    }

    public void updateMouseLocation(Point p)
    {
        xPosLabel.setText("Mouse coordinates: x: " + p.x);
        yPosLabel.setText("y: " + p.y);
    }
}

class MouseLocation implements Runnable
{
    @Override
    public void run()
    {
        while(true)
        {
            Main.gui.updateMouseLocation(MouseInfo.getPointerInfo().getLocation());

            try
            {
                Thread.sleep(20);
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
