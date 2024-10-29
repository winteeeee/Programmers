public class Debugger {
    public static void main(String[] args) {

    }

    static int[] listToIntArray(String list) {
        String[] elements = list.split(",");
        int[] result = new int[elements.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(elements[i].replaceAll("[^0-9]", ""));
        }

        return result;
    }

    static String[] listToStringArray(String list) {
        String[] elements = list.split(",");
        for (int i = 0; i < elements.length; i++) {
            elements[i] = getString(elements[i]);
        }

        return elements;
    }

    static String getString(String str) {
        var sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '[' && str.charAt(i) != ']' && str.charAt(i) != '\"' && str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    static int[][] listTo2DIntArray(String list) {
        String[] elements = list.split("],");
        int[][] result = new int[elements.length][elements[0].split(",").length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = listToIntArray(elements[i]);
        }

        return result;
    }

    static String[][] listTo2DStringArray(String list) {
        String[] elements = list.split("],");
        String[][] result = new String[elements.length][elements[0].split(",").length];
        for (int i = 0; i < elements.length; i++) {
            result[i] = listToStringArray(elements[i]);
        }

        return result;
    }
}
