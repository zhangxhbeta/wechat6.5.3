package com.tencent.mm.af;

import android.content.Context;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, a> cQj = null;
    private static String cQk = null;

    public static class a {
        public String cQl;
        public String cQm;
        public String cQn;
    }

    public static boolean GZ() {
        return be.bup() || !u.bsY().equals("zh_CN");
    }

    public static boolean Ha() {
        return be.He();
    }

    public static boolean Hb() {
        if (k.xE() == 0 && be.He()) {
            return false;
        }
        return true;
    }

    public static boolean Hc() {
        return be.He();
    }

    public static boolean Hd() {
        if (!u.bsY().equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() == TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        return true;
    }

    public static boolean He() {
        return be.He();
    }

    public static a g(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(cQk)) {
                cQj = null;
            }
        } catch (Exception e) {
        }
        if (cQj == null) {
            cQj = new HashMap();
            cQk = str3;
            InputStream inputStream = null;
            String str4 = SQLiteDatabase.KeyEmpty;
            try {
                inputStream = context.getAssets().open("country_code.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str3 = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2) {
                        v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", be.e(e2));
                    }
                }
            } catch (Throwable e3) {
                v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", be.e(e3));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str3 = str4;
                    } catch (Throwable e32) {
                        v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", be.e(e32));
                        str3 = str4;
                    }
                } else {
                    str3 = str4;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22) {
                        v.e("MicroMsg.InternationaPluginlLogic", "exception:%s", be.e(e22));
                    }
                }
            }
            String[] split = str3.trim().split("\n");
            String[] split2 = be.ma(str2).trim().split(",");
            for (String str42 : split) {
                String[] split3 = str42.trim().split(" ");
                if (split3.length < 2) {
                    v.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split[r0]);
                } else {
                    a aVar = new a();
                    aVar.cQl = split3[0];
                    aVar.cQm = split3[1];
                    for (String trim : split2) {
                        String[] split4 = trim.trim().split(":");
                        if (split4.length < 2) {
                            v.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", trim);
                        } else {
                            if (split3[1].equals(split4[0])) {
                                aVar.cQn = split4[1];
                                break;
                            }
                        }
                    }
                    cQj.put(aVar.cQl, aVar);
                }
            }
        }
        return (a) cQj.get(str.toUpperCase());
    }

    public static boolean jn(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            return false;
        }
        return true;
    }

    public static String jo(String str) {
        if (str.startsWith("+886") || str.startsWith("+86")) {
            return "zh-TW";
        }
        if (str.startsWith("+852") || str.startsWith("+853")) {
            return "zh-HK";
        }
        if (str.startsWith("+81")) {
            return "ja";
        }
        if (str.startsWith("+82")) {
            return "ko";
        }
        if (str.startsWith("+66")) {
            return "th";
        }
        if (str.startsWith("+84")) {
            return "vi";
        }
        if (str.startsWith("+62")) {
            return "id";
        }
        if (str.startsWith("+55")) {
            return "pt";
        }
        if (str.startsWith("+34")) {
            return "es-419";
        }
        return "en";
    }
}
