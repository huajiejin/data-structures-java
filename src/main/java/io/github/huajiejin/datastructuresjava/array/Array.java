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

        int[] ret = Array.selectionSort(new int[]{8,4,9,2,3,-1});
        ret = Array.selectionSort(new int[]{-1});
        ret = Array.selectionSort(null);
    }

    public static int[] selectionSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        for (int i=0; i<arr.length; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Array.swap(arr, i, minIndex);
        }
        return arr;
    }

    private static int[] swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
        return arr;
    }
}
