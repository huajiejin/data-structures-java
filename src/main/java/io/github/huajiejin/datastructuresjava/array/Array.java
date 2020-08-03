package io.github.huajiejin.datastructuresjava.array;

public class Array {
    public static void main(String[] args) {
        int[] scores = new int[]{1,3,5};

        System.out.println("scores is: " + scores);

        for(int i=0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        scores[0] = 100;

        for(int score: scores)
            System.out.println(score);
    }
}
