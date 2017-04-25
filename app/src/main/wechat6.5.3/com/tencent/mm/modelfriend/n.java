package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;

public final class n {
    public static boolean Fg() {
        ak.yW();
        if (TextUtils.isEmpty((String) c.vf().get(208903, null))) {
            return false;
        }
        return true;
    }

    public static String F(List<NameValuePair> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            NameValuePair nameValuePair = (NameValuePair) list.get(i);
            if (!TextUtils.isEmpty(nameValuePair.getName())) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(URLEncoder.encode(nameValuePair.getName(), "UTF-8"));
                stringBuilder.append("=");
                if (!TextUtils.isEmpty(nameValuePair.getValue())) {
                    stringBuilder.append(URLEncoder.encode(nameValuePair.getValue(), "UTF-8"));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static boolean aP(Context context) {
        Intent intent = new Intent("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        if (context.getPackageManager().resolveActivity(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 0) == null || context.getPackageManager().resolveActivity(intent, 0) == null || VERSION.SDK_INT < 8 || context.getSharedPreferences(aa.bti(), 0).getBoolean("googleauth", false)) {
            return false;
        }
        return true;
    }
}
