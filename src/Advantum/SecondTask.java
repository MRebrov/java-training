package Advantum;

public class SecondTask {

    public int wordsCount(String str) {
        String[] splitted = str.split("[A-Z]");
        return splitted.length;
    }

    public static void main(String[] args) {
        SecondTask st = new SecondTask();
        System.out.println(st.wordsCount("veryThinDog"));
    }
}
