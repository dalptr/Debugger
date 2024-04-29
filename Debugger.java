import static java.lang.reflect.Array.getLength;
import static java.lang.reflect.Array.get;

public class Debugger {
    public static String arrayToString(Object array) {
        final int length = getLength(array);
        final int last = length - 1;
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < length; ++i) {
            Object item = get(array, i);
            res.append(objectToString(item));
            if (i != last) {
                res.append(',');
                res.append(' ');
            }
        }
        res.append(']');
        return res.toString();
    }

    public static String objectToString(Object o) {
        if (o == null) {
            return "null";
        } else if (o.getClass().isArray()) {
            return arrayToString(o);
        } else if (o instanceof String) {
            return String.format("\"%s\"", o);
        } else if (o instanceof Character) {
            return String.format("'%c'", o);
        } else {
            return String.valueOf(o);
        }
    }

    public static void debug(boolean conditional, Object o) {
        if (!conditional) return;
        System.out.println(objectToString(o));
    }
}
