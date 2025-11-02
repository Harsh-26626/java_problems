import java.io.Console;

class ArrayOperations {
    static Console c = System.console();

    static int[][] take2dInput() {
        int[][] arr = new int[1][];

        int arrayIndex = -1;
        int addMoreArraysOrNot = 0;

        do{
            arrayIndex++;
            System.out.println("\nTaking input for array[" + arrayIndex + "]: \n");
            if(arrayIndex < arr.length)
                arr[arrayIndex] = takeInput();
            else {
                int[][] tmp2d = new int[arrayIndex + 1][];
                int[] tmp1d;
                for(int i = 0, n = arr.length; i < n; i++) {
                    tmp1d = new int[arr[i].length];
                    tmp2d[i] = copyArray(arr[i], tmp1d);
                }
                arr = tmp2d;
                arr[arrayIndex] = takeInput();
            }

            System.out.print("Input for array[" + arrayIndex + "] complete!\n"+
                                "\nDo you want more 1D arrays inside base array?" +
                                "\nType 0 to continue, 1 to stop: ");
            addMoreArraysOrNot = Integer.parseInt(c.readLine());
        } while(addMoreArraysOrNot == 0);


        return arr;
    }

    static int[] takeInput() {
        

        int[] arr = new int[5];
        int input;
        int inputIndex = 0;
        int arrayLength = arr.length;

        System.out.println("Type - 1 to stop accepting more values\n");

        while(true) {
            System.out.print("Enter value for element " + (inputIndex + 1) + ": ");
            input = Integer.parseInt(c.readLine());
            if(input == -1) {
                int[] tmp = new int[inputIndex];

                for(int i = 0; i < tmp.length; i ++) {
                    tmp[i] = arr[i];
                }

                arr = tmp;
                break;
            }

            else {
                if(inputIndex < arrayLength) {
                    arr[inputIndex] = input;
                    inputIndex++;
                }
                else if(inputIndex == arrayLength) {
                    int[] tmp = new int[arrayLength + 5];
                    arr = copyArray(arr, tmp);
                    arr[inputIndex] = input;
                    arrayLength = arr.length;
                    inputIndex++;
                }
            }
        }
        System.out.println();
        return arr;
    }

    static int[] copyArray(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++)
            b[i] = a[i];
        return b;
    }

    static void printArray(int[] arr) {
        for(int next : arr) 
            System.out.print(next + " ");
        System.out.println();
    }
}