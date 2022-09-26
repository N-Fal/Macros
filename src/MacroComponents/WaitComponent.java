package MacroComponents;

import Backend.Inputter;

public class WaitComponent extends MacroComponent
{
    private int time;

    public WaitComponent(int time)
    {
        super(MacroType.WAIT);
        this.time = time;

        this.setType(MacroType.WAIT);
    }

    public void setTime(int time)
    {
        this.time = time;
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
