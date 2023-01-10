package textProcessing;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static textProcessing.TextProcessingUtils.getInstructionsFromLine;

class TextProcessingUtilsTest {

    @Test
    void testWrongPathGetBRfromPath() throws Exception {
       String path="res\\test_instructionsssss.txt";
        assertThrows(FileNotFoundException.class, () ->
        { TextProcessingUtils.getBRfromPath(path);});
    }

    @Test
    void testGetBRfromPath() throws FileNotFoundException {
        String path="res\\test_instructions.txt";
        BufferedReader br = TextProcessingUtils.getBRfromPath(path);
        assertNotNull(br);
    }

    @org.junit.jupiter.api.Test
    void testGetInstructionsFromLineExists() {
        String line="turn off 923,196 through 980,446";
        int[] instruction = TextProcessingUtils.getInstructionsFromLine(line);
        assertEquals(5, instruction.length);
        assertNotNull(instruction);
    }

    @Test
    void testGetInstructionsFromLineWrongFormatCoordinated(){
        String line="turn off 923,196aa through 980,446";
        assertThrows(NumberFormatException.class, () ->
        { TextProcessingUtils.getInstructionsFromLine(line);});
    }

    @Test
    void testGetInstructionsFromLineWrongFormatCode(){
        String line="turnoff 923,196 through 980,446";
        assertThrows(IllegalStateException.class, () ->
        { TextProcessingUtils.getInstructionsFromLine(line);});
    }

    @Test
    void testGetInstructionsFromLineOK() {
        String line="turn off 923,196 through 980,446";
        int[] instruction = TextProcessingUtils.getInstructionsFromLine(line);
        for(int i=0;i<5;i++)
            assertTrue(instruction[i]>=0&&instruction[i]<1000);
    }




}