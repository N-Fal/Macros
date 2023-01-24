package MacroComponents;

import Manager.Inputter;

public final class KeyComponent extends MacroComponent
{
    private final int keyCode;
    private final Action action;

    public KeyComponent(int keyCode, Action action)
    {
        this.keyCode = keyCode;
        this.action = action;
    }

    public int getKeyCode()
    {
        return keyCode;
    }

    public Action getAction()
    {
        return action;
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
