package step5;


import java.util.Scanner;
import java.lang.Exception;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.List;
class NegativeNumberException extends Exception {  //власний клас винятку, який успадковує від Exception і може використовувати всі його методи
    public NegativeNumberException(String message) {   //конструктор, який приймаає повідомлення
        super(message);  //викоикаємо конструктор
    }
}
public class StringCalculator {
    public int add(String numbers) { //публічний нестатичний метод
        int sum = 0;
        if (!numbers.isEmpty()){
            String delimiter = "[,\\n]";

            if (numbers.endsWith("\n") || numbers.endsWith(",") ){
                System.out.println("invalid value!");
                return 0;
            }

            if (numbers.startsWith("//")) {
                int newline_index = numbers.indexOf('\n');
                if (newline_index != -1) {
                    String delimiter_hand = numbers.substring(2, newline_index);  //встановлюємо роздільник
                    delimiter = "[" + delimiter_hand + ",\\n]";   //тепер всі роздільники
                    numbers = numbers.substring(newline_index + 1);   //обрізаємо частину рядка це роздільник
                }
            }

            List<Integer> negative_numb = new ArrayList<>();  //лист для ві'ємних значень

            String[] numbers_broken = numbers.split(delimiter);   //розбиває рядок який містить числа на кожне число окремо, роздільник кома
            for (int i = 0; i < numbers_broken.length; i++)
            {
                String number_str = numbers_broken[i].trim(); //trim  видаляє всі зайві пробіли на початку та в кінці рядка

                try {
                    int num = Integer.parseInt(number_str);  //перетворюємо рядок у ціле число
                    if (num>=0) {
                        sum += num;
                    }else {
                        negative_numb.add(num);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("invalid input!");
                    return 0;
                }
            }
            try{
                if (negative_numb.size()==0) {
                    System.out.println("Sum:" + sum);
                    return sum;
                }else {
                    throw new NegativeNumberException("negativ number are not allowed");  //новий об'єкт винятку з повідомленням
                }
            } catch (NegativeNumberException e)  //задаємо тип винятку
            {
                System.err.println(e.getMessage());  //викликаємо getMessage() на об'єкті винятку e
                for (int i = 0; i < negative_numb.size(); i++)
                {
                    int number = negative_numb.get(i); //отримуємо елемент списку за індексом i
                    System.out.println(number); //виводимо елемент на екран
                }
            }
            return 0;
        }
        System.out.println("Sum:" + sum);
        return sum;
    }
    public static void main(String[] args) {
        Scanner numb = new Scanner(System.in);  //створюємо об'єкт numb
        System.out.println("Enter a numbers: ");
        String number_line = numb.nextLine();  //зчитуємо рядок введений користувачем і вписуємо його в number
        number_line = number_line.replace("\\n", "\n"); //замінено символи "\\n" на фактичний символ нового рядка "\n"
        step5.StringCalculator obj_1 = new step5.StringCalculator(); // створюємо об’єкт obj_1
        obj_1.add(number_line);
    }
}

