package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class r {
    public static int a(Intent intent, String str, int i) {
        if (intent != null) {
            try {
                i = intent.getIntExtra(str, i);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
        }
        return i;
    }

    public static int a(Bundle bundle, String str, int i) {
        if (bundle != null) {
            try {
                i = bundle.getInt(str, i);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
        }
        return i;
    }

    public static long f(Intent intent, String str) {
        long j = 0;
        if (intent != null) {
            try {
                j = intent.getLongExtra(str, 0);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
        }
        return j;
    }

    public static Bundle T(Intent intent) {
        Bundle bundle = null;
        if (intent != null) {
            try {
                bundle = intent.getExtras();
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getExtras exception:%s", e.getMessage());
            }
        }
        return bundle;
    }

    public static boolean a(Intent intent, String str, boolean z) {
        if (intent != null) {
            try {
                z = intent.getBooleanExtra(str, z);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", e.getMessage());
            }
        }
        return z;
    }

    public static String g(Intent intent, String str) {
        String str2 = null;
        if (intent != null) {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
        }
        return str2;
    }

    public static String c(Bundle bundle, String str) {
        String str2 = null;
        if (bundle != null) {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
        }
        return str2;
    }

    public static byte[] h(Intent intent, String str) {
        byte[] bArr = null;
        if (intent != null) {
            try {
                bArr = intent.getByteArrayExtra(str);
            } catch (Exception e) {
                v.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", e.getMessage());
            }
        }
        return bArr;
    }

    public static void i(Intent intent, String str) {
        try {
            intent.putExtra(str, true);
        } catch (Throwable e) {
            v.a("MicroMsg.IntentUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
