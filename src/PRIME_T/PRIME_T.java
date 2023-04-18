package PRIME_T;

import java.util.Scanner;

public class PRIME_T {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        var testsNumber = scanner.nextInt();
        while(testsNumber-- > 0){
            var input = scanner.nextInt();
            System.out.println(CheckForPrimeNumber(input) ? "TAK" : "NIE");
        }
    }
    public static boolean CheckForPrimeNumber(int num){
        if(num == 1)
            return false;

        if (num == 2 || num == 3)
            return true;

        if (num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(num); i = i + 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }
}
