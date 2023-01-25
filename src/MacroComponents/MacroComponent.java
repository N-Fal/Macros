package MacroComponents;

import Macro.Inputter;
import java.awt.event.KeyEvent;

public abstract class MacroComponent
{
    /**
     * <p>Holds the <code>KeyEvent</code> values of each mouse button.</p>
     */
    public enum Mouse
    {
        /**
         * <p>Left mouse button.</p>
         */
        LEFT(KeyEvent.BUTTON1_DOWN_MASK),
        /**
         * <p>Right mouse button.</p>
         */
        RIGHT(KeyEvent.BUTTON2_DOWN_MASK),
        /**
         * <p>Scroll wheel button.</p>
         */
        MIDDLE(KeyEvent.BUTTON3_DOWN_MASK);

        private final int mouseCode;

        Mouse(int button)
        {
            mouseCode = button;
        }

        /**
         * @return Integer value of the <code>KeyEvent</code> mouse button code
         */
        public int getMouseCode()
        {
            return mouseCode;
        }
    }

    /**
     * <p>Contains the different actions one can perform with a key on a keyboard.</p>
     */
    public enum Action
    {
        /**
         * <p>Represents pressing and holding down a key.</p>
         */
        PRESS,
        /**
         * <p>Represents releasing a key that was being held down.</p>
         */
        RELEASE,
        /**
         * <p>Represents pressing and releasing a key.</p>
         */
        TYPE
    }

    /**
     * <p>A series of instructions for an <code>Inputter</code> object. This details what the <code>MacroComponent</code> actually does in the context of the macro.</p>
     * @param inputter Typically passed by a <code>MacroManager</code> when the <code>runMacro()</code> method is called.
     */
    public abstract void performAction(Inputter inputter);

    public abstract String toString();
}