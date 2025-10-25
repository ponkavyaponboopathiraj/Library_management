package src.model;

public class Book {
    private int bookId;
    private String title;
    private int publisherId;
    private int categoryId;
    private String language;
    private double price;

    
    public Book(int bookId, String title, int publisherId, int categoryId, String language, double price) {
        this.bookId = bookId;
        this.title = title;
        this.publisherId = publisherId;
        this.categoryId = categoryId;
        this.language = language;
        this.price = price;
    }


    public int getBookId() { 
        return bookId; 
    }

    public void setBookId(int bookId) { 
        this.bookId = bookId; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public int getPublisherId() { 
        return publisherId; 
    }
    public void setPublisherId(int publisherId) { 
        this.publisherId = publisherId; 
    }

    public int getCategoryId() { 
        return categoryId; 
    }
    public void setCategoryId(int categoryId) { 
        this.categoryId = categoryId; 
    }

    public String getLanguage() { 
        return language; 
    }
    public void setLanguage(String language) { 
        this.language = language; 
    }

    public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }
}
