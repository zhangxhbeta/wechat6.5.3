package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.w;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;

public final class e extends w {
    public final boolean eH(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        v.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            ak.yW();
            g wE = c.wE();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username").append(" from rconversation, rcontact").append(", bizinfo where rconversation").append(".username = rcontact").append(".username and rconversation").append(".username = bizinfo").append(".username and ( rcontact").append(".verifyFlag & 8").append(" ) != 0 ");
            v.d("MicroMsg.ConversationDataTransfer", "select sql %s", stringBuilder.toString());
            Cursor rawQuery = wE.rawQuery(r1, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                ab abVar;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef").append(" = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = rawQuery.getString(0);
                    if (!m.fl(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                v.d("MicroMsg.ConversationDataTransfer", "changed[%B] exec sql[%s]", Boolean.valueOf(true), stringBuilder.toString());
                wE.dF("rconversation", r1);
                ak.yW();
                ab Mh = c.wK().Mh("officialaccounts");
                if (Mh == null) {
                    af abVar2 = new ab("officialaccounts");
                    abVar2.bvG();
                    ak.yW();
                    c.wK().d(abVar2);
                    abVar = abVar2;
                } else {
                    abVar = Mh;
                }
                ak.yW();
                String bvM = c.wK().bvM();
                if (be.kS(bvM)) {
                    v.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    return;
                }
                ak.yW();
                at MI = c.wJ().MI(bvM);
                if (MI == null || MI.field_msgId == 0) {
                    v.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    return;
                }
                abVar.M(MI);
                abVar.setContent(MI.field_talker + ":" + MI.field_content);
                abVar.ct(Integer.toString(MI.field_type));
                ak.yW();
                ac.c cVar = c.wK().nuA;
                if (cVar != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    MI.cH("officialaccounts");
                    MI.setContent(abVar.field_content);
                    cVar.a(MI, pString, pString2, pInt, false);
                    abVar.cu(pString.value);
                    abVar.cv(pString2.value);
                    abVar.dj(pInt.value);
                }
                ak.yW();
                c.wK().a(abVar, abVar.field_username, true);
            }
            if (rawQuery != null && !rawQuery.isClosed()) {
                rawQuery.close();
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
