import java.io.*;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {

    Character cs;
    Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder cryptedText = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Character keyToCrypt = Character.toUpperCase(cf);
        String cryptoRotate = rotate(alphabet, keyToCrypt);

        for (int i = 0; i < text.length(); i++) {
            Character charToCrypt = text.charAt(i);
            if (!Character.isLetter(charToCrypt)) {
                cryptedText.append(charToCrypt);
            } else if (!Character.isUpperCase(charToCrypt)) {
                Character temp = Character.toUpperCase(charToCrypt);
                int alphabetIndex = alphabet.indexOf(temp);
                int cryptoIndex = alphabetIndex;
                cryptedText.append(Character.toLowerCase(cryptoRotate.charAt(cryptoIndex)));
            } else {
                Character temp = charToCrypt;
                int alphabetIndex = alphabet.indexOf(temp);
                int cryptoIndex = alphabetIndex;
                cryptedText.append(cryptoRotate.charAt(cryptoIndex));
            }
        }
        return cryptedText.toString();
    }


    public String encrypt(String text) {


        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }


    public static String rotate(String s, Character c) {
        int index = s.indexOf(c);

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int currentIndex = (index + i) % s.length();
            newString.append(s.charAt(currentIndex));
        }
        return newString.toString();
    }


    public void fileReaderAndCrypter() {
        StringBuilder sonnet = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/dima/Projects/SimpleCrypt/sonnet18.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                sonnet.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] sonnetArr = sonnet.toString().split("\n");
        for (int i = 0; i < sonnetArr.length; i++) {
            sonnetArr[i] = encrypt(sonnetArr[i]);
        }

        try {
            FileWriter writer = new FileWriter("/Users/dima/Projects/SimpleCrypt/sonnetCrypto.txt");
            for (String line : sonnetArr) {
                writer.write(line + "\n");
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String decryptedOfTHeFile() {

        StringBuilder decryptText = new StringBuilder();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/dima/Projects/SimpleCrypt/sonnetCrypto.txt"));

            while ((line = reader.readLine()) != null) {
                decryptText.append(line).append("\n");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] decryptArray = decryptText.toString().split("\n");

        for (int i = 0; i < decryptArray.length; i++) {
            decryptArray[i] = decrypt(decryptArray[i]);
        }
        StringBuilder finalDecrypt = new StringBuilder();

        for (String lines : decryptArray) {
            finalDecrypt.append(lines).append("\n");
        }
        return finalDecrypt.toString();
    }

}






