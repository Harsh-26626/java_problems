import java.util.Scanner;

class Compare2 {
    // array with 5 positions by default
    int[] arr = new int[5];

    // stores the length of array with valid user entered values.
    int arr_position = 0;

    // Constructor calls take input function.
    Compare2(Scanner sc) {
        System.out.println("Input -1 for to stop accepting more values!\n");
        takeInput(sc);
    }

    void takeInput(Scanner sc) {
        // stores the lastly entered number by user.
        int storeNumber;

        while (true) {
            // prompts user for input.
            System.out.print("Number " + (arr_position + 1) + " for array: ");
            storeNumber = sc.nextInt();

            // if user input number is -1 then loop stops otherwise arrayAdd() method is called.
            if(storeNumber == -1)
                break;
            arrayAdd(storeNumber);
        }

        // Shows numbers entered by user for current array.
        System.out.print("\nNumers are: ");
        for(int i = 0; i < arr_position; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    // stores user input in arr[]
    void arrayAdd(int num) {

        // if there is memory left for more numbers in arr[] then we store the input.
        if ((arr_position + 1) < arr.length) {
            arr[arr_position] = num;
            arr_position++;
        }
        // else if there is no more memory to store more numbers then we,
        // increase the size of array by 5.
        else if ((arr_position + 1) == arr.length) {
            int[] new_arr = new int[arr.length + 5];
            System.arraycopy(arr, 0, new_arr, 0, arr.length);
            arr = new_arr;
            arr[arr_position] = num;
            arr_position++;
        }
    }

    public static void main(String[] args) {
        // scanner used to take input from user.
        Scanner inputScanner = new Scanner(System.in);

        // taking input for first array.
        System.out.println("Enter numbers for first array, one at a time: ");
        Compare2 firstArray = new Compare2(inputScanner);

        // taking input for second array.
        System.out.println("\n\nEnter numbers for second array, one at a time: ");
        Compare2 secondArray = new Compare2(inputScanner);

        // printing common numbers
        System.out.print("\n\nCommon numbers are: ");

        // compares each number of first array with each number of second array
        // and prints out the common numbers.
        for(int i = 0; i < firstArray.arr_position; i++) {
            for(int j = 0; j < secondArray.arr_position; j++) {
                if(firstArray.arr[i] == secondArray.arr[j]) {
                    System.out.print(firstArray.arr[i] + ", ");
                }
            }
        }

        inputScanner.close();
    }
}