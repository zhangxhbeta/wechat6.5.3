package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bh.c;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class AddressUI extends FragmentActivity {
    public p ojM;

    public static class a extends com.tencent.mm.ui.AbstractTabChildActivity.a implements e {
        private int bCd;
        private final long deb = 180000;
        private ProgressDialog dwR = null;
        d ePu = new d(new OnScrollListener(this) {
            final /* synthetic */ a oEA;

            {
                this.oEA = r1;
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i >= 2 && !this.oEA.oEh) {
                    this.oEA.oEh = true;
                }
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2) {
                    c.byp().bX(AddressUI.class.getName() + ".Listview", 4);
                }
            }
        });
        List<String> ejp = new LinkedList();
        private l eyZ;
        private ListView gQL;
        private boolean gYJ = false;
        private TextView nIp;
        private String oDA;
        private String oDB;
        private TextView oDY;
        private TextView oDZ;
        private a oEa;
        private b oEb;
        private String oEc;
        private String oEd = SQLiteDatabase.KeyEmpty;
        private int oEe;
        private AlphabetScrollBar oEf;
        private LinearLayout oEg = null;
        private boolean oEh = false;
        private boolean oEi = false;
        private k oEj;
        private BizContactEntranceView oEk;
        private b oEl;
        private b oEm;
        private b oEn;
        private ContactCountView oEo;
        private i oEp;
        private View oEq;
        boolean oEr;
        private boolean oEs = true;
        private LinearLayout oEt;
        private Animation oEu;
        private Animation oEv;
        private n.d oEw = new n.d(this) {
            final /* synthetic */ a oEA;

            {
                this.oEA = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        a.a(this.oEA, this.oEA.oEd);
                        return;
                    case 7:
                        a.c(this.oEA, this.oEA.oEd);
                        return;
                    default:
                        return;
                }
            }
        };
        private com.tencent.mm.ui.base.VerticalScrollBar.a oEx = new com.tencent.mm.ui.base.VerticalScrollBar.a(this) {
            final /* synthetic */ a oEA;

            {
                this.oEA = r1;
            }

            public final void pC(String str) {
                int i = 0;
                if (this.oEA.getString(2131234799).equals(str)) {
                    this.oEA.gQL.setSelection(0);
                    return;
                }
                a a = this.oEA.oEa;
                v.v("MicroMsg.AddressAdapter", "getSections");
                String[] strArr = a.oDG;
                if (strArr == null) {
                    return;
                }
                if ("↑".equals(str)) {
                    this.oEA.gQL.setSelection(0);
                } else if ("☆".equals(str)) {
                    this.oEA.gQL.setSelection(this.oEA.gQL.getHeaderViewsCount());
                } else {
                    while (i < strArr.length && strArr[i] != null) {
                        if (strArr[i].equals(str)) {
                            this.oEA.gQL.setSelection(this.oEA.oEa.getPositionForSection(i) + this.oEA.gQL.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        List<String> oEy = new LinkedList();
        private Runnable oEz = new Runnable(this) {
            final /* synthetic */ a oEA;

            {
                this.oEA = r1;
            }

            public final void run() {
                a.m(this.oEA);
            }
        };

        static /* synthetic */ void a(a aVar, String str) {
            ak.yW();
            com.tencent.mm.model.c.wH().b(aVar.oEa);
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(str);
            LX.tq();
            m.r(LX);
            if (m.dE(str)) {
                ak.yW();
                com.tencent.mm.model.c.wH().Mc(str);
                ak.yW().wO().LG(str);
            } else {
                ak.yW();
                com.tencent.mm.model.c.wH().a(str, LX);
            }
            aVar.oEa.ck(str, 5);
            ak.yW();
            com.tencent.mm.model.c.wH().a(aVar.oEa);
        }

        static /* synthetic */ void b(a aVar) {
            aVar.oDY.setVisibility(8);
            aVar.gQL.setVisibility(0);
        }

        static /* synthetic */ void c(a aVar, String str) {
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(str);
            if (com.tencent.mm.i.a.ei(LX.field_type)) {
                Intent intent = new Intent();
                intent.setClass(aVar.nDR.nEl, ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", LX.field_username);
                intent.putExtra("view_mode", true);
                aVar.nDR.nEl.startActivity(intent);
            }
        }

        static /* synthetic */ void m(a aVar) {
            LauncherUI launcherUI = (LauncherUI) aVar.nDR.nEl;
            if (launcherUI == null || launcherUI.nBM == 1) {
                BackwardSupportUtil.c.a(aVar.gQL);
                new ac().postDelayed(new Runnable(aVar) {
                    final /* synthetic */ a oEA;

                    {
                        this.oEA = r1;
                    }

                    public final void run() {
                        this.oEA.gQL.setSelection(0);
                    }
                }, 300);
            }
        }

        protected final int getLayoutId() {
            return 2130903088;
        }

        public final boolean aXG() {
            return false;
        }

        public final boolean Sk() {
            return true;
        }

        public final void jT(boolean z) {
            if (this.oEf != null) {
                if (this.oEu == null) {
                    this.oEu = AnimationUtils.loadAnimation(this.nDR.nEl, 2130968616);
                    this.oEu.setDuration(200);
                }
                if (this.oEv == null) {
                    this.oEv = AnimationUtils.loadAnimation(this.nDR.nEl, 2130968616);
                    this.oEv.setDuration(200);
                }
                if (z) {
                    if (this.oEf.getVisibility() != 0) {
                        this.oEf.setVisibility(0);
                        this.oEf.startAnimation(this.oEu);
                    }
                } else if (4 != this.oEf.getVisibility()) {
                    this.oEf.setVisibility(8);
                    this.oEf.startAnimation(this.oEv);
                }
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(this.oEd);
            if (LX == null) {
                v.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.oEd);
            } else if (!k.xF().equals(LX.field_username)) {
                if (m.eA(this.oEd)) {
                    contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(view.getContext(), LX.tU()));
                    contextMenu.add(adapterContextMenuInfo.position, 2, 0, 2131230845);
                } else if (!m.eP(this.oEd) && !m.fg(this.oEd)) {
                    contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(view.getContext(), LX.tU()));
                    if (com.tencent.mm.i.a.ei(LX.field_type) && LX.field_deleteFlag != 1) {
                        contextMenu.add(adapterContextMenuInfo.position, 7, 0, 2131232091);
                    }
                }
            }
        }

        public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (!t.bm(this.nDR.nEl) || com.tencent.mm.ui.o.a.a(this.nDR.nEl, i, i2, str, 4) || i != 0 || i2 == 0) {
            }
        }

        private void bHn() {
            this.ejp = new LinkedList();
            this.oEy = new LinkedList();
            com.tencent.mm.ay.c.brh();
            this.ejp.add("tmessage");
            this.oEy.addAll(this.ejp);
            if (!this.ejp.contains("officialaccounts")) {
                this.ejp.add("officialaccounts");
            }
            this.ejp.add("helper_entry");
            if (this.oEa != null) {
                this.oEa.cB(this.ejp);
            }
            if (this.oEb != null) {
                this.oEb.cB(this.oEy);
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            v.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                bzp();
                finish();
            } else if (i2 == -1) {
                switch (i) {
                    case 4:
                        if (this.nAV) {
                            bzo().setResult(-1);
                        } else {
                            bzo().setResult(-1, intent);
                        }
                        finish();
                        return;
                    default:
                        return;
                }
            }
        }

        protected final void bys() {
            v.v("MicroMsg.AddressUI", "address ui on create");
            v.v("MicroMsg.AddressUI", "on address ui create");
            this.oEh = false;
            this.gYJ = false;
            this.oEi = false;
            this.oDA = null;
            this.oDB = null;
            this.oEc = null;
            ak.vy().a(138, (e) this);
            this.oDA = "@all.contact.without.chatroom";
            this.oDB = getStringExtra("Contact_GroupFilter_Str");
            this.oEc = getString(2131233192);
            this.oEe = getIntExtra("List_Type", 2);
            v.v("MicroMsg.AddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            if (this.gQL != null) {
                if (this.oEj != null) {
                    this.gQL.removeHeaderView(this.oEj);
                }
                if (this.oEk != null) {
                    this.gQL.removeHeaderView(this.oEk);
                }
                if (this.oEl != null) {
                    this.gQL.removeHeaderView(this.oEl);
                }
                if (this.oEn != null) {
                    this.gQL.removeHeaderView(this.oEn);
                }
            }
            this.oEq = View.inflate(this.nDR.nEl, 2130903808, null);
            this.gQL = (ListView) findViewById(2131755317);
            this.gQL.setScrollingCacheEnabled(false);
            this.oDY = (TextView) findViewById(2131755319);
            this.oDY.setText(2131230848);
            this.nIp = (TextView) findViewById(2131755318);
            this.nIp.setText(2131230850);
            this.oDZ = (TextView) findViewById(2131755321);
            this.oDZ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void onClick(View view) {
                }
            });
            this.oEa = new a(this.nDR.nEl, this.oDA, this.oDB, this.oEe);
            this.gQL.setAdapter(null);
            this.oEa.a(new com.tencent.mm.ui.e.a(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void Oi() {
                    a aVar = this.oEA;
                    this.oEA.oEa.getCount();
                    a.b(aVar);
                    this.oEA.oEa.bHk();
                }

                public final void Oj() {
                }
            });
            this.oEa.oDN = true;
            this.oEa.l(this);
            this.oEa.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final int bN(View view) {
                    return this.oEA.gQL.getPositionForView(view);
                }
            });
            this.oEa.a(new f(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void p(View view, int i) {
                    this.oEA.gQL.performItemClick(view, i, 0);
                }
            });
            this.oEa.a(new MMSlideDelView.e(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void aE(Object obj) {
                    if (obj == null) {
                        v.e("MicroMsg.AddressUI", "onItemDel object null");
                    } else {
                        a.a(this.oEA, obj.toString());
                    }
                }
            });
            this.oEb = new b(this.nDR.nEl, 1);
            this.oEb.ko(true);
            this.oEt = new LinearLayout(this.nDR.nEl);
            this.oEt.setOrientation(1);
            this.gQL.addHeaderView(this.oEt);
            this.oEm = new b(this.nDR.nEl, com.tencent.mm.ui.contact.b.a.ContactIpCall);
            this.oEt.addView(this.oEm);
            ak.yW();
            ((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
            this.oEm.setVisible(false);
            this.oEj = new k(this.nDR.nEl);
            this.oEt.addView(this.oEj);
            this.oEl = new b(this.nDR.nEl, com.tencent.mm.ui.contact.b.a.Chatromm);
            this.oEt.addView(this.oEl);
            this.oEl.setVisible(true);
            this.oEn = new b(this.nDR.nEl, com.tencent.mm.ui.contact.b.a.ContactLabel);
            this.oEt.addView(this.oEn);
            this.oEn.setVisible(true);
            this.bCd = t.getInt(j.sU().getValue("InviteFriendsControlFlags"), 0);
            if ((this.bCd & 2) > 0) {
                this.gQL.addFooterView(this.oEq, null, true);
            }
            ListView listView = this.gQL;
            View contactCountView = new ContactCountView(this.nDR.nEl);
            this.oEo = contactCountView;
            listView.addFooterView(contactCountView, null, false);
            this.oEq.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Invite_friends", true);
                    com.tencent.mm.ay.c.b(this.oEA.nDR.nEl, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
                    g.iuh.a(224, 1, 1, false);
                }
            });
            if (com.tencent.mm.ay.c.EH("brandservice")) {
                this.oEk = new BizContactEntranceView(this.nDR.nEl);
                this.oEt.addView(this.oEk);
                this.oEk.setVisible(true);
                this.oEp = new i(this.nDR.nEl, new com.tencent.mm.ui.contact.i.a(this) {
                    final /* synthetic */ a oEA;

                    {
                        this.oEA = r1;
                    }

                    public final void xR(int i) {
                        if (this.oEA.oEp != null) {
                            if (i <= 0) {
                                this.oEA.oEp.setVisibility(8);
                            } else {
                                this.oEA.oEp.setVisibility(0);
                            }
                        }
                    }
                });
                if (this.oEp.bHB() <= 0) {
                    this.oEp.setVisibility(8);
                }
                this.oEt.addView(this.oEp);
            }
            this.eyZ = new l(this.nDR.nEl);
            this.oEa.oDL = new com.tencent.mm.ui.contact.a.a(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }
            };
            this.gQL.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    v.i("MicroMsg.AddressUI", "onItemClick " + i + (this.oEA.oEb == null ? this.oEA.oEb : Boolean.valueOf(this.oEA.oEb.oYM)));
                    if ((i != 0 || "@biz.contact".equals(this.oEA.oDA)) && i >= this.oEA.gQL.getHeaderViewsCount()) {
                        int headerViewsCount = i - this.oEA.gQL.getHeaderViewsCount();
                        String str;
                        if (this.oEA.oEb == null || !this.oEA.oEb.oYM) {
                            com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) this.oEA.oEa.en(headerViewsCount);
                            if (fVar != null) {
                                str = fVar.field_username;
                                p pVar = this.oEA;
                                if (str != null && str.length() > 0) {
                                    if (m.fc(str)) {
                                        v.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", str);
                                        return;
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", str);
                                    if (m.eA(str)) {
                                        intent.putExtra("Is_group_card", true);
                                    }
                                    if (str != null && str.length() > 0) {
                                        e.a(intent, str);
                                        com.tencent.mm.ay.c.b(pVar.nDR.nEl, "profile", ".ui.ContactInfoUI", intent);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        boolean lB = this.oEA.oEb.lB(headerViewsCount);
                        boolean yp = this.oEA.oEb.yp(headerViewsCount);
                        v.i("MicroMsg.AddressUI", "onItemClick " + yp);
                        if (yp) {
                            this.oEA.oEb.PI(SQLiteDatabase.KeyEmpty);
                        } else if (lB) {
                            arq yo = this.oEA.oEb.yo(headerViewsCount);
                            String str2 = yo.moM.mQy;
                            ak.yW();
                            ab LX = com.tencent.mm.model.c.wH().LX(str2);
                            if (com.tencent.mm.i.a.ei(LX.field_type)) {
                                r1 = new Intent();
                                r1.putExtra("Contact_User", str2);
                                r1.putExtra("Contact_Scene", 3);
                                if (str2 != null && str2.length() > 0) {
                                    if (LX.bvm()) {
                                        g.iuh.Y(10298, str2 + ",3");
                                    }
                                    e.a(r1, str2);
                                    com.tencent.mm.ay.c.b(this.oEA.nDR.nEl, "profile", ".ui.ContactInfoUI", r1);
                                    return;
                                }
                                return;
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", yo.moM.mQy);
                            intent2.putExtra("Contact_Alias", yo.cHh);
                            intent2.putExtra("Contact_Nick", yo.mEj.mQy);
                            intent2.putExtra("Contact_Signature", yo.cHf);
                            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(yo.cHl, yo.cHd, yo.cHe));
                            intent2.putExtra("Contact_Sex", yo.cHc);
                            intent2.putExtra("Contact_VUser_Info", yo.mFv);
                            intent2.putExtra("Contact_VUser_Info_Flag", yo.mFu);
                            intent2.putExtra("Contact_KWeibo_flag", yo.mFy);
                            intent2.putExtra("Contact_KWeibo", yo.mFw);
                            intent2.putExtra("Contact_KWeiboNick", yo.mFx);
                            intent2.putExtra("Contact_KSnsIFlag", yo.mFA.cHn);
                            intent2.putExtra("Contact_KSnsBgId", yo.mFA.cHp);
                            intent2.putExtra("Contact_KSnsBgUrl", yo.mFA.cHo);
                            if (yo.mFB != null) {
                                try {
                                    intent2.putExtra("Contact_customInfo", yo.mFB.toByteArray());
                                } catch (Throwable e) {
                                    v.a("MicroMsg.AddressUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            if ((yo.mFu & 8) > 0) {
                                g.iuh.Y(10298, str2 + ",3");
                            }
                            com.tencent.mm.ay.c.b(this.oEA.nDR.nEl, "profile", ".ui.ContactInfoUI", intent2);
                        } else {
                            ab js = this.oEA.oEb.js(headerViewsCount);
                            if (js == null) {
                                v.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(this.oEA.oEb.getCount()), Integer.valueOf(headerViewsCount));
                                return;
                            }
                            str = js.field_username;
                            if (m.fc(str)) {
                                Intent intent3 = new Intent(this.oEA.nDR.nEl, AddressUI.class);
                                intent3.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                                this.oEA.startActivity(intent3);
                                return;
                            }
                            r1 = new Intent();
                            r1.putExtra("Contact_User", str);
                            r1.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                com.tencent.mm.ay.c.b(this.oEA.nDR.nEl, "profile", ".ui.ContactInfoUI", r1);
                            }
                        }
                    }
                }
            });
            this.gQL.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    v.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                    if (i < this.oEA.gQL.getHeaderViewsCount()) {
                        v.w("MicroMsg.AddressUI", "on item long click, but match header view");
                    } else if (this.oEA.oEb == null || !this.oEA.oEb.oYM) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) this.oEA.oEa.en(i - this.oEA.gQL.getHeaderViewsCount());
                        if (fVar == null) {
                            v.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(this.oEA.gQL.getHeaderViewsCount()));
                        } else {
                            String str = fVar.field_username;
                            if (!(m.fc(str) || m.fd(str))) {
                                this.oEA.oEd = str;
                                this.oEA.eyZ.a(view, i, j, this.oEA, this.oEA.oEw);
                            }
                        }
                    }
                    return true;
                }
            });
            this.gQL.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.oEA.ale();
                            break;
                    }
                    return false;
                }
            });
            this.gQL.setOnScrollListener(this.ePu);
            this.gQL.setDrawingCacheEnabled(false);
            this.oEf = (AlphabetScrollBar) findViewById(2131755320);
            this.oEf.obP = this.oEx;
            ak.yW();
            com.tencent.mm.model.c.wH().a(this.oEa);
            if (this.oEp != null) {
                com.tencent.mm.modelbiz.u.Dy().a(this.oEp);
            }
        }

        protected final void byt() {
            v.v("MicroMsg.AddressUI", "address ui on resume");
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            if (currentTimeMillis - t.e((Long) com.tencent.mm.model.c.vf().get(340226, null)) >= 180000) {
                bHp();
            }
            if (this.oEs) {
                this.oEs = false;
                this.oEr = false;
                bHn();
                this.gQL.setAdapter(this.oEa);
                this.gQL.post(new Runnable(this) {
                    final /* synthetic */ a oEA;

                    {
                        this.oEA = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.AddressUI", "post to first init finish");
                        View findViewById = this.oEA.findViewById(2131759528);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                            findViewById.startAnimation(AnimationUtils.loadAnimation(this.oEA.nDR.nEl, 2130968623));
                        }
                    }
                });
                this.oEb.kn(false);
            } else if (this.oEr) {
                this.oEr = false;
                com.tencent.mm.sdk.i.e.b(new Runnable(this) {
                    final /* synthetic */ a oEA;

                    {
                        this.oEA = r1;
                    }

                    public final void run() {
                        Process.setThreadPriority(10);
                        this.oEA.bHo();
                    }
                }, "AddressUI_updateUIData", 4);
                this.oEo.bHr();
            }
            if (this.oEk != null) {
                BizContactEntranceView bizContactEntranceView = this.oEk;
                bizContactEntranceView.bHq();
                bizContactEntranceView.setVisible(true);
            }
            if (this.oEp != null) {
                if (this.oEp.bHB() <= 0) {
                    this.oEp.setVisibility(8);
                } else {
                    this.oEp.setVisibility(0);
                }
            }
            ak.yW();
            this.oEh = ((Boolean) com.tencent.mm.model.c.vf().get(12296, Boolean.valueOf(false))).booleanValue();
            if (this.oEe == 2) {
                ak.yW();
                ab LX = com.tencent.mm.model.c.wH().LX(k.xF());
                if (!(LX == null || (com.tencent.mm.i.a.ei(LX.field_type) && t.kS(LX.field_conRemark) && t.kS(LX.field_conRemarkPYFull) && t.kS(LX.field_conRemarkPYShort)))) {
                    LX.tp();
                    LX.bQ(SQLiteDatabase.KeyEmpty);
                    LX.bW(SQLiteDatabase.KeyEmpty);
                    LX.bX(SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    com.tencent.mm.model.c.wH().a(k.xF(), LX);
                }
            }
            if (this.oEb != null) {
                this.oEb.onResume();
            }
            this.oEa.nzU = false;
            ad.o(new Runnable(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.e a = this.oEA.oEa;
                    v.i(a.TAG, "newcursor resume ");
                    a.nzO = true;
                    a.aK("resume", true);
                }
            });
            if (this.oEj != null) {
                this.oEj.oGz = true;
                k.bHD();
            }
            LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
            if (launcherUI != null) {
                launcherUI.P(this.oEz);
            }
        }

        private synchronized void bHo() {
            long currentTimeMillis = System.currentTimeMillis();
            bHn();
            v.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.oEa != null) {
                v.v("MicroMsg.AddressUI", "post to do refresh");
                ad.o(new Runnable(this) {
                    final /* synthetic */ a oEA;

                    {
                        this.oEA = r1;
                    }

                    public final void run() {
                        this.oEA.oEa.bHm();
                    }
                });
            }
            if (this.oEb != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ a oEA;

                    {
                        this.oEA = r1;
                    }

                    public final void run() {
                        v.v("MicroMsg.AddressUI", "post search adapter to do refresh");
                        this.oEA.oEb.a(null, null);
                    }
                });
            }
            v.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
        }

        protected final void byu() {
        }

        protected final void byv() {
            v.i("MicroMsg.AddressUI", "AddressUI on Pause");
            ak.yW();
            com.tencent.mm.model.c.vf().set(340226, Long.valueOf(System.currentTimeMillis()));
            ak.yW();
            com.tencent.mm.model.c.vf().set(12296, Boolean.valueOf(this.oEh));
            if (this.oEb != null) {
                this.oEb.onPause();
            }
            this.oEa.bHl();
            ad.o(new Runnable(this) {
                final /* synthetic */ a oEA;

                {
                    this.oEA = r1;
                }

                public final void run() {
                    this.oEA.oEa.pause();
                }
            });
            if (this.oEj != null) {
                this.oEj.oGz = false;
            }
            LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
            if (launcherUI != null) {
                launcherUI.Q(this.oEz);
            }
        }

        protected final void byw() {
        }

        protected final void byx() {
            v.v("MicroMsg.AddressUI", "onDestory");
            if (this.oEf != null) {
                this.oEf.obP = null;
            }
            ak.vy().b(138, (e) this);
            if (this.oEa != null) {
                this.oEa.iJ(true);
                a aVar = this.oEa;
                if (aVar.cHD != null) {
                    aVar.cHD.detach();
                    aVar.cHD = null;
                }
                this.oEa.byT();
            }
            if (this.oEb != null) {
                this.oEb.detach();
                this.oEb.avc();
            }
            if (ak.uz() && this.oEa != null) {
                ak.yW();
                com.tencent.mm.model.c.wH().b(this.oEa);
            }
            if (ak.uz() && this.oEp != null) {
                com.tencent.mm.modelbiz.u.Dy().b(this.oEp);
            }
            if (this.oEj != null) {
                k kVar = this.oEj;
                if (ak.uz()) {
                    com.tencent.mm.ar.l.KD().d(kVar.oGy);
                }
                this.oEj = null;
            }
            if (this.oEk != null) {
                this.oEk = null;
            }
            if (this.oEl != null) {
                this.oEl = null;
            }
            if (this.oEn != null) {
                this.oEn = null;
            }
        }

        public final void byz() {
            if (this.oEa != null) {
                this.oEa.clearCache();
            }
            v.i("MicroMsg.INIT", "KEVIN Address turnTobg");
            if (this.oEk != null) {
                this.oEk.destroyDrawingCache();
            }
            if (this.oEl != null) {
                this.oEl.destroyDrawingCache();
            }
            if (this.oEn != null) {
                this.oEn.destroyDrawingCache();
            }
            if (this.oEo != null) {
                this.oEo.destroyDrawingCache();
            }
            if (this.oEj != null) {
                this.oEj.destroyDrawingCache();
            }
        }

        public final void byA() {
            v.v("MicroMsg.INIT", "KEVIN Address turnTofg");
        }

        public final void byy() {
            v.v("MicroMsg.AddressUI", "request to top");
            if (this.gQL != null) {
                BackwardSupportUtil.c.a(this.gQL);
            }
        }

        public final void bzm() {
            if (this.oEj != null) {
                k.bHD();
            }
        }

        public final void ml(String str) {
            boolean z;
            v.d("MicroMsg.AddressUI", "onSearchBarChange %s", str);
            String lZ = t.lZ(str);
            this.gYJ = true;
            a aVar = this.oEa;
            if (t.kS(str)) {
                z = false;
            } else {
                z = true;
            }
            aVar.eyB = z;
            if (this.oEi) {
                this.oEb.kn(false);
                if (lZ != null && lZ.trim().length() == 0) {
                    this.oEa.eyB = false;
                }
                this.oEa.k(lZ, null);
            } else if (lZ == null || lZ.length() == 0) {
                if (this.oEf != null) {
                    this.oEf.setVisibility(0);
                }
                this.gQL.setAdapter(this.oEa);
                this.oEa.notifyDataSetChanged();
                this.oEb.kn(false);
                this.oEa.k(lZ, null);
                if (this.oDZ != null) {
                    this.oDZ.setVisibility(0);
                }
            } else {
                if (this.oEf != null) {
                    v.d("MicroMsg.AddressUI", "do query");
                    this.oEf.setVisibility(8);
                }
                this.oEa.clearCache();
                this.gQL.setAdapter(this.oEb);
                this.oEb.kn(true);
                this.oEb.uU(lZ);
                this.oEb.notifyDataSetChanged();
                if (this.oDZ != null) {
                    this.oDZ.setVisibility(8);
                }
            }
        }

        public final void Of() {
            ml(SQLiteDatabase.KeyEmpty);
            LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
            if (launcherUI != null) {
                launcherUI.iO(true);
            }
            if (this.oDZ != null) {
                this.oDZ.setVisibility(8);
            }
            if (this.oEj != null) {
                this.oEj.setVisible(true);
            }
            if (this.oEk != null) {
                this.oEk.setVisible(true);
            }
            if (this.oEl != null) {
                this.oEl.setVisible(true);
            }
            if (this.oEn != null) {
                this.oEn.setVisible(true);
            }
            if (this.oEo != null) {
                this.oEo.setVisible(true);
            }
        }

        public final void Og() {
            g.iuh.Y(10919, "3");
            LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
            if (launcherUI != null) {
                launcherUI.iO(false);
            }
            if (this.oDZ != null) {
                this.oDZ.setVisibility(0);
            }
            if (this.oEj != null) {
                this.oEj.setVisible(false);
            }
            if (this.oEk != null) {
                this.oEk.setVisible(false);
            }
            if (this.oEl != null) {
                this.oEl.setVisible(false);
            }
            if (this.oEn != null) {
                this.oEn.setVisible(false);
            }
            if (this.oEo != null) {
                this.oEo.setVisible(false);
            }
        }

        public final void Yt() {
            ale();
        }

        public final void Yu() {
        }

        public final void a(boolean z, String[] strArr, long j, int i) {
            v.v("MicroMsg.AddressUI", "onVoiceReturn");
            if (z) {
                Intent intent = new Intent(this.nDR.nEl, VoiceSearchResultUI.class);
                intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                intent.putExtra("VoiceSearchResultUI_ShowType", i);
                this.nDR.nEl.startActivity(intent);
                return;
            }
            intent = new Intent(this.nDR.nEl, VoiceSearchResultUI.class);
            intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
            intent.putExtra("VoiceSearchResultUI_Error", this.nDR.nEl.getString(2131232875));
            intent.putExtra("VoiceSearchResultUI_VoiceId", j);
            intent.putExtra("VoiceSearchResultUI_ShowType", i);
            this.nDR.nEl.startActivity(intent);
        }

        public final boolean mk(String str) {
            return false;
        }

        public final void hY(boolean z) {
            v.d("MicroMsg.AddressUI", "visible " + z);
            if (z) {
                int firstVisiblePosition = this.gQL.getFirstVisiblePosition();
                v.d("MicroMsg.AddressUI", "getFirstVisiblePosition  " + firstVisiblePosition);
                if (firstVisiblePosition > 0) {
                    this.gQL.post(new Runnable(this) {
                        final /* synthetic */ a oEA;

                        {
                            this.oEA = r1;
                        }

                        public final void run() {
                            this.oEA.gQL.setSelection(0);
                        }
                    });
                }
            }
        }

        public final void bHp() {
            if (this.gQL != null) {
                this.gQL.setSelection(0);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        android.support.v4.app.k aS = aS();
        if (aS.E(16908290) == null) {
            this.ojM = new a();
            this.ojM.setArguments(getIntent().getExtras());
            aS.aW().a(16908290, this.ojM).commit();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }
}
