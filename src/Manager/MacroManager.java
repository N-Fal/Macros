package Manager;

import MacroComponents.MacroComponent;

import java.awt.*;
import java.util.ArrayList;

public class MacroManager
{
    private final ArrayList<MacroComponent> macroList;
    private Inputter macroRunner;
    private int defaultWait; // the amount of time between the running of macroComponents (default is 10)

    public MacroManager()
    {
        macroList = new ArrayList<>();
        try
        {
             macroRunner = new Inputter();
             defaultWait = 10;
        }
        catch (AWTException e) {e.printStackTrace();}
    }

    public void add(MacroComponent component)
    {
        macroList.add(component);
    }

    public void remove(MacroComponent component)
    {
        macroList.remove(component);
    }

    public void remove(int index)
    {
        macroList.remove(index);
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
}