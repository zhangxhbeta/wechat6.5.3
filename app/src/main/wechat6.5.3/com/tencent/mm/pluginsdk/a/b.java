package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class b {
    private static HashMap<String, a> lyo = new HashMap();
    private static final Pattern lyp = Pattern.compile(" +");

    public static void a(a aVar, String... strArr) {
        synchronized (lyo) {
            for (Object put : strArr) {
                lyo.put(put, aVar);
                v.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", put);
            }
        }
    }

    public static void A(String... strArr) {
        synchronized (lyo) {
            for (int i = 0; i < 4; i++) {
                lyo.remove(strArr[i]);
                v.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", r2);
            }
        }
    }

    public static boolean aK(Context context, String str) {
        String[] split = lyp.split(str);
        synchronized (lyo) {
            a aVar = (a) lyo.get(split[0]);
        }
        if (aVar == null) {
            return false;
        }
        v.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", split[0]);
        return aVar.a(context, split);
    }
}
