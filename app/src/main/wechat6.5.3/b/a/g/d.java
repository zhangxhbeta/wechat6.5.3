package b.a.g;

import java.util.regex.Pattern;

public final class d {
    private static final Pattern pPF = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    public static void c(Object obj, String str) {
        k(obj != null, str);
    }

    public static void es(String str, String str2) {
        boolean z = (str == null || str.trim().equals("")) ? false : true;
        k(z, str2);
    }

    private static void k(boolean z, String str) {
        if (str == null || str.trim().length() <= 0) {
            str = "Received an invalid parameter";
        }
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
