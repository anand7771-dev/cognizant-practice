package dsa;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = {5, 10, 15, 20, 25, 30, 35};

        int key = 20;

        int index = search(arr, key);

        if(index != -1) {
            System.out.println("Element Found at Index " + index);
        } else {
            System.out.println("Element Not Found");
        }
    }

    static int search(int arr[], int key) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {

            int mid = (start + end) / 2;

            if(arr[mid] == key) {
                return mid;
            }

            if(arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}