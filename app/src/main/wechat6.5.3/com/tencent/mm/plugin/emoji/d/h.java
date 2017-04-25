package com.tencent.mm.plugin.emoji.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.b;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.t;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class h implements f {
    public final c rg(String str) {
        return g.afx().fch.NF(str);
    }

    public final c c(c cVar) {
        if (cVar.field_catalog != a.nwK || cVar.field_type != c.nwS || cVar.pO().length() <= 0 || !c.vk(be.getInt(cVar.pO(), 0))) {
            return cVar;
        }
        Cursor vm = g.afx().fch.vm(be.getInt(cVar.pO(), 0));
        int cW = be.cW(vm.getCount() - 1, 0);
        cVar = new c();
        vm.moveToPosition(cW);
        cVar.b(vm);
        vm.close();
        return cVar;
    }

    public final boolean a(Context context, c cVar, int i, String str) {
        if (context == null) {
            v.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            return false;
        } else if (cVar == null) {
            v.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", cVar.EB());
            intent.putExtra("extra_scence", i);
            intent.addFlags(65536);
            intent.putExtra("extra_username", str);
            context.startActivity(intent);
            return true;
        }
    }

    public final void a(Context context, at atVar) {
        if (context == null || atVar == null) {
            v.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            return;
        }
        ag Mv = ag.Mv(atVar.field_content);
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
        if (dV == null) {
            dV = new com.tencent.mm.q.a.a();
            dV.cod = Mv.aZy;
        }
        c NF = g.afx().fch.NF(dV.cod);
        long j;
        if (atVar.field_isSend == 1) {
            if (NF == null || !NF.bxE()) {
                j = atVar.field_msgId;
                d(dV);
                return;
            }
            a(context, dV.cod, dV.appId, dV.appName, atVar.field_msgSvrId, atVar.field_talker, atVar.field_content);
        } else if (NF == null || !NF.bxE()) {
            j = atVar.field_msgId;
            d(dV);
        } else {
            a(context, NF.EB(), dV.appId, dV.appName, atVar.field_msgSvrId, atVar.field_talker, atVar.field_content);
        }
    }

    public final boolean l(Context context, String str, String str2) {
        if (context == null) {
            v.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            return false;
        } else if (be.kS(str) || be.kS(str2)) {
            v.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            return false;
        } else {
            c NF = g.afx().fch.NF(str2);
            if (NF == null) {
                v.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[]{str2});
                return false;
            }
            if (NF.field_type == c.nwW || NF.field_type == c.nwX) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wY()).append(NF.EB()).toString();
                if (e.aR(stringBuilder2 + "_thumb")) {
                    wXMediaMessage.thumbData = e.c(stringBuilder2 + "_thumb", 0, e.aQ(stringBuilder2 + "_thumb"));
                } else {
                    wXMediaMessage.setThumbImage(NF.eg(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                l.a(wXMediaMessage, NF.field_app_id, null, str, 0, NF.EB());
            } else {
                c cVar;
                if (NF.field_type == c.nwS) {
                    Cursor vm = c.vk(NF.field_catalog) ? g.afx().fch.vm(NF.field_catalog) : (NF.field_catalog == c.nwN && NF.pO().length() > 0 && c.vk(be.getInt(NF.pO(), 0))) ? g.afx().fch.vm(be.getInt(NF.pO(), 0)) : null;
                    if (vm != null) {
                        int cW = be.cW(vm.getCount() - 1, 0);
                        cVar = new c();
                        vm.moveToPosition(cW);
                        cVar.b(vm);
                        vm.close();
                        g.afr().a(str, cVar, null);
                    }
                }
                cVar = NF;
                g.afr().a(str, cVar, null);
            }
            return true;
        }
    }

    public final void a(String str, c cVar, at atVar) {
        if (cVar != null || atVar != null) {
            if (cVar == null) {
                cVar = g.afx().fch.NF(atVar.field_imgPath);
            }
            g.afr().a(str, cVar, atVar);
        }
    }

    private static void a(Context context, String str, String str2, String str3, long j, String str4, String str5) {
        if (str.equals("-1")) {
            v.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        c NF = g.afx().fch.NF(str);
        if (NF == null) {
            v.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", NF.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j);
        intent.putExtra("msg_content", str5);
        if (m.dE(str4)) {
            str4 = aw.fL(str5);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
    }

    private static void d(com.tencent.mm.q.a.a aVar) {
        g.afA();
        if (aVar == null) {
            v.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            return;
        }
        String str = aVar.cod;
        if (be.kS(str)) {
            v.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            return;
        }
        c cVar = new c();
        cVar.field_md5 = str;
        cVar.field_app_id = aVar.appId;
        cVar.field_catalog = c.nwM;
        cVar.field_size = aVar.cob;
        cVar.field_temp = 1;
        cVar.field_state = c.nxc;
        g.afx().fch.q(cVar);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        ak.vy().a(new com.tencent.mm.plugin.emoji.e.e(linkedList), 0);
        b.aq(str, 0);
        v.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", new Object[]{str});
    }

    public final ai bn(String str, String str2) {
        Map q = bf.q(str, "msg");
        if (q == null) {
            v.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            return null;
        }
        ai a = ai.a(q, str2, str, "");
        if (a != null) {
            return a;
        }
        v.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error " + str);
        return null;
    }

    public final c a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5) {
        return g.afx().fch.a(str, str2, i, i2, i3, null, str3, str4, str5, 1);
    }

    public final void d(c cVar) {
        g.afx().fch.r(cVar);
    }

    public final String rh(String str) {
        return EmojiLogic.rh(str);
    }

    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        return EmojiLogic.b(context, wXMediaMessage, str);
    }

    public final boolean ri(String str) {
        return g.afx().fch.ri(str);
    }

    public final boolean aeZ() {
        return EmojiLogic.aeZ();
    }

    public final boolean a(String str, String str2, long j, String str3, d.a aVar) {
        com.tencent.mm.plugin.emoji.model.c afr = g.afr();
        v.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml " + str2);
        ai a = ai.a(bf.q(str2, "msg"), str, str2, str3);
        if (a == null) {
            v.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            a.bmL = j;
            v.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[]{Long.valueOf(j), be.bur()});
            afr.rB(a == null ? null : a.aZD);
            afr.a(a, aVar, !EmojiLogic.rA(j.sU().getValue("C2CEmojiNotAutoDownloadTimeRange")));
        }
        return true;
    }

    public final List<c> rj(String str) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            return (ArrayList) g.afx().fch.rj(str);
        }
        return new ArrayList();
    }

    public final String rk(String str) {
        b afs = g.afs();
        if (afs.faw != null && afs.faw.containsKey(str)) {
            return (String) afs.faw.get(str);
        }
        com.tencent.mm.storage.a.e eVar = g.afx().fcj;
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "md5_lang"});
        Cursor rawQuery = eVar.cie.rawQuery(format, new String[]{str + u.bsY().toLowerCase()});
        if (rawQuery.moveToFirst()) {
            str2 = rawQuery.getString(rawQuery.getColumnIndex("desc"));
        }
        rawQuery.close();
        if (!be.kS(str2)) {
            return str2;
        }
        Cursor rawQuery2 = eVar.cie.rawQuery(format, new String[]{str + "default"});
        if (rawQuery2.moveToFirst()) {
            str2 = rawQuery2.getString(rawQuery2.getColumnIndex("desc"));
        }
        rawQuery2.close();
        return str2;
    }

    public final boolean rl(String str) {
        return g.afx().fci.Nz(str);
    }

    public final ArrayList<String> rm(String str) {
        b afs = g.afs();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int PC = com.tencent.mm.ui.tools.h.PC(str);
        if (PC < afs.fau || PC > afs.fav) {
            v.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            return null;
        }
        if (!(be.kS(str) || afs.faz == null)) {
            String toLowerCase = str.toLowerCase();
            ArrayList arrayList3 = new ArrayList();
            if (afs.fay.containsKey(toLowerCase)) {
                arrayList3.addAll((Collection) afs.fax.get(afs.fay.get(toLowerCase)));
            } else {
                arrayList3.add(toLowerCase);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) afs.faz.get((String) it.next());
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    arrayList.addAll(arrayList4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, afs.faA);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((a) arrayList.get(i)).aZy);
            }
        }
        v.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList2;
    }

    public final String rn(String str) {
        return EmojiLogic.rn(str);
    }

    public final String ro(String str) {
        return EmojiLogic.ro(str);
    }

    public final int rp(String str) {
        return EmojiLogic.rp(str);
    }

    public final String rq(String str) {
        return EmojiLogic.rq(str);
    }

    public final int e(c cVar) {
        if (cVar != null) {
            if (cVar.field_catalog == c.nwP || String.valueOf(c.nwP).equals(cVar.field_groupId)) {
                return 2130838440;
            }
            if (cVar.field_catalog == c.nwQ || String.valueOf(c.nwQ).equals(cVar.field_groupId)) {
                return 2130838110;
            }
        }
        return 0;
    }

    public final int[] f(c cVar) {
        if (cVar != null) {
            if (cVar.field_catalog == c.nwP) {
                return new int[]{2130838442, 2130838443, 2130838441};
            }
            if (cVar.field_catalog == c.nwQ) {
                return new int[]{2130838117, 2130838118, 2130838119, 2130838120};
            }
        }
        return null;
    }

    public final byte[] g(c cVar) {
        return f.aeV().a(cVar);
    }

    public final boolean afa() {
        return (j.sU().getInt("EmotionRewardOption", 0) & 4) == 4;
    }

    public final ArrayList<s> afb() {
        return g.afx().fcp.afb();
    }

    public final ArrayList<String> afc() {
        return g.afx().fcp.afc();
    }

    public final ArrayList<com.tencent.mm.storage.a.u> afd() {
        return g.afx().fcq.afd();
    }

    public final boolean t(ArrayList<s> arrayList) {
        t tVar = g.afx().fcp;
        if (arrayList.size() <= 0) {
            v.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
        } else {
            long er;
            com.tencent.mm.bg.g gVar;
            if (tVar.cie instanceof com.tencent.mm.bg.g) {
                com.tencent.mm.bg.g gVar2 = (com.tencent.mm.bg.g) tVar.cie;
                er = gVar2.er(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                er = -1;
                gVar = null;
            }
            tVar.cie.delete("SmileyInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tVar.b((s) it.next());
            }
            int i = -1;
            if (gVar != null) {
                i = gVar.es(er);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean u(ArrayList<com.tencent.mm.storage.a.u> arrayList) {
        com.tencent.mm.storage.a.v vVar = g.afx().fcq;
        if (arrayList.size() <= 0) {
            v.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long er;
            com.tencent.mm.bg.g gVar;
            if (vVar.cie instanceof com.tencent.mm.bg.g) {
                com.tencent.mm.bg.g gVar2 = (com.tencent.mm.bg.g) vVar.cie;
                er = gVar2.er(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                er = -1;
                gVar = null;
            }
            vVar.cie.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                vVar.b((com.tencent.mm.storage.a.u) it.next());
            }
            int i = -1;
            if (gVar != null) {
                i = gVar.es(er);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final com.tencent.mm.storage.c rd(String str) {
        a.aeQ();
        return a.rd(str);
    }

    public final String a(com.tencent.mm.storage.c cVar, String str) {
        a.aeQ();
        return a.a(cVar, str);
    }

    public final String bo(String str, String str2) {
        ak.yW();
        return EmojiLogic.A(com.tencent.mm.model.c.wY(), str, str2);
    }

    public final com.tencent.mm.al.f afe() {
        return j.aff().afe();
    }

    public final void rr(String str) {
        Cursor Kp;
        Throwable th;
        Cursor cursor = null;
        if (be.kS(str)) {
            v.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
        }
        if ("sync".equalsIgnoreCase(str)) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noF, Boolean.valueOf(true));
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noK, Boolean.valueOf(true));
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noN, Long.valueOf(0));
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noE, Long.valueOf(0));
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.e(), 0);
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.m(8, null, 15, true), 0);
        } else if ("rcheart".equalsIgnoreCase(str)) {
            g.afx().fci.bxD();
        } else if ("recover".equalsIgnoreCase(str)) {
            v.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
            g.afx().fch.ee(aa.getContext());
            g.afx().fci.ee(aa.getContext());
            v.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        } else if ("clean".equalsIgnoreCase(str)) {
            v.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            e aeU = e.aeU();
            ak.yW();
            aeU.rf(com.tencent.mm.model.c.wY());
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noK, Boolean.valueOf(true));
            v.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        } else if ("dump".equalsIgnoreCase(str)) {
            v.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            ArrayList arrayList = (ArrayList) g.afx().fci.bxo();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    a aVar = (a) arrayList.get(i);
                    v.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[]{Integer.valueOf(i), aVar.toString()});
                }
            }
            try {
                Kp = g.afx().fch.Kp();
                if (Kp != null) {
                    try {
                        if (Kp.moveToFirst()) {
                            do {
                                new c().b(Kp);
                                v.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[]{r1.toString()});
                            } while (Kp.moveToNext());
                        }
                    } catch (Exception e) {
                        if (Kp != null) {
                            Kp.close();
                        }
                        v.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                    } catch (Throwable th2) {
                        cursor = Kp;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (Kp != null) {
                    Kp.close();
                }
            } catch (Exception e2) {
                Kp = null;
                if (Kp != null) {
                    Kp.close();
                }
                v.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            v.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
        } else if ("config".equalsIgnoreCase(str)) {
            ak.vy().a(new com.tencent.mm.pluginsdk.k.a.a.m(37), 0);
        }
    }
}
