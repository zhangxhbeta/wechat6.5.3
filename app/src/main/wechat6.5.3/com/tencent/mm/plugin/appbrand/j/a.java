package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.u;
import java.util.Map;

public final class a implements b {
    public final void a(ab abVar, ac acVar) {
        if (abVar != null && !be.kS(abVar.field_username)) {
            String str = abVar.field_username;
            ak.yW();
            u LX = c.wH().LX(str);
            if (LX == null || ((int) LX.chr) == 0) {
                v.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[]{str});
            } else if (u.dW(str) && !m.eP(str)) {
                v.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                abVar.cw("appbrandcustomerservicemsg");
                ak.yW();
                ab Mh = c.wK().Mh("appbrandcustomerservicemsg");
                if (Mh == null) {
                    v.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    Mh = new ab("appbrandcustomerservicemsg");
                    Mh.bvG();
                    a(abVar, Mh);
                    ak.yW();
                    c.wK().d(Mh);
                    return;
                }
                v.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                Mh.cw(null);
                a(abVar, Mh);
                ak.yW();
                c.wK().a(Mh, "appbrandcustomerservicemsg", true);
            } else if (m.fm(str)) {
                v.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                abVar.cw(null);
            }
        }
    }

    private static void a(ab abVar, ab abVar2) {
        af afVar;
        bx MI;
        String str = null;
        ak.yW();
        Cursor b = c.wK().b(m.crF, null, "appbrandcustomerservicemsg");
        if (b != null) {
            if (b.getCount() <= 0 || !b.moveToFirst()) {
                afVar = null;
            } else {
                afVar = new ab();
                afVar.b(b);
            }
            b.close();
        } else {
            afVar = null;
        }
        if (afVar != null) {
            v.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", new Object[]{afVar.field_username});
            ak.yW();
            MI = c.wJ().MI(afVar.field_username);
        } else {
            v.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            ak.yW();
            MI = c.wJ().MI(abVar.field_username);
        }
        if (MI == null || MI.field_msgId <= 0) {
            v.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            abVar2.bvG();
            return;
        }
        abVar2.M(MI);
        abVar2.setContent(MI.field_talker + ":" + MI.field_content);
        abVar2.ct(Integer.toString(MI.field_type));
        ak.yW();
        ac.c cVar = c.wK().nuA;
        if (cVar != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            MI.cH(abVar.field_parentRef);
            MI.setContent(abVar2.field_content);
            cVar.a(MI, pString, pString2, pInt, true);
            int i = MI.field_type;
            String str2 = MI.field_content;
            if (!be.kS(str2)) {
                switch (i) {
                    case 49:
                        Map q = bf.q(str2, "msg");
                        if (q != null) {
                            v.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[]{(String) q.get(".msg.appmsg.title")});
                            str = r0;
                            break;
                        }
                        break;
                }
            }
            abVar2.cu(be.ma(pString.value).concat(be.kS(str) ? "" : " " + be.ma(str)));
            abVar2.cv(pString2.value);
            abVar2.dj(pInt.value);
        }
    }
}
