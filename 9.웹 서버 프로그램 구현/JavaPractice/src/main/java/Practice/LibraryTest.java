package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LibraryTest {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("자바2",25000));
        bookList.add(new Book("자바1",35000));
        bookList.add(new Book("자바3",45000));


        int totalPrice = bookList.stream().mapToInt(b->b.getPrice()).sum();
        System.out.println("모든 책 각격 합" + totalPrice);

        bookList.stream().filter(b -> b.getPrice() >= 20000).map(b ->b.getName()).sorted()
                .forEach(s-> System.out.println(s));

    }
}
