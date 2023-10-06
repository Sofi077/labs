package step7;

import java.util.Scanner;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
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
                    delimiter_hand = Pattern.quote(delimiter_hand); //це щоб довгий роздільник не сприймався як спеціалні символи (регулярний літерал)
                    delimiter = "[" + delimiter_hand + ",\\n]";   //тепер всі роздільники
                    numbers = numbers.substring(newline_index + 1);   //обрізаємо частину рядка це роздільник
                }
            }

            List<Integer> negative_numb = new ArrayList<>();  //лист для ві'ємних значень

            String[] numbers_broken = numbers.split(delimiter);   //розбиває рядок який містить числа на кожне число окремо, роздільник кома
            String number_str;
            for (int i = 0; i < numbers_broken.length; i++)
            {
                if (!numbers_broken[i].isEmpty()){
                    number_str = numbers_broken[i].trim(); //trim  видаляє всі зайві пробіли на початку та в кінці рядка
                }else {
                    int j = i + 1;
                    while (j < numbers_broken.length && numbers_broken[j].isEmpty()) {
                        j++; //пересуваємося до наступного непорожнього елементу
                    }
                    i = j - 1; //встановлюємо індекс на останній непорожній елемент
                    continue;
                }
                try {
                    int num = Integer.parseInt(number_str);  //перетворюємо рядок у ціле число
                    if (num>=0) {
                        if (num<=1000){
                            sum += num;
                        }
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
                    throw new step7.NegativeNumberException("negativ number are not allowed");  //новий об'єкт винятку з повідомленням
                }
            } catch (step7.NegativeNumberException e)  //задаємо тип винятку
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
        step7.StringCalculator obj_1 = new step7.StringCalculator(); // створюємо об’єкт obj_1
        obj_1.add(number_line);
    }
}
