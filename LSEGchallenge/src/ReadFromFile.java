import matrix.MatrixProcessing;
import upgradedMatrix.UpgradedMatrix;

import javax.management.MBeanAttributeInfo;
import java.io.*;


import static matrix.MatrixProcessing.*;
import static textProcessing.TextProcessingUtils.*;
import static upgradedMatrix.UpgradedMatrix.*;

public class ReadFromFile {

    public static void main(String[] args) throws Exception {

        String path="res\\coding_challenge_input.txt";

        BufferedReader br = getBRfromPath(path);

        MatrixProcessing matrixProcessing=new MatrixProcessing();
        UpgradedMatrix upgradedMatrix=new UpgradedMatrix();

        String line;
        int[] instruction;

        while ((line = br.readLine()) != null)
        {
           //System.out.println(line);
           instruction = getInstructionsFromLine(line);
           matrixProcessing.operation(instruction);
           upgradedMatrix.upgradedOperation(instruction);
        }

        System.out.println("The number of lights turned on is:");
        System.out.println(matrixProcessing.countLightsOn());

        System.out.println("The number of lights turned on in the upgraded lights system is:");
        System.out.println(upgradedMatrix.upgradedCountLightsOn());


}
}
