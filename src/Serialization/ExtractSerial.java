package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ExtractSerial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestSerial ts = (TestSerial) ois.readObject();
        System.out.println(ts);
        ois.close();
        fis.close();

        File file = new File("temp.out");
        FileInputStream fis1 = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis1.read(bytes);
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        System.out.println(sb.toString());
        fis1.close();
    }
}
