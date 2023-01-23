package Backend;

import MacroComponents.TypeComponent;

/*
 * This is a streamlines, GUI-less version of the actual macro software.
 * Instead of programming a macro via the gui, you use the macro classes like a library to program and run your macro
 * This "Main" class is an example, you can modify it or create additional main methods to create your own macros.
 */
public class Main
{
    public static void main(String[] args)
    {
        MacroManager manager = new MacroManager();
        manager.add(new TypeComponent("Hello! This is an example macro."));
        manager.runMacro();
    }
}