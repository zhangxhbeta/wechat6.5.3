package com.tencent.mm.pluginsdk.h;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;

public final class a {
    public static Bundle Gm(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_scene", 1);
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            v.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
            return bundle;
        }
        HashMap hashMap = new HashMap();
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                String[] split2 = obj.split("=");
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        bundle.putString("_wxapi_payreq_appid", c("appid", hashMap));
        bundle.putString("_wxapi_payreq_partnerid", c("partnerid", hashMap));
        bundle.putString("_wxapi_payreq_prepayid", c("prepayid", hashMap));
        bundle.putString("_wxapi_payreq_noncestr", c("noncestr", hashMap));
        bundle.putString("_wxapi_payreq_timestamp", c("timestamp", hashMap));
        bundle.putString("_wxapi_payreq_packagevalue", c("package", hashMap));
        bundle.putString("_wxapi_payreq_sign", c("sign", hashMap));
        bundle.putString("_wxapi_payreq_sign_type", c("signtype", hashMap));
        bundle.putString("_wxapi_payreq_extdata", c("extdata", hashMap));
        bundle.putString("_wxapi_payoptions_callback_classname", SQLiteDatabase.KeyEmpty);
        bundle.putInt("_wxapi_payoptions_callback_flags", -1);
        return bundle;
    }

    private static String c(String str, HashMap<String, String> hashMap) {
        String str2 = (String) hashMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        v.e("MicroMsg.MallManager", "getWapPayKey key: " + str + " value is empty");
        return SQLiteDatabase.KeyEmpty;
    }
}
