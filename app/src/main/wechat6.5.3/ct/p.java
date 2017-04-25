package ct;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class p {
    public static Context a = null;
    public static String b = SQLiteDatabase.KeyEmpty;
    public static String c = "null";
    public static int d = 0;
    public static String e = SQLiteDatabase.KeyEmpty;
    public static String f = SQLiteDatabase.KeyEmpty;
    public static String g = "1.6.4.1101";
    private static a h = a.OFFICIAL;

    enum a {
        DEV,
        GRAY,
        OFFICIAL;

        static {
            DEV = new a("DEV", 0);
            GRAY = new a("GRAY", 1);
            OFFICIAL = new a("OFFICIAL", 2);
            a[] aVarArr = new a[]{DEV, GRAY, OFFICIAL};
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        a = context.getApplicationContext();
        b = str;
        e = str3;
        f = str2;
        g = "1.6.4.1101";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            c = packageInfo.versionName;
            d = packageInfo.versionCode;
        } catch (Throwable th) {
        }
    }

    public static boolean a() {
        return h == a.DEV;
    }
}
