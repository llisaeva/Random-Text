package src;

public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator("file/twoletters.txt", null);

        System.out.println(generator.makeText());
    }
}
