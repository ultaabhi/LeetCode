/**
 * Created by ABHI on 8/31/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Helloworld {
    public static void main(String[] args) {


        int[] arr={5,5,2,2,3,6,6,8,3};
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }

        }

    }
}
