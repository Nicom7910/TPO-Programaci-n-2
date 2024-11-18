package org.example.ej2.utils;


import org.example.ej2.tda.StaticSet;

public class SetUtil {

    public static <T> StaticSet<T> copySet(StaticSet<T> set) {
        StaticSet<T> aux = new StaticSet<>();
        StaticSet<T> aux2 = new StaticSet<>();

        while (!set.isEmpty()) {
            T element = set.choose();
            aux.add(element);
            aux2.add(element);
            set.remove(element);
        }

        while (!aux2.isEmpty()) {
            T element = aux2.choose();
            set.add(element);
            aux2.remove(element);
        }

        return aux;
    }
}
