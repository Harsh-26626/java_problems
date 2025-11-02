class CopyArray extends ArrayOperations {
    public static void main(String[] args) {

        int[] x = takeInput();

        int[] y = new int[x.length];

        for(int i = 0, n = x.length; i < n; i++) 
            y[i] = x[i];

        System.out.print("Old Array x = ");
        
        for(int i: x)
            System.out.print(i + " ");
        
        System.out.print("\nNew Array y = ");

        for(int i: y)
            System.out.print(i + " ");
    }
}