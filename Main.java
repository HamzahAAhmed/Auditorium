import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector filenames = new Vector();
        String auditorium;

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++)
        {
            File file = listOfFiles[i];

            if (file.isFile() && file.getName().toLowerCase().endsWith(".txt"))
            {
                //Read the file and load it into a 2-D array.
                filenames.add(file.getName().replace(".txt",""));
            }

        }
        auditorium = getAuditorium(filenames);
        try {
            Scanner fileSize = new Scanner(new BufferedReader(new FileReader(auditorium+".txt")));
            int rows = 0;
            int columns = 0;
            int tempRow=0;
            Scanner file = new Scanner(new BufferedReader(new FileReader(auditorium+".txt")));

            while (fileSize.hasNextLine()) {
                String line = fileSize.nextLine();
                rows++;

                for (int i = 0; i < line.length(); i++) {
                    columns=i+1;
                }
            }


            char [][] auditoriumSeats = new char[rows][columns];

            while (file.hasNextLine()){
                String line = file.nextLine();

                for (int i=0; i<line.length(); i++) {

                    auditoriumSeats[tempRow][i] = (line.charAt(i));
                }
                tempRow++;
                System.out.println();
            }


            getMenu();

            for (int i=0; i < auditoriumSeats.length; i++) {
                for (int j=0; j < auditoriumSeats[0].length; j++) {
                    System.out.print(auditoriumSeats[i][j]);
                }
             System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }



    }

    public static void getMenu() {
        System.out.println("Select 1 or 2 of the following options");
        System.out.println("1. Reserve Seats");
        System.out.println("2. Exit");

        Scanner input = new Scanner(System.in);
        int option;
        while (true) {
            option = input.nextInt();
            if (option==1 || option==2) {
                break;
            } else {
                System.out.println("Invalid option! Try again.");

            }
        }

        if (option == 2) {
            System.exit(0);
        }
    }


    public static String getAuditorium(Vector filenames) {
        System.out.println("Which of the following Auditoriums would you like to purchase seats in?");

        Scanner input = new Scanner(System.in);
        while (true) {
            for (int i=0; i < filenames.size(); i++) {
                System.out.print(filenames.elementAt(i) + " ");
            }
            System.out.println();
            String auditorium = input.nextLine();

            if (filenames.contains(auditorium)) {
                return auditorium;
            }

            System.out.println("Invalid option, try again!");
        }

    }
}
