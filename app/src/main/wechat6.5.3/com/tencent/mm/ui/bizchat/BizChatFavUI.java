package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.modelbiz.a.b.a;
import com.tencent.mm.modelbiz.a.b.a.b;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.s;
import com.tencent.mm.modelbiz.a.w;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.j;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BizChatFavUI extends MMActivity implements k {
    private p dwE;
    private TextView euo;
    private ListView eup;
    private d eus;
    private long ezh;
    private String ezn;
    private boolean nAV;
    private a ohF;
    private com.tencent.mm.modelbiz.a.d.a ohG;
    private c ohO;

    static /* synthetic */ void a(BizChatFavUI bizChatFavUI, long j) {
        v.i("MicroMsg.BizChatFavUI", "deleteFromFav");
        c Z = u.DA().Z(j);
        Z.field_bitFlag &= -9;
        v.i("MicroMsg.BizChatFavUI", "deleteFromFav:bitFlag %s", Integer.valueOf(Z.field_bitFlag));
        gu guVar = new gu();
        guVar.mhD = Z.field_bizChatServId;
        guVar.mhF = Z.field_bitFlag;
        u.DE();
        final w a = h.a(Z.field_brandUserName, guVar, (k) bizChatFavUI);
        bizChatFavUI.dwE = g.a((Context) bizChatFavUI, SQLiteDatabase.KeyEmpty, false, new OnCancelListener(bizChatFavUI) {
            final /* synthetic */ BizChatFavUI ohP;

            public final void onCancel(DialogInterface dialogInterface) {
                u.DE();
                ak.vy().c(a);
            }
        });
    }

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j) {
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.ezn);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        ad.g(new Runnable(bizChatFavUI) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void run() {
                this.ohP.finish();
            }
        }, 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ezn = getIntent().getStringExtra("Contact_User");
        v.i("MicroMsg.BizChatFavUI", "[regitListener]");
        this.ohF = new a(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void a(b bVar) {
                if (bVar != null && bVar.cDG != null && this.ohP.ezn.equals(bVar.cDG.field_brandUserName)) {
                    v.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
                    if (this.ohP.nAV) {
                        this.ohP.ohO.Ol();
                    }
                }
            }
        };
        this.ohG = new com.tencent.mm.modelbiz.a.d.a(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.d.a.b bVar) {
                if (bVar != null && bVar.cDQ != null) {
                    v.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
                    c Z = u.DA().Z(bVar.cDF);
                    v.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", Boolean.valueOf(Z.field_needToUpdate));
                    if (this.ohP.nAV) {
                        this.ohP.ohO.Ol();
                    }
                }
            }
        };
        u.DB().a(this.ohF, getMainLooper());
        u.DA().a(this.ohG, getMainLooper());
        NI();
        u.DE();
        ak.vy().a(new s(this.ezn), 0);
    }

    protected final int getLayoutId() {
        return 2130903531;
    }

    public void onDestroy() {
        v.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        u.DB().a(this.ohF);
        u.DA().a(this.ohG);
        this.ohO.avc();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ak.yW();
        ab LX = com.tencent.mm.model.c.wH().LX(this.ezn);
        if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
            finish();
            return;
        }
        vI(8);
        this.nAV = true;
        this.ohO.a(null, null);
        ak.oH().db(this.ezn);
    }

    public void onPause() {
        this.ohO.onPause();
        this.nAV = false;
        ak.oH().db(SQLiteDatabase.KeyEmpty);
        super.onPause();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.ezh = ((c) this.ohO.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, 2131231497);
    }

    public final void a(int i, com.tencent.mm.v.k kVar) {
        if (this.dwE != null) {
            this.dwE.dismiss();
        }
    }

    protected final void NI() {
        this.eup = (ListView) findViewById(2131756759);
        this.euo = (TextView) findViewById(2131756760);
        this.euo.setText(2131231496);
        this.eup.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                n.GL().ba(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ohO = new c(this, new j.a(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void Oi() {
                this.ohP.Fd(l.er(this.ohP.ezn));
                if (this.ohP.ohO.getCount() <= 0) {
                    this.ohP.euo.setVisibility(0);
                    this.ohP.eup.setVisibility(8);
                    return;
                }
                this.ohP.euo.setVisibility(8);
                this.ohP.eup.setVisibility(0);
            }

            public final void Oj() {
            }
        }, this.ezn);
        this.ohO.a(new MMSlideDelView.c(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final int bN(View view) {
                return this.ohP.eup.getPositionForView(view);
            }
        });
        this.ohO.a(new f(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void p(View view, int i) {
                this.ohP.eup.performItemClick(view, i, 0);
            }
        });
        this.ohO.a(new e(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                }
            }
        });
        this.eup.setAdapter(this.ohO);
        this.eus = new d(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatFavUI.a(this.ohP, this.ohP.ezh);
                        return;
                    default:
                        return;
                }
            }
        };
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.eup.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BizChatFavUI ohP;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.ohP.eup.getHeaderViewsCount()) {
                    v.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.ohP, this.ohP.eus);
                }
                return true;
            }
        });
        this.eup.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BizChatFavUI.b(this.ohP, ((c) this.ohP.ohO.getItem(i)).field_bizChatLocalId);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatFavUI ohP;

            {
                this.ohP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ohP.finish();
                return true;
            }
        });
    }
}
