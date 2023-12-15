import java.util.Scanner;

public class StudentsManager {

    Scanner input = new Scanner(System.in);
    Student[] registeredStudents = new Student[50];

    public static int count = 0;

    // Add students
    public void addStudent(Student student) {
        for (int i = 0; i < count; i++) {
            if (student.registrationNumber.equalsIgnoreCase(registeredStudents[i].registrationNumber)) {
                System.out.println("Student with Reg Num " + student.registrationNumber + " is Already Registered.");
                return;
            }
        }

        if (count <= 50) {
            registeredStudents[count] = student;
            count++;
        }
    }

    // Display all students
    public void showAllStudents() {
        System.out.println("Student Name\t\tReg No.");
        for (int i = 0; i < count; i++) {
            System.out.println(registeredStudents[i].studentName + "\t\t" + registeredStudents[i].registrationNumber);
        }
    }

    // Check if a student is registered
    public int isStudent() {
        System.out.println("Enter Reg No.:");
        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {
            if (registeredStudents[i].registrationNumber.equalsIgnoreCase(regNum)) {
                return i;
            }
        }

        System.out.println("Student is Not Registered.");
        System.out.println("Please Register The Student.");

        return -1;
    }

    // Check out a book
    public void checkOutBook(BooksManager booksManager) {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("Book Checking out");

            booksManager.showAllBooks();
            Book book = booksManager.checkOutBook();

            System.out.println("Book Checking out");
            if (book != null) {
                if (registeredStudents[studentIndex].booksCount <= 3) {
                    System.out.println("Adding the book");
                    registeredStudents[studentIndex].borrowedBooks[registeredStudents[studentIndex].booksCount] = book;
                    registeredStudents[studentIndex].booksCount++;
                    return;
                } else {
                    System.out.println("Student Cannot Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book Unavailable.");
        }
    }

    // Check in a book
    public void checkInBook(BooksManager booksManager) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");

            Student student = registeredStudents[studentIndex];

            for (int i = 0; i < student.booksCount; i++) {
                System.out.println(
                        student.borrowedBooks[i].serialNumber + "\t\t\t"
                                + student.borrowedBooks[i].bookName + "\t\t\t"
                                + student.borrowedBooks[i].authorName);
            }

            System.out.println("Enter Serial Number of Book to be Checked In:");
            int serialNumber = input.nextInt();

            for (int i = 0; i < student.booksCount; i++) {
                if (serialNumber == student.borrowedBooks[i].serialNumber) {
                    booksManager.checkInBook(student.borrowedBooks[i]);
                    student.borrowedBooks[i] = null;
                    return;
                }
            }

            System.out.println("Book of Serial Number " + serialNumber + " not Found");
        }
    }
}