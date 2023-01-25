package MacroComponents;

import Macro.Inputter;

public final class KeyComponent extends MacroComponent
{
    private final int keyCode;
    private final Action action;

    /**
     * <p><code>MacroComponent</code> that represents a singular keystroke.</p>
     * @param keyCode <code>KeyEvent</code> constant.
     * @param action <code>MacroComponent.Action</code> constant that represents the action performed with the key.
     */
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
