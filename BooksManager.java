import java.util.Scanner;

public class BooksManager {

    private Book[] libraryBooks = new Book[50];
    private int bookCount;
    private Scanner input = new Scanner(System.in);

    // Compare books
    private int compareBookObjects(Book book1, Book book2) {
        if (book1.bookName.equalsIgnoreCase(book2.bookName)) {
            System.out.println("Book with this name already exists.");
            return 0;
        }

        if (book1.serialNumber == book2.serialNumber) {
            System.out.println("Book with this serial no. already exists.");
            return 0;
        }
        return 1;
    }

    // Add book
    public void addBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (compareBookObjects(book, libraryBooks[i]) == 0) {
                return;
            }
        }

        if (bookCount < 50) {
            libraryBooks[bookCount] = book;
            bookCount++;
        } else {
            System.out.println("No space to add more books.");
        }
    }

    // Search book by serial number
    public void searchBySerialNumber() {
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        int serialNumber;
        System.out.println("Enter Serial Number of Book:");
        serialNumber = input.nextInt();

        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < bookCount; i++) {
            if (serialNumber == libraryBooks[i].serialNumber) {
                System.out.println(
                        libraryBooks[i].serialNumber + "\t\t"
                                + libraryBooks[i].bookName + "\t\t"
                                + libraryBooks[i].authorName + "\t\t"
                                + libraryBooks[i].copyQuantity + "\t\t"
                                + libraryBooks[i].quantity);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No " + serialNumber + " Found.");
    }

    // Search author by name
    public void searchByAuthorName() {
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

        input.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < bookCount; i++) {
            if (authorName.equalsIgnoreCase(libraryBooks[i].authorName)) {
                System.out.println(
                        libraryBooks[i].serialNumber + "\t\t"
                                + libraryBooks[i].bookName + "\t\t"
                                + libraryBooks[i].authorName + "\t\t"
                                + libraryBooks[i].copyQuantity + "\t\t"
                                + libraryBooks[i].quantity);
                flag++;
            }
        }

        if (flag == 0)
            System.out.println("No Books of " + authorName + " Found.");
    }

    // Display all books
    public void showAllBooks() {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < bookCount; i++) {
            System.out.println(
                    libraryBooks[i].serialNumber + "\t\t"
                            + libraryBooks[i].bookName + "\t\t"
                            + libraryBooks[i].authorName + "\t\t"
                            + libraryBooks[i].copyQuantity + "\t\t"
                            + libraryBooks[i].quantity);
        }
    }

    // Edit the book
    public void upgradeBookQty() {

        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int serialNumber = input.nextInt();

        for (int i = 0; i < bookCount; i++) {

            if (serialNumber == libraryBooks[i].serialNumber) {

                System.out.println("Enter No of Books to be Added:");
                int addingQty = input.nextInt();
                libraryBooks[i].quantity += addingQty;
                libraryBooks[i].copyQuantity += addingQty;
                return;
            }
        }
    }

    // Display menu
    public void displayMenu() {
        System.out.println("Please Select:- ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Enter 1 to Add a New Book.");
        System.out.println("Enter 2 to Upgrade Quantity of a Book.");
        System.out.println("Enter 3 to Search a Book.");
        System.out.println("Enter 4 to Show All Books.");
        System.out.println("Enter 5 to Register Student.");
        System.out.println("Enter 6 to Show All Registered Students.");
        System.out.println("Enter 7 to Check Out Book.");
        System.out.println("Enter 8 to Check In Book");
        System.out.println("Enter 0 to Exit Application.");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter your choice:- ");
    }

    // Check if a book is available
    public int isAvailable(int serialNumber) {
        for (int i = 0; i < bookCount; i++) {
            if (serialNumber == libraryBooks[i].serialNumber) {
                if (libraryBooks[i].copyQuantity > 0) {
                    System.out.println("Book Available.");
                    return i;
                }
                System.out.println("Book Unavailable");
                return -1;
            }
        }

        System.out.println("Book of Serial No. " + serialNumber + " Unavailable in Library.");
        return -1;
    }

    // Check out a book
    public Book checkOutBook() {
        System.out.println("Enter Serial Number of Book to be Checked Out.");
        int serialNumber = input.nextInt();

        int bookIndex = isAvailable(serialNumber);

        if (bookIndex != -1) {
            libraryBooks[bookIndex].copyQuantity--;
            return libraryBooks[bookIndex];
        }
        return null;
    }

    // Check in a book
    public void checkInBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (book.equals(libraryBooks[i])) {
                libraryBooks[i].copyQuantity++;
                return;
            }
        }
    }
}