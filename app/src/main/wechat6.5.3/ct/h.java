package ct;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class h {
    public static boolean a = true;
    private static final Lock b = new ReentrantLock();
    private static a c = null;

    public static a a() {
        if (c != null) {
            return c;
        }
        try {
            if (p.a != null) {
                c = a(p.a, p.b, p.f, p.e);
            }
        } catch (Exception e) {
        }
        return c;
    }

    public static a a(Context context, String str, String str2, String str3) {
        new StringBuilder("creatAccessScheduler...context:").append(context).append(",appId:").append(str).append(",channelId:").append(str2).append(",uuid:").append(str3);
        bd.b();
        if (context == null || be.a(str)) {
            throw new l("AccessScheduler init illegal Argument[appId=" + str + ",context=" + context + "]");
        }
        b.lock();
        try {
            if (c == null) {
                if (be.a(str3) || str3.toLowerCase().contains("test")) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("Access_Preferences", 0);
                    if (sharedPreferences != null) {
                        str3 = sharedPreferences.getString("test_uuid", SQLiteDatabase.KeyEmpty);
                        if (be.a(str3)) {
                            str3 = be.a(context) + "_" + be.b(context);
                            sharedPreferences.edit().putString("test_uuid", str3).commit();
                        }
                    }
                }
                if (be.a(str2)) {
                    str2 = "test_channelId";
                }
                try {
                    p.a(context, str, str2, str3);
                    bc.a(context);
                    c = new e();
                    new Thread((Runnable) c, "HalleyScheduler").start();
                } catch (Exception e) {
                }
            }
            b.unlock();
            return c;
        } catch (Throwable th) {
            b.unlock();
        }
    }
}
