package exam01;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private int isbn; // number of book
    private String title; // name of book
    private String author; // author of book



    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn,title,author);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            Book book = (Book)obj;
            if (isbn == book.isbn && title.equals(book.title) && author.equals(book.author));{
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return isbn - o.isbn; // 오름차순
       // return o.isbn - isbn; // 내림차순
    }
}
