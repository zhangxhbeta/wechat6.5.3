package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.AppBrandStickInChattingPluginLogic;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.AppBrandJSInterface;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"ViewConstructor"})
public final class h extends LinearLayout implements com.tencent.mm.plugin.appbrand.jsapi.c {
    public boolean ZO = true;
    public FrameLayout dMW;
    public l dNn;
    private Set<c> dOc = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<a> dOd = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<Object> dOe = Collections.newSetFromMap(new ConcurrentHashMap());
    public Set<Object> dOf = Collections.newSetFromMap(new ConcurrentHashMap());
    com.tencent.mm.plugin.appbrand.widget.a dOg;
    public com.tencent.mm.plugin.appbrand.widget.input.b dOh;
    private j dOi;
    private AppBrandJSInterface dWV;
    public String dzg;
    private Set<b> dzi = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c> lqh;

    class AnonymousClass10 implements Runnable {
        final /* synthetic */ h dOj;
        final /* synthetic */ boolean dOn = false;

        AnonymousClass10(h hVar, boolean z) {
            this.dOj = hVar;
        }

        public final void run() {
            this.dOj.dOi.setEnabled(this.dOn);
        }
    }

    class AnonymousClass12 implements Runnable {
        final /* synthetic */ h dOj;
        final /* synthetic */ String dOl;
        final /* synthetic */ String dOo;

        AnonymousClass12(h hVar, String str, String str2) {
            this.dOj = hVar;
            this.dOl = str;
            this.dOo = str2;
        }

        public final void run() {
            i j = this.dOj.dOi;
            String str = this.dOl;
            String str2 = this.dOo;
            if ("light".equals(str)) {
                j.dOH.setImageDrawable(j.a(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
                j.dOI.setImageDrawable(j.a(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
                j.dOJ.setImageDrawable(j.a(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
            } else {
                j.dOH.setImageDrawable(j.a(-16777216, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
                j.dOI.setImageDrawable(j.a(-16777216, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
                j.dOJ.setImageDrawable(j.a(-16777216, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
            }
            j.dOr.setBackgroundColor(d.bn(str2, -1));
            j.Rz();
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ h dOj;
        final /* synthetic */ String dOk;

        AnonymousClass2(h hVar, String str) {
            this.dOj = hVar;
            this.dOk = str;
        }

        public final void run() {
            com.tencent.mm.plugin.appbrand.widget.a aVar = this.dOj.dOg;
            long EX = d.EX(this.dOk);
            if (EX == -1) {
                aVar.setBackgroundColor(aVar.getContext().getResources().getColor(2131689495));
            } else {
                aVar.setBackgroundColor((int) EX);
            }
        }
    }

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ h dOj;
        final /* synthetic */ String dOl;

        AnonymousClass6(h hVar, String str) {
            this.dOj = hVar;
            this.dOl = str;
        }

        public final void run() {
            this.dOj.dOg.Ri(this.dOl);
        }
    }

    class AnonymousClass9 implements Runnable {
        final /* synthetic */ h dOj;
        final /* synthetic */ boolean dOn;

        AnonymousClass9(h hVar, boolean z) {
            this.dOj = hVar;
            this.dOn = z;
        }

        public final void run() {
            this.dOj.dOi.setEnabled(this.dOn);
            i j = this.dOj.dOi;
            boolean z = this.dOn;
            j.dOE = z;
            j.dOu = z;
            j.dOG.setVisibility(z ? 0 : 4);
        }
    }

    public interface a {
        void Qi();
    }

    public interface b {
        void onDestroy();
    }

    public interface c {
        void onReady();
    }

    public h(Context context, String str) {
        super(context);
        this.dzg = str;
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(this.dzg);
        this.lqh = new HashSet();
        this.lqh.add(com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c.ShareAppMsg);
        if (!com.tencent.mm.sdk.b.b.bsI() && mr.dDB.dBr == 1) {
            this.lqh.add(com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c.SendToDesktop);
        }
        setLayoutParams(new LayoutParams(-1, -1));
        setOrientation(1);
        com.tencent.mm.plugin.appbrand.widget.a aVar = new com.tencent.mm.plugin.appbrand.widget.a(getContext());
        aVar.dVf = new OnClickListener(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.appbrand.a.mp(this.dOj.dzg).Rl();
            }
        };
        aVar.dVg = new OnClickListener(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.appbrand.c.gV(com.tencent.mm.plugin.appbrand.c.b.dyX);
                com.tencent.mm.plugin.appbrand.a.mp(this.dOj.dzg).close();
                AppBrandStickInChattingPluginLogic.mD(this.dOj.dzg);
                com.tencent.mm.plugin.appbrand.report.a.a(this.dOj.getContext(), this.dOj.dzg, "", System.currentTimeMillis(), 3, 0);
            }
        };
        aVar.dUU.setOnClickListener(new com.tencent.mm.plugin.appbrand.widget.a.AnonymousClass2(aVar, new OnClickListener(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void onClick(View view) {
                l d = this.dOj.dNn;
                d.getView().scrollTo(d.getView().getScrollX(), 0);
            }
        }));
        this.dOg = aVar;
        addView(this.dOg);
        this.dWV = new AppBrandJSInterface(this);
        AppBrandJSInterface appBrandJSInterface = this.dWV;
        l lVar = new l(getContext(), this.dzg);
        lVar.addJavascriptInterface(appBrandJSInterface, "WeixinJSCore");
        if (lVar.dOS == null) {
            lVar.dOS = lVar.RA() + "page-frame.html";
        }
        lVar.loadUrl(lVar.dOS);
        this.dNn = lVar;
        j jVar = new j(getContext(), this.dNn);
        jVar.dOC = new com.tencent.mm.plugin.appbrand.page.j.a(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void Rs() {
                this.dOj.a("onPullDownRefresh", null, null);
            }
        };
        this.dOi = jVar;
        this.dMW = new FrameLayout(getContext());
        this.dMW.addView(this.dOi);
        this.dOh = new com.tencent.mm.plugin.appbrand.widget.input.b(getContext(), this.dNn);
        this.dOi.dOD = this.dOh;
        this.dMW.addView(this.dOh);
        addView(this.dMW, new LinearLayout.LayoutParams(-1, -1));
        this.dOg.a(new OnClickListener(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void onClick(View view) {
                boolean z;
                int i = 0;
                final Collection hashSet = new HashSet();
                hashSet.addAll(this.dOj.lqh);
                j.a(this.dOj.dzg, new com.tencent.mm.plugin.appbrand.j.a(this) {
                    final /* synthetic */ AnonymousClass14 dOp;

                    public final void a(com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c cVar, boolean z) {
                        if (z) {
                            hashSet.add(cVar);
                        } else {
                            hashSet.remove(cVar);
                        }
                    }

                    public final boolean a(com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c cVar) {
                        return hashSet.contains(cVar);
                    }
                });
                final Set hashSet2 = new HashSet();
                hashSet2.addAll(hashSet);
                if (this.dOj.getContext() == null || !(this.dOj.getContext() instanceof MMActivity)) {
                    z = false;
                } else {
                    z = ((MMActivity) this.dOj.getContext()).nDR.ale();
                }
                Runnable anonymousClass2 = new Runnable(this) {
                    final /* synthetic */ AnonymousClass14 dOp;

                    public final void run() {
                        AppBrandPageActionSheet appBrandPageActionSheet = new AppBrandPageActionSheet(this.dOp.dOj.getContext(), this.dOp.dOj.dzg, this.dOp.dOj, hashSet2);
                    }
                };
                if (z) {
                    i = 100;
                }
                ad.g(anonymousClass2, (long) i);
            }
        });
    }

    public final String getAppId() {
        return this.dzg;
    }

    public final void oe(String str) {
        boolean z;
        l lVar = this.dNn;
        lVar.dOM = com.tencent.mm.plugin.appbrand.k.j.ov(str);
        lVar.dON = str;
        if (com.tencent.mm.plugin.appbrand.appcache.b.ar(lVar.dzg, lVar.dOM) != null) {
            if (lVar.dzD) {
                lVar.oh(lVar.dOM);
                v.i("MicroMsg.AppBrandWebView", "Frame ready, inject page");
            } else {
                v.i("MicroMsg.AppBrandWebView", "Frame not ready, wait for it");
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.dOg.a(null);
            runOnUiThread(new AnonymousClass10(this, false));
            f mp = com.tencent.mm.plugin.appbrand.a.mp(this.dzg);
            if (mp.dNC.size() < 2) {
                mp.dNF = true;
            }
            this.dMW.addView(new a(getContext(), this.dzg));
            onReady();
        }
    }

    public final void aP(String str, String str2) {
        this.dNn.aP(str, str2);
    }

    public final void y(int i, String str) {
        l lVar = this.dNn;
        if (be.kS(str)) {
            str = "{}";
        }
        v.d("MicroMsg.AppBrandWebView", "callback, callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
        lVar.post(new com.tencent.mm.plugin.appbrand.page.l.AnonymousClass5(lVar, i, str));
    }

    public final void a(String str, String str2, int[] iArr) {
        com.tencent.mm.plugin.appbrand.a.a(this.dzg, str, str2, hashCode());
    }

    public final int OI() {
        return hashCode();
    }

    public final boolean isRunning() {
        return this.ZO;
    }

    public final void OE() {
        this.dNn.destroy();
        this.dWV.OE();
        this.dzi.clear();
        this.dOd.clear();
        this.dOe.clear();
        this.dOf.clear();
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public final void a(c cVar) {
        this.dOc.add(cVar);
    }

    public final void b(c cVar) {
        this.dOc.remove(cVar);
    }

    public final void onReady() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void run() {
                for (c onReady : this.dOj.dOc) {
                    onReady.onReady();
                }
            }
        });
    }

    final void Rq() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void run() {
                Iterator it = this.dOj.dOe.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    final void Qi() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void run() {
                for (a Qi : this.dOj.dOd) {
                    Qi.Qi();
                }
            }
        });
    }

    public final void a(a aVar) {
        this.dOd.add(aVar);
    }

    public final void b(a aVar) {
        this.dOd.remove(aVar);
    }

    final void onDestroy() {
        this.ZO = false;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void run() {
                for (b onDestroy : this.dOj.dzi) {
                    onDestroy.onDestroy();
                }
            }
        });
    }

    public final void a(b bVar) {
        this.dzi.add(bVar);
    }

    public final void b(b bVar) {
        this.dzi.remove(bVar);
    }

    public final void of(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            public final void run() {
                com.tencent.mm.plugin.appbrand.widget.a aVar = this.dOj.dOg;
                aVar.dUV.setText(str);
            }
        });
    }

    public final void og(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            public final void run() {
                com.tencent.mm.plugin.appbrand.widget.a aVar = this.dOj.dOg;
                CharSequence charSequence = str;
                if (be.kS(charSequence)) {
                    aVar.dUW.setVisibility(8);
                } else {
                    aVar.dUW.setVisibility(0);
                    aVar.dUW.setText(charSequence);
                }
                aVar.dUW.clearAnimation();
            }
        });
    }

    public final void Rr() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            {
                this.dOj = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.appbrand.widget.a aVar = this.dOj.dOg;
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setStartOffset(0);
                alphaAnimation.setRepeatMode(2);
                alphaAnimation.setRepeatCount(-1);
                aVar.dUW.startAnimation(alphaAnimation);
            }
        });
    }

    public final void bx(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ h dOj;

            public final void run() {
                Object obj = null;
                com.tencent.mm.plugin.appbrand.widget.a aVar = this.dOj.dOg;
                boolean z = z;
                aVar.dVb.setVisibility(z ? 0 : 8);
                Iterator it;
                if (z) {
                    e eVar = aVar.dVc;
                    eVar.mb.clear();
                    eVar.mb.add(e.a(eVar.dVV));
                    eVar.mb.add(e.a(eVar.dVW));
                    e eVar2 = aVar.dVc;
                    Iterator it2 = eVar2.mb.iterator();
                    while (it2.hasNext()) {
                        if (((Animator) it2.next()).isStarted()) {
                            obj = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        it = eVar2.mb.iterator();
                        while (it.hasNext()) {
                            ((Animator) it.next()).start();
                        }
                        eVar2.invalidateSelf();
                        return;
                    }
                    return;
                }
                it = aVar.dVc.mb.iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).end();
                }
            }
        });
    }
}
