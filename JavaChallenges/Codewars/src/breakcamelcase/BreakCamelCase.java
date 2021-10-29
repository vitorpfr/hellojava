package breakcamelcase;

public class BreakCamelCase {
    public static String camelCase(String input) {
        var stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(currentChar);
        }
        return stringBuilder.toString();
    }

    // another version found in the answers, not written by me
    public static String betterCamelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

    public static void main(String[] args) {
        System.out.println(camelCase("camelCasing"));
        System.out.println(camelCase("camelCasingTest"));
        System.out.println(camelCase("identifier"));
        System.out.println(camelCase(""));
    }
}
