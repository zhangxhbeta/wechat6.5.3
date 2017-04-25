package com.tencent.mm.platformtools;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class s {
    private static final long[] drl = new long[]{0, 259200000, 604800000};

    public static String Nd() {
        return aa.getContext().getSharedPreferences("update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static int Ne() {
        return aa.getContext().getSharedPreferences("update_config_prefs", 4).getInt("update_downloaded_pack_update_type", 3);
    }

    public static boolean Nf() {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        v.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", Long.valueOf(j), Integer.valueOf(i));
        if (i > drl.length - 1) {
            return true;
        }
        if (System.currentTimeMillis() - j > drl[i]) {
            return false;
        }
        if (System.currentTimeMillis() - j >= 0) {
            return true;
        }
        v.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
        aa.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
        v.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        return true;
    }

    public static boolean Ng() {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        v.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", Long.valueOf(j));
        if (z || (j != 0 && System.currentTimeMillis() - j > 3600000)) {
            return true;
        }
        return false;
    }
}
