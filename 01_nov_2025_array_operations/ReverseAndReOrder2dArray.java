class ReverseAndReOrder2dArray extends ArrayOperations {
    public static void main(String[] args) {
        int[][] x = take2dInput();

        int[][] y = new int[x.length][];

        System.out.println();
        for(int i = 0, n = x.length; i < n; i++) {
            System.out.print("Values of x [" + i + "] = ");
            printArray(x[i]);
        }

        System.out.println("\nNow ReOrdering and Reversing all elements in y array: ");

        for(int i = 0, n = y.length; i < n; i++) {
            y[i] = new int[x[n - i - 1].length];
            for(int j = 0, m = y[i].length; j < m; j++) {
                y[i][j] = x[n - i - 1][m - j - 1];
            }
        }

        System.out.println();
        for(int i = 0; i < y.length; i++) {
            System.out.print("Values of y[" + i + "] = ");
            printArray(y[i]);
        }
    }
}