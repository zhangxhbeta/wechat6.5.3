package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class p {
    static long bYr = 0;

    static class a {
        int bYt;
        int bYu = 1;
        int bYv;
        int bYw;
        int bYx;

        a() {
        }

        public final boolean cX(String str) {
            String[] split = str.split(",");
            if (split == null || split.length != 5) {
                v.e("MicroMsg.ProcessReport", "error format");
                return false;
            }
            try {
                this.bYt = be.getInt(split[0], 0);
                this.bYu = be.getInt(split[1], 0);
                this.bYv = be.getInt(split[2], 0);
                this.bYw = be.getInt(split[3], 0);
                this.bYx = be.getInt(split[4], 0);
                return true;
            } catch (Throwable e) {
                v.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
                v.a("MicroMsg.ProcessReport", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            }
        }

        public final String toString() {
            return String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.bYt), Integer.valueOf(this.bYu), Integer.valueOf(this.bYv), Integer.valueOf(this.bYw), Integer.valueOf(this.bYx)});
        }
    }

    static /* synthetic */ void cW(String str) {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", SQLiteDatabase.KeyEmpty).split("=");
        if (split == null || split.length <= 1) {
            v.i("MicroMsg.ProcessReport", "nothing to reprot");
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            v.i("MicroMsg.ProcessReport", "reprot %s: %s", str, split[i]);
            g.iuh.Y(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
    }

    public static void onCreate(boolean z) {
        if (z) {
            j("mm_proc_startup", 2);
        } else {
            j("push_proc_startup", 1);
        }
    }

    private static void j(String str, int i) {
        a aVar;
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", SQLiteDatabase.KeyEmpty).split("=");
        if (split != null && split.length > 0) {
            aVar = new a();
            if (aVar.cX(split[split.length - 1])) {
                aVar.bYx = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        aVar = new a();
        aVar.bYt = i;
        aVar.bYv = Process.myPid();
        aVar.bYw = (int) be.Nh();
        String c = c(split);
        String aVar2 = aVar.toString();
        if (c.length() > 0) {
            aVar2 = c + "=" + aVar2;
        }
        v.d("MicroMsg.ProcessReport", "startProc new info %s", aVar2);
        sharedPreferences.edit().putString("startup_info", aVar2).commit();
    }

    public static void oC() {
        cV("mm_proc_startup");
        cV("push_proc_startup");
    }

    private static void cV(String str) {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", SQLiteDatabase.KeyEmpty).split("=");
        if (split != null && split.length != 0) {
            a aVar = new a();
            if (aVar.cX(split[split.length - 1])) {
                aVar.bYu = 2;
                split[split.length - 1] = aVar.toString();
            }
            v.d("MicroMsg.ProcessReport", "uerExit new info %s", c(split));
            sharedPreferences.edit().putString("startup_info", r1).commit();
        }
    }

    public static void qq() {
        if (bYr == 0 || be.az(bYr) >= 3600000) {
            final int intValue = ((Integer) ak.yT().get(37, Integer.valueOf(0))).intValue();
            if (d.lWh != intValue) {
                ak.yT().set(37, Integer.valueOf(d.lWh));
                new ac(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        g.iuh.Y(10675, intValue + "," + f.aPW);
                    }
                });
            }
            bYr = be.Nj();
            new ac(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    p.cW("mm_proc_startup");
                    p.cW("push_proc_startup");
                }
            });
        }
    }

    private static String c(String[] strArr) {
        String str = SQLiteDatabase.KeyEmpty;
        Object obj = 1;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (obj != null) {
                obj = null;
            } else {
                str = str + "=";
            }
            i++;
            str = str + str2;
        }
        return str;
    }
}
