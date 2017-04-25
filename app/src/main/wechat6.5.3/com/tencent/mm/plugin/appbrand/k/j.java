package com.tencent.mm.plugin.appbrand.k;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.Map;

public final class j {
    public static String ov(String str) {
        String path = Uri.parse("file:///" + str).getPath();
        if (path != null && path.startsWith("/")) {
            return path.substring(1);
        }
        if (path == null) {
            return "";
        }
        return path;
    }

    public static Map<String, String> ow(String str) {
        Map<String, String> hashMap = new HashMap();
        String encodedQuery = Uri.parse("file:///" + str).getEncodedQuery();
        if (be.kS(encodedQuery)) {
            return hashMap;
        }
        int i = 0;
        int length = encodedQuery.length();
        while (true) {
            Object obj;
            int indexOf = encodedQuery.indexOf(38, i);
            int i2 = indexOf != -1 ? indexOf : length;
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > i2 || indexOf2 == -1) {
                indexOf2 = i2;
            }
            String decode = Uri.decode(encodedQuery.substring(i, indexOf2));
            if (indexOf2 == i2) {
                obj = "";
            } else {
                obj = encodedQuery.substring(indexOf2 + 1, i2);
            }
            hashMap.put(decode, obj);
            if (indexOf == -1) {
                return hashMap;
            }
            i = indexOf + 1;
        }
    }
}
