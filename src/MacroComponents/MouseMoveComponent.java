package MacroComponents;

import Macro.Inputter;

public final class MouseMoveComponent extends MacroComponent
{
    private final int mouseX, mouseY;

    /**
     * <p><code>MacroComponent</code> that represents a singular mouse cursor movement.</p><p>Coordinates are measured in pixels, relative to the top left corner of the main screen.</p>
     * @param mouseX Desired X-coordinate of the mouse.
     * @param mouseY Desired Y-coordinate of the mouse.
     */
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
