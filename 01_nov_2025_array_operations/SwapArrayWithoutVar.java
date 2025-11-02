class SwapArrayWithoutVar extends ArrayOperations {
    public static void main(String[] args) {
        int x[] = takeInput();

        System.out.print("Array x before swapping elements: ");
        printArray(x);

        // Store sum in first number, then do Sum - 2nd number
        // (Sum - 2nd number) = 1st number, and we store this in position of 2nd number
        // now 1st number is present place of 2nd number
        // Doing Sum - 1st number = 2nd number we store this in position of 1st number
        for(int i = 0, n = x.length; i < (int)n/2; i++) {
            x[i] = x[i] + x[n - i - 1];
            x[n - i - 1] = x[i] - x[n - i - 1];
            x[i] -= x[n - i -1];
        }

        System.out.print("Array x after swapping elements:  ");
        printArray(x);

    }
}