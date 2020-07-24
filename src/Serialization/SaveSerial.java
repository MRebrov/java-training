package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveSerial {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestSerial ts = new TestSerial((byte) 100, 0);
        oos.writeObject(ts);
        oos.flush();
        oos.close();
    }
}
