package MacroComponents;

import Macro.Inputter;

public final class TypeComponent extends MacroComponent
{
    private final String phrase;

    /**
     * <p><code>MacroComponent</code> that represents a string of characters being typed successively.</p>
     * @param phrase String of characters to be typed.
     */
    public TypeComponent(String phrase)
    {
        this.phrase = phrase;
    }

    public String getPhrase()
    {
        return phrase;
    }

    @Override
    public void performAction(Inputter inputter)
    {
        inputter.type(phrase);
    }

    @Override
    public String toString()
    {
        return "type " + phrase;
    }
}