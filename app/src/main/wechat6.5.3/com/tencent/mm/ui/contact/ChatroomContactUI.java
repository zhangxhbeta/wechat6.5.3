package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ChatroomContactUI extends MMActivity implements a, e {
    private d ePu = new d(new OnScrollListener(this) {
        final /* synthetic */ ChatroomContactUI oFm;

        {
            this.oFm = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    private l eyZ;
    private TextView fMV;
    private ListView gQL;
    private VoiceSearchLayout nBO;
    private b oEb;
    private String oEd;
    private ContactCountView oEo;
    private n.d oEw = new n.d(this) {
        final /* synthetic */ ChatroomContactUI oFm;

        {
            this.oFm = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.Pe(this.oFm.oEd);
                    return;
                default:
                    return;
            }
        }
    };
    private p oFk;
    private d oFl;

    static /* synthetic */ void Pe(String str) {
        ak.yW();
        u LX = c.wH().LX(str);
        LX.tq();
        m.r(LX);
        if (m.dE(str)) {
            ak.yW();
            c.wH().Mc(str);
            ak.yW().wO().LG(str);
            return;
        }
        ak.yW();
        c.wH().a(str, LX);
    }

    static /* synthetic */ void a(ChatroomContactUI chatroomContactUI, String str) {
        if (str == null || str.length() <= 0) {
            if (chatroomContactUI.oEo != null) {
                chatroomContactUI.oEo.setVisible(true);
            }
        } else if (chatroomContactUI.oEo != null) {
            chatroomContactUI.oEo.setVisible(false);
        }
        if (str == null || str.length() == 0) {
            chatroomContactUI.gQL.setAdapter(chatroomContactUI.oFl);
            chatroomContactUI.gQL.setBackgroundColor(chatroomContactUI.getResources().getColor(2131689998));
            chatroomContactUI.oFl.notifyDataSetChanged();
            chatroomContactUI.oEb.kn(false);
            chatroomContactUI.oFl.Ol();
            return;
        }
        chatroomContactUI.gQL.setAdapter(chatroomContactUI.oEb);
        chatroomContactUI.gQL.setBackgroundColor(chatroomContactUI.getResources().getColor(com.tencent.mm.bi.a.a.white));
        chatroomContactUI.oEb.kn(true);
        chatroomContactUI.oEb.uU(str);
        chatroomContactUI.oEb.notifyDataSetChanged();
    }

    static /* synthetic */ void b(ChatroomContactUI chatroomContactUI, String str) {
        if (str != null && str.length() > 0) {
            if (m.fc(str)) {
                v.e("MicroMsg.ChatroomContactUI", "error, 4.5 do not contain this contact %s", str);
                return;
            }
            Intent intent = new Intent(chatroomContactUI.nDR.nEl, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            chatroomContactUI.nDR.nEl.startActivity(intent);
            if (str != null && str.length() > 0) {
                e.a(intent, str);
                chatroomContactUI.startActivity(intent);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903271;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131230838);
        NI();
        ak.vy().a(138, (e) this);
        ak.yW();
        c.wH().a(this.oFl);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        ak.yW();
        if (c.wH().LX(this.oEd) == null) {
            v.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.oEd);
        } else if (m.eA(this.oEd)) {
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(view.getContext(), com.tencent.mm.model.l.er(this.oEd)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, 2131230845);
        }
    }

    public final void NI() {
        ((TextView) findViewById(2131755318)).setVisibility(8);
        this.gQL = (ListView) findViewById(2131755317);
        this.gQL.setAdapter(null);
        this.fMV = (TextView) findViewById(2131755318);
        this.fMV.setText(2131230849);
        String str = "@all.chatroom.contact";
        this.oFl = new d(this, str);
        this.oFl.iQ(true);
        this.oEb = new b(this.nDR.nEl, 1);
        this.oEb.oDA = str;
        this.oFk = new p((byte) 0);
        this.oFk.a(new p.a(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final void Oh() {
            }

            public final void ml(String str) {
                v.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", str);
                ChatroomContactUI.a(this.oFm, t.lZ(str));
            }

            public final void Of() {
            }

            public final void Og() {
            }

            public final void Yt() {
                v.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
                this.oFm.axg();
            }

            public final void Yu() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
                v.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
                if (z) {
                    Intent intent = new Intent(this.oFm.nDR.nEl, VoiceSearchResultUI.class);
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                    intent.putExtra("VoiceSearchResultUI_ShowType", i);
                    this.oFm.nDR.nEl.startActivity(intent);
                    return;
                }
                intent = new Intent(this.oFm.nDR.nEl, VoiceSearchResultUI.class);
                intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
                intent.putExtra("VoiceSearchResultUI_Error", this.oFm.nDR.nEl.getString(2131232875));
                intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                intent.putExtra("VoiceSearchResultUI_ShowType", i);
                this.oFm.nDR.nEl.startActivity(intent);
            }

            public final boolean mk(String str) {
                return false;
            }
        });
        a(this.oFk);
        this.oFl.a(new MMSlideDelView.c(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final int bN(View view) {
                return this.oFm.gQL.getPositionForView(view);
            }
        });
        this.oFl.a(new f(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final void p(View view, int i) {
                this.oFm.gQL.performItemClick(view, i, 0);
            }
        });
        this.oFl.a(new MMSlideDelView.e(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
                    return;
                }
                ChatroomContactUI.Pe(obj.toString());
                this.oFm.avT();
            }
        });
        this.gQL.setOnScrollListener(this.ePu);
        this.oFl.lKh = this.ePu;
        this.eyZ = new l(this.nDR.nEl);
        this.gQL.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (this.oFm.oEb == null ? this.oFm.oEb : Boolean.valueOf(this.oFm.oEb.oYM)));
                if (i >= this.oFm.gQL.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.oFm.gQL.getHeaderViewsCount();
                    if (this.oFm.oEb == null || !this.oFm.oEb.oYM) {
                        ChatroomContactUI.b(this.oFm, ((u) this.oFm.oFl.getItem(headerViewsCount)).field_username);
                        return;
                    }
                    boolean lB = this.oFm.oEb.lB(headerViewsCount);
                    boolean yp = this.oFm.oEb.yp(headerViewsCount);
                    v.d("MicroMsg.ChatroomContactUI", "onItemClick " + yp);
                    if (yp) {
                        this.oFm.oEb.PI(this.oFm.oFk == null ? SQLiteDatabase.KeyEmpty : this.oFm.oFk.boJ());
                    } else if (lB) {
                        arq yo = this.oFm.oEb.yo(headerViewsCount);
                        String str = yo.moM.mQy;
                        ak.yW();
                        ab LX = c.wH().LX(str);
                        if (com.tencent.mm.i.a.ei(LX.field_type)) {
                            r1 = new Intent();
                            r1.putExtra("Contact_User", str);
                            r1.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (LX.bvm()) {
                                    g.iuh.Y(10298, str + ",3");
                                }
                                e.a(r1, str);
                                com.tencent.mm.ay.c.b(this.oFm, "profile", ".ui.ContactInfoUI", r1);
                                return;
                            }
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", yo.moM.mQy);
                        intent.putExtra("Contact_Alias", yo.cHh);
                        intent.putExtra("Contact_Nick", yo.mEj.mQy);
                        intent.putExtra("Contact_Signature", yo.cHf);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(yo.cHl, yo.cHd, yo.cHe));
                        intent.putExtra("Contact_Sex", yo.cHc);
                        intent.putExtra("Contact_VUser_Info", yo.mFv);
                        intent.putExtra("Contact_VUser_Info_Flag", yo.mFu);
                        intent.putExtra("Contact_KWeibo_flag", yo.mFy);
                        intent.putExtra("Contact_KWeibo", yo.mFw);
                        intent.putExtra("Contact_KWeiboNick", yo.mFx);
                        intent.putExtra("Contact_KSnsIFlag", yo.mFA.cHn);
                        intent.putExtra("Contact_KSnsBgId", yo.mFA.cHp);
                        intent.putExtra("Contact_KSnsBgUrl", yo.mFA.cHo);
                        if (yo.mFB != null) {
                            try {
                                intent.putExtra("Contact_customInfo", yo.mFB.toByteArray());
                            } catch (Throwable e) {
                                v.a("MicroMsg.ChatroomContactUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        if ((yo.mFu & 8) > 0) {
                            g.iuh.Y(10298, str + ",3");
                        }
                        com.tencent.mm.ay.c.b(this.oFm, "profile", ".ui.ContactInfoUI", intent);
                    } else {
                        ab js = this.oFm.oEb.js(headerViewsCount);
                        if (js == null) {
                            v.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(this.oFm.oEb.getCount()), Integer.valueOf(headerViewsCount));
                            return;
                        }
                        t.h(this.oFm.oFk.boJ(), 9, 3, headerViewsCount + 1);
                        String str2 = js.field_username;
                        r1 = new Intent(this.oFm.nDR.nEl, ChattingUI.class);
                        r1.addFlags(67108864);
                        r1.putExtra("Chat_User", str2);
                        r1.putExtra("Chat_Mode", 1);
                        this.oFm.nDR.nEl.startActivity(r1);
                    }
                }
            }
        });
        this.gQL.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                if (i < this.oFm.gQL.getHeaderViewsCount()) {
                    v.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
                } else if (this.oFm.oEb == null || !this.oFm.oEb.oYM) {
                    String str = ((u) this.oFm.oFl.getItem(i - this.oFm.gQL.getHeaderViewsCount())).field_username;
                    if (!(m.fc(str) || m.fd(str))) {
                        this.oFm.oEd = str;
                        this.oFm.eyZ.a(view, i, j, this.oFm, this.oFm.oEw);
                    }
                }
                return true;
            }
        });
        this.gQL.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.oFm.axg();
                        break;
                }
                if (this.oFm.oFl != null) {
                    d f = this.oFm.oFl;
                    if (f.cHD != null) {
                        f.cHD.onTouchEvent(motionEvent);
                    }
                }
                if (this.oFm.oEb != null) {
                    b d = this.oFm.oEb;
                    if (d.cHD != null) {
                        d.cHD.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        ListView listView = this.gQL;
        View contactCountView = new ContactCountView(this);
        this.oEo = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oFm.finish();
                return false;
            }
        });
        a(0, 2131230800, 2131165188, new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.oFm, SelectContactUI.class);
                intent.putExtra("titile", this.oFm.getString(2131230881));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", r.s(r.oHK, FileUtils.S_IRUSR, 512));
                this.oFm.nDR.nEl.startActivity(intent);
                return false;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ ChatroomContactUI oFm;

            {
                this.oFm = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.oFm.gQL);
            }
        };
        this.gQL.setAdapter(this.oFl);
        this.oEb.kn(false);
        this.gQL.setVisibility(0);
        this.nBO = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.nBO.setLayoutParams(layoutParams);
        this.nBO.tR(BackwardSupportUtil.b.a(this, 100.0f));
        this.nBO.setVisibility(8);
        ((ViewGroup) findViewById(2131756019)).addView(this.nBO);
        if (this.nBO != null) {
            this.nBO.lIS = new VoiceSearchLayout.b(this) {
                final /* synthetic */ ChatroomContactUI oFm;

                {
                    this.oFm = r1;
                }

                public final void hY(boolean z) {
                    v.d("MicroMsg.ChatroomContactUI", "visible " + z);
                    if (z) {
                        int firstVisiblePosition = this.oFm.gQL.getFirstVisiblePosition();
                        v.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + firstVisiblePosition);
                        if (firstVisiblePosition > 0) {
                            this.oFm.gQL.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass5 oFn;

                                {
                                    this.oFn = r1;
                                }

                                public final void run() {
                                    this.oFn.oFm.gQL.setSelection(0);
                                }
                            });
                        }
                    }
                }
            };
        }
        if (this.oFl.getCount() == 0) {
            this.fMV.setSingleLine(false);
            this.fMV.setPadding(40, 0, 40, 0);
            this.fMV.setVisibility(0);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.oEo != null) {
            this.oEo.oFo = 2;
            this.oEo.bHr();
        }
        ak.yW().wO().c(this);
        if (!(this.oFk == null || this.nBO == null)) {
            com.tencent.mm.ay.c.brh();
            if (com.tencent.mm.af.b.He() || !com.tencent.mm.sdk.platformtools.u.bsY().equals("zh_CN")) {
                this.oFk.lUX = false;
            } else {
                this.oFk.lUX = true;
                this.oFk.o(this.nBO);
            }
        }
        if (this.oEb != null) {
            this.oEb.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        ak.yW().wO().d(this);
        if (this.oFk != null) {
            p pVar = this.oFk;
            pVar.bJs();
            pVar.cancel();
        }
        if (this.oEb != null) {
            this.oEb.onPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(138, (e) this);
        ak.yW();
        c.wH().b(this.oFl);
        d dVar = this.oFl;
        if (dVar.cHD != null) {
            dVar.cHD.detach();
            dVar.cHD = null;
        }
        this.oFl.avc();
        this.oFl.nDK = null;
        this.oEb.detach();
        this.oEb.avc();
    }

    private void avT() {
        if (this.oFl != null) {
            this.oFl.a(null, null);
        }
        if (this.oEb != null) {
            this.oEb.a(null, null);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (t.bm(this) && !o.a.a(this, i, i2, str, 4) && i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    avT();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(String str, i iVar) {
        if (this.oEo != null) {
            this.oEo.oFo = 2;
            this.oEo.bHr();
        }
    }
}
