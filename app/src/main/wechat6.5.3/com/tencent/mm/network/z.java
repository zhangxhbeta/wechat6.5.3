package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class z {
    private static boolean dmD = false;
    private static z dmu;
    private static boolean hasInit = false;
    private s bXw;
    private x dmA;
    private Looper dmB;
    private v dmC;
    private aa dmv;
    private ab dmw;
    private Context dmx;
    private a dmy;
    private y dmz;
    private ac handler;

    public interface a {
        void ao(boolean z);
    }

    private z() {
    }

    private static z Mo() {
        if (dmu == null) {
            dmu = new z();
        }
        return dmu;
    }

    private static SharedPreferences Mp() {
        return aa.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
    }

    public static SharedPreferences Mq() {
        String string = Mp().getString("login_weixin_username", SQLiteDatabase.KeyEmpty);
        if (be.kS(string)) {
            string = ai.cse.A("login_weixin_username", SQLiteDatabase.KeyEmpty);
            if (!be.kS(string)) {
                Mp().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        return aa.getContext().getSharedPreferences("notify_key_pref" + string, 4);
    }

    public static void Mr() {
        if (!hasInit) {
            SharedPreferences Mq = Mq();
            long j = Mq.getLong("wakeup_alarm_last_tick", 0);
            int i = Mq.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > be.Ni()) {
                v.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                Mq.edit().putLong("wakeup_alarm_last_tick", be.Ni()).commit();
                Mq.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                return;
            } else if (be.ay(j) > 86400000) {
                Mq.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                Mq.edit().putLong("wakeup_alarm_last_tick", be.Ni()).commit();
                Mq.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                v.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                Mq.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                v.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
    }

    public static boolean Ms() {
        String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
        if (A != null) {
            A = A.replace("[\\/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("notify_key_pref" + A, 4);
        v.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        return (r0 > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
    }

    public static aa Mt() {
        return Mo().dmv;
    }

    public static void a(aa aaVar) {
        Mo().dmv = aaVar;
    }

    public static ab Mu() {
        return Mo().dmw;
    }

    public static void a(ab abVar) {
        Mo().dmw = abVar;
    }

    public static Context getContext() {
        return Mo().dmx;
    }

    public static void setContext(Context context) {
        Mo().dmx = context;
    }

    public static ac Mv() {
        return Mo().handler;
    }

    public static void a(ac acVar) {
        Mo().handler = acVar;
    }

    public static a Mw() {
        return Mo().dmy;
    }

    public static void a(a aVar) {
        Mo().dmy = aVar;
    }

    public static s Mx() {
        return Mo().bXw;
    }

    public static void b(s sVar) {
        Mo().bXw = sVar;
    }

    public static y My() {
        return Mo().dmz;
    }

    public static void a(y yVar) {
        Mo().dmz = yVar;
    }

    public static x Mz() {
        return Mo().dmA;
    }

    public static void a(x xVar) {
        Mo().dmA = xVar;
    }

    public static Looper MA() {
        if (Mo().dmB == null) {
            HandlerThread Lg = e.Lg("MMPushCore_handlerThread");
            Lg.start();
            Mo().dmB = Lg.getLooper();
        }
        return Mo().dmB;
    }

    public static v MB() {
        return Mo().dmC;
    }

    public static void a(v vVar) {
        Mo().dmC = vVar;
    }

    public static void bn(boolean z) {
        Mo();
        dmD = z;
    }

    public static boolean MC() {
        Mo();
        return dmD;
    }
}
