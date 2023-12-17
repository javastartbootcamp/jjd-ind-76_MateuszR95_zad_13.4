package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        // tutaj możesz przeprowadzać manualne testy listy

        // lista powinna być parametryzowana (analogicznie jak java.util.ArrayList czy java.util.LinkedList)
        CustomList<String> customListOfStrings = new CustomList();
       // CustomList<Integer> customListOfIntegers = new CustomList();

        customListOfStrings.add("Adam");
        customListOfStrings.add("Tomasz");
        customListOfStrings.add("Wiktor");
        customListOfStrings.add("Krystian");
        customListOfStrings.add(0, "Krystyna");
        String name = customListOfStrings.get(1);
        System.out.println("Indeks 1: " + name);
        System.out.println("Rozmiar listy: " + customListOfStrings.size());
        System.out.println(customListOfStrings);

    }

}

