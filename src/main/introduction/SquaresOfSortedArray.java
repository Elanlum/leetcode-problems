package main.introduction;

public class SquaresOfSortedArray {


    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int negIndex = -1;
        int posIndex = 0;
        int index = 0;

        //this cycle finds index where positive (sorted) part starts and squares each element
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < 0) {
                negIndex++;
            }
            nums[k] = nums[k] * nums[k];
        }
        posIndex = negIndex + 1;

        //sorting while positive and negative parts are present
        while(posIndex <= nums.length - 1 && negIndex >= 0) {
            if (nums[posIndex] > nums[negIndex]) {
                result[index] = nums[negIndex];
                negIndex--;
            } else {
                result[index] = nums[posIndex];
                posIndex++;
            }
            index++;
        }

        //sorting when only negative part is present
        while (negIndex >= 0) {
            result[index] = nums[negIndex];
            negIndex--;
            index++;
        }

        //sorting when only positive part is present
        while (posIndex <= nums.length - 1) {
            result[index] = nums[posIndex];
            posIndex++;
            index++;
        }


        return result;
    }
}

