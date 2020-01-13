import java.util.Scanner;
public class Matrix {
    int[][] entries;
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

    public void interchange(int i, int r){
        i--; r--;
        if(i >= 0 && r >= 0 && i < entries.length && r < entries.length){
            int[] temp = entries[i];
            entries[i] = entries[r];
            entries[r] = temp;
        }
    }

    public void replace(int rowReplaced, int rowAdded, int scalar){
        entries[rowReplaced-1] = vectoradd(entries[rowReplaced-1], scale(entries[rowAdded-1], scalar));
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
}
