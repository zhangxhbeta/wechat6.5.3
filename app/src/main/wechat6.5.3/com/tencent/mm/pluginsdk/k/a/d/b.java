package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.mm.sdk.platformtools.be;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public enum b {
    ;

    public static String ac(Map<String, List<String>> map) {
        if (map == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(be.ah((String) entry.getKey(), "null"));
            stringBuilder.append(" : ");
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String ma : list) {
                    stringBuilder.append(be.ma(ma)).append("|");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
