
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppFunctions {

    static Function<Integer, String> intToBinaryString = intToTransform -> Integer.toBinaryString(intToTransform);

    static BinaryOperator<String> lengthKeyMapping = (originalString, key) -> {
        while (originalString.length() < Integer.parseInt(key)) {
            originalString = originalString.concat("0");
        }
        return originalString;
    };

    static UnaryOperator<String> reverseString = originalString -> {
        StringBuilder returnString = new StringBuilder();
        returnString.append(originalString);
        return returnString.reverse().toString();
    };

    static UnaryOperator<String> binaryToString = originalString -> {
        int originalStringAccumulatedValue = 0;
        int individualReturnCharValue;
        String returnString = "#";
        for (int i = 0; i < originalString.length(); i++) {
            originalStringAccumulatedValue += originalString.toCharArray()[i] * Math.pow(2, i);
        }
        while (originalStringAccumulatedValue > 0) {
            individualReturnCharValue = originalStringAccumulatedValue % 255;
            originalStringAccumulatedValue = originalStringAccumulatedValue / 255;
            returnString = returnString.concat(String.valueOf((char) individualReturnCharValue));
        }
        return returnString;
    };
}
