package com.tencent.mm.plugin.label;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class c {
    public static String bW(String str, String str2) {
        v.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[]{str, str2});
        if (be.kS(str2)) {
            return str;
        }
        if (be.kS(str)) {
            return str2 + "\u0000";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        if (be.g(str.split(",")).contains(str2)) {
            return str + "\u0000";
        }
        return str + "," + str2 + "\u0000";
    }

    public static String bX(String str, String str2) {
        v.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[]{str, str2});
        if (be.kS(str2)) {
            return str;
        }
        if (be.kS(str)) {
            return "";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        List g = be.g(str.split(","));
        if (!g.contains(str2)) {
            return str;
        }
        g.remove(str2);
        return aE(g);
    }

    public static String aE(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) list.get(i));
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\u0000");
        }
        return stringBuilder.toString();
    }
}
