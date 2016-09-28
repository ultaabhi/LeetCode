Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. 
We define a token to be one or more consecutive English alphabetic letters. 
Then, print the number of tokens, followed by each token on a new line.



import java.util.Scanner;

/**
 * Created by ABHI on 9/28/2016.
 */
public class StringTokenizer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String s = "He is a very very good boy, isn't he?";

        String[] str = s.split("[ !,?._'@]+");
        System.out.println(str.length);
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }
}
