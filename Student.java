import java.util.Scanner;

public class Student {

    // Class member variables
    String studentName;
    String registrationNumber;
    Book[] borrowedBooks = new Book[3];
    public int booksCount = 0;
    Scanner input = new Scanner(System.in);

    // Constructor
    public Student() {
        
        System.out.println("Enter Student Name:");
        // This keywords refers to current instance
        this.studentName = input.nextLine();
        System.out.println("Enter Registration Number:");
        this.registrationNumber = input.nextLine();
    }
}