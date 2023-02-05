package jdk;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        String str = empty.map(Object::hashCode).map(Object::toString).orElse("?!");
        System.out.println(str);

    }

}
