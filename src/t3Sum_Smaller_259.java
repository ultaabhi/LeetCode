import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class t3Sum_Smaller_259 {
    public static int threeSum(int[] nums, int target) {

        Arrays.sort(nums);

       int res = 0;

        for(int i = 0 ; i< nums.length-2; i++){

            if(i > 0 && (nums[i] == nums[i-1])) continue;

            int x = nums[i];
            int l = i+1;
            int r = nums.length-1;

            while(l<r){

                int sum = x+nums[l]+nums[r];
                if(sum<target){
                    res += r-l;
                    l++;
                }else{
                    r--;
                }


            }
        }
        return res;
    }

    public static void main(String[] args){

        int[] arr = new int[]{-2, 0, 1, 3};
        int target = 2;

        int res = threeSum(arr,target);
        System.out.println(res);

    }
}