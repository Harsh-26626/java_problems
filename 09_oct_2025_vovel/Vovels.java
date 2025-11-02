import java.util.Scanner;

class Vovels {
    final String input;
    final char[] vovels = {'a', 'e', 'i', 'o', 'u'};

    Vovels(String user_input) {
        input = user_input;
        print_vovels();
    }
    
    void print_vovels() {
        System.out.print("Your Vovels are: ");
        for(int i = 0; i < input.length(); i++)
            for(int j = 0; j < vovels.length; j++)
                if (input.charAt(i) == vovels[j]) 
                    System.out.print(vovels[j] + ", ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any String: ");
        new Vovels(sc.nextLine());

        sc.close();
    }
}