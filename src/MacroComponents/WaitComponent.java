package MacroComponents;

import Manager.Inputter;

public final class WaitComponent extends MacroComponent
{
    private final int time;

    /**
     * <p><code>MacroComponent</code> that represents a delay in the execution of a macro.</p>
     * @param time Time in milliseconds that the delay lasts.
     */
    public WaitComponent(int time)
    {
        this.time = time;
    }

    public int getTime()
    {
        return time;
    }

    @Override
    public void performAction(Inputter inputter)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString()
    {
        return "wait " + time;
    }
}
