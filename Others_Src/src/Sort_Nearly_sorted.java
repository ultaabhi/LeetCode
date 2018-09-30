import java.util.PriorityQueue;

public class Sort_Nearly_sorted {

    /*

    https://www.geeksforgeeks.org/nearly-sorted-algorithm/

    Given an array of n elements, where each element is at most k away from its target position, devise an algorithm
    that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array,
    can be at indexes 5, 6, 7, 8, 9 in the given array.
     */

    public static void main(String[] args){
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };

        int[] res = sortK(arr, arr.length, k);
        for(int n : res){
            System.out.println(n);
        }

    }

    private static int[] sortK(int[] arr, int length, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        int count = 0;
        while(count < k+1){
            pq.offer(arr[count]);
            count++;
        }

        int index = 0;

        for(int i = k+1; i<arr.length; i++){
            arr[index++] = pq.poll();
            pq.offer(arr[i]);
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }

        return arr;

    }
}
