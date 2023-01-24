import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Person> personOData = new ArrayList<>();

        final int FIELDS_LENGTH = 5;

        String ID = "", firstName = "", lastName = "", title = "";
        int YOB = 0;

        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                int line = 0;
                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
                    System.out.println(rec);
                }
                reader.close();
                System.out.println();



                System.out.printf("%-10s%-15s%-15s%-6s%6s", "ID#", "FirstName", "LastName", "Title", "YOB");
                System.out.print("\n========================================================");
                String[] fields;
                for(String l:lines)
                {
                    fields = l.split(",");
                    if(fields.length == FIELDS_LENGTH)
                    {

                        ID = fields[0].trim();
                        firstName = fields[1].trim();
                        lastName = fields[2].trim();
                        title = fields[3].trim();
                        YOB = Integer.parseInt(fields[4].trim());
                        System.out.printf("\n%-10s%-15s%-15s%-6s%6d", ID, firstName, lastName, title, YOB);
                        personOData.add(new Person(firstName, lastName, ID, title, YOB));

                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println();
                    }
                }
                System.out.println();
            }
            else
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }

            for (Person p: personOData) {
                System.out.println(p.getFormalName());
            }
        }  // end of TRY
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
