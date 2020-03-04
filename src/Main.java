import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CDOrganizer myCDOrganizer = new CDOrganizer();
        startupOptions();
        Scanner inFile = new Scanner(new File("genre.txt"));
        String genreList = printGenreList(inFile);
        Scanner input = new Scanner(System.in);
        int userAnswer = input.nextInt();
        while (userAnswer != 4) {
            if (userAnswer == 1) {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter the artist: ");
                String artist = input1.nextLine().toUpperCase();
                System.out.print("Enter the CD title: ");
                String title = input1.nextLine().toUpperCase();
                System.out.print("Enter the year of the CD: ");
                int year = input1.nextInt();
                System.out.println(genreList);
                System.out.print("Enter the genre number for this CD: ");
                int genre = input1.nextInt();
                myCDOrganizer.insert(new CDLink(artist, title, genre, year, null));
                System.out.println();
            } else if (userAnswer == 2) {
                System.out.println();
                myCDOrganizer.viewList();
            } else if (userAnswer == 3) {
                Scanner searchInput = new Scanner(System.in);
                System.out.println("Search by (1) Artist or (2) Genre?");
                int search = searchInput.nextInt();
                if (search == 1) {
                    System.out.print("Enter Artist (all or partial name): ");
                    String blank = searchInput.nextLine();
                    String artistSearch = searchInput.nextLine();
                    System.out.println();
                    myCDOrganizer.artistSearch(artistSearch);
                } else if (search == 2) {
                    System.out.println(genreList);
                    System.out.print("Enter Genre number for which to search: ");
                    int genreSearch = searchInput.nextInt();
                    System.out.println();
                    myCDOrganizer.genreSearch(genreSearch);
                }
            }
            startupOptions();
            userAnswer = input.nextInt();
        }
        System.exit(0);
    }

    /**
     * Prints options for CD Organizer.
     */
    public static void startupOptions() {
        System.out.println(
                "CD Organizer -- Enter your choice\n" +
                        "1. Enter a New CD\n" +
                        "2. View all CDs\n" +
                        "3. Search for a CD\n" +
                        "4. Exit the program");
    }

    /**
     * Prints list of genre options from file genre.txt.
     * @param inFile the Scanner reading genre.txt
     * @return the genre list from genre.txt
     */
    public static String printGenreList(Scanner inFile) {
        String genreList = "";
        int lineNum = Integer.parseInt(inFile.nextLine());
        for (int i=0; i<lineNum+1; i++) {
            String s = inFile.nextLine();
            genreList += s + "\n";
        }
        return genreList;
    }
}