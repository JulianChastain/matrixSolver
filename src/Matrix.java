import java.util.Scanner;
public class Matrix {

    private int[][] entries;

    //sub function to find a nonzero row, works by finding the row with the value of the greatest abolute value
    //in the column specified
    private int rowWithGreatestValue(int i){
        return 0;
    }

    //helper function to add two vectors together, returning the subsequent sum vector
    private int[] vectoradd(int[] vectOne, int[] vectTwo) {
        int [] newEntries = new int[vectOne.length];
        if(vectOne.length==vectTwo.length)
            for(int i = 0; i < vectOne.length; i++)
                newEntries[i] = vectOne[i] + vectTwo[i];
        return newEntries;
    }

    //helper function to multiply a vector by a scalar
    private int[] scale(int[] vect, int scalar){
        int [] newEntries = new int[vect.length];
        for(int i = 0; i <newEntries.length; i++){
            newEntries[i] = vect[i] * scalar;
        }
        return newEntries;
    }

    //helper function to determine whether a column is all zeroes, with an optional
    //parameter to specify how many rows to ignore
    private boolean isZero(int col, int startRow){
        for(int i = startRow; i < entries.length; i++)
            if(entries[i][col] != 0)
                return false;
        return true;
    }

    //constructor for a matrix from two ints that specify the dimensions, will prompt the user
    //for the actual values
    Matrix(int row, int column){
        Scanner input = new Scanner(System.in);
        entries = new int[row][column + 1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column + 1; j++){
                System.out.println("Enter the " + (j+1) + "th element of the " + (i+1) + "th equation");
                entries[i][j] = input.nextInt();
            }
        }
    }

    //constructor for the matrix from one 2d array which will simply be assigned as the entries array
    Matrix(int[][] values){
        entries = values;
    }

    //Will print out all of the entries in the matrix in order
    public String toString(){
        String str = "";
        for(int[] vec : entries){
            for(int num:vec){
                str = str.concat(num + " ");
            }
            str = str.concat("\n");
        }
        return str;
    }

    //implementing a four step algorithm to reduce rows down to echelon form
    public void rowReduction(int rowsIgnored){
        if(rowsIgnored < entries.length){
            int i;
            for(i = 0; (i < entries[0].length) && isZero(i, rowsIgnored); i++);
            if(rowsIgnored != rowWithGreatestValue(i))
                interchange(rowsIgnored, rowWithGreatestValue(i));
        }
    }

    //elementary row opertaion to swap the positions of two rows in the matrix
    public void interchange(int i, int r){
        System.out.println("Swapping row " + i + " and row " + r);
        i--; r--;
        if(i >= 0 && r >= 0 && i < entries.length && r < entries.length){
            int[] temp = entries[i];
            entries[i] = entries[r];
            entries[r] = temp;
        }
    }

    //Elementary row operation to replace one row with the sum of itself and another row times
    //a scalar
    public void replace(int rowReplaced, int rowAdded, int scalar){
        System.out.println("Replacing row " + rowReplaced + " with " + scalar + " times row " + rowAdded);
        entries[rowReplaced-1] = vectoradd(entries[rowReplaced-1], scale(entries[rowAdded-1], scalar));
    }

}
