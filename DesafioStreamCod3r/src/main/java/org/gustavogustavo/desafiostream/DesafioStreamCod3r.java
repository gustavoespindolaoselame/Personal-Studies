/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.gustavogustavo.desafiostream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Rawdog bem complicado pq decidi não usar Integer.toBinaryString()
 * @author gustavo
 */
public class DesafioStreamCod3r {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Function<Integer, StringBuilder> toStringbuilderBinary = num -> {
            StringBuilder result = new StringBuilder();
            while(num>0){
                result.append(num % 2);
                num=num/2;
            }
            return result.reverse();
        };
        
        UnaryOperator<StringBuilder> reverseStringbuilderBinary = binary -> {
            return binary.reverse();
        };

        Function<StringBuilder, Integer> toDecimal = binary -> {
            Integer result = 0;
            int length = binary.length();
            for (int i = 0; i < length; i++) {
                result += (binary.charAt(length - i - 1) - '0') * (int)Math.pow(2, i);
            }
            
            return result;
        };        
        nums.stream().
        map(toStringbuilderBinary).
        map(reverseStringbuilderBinary).
        map(toDecimal).
        forEach(System.out::println);
    }
}
