package MacroComponents;

import Backend.Inputter;

public class TypeComponent extends MacroComponent
{
    private String phrase;

    public TypeComponent(String phrase)
    {
        super(MacroType.TYPE);
        this.phrase = phrase;

        this.setType(MacroType.TYPE);
    }

    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
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
