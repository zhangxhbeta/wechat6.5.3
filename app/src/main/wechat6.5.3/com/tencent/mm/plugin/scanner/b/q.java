package com.tencent.mm.plugin.scanner.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mm.h.j;
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q {
    public static String iEh = "title";
    public static String iEi = "tip";
    public static String iEj = "buttonTitle";

    public static class a {
        public String bom;
        public String eBK;
        public int eBL;
    }

    public static int zb(String str) {
        if (str == null) {
            return 0;
        }
        if ("EAN-13".equals(str) || "EAN_13".equals(str)) {
            return 4;
        }
        if ("EAN-8".equals(str) || "EAN_8".equals(str)) {
            return 3;
        }
        if ("EAN-2".equals(str)) {
            return 1;
        }
        if ("EAN-5".equals(str)) {
            return 2;
        }
        if ("UPC-A".equals(str) || "UPC_A".equals(str)) {
            return 5;
        }
        if ("UPC-E".equals(str) || "UPC_E".equals(str)) {
            return 6;
        }
        if ("CODE-39".equals(str) || "CODE_39".equals(str)) {
            return 9;
        }
        if ("CODE-93".equals(str) || "CODE_93".equals(str)) {
            return 10;
        }
        if ("CODE-128".equals(str) || "CODE_128".equals(str)) {
            return 11;
        }
        if ("COMPOSITE".equals(str)) {
            return 12;
        }
        if ("I/25".equals(str) || "ITF".equals(str)) {
            return 13;
        }
        if ("DATABAR".equals(str)) {
            return 7;
        }
        if ("DATABAR-EXP".equals(str)) {
            return 8;
        }
        if ("RSS_14".equals(str)) {
            return 15;
        }
        if ("RSS_EXPANDED".equals(str)) {
            return 16;
        }
        if ("MAXICODE".equals(str)) {
            return 18;
        }
        if ("PDF_417".equals(str)) {
            return 20;
        }
        if ("QR_CODE".equals(str)) {
            return 19;
        }
        if ("CODABAR".equals(str)) {
            return 17;
        }
        if ("ISBN10".equals(str)) {
            return 14;
        }
        if ("DATA_MATRIX".equals(str)) {
            return 21;
        }
        return 0;
    }

    public static float cm(int i, int i2) {
        if (i2 >= i * 3) {
            return 0.5f;
        }
        return 1.0f;
    }

    public static boolean iT(int i) {
        d dVar = com.tencent.mm.pluginsdk.j.a.lxM;
        if (dVar != null) {
            return dVar.iT(i);
        }
        return false;
    }

    public static a zc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.eBK = jSONObject.optString("card_tp_id");
            aVar.eBL = jSONObject.optInt("card_type");
            aVar.bom = jSONObject.optString("card_ext");
            return aVar;
        } catch (Throwable e) {
            v.a("MicroMsg.ScannerUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static ArrayList<a> zd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                v.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
                return null;
            }
            ArrayList<a> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.eBK = optJSONObject.optString("card_tp_id");
                aVar.eBL = optJSONObject.optInt("card_type");
                aVar.bom = optJSONObject.optString("card_ext");
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.ScannerUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static boolean M(ArrayList<a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            v.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            a aVar = (a) arrayList.get(i);
            if (aVar != null && iT(aVar.eBL)) {
                return true;
            }
        }
        return false;
    }

    public static void an(Context context, String str) {
        g.a(context, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public static String cu(String str, String str2) {
        String value = j.sU().getValue("ScanBookWording");
        v.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + be.ma(value));
        if (be.kS(value)) {
            return str2;
        }
        String[] split = value.split("&");
        if (split == null) {
            return str2;
        }
        Map hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            if (split3.length == 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        value = (String) hashMap.get(str);
        if (be.kS(value)) {
            return str2;
        }
        return value;
    }
}
