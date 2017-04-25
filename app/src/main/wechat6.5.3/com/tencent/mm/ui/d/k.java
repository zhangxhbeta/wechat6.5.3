package com.tencent.mm.ui.d;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.as.i.AnonymousClass5;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class k extends com.tencent.mm.pluginsdk.ui.b.b implements com.tencent.mm.as.o.a {
    Map<String, Long> nQY = new HashMap();
    public Map<Long, b> nQZ = new HashMap();
    ViewGroup pi;

    private static final class a implements Runnable {
        WeakReference<k> nRa;

        private a() {
        }

        public final void run() {
            List Lj = com.tencent.mm.as.k.KV().Lj();
            List Lk = com.tencent.mm.as.k.KV().Lk();
            k kVar = (k) this.nRa.get();
            if (kVar == null) {
                v.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
                return;
            }
            v.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", Integer.valueOf(kVar.pi.getChildCount()), Integer.valueOf(Lj.size()), Integer.valueOf(Lk.size()));
            if (kVar.pi.getChildCount() != 0 || !Lj.isEmpty() || !Lk.isEmpty()) {
                Runnable cVar = new c();
                cVar.nRa = new WeakReference(this.nRa.get());
                cVar.nRj = Lj;
                cVar.nRk = Lk;
                ad.o(cVar);
            }
        }
    }

    private static final class b {
        ProgressBar fpm;
        long nRb;
        boolean nRc;
        View nRd;
        public com.tencent.mm.plugin.sight.decode.a.a nRe;
        ImageView nRf;
        TextView nRg;
        ImageButton nRh;

        private b() {
            this.nRb = 0;
            this.nRc = false;
            this.nRd = null;
            this.nRe = null;
            this.nRf = null;
            this.nRg = null;
            this.fpm = null;
            this.nRh = null;
        }
    }

    private static final class c implements Runnable {
        WeakReference<k> nRa;
        List<n> nRj;
        List<n> nRk;

        private c() {
        }

        private static int a(String str, k kVar, List<n> list, int i, int i2, int i3) {
            for (n nVar : list) {
                kVar.nQY.put(nVar.getFileName(), Long.valueOf(nVar.dgv));
                if (kVar.nQZ.containsKey(Long.valueOf(nVar.dgv))) {
                    v.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", str, Long.valueOf(nVar.dgv), nVar.getFileName());
                } else {
                    View view;
                    b bVar;
                    View inflate;
                    if (i < i2) {
                        v.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(kVar.pi.getChildAt(i).hashCode()), Long.valueOf(nVar.dgv));
                        i = r2;
                        view = inflate;
                    } else {
                        inflate = LayoutInflater.from(kVar.pi.getContext()).inflate(2130903960, kVar.pi, false);
                        kVar.pi.addView(inflate);
                        v.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(nVar.dgv));
                        view = inflate;
                    }
                    b bVar2 = (b) view.getTag();
                    if (bVar2 == null) {
                        bVar = new b();
                    } else {
                        bVar = bVar2;
                    }
                    if (bVar.nRb != nVar.dgv) {
                        v.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", Long.valueOf(bVar.nRb), Long.valueOf(nVar.dgv), Integer.valueOf(i3));
                        bVar.nRb = nVar.dgv;
                        bVar.nRd = view;
                        bVar.nRe = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(2131758180);
                        bVar.nRf = (ImageView) view.findViewById(2131758181);
                        bVar.fpm = (ProgressBar) view.findViewById(2131758183);
                        bVar.nRh = (ImageButton) view.findViewById(2131757038);
                        bVar.nRg = (TextView) view.findViewById(2131758184);
                        bVar.nRe.pv(view.getResources().getDimensionPixelSize(2131493160));
                        bVar.nRd.setTag(bVar);
                        bVar.nRh.setTag(Long.valueOf(bVar.nRb));
                        bVar.nRd.setOnClickListener(new OnClickListener(bVar) {
                            final /* synthetic */ b nRi;

                            {
                                this.nRi = r1;
                            }

                            public final void onClick(View view) {
                                b bVar = (b) view.getTag();
                                v.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", Long.valueOf(bVar.nRb), Boolean.valueOf(bVar.nRc));
                                if (bVar.nRc) {
                                    p.at(bVar.nRb);
                                }
                            }
                        });
                        bVar.nRh.setOnClickListener(new OnClickListener(bVar) {
                            final /* synthetic */ b nRi;

                            {
                                this.nRi = r1;
                            }

                            public final void onClick(View view) {
                                v.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", Long.valueOf(((Long) view.getTag()).longValue()));
                                ak.vA().x(new AnonymousClass5(com.tencent.mm.as.k.KZ(), r0));
                            }
                        });
                    } else {
                        v.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", Long.valueOf(bVar.nRb), Integer.valueOf(i3));
                    }
                    com.tencent.mm.as.k.KV();
                    String lc = o.lc(nVar.getFileName());
                    com.tencent.mm.as.k.KV();
                    bVar.nRe.s(com.tencent.mm.ae.n.GH().a(o.ld(nVar.getFileName()), com.tencent.mm.bd.a.getDensity(view.getContext()), view.getContext()));
                    if (i3 > 3) {
                        bVar.nRe.clear();
                        bVar.nRf.setVisibility(0);
                    } else {
                        bVar.nRe.ag(lc, false);
                        bVar.nRf.setVisibility(8);
                    }
                    a(bVar, nVar);
                    kVar.nQZ.put(Long.valueOf(nVar.dgv), bVar);
                }
            }
            return i;
        }

        public static void a(b bVar, n nVar) {
            boolean z = true;
            v.v("MicroMsg.MassSightBanner", "info status %d", Integer.valueOf(nVar.status));
            if (nVar.status == 198 || nVar.status == 197 || nVar.status == 196) {
                bVar.fpm.setVisibility(4);
                bVar.nRg.setVisibility(0);
                bVar.nRh.setEnabled(true);
                bVar.nRc = true;
                return;
            }
            float f = ((float) nVar.dgC) / ((float) nVar.cyu);
            bVar.fpm.setVisibility(0);
            bVar.nRg.setVisibility(4);
            bVar.fpm.setProgress((int) (((float) bVar.fpm.getMax()) * f));
            ImageButton imageButton = bVar.nRh;
            if (Float.compare(0.99f, f) <= 0) {
                z = false;
            }
            imageButton.setEnabled(z);
            bVar.nRc = false;
        }

        public final void run() {
            k kVar = (k) this.nRa.get();
            if (kVar == null) {
                v.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
                return;
            }
            int childCount = kVar.pi.getChildCount();
            kVar.nQZ.clear();
            Set hashSet = new HashSet();
            for (n nVar : this.nRj) {
                hashSet.add(Long.valueOf(nVar.dgv));
            }
            for (n nVar2 : this.nRk) {
                hashSet.add(Long.valueOf(nVar2.dgv));
            }
            int size = hashSet.size();
            int a = a("update fail", kVar, this.nRk, a("update unfinish", kVar, this.nRj, 0, childCount, size), childCount, size);
            for (int i = a; i < childCount; i++) {
                kVar.pi.removeViewAt(a);
            }
        }
    }

    public k(Context context) {
        super(context);
        com.tencent.mm.as.k.KV().a(this, Looper.getMainLooper());
        this.pi = (ViewGroup) this.view;
    }

    public final int getLayoutId() {
        return 2130903959;
    }

    public final void destroy() {
        com.tencent.mm.as.k.KV().a((com.tencent.mm.as.o.a) this);
    }

    public final void blU() {
        v.i("MicroMsg.MassSightBanner", "call update status");
        Runnable aVar = new a();
        aVar.nRa = new WeakReference(this);
        ak.vA().x(aVar);
    }

    public final void a(com.tencent.mm.as.o.a.a aVar) {
        String str = aVar.aST;
        Long l = (Long) this.nQY.get(str);
        if (l == null) {
            v.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", str);
            if (be.ah(str, SQLiteDatabase.KeyEmpty).startsWith("DELETE_")) {
                blU();
                return;
            }
            return;
        }
        b bVar = (b) this.nQZ.get(l);
        if (bVar == null) {
            v.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", l);
            return;
        }
        n lp = p.lp(str);
        if (lp == null) {
            v.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", str, l);
        } else if (lp.status == 199) {
            v.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", str, l);
            blU();
        } else {
            c.a(bVar, lp);
        }
    }
}
