package com.tencent.mm.ui.chatting;

import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.lr;
import com.tencent.mm.e.a.ls;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.qa;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

public final class dw {
    public static void aC(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", Long.valueOf(atVar.field_msgId));
        if (m.eY(atVar.field_talker)) {
            b lsVar = new ls();
            lsVar.bmW.aXd = atVar;
            a.nhr.z(lsVar);
            return;
        }
        lsVar = new lr();
        lsVar.bmV.aXd = atVar;
        a.nhr.z(lsVar);
    }

    public static void aD(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d", Long.valueOf(atVar.field_msgId));
        b mqVar = new mq();
        mqVar.bnZ.aXd = atVar;
        a.nhr.z(mqVar);
    }

    public static void ar(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", Long.valueOf(atVar.field_msgId));
        b qaVar = new qa();
        qaVar.brp.aXd = atVar;
        a.nhr.z(qaVar);
    }

    public static void au(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", Long.valueOf(atVar.field_msgId));
        c dy = am.Wf().dy(atVar.field_msgId);
        if (dy == null || dy.field_msgInfoId != atVar.field_msgId) {
            v.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            am.bnE();
            al.a.dC(atVar.field_msgId);
            return;
        }
        v.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        dy.field_status = 101;
        dy.field_offset = 0;
        dy.field_lastModifyTime = System.currentTimeMillis() / 1000;
        am.Wf().a(dy, new String[0]);
        am.bnE().run();
    }

    public static void L(at atVar) {
        int i = 0;
        v.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", Long.valueOf(atVar.field_msgId));
        String str = atVar.field_content;
        int i2 = atVar.field_isSend;
        String str2 = atVar.field_talker;
        if (m.ey(str2) || i.ef(str2)) {
            i = 1;
        }
        if (!(i == 0 || str == null || i2 != 0)) {
            str = aw.fM(str);
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
        if ((dV == null || 19 != dV.type) && (dV == null || 24 != dV.type)) {
            l.L(atVar);
        } else {
            b kwVar = new kw();
            kwVar.bmf.type = 4;
            kwVar.bmf.bmk = atVar;
            kwVar.bmf.toUser = atVar.field_talker;
            a.nhr.z(kwVar);
        }
        aw.L(atVar.field_msgId);
    }

    public static void as(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", Long.valueOf(atVar.field_msgId));
        aF(atVar);
    }

    public static void aE(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", Long.valueOf(atVar.field_msgId));
        aF(atVar);
    }

    public static void at(at atVar) {
        v.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", Long.valueOf(atVar.field_msgId));
        aF(atVar);
    }

    private static void aF(at atVar) {
        long j = atVar.field_msgId;
        if (j == -1) {
            v.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + j);
        } else if (!atVar.field_talker.equals("medianote") || (k.xJ() & 16384) != 0) {
            v.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", Long.valueOf(j));
            if (!ak.vy().a(new com.tencent.mm.modelmulti.i(j), 0)) {
                v.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
                atVar.dh(5);
                ak.yW();
                com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
                b msVar = new ms();
                msVar.boc.aXd = atVar;
                a.nhr.z(msVar);
            }
        }
    }
}
