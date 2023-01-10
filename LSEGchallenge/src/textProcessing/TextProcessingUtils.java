package textProcessing;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextProcessingUtils {

    //function that takes the file path as an input and returns a bufferedReader to be processed
    public static BufferedReader getBRfromPath(String path) throws FileNotFoundException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br;
    }

    //input: buffered Reader
    //output: an array of integers, representing set of instructions
    // 0 - turn on
    // 1 - turn off
    // 2 - toggle
    // as well as the respective coordinates
    public static int[] getInstructionsFromLine(String line) throws NumberFormatException {
        int[] result = new int[5];

        String[] words = line.split("\\s");//splits the string based on whitespace
        int size = words.length;

        if (words[0].contains("toggle"))
            result[0] = 2;
        else
        if (words[1].contains("on"))
            result[0] = 0;
        else
        if (words[1].contains("off"))
            result[0] = 1;
        else
           throw new IllegalStateException("Unexpected instruction word :"+words[0]);
        //the first pair of coordinates can always be found at the position size-3,
        // regardless of the first 2 words (toggle/turn on or off)
        String[] values1 = words[size - 3].split(",");
        result[1] = Integer.parseInt(values1[0]);
        result[2] = Integer.parseInt(values1[1]);

        //the last word in the array is the second pair of coordinates
        String[] values2 = words[size - 1].split(",");
        result[3] = Integer.parseInt(values2[0]);
        result[4] = Integer.parseInt(values2[1]);

        return result;

    }
}



