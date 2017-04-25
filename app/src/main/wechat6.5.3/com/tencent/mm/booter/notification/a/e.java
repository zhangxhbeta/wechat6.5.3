package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.a;
import com.tencent.mm.h.i;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> bZQ;
    public boolean bZR;

    static {
        Set hashSet = new HashSet();
        bZQ = hashSet;
        hashSet.add("readerapp");
        bZQ.add("blogapp");
        bZQ.add("newsapp");
    }

    public static boolean dg(String str) {
        if (ab.Kk("keep_chatting_silent" + str)) {
            v.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            return true;
        }
        v.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean dh(String str) {
        boolean z = true;
        boolean contains = bZQ.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.i(str2, str3, objArr);
        return contains;
    }

    public static boolean qH() {
        Time time = new Time();
        time.setToNow();
        if (a.au(time.hour, time.minute)) {
            return false;
        }
        v.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        return true;
    }

    public static boolean qI() {
        v.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", Boolean.valueOf(a.sv()));
        return a.sv();
    }

    public static boolean dH(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", Boolean.valueOf(z));
        return z;
    }

    public static boolean a(String str, at atVar) {
        boolean z;
        boolean z2 = true;
        if (!i.dF(str) || i.c(atVar)) {
            z = false;
        } else {
            z = true;
        }
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Must Mute: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        v.i(str2, str3, objArr);
        return z;
    }

    public static boolean qJ() {
        boolean z;
        boolean z2 = true;
        try {
            b qiVar = new qi();
            qiVar.brC.bdn = 2;
            com.tencent.mm.sdk.c.a.nhr.z(qiVar);
            z = qiVar.brD.brE;
        } catch (Throwable e) {
            v.a("MicroMsg.Notification.Silent.Handle", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        v.d(str, str2, objArr);
        return z;
    }

    public static boolean l(int i, String str) {
        boolean tf;
        if (i.ec(i)) {
            if (i.dA(str)) {
                tf = i.tf();
            } else if (i.dB(str)) {
                tf = i.tg();
            }
            v.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(tf));
            return tf;
        }
        tf = true;
        v.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(tf));
        return tf;
    }

    public static boolean qK() {
        boolean sx = a.sx();
        if (qL() == 0) {
            sx = false;
        }
        v.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", Boolean.valueOf(sx), Integer.valueOf(qL()));
        return sx;
    }

    public static int qL() {
        return ((AudioManager) aa.getContext().getSystemService("audio")).getRingerMode();
    }

    public static boolean dI(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", Boolean.valueOf(z));
        return z;
    }
}
