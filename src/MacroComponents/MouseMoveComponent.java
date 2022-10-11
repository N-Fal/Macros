package MacroComponents;

import Backend.Inputter;

public class MouseMoveComponent extends MacroComponent
{
    private int mouseX, mouseY;

    public MouseMoveComponent(int mouseX, int mouseY)
    {
        super(MacroType.MOUSE_MOVE);
        this.mouseX = mouseX;
        this.mouseY = mouseY;

        this.setType(MacroType.MOUSE_MOVE);
    }

    public void setMouseX(int mouseX)
    {
        this.mouseX = mouseX;
    }

    public int getMouseX()
    {
        return mouseX;
    }

    public void setMouseY(int mouseY)
    {
        this.mouseY = mouseY;
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
