package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends FrameLayout {
    public com.tencent.mm.plugin.appbrand.config.a dNB;
    public LinkedList<e> dNC = new LinkedList();
    private LinkedList<e> dND = new LinkedList();
    h dNE;
    boolean dNF = false;
    public g dNG;
    private boolean dNH = false;
    public a dNI;
    String dzg;
    private Activity pP;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ f dNJ;
        final /* synthetic */ String dNM;
        final /* synthetic */ String dNN;
        final /* synthetic */ int[] dNO;

        public AnonymousClass4(f fVar, String str, String str2, int[] iArr) {
            this.dNJ = fVar;
            this.dNM = str;
            this.dNN = str2;
            this.dNO = iArr;
        }

        public final void run() {
            f.a(this.dNJ, this.dNM, this.dNN, this.dNO);
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ f dNJ;
        final /* synthetic */ String val$url;

        public AnonymousClass7(f fVar, String str) {
            this.dNJ = fVar;
            this.val$url = str;
        }

        public final void run() {
            f.a(this.dNJ, this.val$url, n.REDIRECT_TO);
        }
    }

    public interface a {
        void Ro();
    }

    static /* synthetic */ void a(f fVar, int i) {
        fVar.dNG.dNY = System.currentTimeMillis();
        if (fVar.dNC.size() <= 1) {
            c.gV(b.dyY);
            fVar.close();
            fVar.dNG.a("", System.currentTimeMillis(), 7);
            return;
        }
        if (i <= 0) {
            i = 1;
        }
        if (i >= fVar.dNC.size()) {
            i = fVar.dNC.size() - 1;
        }
        e eVar = (e) fVar.dNC.getFirst();
        e eVar2 = (e) fVar.dNC.get(i);
        fVar.a(eVar, eVar2);
        fVar.a(eVar2, eVar, n.NAVIGATE_BACK);
        g gVar = fVar.dNG;
        String Ra = eVar2.Ra();
        if (gVar.dOb) {
            gVar.a(Ra, gVar.dNY, 5);
        } else {
            gVar.a(Ra, gVar.dNY, 1);
        }
        AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(gVar.dzg);
        if (ms != null) {
            ms.dPP = System.currentTimeMillis();
            ms.dPQ = 1;
        }
        com.tencent.mm.plugin.appbrand.report.a.b(gVar.dzg, System.currentTimeMillis() - gVar.dNY, 4);
    }

    static /* synthetic */ void a(f fVar, final e eVar, final boolean z) {
        if (eVar != null) {
            if (z) {
                fVar.dNC.remove(eVar);
            }
            eVar.QX();
            Runnable anonymousClass2 = new Runnable(fVar) {
                final /* synthetic */ f dNJ;

                public final void run() {
                    eVar.hide();
                    if (z) {
                        this.dNJ.a(eVar);
                    }
                }
            };
            ObjectAnimator.ofFloat(eVar, "translationX", new float[]{0.0f, -(((float) eVar.getWidth()) * 0.25f)}).setDuration(250);
            ObjectAnimator.ofFloat(eVar, "translationX", new float[]{0.0f}).setDuration(0);
            Animator animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{r1, r2});
            fVar.a(animatorSet, anonymousClass2);
        }
    }

    static /* synthetic */ void a(f fVar, String str, n nVar) {
        if (!be.kS(str)) {
            fVar.dNG.od(str);
            v.i("MicroMsg.AppBrandPageContainer", "navigateTo: " + str);
            if (nVar != n.SWITCH_TAB) {
                fVar.b(str, nVar);
            } else if (fVar.ob(str) != null) {
                fVar.oa(str);
            } else if (fVar.oc(str) != null) {
                fVar.oa(str);
            } else {
                fVar.b(str, n.SWITCH_TAB);
            }
        }
    }

    static /* synthetic */ void a(f fVar, String str, String str2, int[] iArr) {
        Iterator it = fVar.dNC.iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(str, str2, iArr);
        }
        it = fVar.dND.iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(str, str2, iArr);
        }
    }

    static /* synthetic */ void b(f fVar, final e eVar) {
        if (eVar != null) {
            fVar.dNC.remove(eVar);
            fVar.dNC.push(eVar);
            fVar.dND.remove(eVar);
            eVar.bringToFront();
            fVar.requestLayout();
            fVar.invalidate();
            eVar.setVisibility(0);
            eVar.QW();
            Runnable anonymousClass3 = new Runnable(fVar) {
                final /* synthetic */ f dNJ;

                public final void run() {
                    this.dNJ.postDelayed(new Runnable(this.dNJ) {
                        final /* synthetic */ f dNJ;

                        {
                            this.dNJ = r1;
                        }

                        public final void run() {
                            if (this.dNJ.dNE == null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                h hVar = new h(this.dNJ.getContext(), this.dNJ.dzg);
                                hVar.setVisibility(4);
                                this.dNJ.addView(hVar, 0);
                                this.dNJ.dNE = hVar;
                                v.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            }
                        }
                    }, 200);
                    eVar.Rg();
                }
            };
            Animator ofFloat = ObjectAnimator.ofFloat(eVar, "translationX", new float[]{(float) eVar.getWidth(), 0.0f});
            ofFloat.setDuration(250);
            fVar.a(ofFloat, anonymousClass3);
        }
    }

    static /* synthetic */ void c(f fVar) {
        if (!fVar.dNH) {
            fVar.dNH = true;
            fVar.dNI.Ro();
        }
    }

    public f(Context context, String str) {
        super(context);
        this.pP = (Activity) context;
        this.dzg = str;
        this.dNB = com.tencent.mm.plugin.appbrand.a.mu(this.dzg);
        this.dNG = new g(context, this.dzg);
        JsApiOperateMusicPlayer.dHs = false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        JsApiOperateMusicPlayer.dHs = true;
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public final void nY(final String str) {
        g gVar = this.dNG;
        if (!(be.kS(str) || be.kS(gVar.dzg))) {
            String str2 = com.tencent.mm.plugin.appbrand.a.mu(gVar.dzg).dCx;
            if (be.kS(str2) || !str.equals(str2)) {
                gVar.dNX = 2;
            } else {
                gVar.dNX = 1;
            }
        }
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ f dNJ;

            public final void run() {
                f.a(this.dNJ, str, n.NAVIGATE_TO);
            }
        });
    }

    public final void nZ(final String str) {
        this.dNG.dNX = 2;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ f dNJ;

            public final void run() {
                f.a(this.dNJ, str, n.SWITCH_TAB);
            }
        });
    }

    public final void Rl() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ f dNJ;

            {
                this.dNJ = r1;
            }

            public final void run() {
                this.dNJ.hi(1);
            }
        });
    }

    public final void hi(final int i) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ f dNJ;

            public final void run() {
                f.a(this.dNJ, i);
            }
        });
    }

    private void b(String str, final n nVar) {
        int i;
        View bVar;
        v.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s, Staging Count: %d", new Object[]{str, Integer.valueOf(this.dND.size())});
        if (nVar == n.SWITCH_TAB) {
            i = 1;
        } else {
            i = (this.dNC.size() + 1) - (nVar == n.REDIRECT_TO ? 1 : 0);
            if (this.dNB.dCu.mZ(str) && i == 1) {
                i = 1;
            } else {
                boolean z = false;
            }
        }
        if (i != 0) {
            bVar = new b(getContext(), this);
        } else {
            bVar = new k(getContext(), this);
        }
        this.dND.push(bVar);
        addView(bVar, 0);
        final boolean[] zArr = new boolean[]{false};
        final Runnable anonymousClass11 = new Runnable(this) {
            final /* synthetic */ f dNJ;

            public final void run() {
                boolean z = false;
                zArr[0] = true;
                e eVar = this.dNJ.dNC.size() > 0 ? (e) this.dNJ.dNC.getFirst() : null;
                if (nVar == n.SWITCH_TAB) {
                    this.dNJ.a(eVar, null);
                }
                f fVar = this.dNJ;
                if (nVar == n.REDIRECT_TO || nVar == n.SWITCH_TAB) {
                    z = true;
                }
                f.a(fVar, eVar, z);
                f.b(this.dNJ, bVar);
                this.dNJ.dNG.Rp();
            }
        };
        postDelayed(anonymousClass11, 500);
        final long currentTimeMillis = System.currentTimeMillis();
        bVar.QZ().a(new h.c(this) {
            final /* synthetic */ f dNJ;

            public final void onReady() {
                bVar.QZ().b((h.c) this);
                if (!zArr[0]) {
                    this.dNJ.removeCallbacks(anonymousClass11);
                    this.dNJ.post(anonymousClass11);
                }
                f.c(this.dNJ);
                int currentTimeMillis = (int) (System.currentTimeMillis() - currentTimeMillis);
                g.iuh.a(390, 0, 1, false);
                switch (currentTimeMillis / 250) {
                    case 0:
                        currentTimeMillis = 1;
                        break;
                    case 1:
                        currentTimeMillis = 2;
                        break;
                    case 2:
                        currentTimeMillis = 3;
                        break;
                    case 3:
                        currentTimeMillis = 4;
                        break;
                    case 4:
                    case 5:
                        currentTimeMillis = 5;
                        break;
                    case 6:
                    case 7:
                        currentTimeMillis = 6;
                        break;
                    default:
                        currentTimeMillis = 7;
                        break;
                }
                g.iuh.a(390, (long) currentTimeMillis, 1, false);
                v.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", new Object[]{Long.valueOf(r10)});
            }
        });
        bVar.loadUrl(str);
        bVar.a(nVar);
    }

    private void oa(String str) {
        e ob = ob(str);
        if (ob != null) {
            ob.loadUrl(str);
            ob.a(n.SWITCH_TAB);
            ob.Rg();
            this.dNG.Rp();
            return;
        }
        e oc = oc(str);
        if (oc != null) {
            oc.loadUrl(str);
            ob = (e) this.dNC.getFirst();
            a(ob, oc);
            a(oc, ob, n.SWITCH_TAB);
            this.dNG.Rp();
        }
    }

    public final void close() {
        if (this.dNF) {
            this.pP.finish();
        } else {
            this.pP.moveTaskToBack(true);
        }
    }

    private void a(e eVar, e eVar2) {
        Iterator it = this.dNC.iterator();
        Object obj = null;
        while (it.hasNext()) {
            e eVar3 = (e) it.next();
            if (eVar3 == eVar) {
                obj = 1;
            } else if (eVar3 == eVar2) {
                return;
            } else {
                if (obj != null) {
                    a(eVar3);
                    it.remove();
                }
            }
        }
    }

    private void a(final e eVar, final e eVar2, n nVar) {
        this.dNC.remove(eVar2);
        if (eVar2.dNj) {
            a(eVar2);
        } else {
            Runnable anonymousClass13 = new Runnable(this) {
                final /* synthetic */ f dNJ;

                public final void run() {
                    this.dNJ.a(eVar2);
                }
            };
            Animator ofFloat = ObjectAnimator.ofFloat(eVar2, "translationX", new float[]{0.0f, (float) eVar2.getWidth()});
            ofFloat.setDuration(250);
            a(ofFloat, anonymousClass13);
        }
        eVar.a(nVar);
        eVar.setVisibility(0);
        eVar.QW();
        if (eVar2.dNj) {
            eVar.Rg();
            return;
        }
        anonymousClass13 = new Runnable(this) {
            final /* synthetic */ f dNJ;

            public final void run() {
                eVar.Rg();
            }
        };
        ofFloat = ObjectAnimator.ofFloat(eVar, "translationX", new float[]{-(((float) eVar.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, anonymousClass13);
    }

    private e ob(String str) {
        if (this.dNC.size() == 0) {
            return null;
        }
        return ((this.dNC.getFirst() instanceof b) && ((e) this.dNC.getFirst()).nV(str)) ? (e) this.dNC.getFirst() : null;
    }

    private e oc(String str) {
        if (this.dNC.size() < 2) {
            return null;
        }
        int i = 1;
        while (i < this.dNC.size()) {
            if ((this.dNC.get(i) instanceof b) && ((e) this.dNC.get(i)).nV(str)) {
                return (e) this.dNC.get(i);
            }
            i++;
        }
        return null;
    }

    private void a(e eVar) {
        eVar.setVisibility(8);
        eVar.QY();
        removeView(eVar);
        eVar.OE();
    }

    public final e Rm() {
        if (!this.dND.isEmpty()) {
            return (e) this.dND.getFirst();
        }
        try {
            return (e) this.dNC.getFirst();
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandPageContainer", e.getMessage());
            return null;
        }
    }

    public final void OE() {
        Iterator it = this.dNC.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            eVar.QY();
            eVar.OE();
        }
        if (this.dNE != null) {
            this.dNE.OE();
        }
        this.dNC.clear();
    }

    public final void Rn() {
        if (this.dNC.size() != 0) {
            ((e) this.dNC.getFirst()).QW();
            AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(this.dzg);
            if (ms != null && ms.isInit) {
                this.dNG.od(((e) this.dNC.getFirst()).Ra());
            }
            this.dNG.dOa = System.currentTimeMillis() - this.dNG.dNZ;
            if (ms != null && ms.isInit) {
                ms.isInit = false;
                ms.dPP = System.currentTimeMillis();
                ms.dPQ = 1;
                ms.dOa = this.dNG.dOa;
            }
        }
    }

    private void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ f dNJ;

            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }
}
