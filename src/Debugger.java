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
}
