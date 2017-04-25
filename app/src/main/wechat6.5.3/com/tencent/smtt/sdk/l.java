package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

final class l {
    public boolean pwr;
    public boolean pws;
    private Map<String, String> pwt;

    public l() {
        this.pwr = false;
        this.pws = false;
        this.pwt = null;
        this.pwt = new HashMap();
    }

    public final synchronized void a(String str, byte b) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = SQLiteDatabase.KeyEmpty;
            if (b == (byte) 1) {
                str2 = "_begin";
            } else if (b == (byte) 2) {
                str2 = "_end";
            }
            this.pwt.put(str + str2, String.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized void az(int i, String str) {
        y bNJ = y.bNJ();
        if (bNJ.bNK()) {
            this.pwt.put("is_first_init_tbs", String.valueOf(this.pws));
            this.pwt.put("is_first_init_x5", String.valueOf(this.pwr));
            this.pwt.put("x5_webview_id", Integer.toString(i));
            this.pwt.put("current_url", str);
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.pwt);
            Map map = this.pwt;
            String[] strArr = new String[]{"init_all", "tbslog_init", "mtt_trace", "x5_core_engine_init_sync", "tbs_rename_task", "can_load_x5", "read_core_info", "load_tbs_dex", "init_tbs", "init_x5_core", "init_x5_webview", "load_url_gap", "load_url"};
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder.append("----------------------------start------------------------------");
            stringBuilder.append("\n");
            stringBuilder.append("is_first_init_x5");
            stringBuilder.append(": ");
            stringBuilder.append((String) map.get("is_first_init_x5"));
            stringBuilder.append("\n");
            stringBuilder.append("is_first_init_tbs");
            stringBuilder.append(": ");
            stringBuilder.append((String) map.get("is_first_init_tbs"));
            stringBuilder.append("\n");
            stringBuilder.append("current_url");
            stringBuilder.append(": ");
            stringBuilder.append((String) map.get("current_url"));
            stringBuilder.append("\n");
            stringBuilder.append("tbs_core_version");
            stringBuilder.append(": ");
            stringBuilder.append(QbSdk.bMF());
            stringBuilder.append("\n");
            for (int i2 = 0; i2 < 13; i2++) {
                String str2 = strArr[i2];
                String str3 = str2 + "_end";
                String str4 = str2 + "_begin";
                String str5 = (String) map.get(str3);
                String str6 = (String) map.get(str4);
                if (!(str5 == null || str6 == null || str5.isEmpty() || str6.isEmpty())) {
                    long parseLong = Long.parseLong(str5) - Long.parseLong(str6);
                    stringBuilder.append(str2 + " duration:\t");
                    stringBuilder.append(parseLong);
                    stringBuilder.append("\n");
                    stringBuilder2.append("(" + i2 + ") ");
                    stringBuilder2.append(str4);
                    stringBuilder2.append(" :\t" + ((String) map.get(str4)));
                    stringBuilder2.append(";");
                    stringBuilder2.append("\n");
                    stringBuilder2.append("(" + i2 + ") ");
                    stringBuilder2.append(str3);
                    stringBuilder2.append(" :\t" + ((String) map.get(str3)));
                    stringBuilder2.append(";");
                    stringBuilder2.append("\n");
                }
            }
            stringBuilder.append("\n");
            stringBuilder.append("-------------------------------------------------------------");
            stringBuilder.append("\n");
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("----------------------------end------------------------------");
            stringBuilder.append("\n");
            new StringBuilder().append(stringBuilder.toString());
        }
    }
}
