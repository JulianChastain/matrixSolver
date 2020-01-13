import java.util.Scanner;
public class Matrix {

    private int[][] entries;

    private int rowWithGreatestValue(int i){
        return 0;
    }
    private int[] vectoradd(int[] vectOne, int[] vectTwo) {
        int [] newEntries = new int[vectOne.length];
        if(vectOne.length==vectTwo.length)
            for(int i = 0; i < vectOne.length; i++)
                newEntries[i] = vectOne[i] + vectTwo[i];
        return newEntries;
    }
    private int[] scale(int[] vect, int scalar){
        int [] newEntries = new int[vect.length];
        for(int i = 0; i <newEntries.length; i++){
            newEntries[i] = vect[i] * scalar;
        }
        return newEntries;
    }
    private boolean isZero(int col, int startRow){
        for(int i = startRow; i < entries.length; i++)
            if(entries[i][col] != 0)
                return false;
        return true;
    }

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
    Matrix(int[][] values){
        entries = values;
    }

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

    public void rowReduction(int rowsIgnored){
        if(rowsIgnored < entries.length){
            int i;
            for(i = 0; (i < entries[0].length) && isZero(i, rowsIgnored); i++);
            if(rowsIgnored != rowWithGreatestValue(i))
                interchange(rowsIgnored, rowWithGreatestValue(i));
        }
    }

    public void interchange(int i, int r){
        System.out.println("Swapping row " + i + " and row " + r);
        i--; r--;
        if(i >= 0 && r >= 0 && i < entries.length && r < entries.length){
            int[] temp = entries[i];
            entries[i] = entries[r];
            entries[r] = temp;
        }
    }

    public void replace(int rowReplaced, int rowAdded, int scalar){
        System.out.println("Replacing row " + rowReplaced + " with " + scalar + " times row " + rowAdded);
        entries[rowReplaced-1] = vectoradd(entries[rowReplaced-1], scale(entries[rowAdded-1], scalar));
    }

}
