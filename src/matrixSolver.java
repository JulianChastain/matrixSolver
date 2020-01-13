public class matrixSolver {
    public static void main(String[] args) {
        int [][]v = {{0,1,-4,8},{2,-3,2,1},{4,-8,12,1}};
        Matrix m = new Matrix(v);
        System.out.println(m);
        m.interchange(1,2);
        System.out.println(m);
        m.replace(3,1,-2);
        System.out.println(m);
        m.replace(3,2,2);
        System.out.println(m);

    }
}
