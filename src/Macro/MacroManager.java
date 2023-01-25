package Macro;

import MacroComponents.MacroComponent;

import java.awt.*;
import java.util.ArrayList;

public class MacroManager
{
    private final ArrayList<MacroComponent> macroList;
    private Inputter macroRunner;
    private long defaultWait;

    /**
     * <p>Manages and iterates through an <code>ArrayList</code> of <code>MacroComponent</code> objects.</p>
     */
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

    /**
     * <p>Adds the given <code>MacroComponent</code> to the list.</p>
     * @param component <code>MacroComponent</code> to be added.
     */
    public void add(MacroComponent component)
    {
        macroList.add(component);
    }

    /**
     * <p>Removes the given <code>MacroComponent</code> from the list.</p>
     * @param component <code>MacroComponent</code> to be removed.
     */
    public void remove(MacroComponent component)
    {
        macroList.remove(component);
    }

    /**
     * <p>Removes the <code>MacroComponent</code> at the given index of the list.</p>
     * @param index position of the <code>MacroComponent</code> to be removed.
     */
    public void remove(int index)
    {
        macroList.remove(index);
    }

    /**
     * <p>Calls the <code>performAction()</code> method of each <code>MacroComponent</code>, executing the constructed macro.</p>
     */
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

    /**
     * Sets the delay between execution of <code>performAction()</code> methods.
     * @param millis Time in milliseconds between each <code>MacroComponent</code>'s method call.
     */
    public void setDefaultWait(long millis)
    {
        defaultWait = millis;
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