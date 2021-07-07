package strings.isanagram;

import java.util.Random;

public class IsAnagramMain {

    public static String genString(int targetStringLength) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public static void main(String[] args) {

        // generate really large string
        String s1 = genString(100000000);
        String s2 = genString(100000000);


        long start4 = System.currentTimeMillis();
        System.out.println(IsAnagram.areAnagrams(s1, s2));
        long end4 = System.currentTimeMillis();
        System.out.println("Time taken using arraycount (my version): " + (end4 - start4) + " ms");

        long start3 = System.currentTimeMillis();
        System.out.println(IsAnagram.areAnagramsStack(s1, s2));
        long end3 = System.currentTimeMillis();
        System.out.println("Time taken using hashmap (stackoverflow): " + (end3 - start3) + " ms");

        long start2 = System.currentTimeMillis();
        System.out.println(IsAnagram.runIsAnagram(s1, s2));
        long end2 = System.currentTimeMillis();
        System.out.println("Time taken using hashmap: " + (end2 - start2) + " ms");

        long start1 = System.currentTimeMillis();
        System.out.println(IsAnagram.memIsAnagram(s1, s2));
        long end1 = System.currentTimeMillis();
        System.out.println("Time taken sorting strings: " + (end1 - start1) + " ms");


    }
}
