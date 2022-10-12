package File;

import Backend.Main;

import java.io.*;
import java.util.Scanner;

public class FileManager
{
    PrintWriter output;
    FileWriter writer;
    public FileManager()
    {

    }

    public void saveFile(String fileName) throws IOException
    {
        Main.manager.updateAllComponents();

        // String should be "./Macros/" in the actual program
        writer = new FileWriter("C:/Users/sidek/Desktop/Macros/" + fileName + ".txt");
        output = new PrintWriter(writer);

        output.write(Main.manager.toString());

        output.close();
        writer.close();
    }

    public String loadFile(String fileName) throws FileNotFoundException
    {

        // String should be "./Macros/" in the actual program
        Scanner fileReader = new Scanner(new File("C:/Users/sidek/Desktop/Macros/" + fileName + ".txt"));
        fileReader.useDelimiter("\n");
        StringBuilder contents = new StringBuilder();

        while (fileReader.hasNext())
        {
            contents.append(fileReader.next());
            contents.append("\n");
        }


        System.out.println(contents);
        return contents.toString();
    }
}
