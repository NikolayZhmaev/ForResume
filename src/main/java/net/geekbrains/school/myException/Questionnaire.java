package net.geekbrains.myException;

import java.util.Scanner;

/* Сделаем программу, которая предлагает пользователю заполнить анкету. Результат поместим в массив (включая ошибки),
 в случае не корректного ввода нанных, при выводе будет видно какие поля заполнены не правильно*/

public class Questionnaire {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String [] questionnaire = new String[7];

        for (int i = 0; i <questionnaire.length ; i++) {

            try {
                questionnaire[i] = Name();
                i++;
            } catch (IncorrectName incorrectName) {
                questionnaire[i] = incorrectName.getMessage();
                i++;
            }

            try {
                questionnaire[i] = PhoneNumber();
                i++;
            } catch (InvalidPhoneNumber invalidPhoneNumber) {
                questionnaire[i] = invalidPhoneNumber.getMessage();
                i++;
            }

            try {
                questionnaire[i] = Integer.toString(Age());
                i++;
            } catch (WrongAge wrongAge) {
                questionnaire[i] = wrongAge.getMessage();
                i++;
            }

            try {
                questionnaire[i] = Integer.toString(Weight());
                i++;
            } catch (WrongWeight wrongWeight) {
                questionnaire[i] = wrongWeight.getMessage();
                i++;
            }
            try {
                questionnaire[i] = Float.toString(Growth());
                i++;
            } catch (WrongGrowth wrongGrowth) {
                questionnaire[i] = wrongGrowth.getMessage();
                i++;
            }
            try {
                questionnaire[i] = BodyType();
                i++;
            } catch (WrongBodyType wrongBodyType) {
                questionnaire[i] = wrongBodyType.getMessage();
                i++;
            }

            try {
                if (Family()) {
                    try {
                        questionnaire[i] = "Количество детей: "+Integer.toString(Children());
                        i++;
                    } catch (WrongNumberChildren wrongNumberChildren) {
                        questionnaire[i] = wrongNumberChildren.getMessage();
                        i++;
                    }
                }
                else {questionnaire[i] = "Детей нет";
                    i++;  }
            } catch (WrongFamily wrongFamily) {
                questionnaire[i] = wrongFamily.getMessage();
                i++;
            }
        }

        for (int i = 0; i <questionnaire.length ; i++) {  //Посмотрим результат
            System.out.println(questionnaire[i]);
        }
    }

    public static String Name () throws IncorrectName {
        String name;
        System.out.println("Укажите ваши ФИО: ");
        name = sc.nextLine();
        if (name.matches("^[а-яА-Я^ ]+$")) {return name;}  //выполним проверку на то что введены только русские буквы и пробелы.
        else throw new IncorrectName("Не верно введены ФИО");
    }

    public static String PhoneNumber () throws InvalidPhoneNumber {
        String phone;
        System.out.println("Укажите Ваш телефон (6 цифр): ");
        phone = sc.next();
        if (phone.length()==6) {return phone;}
        else throw new InvalidPhoneNumber("Не верно введен телефон");
    }

    public static int Age () throws WrongAge {
        int age;
        System.out.println("Укажите Ваш возраст (он должен быть в пределах от 18 до 55): ");
        age = sc.nextInt();
        if (age>=18 && age<=55) {return age;}
        else throw new WrongAge("Не верно задан возраст");
    }

    public static int Weight () throws WrongWeight {
        int weight;
        System.out.println("Укажите Ваш вес, кг: ");
        weight = sc.nextInt();
        if (weight>30) {return weight;}
        else throw new WrongWeight("Не верно задан вес");
    }

    public static float Growth () throws WrongGrowth {
        float growth;
        System.out.println("Укажите Ваш рост: ");
        growth = sc.nextFloat();
        if (growth>=0 && growth<=250) {return growth;}
        else throw new WrongGrowth("Не верно задан рост");
    }

    public static String BodyType () throws WrongBodyType {
        int choicebodyType;
        String bodyTyp = "" ;
        System.out.println("Выберите тип вашего телосложения: 1-худой, 2-спортивный, 3-полный");
        choicebodyType= sc.nextInt();
        switch (choicebodyType){
            case 1: bodyTyp="телосложение худощавое";  break;
            case 2: bodyTyp="телосложение спортивное";  break;
            case 3: bodyTyp="телосложение полное";  break;
            default: throw new WrongBodyType("Неверно выбрано телосложение");
        }
        return bodyTyp;
    }

    public static boolean Family () throws WrongFamily {
        String family;
        System.out.println("Есть ли у Вас дети: ");
        family = sc.next();
        switch (family){
            case "да": return true;
            case "нет": return false;
            default: throw new WrongFamily("Дан не верный ответ");
        }
    }

    public static int Children () throws WrongNumberChildren {
        int num;
        System.out.println("Введите количество детей: ");
        num=sc.nextInt();
        if (num>0) {return num;}
        else throw new WrongNumberChildren("Не верно задано количество детей");
    }
}

//Создаем 8 наших классов исключений

class WrongAge extends Exception {  // неверный возраст
    public WrongAge(String message) {
        super(message); }
}

class WrongWeight extends Exception {  // неверный вес
    public WrongWeight(String message) {
        super(message); }
}

class WrongGrowth extends Exception {  // неверный рост
    public WrongGrowth(String message) {
        super(message); }
}

class WrongBodyType extends Exception {  // неверное телосложение
    public WrongBodyType(String message) {
        super(message); }
}

class InvalidPhoneNumber extends Exception {  // неверный номер телефона
    public InvalidPhoneNumber(String message) {
        super(message); }
}

class IncorrectName extends Exception {  // неверная фамилия
    public IncorrectName(String message) {
        super(message); }
}

class WrongNumberChildren extends Exception {  // неверный возраст
    public WrongNumberChildren(String message) {
        super(message);
    }
}

class WrongFamily extends Exception {  // неверный возраст
    public WrongFamily(String message) {
        super(message);
    }
}