package com.tencent.mm.storage;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.f.a.a.b;
import com.tencent.mm.plugin.f.a.a.c;
import com.tencent.mm.plugin.f.a.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public final class n implements b, c, g {
    private ac nnU;

    public n(ac acVar) {
        u.DK();
        this.nnU = acVar;
        this.nnU.nuD.ay(this);
        this.nnU.nuC.ay(this);
    }

    public final void a(at atVar, boolean z, au.c cVar, ab abVar) {
        String str = cVar.bdo;
        if (z) {
            if (!(atVar == null || atVar.field_isSend == 1 || (ax.g(atVar) & 1) == 0)) {
                v.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                abVar.ek(4194304);
            }
            if (atVar != null && e.hC(str)) {
                v.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                abVar.ek(8388608);
            }
        } else {
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(str);
            if (!(LX == null || !LX.bvm() || a.ei(LX.field_type) || atVar == null || atVar.field_isSend == 1 || abVar.el(4194304) || (abVar.field_conversationTime >= u.DK() && (ax.g(atVar) & 1) == 0))) {
                abVar.ek(4194304);
                v.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", str);
            }
            if (atVar != null && e.hC(str)) {
                v.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", str);
                abVar.ek(8388608);
            }
        }
        if (cVar != null && !cVar.nwt.isEmpty() && cVar.nwt.get(0) != null) {
            abVar.di(((at) cVar.nwt.get(0)).field_isSend);
            if (cVar.nws.equals("insert")) {
                abVar.nuz = (at) cVar.nwt.get(cVar.nwt.size() - 1);
            }
        }
    }

    public final void a(at atVar, ab abVar) {
        String str = null;
        if (this.nnU.nuA != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            this.nnU.nuA.a(atVar, pString, pString2, pInt, abVar.el(2097152));
            v.d("MicroMsg.BizConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", pString2.value);
            abVar.cu(pString.value);
            abVar.cv(pString2.value);
            abVar.dj(pInt.value);
        } else {
            String ao = ac.ao(atVar.field_type, abVar.field_content);
            abVar.cu(be.ma(abVar.field_digest).concat(be.kS(ao) ? SQLiteDatabase.KeyEmpty : " " + be.ma(ao)));
        }
        abVar.ct(Integer.toString(atVar.field_type));
        if (abVar != null && atVar != null && atVar.field_bizChatId != -1 && abVar.el(8388608)) {
            com.tencent.mm.modelbiz.a.c Z = u.DA().Z(atVar.field_bizChatId);
            String str2 = abVar.field_digest;
            if (be.kS(atVar.field_bizChatUserId)) {
                v.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", Z.field_bizChatServId, Z.field_chatName);
                return;
            }
            j ig = u.DC().ig(atVar.field_bizChatUserId);
            if (ig != null) {
                ao = ig.field_userName;
            } else {
                ao = null;
            }
            boolean equals = atVar.field_bizChatUserId.equals(u.DC().ii(atVar.field_talker));
            if (ig != null && equals) {
                abVar.cu(aa.getContext().getString(2131231088) + ":" + str2);
            } else if (!(ig == null || be.kS(ig.field_userName))) {
                abVar.cu(ig.field_userName + ":" + str2);
            }
            if (!Z.DN()) {
                if (equals || ao == null || ao.length() <= 0 || ao.equals(Z.field_chatName)) {
                    j ig2 = u.DC().ig(Z.field_bizChatServId);
                    if (ig2 != null) {
                        str = ig2.field_userName;
                    }
                    if (str != null && str.length() > 0 && !str.equals(Z.field_chatName)) {
                        Z.field_chatName = str;
                        u.DA().b(Z);
                        return;
                    }
                    return;
                }
                Z.field_chatName = ao;
                u.DA().b(Z);
            }
        }
    }

    public final void a(ac acVar, String str, at atVar, ab abVar, boolean z, int i, int i2, au.c cVar) {
        if (!be.kS(abVar.field_parentRef)) {
            ab Mh = acVar.Mh(abVar.field_parentRef);
            if (Mh != null && Mh.el(2097152)) {
                if (i > 0) {
                    if ((cVar.nws.equals("insert") && cVar.nwu > 0) || (cVar.nws.equals("update") && Mh.field_unReadCount + cVar.nwu >= 0)) {
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(str);
                        if (LX == null || !LX.tM()) {
                            Mh.df(Mh.field_unReadCount + i);
                        } else {
                            Mh.dm(Mh.field_unReadMuteCount + i);
                        }
                    }
                    ac.a(abVar, i2, i);
                }
                ak.yW();
                String Mr = com.tencent.mm.model.c.wK().Mr(abVar.field_parentRef);
                ak.yW();
                at MI = com.tencent.mm.model.c.wJ().MI(Mr);
                if (MI == null || MI.field_msgId <= 0) {
                    Mh.bvG();
                } else {
                    Mh.M(MI);
                    Mh.setContent(MI.field_talker + ":" + MI.field_content);
                    Mh.ct(Integer.toString(MI.field_type));
                    if (acVar.nuA != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        MI.cH(abVar.field_parentRef);
                        MI.setContent(Mh.field_content);
                        acVar.nuA.a(MI, pString, pString2, pInt, true);
                        Mr = ac.ao(MI.field_type, MI.field_content);
                        Mh.cu(be.ma(pString.value).concat(be.kS(Mr) ? SQLiteDatabase.KeyEmpty : " " + be.ma(Mr)));
                        Mh.cv(pString2.value);
                        Mh.dj(pInt.value);
                    }
                }
                if (acVar.a(Mh, abVar.field_parentRef, true) > 0) {
                    v.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", abVar.field_parentRef, Integer.valueOf(Mh.field_unReadCount + i));
                    acVar.b(3, acVar, abVar.field_parentRef);
                }
            } else if (Mh == null || !"officialaccounts".equals(Mh.field_username)) {
                if (Mh != null && "appbrandcustomerservicemsg".equals(Mh.field_username) && i > 0) {
                    if ((cVar.nws.equals("insert") && cVar.nwu > 0) || (cVar.nws.equals("update") && Mh.field_unReadCount + cVar.nwu >= 0)) {
                        Mh.df(Mh.field_unReadCount + i);
                    }
                    ac.a(abVar, i2, i);
                    acVar.a(Mh, abVar.field_parentRef, true);
                }
            } else if (i > 0 && ((cVar.nws.equals("insert") && cVar.nwu > 0) || (cVar.nws.equals("update") && Mh.field_unReadCount + cVar.nwu >= 0))) {
                Mh.df(Mh.field_unReadCount + i);
                acVar.a(Mh, abVar.field_parentRef, true);
            }
        }
        a(str, abVar, i, i2, cVar);
    }

    private void a(String str, ab abVar, int i, int i2, au.c cVar) {
        if (abVar != null && cVar != null && cVar.ezh != -1 && abVar.el(8388608)) {
            at I = ak.yW().cqY.I(str, cVar.ezh);
            com.tencent.mm.modelbiz.a.a T = u.DB().T(cVar.ezh);
            com.tencent.mm.modelbiz.a.c Z = u.DA().Z(cVar.ezh);
            if (Z.field_bizChatServId == null) {
                v.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
            } else if (I == null || I.field_msgId == 0) {
                v.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + str);
                T.field_status = 0;
                T.field_isSend = 0;
                T.field_content = SQLiteDatabase.KeyEmpty;
                T.field_msgType = "0";
                T.field_unReadCount = 0;
                T.field_digest = SQLiteDatabase.KeyEmpty;
                T.field_digestUser = SQLiteDatabase.KeyEmpty;
                u.DB();
                com.tencent.mm.modelbiz.a.b.a(T, i2, i);
                u.DB().b(T);
            } else {
                Object obj;
                com.tencent.mm.modelbiz.a.a aVar;
                long j;
                Object obj2;
                int i3;
                String ii;
                Iterator it;
                Object obj3;
                at atVar;
                boolean DN = Z.DN();
                T.field_brandUserName = str;
                if (I.bwi()) {
                    T.field_content = I.bwC();
                } else {
                    T.field_content = I.field_content;
                }
                PString pString = new PString();
                this.nnU.nuA.a(I, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                j ig = u.DC().ig(I.field_bizChatUserId);
                if (!DN) {
                    T.field_digest = str2;
                    obj = null;
                } else if (I.field_isSend == 1 && ig != null) {
                    T.field_digest = aa.getContext().getString(2131231088) + ":" + str2;
                    ig.field_userName = aa.getContext().getString(2131231088);
                    obj = null;
                } else if (ig == null || be.kS(ig.field_userName)) {
                    T.field_digest = str2;
                    obj = null;
                } else {
                    T.field_digest = ig.field_userName + ":" + str2;
                    str2 = ig.field_userName;
                }
                String ao = ac.ao(I.field_type, I.field_content);
                T.field_digest = be.ma(T.field_digest).concat(be.kS(ao) ? SQLiteDatabase.KeyEmpty : " " + be.ma(ao));
                T.field_digestUser = SQLiteDatabase.KeyEmpty;
                T.field_chatType = Z.field_chatType;
                T.field_lastMsgID = I.field_msgId;
                if (I.bwo()) {
                    aVar = T;
                } else if (I.field_status == 1) {
                    j = Long.MAX_VALUE;
                    aVar = T;
                    aVar.field_lastMsgTime = j;
                    T.field_status = I.field_status;
                    T.field_isSend = I.field_isSend;
                    T.field_msgType = Integer.toString(I.field_type);
                    T.field_flag = com.tencent.mm.modelbiz.a.b.a(T, 1, I.field_createTime);
                    obj2 = null;
                    if ((cVar.nws.equals("insert") && cVar.nwu > 0) || (cVar.nws.equals("update") && T.field_unReadCount + cVar.nwu >= 0)) {
                        T.field_unReadCount += cVar.nwu;
                        T.field_newUnReadCount += cVar.nwu;
                        if (cVar.nwu > 0 && Z.fe(1)) {
                            i3 = abVar.field_unReadCount - cVar.nwu;
                            if (i3 > 0) {
                                abVar.df(0);
                            } else {
                                abVar.df(i3);
                            }
                            abVar.dm(abVar.field_unReadMuteCount + cVar.nwu);
                            obj2 = 1;
                        }
                    }
                    if (cVar.nws.equals("insert") && cVar.nwt.size() > 0 && Z.DN()) {
                        ii = u.DC().ii(I.field_talker);
                        it = cVar.nwt.iterator();
                        obj3 = obj2;
                        while (it.hasNext()) {
                            atVar = (at) it.next();
                            if (ii == null && atVar.field_isSend != 1 && atVar.bwm() && atVar.Mw(ii)) {
                                T.field_atCount++;
                                abVar.dl(abVar.field_atCount + 1);
                                obj2 = 1;
                            } else {
                                obj2 = obj3;
                            }
                            obj3 = obj2;
                        }
                        obj2 = obj3;
                    }
                    u.DB();
                    com.tencent.mm.modelbiz.a.b.a(T, i2, i);
                    v.i("MicroMsg.BizConversationStorage", "willen updateBizChatConversation brandUserName:%s,%s,%s", str, Z.field_bizChatServId, obj);
                    u.DB().b(T);
                    if (obj2 != null) {
                        this.nnU.a(abVar, str, true);
                    }
                } else {
                    aVar = T;
                }
                j = I.field_createTime;
                aVar.field_lastMsgTime = j;
                T.field_status = I.field_status;
                T.field_isSend = I.field_isSend;
                T.field_msgType = Integer.toString(I.field_type);
                T.field_flag = com.tencent.mm.modelbiz.a.b.a(T, 1, I.field_createTime);
                obj2 = null;
                T.field_unReadCount += cVar.nwu;
                T.field_newUnReadCount += cVar.nwu;
                i3 = abVar.field_unReadCount - cVar.nwu;
                if (i3 > 0) {
                    abVar.df(i3);
                } else {
                    abVar.df(0);
                }
                abVar.dm(abVar.field_unReadMuteCount + cVar.nwu);
                obj2 = 1;
                ii = u.DC().ii(I.field_talker);
                it = cVar.nwt.iterator();
                obj3 = obj2;
                while (it.hasNext()) {
                    atVar = (at) it.next();
                    if (ii == null) {
                    }
                    obj2 = obj3;
                    obj3 = obj2;
                }
                obj2 = obj3;
                u.DB();
                com.tencent.mm.modelbiz.a.b.a(T, i2, i);
                v.i("MicroMsg.BizConversationStorage", "willen updateBizChatConversation brandUserName:%s,%s,%s", str, Z.field_bizChatServId, obj);
                u.DB().b(T);
                if (obj2 != null) {
                    this.nnU.a(abVar, str, true);
                }
            }
        }
    }

    public final void Lx(String str) {
        if (str != null && m.eD(str) && e.hB(str)) {
            ab Mh = this.nnU.Mh(str);
            if (Mh != null) {
                ak.yW();
                String Mr = com.tencent.mm.model.c.wK().Mr(str);
                ak.yW();
                at MI = com.tencent.mm.model.c.wJ().MI(Mr);
                if (MI != null && MI.field_msgId > 0) {
                    Mh.M(MI);
                    Mh.setContent(MI.field_talker + ":" + MI.field_content);
                    Mh.ct(Integer.toString(MI.field_type));
                    ac.c cVar = this.nnU.nuA;
                    if (cVar != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        MI.cH(str);
                        MI.setContent(Mh.field_content);
                        cVar.a(MI, pString, pString2, pInt, true);
                        Mh.cu(pString.value);
                        Mh.cv(pString2.value);
                        Mh.dj(pInt.value);
                    } else {
                        Mh.bvG();
                    }
                    this.nnU.a(Mh, Mh.field_username, true);
                }
            }
        }
    }
}
