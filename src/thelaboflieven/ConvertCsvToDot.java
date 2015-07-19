package thelaboflieven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * dot -Tpng propro.txt -o outfile.png
 */
public class ConvertCsvToDot
{
    public static void main(String[] args) throws IOException {

        if (args.length != 1)
        {
            System.out.println("Usage: thelaboflieven.ConvertCsvToDot <csvFile>");
            System.exit(2);
        }
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        System.out.println("digraph G {");
        String line = reader.readLine();
        while (line != null)
        {
            String[] items = line.split(",");
            if (items.length >= 3)
            {
                String source = items[0].trim();
                String verb = items[1].trim();
                String directObject = items[2].trim();
                System.out.println("\""+source + "\"->\"" + directObject + "\"[label=\""+verb+"\"]");
            }
            line = reader.readLine();
        }

        System.out.println("}");
    }


}
