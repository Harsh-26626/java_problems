class SwapArray extends ArrayOperations {
    public static void main(String[] args) {
        int[] x = takeInput();

        System.out.print("Array x before swapping elements: ");
        printArray(x);

        int tmp;

        for(int i = 0, n = x.length; i < (int)n/2; i++) {
            tmp = x[i];
            x[i] = x[n - i - 1];
            x[n - i - 1] = tmp;
        }

        System.out.print("Array x after swapping elements:  ");
        printArray(x);

    }
}