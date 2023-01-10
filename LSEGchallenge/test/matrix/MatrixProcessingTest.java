package matrix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import textProcessing.TextProcessingUtils;

import static matrix.MatrixProcessing.*;
import static org.junit.jupiter.api.Assertions.*;

class MatrixProcessingTest {

    private MatrixProcessing matrix;

    @BeforeEach
    void initMatrixProcessing(){
        matrix =  new MatrixProcessing();
    }

    @Test
    void testOperationOK() {

        assertEquals(0, matrix.countLightsOn());
        int[] instruction1={0,0,0,999,999};
        int[] instruction2={1,499,499,500,500};
        int[] instruction3={2,0,499,999,500};
        matrix.operation(instruction1);
        assertEquals(1000000, matrix.countLightsOn());
        matrix.operation(instruction2);
        assertEquals(999996, matrix.countLightsOn());
        matrix.operation(instruction3);
        assertEquals(998004, matrix.countLightsOn());
    }


    @Test
    void testOperationValuesNegative() {

        int[] instruction={0,-2,0,999,999};

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        { matrix.operation(instruction);});
    }

    @Test
    void testOperationOver1000() {

        int[] instruction={0,0,0,9999,999};

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        { matrix.operation(instruction);});
    }

    @Test
    void testCountLightsOn() {
        assertNotNull(matrix.countLightsOn());
        System.out.println(matrix.countLightsOn());
    }
}