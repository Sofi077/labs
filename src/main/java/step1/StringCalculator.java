package step1;
import java.util.Scanner;
public class StringCalculator {
    public int add(String numbers) { //публічний нестатичний метод
        int sum = 0;
        if (!numbers.isEmpty()){
            String[] numbers_broken = numbers.split(",");   //розбиває рядок який містить числа на кожне число окремо, роздільник кома
            if (numbers_broken.length > 2) {
                System.out.println("More than 2 numbers are entered!");
                return 0;
            }
            for (int i = 0; i < numbers_broken.length; i++)
            {
                String number_str = numbers_broken[i].trim(); //trim  видаляє всі зайві пробіли на початку та в кінці рядка

                try {
                    int num = Integer.parseInt(number_str);  //перетворюємо рядок у ціле число
                    sum += num;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input!");
                    return 0;
                }
        }
        }
        System.out.println("Sum:" + sum);
        return sum;
    }
    public static void main(String[] args) {
        Scanner numb = new Scanner(System.in);  //створюємо об'єкт numb
        System.out.println("Enter a numbers: ");
        String number_line = numb.nextLine();  //зчитуємо рядок введений користувачем і вписуємо його в number
        StringCalculator obj_1 = new StringCalculator(); // створюємо об’єкт obj_1
        obj_1.add(number_line);
    }
}