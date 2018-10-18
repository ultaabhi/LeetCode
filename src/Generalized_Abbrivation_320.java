import java.util.ArrayList;
import java.util.List;



/*

 Write a function to generate the generalized abbreviations of a word.
Example:
Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

public class Generalized_Abbrivation_320 {
    public static  List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }

    public static void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if(i==c.length){
            if(num>0)sb.append(num);
            res.add(sb.toString());
        }else{
            //abbrivate
            DFS(res,sb,c,i+1,num+1);//abbr c[i], so keep backtracking

            //keep character
            if(num>0)sb.append(num);//not abbr c[i], so 1. add num(>0)
            DFS(res,sb.append(c[i]),c,i+1,0);//2. appending c[i] to the solution, keep backtracking rest
        }
        sb.setLength(len);
    }

    public static void main(String[] args){
        String word = "word";

        List<String> res = new ArrayList<>();

        res = generateAbbreviations(word);

        System.out.println(res);


    }
}
