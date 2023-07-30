import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');
        System.out.println(actual.toString());

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');
        System.out.println(actual.toString());
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        System.out.println(actual.toString());
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }

//    @Test
//    public void testSonnet () {
//
//        ROT13 cipher = new ROT13();
//
//        String expected = "Shall I compare thee to a summer’s day?\n" +
//                "Thou art more lovely and more temperate:\n" +
//                "Rough winds do shake the darling buds of May,\n" +
//                "And summer’s lease hath all too short a date;\n" +
//                "Sometime too hot the eye of heaven shines,\n" +
//                "And often is his gold complexion dimm'd;\n" +
//                "And every fair from fair sometime declines,\n" +
//                "By chance or nature’s changing course untrimm'd;\n" +
//                "But thy eternal summer shall not fade,\n" +
//                "Nor lose possession of that fair thou ow’st;\n" +
//                "Nor shall death brag thou wander’st in his shade,\n" +
//                "When in eternal lines to time thou grow’st:\n" +
//                "   So long as men can breathe or eyes can see,\n" +
//                "   So long lives this, and this gives life to thee." ;
//        //String st = cipher.fileReader();
//       // String actual = cipher.crypt(st);
//       // Assert.assertEquals(expected,actual);
//    }


    @Test
    public void sonnetTest() {
        ROT13 cipher = new ROT13('a', 'n');
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.\n";

        cipher.fileReaderAndCrypter();
        String actual = cipher.decryptedOfTHeFile();
        Assert.assertEquals(expected, actual);
    }

}