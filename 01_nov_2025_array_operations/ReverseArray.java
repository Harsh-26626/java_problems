class ReverseArray extends ArrayOperations{
    public static void main(String[] args) {

        int[] x = takeInput();

        int[] y = new int[x.length];

        for(int i = 0, n = y.length; i < n; i++) {
            y[n - i - 1] = x[i];
        }

        System.out.print("Old Array x = ");
        printArray(x);

        System.out.print("\nNew Array y = ");
        printArray(y);
    }
}