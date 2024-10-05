import java.util.Arrays;

public class Debugger {
    public static void main(String[] args) {

    }

    static int[] listToIntArray(String list) {
        String[] elements = list.replace("[", "").replace("]", "").split(",");
        return Arrays.stream(elements).mapToInt(Integer::parseInt).toArray();
    }
}
