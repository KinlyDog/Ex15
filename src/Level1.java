public class Level1 {
    public static String BiggerGreater(String input) {
        StringBuilder string = new StringBuilder(input);
        final int STR_LENGTH = string.length();

        boolean isLetterGreater = false;
        int startPoint = 0;

        // проверяем можно ли получить лексикографически большее слово
        for (int i = STR_LENGTH - 1; i > -1; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (input.charAt(i) > input.charAt(j)) {
                    string.setCharAt(j, input.charAt(i));
                    string.setCharAt(i, input.charAt(j));

                    isLetterGreater = true;
                    startPoint = j;
                    break;
                }
            }

            if (isLetterGreater) break;
        }

        if (!isLetterGreater) return "";

        // находим наименьшее из лексикографически больших слов
        for (int i = startPoint + 1; i < STR_LENGTH; i++) {
            for (int j = i + 1; j < STR_LENGTH; j++) {
                if (string.charAt(i) > string.charAt(j)) {
                    char ch = string.charAt(i);
                    string.setCharAt(i, string.charAt(j));
                    string.setCharAt(j, ch);
                }
            }
        }

        return string.toString();
    }
}
