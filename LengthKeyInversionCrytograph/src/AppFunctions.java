
import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class AppFunctions {

    static Function<Integer, String> intToBinaryString = intToTransform
            -> Integer.toBinaryString(intToTransform);

    static BinaryOperator<String> lengthKeyMapping = (inputString, key) -> {
        while (inputString.length() < Integer.parseInt(key)) {
            inputString = "0".concat(inputString);
        }
        return inputString;
    };

    static UnaryOperator<String> stringReverse = inputString -> {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(inputString);
        return stringbuilder.reverse().toString();
    };

    static Function<String, BigInteger> binaryStringToBigInteger = inputString -> {
        BigInteger outputBigInteger = new BigInteger("0");
        int length = inputString.length();
        for (int i = 0; i < length; i++) {
            if (inputString.charAt(length - i - 1) == '1') {
                outputBigInteger = outputBigInteger.add(BigInteger.valueOf(2).pow(i));
            }
        }
        return outputBigInteger;
    };
    
    static Function<BigInteger, String> bigIntegerToASCIIString = bigIntegerLong -> {
        StringBuilder outputString = new StringBuilder();
        while (bigIntegerLong.signum() > 0) {
            BigInteger currentCharValue = bigIntegerLong.mod(BigInteger.valueOf(65536));
            outputString.append((char) currentCharValue.intValue());
            bigIntegerLong = bigIntegerLong.divide(BigInteger.valueOf(65536));
        }
        
        return outputString.reverse().toString();
    };
}
