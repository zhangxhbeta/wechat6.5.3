package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class x {
    public static boolean X(at atVar) {
        if (atVar == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            return true;
        }
        c rg;
        if (atVar.bwq()) {
            ag agVar = new ag(atVar.field_content);
            a B = a.B(atVar.field_content, atVar.field_reserved);
            if (B == null) {
                B = new a();
                B.cod = agVar.aZy;
            }
            rg = j.a.bmr().rg(B.cod);
        } else {
            rg = j.a.bmr().rg(atVar.field_imgPath);
        }
        if (rg != null && (rg.field_catalog == c.nwR || (!be.kS(rg.field_groupId) && j.a.bmr().rl(rg.field_groupId)))) {
            return false;
        }
        if (rg == null || !rg.bxI()) {
            return false;
        }
        return true;
    }

    public static boolean Y(at atVar) {
        if (atVar.bwq()) {
            ag agVar = new ag(atVar.field_content);
            a B = a.B(atVar.field_content, atVar.field_reserved);
            if (B == null) {
                B = new a();
                B.cod = agVar.aZy;
            }
            if (j.a.bmr().rg(B.cod) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean Z(at atVar) {
        if (atVar == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            return true;
        }
        String fM;
        if (atVar.field_isSend == 0) {
            fM = aw.fM(atVar.field_content);
        } else {
            fM = atVar.field_content;
        }
        a dV = a.dV(fM);
        if (dV == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            return false;
        }
        f aC = g.aC(dV.appId, false);
        return aC != null && aC.bnk();
    }

    public static boolean aa(at atVar) {
        return atVar.field_type == 419430449;
    }

    public static boolean ab(at atVar) {
        return atVar.field_type == 436207665 || atVar.field_type == 469762097;
    }

    public static boolean co(List<at> list) {
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
            return true;
        }
        for (at atVar : list) {
            if (atVar.bwb() || X(atVar) || atVar.bwk() || Z(atVar) || aa(atVar) || atVar.field_type == -1879048186 || ae(atVar) || ab(atVar)) {
                return true;
            }
            if (ad(atVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cp(List<at> list) {
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            return false;
        } else if (list.size() == 1) {
            r0 = (at) list.get(0);
            if (af(r0) || r0.bwb() || X(r0) || Z(r0) || r0.field_type == -1879048186 || r0.field_type == 318767153 || ae(r0) || ab(r0) || ag(r0)) {
                return false;
            }
            return true;
        } else {
            Iterator it = list.iterator();
            boolean z = true;
            while (it.hasNext()) {
                boolean z2;
                r0 = (at) it.next();
                if (!(r0.bwb() || X(r0) || Z(r0) || aa(r0) || r0.field_type == -1879048186 || ae(r0) || ab(r0))) {
                    a dV;
                    boolean z3;
                    if (r0 != null) {
                        dV = a.dV(r0.field_content);
                        if (dV != null && dV.type == 19) {
                            z3 = true;
                            if (!z3) {
                                if (r0 != null) {
                                    dV = a.dV(r0.field_content);
                                    if (dV != null && dV.type == 24) {
                                        z3 = true;
                                        if (!(z3 || r0.field_type == 318767153 || af(r0) || ag(r0) || ad(r0))) {
                                            z2 = z;
                                            z = z2;
                                        }
                                    }
                                }
                                z3 = false;
                                z2 = z;
                                z = z2;
                            }
                        }
                    }
                    z3 = false;
                    if (z3) {
                        if (r0 != null) {
                            dV = a.dV(r0.field_content);
                            z3 = true;
                            z2 = z;
                            z = z2;
                        }
                        z3 = false;
                        z2 = z;
                        z = z2;
                    }
                }
                it.remove();
                z2 = false;
                z = z2;
            }
            return z;
        }
    }

    public static boolean ac(at atVar) {
        if (atVar == null) {
            return false;
        }
        a dV = a.dV(atVar.field_content);
        if (dV == null) {
            return false;
        }
        if (dV.type == 6 || dV.type == 5 || dV.type == 19) {
            return true;
        }
        return false;
    }

    public static boolean ad(at atVar) {
        if (atVar == null) {
            return false;
        }
        if (!atVar.bvZ() && !atVar.bwa()) {
            return false;
        }
        com.tencent.mm.q.c dZ = a.dZ(atVar.field_content);
        if (dZ == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "isBizMsgForbidForward reader is null");
            return false;
        } else if (dZ.cqF == 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean ae(at atVar) {
        if (atVar != null) {
            a dV = a.dV(atVar.field_content);
            if (dV != null && dV.type == 16) {
                return true;
            }
            if (dV != null && dV.type == 34) {
                return true;
            }
        }
        return false;
    }

    static boolean af(at atVar) {
        if (!atVar.bwk()) {
            return false;
        }
        ak.yW();
        at.a MU = com.tencent.mm.model.c.wJ().MU(atVar.field_content);
        if (MU == null || be.kS(MU.lct)) {
            return true;
        }
        if (m.eD(MU.lct)) {
            return false;
        }
        return true;
    }

    private static boolean ag(at atVar) {
        if (atVar != null && atVar.bvY()) {
            a dV = a.dV(atVar.field_content);
            if (dV != null && dV.type == 6 && (dV.cof != 0 || dV.cob > 26214400)) {
                return true;
            }
        }
        return false;
    }

    public static int cq(List<at> list) {
        if (list == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            return 0;
        }
        int i = 0;
        for (at atVar : list) {
            int i2;
            if (atVar.bwb() || X(atVar) || atVar.bwl() || Z(atVar) || aa(atVar) || ab(atVar)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public static boolean cr(List<at> list) {
        if (list == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
            return false;
        }
        for (at atVar : list) {
            if (atVar.bwj()) {
                d ah;
                d dVar = null;
                if (atVar.field_msgId > 0) {
                    dVar = n.GH().ai(atVar.field_msgId);
                }
                if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                    ah = n.GH().ah(atVar.field_msgSvrId);
                } else {
                    ah = dVar;
                }
                if (ah != null && (ah.offset < ah.cyu || ah.cyu == 0)) {
                    return true;
                }
            } else if (atVar.bwn()) {
                r0 = k.KV().kZ(atVar.field_imgPath);
                if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                    return true;
                }
            } else if (atVar.bwq()) {
                if (!Y(atVar)) {
                    return true;
                }
            } else if (atVar.bvY()) {
                a B = a.B(atVar.field_content, atVar.field_content);
                if (B != null) {
                    switch (B.type) {
                        case 6:
                            b Gu = am.Wf().Gu(B.aXa);
                            if (Gu != null) {
                                if (new File(Gu.field_fileFullPath).exists()) {
                                    break;
                                }
                                return true;
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return true;
            } else if (atVar.bwo()) {
                r0 = p.lp(atVar.field_imgPath);
                if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static boolean cs(List<at> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (at atVar : list) {
            if (atVar.bwn() && h.Gq(atVar.field_imgPath)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ct(List<at> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (at bwo : list) {
            if (bwo.bwo()) {
                return true;
            }
        }
        return false;
    }

    public static String m(String str, int i, boolean z) {
        if (z && str != null && i == 0) {
            return aw.fM(str);
        }
        return str;
    }

    public static List<String> bEe() {
        String str;
        List<String> fg = u.Dy().fg(25);
        com.tencent.mm.modelbiz.d Dy = u.Dy();
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.modelbiz.d.a(stringBuilder);
        com.tencent.mm.modelbiz.d.c(stringBuilder);
        com.tencent.mm.modelbiz.d.d(stringBuilder);
        com.tencent.mm.modelbiz.d.a(stringBuilder, true);
        stringBuilder.append(" order by ");
        stringBuilder.append(com.tencent.mm.modelbiz.d.Db());
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", stringBuilder.toString());
        Cursor rawQuery = Dy.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : arrayList) {
            String CF = e.hw(str2).CF();
            if (!be.kS(CF)) {
                hashMap.put(CF, str2);
            }
        }
        List<String> linkedList = new LinkedList();
        Collection linkedList2 = new LinkedList();
        for (String str22 : fg) {
            if (!e.hz(str22)) {
                linkedList.add(str22);
            } else if (e.hE(str22)) {
                str22 = e.hw(str22).field_enterpriseFather;
                if (!linkedList2.contains(str22) && e.hB(str22)) {
                    linkedList2.add(str22);
                    str22 = (String) hashMap.get(str22);
                    if (!be.kS(str22)) {
                        linkedList2.add(str22);
                    }
                }
            }
        }
        for (String str222 : hashMap.values()) {
            if (!(be.kS(str222) || linkedList2.contains(str222))) {
                linkedList2.add(str222);
            }
        }
        linkedList.addAll(linkedList2);
        v.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    static boolean a(Context context, String str, at atVar, String str2) {
        if (context == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", str2);
            return false;
        } else if (be.kS(str)) {
            v.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", str2);
            return false;
        } else if (atVar != null) {
            return true;
        } else {
            v.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", str2);
            return false;
        }
    }

    public static void a(Context context, String str, at atVar) {
        if (a(context, str, atVar, "emoji")) {
            String str2 = ag.Mv(atVar.field_content).aZy;
            if (str2 == null || str2.endsWith("-1")) {
                str2 = atVar.field_imgPath;
            }
            if (str2 == null) {
                v.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
            } else {
                j.a.bmr().l(context, str, str2);
            }
        }
    }

    public static void b(Context context, String str, at atVar) {
        if (a(context, str, atVar, "image")) {
            d ah;
            d dVar = null;
            if (atVar.field_msgId > 0) {
                dVar = n.GH().ai(atVar.field_msgId);
            }
            if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                ah = n.GH().ah(atVar.field_msgSvrId);
            } else {
                ah = dVar;
            }
            if (ah != null) {
                int i = 0;
                if (ah.Gp() && !com.tencent.mm.ae.e.a(ah).cLv.startsWith("SERVERID://")) {
                    i = 1;
                }
                String l = n.GH().l(com.tencent.mm.ae.e.c(ah), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                String l2 = n.GH().l(ah.cLx, "th_", SQLiteDatabase.KeyEmpty);
                if (!be.kS(l)) {
                    j.a.bmt().a(context, str, l, i, ah.cLF, l2);
                }
            }
        }
    }

    public static void c(Context context, String str, at atVar) {
        if (a(context, str, atVar, "video") && atVar != null) {
            if (atVar == null || !atVar.bwo() || !p.lr(atVar.field_imgPath)) {
                com.tencent.mm.as.n lp = p.lp(atVar.field_imgPath);
                String str2 = atVar.field_imgPath;
                int i = lp.dhO;
                int i2 = lp.dhK;
                String Lg = lp.Lg();
                int i3 = atVar.field_type;
                v.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
                String lb = o.lb(com.tencent.mm.model.k.xF());
                k.KV();
                v.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", o.lc(str2), o.lc(lb), o.ld(str2), o.ld(lb));
                com.tencent.mm.sdk.platformtools.j.n(r3, r7, false);
                com.tencent.mm.sdk.platformtools.j.n(str2, r8, false);
                p.a(lb, i2, str, null, i, Lg, i3);
                p.lk(lb);
            }
        }
    }

    public static void a(Context context, String str, at atVar, boolean z) {
        if (a(context, str, atVar, "text")) {
            String m = m(atVar.field_content, atVar.field_isSend, z);
            if (atVar.bwy()) {
                m = m + "\n\n" + m(atVar.field_transContent, atVar.field_isSend, z);
            }
            if (m == null || m.equals(SQLiteDatabase.KeyEmpty)) {
                v.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
            } else {
                j.a.bmt().x(str, m, m.fp(str));
            }
        }
    }

    public static void b(Context context, String str, at atVar, boolean z) {
        String str2 = null;
        if (!a(context, str, atVar, "appmsg")) {
            return;
        }
        if (context == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
        } else if (atVar == null) {
            v.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
        } else {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                String x = n.GH().x(atVar.field_imgPath, false);
                if (!(t.kS(x) || x.endsWith("hd") || !FileOp.aR(x + "hd"))) {
                    x = x + "hd";
                }
                try {
                    com.tencent.mm.q.c dZ = a.dZ(atVar.field_content);
                    List<com.tencent.mm.q.d> list = dZ.cqE;
                    if (list == null || list.size() <= 0) {
                        if (atVar != null && (atVar.bvY() || atVar.bvZ() || atVar.bwa())) {
                            str2 = com.tencent.mm.model.o.fz(atVar.field_msgSvrId);
                            com.tencent.mm.model.o.b n = com.tencent.mm.model.o.yx().n(str2, true);
                            n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
                            n.l("preUsername", ad.a(atVar, z, false));
                            n.l("preChatName", atVar.field_talker);
                            n.l("preMsgIndex", Integer.valueOf(0));
                            n.l("sendAppMsgScene", Integer.valueOf(1));
                            com.tencent.mm.modelstat.o.a("adExtStr", n, atVar);
                        }
                        j.a.bmt().a(str, be.readFromFile(x), be.KK(atVar.field_content), str2);
                        return;
                    }
                    for (com.tencent.mm.q.d dVar : list) {
                        a aVar = new a();
                        aVar.title = dVar.title;
                        aVar.description = dVar.cqK;
                        aVar.bXP = "view";
                        aVar.type = 5;
                        aVar.url = dVar.url;
                        aVar.bnR = dZ.bnR;
                        aVar.bnS = dZ.bnS;
                        aVar.bNm = dZ.bNm;
                        aVar.thumburl = dVar.cqI;
                        if (be.kS(aVar.thumburl) && !be.kS(aVar.bnR)) {
                            com.tencent.mm.u.h gQ = com.tencent.mm.u.n.Bo().gQ(aVar.bnR);
                            if (gQ != null) {
                                aVar.thumburl = gQ.Be();
                            }
                        }
                        j.a.bmt().a(str, be.readFromFile(x), be.KK(a.b(aVar)), null);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.ChattingEditModeLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", e.getLocalizedMessage());
                }
            }
        }
    }

    public static void c(Context context, String str, at atVar, boolean z) {
        if (a(context, str, atVar, "location")) {
            j.a.bmt().x(str, m(atVar.field_content, atVar.field_isSend, z), 48);
        }
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        try {
            at atVar = new at();
            atVar.setContent(str2);
            atVar.di(i);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map q = bf.q(str2, "msg");
            if (q != null && q.size() > 0) {
                atVar.cJ(au.U(q));
            }
            b(context, str, atVar, z);
        } catch (Throwable e) {
            v.a("MicroMsg.ChattingEditModeLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
        }
    }

    public static void b(c cVar, String str) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wY()).append(cVar.EB()).toString();
        if (com.tencent.mm.a.e.aQ(stringBuilder2 + "_thumb") > 0) {
            wXMediaMessage.thumbData = com.tencent.mm.a.e.c(stringBuilder2 + "_thumb", 0, com.tencent.mm.a.e.aQ(stringBuilder2 + "_thumb"));
        } else {
            try {
                InputStream fileInputStream = new FileInputStream(stringBuilder2);
                wXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(fileInputStream, 1.0f, 0, 0));
                fileInputStream.close();
            } catch (Throwable e) {
                v.a("MicroMsg.ChattingEditModeLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
        l.a(wXMediaMessage, cVar.field_app_id, null, str, 1, cVar.EB());
    }
}
