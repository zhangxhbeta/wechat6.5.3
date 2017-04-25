package com.tencent.mm.plugin.card.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.plugin.card.sharecard.ui.d;
import com.tencent.mm.plugin.card.sharecard.ui.g;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.b;
import com.tencent.mm.plugin.card.ui.f;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends MMActivity implements a, e {
    private float bYf = -1000.0f;
    private float bYg = -1000.0f;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ CardBaseUI eAJ;

        {
            this.eAJ = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (z) {
                if (!(f2 == -1000.0f || f == -1000.0f)) {
                    this.eAJ.bYf = f2;
                    this.eAJ.bYg = f;
                    af.aaq().m(this.eAJ.bYf, this.eAJ.bYg);
                    this.eAJ.YV();
                }
                if (!this.eAJ.cCU) {
                    this.eAJ.cCU = true;
                    n.a(2010, f, f2, (int) d2);
                }
                return false;
            }
            this.eAJ.YW();
            return true;
        }
    };
    public c cCR;
    private boolean cCU = false;
    private p dFI = null;
    public ListView eAA = null;
    public BaseAdapter eAB = null;
    public RelativeLayout eAC = null;
    public LinearLayout eAD;
    public LinearLayout eAE;
    public boolean eAF = false;
    public boolean eAG = true;
    public a eAH = null;
    public CardInfo eAI;

    public abstract void YN();

    static /* synthetic */ void a(CardBaseUI cardBaseUI, String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        cardBaseUI.eAF = false;
        cardBaseUI.x(linkedList);
    }

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.cg(true);
        ak.vy().a(new aa(cardBaseUI.eAI.field_card_id, str, 17), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.eAG = true;
        ak.vy().a(652, this);
    }

    public void onPause() {
        super.onPause();
        this.eAG = false;
        ak.vy().b(652, this);
    }

    public void NI() {
        a cVar;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardBaseUI eAJ;

            {
                this.eAJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eAJ.finish();
                return true;
            }
        });
        this.eAA = (ListView) findViewById(16908298);
        this.eAC = (RelativeLayout) findViewById(2131755725);
        if (this.eAC != null) {
            this.eAA.setEmptyView(this.eAC);
        }
        this.eAD = (LinearLayout) View.inflate(getBaseContext(), 2130903233, null);
        this.eAE = (LinearLayout) View.inflate(getBaseContext(), 2130903231, null);
        this.eAA.addHeaderView(this.eAD);
        this.eAA.addFooterView(this.eAE);
        this.eAB = YP();
        this.eAA.setAdapter(this.eAB);
        this.eAA.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardBaseUI eAJ;

            {
                this.eAJ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    v.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                if (i < this.eAJ.eAB.getCount()) {
                    this.eAJ.b(this.eAJ.eAH.iQ(i));
                }
            }
        });
        this.eAA.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardBaseUI eAJ;

            {
                this.eAJ = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    v.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i < this.eAJ.eAB.getCount()) {
                        this.eAJ.c(this.eAJ.eAH.iQ(i));
                    }
                }
                return true;
            }
        });
        ak.vy().a(560, this);
        ak.vy().a(692, this);
        BaseAdapter baseAdapter = this.eAB;
        if (baseAdapter instanceof b) {
            cVar = new com.tencent.mm.plugin.card.ui.c((b) baseAdapter);
        } else {
            Object dVar = baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c ? new d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter) : baseAdapter instanceof g ? new h((g) baseAdapter) : new com.tencent.mm.plugin.card.ui.g((f) baseAdapter);
        }
        this.eAH = cVar;
        this.eAH.onCreate();
        YN();
    }

    public int getLayoutId() {
        return 2130903227;
    }

    public void onDestroy() {
        ak.vy().b(560, this);
        ak.vy().b(692, this);
        if (this.eAH != null) {
            this.eAH.onDestroy();
        }
        super.onDestroy();
    }

    public void a(b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.Zz());
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (YO() == j.a.eDl) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11324, new Object[]{"ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
        } else if (YO() == j.a.eDk) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11324, new Object[]{"ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    public final void cg(boolean z) {
        if (z) {
            this.dFI = p.b(this, getString(2131231182), true, 0, null);
        } else if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
            this.dFI = null;
        }
    }

    public final void x(LinkedList<String> linkedList) {
        cg(true);
        ak.vy().a(new com.tencent.mm.plugin.card.model.n(linkedList), 0);
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3;
        if (i != 0 || i2 != 0) {
            cg(false);
            if (kVar instanceof aa) {
                i3 = ((aa) kVar).eDo;
                CharSequence charSequence = ((aa) kVar).eDp;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(2131231626);
                    }
                    str = charSequence;
                }
            }
            if (!(kVar instanceof t) && !(kVar instanceof z) && !(kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) && this.eAG) {
                com.tencent.mm.plugin.card.b.c.b(this, str, i2);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.model.n) {
            cg(false);
            com.tencent.mm.ui.base.g.bf(this, getResources().getString(2131231610));
            af.aaj();
            com.tencent.mm.plugin.card.a.b.iS(4);
            this.eAH.zk();
            YY();
        } else if (kVar instanceof aa) {
            cg(false);
            i3 = ((aa) kVar).eDo;
            String str2 = ((aa) kVar).eDp;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(2131231626);
                }
                com.tencent.mm.plugin.card.b.c.b(this, str2, i3);
                return;
            }
            if (this.eAI != null) {
                iu Zw = this.eAI.Zw();
                Zw.status = 3;
                this.eAI.a(Zw);
                if (!af.aak().a(this.eAI, new String[0])) {
                    v.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[]{this.eAI.field_card_id});
                }
            }
            this.eAH.zk();
            YY();
        }
    }

    public int YO() {
        return j.a.eDg;
    }

    public BaseAdapter YP() {
        return new b(this, YO());
    }

    public boolean YQ() {
        return true;
    }

    public boolean YR() {
        return true;
    }

    public void b(b bVar) {
        if (!YQ()) {
            v.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            v.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (bVar.Zh()) {
            a(bVar);
        } else if (!TextUtils.isEmpty(bVar.Zv().mkT)) {
            com.tencent.mm.plugin.card.b.b.a((MMActivity) this, bVar.Zv().mkT, 0);
        }
    }

    public void c(final b bVar) {
        if (!YR()) {
            v.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            v.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.Zi()) {
                arrayList.add(getResources().getString(2131231654));
            }
            arrayList.add(getResources().getString(2131231020));
            final String Zz = bVar.Zz();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.Zv().eCC);
            com.tencent.mm.ui.base.g.a(this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ CardBaseUI eAJ;

                public final void gT(int i) {
                    if (bVar.Zi()) {
                        switch (i) {
                            case 0:
                                this.eAJ.a((CardInfo) bVar);
                                return;
                            case 1:
                                com.tencent.mm.plugin.card.b.c.a(this.eAJ, Zz, "", new com.tencent.mm.plugin.card.b.c.a(this.eAJ, Zz) {
                                    final /* synthetic */ CardBaseUI eAJ;

                                    public final void YZ() {
                                        CardBaseUI.a(this.eAJ, r3);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                    switch (i) {
                        case 0:
                            com.tencent.mm.plugin.card.b.c.a(this.eAJ, Zz, "", /* anonymous class already generated */);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            h(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    public void a(CardInfo cardInfo) {
        this.eAI = cardInfo;
        com.tencent.mm.plugin.card.b.b.a((MMActivity) this, 0, (a) this);
    }

    public final void h(final String str, int i, final boolean z) {
        if (this.eAI == null) {
            v.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.eAI.Zv() == null) {
            v.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.eAI.Zx().mSm)) {
                    stringBuilder.append(getString(2131235509));
                } else {
                    stringBuilder.append(this.eAI.Zx().mSm);
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(11582, new Object[]{"OperGift", Integer.valueOf(2), Integer.valueOf(this.eAI.Zv().eBL), this.eAI.field_card_tp_id, this.eAI.field_card_id, str});
            } else if (i == 1) {
                stringBuilder.append(getString(2131231625, new Object[]{this.eAI.Zv().eCC}));
                com.tencent.mm.plugin.report.service.g.iuh.h(11582, new Object[]{"OperGift", Integer.valueOf(3), Integer.valueOf(this.eAI.Zv().eBL), this.eAI.field_card_tp_id, this.eAI.field_card_id, str});
            }
            com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, stringBuilder.toString(), this.eAI.Zv().eBM, this.eAI.Zv().title + "\n" + this.eAI.Zv().eCD, false, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                final /* synthetic */ CardBaseUI eAJ;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        CardBaseUI.c(this.eAJ, str);
                        com.tencent.mm.ui.base.g.bf(this.eAJ, this.eAJ.getResources().getString(2131231631));
                        if (z) {
                            CardBaseUI cardBaseUI = this.eAJ;
                            String str2 = str;
                            Intent intent = new Intent();
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", str2);
                            com.tencent.mm.plugin.card.a.drp.e(intent, cardBaseUI);
                        }
                    }
                }
            });
        }
    }

    public final void YS() {
        if (this.cCR == null) {
            this.cCR = c.FY();
        }
        if (this.cCR != null) {
            this.cCR.a(this.bYl, true);
        }
    }

    public final void YT() {
        if (this.cCR != null) {
            this.cCR.a(this.bYl, true);
        }
    }

    public final void YU() {
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
    }

    public void YV() {
    }

    public void YW() {
    }

    public void YX() {
    }

    public void YY() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.CardBaseUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case q.CTRL_INDEX /*69*/:
                if (iArr[0] == 0) {
                    YX();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ CardBaseUI eAJ;

                        {
                            this.eAJ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.eAJ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
