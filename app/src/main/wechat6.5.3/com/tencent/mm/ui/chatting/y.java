package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class y {
    private static a omG = new a();

    private static class a {
        bp blL;
        String bmm;
        boolean nQK;
        dq omF;
        List<at> omM;
        d omN;

        private a() {
        }
    }

    static class AnonymousClass4 implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ String cxT;
        final /* synthetic */ Runnable ftq = null;
        final /* synthetic */ boolean omL;
        final /* synthetic */ Context val$context;

        AnonymousClass4(Context context, String str, boolean z, Runnable runnable) {
            this.val$context = context;
            this.cxT = str;
            this.omL = z;
        }

        public final boolean AZ() {
            if (y.omG.omM == null) {
                return false;
            }
            for (at d : y.omG.omM) {
                y.d(this.val$context, this.cxT, d, y.omG.nQK);
            }
            return true;
        }

        public final boolean Ba() {
            if (y.omG.omM != null) {
                g.iuh.h(10811, Integer.valueOf(5), Integer.valueOf(y.omG.omM.size()), Integer.valueOf(y.omG.omM.size() - x.cq(y.omG.omM)));
            }
            if (this.omL) {
                if (this.ftq != null) {
                    v.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                    this.ftq.run();
                }
                if (y.omG.omF != null) {
                    y.omG.omF.xd(com.tencent.mm.ui.chatting.dq.a.oyd);
                }
                y.bEf();
            }
            return true;
        }
    }

    static /* synthetic */ void d(Context context, String str, at atVar, boolean z) {
        if (!x.aa(atVar) && !x.ab(atVar)) {
            if (e.hC(str) && !atVar.bwj() && !atVar.bwm() && !atVar.bwb()) {
                v.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", Integer.valueOf(atVar.field_type));
            } else if (atVar.bwj()) {
                x.b(context, str, atVar);
            } else if (atVar.bwn()) {
                x.c(context, str, atVar);
            } else if (atVar.bwo()) {
                x.c(context, str, atVar);
                r1 = m.dE(str);
                a.a(r1 ? c.Chatroom : c.Chat, a.d.Samll, atVar, r1 ? i.el(str) : 0);
            } else if (atVar.bwm()) {
                x.a(context, str, atVar, z);
            } else if (atVar.bwe() || atVar.bvY()) {
                r1 = m.dE(str);
                a.a(r1 ? c.Chatroom : c.Chat, a.d.Samll, atVar, r1 ? i.el(str) : 0);
                if (atVar.bwq()) {
                    if (x.a(context, str, atVar, "appEmoji")) {
                        ag Mv = ag.Mv(atVar.field_content);
                        com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(atVar.field_content, atVar.field_reserved);
                        if (B == null) {
                            B = new com.tencent.mm.q.a.a();
                            B.cod = Mv.aZy;
                        }
                        if (be.kS(B.cod) || B.cod.equalsIgnoreCase("-1")) {
                            v.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                            return;
                        }
                        v.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", str, B.cod);
                        com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(B.cod);
                        if (rg != null) {
                            x.b(rg, str);
                        } else {
                            v.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", Mv);
                        }
                    }
                } else if (atVar.bvZ() || atVar.bwa()) {
                    try {
                        com.tencent.mm.q.c dZ = com.tencent.mm.q.a.a.dZ(atVar.field_content);
                        List<com.tencent.mm.q.d> list = dZ.cqE;
                        if (list != null) {
                            for (com.tencent.mm.q.d dVar : list) {
                                com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                                aVar.title = dVar.title;
                                aVar.description = dVar.cqK;
                                aVar.bXP = "view";
                                aVar.type = 5;
                                aVar.url = dVar.url;
                                aVar.bnR = dZ.bnR;
                                aVar.bnS = dZ.bnS;
                                aVar.bNm = dZ.bNm;
                                aVar.thumburl = dVar.cqI;
                                if (be.kS(aVar.thumburl)) {
                                    h gQ = n.Bo().gQ(atVar.field_talker);
                                    if (gQ != null) {
                                        aVar.thumburl = gQ.Be();
                                    }
                                }
                                x.a(context, str, com.tencent.mm.q.a.a.b(aVar), atVar.field_isSend, z);
                            }
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.ChattingEditModeLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", e.getLocalizedMessage());
                    }
                } else {
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_isSend == 0 ? aw.fM(atVar.field_content) : atVar.field_content);
                    if (dV == null) {
                        v.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                        return;
                    }
                    f aC = com.tencent.mm.pluginsdk.model.app.g.aC(dV.appId, false);
                    if (aC != null && aC.bnk()) {
                        v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    } else if (dV.type == 19) {
                        b kwVar = new kw();
                        kwVar.bmf.type = 4;
                        kwVar.bmf.bmk = atVar;
                        kwVar.bmf.toUser = str;
                        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
                    } else {
                        if (dV.type == 5 && !be.kS(dV.url)) {
                            String str2 = SQLiteDatabase.KeyEmpty;
                            try {
                                str2 = URLEncoder.encode(dV.url, "UTF-8");
                            } catch (Throwable e2) {
                                v.a("MicroMsg.ChattingEditModeRetransmitMsg", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                            long Nh = be.Nh();
                            v.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), dV.url, Long.valueOf(Nh), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                            g.iuh.h(13378, str2, Long.valueOf(Nh), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                        }
                        x.b(context, str, atVar, z);
                    }
                }
            } else if (atVar.bwk()) {
                if (x.a(context, str, atVar, "friendcard")) {
                    com.tencent.mm.pluginsdk.j.a.bmt().x(str, x.m(atVar.field_content, atVar.field_isSend, z), 42);
                }
            } else if (atVar.bwp() || atVar.bwq()) {
                if (!x.X(atVar)) {
                    x.a(context, str, atVar);
                }
            } else if (atVar.bwl()) {
                x.c(context, str, atVar, z);
            }
        }
    }

    public static void a(Context context, List<at> list, boolean z, String str, dq dqVar) {
        bEf();
        if (context == null) {
            v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
        } else if (list == null || list.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
        } else if (x.cp(list)) {
            b(context, list, z, str, dqVar);
        } else {
            final List<at> list2 = list;
            final dq dqVar2 = dqVar;
            final Context context2 = context;
            final boolean z2 = z;
            final String str2 = str;
            com.tencent.mm.ui.base.g.b(context, context.getString(2131233302), SQLiteDatabase.KeyEmpty, context.getString(2131234555), context.getString(2131231010), (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Object obj;
                    List<at> list = list2;
                    if (list != null && !list.isEmpty()) {
                        for (at atVar : list) {
                            if (!atVar.bwb() && !x.X(atVar) && !x.Z(atVar) && !x.af(atVar) && !x.aa(atVar) && atVar.field_type != -1879048186 && !x.ae(atVar) && !x.ab(atVar) && atVar.field_type != 318767153) {
                                obj = null;
                                break;
                            }
                        }
                    } else {
                        v.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
                    }
                    obj = 1;
                    if (obj != null) {
                        v.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
                        if (dqVar2 != null) {
                            dqVar2.xd(com.tencent.mm.ui.chatting.dq.a.oyd);
                            return;
                        }
                        return;
                    }
                    y.b(context2, list2, z2, str2, dqVar2);
                }
            }, null);
        }
    }

    private static void b(Context context, List<at> list, boolean z, String str, final dq dqVar) {
        if (x.cs(list)) {
            com.tencent.mm.ui.base.g.a(context, context.getString(2131232227), SQLiteDatabase.KeyEmpty, context.getString(2131230747), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dqVar != null) {
                        dq dqVar = dqVar;
                        int i2 = com.tencent.mm.ui.chatting.dq.a.oyd;
                        dqVar.bEM();
                    }
                }
            });
        } else if (x.cr(list)) {
            com.tencent.mm.ui.base.g.a(context, context.getString(2131232229), SQLiteDatabase.KeyEmpty, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (dqVar != null) {
                        dq dqVar = dqVar;
                        int i2 = com.tencent.mm.ui.chatting.dq.a.oyd;
                        dqVar.bEM();
                    }
                }
            }, null);
        } else {
            omG.omM = new LinkedList(list);
            omG.nQK = z;
            omG.omF = dqVar;
            omG.bmm = str;
            int i = 2;
            Intent intent = new Intent(context, MsgRetransmitUI.class);
            if (list.size() == 1) {
                String str2;
                int i2;
                at atVar = (at) list.get(0);
                if (atVar.bvY() || atVar.bvZ() || atVar.bwa()) {
                    String fz = o.fz(atVar.field_msgSvrId);
                    o.b n = o.yx().n(fz, true);
                    n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
                    n.l("preUsername", ad.a(atVar, z, false));
                    n.l("preChatName", atVar.field_talker);
                    n.l("preMsgIndex", Integer.valueOf(0));
                    n.l("sendAppMsgScene", Integer.valueOf(1));
                    n.l("moreRetrAction", Boolean.valueOf(true));
                    if (z) {
                        n.l("fromScene", Integer.valueOf(2));
                    } else {
                        n.l("fromScene", Integer.valueOf(1));
                    }
                    com.tencent.mm.modelstat.o.a("adExtStr", n, atVar);
                    intent.putExtra("reportSessionId", fz);
                }
                String str3 = atVar.field_content;
                int i3 = 12;
                if (atVar.bwl()) {
                    i3 = 9;
                    str2 = str3;
                } else if (atVar.bwp()) {
                    i3 = 5;
                    intent.putExtra("Retr_File_Name", atVar.field_imgPath);
                    str2 = str3;
                } else if (atVar.bwk()) {
                    i3 = 8;
                    str2 = str3;
                } else {
                    if (atVar.bwm()) {
                        i3 = 4;
                        if (z && atVar.field_isSend == 0) {
                            str2 = aw.fM(str3);
                        }
                    } else if (atVar.bwj()) {
                        com.tencent.mm.ae.d dVar = null;
                        if (atVar.field_msgId > 0) {
                            dVar = com.tencent.mm.ae.n.GH().ai(atVar.field_msgId);
                        }
                        if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                            dVar = com.tencent.mm.ae.n.GH().ah(atVar.field_msgSvrId);
                        }
                        intent.putExtra("Retr_File_Name", com.tencent.mm.ae.n.GH().l(com.tencent.mm.ae.e.c(dVar), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                        i3 = 0;
                        str2 = str3;
                    } else if (atVar.bwo()) {
                        r1 = p.lp(atVar.field_imgPath);
                        if (r1 != null) {
                            intent.putExtra("Retr_length", r1.dhK);
                        }
                        i3 = 11;
                        intent.putExtra("Retr_File_Name", atVar.field_imgPath);
                        str2 = str3;
                    } else if (atVar.bwn()) {
                        r1 = p.lp(atVar.field_imgPath);
                        if (r1 != null) {
                            intent.putExtra("Retr_length", r1.dhK);
                        }
                        i3 = 1;
                        intent.putExtra("Retr_File_Name", atVar.field_imgPath);
                        str2 = str3;
                    } else if (atVar.bvY()) {
                        i3 = 2;
                        if (atVar.bvZ() || atVar.bwa()) {
                            intent.putExtra("is_group_chat", z);
                        }
                    }
                    str2 = str3;
                }
                if (atVar.bvZ()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                intent.putExtra("Retr_Msg_Type", i3);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                intent.putExtra("Retr_Msg_content", str2);
                intent.putExtra("Edit_Mode_Sigle_Msg", true);
                i = i2;
            } else if ((dqVar == null || !dqVar.bEN()) && ((!m.eD(str) || e.hC(str)) && !m.fo(str))) {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            } else {
                intent.putExtra("Retr_Msg_Type", 12);
            }
            intent.putExtra("Retr_MsgFromScene", i);
            intent.putExtra("Retr_show_success_tips", true);
            context.startActivity(intent);
        }
    }

    public static void j(Context context, String str, boolean z) {
        b kwVar = new kw();
        kwVar.bmf.type = 5;
        kwVar.bmf.bml = omG.omM;
        kwVar.bmf.toUser = str;
        kwVar.bmf.bmm = omG.bmm;
        kwVar.bmf.context = context;
        kwVar.bmf.blL = omG.blL;
        kwVar.bmf.bmo = omG.omN;
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        if (omG.omM != null) {
            g.iuh.h(10811, Integer.valueOf(8), Integer.valueOf(omG.omM.size()), Integer.valueOf(omG.omM.size() - x.cq(omG.omM)));
            for (at atVar : omG.omM) {
                long Nh = be.Nh();
                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(atVar.field_content));
                if (!(dV == null || dV.type != 5 || be.kS(dV.url))) {
                    int i;
                    if (atVar.bvZ()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = SQLiteDatabase.KeyEmpty;
                    try {
                        str2 = URLEncoder.encode(dV.url, "UTF-8");
                    } catch (Throwable e) {
                        v.a("MicroMsg.ChattingEditModeRetransmitMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    v.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), dV.url, Long.valueOf(Nh), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                    g.iuh.h(13378, str2, Long.valueOf(Nh), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        if (z && omG.omF != null) {
            omG.omF.xd(com.tencent.mm.ui.chatting.dq.a.oyd);
        }
    }

    public static void jF(boolean z) {
        if (z && omG.omF != null) {
            omG.omF.xd(com.tencent.mm.ui.chatting.dq.a.oyd);
        }
    }

    public static kw eB(Context context) {
        b kwVar = new kw();
        kwVar.bmf.type = 6;
        kwVar.bmf.bml = omG.omM;
        kwVar.bmf.bmm = omG.bmm;
        kwVar.bmf.context = context;
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        omG.blL = kwVar.bmg.blL;
        omG.omN = kwVar.bmg.bmo;
        return kwVar;
    }

    public static void k(Context context, String str, boolean z) {
        if (context == null) {
            v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
        } else if (be.kS(str)) {
            v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
        } else if (omG.omM == null || omG.omM.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
        } else {
            v.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", str);
            ct.orh.c(new AnonymousClass4(context, str, z, null));
        }
    }

    public static void bEf() {
        omG.omM = null;
        omG.nQK = false;
        omG.omF = null;
        omG.bmm = null;
        omG.blL = null;
        omG.omN = null;
    }
}
