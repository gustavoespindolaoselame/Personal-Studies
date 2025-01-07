
import java.util.stream.Collectors;

public class AppMethods {

    public static void chooseString() {
        System.out.println("Define string:");
        AppConfig.stringExample = AppConfig.scanner.nextLine();
        AppConfig.stringExample = AppConfig.scanner.nextLine();
    }

    public static void encryptOrDecrypt() {
        while (true) {
            int encryptChoice = 0;
            System.out.println("""
            Choose wether to:
            1) Encrypt
            2) Decrypt""");
            while (encryptChoice < 1 || encryptChoice > 2) {
                encryptChoice = AppConfig.scanner.nextInt();
            }
            switch (encryptChoice) {
                case 1 -> {
                    chooseString();
                    encrypt();
                }
                case 2 -> {
                    chooseString();
                    decrypt();
                }
            }
        }
    }

    public static void encrypt() {
        System.out.println("String to encrypt: " + AppConfig.stringExample);
        AppConfig.intList.addAll(AppConfig.stringExample.chars().
                mapToObj(c -> (int) c
                ).
                toList()
        );
        AppConfig.resultList.addAll(AppConfig.intList.stream().
                map(AppFunctions.intToBinaryString).
                map(str -> AppFunctions.lengthKeyMapping.apply(str, AppConfig.key)).
                map(AppFunctions.stringReverse).
                map(AppFunctions.binaryStringToBigInteger).
                map(AppFunctions.bigIntegerToASCIIString).
                collect(Collectors.toList()));
        for (String string : AppConfig.resultList) {
            AppConfig.resultString = AppConfig.resultString.concat(string);
        }
        System.out.println(AppConfig.resultString);
    }

    public static void decrypt() {
    }
}
