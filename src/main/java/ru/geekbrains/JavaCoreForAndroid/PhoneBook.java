package ru.geekbrains.JavaCoreForAndroid;

import java.util.ArrayList;
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
public class PhoneBook {
    // Выполнение задания №2
    // самый простой телефонный справочник (минимальный функционал оформления и взаимодействия)
    // поля класса:
    private final HashMap<String, ArrayList<String>> items = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        // Новый контакт создается в том случае если номер который введен не существует
        if (items.get(surname) != null) {
            if (!items.get(surname).contains(phoneNumber)) {
                items.get(surname).add(phoneNumber);
            }
        } else {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(phoneNumber);
            items.put(surname, arr);
        }
    }

    public void get(String surname) {
        String format = "|%1$-20.18s| контактный телефон(ы): ";
        System.out.format(format, surname);
        System.out.println(items.get(surname));
    }
}
