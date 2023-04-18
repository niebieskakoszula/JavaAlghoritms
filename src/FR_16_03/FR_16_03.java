package FR_16_03;

import java.util.Scanner;

public class FR_16_03 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        System.out.println(Solve(input));
    }

    /** This method changes only Snake case string to Camel case string */
    public static String Solve(String input){
        var array = input.toCharArray();
        var difference = 'a' - 'A';
        String result = "";
        for(int i = 0; i < array.length; i++){
            if(array[i] == '_'){
                array[i + 1] -= difference;
            }
            else{
                result += array[i];
            }
        }
        return result;
    }
}
