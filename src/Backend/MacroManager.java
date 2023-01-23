package Backend;

import MacroComponents.MacroComponent;

import java.awt.*;
import java.util.ArrayList;

public class MacroManager
{
    private ArrayList<MacroComponent> macroList = new ArrayList<MacroComponent>();
    private Inputter macroRunner;
    private int defaultWait; // the amount of time between the running of macroComponents (default is 10)

    public MacroManager()
    {
        try
        {
             macroRunner = new Inputter();
             defaultWait = 10;
        }
        catch (AWTException e) {}
    }

    public void add(MacroComponent m)
    {
        macroList.add(m);
    }

    public void remove(MacroComponent m)
    {
        macroList.remove(m);
    }

    public void runMacro()
    {
        for (MacroComponent m : macroList)
        {
            m.performAction(this.macroRunner);

            try
            {
                Thread.sleep(defaultWait);
            } catch (InterruptedException e) {e.printStackTrace();}
        }


    }

    public void setDefaultWait(int time)
    {
        defaultWait = time;
    }

    public int getMacroSize()
    {
        return macroList.size();
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (MacroComponent m : macroList)
        {
            builder.append(m);
            builder.append("\n");
        }

        return builder.toString();
    }

    public void move(int toMove, int moveTo)
    {
        System.out.println(this);

        MacroComponent temp = macroList.get(toMove);
        macroList.remove(toMove);
        macroList.add(moveTo, temp);

        System.out.println(this);
    }
}