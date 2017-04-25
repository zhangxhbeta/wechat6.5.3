package com.tencent.mm.plugin.sns.e;

import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.Map;

public final class al {
    private static final Map<String, String> jnj = new HashMap();

    public static String cA(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        String str3;
        boolean equals = Looper.getMainLooper().equals(Looper.myLooper());
        if (equals && jnj.containsKey(str + str2)) {
            str3 = (String) jnj.get(str + str2);
            if (!be.kS(str3)) {
                return str3;
            }
        }
        str3 = g.m(str2.getBytes());
        StringBuffer stringBuffer = new StringBuffer(str);
        if (str3.length() > 0) {
            stringBuffer.append(str3.charAt(0));
            stringBuffer.append("/");
        }
        if (str3.length() >= 2) {
            stringBuffer.append(str3.charAt(1));
            stringBuffer.append("/");
        }
        if (equals) {
            jnj.put(str + str2, stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized void release() {
        synchronized (al.class) {
            jnj.clear();
        }
    }
}
