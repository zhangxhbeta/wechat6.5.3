package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.z;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class d extends a {
    private View dQB;
    private MRecyclerView dQC;
    private LinearLayoutManager dQD;
    private h dQE;
    private boolean dQF = true;
    private final ArrayList<Object> dQG = new ArrayList();
    private String dQH = null;
    private String dQI = null;
    private String dQJ = "";
    private boolean dQK = false;
    private volatile a dQL;
    private String dQM;
    private Dialog dQN = null;

    private final class c extends s implements OnClickListener, OnLongClickListener, com.tencent.mm.ui.base.n.c, com.tencent.mm.ui.base.n.d {
        final /* synthetic */ d dQO;
        TextView dQW;
        TextView dQX;
        TextView dQY;
        ImageView dQZ;
        l dRa;
        final int dRb = 1;
        final int dRc = 2;
        View duA;
        TextView fVs;

        c(d dVar, View view) {
            this.dQO = dVar;
            super(view);
            this.duA = view.findViewById(2131755264);
            this.dQW = (TextView) view.findViewById(2131755366);
            this.dQX = (TextView) view.findViewById(2131755367);
            this.dQY = (TextView) view.findViewById(2131755368);
            this.fVs = (TextView) view.findViewById(2131760120);
            this.dQZ = (ImageView) view.findViewById(2131755225);
            view.setOnClickListener(this);
            this.dRa = new l(this.aal.getContext());
            this.dRa.jXn = this;
            this.dRa.jXo = this;
            this.aal.setOnLongClickListener(this);
        }

        private com.tencent.mm.plugin.appbrand.b.b Sc() {
            try {
                return (com.tencent.mm.plugin.appbrand.b.b) this.dQO.dQG.get(gh());
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrandLauncherRecentsList", e, "getAppInfo", new Object[0]);
                return null;
            }
        }

        public final void a(com.tencent.mm.ui.base.l lVar) {
            if (Sc() != null) {
                com.tencent.mm.plugin.appbrand.b.c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
                com.tencent.mm.plugin.appbrand.b.c.Pq();
                lVar.d(2, this.aal.getContext().getString(2131230952));
            }
        }

        public final void c(MenuItem menuItem, int i) {
            final com.tencent.mm.plugin.appbrand.b.b Sc = Sc();
            if (Sc != null && menuItem != null) {
                if (1 == menuItem.getItemId()) {
                    com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable(this) {
                        final /* synthetic */ c dRe;

                        public final void run() {
                            if (Sc.dBF) {
                                com.tencent.mm.plugin.appbrand.a.a.dzS.o(Sc.aWH, Sc.dzx, 1);
                            } else {
                                com.tencent.mm.plugin.appbrand.a.a.dzS.a(Sc.aWH, Sc.dzx, 1, true, false, BaseReportManager.MAX_READ_COUNT);
                            }
                        }
                    });
                } else if (2 == menuItem.getItemId()) {
                    String str = Sc.appId;
                    int i2 = Sc.dzx;
                    if (!be.kS(str)) {
                        AppBrandTaskManager.ab(str, i2);
                        com.tencent.mm.plugin.appbrand.k.a.vA().x(new com.tencent.mm.plugin.appbrand.b.e.AnonymousClass1(str, i2));
                    }
                    com.tencent.mm.plugin.appbrand.b.c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
                    String str2 = Sc.aWH;
                    int i3 = Sc.dzx;
                    if (cVar.o(str2, i3, 2)) {
                        cVar.a("single", 5, String.valueOf(com.tencent.mm.plugin.appbrand.b.c.p(str2, i3, 2)));
                    }
                    com.tencent.mm.plugin.appbrand.report.a.g(Sc.appId, Sc.dzx + 1, this.dQO.dQM);
                }
            }
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.appbrand.b.b Sc = Sc();
            if (Sc != null) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1001;
                AppBrandLaunchingLogic.a((MMActivity) this.dQO.aG(), Sc.aWH, Sc.appName, Sc.appId, Sc.dzx, Sc.dBD, null, appBrandStatObject, true);
            }
        }

        public final boolean onLongClick(View view) {
            if (this.dRa != null) {
                this.dRa.aXZ();
            }
            return true;
        }
    }

    private static final class e extends android.support.v7.widget.v {
        private e() {
        }

        public final boolean a(s sVar, int i, int i2, int i3, int i4) {
            v.d("MicroMsg.AppBrandLauncherRecentsList", "animateMove, fromX %d, fromY %d, toX %d, toY %d, itemHeight %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(sVar.aal.getHeight())});
            if (((float) Math.abs(i4 - i2)) <= ((float) sVar.aal.getHeight()) * 1.2f) {
                return super.a(sVar, i, i2, i3, i4);
            }
            k(sVar);
            return false;
        }
    }

    private final class f extends android.support.v7.widget.RecyclerView.g {
        final /* synthetic */ d dQO;

        private f(d dVar) {
            this.dQO = dVar;
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView) {
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
            rect.top = 0;
            s aP = recyclerView.aP(view);
            if ((aP instanceof c) && (recyclerView instanceof MRecyclerView)) {
                int i;
                View view2 = ((c) aP).duA;
                if (((MRecyclerView) recyclerView).D(aP) == this.dQO.dQG.size() - 1) {
                    i = 4;
                } else {
                    i = 0;
                }
                view2.setVisibility(i);
            }
        }
    }

    private static final class g extends z {
        private final LinearLayoutManager dRf;
        private final int dRg = 3000;
        private final int dRh;

        g(Context context, LinearLayoutManager linearLayoutManager) {
            super(context);
            this.dRf = linearLayoutManager;
            this.dRh = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
        }

        protected final int aV(int i) {
            return super.aV(Math.max(this.dRh, Math.min(this.dRg, i)));
        }

        public final PointF aS(int i) {
            return this.dRf.aS(i);
        }
    }

    private static final class h extends android.support.v7.widget.RecyclerView.a {
        private LayoutInflater CE;
        ArrayList<Object> dQG;
        final SparseArray<i> dRi;

        private h() {
            this.dRi = new SparseArray();
        }

        public final s a(ViewGroup viewGroup, int i) {
            i iVar = (i) this.dRi.get(i);
            if (iVar == null) {
                return null;
            }
            Context context = viewGroup.getContext();
            if (this.CE == null) {
                this.CE = LayoutInflater.from(context);
            }
            return iVar.a(this.CE, viewGroup);
        }

        public final void a(s sVar, int i) {
            i iVar = (i) this.dRi.get(getItemViewType(i));
            if (iVar != null) {
                Object obj = (i < 0 || i > getItemCount()) ? null : this.dQG.get(i);
                iVar.a(sVar, obj);
            }
        }

        public final void a(s sVar, int i, List list) {
            i iVar = (i) this.dRi.get(getItemViewType(i));
            this.dQG.get(i);
            if (iVar == null || list.size() <= 0 || !iVar.a(sVar, this.dQG.get(i), list.get(0))) {
                super.a(sVar, i, list);
            }
        }

        public final int getItemViewType(int i) {
            return this.dQG == null ? 0 : this.dQG.get(i).getClass().hashCode();
        }

        public final int getItemCount() {
            return this.dQG == null ? 0 : this.dQG.size();
        }
    }

    private static abstract class i<_Data, _ViewHolder extends s> {
        abstract _ViewHolder a(LayoutInflater layoutInflater, ViewGroup viewGroup);

        abstract void a(_ViewHolder _ViewHolder, _Data _Data);

        private i() {
        }

        protected boolean a(_ViewHolder _ViewHolder, Object obj, Object obj2) {
            return false;
        }
    }

    private final class b extends i<com.tencent.mm.plugin.appbrand.b.b, c> {
        final /* synthetic */ d dQO;

        private b(d dVar) {
            this.dQO = dVar;
            super();
        }

        final /* synthetic */ s a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return new c(this.dQO, layoutInflater.inflate(2130903103, viewGroup, false));
        }

        final /* synthetic */ void a(s sVar, Object obj) {
            boolean z;
            c cVar = (c) sVar;
            com.tencent.mm.plugin.appbrand.b.b bVar = (com.tencent.mm.plugin.appbrand.b.b) obj;
            cVar.dQX.setVisibility(8);
            a(cVar, bVar.appName);
            a(cVar, bVar.dzx, bVar.dBG);
            b(cVar, bVar.dBD);
            CharSequence gX = com.tencent.mm.plugin.appbrand.appcache.c.gX(bVar.dzx);
            if (be.kS(gX)) {
                cVar.dQY.setVisibility(8);
            } else {
                cVar.dQY.setText(gX);
                cVar.dQY.setVisibility(0);
            }
            this.dQO.dQC;
            if (MRecyclerView.aZ(cVar.aal) == this.dQO.dQE.getItemCount() - 1) {
                cVar.duA.setVisibility(8);
            } else {
                cVar.duA.setVisibility(0);
            }
            if (com.tencent.mm.sdk.b.b.bsI()) {
                ak.yW();
                if (com.tencent.mm.model.c.vf().b(com.tencent.mm.storage.t.a.fVM, false)) {
                    z = true;
                    if (z) {
                        cVar.fVs.setVisibility(8);
                        return;
                    }
                    TextView textView = cVar.fVs;
                    this.dQO.dQC;
                    textView.setText(String.valueOf(MRecyclerView.aZ(cVar.aal)));
                    cVar.fVs.setVisibility(0);
                }
            }
            z = false;
            if (z) {
                cVar.fVs.setVisibility(8);
                return;
            }
            TextView textView2 = cVar.fVs;
            this.dQO.dQC;
            textView2.setText(String.valueOf(MRecyclerView.aZ(cVar.aal)));
            cVar.fVs.setVisibility(0);
        }

        protected final /* synthetic */ boolean a(s sVar, Object obj, Object obj2) {
            c cVar = (c) sVar;
            if (obj2 == null || !(obj2 instanceof Bundle) || ((Bundle) obj2).size() <= 0) {
                return false;
            }
            if (((Bundle) obj2).get("nick_name") != null) {
                a(cVar, ((Bundle) obj2).getString("nick_name"));
            }
            if (((Bundle) obj2).get("favor") != null) {
                ((Bundle) obj2).getBoolean("favor");
            }
            if (((Bundle) obj2).get("running_flag") != null) {
                a(cVar, ((com.tencent.mm.plugin.appbrand.b.b) obj).dzx, ((Bundle) obj2).getLong("running_flag"));
            }
            if (((Bundle) obj2).get("icon") != null) {
                b(cVar, ((Bundle) obj2).getString("icon"));
            }
            return true;
        }

        private static void a(c cVar, String str) {
            cVar.dQW.setText(str);
        }

        private static void a(c cVar, int i, long j) {
            int i2;
            int i3 = 1;
            if ((2 & j) > 0) {
                i2 = 2131230985;
            } else if ((1 & j) > 0) {
                i2 = 2131230986;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i3 == 0 || i != 0) {
                cVar.dQZ.setColorFilter(null);
                return;
            }
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            cVar.dQZ.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            cVar.dQX.setVisibility(0);
            cVar.dQX.setText(i2);
        }

        private static void b(c cVar, String str) {
            com.tencent.mm.t.a.b.AL().a(cVar.dQZ, str, com.tencent.mm.t.a.a.AK(), com.tencent.mm.t.a.c.cxH);
        }
    }

    private final class a implements com.tencent.mm.plugin.appbrand.b.c.a, com.tencent.mm.plugin.appbrand.b.c.b, com.tencent.mm.plugin.appbrand.config.j.b, com.tencent.mm.plugin.appbrand.f.a.a {
        final /* synthetic */ d dQO;

        private a(d dVar) {
            this.dQO = dVar;
        }

        final ArrayList<? extends Object> bz(boolean z) {
            QO();
            ArrayList WG = com.tencent.mm.plugin.appbrand.a.a.dzS.WG();
            final ArrayList n = d.l(WG);
            if (be.bP(WG)) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ a dQS;

                    {
                        this.dQS = r1;
                    }

                    public final void run() {
                        this.dQS.dQO.Sb();
                        ((AppBrandLauncherUI) this.dQS.dQO.aG()).bA(false);
                    }
                });
            } else {
                this.dQO.dQJ = d.o(WG);
                if (this.dQO.dQJ != null && this.dQO.dQJ.length() > 0 && this.dQO.dQK) {
                    this.dQO.Sa();
                    this.dQO.dQK = false;
                }
                if (z) {
                    final com.tencent.mm.plugin.appbrand.k.f.b a = com.tencent.mm.plugin.appbrand.k.f.a(new d(this.dQO.dQG, n));
                    Object obj = (a.dST == null || a.dST.size() <= 0) ? null : 1;
                    if (obj != null) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ a dQS;

                            public final void run() {
                                d.a(this.dQS.dQO, n, a);
                            }
                        });
                    }
                } else {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ a dQS;

                        public final void run() {
                            this.dQS.dQO.m(n);
                        }
                    });
                }
            }
            return WG;
        }

        public final void Pr() {
            bz(true);
        }

        public final void PD() {
            bz(true);
        }

        public final void QO() {
            final String QL = com.tencent.mm.plugin.appbrand.f.a.QL();
            final String QN = com.tencent.mm.plugin.appbrand.f.a.QN();
            ad.o(new Runnable(this) {
                final /* synthetic */ a dQS;

                public final void run() {
                    d.a(this.dQS.dQO, QL, QN);
                }
            });
        }
    }

    private static final class d extends b<Object> {
        d(ArrayList<Object> arrayList, ArrayList<Object> arrayList2) {
            super(arrayList, arrayList2);
        }

        public final boolean ba(int i, int i2) {
            if (!this.dRq.get(i).getClass().equals(this.dRr.get(i2).getClass())) {
                return false;
            }
            if (!(this.dRq.get(i) instanceof com.tencent.mm.plugin.appbrand.b.b)) {
                return false;
            }
            com.tencent.mm.plugin.appbrand.b.b bVar = (com.tencent.mm.plugin.appbrand.b.b) this.dRq.get(i);
            com.tencent.mm.plugin.appbrand.b.b bVar2 = (com.tencent.mm.plugin.appbrand.b.b) this.dRr.get(i2);
            return bVar.appId.equals(bVar2.appId) && bVar.dzx == bVar2.dzx && bVar.aWH.equals(bVar2.aWH);
        }

        public final boolean bb(int i, int i2) {
            if (!(this.dRq.get(i) instanceof com.tencent.mm.plugin.appbrand.b.b)) {
                return false;
            }
            com.tencent.mm.plugin.appbrand.b.b bVar = (com.tencent.mm.plugin.appbrand.b.b) this.dRq.get(i);
            com.tencent.mm.plugin.appbrand.b.b bVar2 = (com.tencent.mm.plugin.appbrand.b.b) this.dRr.get(i2);
            return bVar.appId.equals(bVar2.appId) && bVar.aWH.equals(bVar2.aWH) && bVar.dzx == bVar2.dzx && bVar.dBF == bVar2.dBF && bVar.dBG == bVar2.dBG && be.ma(bVar.dBD).equals(bVar2.dBD) && be.ma(bVar.appName).equals(bVar2.appName);
        }

        public final Object bc(int i, int i2) {
            if (i >= this.dRq.size()) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (this.dRq.get(i) instanceof com.tencent.mm.plugin.appbrand.b.b) {
                com.tencent.mm.plugin.appbrand.b.b bVar = (com.tencent.mm.plugin.appbrand.b.b) this.dRq.get(i);
                com.tencent.mm.plugin.appbrand.b.b bVar2 = (com.tencent.mm.plugin.appbrand.b.b) this.dRr.get(i2);
                if (bVar.dBF != bVar2.dBF) {
                    bundle.putBoolean("favor", bVar2.dBF);
                }
                if (bVar.dBG != bVar2.dBG) {
                    bundle.putLong("running_flag", bVar2.dBG);
                }
                if (!be.ma(bVar.dBD).equals(bVar2.dBD)) {
                    bundle.putString("icon", bVar2.dBD);
                }
                if (!be.ma(bVar.appName).equals(bVar2.appName)) {
                    bundle.putString("nick_name", bVar2.appName);
                }
            }
            return bundle.size() <= 0 ? null : bundle;
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        dVar.dQH = str;
        dVar.dQI = str2;
        dVar.dQB.setVisibility(!be.kS(dVar.dQH) ? 0 : 8);
    }

    static /* synthetic */ void a(d dVar, ArrayList arrayList, com.tencent.mm.plugin.appbrand.k.f.b bVar) {
        dVar.Sb();
        dVar.dQG.clear();
        dVar.dQG.addAll(arrayList);
        if (dVar.dQE != null && dVar.dQC != null) {
            dVar.dQE.dQG = dVar.dQG;
            com.tencent.mm.plugin.appbrand.k.g anonymousClass1 = new com.tencent.mm.plugin.appbrand.k.f.b.AnonymousClass1(bVar, dVar.dQE);
            com.tencent.mm.plugin.appbrand.k.e eVar = anonymousClass1 instanceof com.tencent.mm.plugin.appbrand.k.e ? (com.tencent.mm.plugin.appbrand.k.e) anonymousClass1 : new com.tencent.mm.plugin.appbrand.k.e(anonymousClass1);
            List arrayList2 = new ArrayList();
            int i = bVar.dSX;
            int size = bVar.dST.size() - 1;
            int i2 = bVar.dSY;
            while (size >= 0) {
                e eVar2 = (e) bVar.dST.get(size);
                int i3 = eVar2.size;
                int i4 = eVar2.x + i3;
                int i5 = eVar2.y + i3;
                if (i4 < i) {
                    bVar.b(arrayList2, eVar, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    bVar.a(arrayList2, eVar, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((bVar.dSU[eVar2.x + i6] & 31) == 2) {
                        eVar.d(eVar2.x + i6, 1, bVar.dSW.bc(eVar2.x + i6, eVar2.y + i6));
                    }
                }
                i = eVar2.x;
                size--;
                i2 = eVar2.y;
            }
            eVar.So();
        }
    }

    static /* synthetic */ void k(d dVar) {
        dVar.RY();
        dVar.dQL = new a();
        com.tencent.mm.plugin.appbrand.b.c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
        a aVar = dVar.dQL;
        if (aVar != null) {
            cVar.dBJ.ay(aVar);
        }
        cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
        aVar = dVar.dQL;
        if (aVar != null) {
            cVar.dBL.ay(aVar);
        }
        com.tencent.mm.plugin.appbrand.a.a.OO().a(dVar.dQL);
        com.tencent.mm.plugin.appbrand.f.a.a(dVar.dQL);
    }

    static /* synthetic */ String o(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof com.tencent.mm.plugin.appbrand.b.b) {
                i++;
                stringBuilder.append(((com.tencent.mm.plugin.appbrand.b.b) obj).appId);
                if (i == 20 || i >= arrayList.size()) {
                    break;
                }
                stringBuilder.append(":#:");
            }
        }
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    private void RY() {
        if (this.dQL != null) {
            com.tencent.mm.plugin.appbrand.b.c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
            a aVar = this.dQL;
            if (aVar != null) {
                cVar.dBJ.remove(aVar);
            }
            cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
            aVar = this.dQL;
            if (aVar != null) {
                cVar.dBL.remove(aVar);
            }
            com.tencent.mm.plugin.appbrand.a.a.OO().b(this.dQL);
            com.tencent.mm.plugin.appbrand.f.a.b(this.dQL);
            this.dQL = null;
        }
    }

    private static ArrayList<Object> l(ArrayList<? extends Object> arrayList) {
        if (be.bP(arrayList)) {
            return null;
        }
        ArrayList<Object> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if ((next instanceof com.tencent.mm.plugin.appbrand.b.b) && !be.kS(((com.tencent.mm.plugin.appbrand.b.b) next).appName)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public final void onResume() {
        super.onResume();
        aG().setTitle(2131230936);
        final boolean z = this.dQF;
        if (z) {
            com.tencent.mm.plugin.appbrand.f.a.refresh();
            if (com.tencent.mm.plugin.appbrand.i.d.bRN()) {
                long currentTimeMillis = System.currentTimeMillis();
                ak.yW();
                Object obj = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.pRI, null);
                long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
                String language = Locale.getDefault().getLanguage();
                ak.yW();
                Object obj2 = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.pRF, null);
                if (currentTimeMillis - longValue >= 3600000 || obj2 == null || !obj2.equals(language)) {
                    ak.vy().a(new com.tencent.mm.plugin.appbrand.netscene.h(), 0);
                }
                v.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[]{obj2, language, Long.valueOf(longValue), Long.valueOf(currentTimeMillis)});
            } else {
                v.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
            }
        }
        final boolean z2 = !be.bP(com.tencent.mm.plugin.appbrand.a.a.dzS.dBN);
        if (z && z2) {
            m(l(com.tencent.mm.plugin.appbrand.a.a.dzS.dBN));
        }
        if (z && !z2) {
            Sb();
            this.dQN = f.bs(aG());
            this.dQN.show();
        }
        com.tencent.mm.sdk.i.e.a(new Runnable(this) {
            final /* synthetic */ d dQO;

            public final void run() {
                boolean z = false;
                a aVar = new a();
                if (!(z || z2)) {
                    z = true;
                }
                Object bz = aVar.bz(z);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 dQR;

                    {
                        this.dQR = r1;
                    }

                    public final void run() {
                        d.k(this.dQR.dQO);
                    }
                });
                if (z && !be.bP(bz)) {
                    List linkedList = new LinkedList();
                    Collection hashSet = new HashSet();
                    Iterator it = bz.iterator();
                    while (it.hasNext()) {
                        bz = it.next();
                        if (bz instanceof com.tencent.mm.plugin.appbrand.b.b) {
                            com.tencent.mm.plugin.appbrand.b.b bVar = (com.tencent.mm.plugin.appbrand.b.b) bz;
                            linkedList.add(com.tencent.mm.vending.j.a.t(bVar.appId, Integer.valueOf(bVar.dzx)));
                            hashSet.add(bVar.aWH);
                        }
                    }
                    com.tencent.mm.plugin.appbrand.h.g.a(linkedList, null);
                    List arrayList = new ArrayList();
                    arrayList.addAll(hashSet);
                    k.S(arrayList);
                }
            }
        }, "AppBrandLauncherRecentsList-QueryDiffOnResume");
        this.dQF = false;
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis());
        ak.yW();
        this.dQM = append.append(com.tencent.mm.model.c.ww()).toString();
        if (!this.dQK) {
            Sa();
        }
    }

    public final void onPause() {
        super.onPause();
        RY();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        RY();
    }

    final void RZ() {
        if (this.dQC != null) {
            MRecyclerView mRecyclerView = this.dQC;
            if (!mRecyclerView.Yw && mRecyclerView.Ym != null) {
                mRecyclerView.Ym.a(mRecyclerView, 0);
            }
        }
    }

    final void NI() {
        this.dQK = true;
        this.dQC = new MRecyclerView(getContext());
        ((FrameLayout) this.Hq).addView(this.dQC, new LayoutParams(-1, -1));
        this.dQD = new LinearLayoutManager(this) {
            final /* synthetic */ d dQO;

            {
                this.dQO = r3;
            }

            public final void a(RecyclerView recyclerView, int i) {
                g gVar = new g(this.dQO.aG(), this.dQO.dQD);
                gVar.ZM = 0;
                a(gVar);
            }
        };
        this.dQC.a(this.dQD);
        this.dQC.a(new f());
        MRecyclerView mRecyclerView = this.dQC;
        e eVar = new e();
        if (mRecyclerView.YI != null) {
            mRecyclerView.YI.eP();
            mRecyclerView.YI.Zk = null;
        }
        mRecyclerView.YI = eVar;
        if (mRecyclerView.YI != null) {
            mRecyclerView.YI.Zk = mRecyclerView.YX;
        }
        this.dQC.dZT = new com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a(this) {
            final /* synthetic */ d dQO;

            {
                this.dQO = r1;
            }

            public final void bz(View view) {
                s aP = this.dQO.dQC.aP(view);
                if (aP != null && (aP instanceof OnClickListener)) {
                    ((OnClickListener) aP).onClick(view);
                }
            }
        };
        this.dQC.dZU = new com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b(this) {
            final /* synthetic */ d dQO;

            {
                this.dQO = r1;
            }

            public final boolean bA(View view) {
                s aP = this.dQO.dQC.aP(view);
                if (aP == null || !(aP instanceof OnLongClickListener)) {
                    return false;
                }
                return ((OnLongClickListener) aP).onLongClick(view);
            }
        };
        h hVar = new h();
        hVar.dRi.put(com.tencent.mm.plugin.appbrand.b.b.class.hashCode(), new b());
        this.dQE = hVar;
        this.dQC.a(this.dQE);
        this.dQB = LayoutInflater.from(aG()).inflate(2130903111, this.dQC, false);
        this.dQB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d dQO;

            {
                this.dQO = r1;
            }

            public final void onClick(View view) {
                if (!be.kS(this.dQO.dQH)) {
                    Intent intent = new Intent();
                    intent.putExtra("geta8key_scene", 41);
                    intent.putExtra("rawUrl", this.dQO.dQH);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent, 2);
                    com.tencent.mm.plugin.appbrand.report.a.A(3, this.dQO.dQI);
                }
            }
        });
        this.dQC.addFooterView(this.dQB);
        this.dQB.setVisibility(8);
    }

    private void Sa() {
        com.tencent.mm.plugin.appbrand.report.a.j(this.cVh, "", this.dQJ);
    }

    private void m(ArrayList<Object> arrayList) {
        Sb();
        this.dQG.clear();
        this.dQG.addAll(arrayList);
        if (this.dQE != null) {
            this.dQE.dQG = this.dQG;
            this.dQE.Zi.notifyChanged();
        }
    }

    private void Sb() {
        if (this.dQN != null) {
            this.dQN.dismiss();
        }
        this.dQN = null;
    }
}
