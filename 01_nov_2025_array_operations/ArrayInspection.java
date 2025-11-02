import java.io.Console;

class ArrayInspection extends ArrayOperations {
    int[] x;
    int max = -2147483648;;
    int max2 = -2147483648;;
    int min = 2147483647;
    int min2 = 2147483647;
    int sum;
    int[] oddValues;
    int evenCount;
    int greaterThanThis;
    int[] greaterNumbers;

    ArrayInspection(int[] x, Console c) {
        this.x = x;
        this.oddValues = new int[this.x.length];
        this.greaterNumbers = new int[this.x.length];
        System.out.print("The array created by your inputs is: ");
        printArray(x);
        System.out.print("Enter any number, ");
        System.out.print("\nWe will check and print all numbers which are greater than this number in the array: ");
        greaterThanThis = Integer.parseInt(c.readLine());
        checkArrayProperties();
        printArrayProperties();
    }
    public static void main(String[] args) {
        Console c = System.console();
        new ArrayInspection(takeInput(), c);
    }

    void checkArrayProperties() {
        int oddValuesCount = 0;
        int greaterValuesCount = 0;

        for(int i = 0, n = x.length; i < n; i++) {
            if(x[i] > max)
                max = x[i];

            if(x[i] < min)
                min = x[i];
            
            sum += x[i];
            if(x[i] > greaterThanThis) {
                greaterNumbers[greaterValuesCount] = x[i];
                greaterValuesCount++;
            }
        }

        for(int i = 0, n = x.length; i < n; i++) {

            if(x[i] > max2 && x[i] != max)
                max2 = x[i];
            
            if(x[i] < min2 && x[i] != min)
                min2 = x[i];
            
            if(x[i] % 2 != 0) {
                oddValues[oddValuesCount] = x[i];
                oddValuesCount++;
            } else {
                evenCount++;
            }
        }

        int[] tmp = new int[oddValuesCount];

        for(int i = 0, n = tmp.length; i < n; i++)
            tmp[i] = oddValues[i];

        oddValues = tmp;

        tmp = new int[greaterValuesCount];

         for(int i = 0, n = tmp.length; i < n; i++)
            tmp[i] = greaterNumbers[i];
        
        greaterNumbers = tmp;
    }

    void printArrayProperties() {
        System.out.println();
        System.out.println("The largerst number is                  : " + max);
        System.out.println("The 2nd largest number is               : " + max2);
        System.out.println("The smallest number is                  : "  + min);
        System.out.println("The 2nd smallest number is              : " + min2);
        System.out.println("Sum of all numbers is                   : " + sum);
        System.out.print("Odd values in array are                 : ");
        printArray(oddValues);
        System.out.println("Count of even numbers is                : " + evenCount);
        System.out.print("All numbers in array greater than " + greaterThanThis + " are: ");
        printArray(greaterNumbers);
        System.out.println();
    }
}