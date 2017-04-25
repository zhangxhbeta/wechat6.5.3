package com.tencent.mm.h;

import android.content.SharedPreferences;
import com.tencent.mm.network.z;

public class a {
    public static final String cgI = null;
    private static SharedPreferences cgJ = null;
    private static SharedPreferences cgK = null;

    public static SharedPreferences sr() {
        SharedPreferences Mq = z.Mq();
        cgK = Mq;
        return Mq;
    }

    public static boolean ss() {
        return com.tencent.mm.kernel.a.uK().getBoolean("command_notification_status", false);
    }

    public static boolean st() {
        return com.tencent.mm.kernel.a.uK().getBoolean("settings_new_msg_notification", true);
    }

    public static boolean su() {
        return com.tencent.mm.kernel.a.uK().getBoolean("settings_show_detail", true);
    }

    public static boolean sv() {
        return com.tencent.mm.kernel.a.uK().getBoolean("settings_sound", true);
    }

    public static String sw() {
        return com.tencent.mm.kernel.a.uK().getString("settings.ringtone", cgI);
    }

    public static boolean sx() {
        return com.tencent.mm.kernel.a.uK().getBoolean("settings_shake", true);
    }

    public static boolean sy() {
        return com.tencent.mm.kernel.a.uK().getBoolean("settings_active_time_full", true);
    }

    public static int sz() {
        return com.tencent.mm.kernel.a.uK().getInt("settings_active_begin_time_hour", 8);
    }

    public static int sA() {
        return com.tencent.mm.kernel.a.uK().getInt("settings_active_end_time_hour", 23);
    }

    public static int sB() {
        return com.tencent.mm.kernel.a.uK().getInt("settings_active_begin_time_min", 0);
    }

    public static int sC() {
        return com.tencent.mm.kernel.a.uK().getInt("settings_active_end_time_min", 0);
    }

    public static boolean au(int i, int i2) {
        if (sy()) {
            return true;
        }
        int sz = sz();
        int sB = sB();
        int sA = sA();
        int sC = sC();
        if (sz == sA && sB == sC) {
            return false;
        }
        if (sz != sA || sB >= sC) {
            if (sA > sz) {
                if (i > sz && i < sA) {
                    return true;
                }
                if (i == sz && i2 > sB) {
                    return true;
                }
                if (i != sA || i2 >= sC) {
                    return false;
                }
                return true;
            } else if (sA >= sz && (sz != sA || sB <= sC)) {
                return true;
            } else {
                if (i > sz && i <= 23) {
                    return true;
                }
                if (i == sz && i2 > sB) {
                    return true;
                }
                if (i == sA && i2 < sC) {
                    return true;
                }
                if (i <= 0 || i >= sA) {
                    return false;
                }
                return true;
            }
        } else if (i != sz || i2 <= sB || i2 >= sC) {
            return false;
        } else {
            return true;
        }
    }
}
