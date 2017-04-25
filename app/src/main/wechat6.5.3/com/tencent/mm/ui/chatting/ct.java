package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.wework.api.WWAPIFactory;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class ct implements dq {
    public static ap orh = new ap(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private u bhV;
    p eSv;
    Animation iVP;
    private l khn;
    private boolean nQK;
    a omY;
    cp omZ;
    private ChatFooter ona;
    boolean onc = false;
    boolean oqD = false;
    ChattingFooterMoreBtnBar ori;
    cv orj;
    private ChatFooterCustom ork;
    private boolean orl = true;

    static /* synthetic */ List e(ct ctVar) {
        List linkedList = new LinkedList();
        for (Long longValue : ctVar.omZ.oqG) {
            v.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", Long.valueOf(longValue.longValue()));
            ak.yW();
            linkedList.add(c.wJ().ek(r4));
        }
        Collections.sort(linkedList, new Comparator<at>(ctVar) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return (int) (((at) obj).field_createTime - ((at) obj2).field_createTime);
            }
        });
        return linkedList;
    }

    public ct(a aVar, ChattingFooterMoreBtnBar chattingFooterMoreBtnBar, cp cpVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, u uVar, boolean z) {
        this.omY = aVar;
        this.ori = chattingFooterMoreBtnBar;
        this.ona = chatFooter;
        this.ork = chatFooterCustom;
        this.omZ = cpVar;
        b(uVar, z);
        this.iVP = AnimationUtils.loadAnimation(aVar.nDR.nEl, 2130968646);
        if (this.onc) {
            v.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        } else {
            this.eSv = new p(true, true);
            this.eSv.oUs = new b(this) {
                final /* synthetic */ ct orm;

                {
                    this.orm = r1;
                }

                public final void ml(String str) {
                    v.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
                    if (!be.kS(str)) {
                        v.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                        this.orm.ori.setVisibility(8);
                        this.orm.omY.bFB();
                        if (this.orm.orj != null) {
                            this.orm.orj.uU(str);
                        }
                    } else if (this.orm.omY.oui) {
                        if (this.orm.orj != null) {
                            this.orm.orj.uU(SQLiteDatabase.KeyEmpty);
                        }
                        this.orm.omY.xk(-1);
                    } else if (this.orm.oqD) {
                        this.orm.omY.bFC();
                        this.orm.ori.setVisibility(0);
                        this.orm.ori.xa(this.orm.omZ.oqG.size());
                    } else {
                        this.orm.omY.bFC();
                        this.orm.ori.setVisibility(8);
                    }
                }

                public final void Of() {
                    v.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
                    if (this.orm.omZ.oqD) {
                        this.orm.omY.bFC();
                        this.orm.ori.setVisibility(0);
                        this.orm.ori.xa(this.orm.omZ.oqG.size());
                    }
                }

                public final void Og() {
                    v.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
                    g.iuh.a(219, 21, 1, true);
                    if (this.orm.omZ.oqD) {
                        this.orm.omY.bFB();
                        this.orm.ori.setVisibility(8);
                    }
                }

                public final boolean mk(String str) {
                    return false;
                }

                public final void Oh() {
                }
            };
        }
        this.ori.c(3, new OnClickListener(this) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            public final void onClick(View view) {
                if (this.orm.omZ.oqG.size() == 0) {
                    v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                final Context context = this.orm.omY.nDR.nEl;
                com.tencent.mm.ui.base.g.a(context, context.getString(2131231970), SQLiteDatabase.KeyEmpty, context.getString(2131232281), context.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 orn;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                        w.a(context, this.orn.orm.omZ.oqG, this.orn.orm);
                        this.orn.orm.bEK();
                    }
                }, null, 2131689512);
            }
        });
        this.ori.c(2, new OnClickListener(this) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            public final void onClick(View view) {
                if (this.orm.omZ.oqG.size() == 0) {
                    v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else {
                    z.a(this.orm.omY, ct.e(this.orm), this.orm.nQK, this.orm, this.orm.bhV);
                }
            }
        });
        this.ori.c(1, new OnClickListener(this) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            public final void onClick(View view) {
                if (this.orm.omZ.oqG.size() == 0) {
                    v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                List e = ct.e(this.orm);
                if (x.cs(e)) {
                    com.tencent.mm.ui.base.g.a(this.orm.omY.nDR.nEl, this.orm.omY.nDR.nEl.getString(2131232227), SQLiteDatabase.KeyEmpty, this.orm.omY.nDR.nEl.getString(2131230747), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 oro;

                        {
                            this.oro = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (x.ct(e)) {
                    com.tencent.mm.ui.base.g.a(this.orm.omY.nDR.nEl, this.orm.omY.nDR.nEl.getString(2131232228), SQLiteDatabase.KeyEmpty, this.orm.omY.nDR.nEl.getString(2131230747), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 oro;

                        {
                            this.oro = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (x.cr(e)) {
                    com.tencent.mm.ui.base.g.a(this.orm.omY.nDR.nEl, this.orm.omY.nDR.nEl.getString(2131232229), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 oro;

                        {
                            this.oro = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, null);
                } else if (aa.a(this.orm.omY, e, this.orm.bhV)) {
                    this.orm.bEK();
                }
            }
        });
        this.ori.c(0, new OnClickListener(this) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            public final void onClick(View view) {
                if (this.orm.omZ.oqG.size() == 0) {
                    v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else if ((!m.eD(this.orm.bhV.field_username) || e.hC(this.orm.bhV.field_username)) && !m.fo(this.orm.bhV.field_username)) {
                    this.orm.khn.b(view, new OnCreateContextMenuListener(this) {
                        final /* synthetic */ AnonymousClass5 orp;

                        {
                            this.orp = r1;
                        }

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 0, 0, 2131233905);
                            contextMenu.add(0, 1, 1, 2131233906);
                            if (WWAPIFactory.gC(this.orp.orm.omY.nDR.nEl).bPT()) {
                                contextMenu.add(0, 2, 2, 2131233907);
                            }
                        }
                    }, new d(this) {
                        final /* synthetic */ AnonymousClass5 orp;

                        {
                            this.orp = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            if (menuItem.getItemId() == 0) {
                                this.orp.orm.orl = true;
                            } else if (2 == menuItem.getItemId()) {
                                Context context = this.orp.orm.omY.nDR.nEl;
                                u g = this.orp.orm.bhV;
                                List e = ct.e(this.orp.orm);
                                boolean f = this.orp.orm.nQK;
                                if (e.size() != 0) {
                                    if (x.cr(e)) {
                                        v.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                                        com.tencent.mm.ui.base.g.a(context, context.getString(2131232230), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        }, null);
                                    } else if (x.cp(e)) {
                                        dz.a(context, g, e, f);
                                    } else {
                                        v.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                                        com.tencent.mm.ui.base.g.b(context, context.getString(2131233302), SQLiteDatabase.KeyEmpty, context.getString(2131234555), context.getString(2131231010), new com.tencent.mm.ui.chatting.dz.AnonymousClass2(context, g, e, f), null);
                                    }
                                }
                                this.orp.orm.bEK();
                                return;
                            } else {
                                this.orp.orm.orl = false;
                            }
                            y.a(this.orp.orm.omY.nDR.nEl, ct.e(this.orp.orm), this.orp.orm.nQK, this.orp.orm.bhV.field_username, this.orp.orm);
                        }
                    });
                } else {
                    this.orm.orl = true;
                    y.a(this.orm.omY.nDR.nEl, ct.e(this.orm), this.orm.nQK, this.orm.bhV.field_username, this.orm);
                }
            }
        });
        this.ori.c(4, new OnClickListener(this) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            private void a(bp bpVar) {
                int i;
                bpVar.aZd.og = this.orm.omY;
                bpVar.aZd.aZl = 41;
                bpVar.aZd.aZn = new com.tencent.mm.ui.snackbar.b.c(this) {
                    final /* synthetic */ AnonymousClass6 orq;

                    {
                        this.orq = r1;
                    }

                    public final void aEU() {
                        this.orq.orm.bEK();
                        this.orq.orm.ori.setVisibility(4);
                    }

                    public final void onHide() {
                        this.orq.orm.bEK();
                    }

                    public final void blD() {
                        this.orq.orm.omY.bFa();
                    }
                };
                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                if (bpVar.aZe.ret == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
                List<at> e = ct.e(this.orm);
                long Nh = be.Nh();
                for (at atVar : e) {
                    if (atVar.bvY()) {
                        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(atVar.field_content));
                        if (!(dV == null || dV.type != 5 || be.kS(dV.url))) {
                            int i2;
                            if (atVar.bvZ()) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            v.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), dV.url, Long.valueOf(Nh), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1));
                            String str = SQLiteDatabase.KeyEmpty;
                            try {
                                str = URLEncoder.encode(dV.url, "UTF-8");
                            } catch (Throwable e2) {
                                v.a("MicroMsg.ChattingMoreBtnBarHelper", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                            g.iuh.h(13378, str, Long.valueOf(Nh), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i));
                        }
                    }
                }
                if (bpVar.aZe.ret != 0) {
                    return;
                }
                if (14 != bpVar.aZd.type) {
                    v.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                } else if (bpVar.aZd.aZg == null) {
                    v.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                } else {
                    g.iuh.h(11142, Integer.valueOf(bpVar.aZd.aZg.muc), Integer.valueOf(bpVar.aZd.aZg.mud), Integer.valueOf(bpVar.aZd.aZg.mue), Integer.valueOf(bpVar.aZd.aZg.muf), Integer.valueOf(bpVar.aZd.aZg.mug), Integer.valueOf(bpVar.aZd.aZg.muh), Integer.valueOf(bpVar.aZd.aZg.mui), Integer.valueOf(bpVar.aZd.aZg.muj), Integer.valueOf(bpVar.aZd.aZg.muk), Integer.valueOf(bpVar.aZd.aZg.mul), Integer.valueOf(bpVar.aZd.aZg.mum), Integer.valueOf(bpVar.aZd.aZg.mun), Integer.valueOf(bpVar.aZd.aZg.muo), Integer.valueOf(bpVar.aZd.aZg.mup), Integer.valueOf(bpVar.aZd.aZg.muq));
                }
            }

            public final void onClick(View view) {
                final List<at> e = ct.e(this.orm);
                if (x.cs(e)) {
                    com.tencent.mm.ui.base.g.a(this.orm.omY.nDR.nEl, this.orm.omY.nDR.nEl.getString(2131232664), SQLiteDatabase.KeyEmpty, this.orm.omY.nDR.nEl.getString(2131230747), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass6 orq;

                        {
                            this.orq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                at atVar;
                final bp bpVar = new bp();
                v.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", this.orm.bhV.field_username);
                if (e.size() == 1) {
                    atVar = (at) e.get(0);
                    if (atVar != null && (atVar.bvY() || atVar.bvZ() || atVar.bwa())) {
                        String fz = o.fz(atVar.field_msgSvrId);
                        o.b n = o.yx().n(fz, true);
                        n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
                        n.l("preUsername", ad.a(atVar, this.orm.nQK, this.orm.omY.lKa));
                        n.l("preChatName", this.orm.bhV.field_username);
                        n.l("preMsgIndex", Integer.valueOf(0));
                        n.l("sendAppMsgScene", Integer.valueOf(1));
                        com.tencent.mm.modelstat.o.a("adExtStr", n, atVar);
                        bpVar.aZd.aZj = fz;
                    }
                }
                if (com.tencent.mm.pluginsdk.model.e.a(this.orm.omY.nDR.nEl, bpVar, this.orm.bhV.field_username, e, false)) {
                    for (at atVar2 : e) {
                        com.tencent.mm.modelstat.b.daJ.q(atVar2);
                    }
                    a(bpVar);
                    AnonymousClass6.cu(ct.e(this.orm));
                } else if (ct.e(this.orm).size() > 1) {
                    com.tencent.mm.ui.base.g.a(this.orm.omY.nDR.nEl, 2131232663, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass6 orq;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            for (at atVar : e) {
                                if (!atVar.bwq() && !atVar.bwp()) {
                                    if (bpVar.aZd.type == 14 && bpVar.aZd.aZf.mtR.size() == 0) {
                                        this.orq.orm.bEK();
                                        return;
                                    }
                                    this.orq.a(bpVar);
                                    AnonymousClass6.cu(ct.e(this.orq.orm));
                                    return;
                                }
                            }
                        }
                    }, null);
                } else {
                    com.tencent.mm.ui.base.g.f(this.orm.omY.nDR.nEl, bpVar.aZd.aZk, 0);
                }
            }

            private static void cu(List<at> list) {
                for (at a : list) {
                    a.a(a.c.Fav, a.d.Samll, a, 0);
                }
            }
        });
        this.omZ.oqQ = new OnClickListener(this) {
            final /* synthetic */ ct orm;

            {
                this.orm = r1;
            }

            public final void onClick(View view) {
                if (this.orm.omZ.ew(((Long) view.getTag()).longValue())) {
                    int size = this.orm.omZ.oqG.size();
                    this.orm.omY.bFC();
                    this.orm.eSv.bJs();
                    this.orm.ori.setVisibility(0);
                    this.orm.ori.xa(size);
                }
            }
        };
        this.khn = new l(this.omY.nDR.nEl);
    }

    public final void b(u uVar, boolean z) {
        this.bhV = uVar;
        this.nQK = z;
    }

    public final void bEK() {
        this.omY.a(false, this.eSv);
        this.ori.setVisibility(8);
        this.omZ.amG();
        this.omY.bFC();
        this.oqD = false;
        this.omY.bFt();
        this.omY.bGc();
        this.omY.bFs();
        this.omY.ale();
        y.bEf();
    }

    public final void bEL() {
        if (this.eSv != null) {
            this.eSv.bJs();
        }
    }

    public final void bEM() {
        bEK();
    }

    public final void xd(int i) {
        bEK();
    }

    public final boolean bEN() {
        return this.orl;
    }
}
