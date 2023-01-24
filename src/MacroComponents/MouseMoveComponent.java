package MacroComponents;

import Manager.Inputter;

public final class MouseMoveComponent extends MacroComponent
{
    private final int mouseX, mouseY;

    public MouseMoveComponent(int mouseX, int mouseY)
    {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public int getMouseX()
    {
        return mouseX;
    }

    public int getMouseY()
    {
        return mouseY;
    }

    @Override
    public void performAction(Inputter inputter)
    {
        inputter.mouseTo(mouseX, mouseY);
    }

    @Override
    public String toString()
    {
        return "move " + mouseX + " " + mouseY;
    }
}
