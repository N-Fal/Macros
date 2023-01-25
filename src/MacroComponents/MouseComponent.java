package MacroComponents;

import Macro.Inputter;

public final class MouseComponent extends MacroComponent
{
    private final Mouse button;
    private final Action action;

    /**
     * <p><code>MacroComponent</code> that represents a singular mouse press.</p>
     * @param button <code>MacroComponent.Mouse</code> constant that represents the mouse button.
     * @param action <code>MacroComponent.Action</code> constant that represents the action performed with the mouse
     */
    public MouseComponent(Mouse button, Action action)
    {
        this.button = button;
        this.action = action;
    }

    public Mouse getButton()
    {
        return button;
    }

    public Action getAction()
    {
        return action;
    }

    @Override
    public void performAction(Inputter inputter)
    {
        switch (action)
        {
            case PRESS:
            inputter.clickDown(button);
                break;
            case RELEASE:
                inputter.clickUp(button);
                break;
            case TYPE:
                inputter.click(button);
                break;
        }
    }

    @Override
    public String toString()
    {
        return "mouse " + button + " " + action;
    }
}
