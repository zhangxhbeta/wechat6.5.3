package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.k;
import java.util.ArrayList;

public class ShareCardListUI extends CardBaseUI implements d, a {
    private b.a eEo = null;
    boolean eGA = false;
    private long eGB = 0;
    private final long eGC = 500;
    private boolean eGD = false;
    private boolean eGE = false;
    private b eGa;
    private f eGj;
    private e eGk;
    private i eGl;
    private String eGm = null;
    private boolean eGn = false;
    private boolean eGo = true;
    private boolean eGp = false;
    private boolean eGq = true;
    private boolean eGr = true;
    private boolean eGs = false;
    private String eGt = "";
    private boolean eGu = false;
    private boolean eGv = false;
    private boolean eGw = false;
    private int eGx = 0;
    private boolean eGy = false;
    private long eGz = 0;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.eGz = currentTimeMillis;
        NI();
        ak.vy().a(1164, this);
        af.aar().a(this);
        aaW();
        af.aas().c(this);
    }

    protected void onDestroy() {
        if (this.eGy) {
            YU();
        }
        this.eGj.eGa = null;
        this.eGk.eGa = null;
        this.eGa.eEo = null;
        ak.vy().b(1164, this);
        af.aar().b(this);
        b.aaF();
        af.aas().d(this);
        long currentTimeMillis = System.currentTimeMillis() - this.eGz;
        if (TextUtils.isEmpty(this.eGm)) {
            g.iuh.h(13219, new Object[]{"ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(currentTimeMillis)});
        } else {
            g.iuh.h(13219, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected void onResume() {
        ch(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(57);
            iDKey2.SetValue(i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g gVar = g.iuh;
            g.d(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
    }

    private void ch(boolean z) {
        v.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[]{Boolean.valueOf(this.eGo), Boolean.valueOf(z)});
        if (this.eGo) {
            this.eGo = false;
            this.eGu = false;
            this.eGq = true;
            this.eGt = "";
            v.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                aaV();
            } else if (this.eGy && this.eGA) {
                YT();
            }
        }
        aaS();
    }

    protected void onPause() {
        super.onPause();
        this.eGo = false;
        this.eGp = true;
    }

    protected final BaseAdapter YP() {
        return new c(this.nDR.nEl);
    }

    protected final void NI() {
        super.NI();
        v.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.eGy = r0;
        if (this.eGy) {
            aaR();
            return;
        }
        v.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        aaU();
    }

    private void aaR() {
        v.d("MicroMsg.ShareCardListUI", "initLocation");
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ ShareCardListUI eGF;

            {
                this.eGF = r1;
            }

            public final void run() {
                this.eGF.cCR = c.FY();
                this.eGF.YS();
                this.eGF.eGA = true;
                v.d("MicroMsg.ShareCardListUI", "initLocation end");
            }
        });
    }

    protected final void YX() {
        v.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.eGy);
        if (!this.eGy) {
            this.eGy = true;
            aaR();
        }
    }

    protected final void YN() {
        vD(2131231680);
        this.eGa = new b(this);
        this.eEo = new b.a(this) {
            final /* synthetic */ ShareCardListUI eGF;

            {
                this.eGF = r1;
            }
        };
        this.eGa.eEo = this.eEo;
        this.eGa.init();
        this.eGx = b.aaC();
        if (this.eGl == null) {
            this.eGl = new i(this, this.nDR.dtW);
            i iVar = this.eGl;
            iVar.eGG = View.inflate(iVar.eBk, 2130903251, null);
            iVar.eGH = (TextView) iVar.eGG.findViewById(2131755966);
            iVar.eGI = (TextView) iVar.eGG.findViewById(2131755967);
            iVar.av();
        }
        if (this.eGj == null) {
            this.eGj = new f(this, this.nDR.dtW);
            f fVar = this.eGj;
            fVar.eGe = (ImageView) fVar.eEX.findViewById(2131755890);
            fVar.eGg = (TextView) fVar.eEX.findViewById(2131755726);
            fVar.eGf = (TextView) fVar.eEX.findViewById(2131755892);
            this.eGj.eGa = this.eGa;
        }
        if (this.eGk == null) {
            this.eGk = new e(this);
            this.eGk.eGa = this.eGa;
            this.eGk.aaM();
            e eVar = this.eGk;
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ ShareCardListUI eGF;

                {
                    this.eGF = r1;
                }

                public final void onClick(View view) {
                    if (b.aaE() && b.aaD()) {
                        this.eGF.eGx = 2;
                    } else if (b.aaD()) {
                        this.eGF.eGx = 3;
                    }
                    g.iuh.h(11582, new Object[]{"OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", ""});
                    af.aap().putValue("key_share_card_show_type", Integer.valueOf(this.eGF.eGx));
                    this.eGF.aaT();
                    this.eGF.eGk.av();
                    b.eEp = true;
                }
            };
            if (eVar.eFZ != null) {
                eVar.eFZ.setOnClickListener(anonymousClass3);
            }
        }
        if (this.eAD != null) {
            this.eAD.addView(this.eGl.eGG);
        }
        if (this.eAE != null) {
            this.eAE.addView(this.eGk.eFZ);
        }
        this.eAA.setVisibility(0);
        this.eAA.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ShareCardListUI eGF;

            {
                this.eGF = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.eGF.eGr && this.eGF.eGx != 4) {
                    v.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
                    this.eGF.aaV();
                }
            }
        });
        Integer num;
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            ak.yW();
            num = (Integer) com.tencent.mm.model.c.vf().get(t.a.npP, Integer.valueOf(0));
            if (!(num == null || num.intValue() == 1)) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.npP, Integer.valueOf(1));
            }
        } else {
            ak.yW();
            num = (Integer) com.tencent.mm.model.c.vf().get(t.a.npP, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.npP, Integer.valueOf(1));
                com.tencent.mm.plugin.card.b.c.c(this, 2130903258, 2131231690, "");
            }
        }
        this.eGm = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.eGt = getIntent().getStringExtra("key_layout_buff");
        if (!be.kS(this.eGt)) {
            this.eGo = false;
        }
        if (!be.kS(this.eGm)) {
            this.eGn = true;
            this.eGp = true;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        aaW();
        if (intent != null) {
            this.eGm = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!be.kS(this.eGm)) {
                this.eGn = true;
                this.eGp = true;
            }
        }
    }

    private void aaS() {
        long currentTimeMillis = System.currentTimeMillis() - this.eGB;
        if (!this.eGD || currentTimeMillis >= 1000) {
            v.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[]{Boolean.valueOf(this.eGD), Long.valueOf(currentTimeMillis)});
            this.eGD = true;
            if (currentTimeMillis < 500) {
                ad.g(new Runnable(this) {
                    final /* synthetic */ ShareCardListUI eGF;

                    {
                        this.eGF = r1;
                    }

                    public final void run() {
                        this.eGF.eGD = false;
                        if (this.eGF.isFinishing()) {
                            v.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
                        } else {
                            this.eGF.aaS();
                        }
                    }
                }, 500);
                return;
            }
            if (this.eGx == 0 || this.eGx == 4 || ((this.eGx == 2 && !(b.aaE() && b.aaD())) || ((this.eGx == 1 && (!b.aaE() || b.aaD())) || (this.eGx == 3 && (!b.aaD() || b.aaE()))))) {
                this.eGx = b.aaC();
            }
            af.aap().putValue("key_share_card_show_type", Integer.valueOf(this.eGx));
            v.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[]{Integer.valueOf(this.eGx), Boolean.valueOf(b.aaE()), Boolean.valueOf(b.aaD())});
            f fVar = this.eGj;
            fVar.eGf.setVisibility(0);
            fVar.eGe.setImageDrawable(fVar.eBk.getResources().getDrawable(2130837853));
            fVar.eGf.setText(2131231675);
            fVar.eGg.setText(2131231674);
            LayoutParams layoutParams = (LayoutParams) fVar.eGe.getLayoutParams();
            layoutParams.topMargin = fVar.eBk.getResources().getDimensionPixelOffset(2131493374);
            fVar.eGe.setLayoutParams(layoutParams);
            fVar.eGe.invalidate();
            if (b.aaE() || b.aaD()) {
                this.eGk.av();
                this.eGl.av();
                if (this.eGx == 4 && this.eAA.getEmptyView() != null) {
                    this.eAA.setEmptyView(null);
                    this.eAA.invalidate();
                }
            } else {
                this.eGk.aaQ();
                this.eGl.eGG.setVisibility(8);
                if (this.eAA.getEmptyView() != this.eAC) {
                    this.eAA.setEmptyView(this.eAC);
                    this.eAA.invalidate();
                }
            }
            aaT();
            this.eGB = System.currentTimeMillis();
            this.eGD = false;
            return;
        }
        v.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
    }

    private void aaT() {
        if (this.eAB instanceof c) {
            c cVar = (c) this.eAB;
            cVar.eFX = this.eGx;
            cVar.a(null, null);
        }
    }

    protected final void YV() {
        this.eGw = true;
        if (this.eGu) {
            v.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.eGy) {
                YU();
                return;
            }
            return;
        }
        v.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
        this.eGu = true;
        aaU();
        YU();
    }

    protected final void YW() {
        if (this.eGv || this.eGu) {
            YU();
            return;
        }
        this.eGv = true;
        v.i("MicroMsg.ShareCardListUI", "onLocationFail()");
        aaU();
    }

    private void aaU() {
        if (b.aaG() && b.aaH()) {
            v.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
            this.eGr = true;
            return;
        }
        if (!(b.aaG() && b.aaH())) {
            this.eGq = false;
        }
        v.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        aaV();
        af.aaq().l("", "", 4);
    }

    private void aaV() {
        if (this.eGs) {
            v.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            return;
        }
        if (!(!be.kS(this.eGt) || b.aaE() || b.aaD() || b.aaE() || b.aaD())) {
            this.eGk.aaN();
            this.eAA.setEmptyView(null);
            this.eAA.invalidate();
            this.eGE = true;
        }
        if (this.eGq && !be.kS(this.eGt)) {
            this.eGt = "";
        }
        this.eGs = true;
        ak.vy().a(new com.tencent.mm.plugin.card.sharecard.model.b((double) af.aaq().bYf, (double) af.aaq().bYg, this.eGt), 0);
    }

    protected final boolean YQ() {
        return super.YQ();
    }

    protected final boolean YR() {
        return false;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            b.pS(bVar.ZA());
        }
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    protected final void a(com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        v.i("MicroMsg.ShareCardListUI", "card tp id:" + bVar.ZA());
        v.i("MicroMsg.ShareCardListUI", "card id:" + bVar.Zz());
        intent.putExtra("key_card_id", af.aas().qa(bVar.ZA()));
        intent.putExtra("key_card_tp_id", bVar.ZA());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        b.pX(bVar.ZA());
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                if (this.eGE) {
                    this.eGE = false;
                    this.eGk.aaO();
                    this.eAA.setEmptyView(this.eAC);
                    this.eAA.invalidate();
                }
                this.eGs = false;
                this.eGr = true;
            }
            v.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) kVar;
            this.eGs = false;
            this.eGt = bVar.eEw;
            this.eGa.N(bVar.eDn, this.eGq);
            if (!(b.aaG() && b.aaH())) {
                this.eGq = false;
            }
            if (!(b.aaG() && b.aaH())) {
                z = false;
            }
            this.eGr = z;
            v.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            aaS();
        }
    }

    public final void ZG() {
        b.aaB();
        this.eGo = true;
        v.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[]{Boolean.valueOf(this.eGp), Boolean.valueOf(this.eAG), Boolean.valueOf(this.eGw)});
        if (this.eGp && this.eAG && this.eGw) {
            ch(false);
        } else {
            aaS();
        }
        this.eGp = false;
    }

    public final void a(String str, i iVar) {
        v.d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.eGo = true;
    }

    private void aaW() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean ax = com.tencent.mm.p.c.us().ax(262152, 266256);
        boolean ay = com.tencent.mm.p.c.us().ay(262152, 266256);
        boolean a = com.tencent.mm.p.c.us().a(t.a.npx, t.a.npz);
        boolean a2 = com.tencent.mm.p.c.us().a(t.a.npy, t.a.npA);
        ak.yW();
        String ma = be.ma((String) com.tencent.mm.model.c.vf().get(t.a.npD, null));
        if (ax) {
            g.iuh.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (ay) {
            g.iuh.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (a && !a2) {
            g.iuh.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (a && a2) {
            g.iuh.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (a2) {
            g.iuh.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else {
            g.iuh.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        }
    }
}
