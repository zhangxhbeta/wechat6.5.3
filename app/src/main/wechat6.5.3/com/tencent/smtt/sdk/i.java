package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class i {
    private static i pwa;
    private Context aHq;
    Map<String, Object> pwb = new HashMap();
    public SharedPreferences pwc;

    private i(Context context) {
        this.pwc = context.getSharedPreferences("tbs_download_config", 4);
        this.aHq = context.getApplicationContext();
    }

    public static synchronized i bMV() {
        i iVar;
        synchronized (i.class) {
            iVar = pwa;
        }
        return iVar;
    }

    public static synchronized i fb(Context context) {
        i iVar;
        synchronized (i.class) {
            if (pwa == null) {
                pwa = new i(context);
            }
            iVar = pwa;
        }
        return iVar;
    }

    public final synchronized long bMW() {
        int i;
        i = this.pwc.getInt("tbs_download_maxflow", 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * 1024)) * 1024;
    }

    public final synchronized long bMX() {
        return this.pwc.getLong("retry_interval", 86400);
    }

    public final synchronized long bMY() {
        long j;
        int i = 0;
        synchronized (this) {
            int i2 = this.pwc.getInt("tbs_download_min_free_space", 0);
            if (i2 != 0) {
                i = i2;
            }
            j = ((long) (i * 1024)) * 1024;
        }
        return j;
    }

    public final synchronized int bMZ() {
        int i;
        i = this.pwc.getInt("tbs_download_success_max_retrytimes", 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    public final synchronized int bNa() {
        int i;
        i = this.pwc.getInt("tbs_download_failed_max_retrytimes", 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    public final synchronized int bNb() {
        int i;
        if (this.pwc.contains("tbs_download_interrupt_code")) {
            i = this.pwc.getInt("tbs_download_interrupt_code", -99);
            if (i == -119 || i == -121) {
                i = this.pwc.getInt("tbs_download_interrupt_code_reason", -119);
            }
            if (System.currentTimeMillis() - this.pwc.getLong("tbs_download_interrupt_time", 0) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                i = !new File(new File(this.aHq.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.pwc.contains("tbs_needdownload") ? -96 : -101;
            } catch (Throwable th) {
                i = -95;
            }
        }
        i = (this.aHq == null || !"com.tencent.mobileqq".equals(this.aHq.getApplicationInfo().packageName) || "CN".equals(Locale.getDefault().getCountry())) ? (i * 1000) + this.pwc.getInt("tbs_install_interrupt_code", -1) : -320;
        return i;
    }

    public final synchronized void commit() {
        Editor edit = this.pwc.edit();
        for (String str : this.pwb.keySet()) {
            Object obj = this.pwb.get(str);
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else {
                try {
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                } catch (Exception e) {
                }
            }
        }
        edit.commit();
        this.pwb.clear();
    }

    public final synchronized void yK(int i) {
        try {
            Editor edit = this.pwc.edit();
            edit.putInt("tbs_download_interrupt_code", i);
            edit.putLong("tbs_download_interrupt_time", System.currentTimeMillis());
            edit.commit();
        } catch (Exception e) {
        }
    }

    public final synchronized void yL(int i) {
        Editor edit = this.pwc.edit();
        edit.putInt("tbs_install_interrupt_code", i);
        edit.commit();
    }
}
