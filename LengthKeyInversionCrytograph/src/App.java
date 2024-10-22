public class App {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        AppConfig appConfig;
        AppMethods.encryptOrDecrypt();
        System.out.println(AppConfig.resultString);
    }
}
