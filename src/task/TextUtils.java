package task;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param  text
     * @return sorted by natural order array of unique words
     * */
    public static String[] getUniqueSortedWords(String text) {
//        TODO find mistake and correct it, so the method works correctly
        String[] words = getWords(text);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }
    /**
     * @param text
     * @return array with words, get from receive text
     *          if received argument is null
     *          or text length is zero
     *          return array with zero length
     * */
    public static String[] getWords(String text) {

//        TODO write your code here
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        return text.split("; ");
    }


    /**
     * @param words array with words
     * @return  array with unique words
     * */
    public static String[] getUniqueWords(String[] words) {
        if (words == null || words.length == 0) return words;
        return copyUniqueWords(words);
    }

    public static String[] copyUniqueWords(String[] array) {
        String[] dstArray = new String[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (!contains(dstArray, array[i])) {
                dstArray[counter++] = array[i];
            }
        }
        return trimArray(dstArray, counter);
    }

    public static String[] trimArray(String[] array, int length) {
        String[] trimmedArray = new String[length];

        for (int i = 0; i < length; i++) {
            trimmedArray[i] = array[i];
        }
        return trimmedArray;
    }

    public static boolean contains(String[] array, String word) {
        for (int i = 0; i < array.length; i++) {
            if (word != null && word.equals(array[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param  uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     * */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here
        boolean sorted = false;
        String tmp;

        while (!sorted) {
            sorted = true;
            for (int i = 1; i < uniqueWords.length; i++) {
// compareTo() returns a value less than 0 if the argument is a string lexicographically greater than this string
                if (uniqueWords[i-1].compareTo(uniqueWords[i]) > 0) {
                    sorted = false;
                    tmp = uniqueWords[i-1];
                    uniqueWords[i-1] = uniqueWords[i];
                    uniqueWords[i] = tmp;
                }
            }
        }

        return uniqueWords;
    }
}
