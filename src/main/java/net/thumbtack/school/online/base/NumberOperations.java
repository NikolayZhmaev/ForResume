package net.thumbtack.school.online.base;

import java.math.BigInteger;
import java.math.BigDecimal;

public class NumberOperations {
    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps ) {
                return i;
            }
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        double density = weight/volume;
        if ( density <= max && density >= min) {
            return density;
        }
        return null;
    }

   public static Integer find(BigInteger[] array, BigInteger value) {
       for (int i = 0; i < array.length; i++) {
           if (array[i].compareTo(value) == 0) {
               return i;
           }
       }
       return null;
   }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal density = weight.divide(volume);
        if ( density.compareTo(max) < 0 && density.compareTo(min) > 0) {
            return density;
        }
        return null;
    }

}
