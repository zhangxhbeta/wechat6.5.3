package com.tencent.mm.plugin.shake.e;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a {
    public LinkedList<a> cZq = new LinkedList();

    public static class a {
        public String gmB;
        public String iTk;
        public List<String> iTl = new ArrayList();
        public String iTm = "";
        public String iTn = "";
        public String title;
        public int type;

        public a(int i) {
            this.type = i;
        }
    }

    public static LinkedList<a> i(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        int i = 0;
        Object obj = null;
        while (i < BaseReportManager.MAX_READ_COUNT) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < BaseReportManager.MAX_READ_COUNT) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!be.kS((String) map.get(str3 + ".type"))) {
                    try {
                        int intValue = Integer.valueOf((String) map.get(str3 + ".type")).intValue();
                        obj2 = null;
                        if (intValue == 2) {
                            a aVar2 = new a(intValue);
                            aVar2.iTk = be.ma((String) map.get(str3 + ".comment.id"));
                            aVar2.title = be.ma((String) map.get(str3 + ".comment.title"));
                            obj2 = aVar2;
                        } else if (intValue == 3) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 4) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 5) {
                            obj2 = a(map, intValue, str3);
                        } else if (intValue == 6) {
                            obj2 = a(map, intValue, str3);
                        }
                        if (obj2 != null) {
                            linkedList2.add(obj2);
                        }
                        i2++;
                        obj = null;
                    } catch (Exception e) {
                        new StringBuilder("Exception in parseActionList: ").append(e.getMessage());
                        if (obj != null) {
                            return linkedList;
                        }
                        aVar.cZq = linkedList2;
                        int i3 = 1;
                    }
                } else if (obj != null) {
                    return linkedList;
                } else {
                    aVar.cZq = linkedList2;
                    obj2 = 1;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        return linkedList;
    }

    private static a a(Map<String, String> map, int i, String str) {
        a aVar = new a(i);
        aVar.title = be.ma((String) map.get(str + ".title"));
        aVar.gmB = be.ma((String) map.get(str + ".summary"));
        String str2 = str + ".thumburl";
        int i2 = 0;
        while (i2 < 100) {
            String str3 = (String) map.get(str2 + (i2 > 0 ? Integer.valueOf(i2) : ""));
            if (be.kS(str3)) {
                break;
            }
            aVar.iTl.add(str3);
            i2++;
        }
        switch (i) {
            case 3:
                aVar.iTk = be.ma((String) map.get(str + ".h5url.link"));
                aVar.iTm = be.ma((String) map.get(str + ".h5url.title"));
                aVar.iTn = be.ma((String) map.get(str + ".h5url.username"));
                break;
            case 4:
                aVar.iTk = be.ma((String) map.get(str + ".bizprofile.username"));
                aVar.iTm = be.ma((String) map.get(str + ".bizprofile.showchat"));
                break;
            case 5:
                aVar.iTk = be.ma((String) map.get(str + ".nativepay.wx_pay_url"));
                break;
            case 6:
                aVar.iTk = be.ma((String) map.get(str + ".product.product_id"));
                break;
        }
        return aVar;
    }
}
