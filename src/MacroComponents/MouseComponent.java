package MacroComponents;

import Backend.Inputter;

public class MouseComponent extends MacroComponent
{
    private Mouse button;
    private Action action;

    public MouseComponent(Mouse button, Action action)
    {
        super(MacroType.MOUSE);
        this.button = button;
        this.action = action;

        this.setType(MacroType.MOUSE);
    }

    public void setButton(Mouse button)
    {
        this.button = button;
    }

    public Mouse getButton()
    {
        return button;
    }

    public void setAction(Action action)
    {
        this.action = action;
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
