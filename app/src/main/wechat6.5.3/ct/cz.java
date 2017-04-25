package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Pattern;

public final class cz {
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c = a;
    public static final Pattern d = Pattern.compile("[A-Z0-9]{12}");

    static {
        Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
        a = compile;
        b = compile;
    }

    public static String a(String str, Pattern pattern) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (pattern.matcher(str).matches()) {
            return str;
        }
        return SQLiteDatabase.KeyEmpty;
    }
}
