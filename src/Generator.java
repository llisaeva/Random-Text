package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Generator {
    public static int WORD_COUNT = 150;
    private String mFolder = "../";
    private String mSymbolFile = "file/chars.txt";
    private String mLengthFile = "file/length.txt";
    private String mOutFile = "output.txt";
    private boolean WRITE_FILE = true;

    private int lengthPool = 0;
    private int symbolPool = 0;

    private Map<Integer, String> symbols;
    private Map<Integer, Integer> lengths;

    public Generator() {
        this(null, null);
    }

    public Generator(String symbolFile, String lengthFile) {

        if (symbolFile != null) {
            mSymbolFile = symbolFile;
        }

        if (lengthFile != null) {
            mLengthFile = lengthFile;
        }

        symbols = new TreeMap<Integer, String>();
        lengths = new TreeMap<Integer, Integer>();
        load();
    }

    public void load() {
        File symbolFile = new File(mFolder + mSymbolFile);
        File lengthFile = new File(mFolder + mLengthFile);
        Scanner reader;

        try {
            reader = new Scanner(symbolFile);
            while (reader.hasNext()) {
                String symbol = reader.next();
                int frequency = reader.nextInt();

                if (frequency > 0) {
                    symbols.put(symbolPool, symbol);
                    //System.out.println(symbolPool + " -- " + symbol);
                    symbolPool += frequency;
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            reader = new Scanner(lengthFile);
            while(reader.hasNext()) {
                int length = reader.nextInt();
                int frequency = reader.nextInt();

                if (frequency > 0) {
                    lengths.put(lengthPool, length);
                    //System.out.println(lengthPool + " -- " + length);
                    lengthPool += frequency;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int randomLength() {
        if (lengths == null || lengths.isEmpty()) {
            throw new IllegalStateException("Length frequency map is null");
        } else if (lengths.isEmpty()) {
            throw new IllegalStateException("Length frequency map is empty");
        }

        Random randomPoolIndex = new Random();
        int poolIndex = randomPoolIndex.nextInt(lengthPool+1);
        int result = -1;

        for (Map.Entry<Integer,Integer> entry : lengths.entrySet()) {
            if (poolIndex >= entry.getKey()) {
                result = entry.getValue();
            } else {
                break;
            }
        }
        return result;
    }

    public String randomSymbol() {
        if (symbols == null) {
            throw new IllegalStateException("Symbol frequency map is null");
        } else if (symbols.isEmpty()) {
            throw new IllegalStateException("Symbol frequency map is empty");
        }

        Random randomPoolIndex = new Random();
        int poolIndex = randomPoolIndex.nextInt(symbolPool+1);
        String result = null;

        for (Map.Entry<Integer, String> entry : symbols.entrySet()) {
            if (poolIndex >= entry.getKey()) {
                result = entry.getValue();
            } else {
                break;
            }
        }
        return result;
    }

    public String makeText() {
        StringBuilder text = new StringBuilder("");

        for (int i = 0; i < WORD_COUNT; i++) {
            int wordLength = randomLength();
            for (int j = 0; j < wordLength; j++) {
                String symbol = randomSymbol();
                j += symbol.length() -1;
                text.append(symbol);
            }
            text.append(" ");
        }

        String result = text.toString();
        
        if (WRITE_FILE) {
            try {
                FileWriter writer = new FileWriter(new File(mFolder + mOutFile));
                writer.write(result);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void setSymbolFile(String symbolFile) {
        if (symbolFile != null) {
            mSymbolFile = symbolFile;
            load();
        }
    }

    public void setLengthFile(String lengthFile) {
        if (lengthFile != null) {
            mLengthFile = lengthFile;
            load();
        }
    }
}
