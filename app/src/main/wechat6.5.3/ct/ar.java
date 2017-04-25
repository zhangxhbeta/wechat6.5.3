package ct;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ar {
    private static String a = null;

    public static String a(Context context) {
        return context == null ? null : context.getPackageName();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean b(android.content.Context r5) {
        /*
        r1 = 1;
        r0 = 0;
        r2 = ct.ar.class;
        monitor-enter(r2);
        if (r5 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);
        return r0;
    L_0x0009:
        r0 = "Access_Preferences";
        r3 = 0;
        r0 = r5.getSharedPreferences(r0, r3);	 Catch:{ Exception -> 0x003b, all -> 0x0038 }
        r3 = "isNew";
        r4 = 1;
        r0 = r0.getBoolean(r3, r4);	 Catch:{ Exception -> 0x003b, all -> 0x0038 }
        if (r0 == 0) goto L_0x0007;
    L_0x001b:
        r1 = r5.getApplicationContext();	 Catch:{ Exception -> 0x0036, all -> 0x0038 }
        r3 = "Access_Preferences";
        r4 = 0;
        r1 = r1.getSharedPreferences(r3, r4);	 Catch:{ Exception -> 0x0036, all -> 0x0038 }
        r1 = r1.edit();	 Catch:{ Exception -> 0x0036, all -> 0x0038 }
        r3 = "isNew";
        r4 = 0;
        r1.putBoolean(r3, r4);	 Catch:{ Exception -> 0x0036, all -> 0x0038 }
        r1.commit();	 Catch:{ Exception -> 0x0036, all -> 0x0038 }
        goto L_0x0007;
    L_0x0036:
        r1 = move-exception;
        goto L_0x0007;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x003b:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.ar.b(android.content.Context):boolean");
    }

    public static synchronized String c(Context context) {
        String str;
        int i = 0;
        synchronized (ar.class) {
            if (a != null) {
                str = a;
            } else {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context == null ? null : context.getPackageName(), 0);
                    String str2 = packageInfo.versionName;
                    int i2 = packageInfo.versionCode;
                    if (str2 == null || str2.trim().length() <= 0) {
                        str = String.valueOf(i2);
                    } else {
                        str2 = str2.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                        char[] toCharArray = str2.toCharArray();
                        int i3 = 0;
                        while (i < toCharArray.length) {
                            if (toCharArray[i] == '.') {
                                i3++;
                            }
                            i++;
                        }
                        str = i3 < 3 ? str2 + "." + i2 : str2;
                        a = str;
                    }
                } catch (Exception e) {
                    str = SQLiteDatabase.KeyEmpty;
                }
            }
        }
        return str;
    }
}
