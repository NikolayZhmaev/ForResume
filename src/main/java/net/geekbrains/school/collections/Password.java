package net.geekbrains.collections;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
   Необходимо из консоли считать пароль и проверить валидность, результат будет true или false
     Требования:
   1. Пароль должен быть не менее 8ми символов.
   2. В пароле должно быть число
   3. В пароле должна быть хотя бы 1 строчная буква
   4. В пароле должна быть хотя бы 1 заглавная буква
*/

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.println("Введите пароль");
        password = sc.next();
        try {
            passwordVerification(password);
        } catch (WrongPassword wrongPassword) {
            wrongPassword.printStackTrace();
        }
    }

    //В следующем методе проверим соответствие пороля предъявляемым требованиям.
    public static void passwordVerification(String password) throws WrongPassword {
        Pattern p = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])+.{8,}");
        Matcher m = p.matcher(password);
        if (m.matches()) {
            System.out.println(m.matches());
        } else throw new WrongPassword("Неверно введен пароль");
    }
}

//Создадим исключение для ошибочного пароля.
class WrongPassword extends Exception {
    public WrongPassword(String message) {
        super(message);
    }
}

