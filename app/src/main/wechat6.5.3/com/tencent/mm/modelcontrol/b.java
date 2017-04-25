package com.tencent.mm.modelcontrol;

import com.tencent.mm.h.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b {
    public static int Ec() {
        String value = j.sU().getValue("C2CSightTimeLength");
        v.i("MicroMsg.BusyTimeControlLogic", "C2CSightTimeLength value: " + value);
        PString pString = new PString();
        if (a(value, pString)) {
            try {
                v.i("MicroMsg.BusyTimeControlLogic", "it is busy time now, need control C2C short video max record time: " + pString.value);
                return be.getInt(pString.value, 0) * 1000;
            } catch (Throwable e) {
                v.a("MicroMsg.BusyTimeControlLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.BusyTimeControlLogic", e.toString());
            }
        }
        return 6500;
    }

    public static int Ed() {
        String value = j.sU().getValue("SnsSightTimeLength");
        v.i("MicroMsg.BusyTimeControlLogic", "SnsSightTimeLength value: " + value);
        PString pString = new PString();
        if (a(value, pString)) {
            try {
                v.i("MicroMsg.BusyTimeControlLogic", "it is busy time now, need control SNS short video max record time: " + pString.value);
                return be.getInt(pString.value, 0) * 1000;
            } catch (Throwable e) {
                v.a("MicroMsg.BusyTimeControlLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.BusyTimeControlLogic", e.toString());
            }
        }
        return 6500;
    }

    public static boolean iu(String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            int Ee = Ee();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(":");
                int KL = be.KL(split4[1]) + (be.KL(split4[0]) * 60);
                split3 = split3[1].split(":");
                if (q(KL, be.KL(split3[1]) + (be.KL(split3[0]) * 60), Ee)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.BusyTimeControlLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
            return false;
        }
    }

    private static boolean a(String str, PString pString) {
        if (be.kS(str)) {
            return false;
        }
        try {
            int Ee = Ee();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split(",");
                String[] split4 = split3[0].split("-");
                String[] split5 = split4[0].split(":");
                int KL = be.KL(split5[1]) + (be.KL(split5[0]) * 60);
                split4 = split4[1].split(":");
                if (q(KL, be.KL(split4[1]) + (be.KL(split4[0]) * 60), Ee)) {
                    pString.value = split3[1];
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.BusyTimeControlLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl-result error : " + e.toString());
            return false;
        }
    }

    private static int Ee() {
        String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
        int KL = (be.KL(split[1]) + (be.KL(split[0]) * 60)) - ((((int) Ef()) - 8) * 60);
        if (KL < 0) {
            return KL + 1440;
        }
        if (KL >= 1440) {
            return KL - 1440;
        }
        return KL;
    }

    public static long Ef() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    private static boolean q(int i, int i2, int i3) {
        if (i < i2) {
            if (i3 >= i2 || i3 < i) {
                return false;
            }
            return true;
        } else if (i3 <= 1440 && i3 >= i) {
            return true;
        } else {
            if (i3 >= i2 || i3 < 0) {
                return false;
            }
            return true;
        }
    }
}
