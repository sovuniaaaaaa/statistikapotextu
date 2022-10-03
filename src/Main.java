import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = null;

        List<String> outputData;

        String inputWay = askUser("Введите абсолютный или относительный адрес файла с текстом : ");


        try {
            validation(inputWay);
        } catch (Exception e) {
            System.out.println("Введён неправильный путь! Проверьте путь до файла.");
            System.exit(0);
        }

        try {
            list = WorkWithFiles.read(inputWay);
            System.out.println("Файл прочитан!");
        } catch (IOException e) {
            System.out.println("Файл для чтения не найден!");
            System.exit(0);
        }

        if (list == null) {
            System.out.println("Файл пуст!");
            System.exit(0);
        }

        String text = parse(list," ");
        outputData = getStatistics(text);
        System.out.println("Статистика готова!");

        String outputMode = askUser("Укажите способ вывода ( 'c' - консоль 'f' - файл 'c+f' - консоль и файл ) : ");
        switch (outputMode) {

            case "c":
                useCMode(outputData);
                break;

            case "f":
                useFMode(outputData);

                break;

            case "c+f":
                useFMode(outputData);
                useCMode(outputData);
                break;
        }

    }


    private static void validation(String fileWay) throws Exception {
        if (fileWay.matches("[A-Z][:]\\\\([A-Za-zА-Яа-я]*\\\\)*[A-Za-zА-Яа-я]*\\.txt")) {

        } else if (fileWay.matches("^[\\w\\s]+[.][txt]{3}$")) {

        } else {
            throw new Exception();
        }

    }

    private static String askUser(String message) {
        System.out.println(message);
        String answer = sc.nextLine();
        return answer;
    }
    private static void useFMode(List<String> data) {
        String way = askUser("Введите путь к файлу для вывода статистики:");
        try {
            validation(way);
        } catch (Exception e) {
            System.out.println("Неверный путь!");
        }
        try {
            WorkWithFiles.write(way, data);
            System.out.println("Файл статистики заполнен!");
        } catch (IOException e) {
            System.out.println("Файл для записи не найден!");
        }
    }

    private static void useCMode(List<String> data) {
        WorkWithConsol.print(data);
    }

    private static List<String> getStatistics(String text) {
        List<String> data = new ArrayList();
        data.add("Количество символов = " + StstisticOnTheText.countAllSymbols(text));
        data.add("Количество символов без пробелов = " + StstisticOnTheText.countSymbolsWithoutGaps(text));
        data.add("Количество cлов = " + StstisticOnTheText.countAllWords(text));
        return data;
    }

    private static String parse(List<String> list,String separator) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < list.size() - 1; i++) {
            s.append(list.get(i));
            s.append(separator);
        }
        s.append(list.get(list.size() - 1));
        String str = new String(s);
        return str;
    }
}