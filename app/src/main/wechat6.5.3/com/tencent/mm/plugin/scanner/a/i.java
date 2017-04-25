package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import com.tencent.mm.plugin.scanner.b.n;
import com.tencent.mm.plugin.scanner.b.n.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

public final class i {
    public static String a(Context context, a aVar) {
        com.tencent.mm.q.a.a aVar2 = new com.tencent.mm.q.a.a();
        aVar2.appId = oV(aVar.field_functionType);
        aVar2.title = aVar.field_title;
        aVar2.description = aVar.field_source;
        aVar2.type = 10;
        aVar2.url = aVar.field_shareurl;
        aVar2.bXP = "";
        aVar2.appName = n.A(context, aVar.field_type);
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.cox = aVar.field_type;
        aVar2.coy = n.c(aVar);
        return com.tencent.mm.q.a.a.b(aVar2);
    }

    public static String oV(int i) {
        if (i == 4) {
            return "wxfbc915ff7c30e335";
        }
        if (i == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    public static a aN(String str, int i) {
        if (be.kS(str)) {
            return null;
        }
        int yY = n.yY(str);
        if (yY == 3) {
            if (str == null) {
                return null;
            }
            Map q;
            int i2;
            String str2;
            String str3 = "";
            if (str.startsWith("<productInfo")) {
                q = bf.q(str, "productInfo");
                i2 = 1;
                str2 = ".productInfo";
            } else {
                i2 = 0;
                q = bf.q(str, "product");
                str2 = str3;
            }
            if (q == null) {
                return null;
            }
            a aVar = new a();
            if (be.kS((String) q.get(str2 + ".product.$type"))) {
                aVar.field_type = 0;
            } else {
                aVar.field_type = Integer.valueOf((String) q.get(str2 + ".product.$type")).intValue();
            }
            aVar.field_productid = be.ma((String) q.get(str2 + ".product.id"));
            aVar.field_subtitle = be.ma((String) q.get(str2 + ".product.subtitle"));
            aVar.field_shareurl = be.ma((String) q.get(str2 + ".product.shareurl"));
            aVar.field_playurl = be.ma((String) q.get(str2 + ".product.playurl"));
            aVar.field_xmlType = 3;
            aVar.field_title = be.ma((String) q.get(str2 + ".product.title"));
            aVar.field_thumburl = be.ma((String) q.get(str2 + ".product.thumburl"));
            aVar.field_source = be.ma((String) q.get(str2 + ".product.source"));
            aVar.field_feedbackurl = be.ma((String) q.get(str2 + ".product.feedbackurl"));
            aVar.field_extinfo = be.ma((String) q.get(str2 + ".product.extinfo"));
            aVar.field_introtitle = be.ma((String) q.get(str2 + ".product.introtitle"));
            aVar.field_introlink = be.ma((String) q.get(str2 + ".product.introlink"));
            aVar.field_getaction = be.getInt((String) q.get(str2 + ".product.getaction"), 0);
            aVar.field_certification = be.ma((String) q.get(str2 + ".product.certification"));
            aVar.field_headerbackgroundurl = be.ma((String) q.get(str2 + ".product.headerbackgroundurl"));
            aVar.field_headermask = be.ma((String) q.get(str2 + ".product.headermask"));
            aVar.field_detailurl = be.ma((String) q.get(str2 + ".product.detailurl"));
            aVar.field_certificationurl = be.ma((String) q.get(str2 + ".product.certificationurl"));
            aVar.field_exposeurl = be.ma((String) q.get(str2 + ".product.exposeurl"));
            aVar.iEd = a.i(q, str2 + ".product");
            aVar.k(q, str2 + ".product");
            String str4 = (String) q.get(str2 + ".functionType");
            if (be.kS(str4)) {
                aVar.field_functionType = i;
            } else {
                aVar.field_functionType = Integer.valueOf(str4).intValue();
            }
            if (i2 != 0) {
                aVar.field_xml = str;
            } else {
                StringBuilder stringBuilder = new StringBuilder(256);
                stringBuilder.append("<productInfo>");
                stringBuilder.append(str);
                stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
                stringBuilder.append("</productInfo>");
                aVar.field_xml = stringBuilder.toString();
            }
            return aVar;
        } else if (yY != 4 || str == null) {
            return null;
        } else {
            Map q2 = bf.q(str, "search");
            if (q2 == null) {
                return null;
            }
            a aVar2 = new a();
            aVar2.field_xmlType = 4;
            aVar2.field_xml = str;
            aVar2.iEd = a.i(q2, ".search");
            return aVar2;
        }
    }
}
