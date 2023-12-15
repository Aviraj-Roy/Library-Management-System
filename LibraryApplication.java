import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Displaying menu
        System.out.println("##################  Welcome to The Library of SIT  ##################");
        System.out.println("               Please Select From The Following Options:                    ");
        System.out.println("############################################################");

        // Object of BooksManager class
        BooksManager booksManager = new BooksManager();
        // Object of StudentsManager class
        StudentsManager studentsManager = new StudentsManager();

        int choice;
        int searchChoice;

        // Menu
        do {
            booksManager.displayMenu();
            choice = input.nextInt();

            // Switch case
            switch (choice) {
                // Case 1: Add a new Book
                case 1:
                    Book newBook = new Book();
                    booksManager.addBook(newBook);
                    break;
                // Case 2: Upgrade Quantity of a Book
                case 2:
                    booksManager.upgradeBookQty();
                    break;
                // Case 3: Search a Book
                case 3:
                    System.out.println("Enter 1 to Search with Book Serial No.");
                    System.out.println("Enter 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();
                    switch (searchChoice) {
                        // Case 1: Search by Book Serial No.
                        case 1:
                            booksManager.searchBySerialNumber();
                            break;
                        // Case 2: Search by Book's Author Name
                        case 2:
                            booksManager.searchByAuthorName();
                            break;
                    }
                    break;
                // Case 4: Show All Books
                case 4:
                    booksManager.showAllBooks();
                    break;
                // Case 5: Register a new Student
                case 5:
                    Student newStudent = new Student();
                    studentsManager.addStudent(newStudent);
                    break;
                // Case 6: Show All Registered Students
                case 6:
                    studentsManager.showAllStudents();
                    break;
                // Case 7: Check Out Book
                case 7:
                    studentsManager.checkOutBook(booksManager);
                    break;
                // Case 8: Check In Book
                case 8:
                    studentsManager.checkInBook(booksManager);
                    break;
                // Default case
                default:
                    System.out.println("Enter the choice properly(0-8).");
            }
        } while (choice != 0);

        input.close();
    }
}