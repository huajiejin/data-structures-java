package io.github.huajiejin.leetcode.util;

import java.util.ArrayList;
import java.util.Random;

public class TestcaseGenerator {

    private Random random = new Random();

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            TestcaseGenerator generator = new TestcaseGenerator();
            generator.randomIntArray(new int[]{1,100}, new int[]{10,30});
        }
    }

    private void randomIntArray(int[] itemRange, int[] lengthRange) {
        ArrayList<Integer> l = new ArrayList<>();
        int len = random.ints(lengthRange[0], lengthRange[1]).findFirst().getAsInt();
        for (int i = 0; i < len; i++) {
            int item = random.ints(itemRange[0], itemRange[1]).findFirst().getAsInt();
            l.add(item);
        }
        System.out.println(l);
    }
}
