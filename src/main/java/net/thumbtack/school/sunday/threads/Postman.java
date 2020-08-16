package net.thumbtack.school.sunday.threads;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 14. Написать класс Message, содержащий 4 текстовых поля : emailAddress, sender, subject, body, и класс Transport,
       с методом send(Message message), отсылающий письмо на некий SMTP-сервер. Реализовать массовую рассылку одного и
       того же текста, email адреса берутся из текстового файла. Порядок отправки писем произвольный и не обязан совпадать
       с порядком email адресов в файле.
       Примечание 1. Реальную отправку писем производить не надо, вместо этого достаточно выводить их в некоторый файл.
*/

class Messege implements Serializable {
    private String emailAddress;
    private String sender;
    private String subject;
    private String body;

    public Messege(String emailAddress, String sender, String subject, String body) {
        this.emailAddress = emailAddress;
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }

    public Messege(String sender, String subject, String body) {
        this(null, sender, subject, body);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    synchronized void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Messege{" +
                "emailAddress='" + emailAddress + '\'' +
                ", sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

class Transport {

    Lock lock = new ReentrantLock();
    private File file = new File("server.txt");

    public Transport() {
        file.delete(); // для очистки файла, для удобства
    }

    public void send(Messege message) {
        lock.lock();
        try {
            Gson gson = new Gson();
            try (BufferedWriter buffW = new BufferedWriter(new FileWriter(file, true))) {
                gson.toJson(message, buffW);
                buffW.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}

class ReadingAddresses {

    Lock lock = new ReentrantLock();
    private List<String> addressesSynx;

    public List<String> setAndGetAddresses(File file) {
        String address;
        List<String> addresses = new ArrayList<>();
        try (BufferedReader bufR = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            while ((address = bufR.readLine()) != null) {
                addresses.add(address);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setAddressesSynx(addresses);
        return addresses;
    }

    public void setAddressesSynx(List<String> addresses) {
        this.addressesSynx = Collections.synchronizedList(addresses);
    }

    synchronized List<String> getAddressesSynx() {
        return addressesSynx;
    }

    synchronized String getAddress() {
        lock.lock();
        try {
            String address = addressesSynx.get(0);
            addressesSynx.remove(0);
            return address;
        } finally {
            lock.unlock();
        }
    }
}

public class Postman {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Transport transport = new Transport();
        ReadingAddresses readAdr = new ReadingAddresses();
        Messege messege = new Messege("nikolay.zhmaev85@gmail.com", "Test connection", "Hello world!!!"); // шаблон сообщения

        readAdr.setAndGetAddresses(new File("addresses.txt")); // прочитаем из файла и получим синхронизированный лист адрессов

        Runnable run = new Runnable() {
            @Override
            public void run() {
                while (!readAdr.getAddressesSynx().isEmpty()) {
                    String address = readAdr.getAddress();
                    System.out.println("thread id: " + Thread.currentThread().getId() + " sends an email to: " + address); // для наглядности
                    lock.lock();
                    try {
                        messege.setEmailAddress(address);
                        transport.send(messege);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread thread = new Thread(run);
        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);
        Thread thread3 = new Thread(run);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread.join();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}