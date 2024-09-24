package lambdafunction;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {

        List<InterfaceClass> methodArray = new ArrayList<>();
        methodArray.add((a, b) -> a + b);
        methodArray.add((a, b) -> a - b);
        methodArray.add((a, b) -> superCalculation(a,b));
        methodArray.add((a, b) -> a / b);

        double c = 2.5, d=3.5;

        for(int i = 0; i<methodArray.size(); i++){
            System.out.println(methodArray.get(i).operate(c, d));
        }
    }

    static double superCalculation(double a, double b){
        a = a * b / 3 * a * b / a;
        b = b * b * b * b;
        return a + b;
    }
}
