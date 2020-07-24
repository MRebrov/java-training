package Serialization;

import java.io.Serializable;

public class TestSerial extends Parent implements Serializable {
    private byte version;
    private int count;
    Contain contain = new Contain();

    public TestSerial(byte version, int count) {
        this.version = version;
        this.count = count;
    }

    @Override
    public String toString() {
        return "version - " + version + ", count - " + count + ", parentVersion - " + getParentVersion() + ", containVersion - " + contain.getContainVersion();
    }
}

class Parent implements Serializable {
    private int parentVersion = 10;

    public int getParentVersion() {
        return parentVersion;
    }
}

class Contain implements Serializable {
    private int containVersion = 11;

    public int getContainVersion() {
        return containVersion;
    }
}