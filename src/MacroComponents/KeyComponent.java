package MacroComponents;

import Backend.Inputter;

public class KeyComponent extends MacroComponent
{
    private int keyCode;
    private Action action;

    public KeyComponent(int keyCode, Action action)
    {
        super(MacroType.KEY);
        this.keyCode = keyCode;
        this.action = action;

        this.setType(MacroType.KEY);
    }

    public void setKeyCode(int keyCode)
    {
        this.keyCode = keyCode;
    }

    public void setAction(Action action)
    {
        this.action = action;
    }

    @Override
    public void performAction(Inputter inputter)
    {
        switch(action)
        {
            case PRESS:
                inputter.press(keyCode);
                break;
            case RELEASE:
                inputter.release(keyCode);
                break;
            case TYPE:
                inputter.typeKey(keyCode);
                break;
        }
    }

    @Override
    public String toString()
    {
        return "key " + keyCode + " " + action;
    }
}
