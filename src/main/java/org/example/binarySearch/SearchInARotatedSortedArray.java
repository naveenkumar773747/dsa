package org.example.binarySearch;

/*
    "Given a sorted rotated array, return the minimum element from it.

    Examples:
        int[] arr1 = {5, 6, 1, 2, 3, 4};    //Return 1
        int[] arr2 = {1, 2, 3, 4};          //Return 1
 */
public class SearchInARotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 2, 3, 4, 5, 6};
        int target = 8;
        int index = searchFromRotatedSortedArray(arr,target);
        System.out.println("Integer found at = "+ index);
    }

    protected static int searchFromRotatedSortedArray(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target) return mid;

            if(arr[start]<=arr[mid]){
                if(arr[start]<=target && target<=arr[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
