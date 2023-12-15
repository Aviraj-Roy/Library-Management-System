import java.util.Scanner;

public class Book {

    // Class data members
    public int serialNumber;
    public String bookName;
    public String authorName;
    public int quantity;
    public int copyQuantity;

    Scanner input = new Scanner(System.in);

    // Constructor to add book details
    public Book() {

        System.out.println("Enter the Serial No. of Book:");
        this.serialNumber = input.nextInt();
        input.nextLine();

        System.out.println("Enter the Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter the Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter the No. of Books:");
        this.quantity = input.nextInt();
        copyQuantity = this.quantity;
    }
}