package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.sdk.platformtools.be;
import java.util.Map;

public final class c {
    public static String n(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static boolean b(Map<String, Object> map, String str, boolean z) {
        String n = n(map, str);
        if (!be.kS(n)) {
            try {
                z = Boolean.valueOf(n).booleanValue();
            } catch (Exception e) {
            }
        }
        return z;
    }

    public static int c(Map<String, Object> map, String str, int i) {
        String n = n(map, str);
        if (!be.kS(n)) {
            try {
                i = Integer.valueOf(n).intValue();
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject a(com.tencent.mm.modelsearch.p.h r17, java.lang.String r18, java.util.List<java.lang.String> r19) {
        /*
        com.tencent.mm.model.ak.yW();
        r3 = com.tencent.mm.model.c.wH();
        r0 = r17;
        r4 = r0.cWv;
        r12 = r3.LX(r4);
        r11 = 0;
        r9 = 0;
        r10 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r8 = 0;
        r0 = r17;
        r6 = r0.cWv;
        r7 = com.tencent.mm.model.l.er(r6);
        r0 = r17;
        r6 = r0.cWt;
        switch(r6) {
            case 1: goto L_0x009d;
            case 2: goto L_0x009c;
            case 3: goto L_0x009b;
            case 4: goto L_0x00c0;
            case 5: goto L_0x00a7;
            case 6: goto L_0x00a6;
            case 7: goto L_0x00a5;
            case 8: goto L_0x0025;
            case 9: goto L_0x0025;
            case 10: goto L_0x0025;
            case 11: goto L_0x0166;
            case 12: goto L_0x0025;
            case 13: goto L_0x0025;
            case 14: goto L_0x0025;
            case 15: goto L_0x00d9;
            case 16: goto L_0x00f9;
            case 17: goto L_0x014b;
            case 18: goto L_0x0130;
            default: goto L_0x0025;
        };
    L_0x0025:
        r6 = r3;
        r3 = r9;
        r9 = r5;
        r5 = r8;
        r8 = r4;
    L_0x002a:
        if (r10 == 0) goto L_0x0037;
    L_0x002c:
        if (r8 == 0) goto L_0x017d;
    L_0x002e:
        r0 = r19;
        r1 = r18;
        r4 = com.tencent.mm.modelsearch.h.a(r7, r0, r6, r1);
        r7 = r4;
    L_0x0037:
        if (r9 == 0) goto L_0x0071;
    L_0x0039:
        if (r5 == 0) goto L_0x0230;
    L_0x003b:
        r0 = r17;
        r3 = r0.userData;
        r3 = (java.util.List) r3;
        r4 = r12.field_contactLabelIds;
        r5 = "\u0000";
        r5 = r4.endsWith(r5);
        if (r5 == 0) goto L_0x0057;
    L_0x004c:
        r5 = 0;
        r6 = r4.length();
        r6 = r6 + -1;
        r4 = r4.substring(r5, r6);
    L_0x0057:
        r5 = r4.length();
        if (r5 != 0) goto L_0x018a;
    L_0x005d:
        r3 = "";
    L_0x0060:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r11);
        r3 = r4.append(r3);
        r3 = r3.toString();
    L_0x0071:
        r4 = new org.json.JSONObject;
        r4.<init>();
        r5 = "nickName";
        r6 = com.tencent.mm.model.l.c(r12);	 Catch:{ JSONException -> 0x0258 }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x0258 }
        r5 = "userName";
        r0 = r17;
        r6 = r0.cWv;	 Catch:{ JSONException -> 0x0258 }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x0258 }
        if (r10 == 0) goto L_0x0092;
    L_0x008c:
        r5 = "nickNameHighlight";
        r4.put(r5, r7);	 Catch:{ JSONException -> 0x0258 }
    L_0x0092:
        if (r9 == 0) goto L_0x009a;
    L_0x0094:
        r5 = "extraHighlight";
        r4.put(r5, r3);	 Catch:{ JSONException -> 0x0258 }
    L_0x009a:
        return r4;
    L_0x009b:
        r3 = 1;
    L_0x009c:
        r4 = 1;
    L_0x009d:
        r6 = 1;
        r10 = r6;
        r6 = r3;
        r3 = r9;
        r9 = r5;
        r5 = r8;
        r8 = r4;
        goto L_0x002a;
    L_0x00a5:
        r3 = 1;
    L_0x00a6:
        r4 = 1;
    L_0x00a7:
        r5 = 1;
        r6 = r12.field_nickname;
        r9 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234837; // 0x7f081015 float:1.808585E38 double:1.052969916E-314;
        r9 = r9.getString(r11);
        r11 = r9;
        r9 = r5;
        r5 = r8;
        r8 = r4;
        r16 = r6;
        r6 = r3;
        r3 = r16;
        goto L_0x002a;
    L_0x00c0:
        r5 = 1;
        r6 = r12.bCt;
        r9 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234832; // 0x7f081010 float:1.808584E38 double:1.0529699137E-314;
        r9 = r9.getString(r11);
        r11 = r9;
        r9 = r5;
        r5 = r8;
        r8 = r4;
        r16 = r6;
        r6 = r3;
        r3 = r16;
        goto L_0x002a;
    L_0x00d9:
        r6 = 1;
        r5 = r12.pD();
        r9 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r9 == 0) goto L_0x00e6;
    L_0x00e4:
        r5 = r12.field_username;
    L_0x00e6:
        r9 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234841; // 0x7f081019 float:1.808586E38 double:1.052969918E-314;
        r9 = r9.getString(r11);
        r11 = r9;
        r9 = r6;
        r6 = r3;
        r3 = r5;
        r5 = r8;
        r8 = r4;
        goto L_0x002a;
    L_0x00f9:
        r9 = 1;
        r0 = r17;
        r6 = r0.content;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r5 != 0) goto L_0x025b;
    L_0x0104:
        r5 = "​";
        r13 = r6.split(r5);
        r14 = r13.length;
        r5 = 0;
        r11 = r5;
    L_0x010e:
        if (r11 >= r14) goto L_0x025b;
    L_0x0110:
        r5 = r13[r11];
        r0 = r18;
        r15 = r5.startsWith(r0);
        if (r15 == 0) goto L_0x012c;
    L_0x011a:
        r6 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234836; // 0x7f081014 float:1.8085849E38 double:1.0529699157E-314;
        r6 = r6.getString(r11);
        r11 = r6;
        r6 = r3;
        r3 = r5;
        r5 = r8;
        r8 = r4;
        goto L_0x002a;
    L_0x012c:
        r5 = r11 + 1;
        r11 = r5;
        goto L_0x010e;
    L_0x0130:
        r5 = 1;
        r0 = r17;
        r6 = r0.content;
        r9 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234838; // 0x7f081016 float:1.8085853E38 double:1.0529699167E-314;
        r9 = r9.getString(r11);
        r11 = r9;
        r9 = r5;
        r5 = r8;
        r8 = r4;
        r16 = r6;
        r6 = r3;
        r3 = r16;
        goto L_0x002a;
    L_0x014b:
        r5 = 1;
        r0 = r17;
        r6 = r0.content;
        r9 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234831; // 0x7f08100f float:1.8085839E38 double:1.052969913E-314;
        r9 = r9.getString(r11);
        r11 = r9;
        r9 = r5;
        r5 = r8;
        r8 = r4;
        r16 = r6;
        r6 = r3;
        r3 = r16;
        goto L_0x002a;
    L_0x0166:
        r6 = 1;
        r5 = 1;
        r8 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r11 = 2131234840; // 0x7f081018 float:1.8085857E38 double:1.0529699177E-314;
        r8 = r8.getString(r11);
        r11 = r8;
        r8 = r4;
        r16 = r6;
        r6 = r3;
        r3 = r9;
        r9 = r16;
        goto L_0x002a;
    L_0x017d:
        r0 = r19;
        r1 = r18;
        r2 = r17;
        r4 = com.tencent.mm.modelsearch.h.a(r7, r0, r1, r2);
        r7 = r4;
        goto L_0x0037;
    L_0x018a:
        r6 = com.tencent.mm.pluginsdk.j.a.bmu();
        r5 = com.tencent.mm.modelsearch.d.cVF;
        r8 = r5.split(r4);
        r13 = new java.lang.StringBuffer;
        r13.<init>();
        r4 = 0;
        r5 = r4;
    L_0x019b:
        r4 = r3.size();
        if (r5 >= r4) goto L_0x01cf;
    L_0x01a1:
        r4 = r3.get(r5);
        r4 = (com.tencent.mm.modelsearch.p.i) r4;
        r14 = r4.cWG;
        r15 = r8.length;
        if (r14 >= r15) goto L_0x01b1;
    L_0x01ac:
        r14 = r4.cWt;
        switch(r14) {
            case 8: goto L_0x01bb;
            case 9: goto L_0x01b8;
            case 10: goto L_0x01b5;
            default: goto L_0x01b1;
        };
    L_0x01b1:
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x019b;
    L_0x01b5:
        r14 = 1;
        r4.cWL = r14;
    L_0x01b8:
        r14 = 1;
        r4.cWK = r14;
    L_0x01bb:
        r14 = r4.cWK;
        if (r14 == 0) goto L_0x01ca;
    L_0x01bf:
        r14 = r4.cWG;
        r14 = r8[r14];
        r14 = r6.vu(r14);
        r4.cWI = r14;
        goto L_0x01b1;
    L_0x01ca:
        r14 = r4.content;
        r4.cWI = r14;
        goto L_0x01b1;
    L_0x01cf:
        r4 = 0;
        r6 = r4;
    L_0x01d1:
        r4 = r3.size();
        if (r6 >= r4) goto L_0x022a;
    L_0x01d7:
        r4 = r3.get(r6);
        r4 = (com.tencent.mm.modelsearch.p.i) r4;
        r5 = r4.cWK;
        if (r5 == 0) goto L_0x0208;
    L_0x01e1:
        r5 = r4.cWI;
        r8 = r4.cWL;
        r0 = r19;
        r1 = r18;
        r5 = com.tencent.mm.modelsearch.h.a(r5, r0, r8, r1);
    L_0x01ed:
        r8 = r13.length();
        if (r8 <= 0) goto L_0x01f9;
    L_0x01f3:
        r8 = ", ";
        r13.append(r8);
    L_0x01f9:
        r8 = r4.cWJ;
        r8 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r8 == 0) goto L_0x0214;
    L_0x0201:
        r13.append(r5);
    L_0x0204:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x01d1;
    L_0x0208:
        r5 = r4.cWI;
        r8 = 0;
        r0 = r19;
        r1 = r18;
        r5 = com.tencent.mm.modelsearch.h.a(r5, r0, r1, r8);
        goto L_0x01ed;
    L_0x0214:
        r4 = r4.cWJ;
        r4 = r13.append(r4);
        r8 = 40;
        r4 = r4.append(r8);
        r4 = r4.append(r5);
        r5 = 41;
        r4.append(r5);
        goto L_0x0204;
    L_0x022a:
        r3 = r13.toString();
        goto L_0x0060;
    L_0x0230:
        if (r8 == 0) goto L_0x024d;
    L_0x0232:
        r0 = r19;
        r1 = r18;
        r3 = com.tencent.mm.modelsearch.h.a(r3, r0, r6, r1);
    L_0x023a:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r11);
        r3 = r4.append(r3);
        r3 = r3.toString();
        goto L_0x0071;
    L_0x024d:
        r0 = r19;
        r1 = r18;
        r2 = r17;
        r3 = com.tencent.mm.modelsearch.h.a(r3, r0, r1, r2);
        goto L_0x023a;
    L_0x0258:
        r3 = move-exception;
        goto L_0x009a;
    L_0x025b:
        r5 = r6;
        goto L_0x011a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.c.c.a(com.tencent.mm.modelsearch.p$h, java.lang.String, java.util.List):org.json.JSONObject");
    }
}
