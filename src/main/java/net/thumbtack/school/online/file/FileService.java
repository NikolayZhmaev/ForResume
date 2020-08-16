package net.thumbtack.school.online.file;

import com.google.gson.Gson;
import net.thumbtack.school.online.ttschool.Trainee;
import net.thumbtack.school.online.ttschool.TrainingException;
import net.thumbtack.school.online.windows.v4.RectButton;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

import java.io.*;

public class FileService {


    protected static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    protected static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }

    protected static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        byte[] rez = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            rez = new byte[fis.available()];
            fis.read(rez, 0, fis.available());
        }
        return rez;
    }

    protected static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    protected static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) {
        // Входной поток
        ByteArrayInputStream byInp = new ByteArrayInputStream(array);
        // Выходной поток, куда попадут четные байты
        ByteArrayOutputStream byOut = new ByteArrayOutputStream();
        // Цикл чтения из входного потока и записи в выходной
        byInp.skip(0);
        byte b;
        while ((b = (byte) byInp.read()) != -1) {
            byOut.write(b);
            byInp.skip(1);
        }
        byte[] buffer = byOut.toByteArray();
        return buffer;
    }

    protected static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    protected static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bufOS = new BufferedOutputStream(new FileOutputStream(file))) {
            bufOS.write(array);
        }
    }

    protected static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        byte[] rez = new byte[(int) file.length()];
        try (BufferedInputStream bufIS = new BufferedInputStream(new FileInputStream(file))) {
            bufIS.read(rez);
        }
        return rez;
    }

    protected static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    protected static void writeRectButtonToBinaryFile(File file, RectButton rectButton) throws IOException {
        try (DataOutputStream dOutS = new DataOutputStream(new FileOutputStream(file))) {
            dOutS.writeInt(rectButton.getX()); // записываем координату x (поз. 0)
            dOutS.writeInt(rectButton.getY()); // записываем координату y (поз. 4)
            dOutS.writeInt(rectButton.getWidth()); // записываем ширину (поз. 8)
            dOutS.writeInt(rectButton.getHeight()); // записываем высоту (поз. 12)
            dOutS.writeUTF(String.valueOf(rectButton.getState())); // записываем состояние окна
            dOutS.writeUTF(rectButton.getText()); // записываем название
        }
    }

    protected static RectButton readRectButtonFromBinaryFile(File file) throws IOException {
        RectButton rectButton = null;
        try (DataInputStream dInS = new DataInputStream(new FileInputStream(file))) {
            rectButton = new RectButton(dInS.readInt(), dInS.readInt(), dInS.readInt(), dInS.readInt(),
                    dInS.readUTF(), dInS.readUTF());
        } catch (WindowException e) {
            e.printStackTrace();
        }
        return rectButton;
    }

    protected static void writeRectButtonArrayToBinaryFile(File file, RectButton[] rects) throws IOException {
        try (DataOutputStream dOutS = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < rects.length; i++) {
                dOutS.writeInt(rects[i].getX()); // записываем координату x (поз. 0)
                dOutS.writeInt(rects[i].getY()); // записываем координату y (поз. 4)
                dOutS.writeInt(rects[i].getWidth()); // записываем ширину (поз. 8)
                dOutS.writeInt(rects[i].getHeight()); // записываем высоту (поз. 12)
            }
        }
    }

    protected static void modifyRectButtonArrayInBinaryFile(File file) throws IOException {
        try (RandomAccessFile rAcF = new RandomAccessFile(file, "rw")) {
            for (long i = 0; i < file.length(); i += 16) {
                rAcF.seek(i);
                int rez = rAcF.readInt() + 1;
                rAcF.seek(i);
                rAcF.writeInt(rez);
            }
        }
    }

    protected static RectButton[] readRectButtonArrayFromBinaryFile(File file) throws IOException {
        int num = (int) (file.length() / 16);
        RectButton[] rectButtons = new RectButton[num];
        try (RandomAccessFile rAcF = new RandomAccessFile(file, "r")) {
            for (int i = 0; i < num; i++) {
                RectButton rectButton = new RectButton(rAcF.readInt(), rAcF.readInt(), rAcF.readInt(),
                        rAcF.readInt(), WindowState.ACTIVE, "OK");
                rectButtons[i] = rectButton;
            }
        } catch (WindowException e) {
            e.printStackTrace();
        }
        return rectButtons;
    }

    protected static void writeRectButtonToTextFileOneLine(File file, RectButton rectButton) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintStream prStr = new PrintStream(file, "UTF-8")) {
            prStr.print(rectButton.getX());
            prStr.print(" " + rectButton.getY());
            prStr.print(" " + rectButton.getWidth());
            prStr.print(" " + rectButton.getHeight());
            prStr.print(" " + rectButton.getState());
            prStr.print(" " + rectButton.getText());
        }
    }

    protected static RectButton readRectButtonFromTextFileOneLine(File file) throws IOException, UnsupportedEncodingException {
        RectButton rectButton = null;
        try (BufferedReader bfR = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String rezStr = bfR.readLine();
            String[] field = rezStr.split(" ");
            // получив массив строк выдерним нужные данные
            int x = Integer.parseInt(field[0]);
            int y = Integer.parseInt(field[1]);
            int width = Integer.parseInt(field[2]);
            int height = Integer.parseInt(field[3]);
            String state = field[4];
            String text = field[5];
            rectButton = new RectButton(x, y, width, height, state, text);
        } catch (WindowException e) {
            e.printStackTrace();
        }
        return rectButton;
    }

    protected static void writeRectButtonToTextFileSixLines(File file, RectButton rectButton) throws IOException, UnsupportedEncodingException {
        try (BufferedWriter bfW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bfW.write(String.valueOf(rectButton.getX()));
            bfW.newLine();
            bfW.write(String.valueOf(rectButton.getY()));
            bfW.newLine();
            bfW.write(String.valueOf(rectButton.getWidth()));
            bfW.newLine();
            bfW.write(String.valueOf(rectButton.getHeight()));
            bfW.newLine();
            bfW.write(String.valueOf(rectButton.getState()));
            bfW.newLine();
            bfW.write(rectButton.getText());
        }
    }

    protected static RectButton readRectButtonFromTextFileSixLines(File file) throws IOException {
        RectButton rectButton = null;
        try (BufferedReader bfR = new BufferedReader(new FileReader(file))) {
            int x = Integer.parseInt(bfR.readLine());
            int y = Integer.parseInt(bfR.readLine());
            int width = Integer.parseInt(bfR.readLine());
            int height = Integer.parseInt(bfR.readLine());
            String state = bfR.readLine();
            String text = bfR.readLine();
            rectButton = new RectButton(x, y, width, height, state, text);
        } catch (WindowException e) {
            e.printStackTrace();
        }
        return rectButton;
    }

    protected static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws FileNotFoundException {
        try (PrintStream prStr = new PrintStream(file, "UTF-8")) {
            prStr.print(trainee.getFirstName());
            prStr.print(" " + trainee.getLastName());
            prStr.print(" " + trainee.getRating());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    protected static Trainee readTraineeFromTextFileOneLine(File file) throws IOException {
        Trainee trainee = null;
        try (BufferedReader bfR = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String rezStr = bfR.readLine();
            String[] field = rezStr.split(" ");
            // получив массив строк выдерним нужные данные
            String firstName = field[0];
            String lastName = field[1];
            int rating = Integer.parseInt(field[2]);
            trainee = new Trainee(firstName, lastName, rating);
        } catch (TrainingException e) {
            e.printStackTrace();
        }
        return trainee;
    }

    protected static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException, UnsupportedEncodingException {
        try (BufferedWriter bfW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bfW.write(trainee.getFirstName());
            bfW.newLine();
            bfW.write(trainee.getLastName());
            bfW.newLine();
            bfW.write(String.valueOf(trainee.getRating()));
        }
    }

    protected static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException, UnsupportedEncodingException {
        Trainee trainee = null;
        try (BufferedReader bfR = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String firstName = bfR.readLine();
            String lastName = bfR.readLine();
            int rating = Integer.parseInt(bfR.readLine());
            trainee = new Trainee(firstName, lastName, rating);
        }
        return trainee;
    }

    protected static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objOutStr = new ObjectOutputStream(new FileOutputStream(file))) {
            objOutStr.writeObject(trainee);
        }
    }

    protected static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        Trainee trainee = null;
        try (ObjectInputStream objInpStr = new ObjectInputStream(new FileInputStream(file))) {
            trainee = (Trainee) objInpStr.readObject();
        }
        return trainee;
    }

    protected static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        String traineeText = gson.toJson(trainee);
        return traineeText;
    }

    protected static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        Trainee trainee = gson.fromJson(json, Trainee.class);
        return trainee;
    }

    protected static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter buffW = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee, buffW);
        }
    }

    protected static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        Trainee trainee = null;
        try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
            trainee = gson.fromJson(buffR, Trainee.class);
        }
        return trainee;
    }

}