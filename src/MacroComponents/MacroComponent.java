package MacroComponents;

import Backend.Inputter;
import java.awt.event.KeyEvent;

public abstract class MacroComponent
{
    private MacroType type;

    public MacroComponent(MacroType type)
    {

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

    public abstract String toString();

    public static MacroComponent loadComponent(String info)
    {
        MacroComponent output;
        String[] splitLine = info.split(" ");

        switch(splitLine[0])
        {
            case "mouse":
                Mouse mouseButton;
                Action mouseAction;

                switch(splitLine[1])
                {
                    default:
                    case "LEFT":
                        mouseButton = Mouse.LEFT;
                        break;
                    case "RIGHT":
                        mouseButton = Mouse.RIGHT;
                        break;
                    case "MIDDLE":
                        mouseButton = Mouse.MIDDLE;
                        break;
                }

                switch (splitLine[2])
                {
                    case "PRESS":
                        mouseAction = Action.PRESS;
                        break;
                    case "RELEASE":
                        mouseAction = Action.RELEASE;
                        break;
                    default:
                    case "TYPE":
                        mouseAction = Action.TYPE;
                        break;
                }

                output = new MouseComponent(mouseButton, mouseAction);
                break;

            case "move":
                int x = Integer.parseInt(splitLine[1]);
                int y = Integer.parseInt(splitLine[2]);
                output = new MouseMoveComponent(x, y);
                break;

            case "type":
                StringBuilder phrase = new StringBuilder();
                for (int i = 1; i < splitLine.length; i++)
                {
                    phrase.append(splitLine[i] + " ");
                }

                output = new TypeComponent(phrase.toString());
                break;

            case "key":
                int keyCode = Integer.parseInt(splitLine[1]);

                Action keyAction;

                switch (splitLine[2])
                {
                    case "PRESS":
                        keyAction = Action.PRESS;
                        break;
                    case "RELEASE":
                        keyAction = Action.RELEASE;
                        break;
                    default:
                    case "TYPE":
                        keyAction = Action.TYPE;
                        break;
                }

                output = new KeyComponent(keyCode, keyAction);
                break;

            case "wait":
                int time = Integer.parseInt(splitLine[1]);
                output = new WaitComponent(time);
                break;

            default:
                output = null;
        }

        return output;
    }
}