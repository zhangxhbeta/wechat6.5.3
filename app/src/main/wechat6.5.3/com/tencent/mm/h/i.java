package com.tencent.mm.h;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.g;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import java.util.List;
import java.util.Map;

public final class i extends a {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void aA(boolean z) {
        aa.btk().edit().putBoolean("settings_new_msg_notification", z).commit();
        a.uK().edit().putBoolean("settings_new_msg_notification", z).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", Boolean.valueOf(z));
    }

    public static void aB(boolean z) {
        aa.btk().edit().putBoolean("settings_show_detail", z).commit();
        a.uK().edit().putBoolean("settings_show_detail", z).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", Boolean.valueOf(z));
    }

    public static void aC(boolean z) {
        a.uK().edit().putBoolean("command_notification_status", z).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", Boolean.valueOf(z));
    }

    public static void aD(boolean z) {
        aa.btk().edit().putBoolean("settings_sound", z).commit();
        a.uK().edit().putBoolean("settings_sound", z).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", Boolean.valueOf(z));
    }

    public static void aE(boolean z) {
        aa.btk().edit().putBoolean("settings_shake", z).commit();
        a.uK().edit().putBoolean("settings_shake", z).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", Boolean.valueOf(z));
    }

    public static void dz(String str) {
        aa.btk().edit().putString("settings.ringtone", str).commit();
        a.uK().edit().putString("settings.ringtone", str).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", str);
    }

    public static void aF(boolean z) {
        aa.btk().edit().putBoolean("settings_active_time_full", z).commit();
        a.uK().edit().putBoolean("settings_active_time_full", z).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", Boolean.valueOf(z));
    }

    public static void av(int i, int i2) {
        SharedPreferences btk = aa.btk();
        btk.edit().putInt("settings_active_begin_time_hour", i).commit();
        btk.edit().putInt("settings_active_begin_time_min", i2).commit();
        btk = a.uK();
        btk.edit().putInt("settings_active_begin_time_hour", i).commit();
        btk.edit().putInt("settings_active_begin_time_min", i2).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void aw(int i, int i2) {
        SharedPreferences btk = aa.btk();
        btk.edit().putInt("settings_active_end_time_hour", i).commit();
        btk.edit().putInt("settings_active_end_time_min", i2).commit();
        btk = a.uK();
        btk.edit().putInt("settings_active_end_time_hour", i).commit();
        btk.edit().putInt("settings_active_end_time_min", i2).commit();
        v.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static boolean sY() {
        return c.eB(a.uJ());
    }

    public static void eb(int i) {
        a.uK().edit().putInt("notification.status.webonline.push.open", i).commit();
    }

    public static boolean sZ() {
        return k.eF(a.uK().getInt("notification.status.webonline.push.open", 0));
    }

    public static void ta() {
        SharedPreferences btk = aa.btk();
        Editor edit = a.uK().edit();
        edit.putBoolean("settings_new_msg_notification", btk.getBoolean("settings_new_msg_notification", true));
        edit.putBoolean("settings_show_detail", btk.getBoolean("settings_show_detail", true));
        edit.putBoolean("settings_sound", btk.getBoolean("settings_sound", true));
        edit.putString("settings.ringtone", btk.getString("settings.ringtone", cgI));
        edit.putBoolean("settings_shake", btk.getBoolean("settings_shake", true));
        edit.putBoolean("settings_active_time_full", btk.getBoolean("settings_active_time_full", true));
        edit.putInt("settings_active_begin_time_hour", btk.getInt("settings_active_begin_time_hour", 8));
        edit.putInt("settings_active_begin_time_min", btk.getInt("settings_active_begin_time_min", 0));
        edit.putInt("settings_active_end_time_hour", btk.getInt("settings_active_end_time_hour", 23));
        edit.putInt("settings_active_end_time_min", btk.getInt("settings_active_end_time_min", 0));
        edit.commit();
        v.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", Boolean.valueOf(r2), Boolean.valueOf(r3), Boolean.valueOf(r4), r5, Boolean.valueOf(r6), Boolean.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r0));
    }

    public static boolean ec(int i) {
        return i == 50 || i == 53;
    }

    public static boolean dA(String str) {
        b qiVar = new qi();
        qiVar.brC.bdn = 1;
        qiVar.brC.content = str;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        if (qiVar.brD.type == 2 || str.equals(at.nvC)) {
            return true;
        }
        return false;
    }

    public static boolean dB(String str) {
        b qiVar = new qi();
        qiVar.brC.bdn = 1;
        qiVar.brC.content = str;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        if (qiVar.brD.type == 3 || str.equals(at.nvB)) {
            return true;
        }
        return false;
    }

    public static int b(at atVar) {
        int i = m.eD(atVar.field_talker) ? 0 : 3;
        if (!(atVar == null || atVar.field_bizChatId == -1 || !e.hC(atVar.field_talker))) {
            com.tencent.mm.modelbiz.a.c Z = u.DA().Z(atVar.field_bizChatId);
            if (!Z.DN() && Z.fe(1)) {
                return i;
            }
        }
        String str = atVar.bNo;
        if (be.kS(str)) {
            return i;
        }
        Map q = bf.q(str, "msgsource");
        if (q == null || q.isEmpty()) {
            return i;
        }
        try {
            int parseInt = Integer.parseInt((String) q.get(".msgsource.tips"));
            if ((parseInt & 1) != 0 || (parseInt & 2) == 0) {
                return parseInt;
            }
            return 0;
        } catch (Exception e) {
            return i;
        }
    }

    public static int tb() {
        if (ak.uz()) {
            return n.fw(m.crA);
        }
        v.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        return 0;
    }

    public static List<String> tc() {
        return n.o(m.crA, -1);
    }

    public static int td() {
        if (ak.uz()) {
            return n.fv(m.crA);
        }
        v.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        return 0;
    }

    public static int dC(String str) {
        return n.E(str, null);
    }

    public static boolean dD(String str) {
        return com.tencent.mm.storage.u.ew(str);
    }

    public static boolean dE(String str) {
        return str.toLowerCase().endsWith("@chatroom");
    }

    public static int te() {
        return g.xD();
    }

    public static boolean dF(String str) {
        return m.fs(str) || (m.dE(str) && !m.fr(str));
    }

    public static int dG(String str) {
        int i = 0;
        ak.yW();
        ac wK = c.wK();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(atCount) from rconversation");
        stringBuilder.append(" where unReadCount > 0");
        if (!be.kS(str)) {
            stringBuilder.append(" and username = '").append(str).append("'");
        }
        v.d("MicroMsg.ConversationStorage", "query sql: %s", stringBuilder.toString());
        Cursor rawQuery = wK.cie.rawQuery(r2, null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public static boolean c(at atVar) {
        if (atVar == null) {
            return false;
        }
        return atVar.Mw(k.xF());
    }

    public static boolean tf() {
        ak.yW();
        return ((Boolean) c.vf().get(73217, Boolean.valueOf(true))).booleanValue();
    }

    public static boolean tg() {
        ak.yW();
        return ((Boolean) c.vf().get(73218, Boolean.valueOf(true))).booleanValue();
    }
}
