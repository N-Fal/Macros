package Manager;//212 :>

import MacroComponents.MacroComponent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Inputter
{
    private final Robot runner;

    public Inputter() throws AWTException
    {
        runner = new Robot();
    }

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

    public void press(int keycode)
    {
        runner.keyPress(keycode);
    }
    public void release(int keycode)
    {
        runner.keyRelease(keycode);
    }

    public void typeKey(int keycode)
    {
        this.press(keycode);
        this.release(keycode);
    }

    private void typeCapped(int keycode)
    {
        this.press(KeyEvent.VK_SHIFT);
        this.typeKey(keycode);
        this.release(KeyEvent.VK_SHIFT);
    }

    // helper method for autoclick / if you just want to click once
    public void click(MacroComponent.Mouse button)
    {
        this.clickDown(button);
        this.clickUp(button);
    }

    // helper methods for click / if you want to hold down/release a mouse button
    public void clickDown(MacroComponent.Mouse button)
    {
        runner.mousePress(button.getMouseCode());
    }

    public void clickUp(MacroComponent.Mouse button)
    {
        runner.mouseRelease(button.getMouseCode());
    }

    // moves the mouse cursor to pixel coordinates.
    public void mouseTo(int x, int y)
    {
        runner.mouseMove(x, y);
    }

    public void mouseScroll(int amount)
    {
        runner.mouseWheel(amount);
    }
}
