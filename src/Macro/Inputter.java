package Macro;

import MacroComponents.MacroComponent;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * <p>Constructs an <code>Inputter</code> object in the coordinate system of the primary screen.</p>
 */
public class Inputter
{
    private final Robot runner;

    public Inputter() throws AWTException
    {
        runner = new Robot();
    }

    /**
     * <p>Uses the <code>keyPress()</code> and <code>keyRelease()</code> methods of the <code>Robot</code> class to type a series of characters.</p>
     * @param phrase String of type-able characters.
     */
    public void type(String phrase)
    {
        int code;
        char[] phraseArray = phrase.toCharArray();
        for (int i = 0; i < phrase.length(); i++)
        {
            code = KeyEvent.getExtendedKeyCodeForChar(phraseArray[i]);
            try
            {
                // if it's a capital A-Z letter...
                if (phraseArray[i] >= 65 && phraseArray[i] <= 90)
                {
                    throw new IllegalArgumentException();
                }
                this.typeKey(code);
            } catch (IllegalArgumentException e)
            {
                switch(phraseArray[i])
                {
                    case '~':
                        code = KeyEvent.VK_BACK_QUOTE;
                        break;
                    case '!':
                        code = KeyEvent.VK_1;
                        break;
                    case '@':
                        code = KeyEvent.VK_2;
                        break;
                    case '#':
                        code = KeyEvent.VK_3;
                        break;
                    case '$':
                        code = KeyEvent.VK_4;
                        break;
                    case '%':
                        code = KeyEvent.VK_5;
                        break;
                    case '^':
                        code = KeyEvent.VK_6;
                        break;
                    case '&':
                        code = KeyEvent.VK_7;
                        break;
                    case '*':
                        code = KeyEvent.VK_8;
                        break;
                    case '(':
                        code = KeyEvent.VK_9;
                        break;
                    case ')':
                        code = KeyEvent.VK_0;
                        break;
                    case '_':
                        code = KeyEvent.VK_MINUS;
                        break;
                    case '+':
                        code = KeyEvent.VK_EQUALS;
                        break;
                    case '{':
                        code = KeyEvent.VK_OPEN_BRACKET;
                        break;
                    case '}':
                        code = KeyEvent.VK_CLOSE_BRACKET;
                        break;
                    case '|':
                        code = KeyEvent.VK_BACK_SLASH;
                        break;
                    case ':':
                        code = KeyEvent.VK_SEMICOLON;
                        break;
                    case '"':
                        code = KeyEvent.VK_QUOTE;
                        break;
                    case '<':
                        code = KeyEvent.VK_COMMA;
                        break;
                    case '>':
                        code = KeyEvent.VK_PERIOD;
                        break;
                    case '?':
                        code = KeyEvent.VK_SLASH;
                        break;
                }
                this.typeCapped(code);
            }
        }
    }

    /**
     * <p>Runs the <code>keyPress()</code> method of the <code>Robot</code> class.</p>
     * @param keycode <code>KeyEvent</code> constant.
     */
    public void press(int keycode)
    {
        runner.keyPress(keycode);
    }

    /**
     * <p>runs the <code>keyRelease()</code> method of the Robot class.</p>
     * @param keycode <code>KeyEvent</code> constant.
     */
    public void release(int keycode)
    {
        runner.keyRelease(keycode);
    }

    /**
     * <p>Presses and releases the given keycode.</p>
     * @param keycode <code>KeyEvent</code> constant.
     */
    public void typeKey(int keycode)
    {
        this.press(keycode);
        this.release(keycode);
    }

    /**
     * <p>Presses and releases the given keycode while holding shift.</p>
     * @param keycode <code>KeyEvent</code> constant.
     */
    private void typeCapped(int keycode)
    {
        this.press(KeyEvent.VK_SHIFT);
        this.typeKey(keycode);
        this.release(KeyEvent.VK_SHIFT);
    }

    /**
     * <p>Clicks the given mouse button once.</p>
     * @param button <code>MacroComponent.Mouse</code> constant.
     */
    public void click(MacroComponent.Mouse button)
    {
        this.clickDown(button);
        this.clickUp(button);
    }

    /**
     * <p>Presses and holds the given mouse button.</p>
     * @param button <code>MacroComponent.Mouse</code> constant.
     */
    public void clickDown(MacroComponent.Mouse button)
    {
        runner.mousePress(button.getMouseCode());
    }

    /**
     * <p>Releases the given mouse button</p>
     * @param button <code>MacroComponent.Mouse</code> constant.
     */
    public void clickUp(MacroComponent.Mouse button)
    {
        runner.mouseRelease(button.getMouseCode());
    }

    /**
     * <p>Moves the mouse to given XY coordinates.</p>
     * @param x X-coordinate of the mouse.
     * @param y Y-coordinate of the mouse.
     */
    public void mouseTo(int x, int y)
    {
        runner.mouseMove(x, y);
    }

    /**
     * Scrolls the mouse wheel.
     * @param amount number of "notches" the mouse wheel will turn.
     */
    public void mouseScroll(int amount)
    {
        runner.mouseWheel(amount);
    }
}
