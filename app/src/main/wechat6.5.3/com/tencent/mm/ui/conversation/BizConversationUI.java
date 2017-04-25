package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
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
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BizConversationUI extends BaseConversationUI {
    private View dtW;

    public static class a extends b {
        private String bdo = SQLiteDatabase.KeyEmpty;
        private String cBj;
        private p dwg = null;
        private TextView euo;
        private boolean eut = false;
        private l eyZ;
        private d hkn = new d(this) {
            final /* synthetic */ a oKc;

            {
                this.oKc = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        ak.yW();
                        ab LX = c.wH().LX(this.oKc.bdo);
                        if (LX == null) {
                            v.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + this.oKc.bdo);
                            return;
                        } else if (LX.tP()) {
                            g.iuh.h(13307, LX.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                            m.m(this.oKc.bdo, true);
                            return;
                        } else {
                            g.iuh.h(13307, LX.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                            m.l(this.oKc.bdo, true);
                            return;
                        }
                    case 2:
                        ak.yW();
                        com.tencent.mm.ui.tools.b.a(u.Dy().ho(this.oKc.bdo), this.oKc.bzo(), c.wH().LX(this.oKc.bdo), 2);
                        return;
                    case 3:
                        a.b(this.oKc, this.oKc.bdo);
                        return;
                    default:
                        return;
                }
            }
        };
        private com.tencent.mm.storage.ab oFp;
        private a oJI;
        private ListView oKa;
        private String oKb;

        private static class a extends a {
            private String bkp;

            public a(Context context, String str, com.tencent.mm.ui.j.a aVar) {
                super(context, aVar);
                this.bkp = str;
            }

            public final void Ol() {
                ak.yW();
                setCursor(c.wK().b(m.crA, this.ejp, this.bkp));
                if (this.nDK != null) {
                    this.nDK.Oi();
                }
                super.notifyDataSetChanged();
            }
        }

        static /* synthetic */ void a(a aVar, int i) {
            if (i <= 0) {
                aVar.euo.setVisibility(0);
                aVar.oKa.setVisibility(8);
                return;
            }
            aVar.euo.setVisibility(8);
            aVar.oKa.setVisibility(0);
        }

        static /* synthetic */ void b(a aVar, String str) {
            if (be.kS(str)) {
                v.e("MicroMsg.BizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            if ("officialaccounts".equals(aVar.cBj)) {
                g.iuh.h(13773, Integer.valueOf(0), Integer.valueOf(aVar.oFp.field_unReadCount), Integer.valueOf(0), aVar.oFp.field_username);
            }
            ak.yW();
            bx MH = c.wJ().MH(str);
            com.tencent.mm.ba.a mlVar = new ml();
            mlVar.moM = new arf().JF(be.ma(str));
            mlVar.mcb = MH.field_msgSvrId;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(8, mlVar));
            aVar.eut = false;
            Context bzo = aVar.bzo();
            aVar.getString(2131231164);
            final ProgressDialog a = com.tencent.mm.ui.base.g.a(bzo, aVar.getString(2131231182), true, new OnCancelListener(aVar) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oKc.eut = true;
                }
            });
            aw.a(str, new com.tencent.mm.model.aw.a(aVar) {
                final /* synthetic */ a oKc;

                public final boolean zp() {
                    return this.oKc.eut;
                }

                public final void zo() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ak.yW();
            ab LX = c.wH().LX(str);
            ak.yW();
            af Mh = c.wK().Mh(str);
            ak.yW();
            c.wK().Mf(str);
            if (Mh == null) {
                return;
            }
            if (Mh.el(4194304) || (LX != null && LX.bvm() && !com.tencent.mm.i.a.ei(LX.field_type) && Mh.field_conversationTime < u.DK())) {
                ak.vy().a(new i(str), 0);
            }
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.cBj = bzo().getIntent().getStringExtra("enterprise_biz_name");
            if (be.kS(this.cBj)) {
                this.cBj = "officialaccounts";
            }
            if (be.ma(this.cBj).equals("officialaccounts")) {
                g.iuh.Y(11404, SQLiteDatabase.KeyEmpty);
            }
            this.oKb = bzo().getIntent().getStringExtra("enterprise_biz_display_name");
            if (be.kS(this.oKb)) {
                this.oKb = getString(2131231487);
            }
            Fd(this.oKb);
            this.oKa = (ListView) findViewById(2131756759);
            this.euo = (TextView) findViewById(2131756760);
            this.euo.setText(2131232446);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.oKc.finish();
                    return true;
                }
            });
            AnonymousClass9 anonymousClass9 = new OnClickListener(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.platformtools.a.b.a(this.oKc.oKa);
                }
            };
            this.oJI = new a(bzo(), this.cBj, new com.tencent.mm.ui.j.a(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void Oi() {
                    a.a(this.oKc, this.oKc.oJI.getCount());
                }

                public final void Oj() {
                }
            });
            this.oJI.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final int bN(View view) {
                    return this.oKc.oKa.getPositionForView(view);
                }
            });
            this.oJI.a(new f(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void p(View view, int i) {
                    this.oKc.oKa.performItemClick(view, i, 0);
                }
            });
            this.oKa.setAdapter(this.oJI);
            this.eyZ = new l(bzo());
            this.oKa.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.oKc.oFp = (com.tencent.mm.storage.ab) this.oKc.oJI.getItem(i);
                    this.oKc.bdo = this.oKc.oFp.field_username;
                    af c = this.oKc.oFp;
                    if (c == null) {
                        v.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(this.oKc.oJI.getCount()));
                        this.oKc.oJI.notifyDataSetChanged();
                        return;
                    }
                    this.oKc.oJX.a(c.field_username, null, true);
                }
            });
            this.oKa.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.oKc.oFp = (com.tencent.mm.storage.ab) this.oKc.oJI.getItem(i);
                    this.oKc.bdo = this.oKc.oFp.field_username;
                    this.oKc.eyZ.a(view, i, j, this.oKc, this.oKc.hkn);
                    return true;
                }
            });
            this.oJI.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final int bN(View view) {
                    return this.oKc.oKa.getPositionForView(view);
                }
            });
            this.oJI.a(new f(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void p(View view, int i) {
                    this.oKc.oKa.performItemClick(view, i, 0);
                }
            });
            this.oJI.a(new e(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void aE(Object obj) {
                    if (obj == null) {
                        v.e("MicroMsg.BizConversationUI", "onItemDel object null");
                        return;
                    }
                    a.b(this.oKc, obj.toString());
                }
            });
            if ("officialaccounts".equals(this.cBj)) {
                com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100045");
                boolean z = Ls.isValid() && "1".equals(Ls.buX().get("isOpenSearch"));
                v.d("MicroMsg.BizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
                if (z) {
                    a(1, 2131235684, 2131165206, new OnMenuItemClickListener(this) {
                        final /* synthetic */ a oKc;

                        {
                            this.oKc = r1;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            if (h.Ih()) {
                                Intent Ij = h.Ij();
                                Ij.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.oKc.getString(2131233009));
                                Ij.putExtra("searchbar_tips", this.oKc.getString(2131233009));
                                Ij.putExtra("KRightBtn", true);
                                Ij.putExtra("ftsneedkeyboard", true);
                                Ij.putExtra("publishIdPrefix", "bs");
                                Ij.putExtra("ftsType", 2);
                                Ij.putExtra("ftsbizscene", 11);
                                Ij.putExtra("rawUrl", h.l(h.a(11, false, 2)));
                                Ij.putExtra("key_load_js_without_delay", true);
                                Ij.addFlags(67108864);
                                com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Ij);
                            } else {
                                v.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
                            }
                            return true;
                        }
                    });
                }
            }
            ak.yW();
            c.wK().a(this.oJI);
        }

        protected final int getLayoutId() {
            return 2130904546;
        }

        public final String getUserName() {
            return this.cBj;
        }

        public final void onDestroy() {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a oKc;

                {
                    this.oKc = r1;
                }

                public final void run() {
                    if (ak.uz() && "officialaccounts".equals(this.oKc.cBj)) {
                        int i;
                        long j;
                        int i2;
                        int i3;
                        long currentTimeMillis = System.currentTimeMillis();
                        int i4 = 0;
                        int i5 = 0;
                        int i6 = 0;
                        long j2 = 0;
                        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
                        ak.yW();
                        Cursor b = c.wK().b(m.crA, null, this.oKc.cBj);
                        if (b != null) {
                            int columnIndex = b.getColumnIndex("unReadCount");
                            int columnIndex2 = b.getColumnIndex("conversationTime");
                            int columnIndex3 = b.getColumnIndex("flag");
                            int count = b.getCount();
                            com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab();
                            while (b.moveToNext()) {
                                abVar.t(b.getLong(columnIndex3));
                                i = b.getInt(columnIndex);
                                if (i > 0) {
                                    j2 = b.getLong(columnIndex2);
                                    i5++;
                                    i4 += i;
                                } else {
                                    i = 0;
                                }
                                stringBuilder.append(b.isFirst() ? SQLiteDatabase.KeyEmpty : ".").append(i);
                                ak.yW();
                                c.wK();
                                if (ac.g(abVar)) {
                                    i6++;
                                }
                            }
                            b.close();
                            i = i4;
                            i4 = i5;
                            int i7 = i6;
                            j = j2;
                            i2 = i7;
                            i3 = count;
                        } else {
                            i = 0;
                            i4 = 0;
                            j = 0;
                            i2 = 0;
                            i3 = 0;
                        }
                        g.iuh.h(13771, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i2), stringBuilder.toString());
                        v.v("MicroMsg.BizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            });
            if (ak.uz()) {
                ak.yW();
                c.wK().b(this.oJI);
            }
            if (this.oJI != null) {
                this.oJI.onDestroy();
            }
            super.onDestroy();
        }

        public final void onResume() {
            v.v("MicroMsg.BizConversationUI", "on resume");
            if (this.oJI != null) {
                this.oJI.onResume();
            }
            super.onResume();
        }

        public final void onPause() {
            v.i("MicroMsg.BizConversationUI", "on pause");
            ak.yW();
            c.wK().Mj(this.cBj);
            if (this.oJI != null) {
                this.oJI.onPause();
            }
            super.onPause();
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (!(this.bdo == null || this.bdo.isEmpty())) {
                this.bdo = SQLiteDatabase.KeyEmpty;
            }
            if (i2 == -1) {
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            ak.yW();
            ab LX = c.wH().LX(this.bdo);
            if (LX == null) {
                v.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.bdo);
                return;
            }
            CharSequence tU = LX.tU();
            if (tU.toLowerCase().endsWith("@chatroom") && be.kS(LX.field_nickname)) {
                tU = getString(2131231879);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(bzo(), tU));
            if (LX.tP()) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, 2131233706);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, 2131232190);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, 2131233702);
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, 2131233710);
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
