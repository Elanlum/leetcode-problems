package main.introduction;

public class DuplicateZeroes {

    public void duplicateZeros(int[] arr) {
        int countZeroes = 0;

        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == 0) {
                countZeroes++;
            }
        }

        int len = arr.length + countZeroes;

        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {//copy twice when hit '0'
                    arr[j] = arr[i];
                }
            }
        }
    }
}
