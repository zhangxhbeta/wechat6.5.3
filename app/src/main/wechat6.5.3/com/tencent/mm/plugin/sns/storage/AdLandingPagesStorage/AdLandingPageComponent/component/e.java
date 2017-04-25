package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends j {
    int jxr;
    private RecyclerView jxs;
    private b jxt;
    Map<Integer, a> jxu = new HashMap();
    LinearLayoutManager jxv;
    Set<Integer> jxw = new HashSet();

    private class a {
        int count;
        boolean isVisible;
        long jxx;
        final /* synthetic */ e jxy;
        long time;

        private a(e eVar) {
            this.jxy = eVar;
        }

        final void aTQ() {
            if (this.isVisible) {
                this.isVisible = false;
                if (this.jxx > 0) {
                    this.time += System.currentTimeMillis() - this.jxx;
                    this.jxx = 0;
                }
            }
        }
    }

    private class b extends android.support.v7.widget.RecyclerView.a<a> {
        final /* synthetic */ e jxy;

        class a extends s {
            final /* synthetic */ b jxA;
            private h jxz;

            public a(b bVar, View view, h hVar) {
                this.jxA = bVar;
                super(view);
                this.jxz = hVar;
            }
        }

        private b(e eVar) {
            this.jxy = eVar;
        }

        public final /* synthetic */ s a(ViewGroup viewGroup, int i) {
            h hVar = new h(viewGroup.getContext(), viewGroup);
            return new a(this, hVar.getView(), hVar);
        }

        public final /* synthetic */ void a(s sVar, int i) {
            a aVar = (a) sVar;
            n nVar = (n) ((h) this.jxy.jxU).jvw.get(i);
            if (nVar instanceof k) {
                aVar.jxz.a((k) nVar);
                if (!aVar.jxz.jxO) {
                    this.jxy.jxw.add(Integer.valueOf(i));
                }
                View view = aVar.jxz.dtW;
                int paddingRight = view.getPaddingRight();
                if (i != ((h) this.jxy.jxU).jvw.size() - 1) {
                    paddingRight += this.jxy.jxr;
                }
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + this.jxy.jxr, paddingRight, view.getPaddingBottom() + this.jxy.jxr);
            }
        }

        public final int getItemCount() {
            return ((h) this.jxy.jxU).jvw.size();
        }
    }

    private class c extends j {
        RecyclerView hrb;
        private LinearLayoutManager jxB;
        int jxC = Integer.MAX_VALUE;
        private int jxD = -1;
        private int jxE = -1;
        private long jxF = 0;
        Runnable jxG = new Runnable(this) {
            final /* synthetic */ c jxH;

            {
                this.jxH = r1;
            }

            public final void run() {
                if (this.jxH.jxC == 1) {
                    c cVar = this.jxH;
                    v.d("AdLandingCarouselComp", "onDraggin first visible " + cVar.jxy.jxv.fe() + ", last visible " + cVar.jxy.jxv.ff());
                    e.a(cVar.jxy);
                    this.jxH.hrb.postDelayed(this.jxH.jxG, 100);
                }
            }
        };
        final /* synthetic */ e jxy;

        public c(e eVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            this.jxy = eVar;
            this.hrb = recyclerView;
            this.jxB = linearLayoutManager;
        }

        private void aTR() {
            this.hrb.getHandler().removeCallbacks(this.jxG);
        }

        public final void e(RecyclerView recyclerView, int i) {
            super.e(recyclerView, i);
            if (i != this.jxC) {
                if (i != 1) {
                    aTR();
                }
                switch (i) {
                    case 0:
                        e.a(this.jxy);
                        if (this.jxC == 2) {
                            int fe = this.jxB.fe();
                            int ff = this.jxB.ff();
                            if (ff >= this.jxD) {
                                if (fe > this.jxE) {
                                    a(this.jxE, fe, System.currentTimeMillis() - this.jxF);
                                    break;
                                }
                            }
                            a(ff, this.jxD, System.currentTimeMillis() - this.jxF);
                            break;
                        }
                        break;
                    case 1:
                        aTR();
                        this.hrb.postDelayed(this.jxG, 100);
                        break;
                    case 2:
                        this.jxD = this.jxB.fe();
                        this.jxE = this.jxB.ff();
                        this.jxF = System.currentTimeMillis();
                        break;
                }
            }
            this.jxC = i;
            v.d("AdLandingCarouselComp", "state " + i);
        }

        public final void c(RecyclerView recyclerView, int i, int i2) {
            super.c(recyclerView, i, i2);
        }

        private void a(int i, int i2, long j) {
            int i3 = 1;
            v.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            e eVar = this.jxy;
            if (i > i2) {
                v.e("AdLandingCarouselComp", "wtf start > end");
                return;
            }
            eVar.ct(i, i2);
            if (i2 != i) {
                i3 = (i2 - i) + 1;
            }
            long j2 = j / ((long) i3);
            while (i <= i2) {
                a aVar = (a) eVar.jxu.get(Integer.valueOf(i));
                if (aVar != null && aVar.isVisible) {
                    aVar.isVisible = false;
                    aVar.jxx = 0;
                    aVar.time += j2;
                }
                i++;
            }
        }
    }

    static /* synthetic */ void a(e eVar) {
        eVar.aTN();
        int fe = eVar.jxv.fe();
        int ff = eVar.jxv.ff();
        for (Entry entry : eVar.jxu.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fe || ((Integer) entry.getKey()).intValue() > ff) {
                ((a) entry.getValue()).aTQ();
            }
        }
    }

    public e(Context context, h hVar, ViewGroup viewGroup) {
        super(context, hVar, viewGroup);
        this.jxr = com.tencent.mm.bd.a.fromDPToPix(context, 12);
    }

    protected final int aGY() {
        return 2130904421;
    }

    public final View aTM() {
        this.jxs = (RecyclerView) this.dtW.findViewById(2131759240);
        this.jxs.setBackgroundColor(((h) this.jxU).backgroundColor);
        Iterator it = ((h) this.jxU).jvw.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            n nVar = (n) it.next();
            if (nVar instanceof k) {
                k kVar = (k) nVar;
                i2 = ((int) ((nVar.jvI + nVar.jvJ) + kVar.height)) + (this.jxr << 1);
                if (i <= i2) {
                    i = i2;
                }
                i2 = i;
            } else {
                i2 = i;
            }
            i = i2;
        }
        LayoutParams layoutParams = this.jxs.getLayoutParams();
        layoutParams.height = i;
        this.jxs.setLayoutParams(layoutParams);
        this.jxt = new b();
        this.jxs.a(this.jxt);
        this.jxv = new LinearLayoutManager();
        this.jxv.setOrientation(0);
        this.jxs.a(this.jxv);
        this.jxs.a(new c(this, this.jxs, this.jxv));
        this.jxs.setNestedScrollingEnabled(false);
        this.jxs.Ys = true;
        return this.dtW;
    }

    private void aTN() {
        if (this.jxv != null) {
            ct(this.jxv.fe(), this.jxv.ff());
        }
    }

    final void ct(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.jxu.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a();
                this.jxu.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.isVisible) {
                aVar.isVisible = true;
                aVar.jxx = System.currentTimeMillis();
                aVar.count++;
            }
            i++;
        }
    }

    public final void aTO() {
        super.aTO();
        aTN();
    }

    public final void aTP() {
        super.aTP();
        if (this.jxv != null) {
            int fe = this.jxv.fe();
            int ff = this.jxv.ff();
            for (int i = fe; i <= ff; i++) {
                a aVar = (a) this.jxu.get(Integer.valueOf(i));
                if (aVar != null) {
                    aVar.aTQ();
                }
            }
        }
    }

    public final boolean o(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.x(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.jxu;
            Set set = this.jxw;
            this.jxw = new HashSet();
            this.jxu = new HashMap();
            for (Entry entry : map.entrySet()) {
                n nVar = (n) ((h) this.jxU).jvw.get(((Integer) entry.getKey()).intValue());
                if (!nVar.jvS && (nVar instanceof k)) {
                    k kVar = (k) nVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((n) ((h) this.jxU).jvw.get(((Integer) entry.getKey()).intValue())).jvG);
                    jSONObject2.put("exposureCount", ((a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String Kg = z.Kg(kVar.jvA);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", Kg);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            return true;
        } catch (Throwable e) {
            v.e("AdLandingCarouselComp", be.e(e));
            return false;
        }
    }
}
