public class Level1 {
    public static String BiggerGreater(String input) {
        StringBuilder strBld = new StringBuilder(input);
        int len = strBld.length();

        boolean isLetterGreater = false;
        int startPoint = 0;

        for (int i = len - 1; i > -1; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (input.charAt(i) > input.charAt(j)) {
                    strBld.setCharAt(j, input.charAt(i));
                    strBld.setCharAt(i, input.charAt(j));

                    isLetterGreater = true;
                    startPoint = j;
                    break;
                }
            }

            if (isLetterGreater) break;
        }

        if (!isLetterGreater) return "";

        for (int i = startPoint + 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (strBld.charAt(i) > strBld.charAt(j)) {
                    char ch = strBld.charAt(i);
                    strBld.setCharAt(i, strBld.charAt(j));
                    strBld.setCharAt(j, ch);
                }
            }
        }

        return strBld.toString();
    }
}
