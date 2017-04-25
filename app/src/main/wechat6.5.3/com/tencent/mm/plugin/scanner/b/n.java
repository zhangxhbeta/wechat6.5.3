package com.tencent.mm.plugin.scanner.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.LinkedList;
import java.util.Map;

public final class n {

    public static class a {
        public String field_certification;
        public String field_certificationurl;
        public String field_detailurl;
        public String field_exposeurl;
        public String field_extinfo;
        public String field_feedbackurl;
        public int field_functionType;
        public int field_getaction;
        public String field_headerbackgroundurl;
        public String field_headermask;
        public String field_introlink;
        public String field_introtitle;
        public String field_playurl;
        public String field_productid;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public int field_type;
        public String field_xml;
        public int field_xmlType;
        public LinkedList<com.tencent.mm.plugin.scanner.a.a> iEd;
        public a iEe;

        public static class a {
            public LinkedList<a> iEf;
            public LinkedList<b> iEg;

            public static class a {
                public String cZp;
            }

            public static class b {
                public String desc;
                public String title;
            }
        }

        public final void k(java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r1 = 0;
            if (r7 == 0) goto L_0x0108;
        L_0x0005:
            r0 = new com.tencent.mm.plugin.scanner.b.n$a$a;
            r0.<init>();
            r6.iEe = r0;
            r0 = r6.iEe;
            r2 = new java.util.LinkedList;
            r2.<init>();
            r0.iEf = r2;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0 = r0.append(r8);
            r2 = ".bannerlist.banner";
            r0 = r0.append(r2);
            r3 = r0.toString();
            r2 = r1;
        L_0x002a:
            if (r2 >= r5) goto L_0x0079;
        L_0x002c:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r4 = r0.append(r3);
            if (r2 <= 0) goto L_0x0075;
        L_0x0037:
            r0 = java.lang.Integer.valueOf(r2);
        L_0x003b:
            r0 = r4.append(r0);
            r0 = r0.toString();
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r0 = r4.append(r0);
            r4 = ".link";
            r0 = r0.append(r4);
            r0 = r0.toString();
            r0 = r7.get(r0);
            r0 = (java.lang.String) r0;
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r4 != 0) goto L_0x0079;
        L_0x0063:
            r4 = new com.tencent.mm.plugin.scanner.b.n$a$a$a;
            r4.<init>();
            r4.cZp = r0;
            r0 = r6.iEe;
            r0 = r0.iEf;
            r0.add(r4);
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x002a;
        L_0x0075:
            r0 = "";
            goto L_0x003b;
        L_0x0079:
            r0 = r6.iEe;
            r2 = new java.util.LinkedList;
            r2.<init>();
            r0.iEg = r2;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0 = r0.append(r8);
            r2 = ".detaillist.detail";
            r0 = r0.append(r2);
            r3 = r0.toString();
            r2 = r1;
        L_0x0097:
            if (r2 >= r5) goto L_0x0108;
        L_0x0099:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = r0.append(r3);
            if (r2 <= 0) goto L_0x0104;
        L_0x00a4:
            r0 = java.lang.Integer.valueOf(r2);
        L_0x00a8:
            r0 = r1.append(r0);
            r1 = r0.toString();
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0 = r0.append(r1);
            r4 = ".title";
            r0 = r0.append(r4);
            r0 = r0.toString();
            r0 = r7.get(r0);
            r0 = (java.lang.String) r0;
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r1 = r4.append(r1);
            r4 = ".desc";
            r1 = r1.append(r4);
            r1 = r1.toString();
            r1 = r7.get(r1);
            r1 = (java.lang.String) r1;
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r4 == 0) goto L_0x00f0;
        L_0x00ea:
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r1);
            if (r4 != 0) goto L_0x0108;
        L_0x00f0:
            r4 = new com.tencent.mm.plugin.scanner.b.n$a$a$b;
            r4.<init>();
            r4.title = r0;
            r4.desc = r1;
            r0 = r6.iEe;
            r0 = r0.iEg;
            r0.add(r4);
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x0097;
        L_0x0104:
            r0 = "";
            goto L_0x00a8;
        L_0x0108:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.b.n.a.k(java.util.Map, java.lang.String):void");
        }
    }

    public static class b {
        public String cZp;

        public b(String str) {
            this.cZp = str;
        }
    }

    public static class c {
        public String cID;
        public String username;

        public c(String str, String str2) {
            this.username = str;
            this.cID = str2;
        }
    }

    public static String A(Context context, int i) {
        if (context == null || i < 0) {
            return "";
        }
        if (i == 0) {
            context.getString(2131234790);
        } else if (i == 1) {
            context.getString(2131234783);
        } else if (i == 2) {
            context.getString(2131234789);
        } else if (i == 3) {
            context.getString(2131234784);
        }
        return context.getString(2131234790);
    }

    public static int yY(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            return 1;
        }
        if (trim.startsWith("<url")) {
            return 2;
        }
        if (trim.startsWith("<product")) {
            return 3;
        }
        if (trim.startsWith("<search")) {
            return 4;
        }
        return 0;
    }

    public static c yZ(String str) {
        if (str == null) {
            return null;
        }
        Map q = bf.q(str, "user");
        if (q != null) {
            return new c(be.ma((String) q.get(".user.username")), be.ma((String) q.get(".user.nickname")));
        }
        return null;
    }

    public static b za(String str) {
        if (str == null) {
            return null;
        }
        Map q = bf.q(str, "url");
        if (q != null) {
            return new b(be.ma((String) q.get(".url.link")));
        }
        return null;
    }

    public static String c(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!be.kS(aVar.field_productid)) {
            stringBuilder.append("<productInfo><product type=\"" + aVar.field_type + "\">");
            stringBuilder.append("<id>" + be.KJ(aVar.field_productid) + "</id>");
            stringBuilder.append("<title>" + be.KJ(aVar.field_title) + "</title>");
            stringBuilder.append("<subtitle>" + be.KJ(aVar.field_subtitle) + "</subtitle>");
            stringBuilder.append("<thumburl>" + be.KJ(aVar.field_thumburl) + "</thumburl>");
            stringBuilder.append("<source>" + be.KJ(aVar.field_source) + "</source>");
            stringBuilder.append("<shareurl>" + be.KJ(aVar.field_shareurl) + "</shareurl>");
            stringBuilder.append("<playurl>" + be.KJ(aVar.field_playurl) + "</playurl>");
            stringBuilder.append("<extinfo>" + be.KJ(aVar.field_extinfo) + "</extinfo>");
            stringBuilder.append("<getaction>" + be.KJ(aVar.field_getaction) + "</getaction>");
            stringBuilder.append("<certification>" + be.KJ(aVar.field_certification) + "</certification>");
            stringBuilder.append("<headerbackgroundurl>" + be.KJ(aVar.field_headerbackgroundurl) + "</headerbackgroundurl>");
            stringBuilder.append("<headermask>" + be.KJ(aVar.field_headermask) + "</headermask>");
            stringBuilder.append("<detailurl>" + be.KJ(aVar.field_detailurl) + "</detailurl>");
            stringBuilder.append("<certificationurl>" + be.KJ(aVar.field_certificationurl) + "</certificationurl>");
            stringBuilder.append("</product>");
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        } else if (aVar.field_xml == null) {
            v.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            return "";
        } else if (aVar.field_xml.startsWith("<productInfo")) {
            return aVar.field_xml;
        } else {
            stringBuilder.append("<productInfo>");
            stringBuilder.append(aVar.field_xml);
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        }
        return stringBuilder.toString();
    }

    public static int a(String str, i iVar, int i, com.tencent.mm.plugin.scanner.b.e.a aVar, int i2, int i3) {
        boolean z = true;
        if (iVar == null || str == null || iVar.aLH() == null || iVar.aLH().aLx() == null) {
            String str2 = "MicroMsg.Scanner.ScanXmlHelper";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str2, str3, objArr);
            return 2;
        }
        int yY = yY(str);
        v.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(yY)});
        if (yY == 1) {
            c yZ = yZ(str);
            if (yZ == null || be.kS(yZ.username)) {
                v.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                return 2;
            }
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(yZ.username);
            if (LX == null || ((int) LX.chr) <= 0) {
                iVar.aLH().a(yZ.username, 1, i2, i3, aVar);
                return 1;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", LX.field_username);
            intent.setFlags(65536);
            com.tencent.mm.plugin.scanner.a.drp.d(intent, iVar.aLH().aLx());
            return 0;
        } else if (yY == 2) {
            b za = za(str);
            if (za == null || be.kS(za.cZp)) {
                v.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                return 2;
            }
            v.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{za.cZp});
            r1 = new Intent();
            r1.putExtra("rawUrl", za.cZp);
            r1.setFlags(65536);
            com.tencent.mm.plugin.scanner.a.drp.j(r1, iVar.aLH().aLx());
            return 0;
        } else if (yY == 3 || yY == 4) {
            v.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(true)});
            r1 = new Intent();
            r1.setClass(iVar.aLH().aLx(), ProductUI.class);
            r1.setFlags(65536);
            r1.putExtra("key_Product_xml", str);
            r1.putExtra("key_Product_funcType", i);
            r1.putExtra("key_ProductUI_addToDB", true);
            r1.putExtra("key_need_add_to_history", true);
            r1.putExtra("key_is_from_barcode", true);
            iVar.aLH().aLx().startActivity(r1);
            return 0;
        } else {
            v.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            v.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str});
            return 2;
        }
    }
}
