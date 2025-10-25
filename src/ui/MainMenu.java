package src.ui;

import src.service.LibraryService;
import src.model.Book;
import java.util.Scanner;

public class MainMenu {
    private static LibraryService libraryService = new LibraryService();

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--Library Management System--");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
              System.out.println("4. View All Books");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Publisher ID: ");
                    int pub = sc.nextInt();
                    System.out.print("Category ID: ");
                    int cat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Language: ");
                    String lang = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    Book book = new Book(0, title, pub, cat, lang, price);
                    libraryService.addNewBook(book);
                    break;
               
                case 2: 
                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Publisher ID: ");
                    int newPub = sc.nextInt();
                    System.out.print("New Category ID: ");
                    int newCat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Language: ");
                    String newLang = sc.nextLine();
                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();
                    Book updatedBook = new Book(updateId, newTitle, newPub, newCat, newLang, newPrice);
                    libraryService.updateBook(updatedBook);
                    break;

                case 3: 
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    libraryService.deleteBook(deleteId);
                    break;

                 case 4:
                    libraryService.listAllBooks();
                    break;

                case 5: 
                    System.out.println("Exiting");
                    System.exit(0);

            }
        }
    }
}
