package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<Integer, Integer> lig;
    private static final Map<Integer, Integer> lih;
    private static final Map<Integer, Integer> lii;
    private static final Map<String, Integer> lij;

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(9));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(10));
        hashMap.put(Integer.valueOf(-7), Integer.valueOf(11));
        hashMap.put(Integer.valueOf(-8), Integer.valueOf(12));
        hashMap.put(Integer.valueOf(-9), Integer.valueOf(13));
        hashMap.put(Integer.valueOf(-10), Integer.valueOf(14));
        hashMap.put(Integer.valueOf(-11), Integer.valueOf(15));
        hashMap.put(Integer.valueOf(-12), Integer.valueOf(16));
        hashMap.put(Integer.valueOf(-13), Integer.valueOf(17));
        hashMap.put(Integer.valueOf(-14), Integer.valueOf(18));
        hashMap.put(Integer.valueOf(-15), Integer.valueOf(19));
        lig = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(4));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(9));
        lih = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Integer.valueOf(0));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(1));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(2));
        lii = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("imagePreview", Integer.valueOf(2));
        hashMap.put("profile", Integer.valueOf(3));
        hashMap.put("addContact", Integer.valueOf(4));
        hashMap.put(bk.NAME, Integer.valueOf(7));
        hashMap.put("scanQRCode", Integer.valueOf(8));
        hashMap.put("addEmoticon", Integer.valueOf(9));
        hashMap.put("hideOptionMenu", Integer.valueOf(10));
        hashMap.put("getBrandWCPayRequest", Integer.valueOf(11));
        hashMap.put("editAddress", Integer.valueOf(12));
        hashMap.put("getLatestAddress", Integer.valueOf(13));
        hashMap.put("jumpWCMall", Integer.valueOf(14));
        hashMap.put("geoLocation", Integer.valueOf(15));
        hashMap.put("openProductView", Integer.valueOf(16));
        hashMap.put("openProductViewWithPid", Integer.valueOf(16));
        hashMap.put(aq.NAME, Integer.valueOf(17));
        hashMap.put("hideMenuItems", Integer.valueOf(19));
        hashMap.put("connectToFreeWifi", Integer.valueOf(20));
        hashMap.put(JsApiStartRecordVoice.NAME, Integer.valueOf(21));
        hashMap.put(JsApiChooseImage.NAME, Integer.valueOf(22));
        hashMap.put("scanCover", Integer.valueOf(23));
        lij = Collections.unmodifiableMap(hashMap);
    }

    public static int sS(int i) {
        Integer num = (Integer) lig.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) lig.get(Integer.valueOf(-1));
        }
        return num.intValue();
    }

    public static int sT(int i) {
        Integer num = (Integer) lih.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) lih.get(Integer.valueOf(-1));
        }
        return num.intValue();
    }

    public static int sU(int i) {
        Integer num = (Integer) lii.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        return num.intValue();
    }

    public static int EP(String str) {
        Integer num = (Integer) lij.get(str);
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        return num.intValue();
    }

    public static int dx(long j) {
        if (j < 0) {
            return -1;
        }
        if (j <= 2000) {
            return 1;
        }
        if (j <= 6000) {
            return 2;
        }
        if (j <= 12000) {
            return 3;
        }
        if (j <= 60000) {
            return 4;
        }
        return 5;
    }
}
