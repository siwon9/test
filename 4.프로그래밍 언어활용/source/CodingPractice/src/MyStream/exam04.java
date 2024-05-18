package MyStream;

import java.util.Optional;

public class exam04 {
    public static void main(String[] args) {
        Optional<String> val = Optional.of("hello");

        String str = null;
        Optional<String> val2 = Optional.ofNullable(str);

        Optional<String> val3 = Optional.empty();
    }
}
