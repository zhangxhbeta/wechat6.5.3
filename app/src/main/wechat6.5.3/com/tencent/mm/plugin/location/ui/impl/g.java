package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.d;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.6;
import com.tencent.mm.plugin.location.ui.l.7;
import com.tencent.mm.plugin.location.ui.l.8;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends i implements a {
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ g gZq;

        {
            this.gZq = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            v.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d)});
            if (f.e(d) && !this.gZq.gZd.gWp) {
                v.d("MicroMsg.ShareMapUI", "set driving mode");
                this.gZq.gZd.gWs = false;
                this.gZq.gZd.dY(true);
                this.gZq.gZb.awC();
            }
            return true;
        }
    };
    private View gVc;
    private m.a gWz = new m.a(this) {
        final /* synthetic */ g gZq;

        {
            this.gZq = r1;
        }
    };
    private Button gZa;
    MyLocationButton gZb;
    private TipSayingWidget gZc;
    m gZd;
    o gZe = l.awi();
    com.tencent.mm.plugin.location.ui.l gZf;
    k gZg;
    private i gZh;
    private c gZi = c.FY();
    private ShareHeader gZj;
    private String gZk;
    private long gZl = 0;
    private long gZm = 0;
    private b gZn = new b(this) {
        final /* synthetic */ g gZq;

        {
            this.gZq = r1;
        }

        public final void awv() {
            v.i("MicroMsg.ShareMapUI", "onJoinSucess");
            o oVar = this.gZq.gZe;
            oVar.gSZ = true;
            oVar.awr();
            oVar.aws();
            this.gZq.gZd.dZ(true);
            if (this.gZq.gZg != null) {
                this.gZq.gZg.awL();
            }
        }

        public final void a(aqa com_tencent_mm_protocal_c_aqa) {
            g.a(this.gZq, com_tencent_mm_protocal_c_aqa);
        }

        public final void onError(int i, String str) {
            v.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[]{Integer.valueOf(i), str});
            com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"7", "", Integer.valueOf(0), Integer.valueOf(0)});
            com.tencent.mm.plugin.location.ui.l lVar = this.gZq.gZf;
            v.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[]{str});
            Context context = aa.getContext();
            String str2 = null;
            if (!be.kS(str)) {
                str2 = str;
            } else if (i == 0) {
                str2 = context.getString(2131233528);
            } else if (i == 1) {
                str2 = context.getString(2131233532);
            } else if (i == 2) {
                str2 = context.getString(2131233533);
            }
            com.tencent.mm.ui.base.g.a(lVar.mContext, str2, "", lVar.BE.getString(2131231107), false, new 8(lVar, i));
        }

        public final void aww() {
            this.gZq.gZd.dZ(false);
            this.gZq.gZe.stop();
            this.gZq.gZe.mp(3);
            k.awO();
            this.gZq.aXH.finish();
            this.gZq.aXH.overridePendingTransition(2130968645, 2130968647);
        }
    };
    private o.a gZo = new o.a(this) {
        final /* synthetic */ g gZq;

        {
            this.gZq = r1;
        }

        public final void awu() {
            g gVar = this.gZq;
            h.a aVar = new h.a(gVar.aXH);
            aVar.wn(2131235698);
            aVar.wp(2131231107).a(new OnClickListener(gVar) {
                final /* synthetic */ g gZq;

                {
                    this.gZq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.gZq.gZd.dZ(false);
                    this.gZq.gZe.stop();
                    this.gZq.gZe.mp(2);
                    k.awO();
                    this.gZq.aXH.finish();
                }
            });
            aVar.RX().show();
        }
    };
    private HashMap<String, bda> gZp = new HashMap();
    private WakeLock wakeLock;

    static /* synthetic */ void a(g gVar, aqa com_tencent_mm_protocal_c_aqa) {
        com.tencent.mm.plugin.location.a.a aVar;
        bda com_tencent_mm_protocal_c_bda;
        v.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", new Object[]{Boolean.valueOf(gVar.gZe.aSZ)});
        List<bda> list = com_tencent_mm_protocal_c_aqa.mPu;
        List<bda> linkedList = new LinkedList();
        com.tencent.mm.plugin.location.a.a vI = l.awj().vI(gVar.gTc);
        if (vI == null) {
            vI = new com.tencent.mm.plugin.location.a.a();
            vI.latitude = -1000.0d;
            vI.longitude = -1000.0d;
            aVar = vI;
        } else {
            aVar = vI;
        }
        LinkedList linkedList2 = new LinkedList();
        for (bda com_tencent_mm_protocal_c_bda2 : list) {
            linkedList2.add(com_tencent_mm_protocal_c_bda2.mdw);
        }
        if (!linkedList2.contains(com.tencent.mm.model.k.xF())) {
            linkedList2.add(com.tencent.mm.model.k.xF());
        }
        l.awj().a(gVar.gTc, linkedList2, aVar.latitude, aVar.longitude, aVar.gRG, "", "");
        for (bda com_tencent_mm_protocal_c_bda22 : list) {
            if (Math.abs(com_tencent_mm_protocal_c_bda22.mZb.mhY) > 180.0d || Math.abs(com_tencent_mm_protocal_c_bda22.mZb.mhZ) > 90.0d) {
                bda com_tencent_mm_protocal_c_bda3 = (bda) gVar.gZp.get(com_tencent_mm_protocal_c_bda22.mdw);
                if (com_tencent_mm_protocal_c_bda3 != null) {
                    linkedList.add(com_tencent_mm_protocal_c_bda3);
                    v.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", new Object[]{com_tencent_mm_protocal_c_bda22.mdw, Double.valueOf(com_tencent_mm_protocal_c_bda22.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda22.mZb.mhY), Double.valueOf(com_tencent_mm_protocal_c_bda3.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda3.mZb.mhY)});
                } else {
                    v.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", new Object[]{com_tencent_mm_protocal_c_bda22.mdw, Double.valueOf(com_tencent_mm_protocal_c_bda22.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda22.mZb.mhY)});
                }
            } else {
                linkedList.add(com_tencent_mm_protocal_c_bda22);
            }
        }
        gVar.gZp.clear();
        for (bda com_tencent_mm_protocal_c_bda222 : linkedList) {
            gVar.gZp.put(com_tencent_mm_protocal_c_bda222.mdw, com_tencent_mm_protocal_c_bda222);
        }
        int size = linkedList.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mm.model.k.xF());
        if (size >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("refreshSuccess, count =  " + size);
            for (int i = 0; i < linkedList.size(); i++) {
                com_tencent_mm_protocal_c_bda222 = (bda) linkedList.get(i);
                stringBuilder.append("[" + com_tencent_mm_protocal_c_bda222.mdw + " ] ");
                stringBuilder.append(com_tencent_mm_protocal_c_bda222.mZb.mNp + " ");
                stringBuilder.append(com_tencent_mm_protocal_c_bda222.mZb.mhZ + " ");
                stringBuilder.append(com_tencent_mm_protocal_c_bda222.mZb.mhY + " ");
                arrayList.add(com_tencent_mm_protocal_c_bda222.mdw);
            }
            v.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (gVar.gZd != null) {
                gVar.gZd.aH(linkedList);
            }
        }
        if (gVar.gZd.gWo) {
            m mVar = gVar.gZd;
            azu com_tencent_mm_protocal_c_azu = com_tencent_mm_protocal_c_aqa.mPv;
            if (mVar.gWr == null) {
                mVar.gWr = new azu();
            }
            if (com_tencent_mm_protocal_c_azu != null) {
                v.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + com_tencent_mm_protocal_c_azu.mhZ + " " + com_tencent_mm_protocal_c_azu.mhY);
                mVar.gWr.mMa = com_tencent_mm_protocal_c_azu.mMa;
                mVar.gWr.mhZ = com_tencent_mm_protocal_c_azu.mhZ;
                mVar.gWr.mhY = com_tencent_mm_protocal_c_azu.mhY;
            }
        }
        gVar.gZh.H(arrayList);
    }

    public final boolean axh() {
        return true;
    }

    public g(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.ShareMapUI", "onCreate");
        this.gZl = System.currentTimeMillis();
    }

    final void axf() {
        super.axf();
        this.wakeLock = ((PowerManager) this.aXH.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.gZL != null) {
            n nVar = this.gZL;
            nVar.gWX.setVisibility(4);
            nVar.isVisible = false;
        }
        findViewById(2131758187).setVisibility(8);
        this.gZb = (MyLocationButton) findViewById(2131757409);
        MyLocationButton myLocationButton = this.gZb;
        myLocationButton.gTY = this.gXj.gUq;
        myLocationButton.gTX.setVisibility(0);
        myLocationButton.gTW.setVisibility(8);
        c.FY().a(myLocationButton.bYl);
        this.gZb.awB();
        this.gZb.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ g gZq;

            {
                this.gZq = r1;
            }

            public final void onClick(View view) {
                this.gZq.gZb.awB();
                this.gZq.gZd.gWs = true;
                this.gZq.gZd.a(this.gZq.gXj.gUq);
                this.gZq.gZd.dY(false);
                com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"6", "", Integer.valueOf(0), Integer.valueOf(0)});
            }
        });
        this.gVc = findViewById(2131759183);
        this.gZj = (ShareHeader) findViewById(2131757419);
        this.gZj.setVisibility(0);
        this.gZh = new i(this.aXH, this.gZj.gUN, this.gVc, this.gTc, this.gXj.gUq);
        this.gZh.gVi = new i.a(this) {
            final /* synthetic */ g gZq;

            {
                this.gZq = r1;
            }

            public final void vQ(String str) {
                TrackPoint trackPoint = (TrackPoint) this.gZq.gXj.gUq.getViewByItag(str);
                if (trackPoint != null) {
                    d dVar;
                    trackPoint.bringToFront();
                    this.gZq.gXj.gUq.invalidate();
                    m mVar = this.gZq.gZd;
                    if (!be.kS(str)) {
                        if (mVar.gSX == null || !str.equals(mVar.gSX.mdw)) {
                            if (mVar.gWh != null && mVar.gWh.size() > 0) {
                                for (bda com_tencent_mm_protocal_c_bda : mVar.gWh) {
                                    if (com_tencent_mm_protocal_c_bda.mdw.equals(str)) {
                                        dVar = new d(com_tencent_mm_protocal_c_bda.mZb.mhY, com_tencent_mm_protocal_c_bda.mZb.mhZ);
                                        break;
                                    }
                                }
                            }
                        }
                        dVar = new d(mVar.gSX.mZb.mhY, mVar.gSX.mZb.mhZ);
                        if (dVar != null) {
                            this.gZq.gXj.gUq.getIController().animateTo(dVar.gRK, dVar.gRL);
                        }
                    }
                    dVar = null;
                    if (dVar != null) {
                        this.gZq.gXj.gUq.getIController().animateTo(dVar.gRK, dVar.gRL);
                    }
                }
            }
        };
        this.gZe.gTe = this.gZo;
        if (this.gZd == null) {
            this.gZd = new m(this.aXH, this.gXj.gUq, true);
        }
        this.gZd.gWz = this.gWz;
        this.gZd.gWn = false;
        this.gZf = new com.tencent.mm.plugin.location.ui.l(this.aXH, this);
        this.gZc = (TipSayingWidget) findViewById(2131757416);
        this.gZa = (Button) findViewById(2131759585);
        this.gZa.setVisibility(0);
        this.gZg = new k(this.aXH, this.gZa);
        this.gZg.gVV = this.gZh;
        this.gZj.gUO.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ g gZq;

            {
                this.gZq = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.location.ui.l lVar = this.gZq.gZf;
                com.tencent.mm.ui.base.g.b(lVar.mContext, lVar.BE.getString(2131233542), "", lVar.BE.getString(2131231037), lVar.BE.getString(2131231010), new 6(lVar), new 7(lVar));
            }
        });
        this.gZj.gUP.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ g gZq;

            {
                this.gZq = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                this.gZq.gZf.awV();
            }
        });
        ((LocationManager) this.aXH.getSystemService("location")).isProviderEnabled("gps");
        o oVar = this.gZe;
        LocationInfo locationInfo = this.gXh;
        oVar.gTh = System.currentTimeMillis();
        oVar.cCR = c.FY();
        oVar.cCR.a(oVar.bYl);
        if (oVar.gSU == null) {
            oVar.gSU = l.awk();
        }
        oVar.gSU.a(oVar.gTj);
        if (locationInfo != null) {
            oVar.gSY = locationInfo;
        }
        if (oVar.bhY) {
            v.i("MicorMsg.TrackRefreshManager", "start location " + oVar.gSY.gRK + " " + oVar.gSY.gRL);
        } else {
            oVar.gSW = 1;
            oVar.gSX = new bda();
            oVar.gSX.mZb = new ana();
            oVar.gSX.mZb.mhZ = -1000.0d;
            oVar.gSX.mZb.mhY = -1000.0d;
            v.i("MicorMsg.TrackRefreshManager", "start location imp " + oVar.gSY.gRK + " " + oVar.gSY.gRL);
            ak.vy().a(492, oVar);
            ak.vy().a(490, oVar);
            ak.vy().a(491, oVar);
            oVar.aSZ = false;
            oVar.bhY = true;
        }
        o oVar2 = this.gZe;
        b bVar = this.gZn;
        Iterator it = oVar2.gSV.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                break;
            }
        }
        oVar2.gSV.add(new WeakReference(bVar));
        this.gZk = this.aXH.getIntent().getStringExtra("fromWhereShare");
        v.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[]{this.gZk});
        if (this.gZe.awn()) {
            v.i("MicroMsg.ShareMapUI", "has join");
            this.gZd.dZ(true);
            this.gZg.awL();
            return;
        }
        int i;
        String xF;
        com.tencent.mm.plugin.location.model.a.b bVar2;
        o oVar3 = this.gZe;
        String str = this.gTc;
        if (!be.kS(this.gZk)) {
            if (this.gZk.equals("fromBanner")) {
                i = 0;
            } else if (!this.gZk.equals("fromPluginLocation")) {
                if (this.gZk.equals("fromPluginTalk")) {
                    i = 2;
                } else if (this.gZk.equals("fromTrackButton")) {
                    i = 3;
                } else if (this.gZk.equals("fromMessage")) {
                    i = 4;
                }
            }
            v.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
            oVar3.gTc = str;
            xF = com.tencent.mm.model.k.xF();
            xF = str.contains("@chatroom") ? str : xF.compareTo(str) <= 0 ? str + xF : xF + str;
            bVar2 = new com.tencent.mm.plugin.location.model.a.b(xF);
            ((aet) bVar2.cif.czk.czs).maG = i;
            ak.vy().a(bVar2, 0);
        }
        i = 1;
        v.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
        oVar3.gTc = str;
        xF = com.tencent.mm.model.k.xF();
        if (str.contains("@chatroom")) {
        }
        bVar2 = new com.tencent.mm.plugin.location.model.a.b(xF);
        ((aet) bVar2.cif.czk.czs).maG = i;
        ak.vy().a(bVar2, 0);
    }

    public final void onResume() {
        boolean z;
        v.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        o oVar = this.gZe;
        v.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + oVar.gTa);
        if (oVar.gTa) {
            oVar.gTh = System.currentTimeMillis();
            oVar.cCR.a(oVar.bYl);
            oVar.gSU.a(oVar.gTj);
        }
        oVar.gTa = false;
        oVar.awo();
        oVar = this.gZe;
        com.tencent.mm.plugin.e.d dVar = this.gXj.gUq;
        oVar.gSW = oVar.gTb;
        v.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + oVar.gSW + " %f %f %d ", new Object[]{Double.valueOf(oVar.gRK), Double.valueOf(oVar.gRL), Integer.valueOf(oVar.zoom)});
        if (oVar.gRK == -1000.0d || oVar.gRL == -1000.0d || oVar.zoom == -1) {
            z = false;
        } else {
            dVar.getIController().setCenter(oVar.gRK, oVar.gRL);
            dVar.getIController().setZoom(oVar.zoom);
            z = true;
        }
        if (z) {
            this.gZb.gTZ = false;
            this.gZb.awC();
            this.gZd.gWs = false;
            this.gZd.gWm = true;
        }
        oVar = this.gZe;
        com.tencent.mm.plugin.e.d dVar2 = this.gXj.gUq;
        if (oVar.gTf != -1) {
            dVar2.getIController().setZoom(oVar.gTf);
        }
        if (this.gZi != null) {
            this.gZi.a(this.bYl);
        }
        if (this.gZd != null) {
            this.gZd.onResume();
        }
    }

    public final void onPause() {
        v.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        o oVar = this.gZe;
        v.d("MicorMsg.TrackRefreshManager", "pause isShared:" + oVar.gSZ);
        if (!oVar.gSZ) {
            oVar.cCR.c(oVar.bYl);
            oVar.gSU.b(oVar.gTj);
            oVar.gTa = true;
            oVar.gTg = true;
        }
        oVar = this.gZe;
        com.tencent.mm.plugin.e.d dVar = this.gXj.gUq;
        oVar.gTb = oVar.gSW;
        oVar.gSW = 0;
        v.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + oVar.gTb);
        if (oVar.awt()) {
            oVar.gRK = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            oVar.gRL = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            oVar.zoom = dVar.getZoom();
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.gZl)});
        this.gZl = System.currentTimeMillis();
        if (this.gZi != null) {
            this.gZi.c(this.bYl);
        }
        if (this.gZd != null) {
            this.gZd.onPause();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        o oVar = this.gZe;
        b bVar = this.gZn;
        Iterator it = oVar.gSV.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                oVar.gSV.remove(weakReference);
                break;
            }
        }
        this.gZe.gTe = null;
        if (this.gZg != null) {
            k kVar = this.gZg;
            kVar.gVU.b(kVar);
            VolumeMeter volumeMeter = kVar.gVH;
            volumeMeter.gWC = true;
            volumeMeter.gWB = false;
            if (volumeMeter.gWG != null) {
                volumeMeter.gWG.getLooper().quit();
                volumeMeter.gWG = null;
            }
        }
        if (this.gZd != null) {
            this.gZd.destroy();
        }
        if (this.gZb != null) {
            c.FY().c(this.gZb.bYl);
        }
        v.i("MicroMsg.ShareMapUI", "onDestory");
    }

    public final void dX(boolean z) {
    }

    protected final void axe() {
        super.axe();
    }

    public final void awW() {
        this.gZe.gTf = this.gXj.gUq.getZoom();
        this.aXH.finish();
    }

    private void axo() {
        axg();
        this.gZd.dZ(false);
        this.gZe.stop();
        this.gZe.mp(3);
        k.awO();
        this.gZe.gTf = this.gXj.gUq.getZoom();
        this.aXH.finish();
    }

    public final void awX() {
        this.gZd.dZ(false);
        this.gZe.stop();
        this.gZe.mp(0);
        k.awO();
        this.aXH.finish();
    }

    public final void mt(int i) {
        if (i == 0) {
            com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            axo();
        } else if (i == 1) {
            com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            axo();
        } else if (i == 2) {
            axo();
        }
    }

    public final void awY() {
        azu com_tencent_mm_protocal_c_azu = this.gZd.gWr;
        if (com_tencent_mm_protocal_c_azu != null) {
            LocationInfo locationInfo = this.gXh;
            locationInfo.gRM = com_tencent_mm_protocal_c_azu.mMa;
            locationInfo.gRL = com_tencent_mm_protocal_c_azu.mhY;
            locationInfo.gRK = com_tencent_mm_protocal_c_azu.mhZ;
            if (TextUtils.isEmpty(com_tencent_mm_protocal_c_azu.mMa)) {
                this.gZL.setText("");
            } else {
                this.gZL.setText(com_tencent_mm_protocal_c_azu.mMa);
            }
            this.gZL.b(this.gXh);
            n nVar = this.gZL;
            nVar.gUq.updateLocaitonPinLayout(nVar.gUp, nVar.gRK, nVar.gRL);
            this.gXj.gUq.getIController().animateTo(this.gXh.gRK, this.gXh.gRL);
        }
    }

    public final void onBackPressed() {
        com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        this.gZf.awV();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void axp() {
        super.axp();
        if (this.gZd != null) {
            this.gZd.gWs = false;
            this.gZd.dY(false);
            this.gZb.awC();
        }
    }

    public final void axq() {
        super.axq();
    }

    protected final void axr() {
        super.axr();
        com.tencent.mm.plugin.report.service.g.iuh.h(10997, new Object[]{"1", "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
