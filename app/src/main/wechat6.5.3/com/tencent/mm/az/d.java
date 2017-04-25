package com.tencent.mm.az;

import com.tencent.mm.ak.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {

    public static class a {
        public int cUl = 0;
        public int hitCount = 0;

        public static String T(Map<String, a> map) {
            StringBuilder stringBuilder = new StringBuilder();
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        stringBuilder.append("<voiptenmin>");
                        for (Entry entry : map.entrySet()) {
                            Object key = entry.getKey();
                            a aVar = (a) entry.getValue();
                            stringBuilder.append("<" + key);
                            stringBuilder.append(" hitcount = \"");
                            stringBuilder.append(aVar.hitCount);
                            stringBuilder.append("\"");
                            stringBuilder.append(" sendcount = \"");
                            stringBuilder.append(aVar.cUl);
                            stringBuilder.append("\"");
                            stringBuilder.append("/>");
                        }
                        stringBuilder.append("</voiptenmin>");
                    }
                } catch (Throwable e) {
                    v.e("PostTaskTenMinutesLogicState", "exception:%s", be.e(e));
                    return null;
                }
            }
            v.d("PostTaskTenMinutesLogicState", "mapToXml " + stringBuilder.toString());
            return stringBuilder.toString();
        }

        public static Map<String, a> Iq(String str) {
            Throwable th;
            Map<String, a> map = null;
            v.d("PostTaskTenMinutesLogicState", "xml " + str);
            if (str == null) {
                return null;
            }
            try {
                Map q = bf.q(str, "voiptenmin");
                if (q == null || q.size() <= 0) {
                    return null;
                }
                Map<String, a> hashMap = new HashMap();
                try {
                    for (Entry entry : q.entrySet()) {
                        String str2 = (String) entry.getKey();
                        if (str2 == null) {
                            break;
                        }
                        String[] split = str2.split("\\.");
                        v.d("PostTaskTenMinutesLogicState", "key is " + str2);
                        v.d("PostTaskTenMinutesLogicState", "array is " + split.length);
                        if (str2 != null && split.length >= 4) {
                            a aVar;
                            v.d("PostTaskTenMinutesLogicState", "getValue is " + ((String) entry.getValue()) + "array[1] " + split[2]);
                            if (hashMap.containsKey(split[2])) {
                                aVar = (a) hashMap.get(split[2]);
                            } else {
                                aVar = new a();
                            }
                            if (str2.contains("hitcount")) {
                                aVar.hitCount = be.getInt((String) entry.getValue(), 0);
                            } else if (str2.contains("sendcount")) {
                                aVar.cUl = be.getInt((String) entry.getValue(), 0);
                            }
                            v.d("PostTaskTenMinutesLogicState", "hitCount " + aVar.hitCount + "sendCount " + aVar.cUl);
                            hashMap.put(split[2], aVar);
                        }
                    }
                    return hashMap;
                } catch (Throwable e) {
                    th = e;
                    map = hashMap;
                }
            } catch (Exception e2) {
                th = e2;
                v.e("PostTaskTenMinutesLogicState", "exception:%s", be.e(th));
                return map;
            }
        }
    }

    public static void bro() {
        Object obj = (!ak.uz() || ak.uG()) ? null : 1;
        if (obj != null && qh()) {
            ak.yW();
            String str = (String) c.vf().get(77829, null);
            if (str != null) {
                Map Iq = a.Iq(str);
                if (Iq != null && Iq.size() > 0) {
                    List linkedList = new LinkedList();
                    for (Entry entry : Iq.entrySet()) {
                        a aVar = (a) entry.getValue();
                        if (aVar != null) {
                            int i = aVar.hitCount;
                            int i2 = aVar.cUl;
                            if (i > 0 || i2 > 0) {
                                linkedList.add(new com.tencent.mm.ak.i.a(10166, ((String) entry.getKey()) + "," + i + "," + i2));
                            }
                            v.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState  name " + ((String) entry.getKey()) + " " + i + "  " + i2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        ak.yW();
                        c.wG().b(new i(linkedList));
                        ak.yW();
                        c.vf().set(77829, null);
                    }
                }
            }
        }
        ak.yW();
        c.vf().set(77828, Long.valueOf(be.Nh()));
        v.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
    }

    public static boolean qh() {
        ak.yW();
        return be.ax(be.a((Long) c.vf().get(77828, null), 0)) * 1000 > 1800000;
    }
}
