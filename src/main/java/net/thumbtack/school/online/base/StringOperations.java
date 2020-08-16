package net.thumbtack.school.online.base;

import java.text.DecimalFormat;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int sum = 0; // создадим переменную для хранения результата
        for (int i = 0; i < strings.length; i++) {
            sum+=strings[i].length();
        }
        return sum;
    }


    public static String getFirstAndLastLetterString(String string) {
        String result = string.substring(0,1) + string.substring(string.length()-1);
        return result;
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

	public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return (string1.length() - string1.lastIndexOf(character)) == (string2.length() - string2.lastIndexOf(character));
    }

	public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

	public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return (string1.length() - string1.lastIndexOf(str)) == (string2.length() - string2.lastIndexOf(str));
    }

	public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

	public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        // в нашем решении, если строки равны то также вернется false;
       return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return  string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return  !(!string1.startsWith(prefix) || !string2.startsWith(prefix));
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) == string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int little;
        little = (string1.length() < string2.length()) ? string1.length() : string2.length(); // найдем строку которая короче
        for (int i = 0; i<little; i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                continue;
            }
            else {
                return string1.substring(0, i);
            }
        }
            return string1.substring(0, little);
     }

    public static String reverse(String string) {
        StringBuilder reverseStr = new StringBuilder(string);
        return String.valueOf(reverseStr.reverse());
    }

	public static boolean isPalindrome(String string) {
        return string.equals(reverse(string)); // воспользуемся написанным ранее методом.
    }

	 public static boolean isPalindromeIgnoreCase(String string) {
         return string.equalsIgnoreCase(reverse(string));
     }


	 public static String getLongestPalindromeIgnoreCase(String[] strings) {
         String str;
         String str2 = "";

         for (int i = 0; i < strings.length; i++) {
             str = strings[i];
             if (isPalindromeIgnoreCase(str) && str.length()>str2.length()) {
                 str2 = str;
             }
         }
         return str2;
     }

	 public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1.length() >= (index+length) && string2.length() >= (index+length)) {
         return string1.substring(index, index+length).equals(string2.substring(index, index+length));
        }
        else {
            return false;
        }
     }


    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1,replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

   public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                    String string2, String replaceInStr2, String replaceByInStr2) {
   return string1.replaceAll(replaceInStr1, replaceByInStr1).equals(string2.replaceAll(replaceInStr2, replaceByInStr2));
   }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replaceAll(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (i!=array.length-1) {
                str = str.concat(String.valueOf(array[i]) + ",");
            }
            else
                str = str.concat(String.valueOf(array[i]));
        }
        return str;
    }

   public static String makeCsvStringFromDoubles(double[] array) {
       String str = "";
       DecimalFormat dec = new DecimalFormat("#.00");
       for (int i = 0; i < array.length; i++) {
           if (i!=array.length-1) {
               str = str.concat(String.valueOf(dec.format(array[i])) + ",");
           }
           else
               str = str.concat(String.valueOf(dec.format(array[i])));
       }
       return str;
   }

   public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
       return new StringBuilder(makeCsvStringFromInts(array));
   }

   public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
   }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        for (int i = 0; i < positions.length; i++) {
            int num = positions[i] - i;
            string = string.substring(0, num).concat(string.substring(num+1));
        }
        return new StringBuilder(string);
    }

	 public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
         int num = 0; // создадим счетчик для осуществления сдвига.
         StringBuilder stringNew = new StringBuilder(string);
         for (int i = 0; i < positions.length; i++) {
             if (i!= 0 && positions[i] == positions[i-1]) {  /* Обработаем два условия, когда в одну позицию
                                                                вставляется один элемент и когда их несколько. */

                 stringNew.insert(positions[i]+num, characters[i]);
                 num+=1;
             }
             else {
                 stringNew.insert(positions[i] + num, characters[i]);
                 num+=1;
             }
         }
         return stringNew;
     }
   }
