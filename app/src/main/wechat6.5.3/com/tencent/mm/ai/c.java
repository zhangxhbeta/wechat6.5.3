package com.tencent.mm.ai;

import android.telephony.TelephonyManager;
import com.tencent.mm.h.j;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.TimeZone;

public final class c {
    public static boolean js(String str) {
        ajr HE = b.HE();
        if (HE == null || !HE.mKc.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean HG() {
        return HI() || HH();
    }

    public static boolean HH() {
        v.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[]{Integer.valueOf(j.sU().getInt("ShakeMusicGlobalSwitch", 0))});
        if (j.sU().getInt("ShakeMusicGlobalSwitch", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean HI() {
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!(be.kS(networkCountryIso) || networkCountryIso.equalsIgnoreCase("cn"))) {
                return false;
            }
        }
        return true;
    }
}
