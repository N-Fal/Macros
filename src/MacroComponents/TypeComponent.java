package MacroComponents;

import Manager.Inputter;

public final class TypeComponent extends MacroComponent
{
    private final String phrase;

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