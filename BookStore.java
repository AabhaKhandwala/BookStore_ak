import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

    private ArrayList<String> titles;
    public ArrayList<String> usedBooks;
    public String storeName;
    public String storeAddress;
    public double storeSize;// Square Feet*
    public String workDays;
    public String openHrs;
    public boolean openWeekends;

    public BookStore(String storeName, String storeAddress, double storeSize, String workDays, String openHrs) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeSize = storeSize;
        this.openHrs = openHrs;
        this.workDays = workDays;

        titles = new ArrayList<String>();
        usedBooks = new ArrayList<>();
        loadTitles();
    }

    public void printStoreDetails() {
        System.out.println(" Store: " + storeName + "\n Address: " + storeAddress + "\n size: " + storeSize
                + "\n open hours: " + openHrs + "\n Open Days: " + workDays);
    }

    public void isOpen(String day) {
        if (day.equalsIgnoreCase("saturday") || day.equalsIgnoreCase("sunday")) {
            System.out.println("it's a weekend!! Store is closed!");
        } else {
            System.out.println("plz visit the store, we are Open!!");
        }
    }

    public void hasUsedBooks() {
        for (String s : titles) {
            if (s.contains("used")) {
                usedBooks.add(s);
            }
        }
        // System.out.println("Sorry,we dont have used books in stock.");
        if (usedBooks.size() != 0) {
            System.out.println("list of used Books:");
            for (String l : usedBooks) {
                System.out.println(l);
            }
        } else {
            System.out.println("Sorry,We don't have used books.");
        }
    }

    private void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles);
        } catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();

        }
    }

    public void listBooks() {
        for (String s : titles)
            System.out.println(s);
    }

    public static void main(String[] args) {

        boolean quit = false;
        BookStore myBkStore = new BookStore("luckyStore", "ABC St,charlotte-NC", 2500, "Monday-Friday",
                "9.00am-7.00pm");

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("1) Print store details");
            System.out.println("2) List the titles of all the books in stock (in the Bookstore object)");
            System.out.println("3) check if store is open today or not");
            System.out.println("4) check if store has used books or not");
            System.out.println("5) Quit");
            System.out.println();
            System.out.print("Enter choice [1-5]: ");

            int user_choice = scan.nextInt();
            switch (user_choice) {
                case 1:
                    myBkStore.printStoreDetails();
                    break;
                case 2:
                    System.out.println("Print list of books: ");
                    myBkStore.listBooks();
                    break;
                case 3:
                    System.out.println("Enter day");
                    String day = scan.next();
                    myBkStore.isOpen(day);
                    break;
                case 4:
                    myBkStore.hasUsedBooks();
                    break;
                case 5:
                    System.out.println("Thanks for coming!!");
                    quit = true;
                    break;
                default:
                    System.out.println("\nInvalid Choice");
            }
        } while (!quit);
        scan.close();

    }

}
