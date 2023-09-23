import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаеь HashMap для хранения контактов
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Введите имя контакта, q - для завершения");
            String name = scanner.nextLine();

            if(name.equalsIgnoreCase("q")) {
                break;
            }
            System.out.println("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine();

            // Проверяем, есть ли контакты c таким именем
            if (phoneBook.containsKey(name)) {
                // Получаем список телефонных номеров
                HashSet<String> phoneNumbers = phoneBook.get(name);
                // Добавляем новый телефонный номер в список
                phoneNumbers.add(phoneNumber); 
                // Обновляем запись в HashMap
                phoneBook.put(name, phoneNumbers); 
            } else {
                // Создаем новый список телефонных номеров
                HashSet<String> phoneNumbers = new HashSet<>(); 
                // Добавляем телефонный номер
                phoneNumbers.add(phoneNumber); 
                // Добавляем запись в HashMap
                phoneBook.put(name, phoneNumbers);
            }

        }
        // Сортировка телефонной книги по убыванию числа телефонов
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());
        // Вывод отсортированной телефонной книги
        System.out.println("Телефонная книга: ");
        
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            String name = entry.getKey();
            HashSet<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        } 
        
        
    }
   
}