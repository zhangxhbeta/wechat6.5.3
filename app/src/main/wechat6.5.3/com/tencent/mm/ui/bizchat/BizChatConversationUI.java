package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.f;
import com.tencent.mm.model.l;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI;
import com.tencent.mm.ui.conversation.EnterpriseFullHeightListView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.m;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;

public class BizChatConversationUI extends BaseConversationUI {
    private View dtW;

    public static class a extends b implements k, j.b {
        private String cCn;
        private p dwg;
        private TextView euo;
        private d eus;
        private boolean eut = false;
        private m eyM;
        private long ezh;
        private String ezn;
        private boolean nAV;
        private b ohA;
        private com.tencent.mm.modelbiz.a.j ohB;
        private boolean ohC = true;
        private int ohD = 0;
        private boolean ohE = false;
        private com.tencent.mm.modelbiz.a.b.a ohF = new com.tencent.mm.modelbiz.a.b.a(this) {
            final /* synthetic */ a ohI;

            {
                this.ohI = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.b.a.b bVar) {
                if (bVar != null && bVar.cDG != null && this.ohI.ezn.equals(bVar.cDG.field_brandUserName)) {
                    v.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
                    this.ohI.ohA.eu(bVar.cDF);
                    if (this.ohI.nAV) {
                        this.ohI.ohA.Ol();
                    }
                    ak.vA().x(new Runnable(this.ohI, bVar.cDF, bVar.cDG.field_brandUserName) {
                        final /* synthetic */ a ohI;

                        public final void run() {
                            c Z = u.DA().Z(r4);
                            if (!Z.DO()) {
                                return;
                            }
                            if (Z.DN()) {
                                u.DE();
                                h.b(Z.field_bizChatServId, r3, false);
                                return;
                            }
                            u.DE();
                            h.a(Z.field_bizChatServId, r3, null);
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(Z.field_bizChatServId);
                            a.a(this.ohI, linkedList);
                        }
                    });
                }
            }
        };
        private com.tencent.mm.modelbiz.a.d.a ohG = new com.tencent.mm.modelbiz.a.d.a(this) {
            final /* synthetic */ a ohI;

            {
                this.ohI = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.d.a.b bVar) {
                if (bVar != null && bVar.cDQ != null && this.ohI.ezn.equals(bVar.cDQ.field_brandUserName)) {
                    v.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
                    this.ohI.ohA.eu(bVar.cDF);
                    if (this.ohI.nAV) {
                        this.ohI.ohA.Ol();
                    }
                    ak.vA().x(/* anonymous class already generated */);
                }
            }
        };
        private com.tencent.mm.modelbiz.c.a ohH = new com.tencent.mm.modelbiz.c.a(this) {
            final /* synthetic */ a ohI;

            {
                this.ohI = r1;
            }

            public final void a(com.tencent.mm.modelbiz.c.a.a aVar) {
                String p = this.ohI.bDw();
                if (aVar != null && !be.kS(aVar.cBj) && aVar.cBj.equals(p)) {
                    boolean q = this.ohI.ohE;
                    this.ohI.ohE = u.DF().hf(p);
                    if (this.ohI.ohE != q) {
                        this.ohI.bDu();
                    }
                }
            }
        };
        private View ohw;
        private ImageButton ohx = null;
        private EnterpriseFullHeightListView ohy;
        private int ohz;

        static /* synthetic */ void a(a aVar, final long j) {
            v.i("MicroMsg.BizChatConversationFmUI", "deleteChatroom");
            u.DA().Z(j);
            aVar.eut = false;
            Context bzo = aVar.bzo();
            aVar.getString(2131231164);
            aVar.dwg = g.a(bzo, aVar.getString(2131231182), true, new OnCancelListener(aVar) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.ohI.eut = true;
                }
            });
            f.a(aVar.ezn, j, new com.tencent.mm.model.aw.a(aVar) {
                final /* synthetic */ a ohI;

                public final boolean zp() {
                    return this.ohI.eut;
                }

                public final void zo() {
                    int i = 0;
                    if (this.ohI.dwg != null) {
                        u.DA().U(j);
                        u.DB().U(j);
                        com.tencent.mm.modelbiz.a.b DB = u.DB();
                        String a = this.ohI.ezn;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("select count(*) from BizChatConversation");
                        stringBuilder.append(" where brandUserName = '").append(a).append("' ");
                        Cursor rawQuery = DB.cie.rawQuery(stringBuilder.toString(), null);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                i = rawQuery.getInt(0);
                            }
                            rawQuery.close();
                        }
                        if (i <= 0) {
                            ak.yW();
                            com.tencent.mm.model.c.wK().Mf(this.ohI.ezn);
                        }
                        this.ohI.dwg.dismiss();
                    }
                }
            });
        }

        static /* synthetic */ void a(a aVar, LinkedList linkedList) {
            if (linkedList.size() == 0) {
                v.i("MicroMsg.BizChatConversationFmUI", "userIdList is empty");
                return;
            }
            SharedPreferences NV = aVar.NV(aa.bti());
            if (NV.getBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + aVar.ezn, true)) {
                v.i("MicroMsg.BizChatConversationFmUI", "updateData");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.sdk.h.d dVar = u.DC().cie;
                long j = 0;
                if (dVar instanceof com.tencent.mm.bg.g) {
                    j = ((com.tencent.mm.bg.g) dVar).er(Thread.currentThread().getId());
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    c hR = u.DA().hR(str);
                    if (!(hR == null || hR.DN())) {
                        com.tencent.mm.modelbiz.a.j ig = u.DC().ig(str);
                        str = ig != null ? ig.field_userName : null;
                        if (!(str == null || str.equals(hR.field_chatName))) {
                            hR.field_chatName = str;
                            u.DA().b(hR);
                        }
                    }
                }
                if (dVar instanceof com.tencent.mm.bg.g) {
                    ak.yW();
                    com.tencent.mm.model.c.wE().es(j);
                }
                NV.edit().putBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + aVar.ezn, false).commit();
                v.d("MicroMsg.BizChatConversationFmUI", "updateData use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }

        static /* synthetic */ void g(a aVar) {
            if (be.kS(aVar.cCn)) {
                aVar.cCn = u.Dy().ho(aVar.ezn).CF();
            }
            if (be.kS(aVar.cCn)) {
                v.e("MicroMsg.BizChatConversationFmUI", "GO_TO_FARTHER belong is null");
                return;
            }
            Intent intent = new Intent(aVar.bzo(), EnterpriseConversationUI.class);
            intent.putExtra("enterprise_from_scene", 6);
            intent.putExtra("enterprise_biz_name", aVar.cCn);
            intent.putExtra("enterprise_biz_display_name", l.er(aVar.cCn));
            intent.addFlags(67108864);
            aVar.startActivity(intent);
        }

        static /* synthetic */ void k(a aVar) {
            aVar.ohB = u.DC().ig(u.DC().ii(aVar.ezn));
            if (aVar.ohB == null || be.kS(aVar.ohB.field_addMemberUrl)) {
                Toast.makeText(aVar.bzo(), aVar.getString(2131231495), 0).show();
                aVar.bDv();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aVar.ohB.field_addMemberUrl);
            v.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", aVar.ohB.field_addMemberUrl);
            intent.putExtra("useJs", true);
            intent.addFlags(67108864);
            com.tencent.mm.ay.c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent, 1);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.ezn = bzo().getIntent().getStringExtra("Contact_User");
            v.i("MicroMsg.BizChatConversationFmUI", "[regitListener]");
            u.DB().a(this.ohF, bzo().getMainLooper());
            u.DA().a(this.ohG, bzo().getMainLooper());
            u.DF().a(this.ohH, bzo().getMainLooper());
            ak.yW();
            com.tencent.mm.model.c.wK().a(this);
            this.euo = (TextView) findViewById(2131756760);
            this.euo.setText(2131233714);
            this.ohy = (EnterpriseFullHeightListView) findViewById(2131756759);
            if (com.tencent.mm.bd.a.dt(this.nDR.nEl)) {
                this.ohw = View.inflate(this.nDR.nEl, 2130903535, null);
            } else {
                this.ohw = View.inflate(this.nDR.nEl, 2130903534, null);
            }
            this.ohy.addHeaderView(this.ohw);
            this.ohy.bIp();
            this.ohz = (int) getResources().getDimension(2131493147);
            this.ohE = u.DF().hf(bDw());
            TextView textView = (TextView) this.ohw.findViewById(2131755456);
            ((ImageView) this.ohw.findViewById(2131756771)).setImageResource(2131165494);
            textView.setText(2131232475);
            bDt();
            bDu();
            this.ohA = new b(bzo(), new com.tencent.mm.ui.j.a(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void Oi() {
                    this.ohI.Fd(l.er(this.ohI.ezn));
                    if (this.ohI.ohA.getCount() <= 0) {
                        this.ohI.euo.setVisibility(0);
                        this.ohI.ohy.setVisibility(8);
                    } else {
                        this.ohI.euo.setVisibility(8);
                        if (this.ohI.ohy != null) {
                            this.ohI.ohy.setVisibility(0);
                        }
                    }
                    if (this.ohI.ohy != null) {
                        this.ohI.ohy.bIo();
                    }
                }

                public final void Oj() {
                }
            }, this.ezn);
            this.ohA.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final int bN(View view) {
                    return this.ohI.ohy.getPositionForView(view);
                }
            });
            this.ohA.a(new MMSlideDelView.f(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void p(View view, int i) {
                    this.ohI.ohy.performItemClick(view, i, 0);
                }
            });
            this.ohA.a(new e(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void aE(Object obj) {
                    if (obj == null) {
                        v.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                    }
                }
            });
            this.ohy.setAdapter(this.ohA);
            this.eus = new d(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    com.tencent.mm.modelbiz.a.a T;
                    switch (menuItem.getItemId()) {
                        case 0:
                            a.a(this.ohI, this.ohI.ezh);
                            return;
                        case 1:
                            T = u.DB().T(this.ohI.ezh);
                            T.field_unReadCount = 1;
                            T.field_atCount = 0;
                            u.DB().b(T);
                            com.tencent.mm.modelstat.b.daJ.C(T.field_brandUserName, true);
                            return;
                        case 2:
                            u.DB().V(this.ohI.ezh);
                            com.tencent.mm.modelstat.b.daJ.C(u.DB().T(this.ohI.ezh).field_brandUserName, false);
                            return;
                        case 3:
                            T = u.DB().T(this.ohI.ezh);
                            if (u.DB().W(this.ohI.ezh)) {
                                u.DB().Y(this.ohI.ezh);
                                com.tencent.mm.modelstat.b.daJ.c(true, T.field_brandUserName, false);
                                return;
                            }
                            u.DB().X(this.ohI.ezh);
                            com.tencent.mm.modelstat.b.daJ.c(true, T.field_brandUserName, true);
                            return;
                        default:
                            return;
                    }
                }
            };
            final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(bzo());
            this.ohy.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ a ohI;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i < this.ohI.ohy.getHeaderViewsCount()) {
                        v.w("MicroMsg.BizChatConversationFmUI", "on header view long click, ignore");
                    } else {
                        View view2 = view;
                        lVar.a(view2, i - this.ohI.ohy.getHeaderViewsCount(), j, this.ohI, this.ohI.eus);
                    }
                    return true;
                }
            });
            this.ohy.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i >= this.ohI.ohy.getHeaderViewsCount()) {
                        this.ohI.ev(((com.tencent.mm.modelbiz.a.a) this.ohI.ohA.getItem(i - this.ohI.ohy.getHeaderViewsCount())).field_bizChatId);
                    } else if (i == 0) {
                        a.g(this.ohI);
                    }
                }
            });
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.ohI.finish();
                    return true;
                }
            });
            a(1, 2131235684, 2131165206, new OnMenuItemClickListener(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    v.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
                    Intent intent = new Intent(this.ohI.nDR.nEl, BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", this.ohI.ezn);
                    intent.putExtra("biz_chat_search_scene", 1);
                    intent.putExtra("biz_chat_search_text", SQLiteDatabase.KeyEmpty);
                    intent.addFlags(67108864);
                    this.ohI.startActivity(intent);
                    return true;
                }
            });
            a(2, 2131230800, 2131165188, new OnMenuItemClickListener(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.ohI.eyM != null) {
                        this.ohI.eyM.dismiss();
                        this.ohI.eyM = null;
                    }
                    this.ohI.eyM = new m(this.ohI.nDR.nEl);
                    this.ohI.eyM.jXn = new n.c(this) {
                        final /* synthetic */ AnonymousClass4 ohJ;

                        {
                            this.ohJ = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.S(1, 2131231494, 2131165190);
                            lVar.S(3, 2131231493, 2131165194);
                            lVar.S(2, 2131230801, 2131165208);
                        }
                    };
                    this.ohI.eyM.jXo = new d(this) {
                        final /* synthetic */ AnonymousClass4 ohJ;

                        {
                            this.ohJ = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    a.k(this.ohJ.ohI);
                                    return;
                                case 2:
                                    if (be.kS(this.ohJ.ohI.cCn)) {
                                        this.ohJ.ohI.cCn = u.Dy().ho(this.ohJ.ohI.ezn).CF();
                                    }
                                    if (!be.kS(this.ohJ.ohI.cCn) && u.DI().a(this.ohJ.ohI.cCn, null)) {
                                        u.DF();
                                        com.tencent.mm.modelbiz.c.a(this.ohJ.ohI.cCn, null);
                                    }
                                    intent = new Intent();
                                    intent.putExtra("Contact_User", this.ohJ.ohI.ezn);
                                    com.tencent.mm.ay.c.b(this.ohJ.ohI.bzo(), "profile", ".ui.ContactInfoUI", intent);
                                    return;
                                case 3:
                                    if (be.kS(this.ohJ.ohI.ezn)) {
                                        v.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                                        return;
                                    }
                                    intent = new Intent(this.ohJ.ohI.nDR.nEl, BizChatFavUI.class);
                                    intent.putExtra("Contact_User", this.ohJ.ohI.ezn);
                                    intent.addFlags(67108864);
                                    this.ohJ.ohI.startActivity(intent);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    this.ohI.eyM.dQ();
                    return false;
                }
            });
            bDv();
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final void run() {
                    v.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    Cursor hP = u.DB().hP(this.ohI.ezn);
                    if (hP.moveToFirst()) {
                        while (!hP.isAfterLast()) {
                            com.tencent.mm.modelbiz.a.a aVar = new com.tencent.mm.modelbiz.a.a();
                            aVar.b(hP);
                            hP.moveToNext();
                            c Z = u.DA().Z(aVar.field_bizChatId);
                            if (Z.DO()) {
                                if (Z.DN()) {
                                    linkedList2.add(Z.field_bizChatServId);
                                } else {
                                    linkedList.add(Z.field_bizChatServId);
                                }
                            }
                        }
                    }
                    hP.close();
                    if (linkedList2.size() > 0) {
                        u.DE();
                        h.a(linkedList2, this.ohI.ezn);
                    }
                    a.a(this.ohI, linkedList);
                    if (linkedList.size() > 0) {
                        u.DE();
                        h.a(linkedList, this.ohI.ezn, null);
                    }
                }
            }, 300);
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ a ohI;

                {
                    this.ohI = r1;
                }

                public final boolean queueIdle() {
                    int i;
                    this.ohI.cCn = u.Dy().ho(this.ohI.ezn).CF();
                    int intExtra = this.ohI.bzo().getIntent().getIntExtra("biz_chat_from_scene", 7);
                    int i2 = -1;
                    if (this.ohI.ohA != null) {
                        i2 = this.ohI.ohA.getCount();
                    }
                    com.tencent.mm.modelbiz.b gZ = u.DF().gZ(this.ohI.cCn);
                    int i3 = gZ != null ? gZ.field_qyUin : 0;
                    if (gZ != null) {
                        i = gZ.field_userUin;
                    } else {
                        i = 0;
                    }
                    int hb = u.DF().hb(this.ohI.ezn);
                    com.tencent.mm.plugin.report.service.g.iuh.h(12648, this.ohI.cCn, this.ohI.ezn, Integer.valueOf(intExtra), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(hb), Integer.valueOf(i));
                    v.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d", this.ohI.cCn, this.ohI.ezn, Integer.valueOf(intExtra), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(hb), Integer.valueOf(i));
                    return false;
                }
            });
            Intent intent = bzo().getIntent();
            if (r.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    ev(longExtra);
                }
            }
        }

        protected final int getLayoutId() {
            return 2130903530;
        }

        public final String getUserName() {
            if (be.kS(this.cCn)) {
                return this.ezn;
            }
            return this.cCn;
        }

        public final void onDestroy() {
            v.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            u.DB().a(this.ohF);
            u.DA().a(this.ohG);
            u.DF().a(this.ohH);
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.wK().b(this);
            }
            this.ohA.avc();
            b bVar = this.ohA;
            if (bVar.ohm != null) {
                bVar.ohm.clear();
                bVar.ohm = null;
            }
            super.onDestroy();
        }

        public final void onResume() {
            super.onResume();
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(this.ezn);
            if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                finish();
                return;
            }
            BizInfo hw = com.tencent.mm.modelbiz.e.hw(this.ezn);
            if (hw == null || hw.field_enterpriseFather == null || !com.tencent.mm.model.m.eC(hw.field_enterpriseFather)) {
                finish();
                return;
            }
            if (LX.tM()) {
                vI(0);
            } else {
                vI(8);
            }
            this.nAV = true;
            this.ohA.a(null, null);
            ak.oH().db(this.ezn);
        }

        public final void onPause() {
            v.i("MicroMsg.BizChatConversationFmUI", "on pause");
            ak.yW();
            com.tencent.mm.model.c.wK().Mj(this.ezn);
            com.tencent.mm.modelbiz.a.b DB = u.DB();
            String str = this.ezn;
            if (be.kS(str)) {
                v.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean dF = DB.cie.dF("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                v.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", Boolean.valueOf(dF), str);
            }
            if (this.ohA != null) {
                this.ohA.onPause();
            }
            this.nAV = false;
            ak.oH().db(SQLiteDatabase.KeyEmpty);
            super.onPause();
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.modelbiz.a.a aVar = (com.tencent.mm.modelbiz.a.a) this.ohA.getItem(adapterContextMenuInfo.position);
            this.ezh = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, 2131233705);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, 2131233703);
            }
            u.DB();
            if (com.tencent.mm.modelbiz.a.b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, 2131233706);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, 2131233704);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, 2131233710);
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                switch (i) {
                    case 1:
                        boolean z;
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null) {
                            String str;
                            v.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                            String string = bundleExtra.getString("enterprise_members");
                            ra raVar = new ra();
                            c cVar = new c();
                            if (this.ohB != null) {
                                str = this.ohB.field_addMemberUrl;
                            } else {
                                str = null;
                            }
                            cVar.field_addMemberUrl = str;
                            cVar.field_brandUserName = this.ezn;
                            if (!com.tencent.mm.modelbiz.a.e.a(cVar, string, null, raVar)) {
                                z = false;
                            } else if (cVar.field_bizChatLocalId != -1) {
                                ev(cVar.field_bizChatLocalId);
                                z = true;
                            } else {
                                u.DE();
                                final com.tencent.mm.modelbiz.a.n a = h.a(this.ezn, raVar, (k) this);
                                Context bzo = bzo();
                                getString(2131231164);
                                this.dwg = g.a(bzo, getString(2131231182), true, new OnCancelListener(this) {
                                    final /* synthetic */ a ohI;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        u.DE();
                                        ak.vy().c(a);
                                    }
                                });
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            Toast.makeText(bzo(), getString(2131234577), 0).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final void a(int i, com.tencent.mm.v.k kVar) {
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            if (kVar.getType() == 1355) {
                c hR = u.DA().hR(((com.tencent.mm.modelbiz.a.n) kVar).DR().moz.muP.mhD);
                if (hR == null) {
                    Toast.makeText(aa.getContext(), getString(2131234577), 0).show();
                } else {
                    ev(hR.field_bizChatLocalId);
                }
            }
        }

        private void bDt() {
            if (this.ohw != null) {
                int i;
                View findViewById;
                String bDw = bDw();
                if (!be.kS(bDw)) {
                    ak.yW();
                    af Mh = com.tencent.mm.model.c.wK().Mh(bDw);
                    if (Mh != null) {
                        i = Mh.field_unReadMuteCount + Mh.field_unReadCount > 0 ? 1 : 0;
                        findViewById = this.ohw.findViewById(2131756772);
                        if (i == 0) {
                            findViewById.setVisibility(0);
                        } else {
                            findViewById.setVisibility(8);
                        }
                    }
                }
                i = 0;
                findViewById = this.ohw.findViewById(2131756772);
                if (i == 0) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
        }

        private void bDu() {
            if (this.ohw != null) {
                final String bDw = bDw();
                final boolean hg = u.DF().hg(bDw);
                this.ohx = (ImageButton) this.ohw.findViewById(2131756773);
                if (this.ohE) {
                    if (hg) {
                        this.ohx.setImageResource(2131165498);
                    }
                    this.ohx.setVisibility(0);
                    this.ohx.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a ohI;

                        public final void onClick(View view) {
                            if (hg) {
                                this.ohI.ohx.setImageResource(2131165497);
                                u.DF().hd(bDw);
                            }
                            com.tencent.mm.ui.f.g(this.ohI.nDR.nEl, this.ohI.ezn, true);
                        }
                    });
                }
            }
        }

        private void bDv() {
            boolean z = false;
            String ii = u.DC().ii(this.ezn);
            this.ohB = u.DC().ig(ii);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.ezn;
            objArr[1] = ii;
            if (this.ohB == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
            if (be.kS(ii) || this.ohB == null || this.ohB.DO() || be.kS(this.ohB.field_addMemberUrl)) {
                u.DE();
                h.a(this.ezn, (k) this);
                Context bzo = bzo();
                getString(2131231164);
                this.dwg = g.a(bzo, getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ a ohI;

                    {
                        this.ohI = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.ohI.finish();
                    }
                });
            }
        }

        private String bDw() {
            if (be.kS(this.cCn)) {
                this.cCn = u.Dy().ho(this.ezn).CF();
            }
            return this.cCn;
        }

        private void ev(long j) {
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.oJX.a(this.ezn, bundle, true);
        }

        public final void a(int i, j jVar, Object obj) {
            String str = (String) obj;
            if (!be.kS(str) && str.equals(bDw())) {
                bDt();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtW = q.em(this).inflate(2130903184, null);
        setContentView(this.dtW);
        this.oJN = new a();
        aS().aW().a(2131755641, this.oJN).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.dtW);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.dtW);
    }
}
