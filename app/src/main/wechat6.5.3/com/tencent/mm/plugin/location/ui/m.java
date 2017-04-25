package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.model.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m {
    private static Object gWi = new Object();
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ m gWA;

        {
            this.gWA = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            m mVar = this.gWA;
            double d3 = (double) f2;
            double d4 = (double) f;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[refreshMyLocation] ");
            stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d3), Double.valueOf(d4)}));
            if (mVar.gSX == null) {
                mVar.gSX = new bda();
                mVar.gSX.mZb = new ana();
                mVar.gSX.mdw = k.xF();
                mVar.gSX.mZb.mhZ = d3;
                mVar.gSX.mZb.mhY = d4;
                if (mVar.gTZ && mVar.gWl) {
                    mVar.awZ();
                }
            }
            mVar.gSX.mZb.mhZ = d3;
            mVar.gSX.mZb.mhY = d4;
            View viewByItag = mVar.gTY.getViewByItag(mVar.gSX.mdw);
            if (viewByItag != null) {
                stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
            } else {
                viewByItag = new TrackPoint(mVar.mContext);
                if (mVar.gWq) {
                    ((TrackPoint) viewByItag).c(null);
                    ((TrackPoint) viewByItag).b(null);
                    ((TrackPoint) viewByItag).axt();
                } else {
                    ((TrackPoint) viewByItag).c(mVar.gWy);
                    ((TrackPoint) viewByItag).b(mVar.gWx);
                }
                if (!mVar.gWn) {
                    ((TrackPoint) viewByItag).axv();
                }
                stringBuffer.append("[view is null new one: " + viewByItag.hashCode() + " ] ");
                mVar.gTY.addView(viewByItag, d3, d4, mVar.gSX.mdw);
                mVar.gWk = new TrackPointAnimAvatar(mVar.mContext);
            }
            v.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
            if (viewByItag instanceof TrackPoint) {
                mVar.gWj = (TrackPoint) viewByItag;
                v.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
                mVar.gTY.updateViewLayout(viewByItag, d3, d4);
                mVar.gWj.vW(mVar.gSX.mdw);
                mVar.gWj.gZA.setImageResource(2130838505);
                TrackPoint trackPoint = mVar.gWj;
                if (trackPoint.dKn == -1.0d && trackPoint.dKo == -1.0d) {
                    trackPoint.dKn = d3;
                    trackPoint.dKl = d3;
                    trackPoint.dKo = d4;
                    trackPoint.dKm = d4;
                } else {
                    trackPoint.dKn = trackPoint.dKl;
                    trackPoint.dKo = trackPoint.dKm;
                    trackPoint.dKm = d4;
                    trackPoint.dKl = d3;
                }
                if (mVar.gWn) {
                    mVar.gWj.gZB.setVisibility(0);
                } else {
                    mVar.gWj.axv();
                }
            }
            if (mVar.gWs) {
                mVar.gTY.getIController().setCenter(mVar.gSX.mZb.mhZ, mVar.gSX.mZb.mhY);
            }
            return true;
        }
    };
    private boolean ecK = false;
    protected float euH = 0.0f;
    public bda gSX;
    d gTY;
    boolean gTZ = false;
    private com.tencent.mm.plugin.location.model.i.a gTj = new com.tencent.mm.plugin.location.model.i.a(this) {
        final /* synthetic */ m gWA;

        {
            this.gWA = r1;
        }

        public final void f(double d) {
            if (this.gWA.gWj != null) {
                v.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[]{Double.valueOf(d)});
                this.gWA.gWj.g(d);
            }
        }
    };
    public List<bda> gWh;
    public TrackPoint gWj;
    TrackPointAnimAvatar gWk;
    boolean gWl = false;
    public boolean gWm = false;
    public boolean gWn = true;
    public boolean gWo = false;
    public boolean gWp = false;
    public boolean gWq = false;
    public azu gWr;
    public boolean gWs = true;
    public boolean gWt = true;
    private boolean gWu = false;
    private long gWv = 0;
    private OnTouchListener gWw = new OnTouchListener(this) {
        final /* synthetic */ m gWA;

        {
            this.gWA = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.gWA.gpD = motionEvent.getX();
                    this.gWA.euH = motionEvent.getY();
                    this.gWA.gWv = System.currentTimeMillis();
                    this.gWA.ecK = false;
                    break;
                case 1:
                    if (!this.gWA.ecK && System.currentTimeMillis() - this.gWA.gWv < 200) {
                        m.c(this.gWA);
                        break;
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - this.gWA.gpD) > 10.0f || Math.abs(motionEvent.getY() - this.gWA.euH) > 10.0f) {
                        this.gWA.ecK = true;
                        break;
                    }
            }
            return false;
        }
    };
    OnClickListener gWx = new OnClickListener(this) {
        final /* synthetic */ m gWA;

        {
            this.gWA = r1;
        }

        public final void onClick(View view) {
            String str = (String) view.getTag();
            v.d("MicroMsg.TrackPointViewMgrImpl", "onLocationTpClick, username=%s", new Object[]{str});
            if (!be.kS(str)) {
                View viewByItag = this.gWA.gTY.getViewByItag(str);
                if (viewByItag != null && (viewByItag instanceof TrackPoint)) {
                    TrackPoint trackPoint = (TrackPoint) viewByItag;
                    if (trackPoint.visible) {
                        trackPoint.axt();
                    } else {
                        trackPoint.axu();
                    }
                }
            }
        }
    };
    OnClickListener gWy = new OnClickListener(this) {
        final /* synthetic */ m gWA;

        {
            this.gWA = r1;
        }

        public final void onClick(View view) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            m.a(this.gWA, iArr[0], iArr[1]);
        }
    };
    public a gWz = null;
    protected float gpD = 0.0f;
    Context mContext;

    public interface a {
    }

    static /* synthetic */ boolean a(m mVar, int i, int i2) {
        if (mVar.gWh != null) {
            ArrayList arrayList = new ArrayList();
            float a = (float) b.a(mVar.mContext, 85.0f);
            for (bda com_tencent_mm_protocal_c_bda : mVar.gWh) {
                Point pointByGeoPoint = mVar.gTY.getPointByGeoPoint(com_tencent_mm_protocal_c_bda.mZb.mhZ, com_tencent_mm_protocal_c_bda.mZb.mhY);
                v.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhY), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y)});
                if (f.h(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) a)) {
                    arrayList.add(com_tencent_mm_protocal_c_bda.mdw);
                }
            }
            if (mVar.gSX != null) {
                Point pointByGeoPoint2 = mVar.gTY.getPointByGeoPoint(mVar.gSX.mZb.mhZ, mVar.gSX.mZb.mhY);
                v.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(mVar.gSX.mZb.mhZ), Double.valueOf(mVar.gSX.mZb.mhY), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y)});
                if (f.h(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) a)) {
                    arrayList.add(mVar.gSX.mdw);
                }
            }
            v.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", new Object[]{Integer.valueOf(arrayList.size())});
            if (arrayList.size() > 1) {
                g.iuh.h(10997, new Object[]{"12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                b.b(mVar.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void c(m mVar) {
        boolean z = true;
        if (mVar.gWp) {
            mVar.dY(false);
        }
        Collection<View> childs = mVar.gTY.getChilds();
        for (View view : childs) {
            if (view instanceof TrackPoint) {
                if (((TrackPoint) view).gZC.getVisibility() == 0) {
                    break;
                }
            }
        }
        z = false;
        for (View view2 : childs) {
            if (view2 instanceof TrackPoint) {
                if (z) {
                    ((TrackPoint) view2).axt();
                } else {
                    ((TrackPoint) view2).axu();
                }
            }
        }
    }

    public m(Context context, d dVar, boolean z) {
        this.mContext = context;
        this.gTZ = z;
        this.gTY = dVar;
        this.gWh = new ArrayList();
        dVar.setMapViewOnTouchListener(this.gWw);
    }

    public final void dY(boolean z) {
        if (z) {
            if ((this.gWj != null ? 1 : 0) != 0) {
                g.iuh.h(10997, new Object[]{"20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else {
                return;
            }
        }
        this.gWp = z;
    }

    public final void destroy() {
        synchronized (gWi) {
            if (this.gWh != null) {
                this.gWh.clear();
            }
        }
    }

    public final void dZ(boolean z) {
        if (!(!z || this.gWo || this.gTY == null)) {
            for (View view : this.gTY.getChilds()) {
                if (view instanceof TrackPoint) {
                    ((TrackPoint) view).axu();
                }
            }
        }
        this.gWo = z;
    }

    public final void aH(List<bda> list) {
        this.gWl = true;
        int size = this.gWh.size() + 1;
        synchronized (gWi) {
            this.gWh.clear();
            for (int i = 0; i < list.size(); i++) {
                this.gWh.add(list.get(i));
            }
        }
        int size2 = this.gWh.size() + 1;
        synchronized (gWi) {
            View view;
            Set<String> tags = this.gTY.getTags();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < this.gWh.size(); i2++) {
                hashSet.add(((bda) this.gWh.get(i2)).mdw);
            }
            List<String> linkedList = new LinkedList();
            for (String str : tags) {
                if (!(hashSet.contains(str) || str.endsWith("myAnim"))) {
                    if (this.gWj == null || !this.gWj.equals(this.gTY.getViewByItag(str))) {
                        linkedList.add(str);
                    }
                }
            }
            for (String str2 : linkedList) {
                this.gTY.removeViewByTag(str2);
            }
            for (int i3 = 0; i3 < this.gWh.size(); i3++) {
                bda com_tencent_mm_protocal_c_bda = (bda) this.gWh.get(i3);
                View viewByItag = this.gTY.getViewByItag(com_tencent_mm_protocal_c_bda.mdw);
                v.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[]{Integer.valueOf(i3), com_tencent_mm_protocal_c_bda.mdw, Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhY), Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mNp)});
                if (viewByItag != null) {
                    this.gTY.updateViewLayout(viewByItag, com_tencent_mm_protocal_c_bda.mZb.mhZ, com_tencent_mm_protocal_c_bda.mZb.mhY);
                    view = viewByItag;
                } else {
                    viewByItag = new TrackPoint(this.mContext);
                    viewByItag.setVisibility(0);
                    if (!this.gWn) {
                        ((TrackPoint) viewByItag).axv();
                    }
                    this.gTY.addView(viewByItag, com_tencent_mm_protocal_c_bda.mZb.mhZ, com_tencent_mm_protocal_c_bda.mZb.mhY, com_tencent_mm_protocal_c_bda.mdw);
                    ((TrackPoint) viewByItag).c(this.gWy);
                    ((TrackPoint) viewByItag).b(this.gWx);
                    view = viewByItag;
                }
                if (view instanceof TrackPoint) {
                    TrackPoint trackPoint = (TrackPoint) view;
                    trackPoint.vW(com_tencent_mm_protocal_c_bda.mdw);
                    trackPoint.g(com_tencent_mm_protocal_c_bda.mZb.mNp);
                    if (!this.gWo) {
                        trackPoint.axt();
                    }
                }
            }
            if (this.gTZ && this.gWl) {
                if (com.tencent.mm.model.m.dE(l.awi().gTc)) {
                    awZ();
                } else if (this.gWh.size() > 0) {
                    awZ();
                }
            }
            if (size < 10 && size2 >= 10) {
                for (View view2 : this.gTY.getChilds()) {
                    if (view2 instanceof TrackPoint) {
                        ((TrackPoint) view2).axt();
                    }
                }
            } else if (size >= 10 && size2 < 10) {
                for (View view22 : this.gTY.getChilds()) {
                    if (view22 instanceof TrackPoint) {
                        ((TrackPoint) view22).axu();
                    }
                }
            }
        }
    }

    final void awZ() {
        if (!this.gWm && this.gSX != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            if (this.gSX != null) {
                LocationInfo locationInfo = l.awi().gSY;
                if (this.gSX != null && e.f(locationInfo.gRK, locationInfo.gRL)) {
                    d = 2.0d * Math.abs(this.gSX.mZb.mhZ - locationInfo.gRK);
                    d2 = Math.abs(this.gSX.mZb.mhY - locationInfo.gRL) * 2.0d;
                }
                double d3 = d2;
                double d4 = d;
                for (int i = 0; i < this.gWh.size(); i++) {
                    bda com_tencent_mm_protocal_c_bda = (bda) this.gWh.get(i);
                    if (com_tencent_mm_protocal_c_bda != null && e.f(com_tencent_mm_protocal_c_bda.mZb.mhZ, com_tencent_mm_protocal_c_bda.mZb.mhY)) {
                        double abs = 2.0d * Math.abs(com_tencent_mm_protocal_c_bda.mZb.mhZ - this.gSX.mZb.mhZ);
                        d = Math.abs(com_tencent_mm_protocal_c_bda.mZb.mhY - this.gSX.mZb.mhY) * 2.0d;
                        if (abs > d4) {
                            d4 = abs;
                        }
                        if (d > d3) {
                            d3 = d;
                        }
                        v.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[]{com_tencent_mm_protocal_c_bda.mdw, Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhZ), Double.valueOf(com_tencent_mm_protocal_c_bda.mZb.mhY)});
                    }
                }
                if (Math.abs(d4 - -1000.0d) >= 0.5d && Math.abs(d3 - -1000.0d) >= 0.5d) {
                    v.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.gRK + " " + locationInfo.gRL);
                    if (this.gSX != null) {
                        v.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[]{Double.valueOf(this.gSX.mZb.mhZ), Double.valueOf(this.gSX.mZb.mhY)});
                        this.gTY.zoomToSpan(this.gSX.mZb.mhZ, this.gSX.mZb.mhY, d4, d3);
                    } else if (e.f(locationInfo.gRK, locationInfo.gRL)) {
                        this.gTY.zoomToSpan(locationInfo.gRK, locationInfo.gRL, d4, d3);
                    }
                }
            }
            this.gWm = true;
        }
    }

    public final void a(d dVar) {
        if (this.gSX != null) {
            double d = this.gSX.mZb.mhY;
            dVar.getIController().animateTo(this.gSX.mZb.mhZ, d);
            if (dVar.getZoomLevel() < 16) {
                dVar.getIController().setZoom(16);
            }
        }
    }

    public final void onResume() {
        c.FY().a(this.bYl);
        l.awk().a(this.gTj);
    }

    public final void onPause() {
        c.FY().c(this.bYl);
        l.awk().b(this.gTj);
    }
}
