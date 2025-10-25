package src.service;
import src.dao.BookDAO;
import src.model.Book;
import java.util.List;

public class LibraryService {
    private BookDAO bookDAO = new BookDAO();

    public void addNewBook(Book book) {
        bookDAO.addBook(book);
    }
    public void updateBook(Book book) {
    bookDAO.updateBook(book);
}

public void deleteBook(int bookId) {
    bookDAO.deleteBook(bookId);
}

    public void listAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        System.out.println("\nAll Books:");
        for (Book b : books) {
            System.out.println(b.getBookId() + " - " + b.getTitle());
        }
    }
}
