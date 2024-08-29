package input;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static int inputNumber() {
        do {
            try {
                String dataInput = input.nextLine();
                int number = Integer.parseInt(dataInput);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Vui lòng nhập lại số!");
            }
        } while (true);
    }
    public static String inputString() {
        String dataInput = input.nextLine();
        return dataInput;
    }
    public static String ValidateGmail(){
        String regExGmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.com$";
        do {
            String name = input.nextLine();
            if(name.matches(regExGmail)) { //
                return name;
            } else {
                System.out.println("Sai định dạng, vui lòng nhập theo form (dat3107@gmail.com) !");
            }
        } while (true);
    }
    public static String ValidateDate(){
        String regExDate = "\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}";
        do {
            String name = input.nextLine();
            if(name.matches(regExDate)) { //
                return name;
            } else {
                System.out.println("Sai định dạng, vui lòng nhập theo form (dd-MM-yyyy) !");
            }
        } while (true);
    }
    public static String ValidatePhone(){
        String regExPhone = "^0[1-9]\\d{8}$";
        do {
            String name = input.nextLine();
            if(name.matches(regExPhone)) { //
                return name;
            } else {
                System.out.println("Sai định dạng, vui lòng nhập theo form (10 số) !");
            }
        } while (true);
    }

}
