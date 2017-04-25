package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.mm.modelsearch.j;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.a.a;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.f.f.b;
import java.util.HashSet;

public final class e extends b implements b {
    private boolean gYJ;
    private ac iGN = new ac(Looper.getMainLooper());
    private int iHC;
    private f iHD;
    private com.tencent.mm.modelsearch.f iHE;
    private boolean iHF;
    private boolean iHG;
    private ac iHH = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ e iHI;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.iHI.iHD.a(this.iHI.bkC, this.iHI.iGN, null);
                    return;
                case 1:
                    v.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                    if (!this.iHI.iHG && this.iHI.getCount() > 0) {
                        com.tencent.mm.ui.f.e.bIM().aMI();
                        ak.lye.start();
                        this.iHI.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public e(c cVar, int i, int i2) {
        super(cVar);
        this.iHC = i;
        Context context = getContext();
        int i3 = -1;
        switch (i) {
            case -13:
                i3 = 4208;
                break;
            case -7:
                i3 = 4192;
                break;
            case -5:
                i3 = 4144;
                break;
            case -4:
                i3 = 4112;
                break;
            case -3:
                i3 = 4128;
                break;
            case ai.CTRL_INDEX /*-2*/:
                i3 = 4160;
                break;
            case -1:
                i3 = 4176;
                break;
        }
        v.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i3)});
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.iHD = (f) com.tencent.mm.ui.f.e.a(hashSet, context, this, i2).get(0);
        this.iHE = new com.tencent.mm.modelsearch.f();
    }

    protected final a pe(int i) {
        a pe = this.iHD.pe(i);
        if (pe != null) {
            pe.oJg = i;
        }
        return pe;
    }

    protected final void aMm() {
        this.gYJ = true;
        this.iHF = false;
        this.iHE.reset();
        this.iHD.a(this.bkC, this.iGN, null);
    }

    protected final void clearCache() {
        super.clearCache();
        this.iHD.ua();
        this.iHD.bIJ();
        this.iHH.removeMessages(0);
        this.iHH.removeMessages(1);
    }

    protected final boolean a(a aVar) {
        if (aVar.imS) {
            int i;
            String str;
            v.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[]{Integer.valueOf(aVar.iHC), Integer.valueOf(aVar.iHJ), Integer.valueOf(aVar.oJg), Integer.valueOf(aVar.oPu), aVar.oPv, Long.valueOf(aVar.oPw)});
            if (!this.iHF) {
                j.a(this.bkC, true, getCount(), aVar.iHC, false);
                this.iHF = true;
            }
            com.tencent.mm.modelsearch.f fVar = this.iHE;
            int i2 = aVar.oJg;
            String str2 = aVar.oPv;
            long j = aVar.oPw;
            int f = j.f(aVar.oJf, aVar.oJe, aVar.aMM());
            switch (aVar.eKg) {
                case 1:
                    i = 3;
                    break;
                case 2:
                    i = 4;
                    break;
                case 3:
                    i = 10;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 16;
                    break;
                case 6:
                    i = 11;
                    break;
                case 7:
                    i = 12;
                    break;
                case 8:
                    i = 13;
                    break;
                case 9:
                    i = 14;
                    break;
                case as.CTRL_INDEX /*13*/:
                    i = 17;
                    break;
                case an.CTRL_INDEX /*14*/:
                    i = 15;
                    break;
                case 16:
                    c cVar = new c();
                    str = aVar.bkC;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    cVar.n("20KeyWordId", str + ",");
                    cVar.n("21ViewType", "2,");
                    cVar.n("22OpType", "2,");
                    cVar.n("23ResultCount", ",");
                    cVar.n("24ClickPos", aVar.oPu + ",");
                    cVar.n("25ClickAppUserName", aVar.info + ",");
                    v.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[]{cVar.JH()});
                    g.iuh.h(13963, new Object[]{cVar});
                    i = 19;
                    break;
            }
            long currentTimeMillis = System.currentTimeMillis() - fVar.cVG;
            if (currentTimeMillis < 0 || fVar.cVG == 0) {
                currentTimeMillis = 0;
            }
            v.v("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", new Object[]{String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(aVar.iHJ), Integer.valueOf(i), Integer.valueOf(i2), be.ah(str2, ""), Long.valueOf(j), Integer.valueOf(f), Integer.valueOf(aVar.YM()), Integer.valueOf(j.fX(aVar.aML())), aVar.asE(), Long.valueOf(currentTimeMillis), Integer.valueOf(fVar.cVH)})});
            g.iuh.Y(11310, str);
        }
        return false;
    }

    public final void finish() {
        if (!this.iHF) {
            j.a(this.bkC, false, getCount(), this.iHC, false);
            this.iHF = true;
        }
        this.iHE.reset();
        super.finish();
    }

    public final void a(f fVar, String str) {
        if (str.equals(this.bkC)) {
            this.gYJ = false;
        }
        pf(fVar.xY(0));
        notifyDataSetChanged();
        D(getCount(), true);
        this.iHE.cVG = System.currentTimeMillis();
        com.tencent.mm.modelsearch.f fVar2 = this.iHE;
        for (f.a aVar : ((com.tencent.mm.ui.f.c) fVar).oPj) {
            fVar2.cVH = aVar.iHv.size() + fVar2.cVH;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iHG = true;
            com.tencent.mm.ui.f.e.bIM().aMG();
            ak.lye.pause();
            v.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            return;
        }
        this.iHG = false;
        if (!com.tencent.mm.ui.f.e.bIM().aMH()) {
            this.iHH.removeMessages(1);
            this.iHH.sendEmptyMessageDelayed(1, 200);
        }
    }
}
