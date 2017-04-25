package com.tencent.mm.az;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private static final Map<Integer, Integer> lVT = new HashMap();

    public static void run() {
        ak.yW();
        if ((be.ax(be.a((Long) c.vf().get(66819, null), 0)) * 1000 > 1800000 ? 1 : null) != null) {
            Io(SQLiteDatabase.KeyEmpty);
        }
    }

    public static void uy(int i) {
        lVT.put(Integer.valueOf(i), Integer.valueOf(be.f((Integer) lVT.get(Integer.valueOf(i))) + 1));
    }

    public static String bri() {
        String str = "[a=" + (ak.yW() == null ? "0" : "1") + " ";
        if (ak.yW() == null) {
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        ak.yW();
        return append.append(c.vf() == null ? "0" : "1").append(" ").toString() + "u=" + (ak.uz() ? "1" : "0") + "]";
    }

    public static void Io(String str) {
        String str2 = str + bri();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : lVT.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || ((Integer) entry.getValue()).intValue() == 0)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
                stringBuilder.append(',');
            }
        }
        lVT.clear();
        if (stringBuilder.length() > 0) {
            v.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            bl.p(10, stringBuilder.toString());
        }
        v.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + (str2 + bri()));
        try {
            ak.yW();
            c.vf().set(66819, Long.valueOf(be.Nh()));
        } catch (Exception e) {
            v.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
        }
    }
}
