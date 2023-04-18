package ETI07E8;

import java.util.*;

public class ETI07E8 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        var wordsAmount = scanner.nextInt();
        var testsAmount = scanner.nextInt();
        scanner.nextLine();
        var words = new ArrayList<Tuple<Integer, String>>();
        String word;
        Integer simplifiedWord;
        while(wordsAmount-- > 0){
            word = scanner.nextLine();
            simplifiedWord = SimpleWordToNumber(word);
            words.add(new Tuple<Integer, String>(simplifiedWord, word));
        }
        var tests = new ArrayList<Integer>();
        while(testsAmount-- > 0){
            tests.add(scanner.nextInt());
        }

        var results = Solve(words, tests);
        for(var line : results){
            for(var result : line){
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<String>> Solve(ArrayList<Tuple<Integer, String>> data, ArrayList<Integer> queries){
        var results = new ArrayList<ArrayList<String>>();

        data = SortWordsWithSimplifiedNumbers(data);
        int a = 0;
        for(var query : queries){
            var tempResult = new ArrayList<String>();
            var firstIndex = BinarySearch(data, query);
            if(firstIndex == -1){
                tempResult.add("BRAK");
            }
            else{
                while(firstIndex >= 0 && data.get(firstIndex).first.equals(query)){
                    firstIndex--;
                }
                firstIndex++;
                while(firstIndex < data.size() && data.get(firstIndex).first.equals(query)){
                    tempResult.add(data.get(firstIndex).second);
                    firstIndex++;
                }
            }
            results.add(tempResult);
        }

        return results;
    }

    /** Simplifies words to numbers on phone keyboard that have to be used to write it
     * (without multiple clicks on same number) */
    public static Integer SimpleWordToNumber(String input){
        var array = input.toCharArray();
        var result = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            switch (array[i]){
                case 'a': case 'b': case 'c': result.append('2'); break;
                case 'd': case 'e': case 'f': result.append('3'); break;
                case 'g': case 'h': case 'i': result.append('4'); break;
                case 'j': case 'k': case 'l': result.append('5'); break;
                case 'm': case 'n': case 'o': result.append('6'); break;
                case 'p': case 'q': case 'r': case 's': result.append('7'); break;
                case 't': case 'u': case 'v': result.append('8'); break;
                case 'w': case 'x': case 'y': case 'z': result.append('9'); break;
            }
        }
        return Integer.parseInt(result.toString());
    }
    /** Sorts by first by Simplified Number and then by words alphabetically */
    public static ArrayList<Tuple<Integer, String>> SortWordsWithSimplifiedNumbers(ArrayList<Tuple<Integer, String>> words){
        Collections.sort(words, new Comparator<Tuple<Integer, String>>() {
            @Override
            public int compare(Tuple<Integer, String> lhs, Tuple<Integer, String> rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                var result = lhs.first.compareTo(rhs.first);
                if(result != 0)
                    return result;

                result = lhs.second.compareTo(rhs.second);
                return result;
            }
        });
        return words;
    }

    public static int BinarySearch(ArrayList<Tuple<Integer, String>> sortedArray, int key) {
        int index = -1;
        int low = 0, high = sortedArray.size() - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArray.get(mid).first < key) {
                low = mid + 1;
            } else if (sortedArray.get(mid).first > key) {
                high = mid - 1;
            } else if (sortedArray.get(mid).first == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
/** It's a tuple. Why java don't have tuples by default? */
class Tuple<X, Y> {
    public final X first;
    public final Y second;
    public Tuple(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}
