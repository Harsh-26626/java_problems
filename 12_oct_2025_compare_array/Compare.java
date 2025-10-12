class Compare {
    static final int[] arr1 = {5, 12, 9, 27, 6, 2, 11, 8, 13, 42};
    static final int[] arr2 = {15, 21, 9, 23, 7, 12, 78, 6, 3, 42};

    public static void main(String[] args) {
        System.out.print("Common numbers are: ");
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + ", ");
                }
            }
        }
    }
}