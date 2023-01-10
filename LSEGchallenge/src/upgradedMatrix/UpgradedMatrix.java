package upgradedMatrix;

public class UpgradedMatrix {
    public static final int rows=1000;
    public static final int columns=1000;

    private int[][] upgradedMatrix;

    public UpgradedMatrix(){
        upgradedMatrix=new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                upgradedMatrix[i][j] = 0;
    }
    public void upgradedOperation(int[] instruction) {

        switch (instruction[0]) {

            case 0:
                for (int i = instruction[1]; i <= instruction[3]; i++)
                    for (int j = instruction[2]; j <= instruction[4]; j++)
                        upgradedMatrix[i][j] = upgradedMatrix[i][j] + 1;
                break;

            case 1:
                for (int i = instruction[1]; i <= instruction[3]; i++)
                    for (int j = instruction[2]; j <= instruction[4]; j++)
                        if (upgradedMatrix[i][j] > 0)
                            upgradedMatrix[i][j] = upgradedMatrix[i][j] - 1;
                break;

            case 2:
                for (int i = instruction[1]; i <= instruction[3]; i++)
                    for (int j = instruction[2]; j <= instruction[4]; j++)
                        upgradedMatrix[i][j] = upgradedMatrix[i][j] + 2;
                break;
            default:
                throw new IllegalStateException("Unexpected instruction code: " + instruction[0]);
        }
    }

    public int upgradedCountLightsOn(){
        int sum=0;
        for(int i=0; i<rows; i++)
            for (int j=0; j<columns; j++){
               // System.out.println(upgradedMatrix[i][j]);
                sum+=upgradedMatrix[i][j];}
        return sum;
    }

}
