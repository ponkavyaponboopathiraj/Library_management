package src.dao;

import src.util.DBConfig;
import src.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn = DBConfig.getConnection();

    //CREATE
    public void addBook(Book book) {
        String sql = "INSERT INTO book (title, publisher_id, category_id, language, price) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getPublisherId());
            stmt.setInt(3, book.getCategoryId());
            stmt.setString(4, book.getLanguage());
            stmt.setDouble(5, book.getPrice());
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    // READ (all books)
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                books.add(new Book(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getInt("publisher_id"),
                    rs.getInt("category_id"),
                    rs.getString("language"),
                    rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching books: " + e.getMessage());
        }
        return books;
    }

    //READ (single book by ID)
    public Book getBookById(int bookId) {
        String sql = "SELECT * FROM book WHERE book_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Book(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getInt("publisher_id"),
                    rs.getInt("category_id"),
                    rs.getString("language"),
                    rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error fetching book: " + e.getMessage());
        }
        return null;
    }

    //UPDATE
    public void updateBook(Book book) {
        String sql = "UPDATE book SET title = ?, publisher_id = ?, category_id = ?, language = ?, price = ? WHERE book_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getPublisherId());
            stmt.setInt(3, book.getCategoryId());
            stmt.setString(4, book.getLanguage());
            stmt.setDouble(5, book.getPrice());
            stmt.setInt(6, book.getBookId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found with ID: " + book.getBookId());
            }
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    //DELETE
    public void deleteBook(int bookId) {
        String sql = "DELETE FROM book WHERE book_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found with ID: " + bookId);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }
}
