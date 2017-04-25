package android.support.v4.d;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Locale;

public final class f {
    public static final Locale ROOT = new Locale(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
    private static final a vs;
    private static String vt = "Arab";
    private static String vu = "Hebr";

    private static class a {
        private a() {
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (!(locale == null || locale.equals(f.ROOT))) {
                String a = a.a(locale);
                if (a == null) {
                    switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                        case (byte) 1:
                        case (byte) 2:
                            return 1;
                        default:
                            return 0;
                    }
                } else if (a.equalsIgnoreCase(f.vt) || a.equalsIgnoreCase(f.vu)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    private static class b extends a {
        private b() {
            super();
        }

        public final int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            vs = new b();
        } else {
            vs = new a();
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return vs.getLayoutDirectionFromLocale(locale);
    }
}
