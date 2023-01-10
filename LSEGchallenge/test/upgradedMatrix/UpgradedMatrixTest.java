package upgradedMatrix;

import matrix.MatrixProcessing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static upgradedMatrix.UpgradedMatrix.*;

class UpgradedMatrixTest {

private UpgradedMatrix upgradedMatrix;
    @BeforeEach
    void createUpgradedMatrix(){
       upgradedMatrix=new UpgradedMatrix();
    }

    @Test
    void testUpgradedOperation(){

        assertEquals(0, upgradedMatrix.upgradedCountLightsOn());
        int[] instruction1={0,0,0,999,999};
        int[] instruction2={1,499,499,500,500};
        int[] instruction3={2,0,499,999,500};
        upgradedMatrix.upgradedOperation(instruction1);

        upgradedMatrix.upgradedOperation(instruction2);

        upgradedMatrix.upgradedOperation(instruction3);
        assertEquals(1003996, upgradedMatrix.upgradedCountLightsOn());

    }

    @Test
    void testUpgradedOperationValuesNegative() {
        int[] instruction={0,-2,0,999,999};

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        { upgradedMatrix.upgradedOperation(instruction);});
    }

    @Test
    void testUpgradedOperationOver1000() {
        int[] instruction={1,0,0,9999,999};

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        { upgradedMatrix.upgradedOperation(instruction);});
    }

    @Test
    void testUpgradedCountLightsOn() {

        assertNotNull(upgradedMatrix.upgradedCountLightsOn());
        System.out.println(upgradedMatrix.upgradedCountLightsOn());
    }

}