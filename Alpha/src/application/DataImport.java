package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class DataInput {
    public static void main() {
        try {
            InputStream fileInputStream;
            BufferedReader bufferedReader;
            final +String filepathInSamePackage = "textfile.txt";
            //filter predicate
            Predicate<String> filterFirstLine =
                    line -> !(
                            "Name".equals(line.split("\t", -1)[0])
                                    && "Hobby".equals(line.split("\t", -1)[1])
                    );

            //Implementation 1 returns Arrays as asked.

            System.out.println("==ArrayList==");
            fileInputStream = StreamTests.class.getResourceAsStream(filepathInSamePackage);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            bufferedReader
                    .lines()
                    .filter(filterFirstLine)
                    .map(s -> {
                        String[] splitStrings = s.split("\t", -1);
                        return Arrays.asList(splitStrings);
                    }).forEach(System.out::println);

            //Implementation 2 returns HashMap as another example

            fileInputStream = StreamTests.class.getResourceAsStream(filepathInSamePackage);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            System.out.println("\n==HashMap==");

            bufferedReader
                    .lines()
                    .filter(filterFirstLine)
                    .map(s -> {
                        String[] splitStrings = s.split("\t", -1);
                        HashMap<String, String> stringStringMap = new HashMap<>();
                        stringStringMap.put(splitStrings[0], splitStrings[1]);
                        return stringStringMap;
                    }).forEach(System.out::println);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
