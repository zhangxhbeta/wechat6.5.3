package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseLifeUI extends MMActivity implements e {
    boolean bYh = false;
    protected String bpB = "";
    boolean cAv = false;
    protected boolean cJA = true;
    private p eSv;
    MMLoadMoreListView gXJ;
    boolean gYJ = false;
    public int gYq = -1;
    private boolean hFw = false;
    private int hGA;
    private List<afu> hGB;
    protected afu hGC = null;
    protected float hGD = 0.0f;
    protected float hGE = 0.0f;
    protected int hGF = 0;
    protected float hGG = 0.0f;
    protected long hGH = -1;
    protected long hGI = -1;
    protected long hGJ = -1;
    protected int hGK = 0;
    protected boolean hGL = false;
    protected int hGM = -1;
    protected boolean hGN = false;
    int hGO = 0;
    private OnClickListener hGP = new OnClickListener(this) {
        final /* synthetic */ BaseLifeUI hGS;

        {
            this.hGS = r1;
        }

        public final void onClick(View view) {
            BaseLifeUI.a(this.hGS);
        }
    };
    private OnClickListener hGQ = new OnClickListener(this) {
        final /* synthetic */ BaseLifeUI hGS;

        {
            this.hGS = r1;
        }

        public final void onClick(View view) {
            if (this.hGS.hGC == null) {
                v.e("MicroMsg.BaseLifeUI", "Location is null");
                return;
            }
            g.iuh.h(11138, new Object[]{"1", Integer.valueOf(this.hGS.hGu.getCount() + 1), this.hGS.bpB});
            Intent intent = new Intent();
            intent.setClass(this.hGS, NearLifeCreatePoiUI.class);
            intent.putExtra("get_lat", this.hGS.hGC.mjN);
            intent.putExtra("get_lng", this.hGS.hGC.mjM);
            intent.putExtra("get_preci", this.hGS.hGC.mrA);
            intent.putExtra("get_poi_name", this.hGS.hGu.hGf);
            intent.putExtra("get_cur_lat", this.hGS.hGD);
            intent.putExtra("get_cur_lng", this.hGS.hGE);
            intent.putExtra("get_accuracy", this.hGS.hGG);
            intent.putExtra("get_loctype", this.hGS.hGF);
            intent.putExtra("search_id", this.hGS.bpB);
            intent.putExtra("get_is_mars", this.hGS.cJA);
            this.hGS.startActivityForResult(intent, 1);
        }
    };
    private a hGR = new a(this) {
        final /* synthetic */ BaseLifeUI hGS;

        {
            this.hGS = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (this.hGS.cAv) {
                return false;
            }
            if (this.hGS.bYh) {
                return false;
            }
            if (!z) {
                return true;
            }
            n.a(2003, f, f2, (int) d2);
            this.hGS.bYh = true;
            v.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            this.hGS.hGC = new afu();
            this.hGS.hGC.mrC = "";
            this.hGS.hGC.mrD = 0;
            this.hGS.hGC.mjN = f2;
            this.hGS.hGC.mjM = f;
            this.hGS.hGC.mrB = "";
            this.hGS.hGC.mrA = (int) d2;
            this.hGS.hGD = f2;
            this.hGS.hGE = f;
            this.hGS.hGF = i;
            this.hGS.hGG = (float) d2;
            this.hGS.cJA = this.hGS.hGy == null ? false : this.hGS.hGy.cJA;
            ArrayList arrayList = this.hGS.hGt.hGk;
            if (arrayList == null || arrayList.size() <= 0) {
                this.hGS.j((double) f2, (double) f);
            } else {
                LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
                this.hGS.j((double) latLongData.bhs, (double) latLongData.cNt);
                this.hGS.hGN = BaseLifeUI.b(latLongData.bhs, latLongData.cNt, f2, f);
            }
            this.hGS.hGt.hGo = new LatLongData(this.hGS.hGC.mjN, this.hGS.hGC.mjM);
            this.hGS.hGu.hGo = new LatLongData(this.hGS.hGC.mjN, this.hGS.hGC.mjM);
            BaseLifeUI.a(this.hGS, this.hGS.gYJ ? this.hGS.hGu : this.hGS.hGt);
            this.hGS.aDN();
            this.hGS.a(this.hGS.eSv);
            return false;
        }
    };
    private String hGg = "";
    private View hGr;
    private NearLifeErrorContent hGs;
    private a hGt;
    private a hGu;
    private View hGv;
    private TextView hGw;
    private TextView hGx;
    private c hGy = c.FY();
    private b hGz;

    public abstract a aDK();

    public abstract a aDL();

    public abstract void j(double d, double d2);

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.hGA != -1 || baseLifeUI.hGz != null) {
            v.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.aDN()) {
            baseLifeUI.gXJ.bCk();
        }
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, a aVar) {
        if (baseLifeUI.hGC == null) {
            v.e("MicroMsg.BaseLifeUI", "location is null");
            return;
        }
        Map hashMap = new HashMap();
        baseLifeUI.hGB.clear();
        if (aVar.hGp && baseLifeUI.hGC != null) {
            baseLifeUI.hGB.add(baseLifeUI.hGC);
            hashMap.put(new LatLongData(baseLifeUI.hGC.mjN, baseLifeUI.hGC.mjM), Integer.valueOf(1));
        }
        Iterator it = aVar.hGk.iterator();
        while (it.hasNext()) {
            LatLongData latLongData = (LatLongData) it.next();
            if (!hashMap.containsKey(latLongData)) {
                afu com_tencent_mm_protocal_c_afu = new afu();
                com_tencent_mm_protocal_c_afu.mrC = "";
                com_tencent_mm_protocal_c_afu.mrD = 0;
                com_tencent_mm_protocal_c_afu.mjN = latLongData.bhs;
                com_tencent_mm_protocal_c_afu.mjM = latLongData.cNt;
                com_tencent_mm_protocal_c_afu.mrB = "";
                com_tencent_mm_protocal_c_afu.mrA = 0;
                baseLifeUI.hGB.add(com_tencent_mm_protocal_c_afu);
                hashMap.put(latLongData, Integer.valueOf(1));
            }
        }
        baseLifeUI.hGz = null;
        baseLifeUI.hGA = -1;
        v.i("MicroMsg.BaseLifeUI", "list size:" + baseLifeUI.hGB.size() + " show curpos: " + aVar.hGp);
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, String str) {
        v.d("MicroMsg.BaseLifeUI", "notreal onSearchBtnClick  %s", new Object[]{str});
        if (!be.kS(str)) {
            if (baseLifeUI.hGz == null || !str.equals(baseLifeUI.hGz.hGf)) {
                baseLifeUI.nC(8);
                if (baseLifeUI.hGz != null) {
                    ak.vy().c(baseLifeUI.hGz);
                }
                if (baseLifeUI.hGC != null) {
                    baseLifeUI.hGu.aDI();
                    a aVar = baseLifeUI.hGu;
                    if (str != null) {
                        aVar.hGf = str;
                    }
                    baseLifeUI.aDN();
                    baseLifeUI.gXJ.bCk();
                }
            }
        }
    }

    static /* synthetic */ boolean b(float f, float f2, float f3, float f4) {
        return k.c((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }

    public void aDM() {
        v.d("MicroMsg.BaseLifeUI", "init header");
        this.hGv = View.inflate(this, 2130903440, null);
        this.hGw = (TextView) this.hGv.findViewById(2131756550);
        this.hGx = (TextView) this.hGv.findViewById(2131756549);
        this.hGv.setOnClickListener(this.hGQ);
        this.hGr = View.inflate(this, 2130904169, null);
        this.gXJ.addFooterView(this.hGr);
        this.hGr.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gYq = (int) (System.currentTimeMillis() / 1000);
        b.clear();
        ak.vy().a(603, this);
        this.hGO = getIntent().getIntExtra("near_life_scene", 0);
        this.hGB = new ArrayList();
        NI();
        this.gXJ.bCk();
        if (this.hGy != null) {
            this.hGy.b(this.hGR);
        }
        this.cAv = false;
    }

    public final void NI() {
        this.gXJ = (MMLoadMoreListView) findViewById(2131758402);
        MMLoadMoreListView mMLoadMoreListView = this.gXJ;
        mMLoadMoreListView.nWC.setText(getString(2131233980));
        this.hGs = (NearLifeErrorContent) findViewById(2131758403);
        aDM();
        this.hGt = aDK();
        this.hGu = aDL();
        this.gXJ.setAdapter(this.hGt);
        this.hGs.dyx = this.gXJ;
        this.hGt.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BaseLifeUI hGS;

            {
                this.hGS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hGS.a(-1, false, "");
                this.hGS.finish();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ BaseLifeUI hGS;

            {
                this.hGS = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.hGS.gXJ);
            }
        };
        this.eSv = new p(false, true);
        p pVar = this.eSv;
        AnonymousClass5 anonymousClass5 = new SearchViewNotRealTimeHelper.a(this) {
            final /* synthetic */ BaseLifeUI hGS;

            {
                this.hGS = r1;
            }

            public final boolean mk(String str) {
                v.d("MicroMsg.BaseLifeUI", "notreal onSearchKeyDown  %s", new Object[]{str});
                BaseLifeUI.a(this.hGS, str);
                return false;
            }

            public final void pA(String str) {
                BaseLifeUI.a(this.hGS, str);
                this.hGS.axg();
            }

            public final void YC() {
                v.d("MicroMsg.BaseLifeUI", "notreal onSearchKeyDown");
            }

            public final void YD() {
                v.d("MicroMsg.BaseLifeUI", "notreal onHomeBtnClick");
            }
        };
        pVar.oUt = anonymousClass5;
        if (pVar.oUr != null) {
            pVar.oUr.a(anonymousClass5);
        }
        this.eSv.oUs = new p.b(this) {
            final /* synthetic */ BaseLifeUI hGS;

            {
                this.hGS = r1;
            }

            public final void Oh() {
            }

            public final void ml(String str) {
                v.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[]{str});
            }

            public final void Of() {
                v.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                this.hGS.gYJ = false;
                this.hGS.gXJ.setAdapter(this.hGS.hGt);
                this.hGS.hGt.notifyDataSetChanged();
                this.hGS.hGs.nD(this.hGS.hGt.hGq);
                if (!(this.hGS.hGt.aDJ() || this.hGS.hGr == null)) {
                    this.hGS.hGr.setVisibility(0);
                }
                this.hGS.nC(8);
                BaseLifeUI.a(this.hGS, this.hGS.hGt);
            }

            public final void Og() {
                v.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                this.hGS.hGL = true;
                this.hGS.eSv.setHint(this.hGS.getString(2131233979));
                this.hGS.gYJ = true;
                this.hGS.hGu.aDI();
                this.hGS.gXJ.setAdapter(this.hGS.hGu);
                this.hGS.hGu.notifyDataSetChanged();
                this.hGS.gXJ.bCj();
                this.hGS.hGs.nD(this.hGS.hGu.hGq);
                if (this.hGS.hGr != null) {
                    this.hGS.hGr.setVisibility(8);
                }
                BaseLifeUI.a(this.hGS, this.hGS.hGu);
            }

            public final boolean mk(String str) {
                return false;
            }
        };
        this.gXJ.nWA = new MMLoadMoreListView.a(this) {
            final /* synthetic */ BaseLifeUI hGS;

            {
                this.hGS = r1;
            }

            public final void adB() {
                BaseLifeUI.a(this.hGS);
            }
        };
        this.gXJ.bCi();
    }

    protected void onResume() {
        super.onResume();
        this.hGt.notifyDataSetChanged();
        this.hGy.a(this.hGR, true);
    }

    protected void onDestroy() {
        ak.vy().b(603, this);
        super.onDestroy();
        if (this.hGy != null) {
            this.hGy.c(this.hGR);
        }
    }

    protected void onPause() {
        super.onPause();
        this.hGy.c(this.hGR);
    }

    protected int getLayoutId() {
        return 2130904112;
    }

    private boolean aDN() {
        while (this.hGz == null) {
            if (this.hGB.size() - 1 <= this.hGA) {
                this.hGA = -1;
                v.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.hGA++;
            afu com_tencent_mm_protocal_c_afu = (afu) this.hGB.get(this.hGA);
            if (this.hGA == 0) {
                this.hGK++;
            }
            if (this.gYJ) {
                b = this.hGu.b(new LatLongData(com_tencent_mm_protocal_c_afu.mjN, com_tencent_mm_protocal_c_afu.mjM));
                continue;
            } else {
                b = this.hGt.b(new LatLongData(com_tencent_mm_protocal_c_afu.mjN, com_tencent_mm_protocal_c_afu.mjM));
                continue;
            }
            if (b > 0) {
                are a;
                int i;
                if (this.gYJ) {
                    a = this.hGu.a(new LatLongData(com_tencent_mm_protocal_c_afu.mjN, com_tencent_mm_protocal_c_afu.mjM));
                } else {
                    a = this.hGt.a(new LatLongData(com_tencent_mm_protocal_c_afu.mjN, com_tencent_mm_protocal_c_afu.mjM));
                }
                if (this.gYJ) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (b.nA(i)) {
                    if (-1 == this.hGH) {
                        this.hGH = System.currentTimeMillis();
                    }
                    this.hGz = new b(i, this.hGO, com_tencent_mm_protocal_c_afu.mjM, com_tencent_mm_protocal_c_afu.mjN, com_tencent_mm_protocal_c_afu.mrA, com_tencent_mm_protocal_c_afu.mrD, com_tencent_mm_protocal_c_afu.mrB, com_tencent_mm_protocal_c_afu.mrC, a, this.gYJ ? this.hGu.hGf : "", this.gYq);
                    ak.vy().a(this.hGz, 0);
                    v.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[]{Integer.valueOf(this.hGA), Float.valueOf(com_tencent_mm_protocal_c_afu.mjN), Float.valueOf(com_tencent_mm_protocal_c_afu.mjM)});
                    return true;
                }
                this.hGA = -1;
                return false;
            }
        }
        v.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() == 603) {
            this.gXJ.bCj();
            b bVar = (b) kVar;
            if (!be.kS(bVar.hGg)) {
                this.hGg = bVar.hGg;
                LogoImageView logoImageView = (LogoImageView) this.hGr.findViewById(2131758579);
                String str2 = this.hGg;
                ak.yW();
                logoImageView.imagePath = com.tencent.mm.model.c.wQ();
                logoImageView.url = str2;
                logoImageView.gVE = 0;
                logoImageView.fQm = 0;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    r2 = BitmapFactory.decodeFile(logoImageView.imagePath + com.tencent.mm.a.g.m(str2.getBytes()));
                    if (r2 != null) {
                        if (logoImageView.gVE > 0 && logoImageView.fQm > 0) {
                            r2 = d.a(r2, logoImageView.gVE, logoImageView.fQm, true, false);
                        }
                        logoImageView.setImageBitmap(r2);
                    } else {
                        com.tencent.mm.sdk.i.e.a(new a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (com.tencent.mm.a.e.aR(str2)) {
                    r2 = (logoImageView.gVE <= 0 || logoImageView.fQm <= 0) ? d.JV(str2) : d.b(str2, logoImageView.gVE, logoImageView.fQm, true);
                    if (r2 == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(r2);
                    }
                } else {
                    logoImageView.setVisibility(8);
                }
            }
            this.bpB = bVar.bpB;
            b.nB(((b) kVar).bdf);
            if (this.hGz != null) {
                v.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[]{Integer.valueOf(this.hGA), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1)});
                boolean z = i2 == 0 || i2 == 101;
                a aVar;
                if (i == 0 || z) {
                    if (-1 == this.hGI) {
                        this.hGI = System.currentTimeMillis();
                    }
                    this.hGJ = System.currentTimeMillis();
                    List list = ((xb) bVar.cif.czl.czs).mzs;
                    afu com_tencent_mm_protocal_c_afu = (afu) this.hGB.get(this.hGA);
                    LatLongData latLongData = new LatLongData(com_tencent_mm_protocal_c_afu.mjN, com_tencent_mm_protocal_c_afu.mjM);
                    if (this.gYJ) {
                        this.hGu.a(latLongData, bVar.aDH(), bVar.aDG());
                    } else {
                        this.hGt.a(latLongData, bVar.aDH(), bVar.aDG());
                    }
                    if (list == null || list.size() == 0) {
                        aVar = this.gYJ ? this.hGu : this.hGt;
                        if (this.hGB.size() - 1 == this.hGA) {
                            if (aVar.getCount() == 0) {
                                this.hGs.nD(aVar.hGq);
                            }
                            this.gXJ.bCj();
                            if (!(aVar.aDJ() || i2 == 101)) {
                                aDO();
                            }
                        }
                    } else {
                        aVar = this.gYJ ? this.hGu : this.hGt;
                        this.gXJ.setVisibility(0);
                        aVar.hGq = 0;
                        this.hGs.nD(this.hGu.hGq);
                        aVar.a(latLongData, list);
                        aVar.notifyDataSetChanged();
                        if (this.hGB.size() - 1 == this.hGA && !aVar.aDJ()) {
                            this.gXJ.bCj();
                            aDO();
                        }
                    }
                    if (!(this.hGt.aDJ() || this.hGr == null || this.gYJ)) {
                        this.hGr.setVisibility(0);
                    }
                    if (this.hGr != null && !this.gYJ) {
                        this.hGr.setVisibility(0);
                    } else if (this.hGr != null) {
                        this.hGr.setVisibility(8);
                    }
                } else {
                    v.d("MicroMsg.BaseLifeUI", "error");
                    if (this.gYJ) {
                        aVar = this.hGu;
                    } else {
                        aVar = this.hGt;
                    }
                    if (this.hGB.size() - 1 == this.hGA && aVar.getCount() == 0) {
                        aVar.hGq = 1;
                        this.hGs.nD(aVar.hGq);
                    }
                }
                this.hGz = null;
                aDN();
            }
        }
    }

    private void aDO() {
        if (this.gYJ) {
            int i;
            try {
                v.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[]{Integer.valueOf(Integer.valueOf(j.sU().getValue("POICreateForbiden")).intValue())});
                if (Integer.valueOf(j.sU().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            a aVar = this.hGu;
            String trim = this.hGu.hGf.trim();
            Iterator it = aVar.hGi.iterator();
            while (it.hasNext()) {
                if (trim.equals(((aft) it.next()).aXz.trim())) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                this.hGw.setText(String.format(getResources().getString(2131234044), new Object[]{this.hGu.hGf}));
                nC(0);
                return;
            }
            nC(8);
            return;
        }
        v.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    protected final void a(int i, boolean z, String str) {
        int i2;
        String str2;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        if (i >= 0) {
            i2 = true == z ? 3 : 1;
            if (this.hGN) {
                int i3;
                g gVar = g.iuh;
                Object[] objArr = new Object[1];
                if (z) {
                    i3 = 5;
                } else {
                    i3 = 4;
                }
                objArr[0] = Integer.valueOf(i3);
                gVar.h(11139, objArr);
            }
        } else {
            i2 = true == this.hGL ? 4 : 2;
        }
        if (this.hGC == null) {
            str2 = "null/null";
        } else {
            str2 = String.format("%f/%f", new Object[]{Float.valueOf(this.hGC.mjN), Float.valueOf(this.hGC.mjM)});
        }
        g.iuh.h(11135, new Object[]{Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.hGH), Long.valueOf(this.hGJ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.hGI), Integer.valueOf(this.hGK), str2, str, Integer.valueOf(this.gYq), this.bpB, com.tencent.mm.compatible.d.p.rJ()});
    }

    private void nC(int i) {
        this.gXJ.removeFooterView(this.hGr);
        this.gXJ.removeFooterView(this.hGv);
        MMLoadMoreListView mMLoadMoreListView = this.gXJ;
        mMLoadMoreListView.removeFooterView(mMLoadMoreListView.fgW);
        this.hGv.setVisibility(i);
        this.hGw.setVisibility(i);
        this.hGx.setVisibility(i);
        if (i == 0) {
            this.gXJ.addFooterView(this.hGv);
            return;
        }
        mMLoadMoreListView = this.gXJ;
        if (mMLoadMoreListView.fgW == null) {
            mMLoadMoreListView.bCh();
        }
        try {
            mMLoadMoreListView.removeFooterView(mMLoadMoreListView.fgW);
            mMLoadMoreListView.addFooterView(mMLoadMoreListView.fgW);
        } catch (Exception e) {
        }
        this.gXJ.addFooterView(this.hGr);
    }
}
