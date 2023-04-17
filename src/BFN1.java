import java.util.Scanner;
public class BFN1 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        var tests = scanner.nextInt();
        while (tests-- > 0){
            var input = scanner.nextInt();
            var result = Solve(input);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static int[] Solve(int input){
        int counter = 0;
        while(!CheckForPalindrome(input)){
            var rev = ReverseInteger(input);
            input += rev;
            counter++;
        }
        return new int[]{input, counter};
    }

    static int ReverseInteger(int number){
        return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    static boolean CheckForPalindrome(int n){
        char[] chars = ("" + n).toCharArray();
        int len = chars.length;
        for(int i = 0; i < len / 2; i++){
            if(chars[i] != chars[len - i - 1])
                return false;
        }
        return true;
    }

}