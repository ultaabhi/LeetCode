public class Valid_Palindrome_125 {

    public static void main(String[] args){
        String str = "A man, a plan, a canal: Panama";

        System.out.println(isValid(str));
    }

    public static boolean isValid(String str){
        str = str.trim();
        str = str.toLowerCase();

        int low = 0;
        int high = str.length()-1;

        while(low <= high){
            if(!Character.isLetter(str.charAt(low)))
                low++;
            else if(!Character.isLetter(str.charAt(high)))
                high--;

            else if(str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }else{
                return false;
            }
        }

        return true;
    }

}
