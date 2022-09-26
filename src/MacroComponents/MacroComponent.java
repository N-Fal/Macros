package MacroComponents;

import Backend.Inputter;
import Graphics.*;

import java.awt.event.KeyEvent;
import java.security.Key;

public abstract class MacroComponent
{
    private MacroPanel display;
    private MacroType type;

    public MacroComponent(MacroType type)
    {
        switch (type)
        {
            case KEY:
                display = new KeyPanel(this);
                break;
            case MOUSE:
                display = new MousePanel(this);
                break;
            case MOUSE_MOVE:
                display = new MouseMovePanel(this);
                break;
            case TYPE:
                display = new TypePanel(this);
                break;
            case WAIT:
                display = new WaitPanel(this);
                break;
        }
    }
    public enum MacroType
    {
        MOUSE,
        MOUSE_MOVE,
        KEY,
        TYPE,
        WAIT
    }

    public enum Mouse
    {
        LEFT(KeyEvent.BUTTON1_DOWN_MASK),
        RIGHT(KeyEvent.BUTTON2_DOWN_MASK),
        MIDDLE(KeyEvent.BUTTON3_DOWN_MASK);

        private int mouseCode;

        Mouse(int button)
        {
            mouseCode = button;
        }

        public int getMouseCode()
        {
            return mouseCode;
        }
    }

    public enum Action
    {
        PRESS,
        RELEASE,
        TYPE
    }

    void setType(MacroType type)
    {
        this.type = type;
    }

    // each MacroComponent subclass performs an action by giving its instance variables to a passed Inputter object.
    public abstract void performAction(Inputter inputter);

    public MacroPanel getDisplay()
    {
        return display;
    }

    public abstract String toString();
}