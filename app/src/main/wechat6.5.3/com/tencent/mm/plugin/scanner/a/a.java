package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public LinkedList<a> cZq = new LinkedList();
    public String iconUrl;
    public int ivD;
    public int ivE;
    public int ivF;
    public String ivG;
    public boolean ivH;
    public String title;
    public int type = 1;

    public static class a {
        public int aXx;
        public String apU;
        public String cID = "";
        public String cZp = "";
        public String content;
        public String cqK = "";
        public String desc = "";
        public String iconUrl = "";
        public String ivG;
        public String ivI = "";
        public String ivJ = "";
        public String ivK = "";
        public String ivL = "";
        public String ivM = "";
        public String ivN = "";
        public String ivO = "";
        public String ivP = "";
        public String ivQ = "";
        public String ivR;
        public String ivS;
        public String name = "";
        public String thumburl = "";
        public int type;
        public String username = "";

        public a(int i) {
            this.type = i;
        }
    }

    public static LinkedList<a> i(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        Object obj = null;
        int i = 0;
        while (i < BaseReportManager.MAX_READ_COUNT) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            if (!be.kS((String) map.get(str2 + ".$type"))) {
                aVar.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            aVar.title = be.ma((String) map.get(str2 + ".$title"));
            aVar.iconUrl = be.ma((String) map.get(str2 + ".$iconurl"));
            aVar.ivD = be.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            aVar.ivE = be.getInt((String) map.get(str2 + ".$iconheight"), 34);
            aVar.ivG = be.ma((String) map.get(str2 + ".$referkey"));
            aVar.ivF = be.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            boolean z = false;
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < BaseReportManager.MAX_READ_COUNT) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!be.kS((String) map.get(str3 + ".$type"))) {
                    boolean z2;
                    obj = null;
                    a j = j(map, str3);
                    if (j != null) {
                        linkedList2.add(j);
                        if (!k.a(j)) {
                            z2 = true;
                            i2++;
                            z = z2;
                        }
                    }
                    z2 = z;
                    i2++;
                    z = z2;
                } else if (obj != null) {
                    return linkedList;
                } else {
                    obj2 = 1;
                    aVar.cZq = linkedList2;
                    aVar.ivH = z;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            aVar.ivH = z;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        return linkedList;
    }

    public static a j(Map<String, String> map, String str) {
        int i = be.getInt((String) map.get(str + ".$type"), 0);
        a aVar = new a(i);
        aVar.type = i;
        aVar.ivN = be.ma((String) map.get(str + ".statid"));
        aVar.name = be.ma((String) map.get(str + ".name"));
        aVar.desc = be.ma((String) map.get(str + ".desc"));
        aVar.cqK = be.ma((String) map.get(str + ".digest"));
        aVar.aXx = be.getInt((String) map.get(str + ".showtype"), 0);
        aVar.ivI = be.ma((String) map.get(str + ".image"));
        aVar.apU = be.ma((String) map.get(str + ".$key"));
        aVar.iconUrl = be.ma((String) map.get(str + ".iconurl"));
        if (i == 1) {
            aVar.cZp = be.ma((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 2) {
            aVar.username = be.ma((String) map.get(str + ".username"));
            aVar.cID = be.ma((String) map.get(str + ".nickname"));
            aVar.ivR = be.ma((String) map.get(str + ".strbeforefollow"));
            aVar.ivS = be.ma((String) map.get(str + ".strafterfollow"));
            return aVar;
        } else if (i == 3) {
            aVar.thumburl = be.ma((String) map.get(str + ".thumburl"));
            aVar.cZp = be.ma((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 4) {
            aVar.thumburl = be.ma((String) map.get(str + ".thumburl"));
            aVar.username = be.ma((String) map.get(str + ".username"));
            aVar.cID = be.ma((String) map.get(str + ".nickname"));
            return aVar;
        } else {
            if (i == 5) {
                aVar.ivK = be.ma((String) map.get(str + ".wifiurl"));
                aVar.ivL = be.ma((String) map.get(str + ".wapurl"));
                aVar.ivM = be.ma((String) map.get(str + ".weburl"));
                if (be.kS(aVar.ivK) && be.kS(aVar.ivL) && be.kS(aVar.ivM)) {
                    return null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    aVar.thumburl = be.ma((String) map.get(str + ".thumburl"));
                    aVar.ivJ = be.ma((String) map.get(str + ".playurl"));
                    return aVar;
                } else if (i == 9) {
                    aVar.ivO = be.ma((String) map.get(str + ".productid"));
                    return aVar;
                } else if (i == 8) {
                    aVar.ivP = be.ma((String) map.get(str + ".cardext"));
                    aVar.ivQ = be.ma((String) map.get(str + ".cardid"));
                    return aVar;
                } else if (i == 10) {
                    aVar.ivO = be.ma((String) map.get(str + ".id"));
                    return aVar;
                } else if (i == 12) {
                    aVar.thumburl = be.ma((String) map.get(str + ".image"));
                    aVar.cZp = be.ma((String) map.get(str + ".link"));
                    return aVar;
                } else if (i == 22) {
                    aVar.content = be.ma((String) map.get(str + ".content"));
                    aVar.cZp = be.ma((String) map.get(str + ".link"));
                    aVar.cID = be.ma((String) map.get(str + ".nickname"));
                    aVar.thumburl = be.ma((String) map.get(str + ".image"));
                    return aVar;
                } else if (i == 21) {
                    aVar.ivG = be.ma((String) map.get(str + ".referkey"));
                    return aVar;
                } else {
                    aVar.cZp = be.ma((String) map.get(str + ".link"));
                }
            }
            return aVar;
        }
    }
}
