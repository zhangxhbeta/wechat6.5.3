package com.tencent.mm.plugin.wallet_core.c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.a.g;
import com.tencent.mm.al.t;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static final String eDd = (e.cnj + "wallet");
    private static Map<String, String> kRG = null;

    private static boolean Dk(String str) {
        try {
            kRG = new HashMap();
            v.d("MicroMsg.WalletBankLogoStorage", "bank logo:" + str);
            Editor edit = aa.getContext().getSharedPreferences("bank_logo", 0).edit();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("bank_urls_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (k.xT()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                String jSONObject2 = jSONObject.toString();
                if (be.kS(optString) || be.kS(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                kRG.put(optString, jSONObject2);
            }
            edit.commit();
            v.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean ac(LinkedList<String> linkedList) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            kRG = new HashMap();
            Editor edit = aa.getContext().getSharedPreferences("bank_logo", 0).edit();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String optString;
                JSONObject jSONObject = new JSONObject((String) linkedList.get(i));
                if (k.xT()) {
                    optString = jSONObject.optString("bank_desc");
                } else {
                    optString = jSONObject.optString("bank_type");
                }
                jSONObject.put("timestamp", currentTimeMillis);
                String jSONObject2 = jSONObject.toString();
                if (be.kS(optString) || be.kS(jSONObject2)) {
                    break;
                }
                edit.putString(optString, jSONObject2);
                kRG.put(optString, jSONObject2);
            }
            edit.commit();
            v.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
            return false;
        }
    }

    public static d f(Context context, String str, boolean z) {
        if (!z) {
            return aC(context, str);
        }
        if (!"CITIC_CREDIT".equals(str)) {
            return null;
        }
        d dVar = new d();
        dVar.kNI = 2130839507;
        dVar.kNJ = 2130839509;
        d aC = aC(context, str);
        if (aC == null) {
            return dVar;
        }
        dVar.hGg = aC.hGg;
        return dVar;
    }

    private static d aC(Context context, String str) {
        String string;
        String str2;
        boolean z;
        d dVar;
        boolean z2 = true;
        if (kRG == null) {
            string = aa.getContext().getSharedPreferences("bank_logo", 0).getString(str, "");
        } else {
            string = (String) kRG.get(str);
        }
        if (be.kS(string)) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                t.HS().fT(11);
                ak.vy().a(new com.tencent.mm.al.k(11), 0);
            }
            Dk(aD(context, "config/bank_logo.xml"));
            if (kRG != null) {
                str2 = (String) kRG.get(str);
                z = true;
            } else {
                str2 = string;
                z = true;
            }
        } else {
            str2 = string;
            z = false;
        }
        if (be.kS(str2)) {
            dVar = null;
        } else {
            d dVar2 = new d();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long j = jSONObject.getLong("timestamp");
                dVar2.hGg = jSONObject.getString("logo2x_url");
                dVar2.kNF = jSONObject.getString("bg2x_url");
                dVar2.kNG = jSONObject.getString("wl2x_url");
                if (!z && (System.currentTimeMillis() / 1000) - j <= 7200) {
                    z2 = false;
                }
                dVar2.kNK = z2;
                dVar2.timestamp = j;
                dVar = dVar2;
            } catch (Throwable e) {
                v.a("MicroMsg.WalletBankLogoStorage", e, "", new Object[0]);
                return null;
            }
        }
        return dVar;
    }

    private static String aD(Context context, String str) {
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    v.a("MicroMsg.WalletBankLogoStorage", e, "close", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.WalletBankLogoStorage", e2, "getFromAssets", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    v.a("MicroMsg.WalletBankLogoStorage", e22, "close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    v.a("MicroMsg.WalletBankLogoStorage", e222, "close", new Object[0]);
                }
            }
        }
        return str2;
    }

    public static String bgQ() {
        return eDd;
    }

    public static String xK(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{eDd, g.m(str.getBytes())});
    }
}
