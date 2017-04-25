package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.a.g;
import com.tencent.mm.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class h {
    private static final long[] drl = new long[]{0, 259200000, 604800000};

    private static String dz(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Throwable e) {
            v.a("MicroMsg.UpdateUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public static String dA(Context context) {
        String dz = dz(context);
        if (dz == null || !new File(dz).exists()) {
            return null;
        }
        a bb = a.bb(dz);
        return (bb == null || bb.aPT == null) ? g.aX(dz) : bb.aPT.apkMd5;
    }

    public static int e(Context context, String str, String str2, String str3) {
        return com.tencent.mm.b.h.a(dz(context), str, str2, str3);
    }

    public static void Q(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", false);
        intent.putExtra("intent_extra_opcode", i);
        context.sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
    }

    public static void R(Context context, int i) {
        e(context, i, 0);
    }

    public static void e(Context context, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", true);
        intent.putExtra("intent_extra_opcode", i);
        if (i == 2) {
            intent.putExtra("intent_extra_install_dialog_times", i2);
        }
        context.sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
    }

    public static String Nd() {
        return MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static String bsq() {
        return MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_sig_key", null);
    }

    public static String bsr() {
        return MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_desc_key", null);
    }

    public static int bss() {
        return MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getInt("update_downloaded_pack_download_mode", 0);
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().putString("update_downloaded_pack_md5_key", str).putString("update_downloaded_pack_sig_key", str2).putString("update_downloaded_pack_desc_key", str3).putInt("update_downloaded_pack_size_key", i).putInt("update_downloaded_pack_download_mode", i2).putInt("update_downloaded_pack_update_type", i3).putString("update_download_not_auto_download_range", str4).commit();
        v.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", str, Integer.valueOf(i), str4);
    }

    public static int bst() {
        v.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", Integer.valueOf(MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0)));
        return MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0);
    }

    public static void bsu() {
        int i = 0;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4);
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        v.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", Integer.valueOf(i2));
        if (i2 >= drl.length - 1) {
            String Nd = Nd();
            StringBuffer stringBuffer = null;
            if (!be.kS(Nd)) {
                String[] bsv = bsv();
                stringBuffer = new StringBuffer();
                stringBuffer.append(Nd);
                if (bsv != null) {
                    int length = bsv.length;
                    while (i < length) {
                        String str = bsv[i];
                        if (!be.kS(str)) {
                            stringBuffer.append(":");
                            stringBuffer.append(str);
                        }
                        i++;
                    }
                }
            }
            sharedPreferences.edit().clear().commit();
            if (stringBuffer != null) {
                sharedPreferences.edit().putString("update_downloaded_ignored_pack", stringBuffer.toString()).commit();
                return;
            }
            return;
        }
        sharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", i2 + 1).commit();
    }

    public static boolean JM(String str) {
        String[] bsv = bsv();
        if (bsv == null) {
            return false;
        }
        for (String equals : bsv) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static String[] bsv() {
        String string = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_ignored_pack", null);
        if (be.kS(string)) {
            return null;
        }
        return string.split(":");
    }

    public static void bsw() {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
        v.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    }

    public static void bsx() {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().putBoolean("update_download_start_one_immediate", true).commit();
        v.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    }

    public static void bsy() {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().remove("update_downloading_in_silence").commit();
        v.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    }

    public static void bsz() {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().clear().commit();
        v.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    }

    public static long f(String str, long j, long j2) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_flowstat_prefs", 4);
        long j3 = sharedPreferences.getLong(str, 0);
        v.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", str, Long.valueOf(j), Long.valueOf(j2));
        v.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", str, Long.valueOf(j3));
        j3 += j + j2;
        sharedPreferences.edit().putLong(str, j3).commit();
        return j3;
    }

    public static long JN(String str) {
        v.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", str, Long.valueOf(MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_flowstat_prefs", 4).getLong(str, 0)));
        return MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_flowstat_prefs", 4).getLong(str, 0);
    }
}
