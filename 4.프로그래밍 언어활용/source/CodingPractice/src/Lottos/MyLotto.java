package Lottos;

import java.util.HashSet;
import java.util.Set;

public class MyLotto {
    public static void main(String[] args) {
        Set<Integer> lottos = new HashSet<>();

        while(lottos.size() < 6) {
            lottos.add((int)(Math.random() * 46) +1);
        }
        System.out.println(lottos);
    }
}
