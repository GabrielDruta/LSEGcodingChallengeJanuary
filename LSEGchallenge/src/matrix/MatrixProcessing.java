package matrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import static textProcessing.TextProcessingUtils.getBRfromPath;
import static textProcessing.TextProcessingUtils.getInstructionsFromLine;

public class MatrixProcessing {
    public static final int rows=1000;
    public static final int columns=1000;

    private int[][] matrix;

     public MatrixProcessing(){
        matrix=new int[rows][columns];
    }

    public void operation(int[] instruction){

        if(instruction[0]==0)
            for (int i= instruction[1]; i<=instruction[3]; i++)
                for(int j=instruction[2];j<=instruction[4];j++)
                    matrix[i][j]=1;
        else
        if(instruction[0]==1)
            for (int i= instruction[1]; i<=instruction[3]; i++)
                for(int j=instruction[2];j<=instruction[4];j++)
                    matrix[i][j]=0;
        else
        if(instruction[0]==2)
            for (int i= instruction[1]; i<=instruction[3]; i++)
                for(int j=instruction[2];j<=instruction[4];j++)
                    matrix[i][j]=1-matrix[i][j];
        else
            throw new IllegalStateException("Unexpected instruction word: " + instruction[0]);
    }


    public int countLightsOn(){
       int sum=0;
        for(int i=0; i<rows; i++)
            for (int j=0; j<columns; j++)
                sum=sum+matrix[i][j];
        return sum;
    }



}
