package ru.geekbrains.JavaCoreForAndroid;

import java.util.HashMap;
/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 10
 * Created 14.02.2021
 * v1.0
 */
public class Lesson10 {
    private static String analyzedData = "Регулярные выражения — тема, котёрую котЁрую  котёрую программисты, даже опытные," +
            " зачастую откладывают на потом. Однако большинству Java-разработчиков рано или поздно придётся столкнуться с" +
            " обработкой текстовой информации. Чаще всего — с операциями поиска в тексте и редактированием." +
            " Без регулярных выражений продуктивный и компактный программный код, связанный с обработкой текстов," +
            " попросту немыслим. Так что хватит откладывать, разберёмся с «регулярками» прямо сейчас." +
            " Это не такая уж и сложная задача.";

    public static void main(String[] args) {
        //Выполнение задания №1
        //Входную строку дополнительно обрабатываю
        // - 1. привожу все слов к нижнему регистру для правильно подсчета слов (с заглавной буквой и без нее)
        // - 2. убираю из исследуемого фрагмента все лишние знаки пунктуации (пока с исп. регулярных выражений)
        //   но есть в запасе и другие способы... они чуть более громоздкие.
        analyzedData =  analyzedData.replaceAll("[^A-Za-zА-ЯЁа-яё0-9 ]", " ").toLowerCase();
        analyzedData =  analyzedData.replaceAll("[\\s]{2,}", " "); // удаляю оставшиеся лишние пробелы
        String[] regularArray = analyzedData.split(" ");                // Создаю массив слов из большой строки...
        System.out.println("Задание №1");
        System.out.println("Обрабатываемый фрагмент текста имеет "+regularArray.length + " слов.");
        HashMap<String, Integer> hashMap = new HashMap<>();
                                                // перебираем в цикле все элементы исследуемого массива
        for (String s : regularArray) {         // решил сэкономить несколько строк и уйти от логического оператора
            hashMap.putIfAbsent(s,0);           // грубо говоря я сначала инициализирую запись делаю значение не NULL
            hashMap.put(s,hashMap.get(s)+1);    // потом записываю значение вычисл., относительно уже имеющегося (т.е. +1)
        }                                       // таким образом я не делаю ifи ухожу от ошибок обращения к NULL
        //Запись данных и подсчет повторений закончен.
        //Сортируем коллекцию по значению и выводим результаты
        System.out.println("Таблица результатов анализа текста");
        System.out.println("_________________________________________________________________________");
        String format = "|%1$-40.38s|%2$-30.28s|\n";
        System.out.format(format, "         слово / фраза", " Количество повторений");
        System.out.println("=========================================================================");
        hashMap.entrySet().stream().sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed()).forEach(stringIntegerEntry -> {
            String k = stringIntegerEntry.getKey();
            Integer v = stringIntegerEntry.getValue();
            System.out.format(format, " " + k + " ","   " + + v + " раз.");
        });
        System.out.println("-------------------------------------------------------------------------");
    }
}
