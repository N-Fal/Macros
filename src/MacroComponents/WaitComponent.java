package MacroComponents;

import Manager.Inputter;

public final class WaitComponent extends MacroComponent
{
    private final int time;

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
