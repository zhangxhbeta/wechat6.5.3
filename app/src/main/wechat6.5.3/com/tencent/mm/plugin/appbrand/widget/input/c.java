package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.TransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class c {
    private static final Map<String, Integer> dWT;
    public WeakReference<com.tencent.mm.plugin.appbrand.page.h> dGH;
    public volatile e dWB;
    public volatile f dWC;
    public volatile d dWD;
    private int dWE = -1;
    private int dWF = -1;
    private float dWG = 0.0f;
    private boolean dWH = false;
    public b dWJ;
    public String dWK;
    public j dWL;
    public i dWM;
    public g dWN;
    private final Runnable dWO = new c(this) {
        final /* synthetic */ c dWU;

        {
            this.dWU = r2;
        }

        public final View SW() {
            return this.dWU.dWM;
        }

        protected final int SX() {
            return 5;
        }

        public final void run() {
            super.run();
        }
    };
    private final Runnable dWP = new Runnable(this) {
        final /* synthetic */ c dWU;

        {
            this.dWU = r1;
        }

        public final void run() {
            c.g(this.dWU);
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.i.c dWQ = new com.tencent.mm.plugin.appbrand.widget.input.i.c(this) {
        final /* synthetic */ c dWU;

        {
            this.dWU = r1;
        }

        public final boolean oI(String str) {
            if (this.dWU.dWL != null) {
                j b;
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    b = this.dWU.dWL;
                    if (b.dYG != null) {
                        b.dYG.sendKeyEvent(new KeyEvent(0, 67));
                        b.dYG.sendKeyEvent(new KeyEvent(1, 67));
                    } else {
                        b.dispatchKeyEvent(new KeyEvent(0, 67));
                        b.dispatchKeyEvent(new KeyEvent(1, 67));
                    }
                } else {
                    b = this.dWU.dWL;
                    int max = Math.max(0, b.getSelectionStart());
                    b.setText(b.getText().subSequence(0, max) + str + b.getText().subSequence(Math.min(b.getText().length(), b.getSelectionEnd()), b.getText().length()));
                    try {
                        b.setSelection(Math.max(0, Math.min(max + str.length(), b.getText().length())));
                    } catch (Throwable e) {
                        v.a("MicroMsg.AppBrand.WebEditText", e, "insertText android emoji setSelection", new Object[0]);
                    }
                }
            }
            return true;
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.i.b dWR = new com.tencent.mm.plugin.appbrand.widget.input.i.b(this) {
        final /* synthetic */ c dWU;

        {
            this.dWU = r1;
        }

        public final void kL(boolean z) {
            if (z) {
                this.dWU.dWH = true;
            }
            c.k(this.dWU);
            if (z) {
                this.dWU.dWH = false;
            }
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.i.d dWS = new com.tencent.mm.plugin.appbrand.widget.input.i.d(this) {
        final /* synthetic */ c dWU;

        {
            this.dWU = r1;
        }

        public final void hD(int i) {
            v.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[]{Integer.valueOf(i)});
            if (i != 2) {
                if (i == 0 && this.dWU.dWL != null) {
                    this.dWU.dWL.requestFocus();
                }
                this.dWU.ST();
                if (this.dWU.dGH != null && this.dWU.dGH.get() != null) {
                    e.a((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get(), this.dWU.dWL);
                    return;
                }
                return;
            }
            c.k(this.dWU);
        }
    };
    final i fVt = new i(this);
    boolean fVu = false;
    final Runnable fVv = new Runnable(this) {
        final /* synthetic */ c dWU;

        {
            this.dWU = r1;
        }

        public final void run() {
            this.dWU.fVu = false;
        }
    };
    final ac fnw = new ac(Looper.getMainLooper());

    class AnonymousClass7 implements OnEditorActionListener {
        final /* synthetic */ c dWU;
        final /* synthetic */ int fVw;

        public AnonymousClass7(c cVar, int i) {
            this.dWU = cVar;
            this.fVw = i;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != this.fVw) {
                return false;
            }
            this.dWU.dWH = true;
            c.k(this.dWU);
            this.dWU.dWH = false;
            return true;
        }
    }

    private interface a {
        View SW();
    }

    public interface d {
        void bw(boolean z);
    }

    public interface e {
        void nH(String str);
    }

    public interface f {
        void c(int i, int i2, float f);
    }

    public static abstract class g {
        public Integer dXA = null;
        public String dXe;
        public Integer dXf;
        public Integer dXg;
        public Integer dXh;
        public Integer dXi;
        public String dXj = null;
        public Integer dXk = null;
        public Integer dXl = null;
        public Integer dXm = null;
        public String dXn;
        public String dXo;
        public Integer dXp;
        public String dXq;
        public String dXr;
        public Integer dXs;
        public Integer dXt;
        public Boolean dXu = Boolean.valueOf(false);
        public Boolean dXv = Boolean.valueOf(false);
        public Boolean dXw = Boolean.valueOf(false);
        public Boolean dXx = Boolean.valueOf(false);
        public Boolean dXy = Boolean.valueOf(false);
        public Boolean dXz = null;
        public com.tencent.mm.plugin.appbrand.widget.input.e.a lqI = null;
        public Boolean lqJ = null;
    }

    final class i implements Runnable {
        final /* synthetic */ c dWU;
        String value = null;

        i(c cVar) {
            this.dWU = cVar;
        }

        public final void run() {
            if (this.dWU.dWB != null && this.value != null) {
                this.dWU.dWB.nH(this.value);
            }
        }
    }

    public static final class b extends g {
        public volatile String dWY;
        public volatile boolean dWZ;
        public volatile boolean dXa = true;
        public volatile boolean dXb = true;
        public WeakReference<com.tencent.mm.plugin.appbrand.page.h> dXc;
    }

    private abstract class c implements a, Runnable {
        final /* synthetic */ c dWU;
        private final int dXd;

        private c(c cVar) {
            this.dWU = cVar;
            this.dXd = (VERSION.SDK_INT >= 21 ? com.tencent.mm.plugin.appbrand.ui.f.Sj() : 0) + com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10);
        }

        public void run() {
            if (SW() != null && this.dWU.dWL != null && !com.tencent.mm.plugin.appbrand.ui.f.dg(this.dWU.dWL)) {
                int[] iArr = new int[2];
                this.dWU.dWL.getLocationOnScreen(iArr);
                int i = iArr[1];
                Display defaultDisplay = ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                if (i <= point.y) {
                    int height = (this.dWU.dWL.getHeight() + i) + SX();
                    SW().getLocationOnScreen(iArr);
                    int i2 = iArr[1];
                    if (i2 <= height) {
                        i2 = Math.max(0, Math.min(height - i2, i - this.dXd));
                        if (this.dWU.dGH != null && this.dWU.dGH.get() != null && ((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).dNn != null && ((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).dNn.getView() != null) {
                            View view = ((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).dNn.getView();
                            if ((view.getHeight() - this.dWU.dWL.getTop()) - this.dWU.dWL.getHeight() >= i2) {
                                l lVar = ((com.tencent.mm.plugin.appbrand.page.h) this.dWU.dGH.get()).dNn;
                                if ((lVar.getHeight() < lVar.getView().getHeight() ? 1 : 0) != 0) {
                                    view.scrollBy(view.getScrollX(), i2);
                                    return;
                                }
                            }
                            c.a(this.dWU, c.d(this.dWU) + i2);
                        }
                    }
                }
            }
        }

        protected int SX() {
            int i = 0;
            if (!(this.dWU.dWJ == null || this.dWU.dWJ.dXA == null)) {
                i = Math.max(0, this.dWU.dWJ.dXA.intValue());
            }
            return i > 0 ? i : com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 3);
        }
    }

    public static final class h extends g {
    }

    public abstract void Qt();

    public abstract void Qu();

    public abstract void e(String str, boolean z, boolean z2);

    static /* synthetic */ void a(c cVar, int i) {
        if (cVar.dGH != null && cVar.dGH.get() != null) {
            d bF = d.bF((View) cVar.dGH.get());
            if (bF != null && bF.getChildAt(0) != null) {
                bF.getChildAt(0).scrollTo(0, i);
            }
        }
    }

    static /* synthetic */ void b(c cVar, boolean z) {
        if (z) {
            cVar.SZ();
        }
        if (cVar.dWD != null) {
            cVar.dWD.bw(z);
        }
        if (cVar.dWL != null && z && cVar.dWJ.dXw.booleanValue()) {
            ad.g(cVar.dWP, 100);
        }
        if (!(cVar.dWL == null || z || cVar.dWJ.dXa)) {
            cVar.dWL.setFocusable(false);
            cVar.dWL.setFocusableInTouchMode(false);
        }
        if (cVar.dWM == null) {
            cVar.dWM = cVar.SQ();
        }
        if (cVar.dWM != null && cVar.dWL != null && cVar.dWM.dYz != null && cVar.dWM.dYz != cVar.dWL) {
            cVar.kK(false);
            cVar.bE(cVar.dWL);
            cVar.onDestroy();
        }
    }

    static /* synthetic */ int d(c cVar) {
        if (cVar.dGH == null || cVar.dGH.get() == null) {
            return 0;
        }
        d bF = d.bF((View) cVar.dGH.get());
        return (bF == null || bF.getChildAt(0) == null) ? 0 : bF.getChildAt(0).getScrollY();
    }

    static /* synthetic */ void g(c cVar) {
        if (cVar.dWJ.dXw.booleanValue() && cVar.dWM != null && cVar.dWM.isShown() && cVar.dWL != null && cVar.dWL == cVar.dWM.dYz) {
            cVar.dWL.post(cVar.dWO);
        }
    }

    static /* synthetic */ void i(c cVar) {
        if (cVar.dWL != null) {
            float lineSpacingExtra = VERSION.SDK_INT >= 16 ? cVar.dWL.getLineSpacingExtra() : cVar.dWG;
            if (cVar.dWL.getLineCount() != cVar.dWE || cVar.dWL.getLineHeight() != cVar.dWF || lineSpacingExtra != cVar.dWG) {
                Object obj = cVar.dWE == -1 ? 1 : null;
                cVar.dWE = cVar.dWL.getLineCount();
                cVar.dWF = cVar.dWL.getLineHeight();
                cVar.dWG = lineSpacingExtra;
                if (cVar.dWC != null) {
                    cVar.dWC.c(cVar.dWE, cVar.dWF, lineSpacingExtra);
                }
                if (cVar.dWJ.dXw.booleanValue() && obj == null) {
                    cVar.dWL.addTextChangedListener(new com.tencent.mm.ui.widget.h(cVar) {
                        final /* synthetic */ c dWU;
                        int dWW = 0;

                        {
                            this.dWU = r2;
                        }

                        public final void afterTextChanged(Editable editable) {
                            int i = this.dWW + 1;
                            this.dWW = i;
                            if (i <= 1) {
                                c.g(this.dWU);
                                this.dWU.dWL.removeTextChangedListener(this);
                            }
                        }
                    });
                    cVar.SL();
                }
            }
        }
    }

    static /* synthetic */ void k(c cVar) {
        boolean z = cVar.dWH && cVar.dWJ.lqJ != null && cVar.dWJ.lqJ.booleanValue();
        if (!z) {
            cVar.SR();
        }
        if (cVar.dGH != null && cVar.dGH.get() != null) {
            cVar.kK(z);
            if (!z) {
                cVar.SN();
                if (!(cVar.dWM == null || cVar.dWL == null)) {
                    i iVar = cVar.dWM;
                    if (cVar.dWL == iVar.dYz) {
                        iVar.dYz = null;
                    }
                }
            }
            if (cVar.dWJ.dXa) {
                if (!z) {
                    cVar.bE(cVar.dWL);
                    cVar.onDestroy();
                }
            } else if (cVar.dWL != null) {
                cVar.dWL.setFocusable(false);
                cVar.dWL.setFocusableInTouchMode(false);
            }
        }
    }

    static /* synthetic */ void q(c cVar) {
        if (!(cVar.dGH == null || cVar.dGH.get() == null)) {
            cVar.kK(false);
            cVar.SN();
            cVar.bE(cVar.dWL);
            cVar.onDestroy();
        }
        if (cVar.dWN != null) {
            cVar.dWN.setVisibility(8);
        }
    }

    final void onDestroy() {
        this.dWL = null;
        this.dGH = null;
        com.tencent.mm.plugin.appbrand.k.a.aD(this);
    }

    private void SL() {
        if (this.dWJ.dXy != null && this.dWJ.dXy.booleanValue() && this.dWJ.dXw != null && this.dWJ.dXw.booleanValue()) {
            int max = Math.max(this.dWL.getLineCount(), 1);
            j(this.dWL, this.dWJ.dXf.intValue(), (int) (((VERSION.SDK_INT >= 16 ? this.dWL.getLineSpacingExtra() : 0.0f) + ((float) this.dWL.getLineHeight())) * ((float) max)), this.dWJ.dXi.intValue(), this.dWJ.dXh.intValue());
        }
    }

    public final void bG(boolean z) {
        TransformationMethod transformationMethod = null;
        if (this.dWL == null || !(z || this.dWL.Tf())) {
            v.e("MicroMsg.AppBrandInputInvokeHandler", "updateInputImpl, input is null or detached, skip");
            return;
        }
        boolean z2;
        if (this.dWJ.dXy.booleanValue()) {
            SL();
        } else {
            j(this.dWL, this.dWJ.dXf.intValue(), this.dWJ.dXg.intValue(), this.dWJ.dXi.intValue(), this.dWJ.dXh.intValue());
        }
        if (this.dWJ.dXm != null) {
            this.dWL.setTextSize(0, (float) this.dWJ.dXm.intValue());
        }
        if (this.dWJ.dXl != null) {
            this.dWL.setTextColor(this.dWJ.dXl.intValue());
        }
        if (this.dWJ.dXk != null) {
            this.dWL.setBackgroundDrawable(new ColorDrawable(this.dWJ.dXk.intValue()));
        } else {
            this.dWL.setBackgroundDrawable(null);
        }
        if (!be.kS(this.dWJ.dXq)) {
            j jVar = this.dWL;
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.dWJ.dXq);
            int length = this.dWJ.dXq.length();
            spannableStringBuilder.setSpan(new StyleSpan(d.tr(this.dWJ.dXr)), 0, length, 18);
            if (this.dWJ.dXt != null) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.dWJ.dXt.intValue()), 0, length, 18);
            }
            if (this.dWJ.dXs != null) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.dWJ.dXs.intValue(), false), 0, length, 18);
            }
            jVar.setHint(spannableStringBuilder);
        }
        this.dWL.I(be.ma(this.dWJ.dXe));
        d.a(this.dWL, this.dWJ.dXn, this.dWJ.dXo);
        if (this.dWJ.dXp == null) {
            this.dWJ.dXp = Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX);
        } else if (this.dWJ.dXp.intValue() <= 0) {
            this.dWJ.dXp = Integer.valueOf(Integer.MAX_VALUE);
        }
        com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.dWL).yn(this.dWJ.dXp.intValue());
        yn.oWy = false;
        yn.oSS = com.tencent.mm.ui.tools.h.a.oST;
        yn.a(null);
        j jVar2 = this.dWL;
        if (this.dWJ.dXw.booleanValue()) {
            z2 = false;
        } else {
            z2 = true;
        }
        jVar2.setSingleLine(z2);
        boolean z3;
        int inputType;
        if ("number".equalsIgnoreCase(this.dWJ.dWY)) {
            jVar2 = this.dWL;
            z3 = this.dWJ.dWZ;
            jVar2.dYM = true;
            inputType = jVar2.getInputType() | 2;
            inputType = z3 ? inputType | 16 : inputType & -17;
            jVar2.lUT = z3;
            jVar2.setInputType(inputType);
            jVar2.setTransformationMethod(z3 ? jVar2.fVJ : null);
            jVar2.dYM = false;
        } else {
            jVar2 = this.dWL;
            z3 = this.dWJ.dWZ;
            jVar2.dYM = true;
            inputType = jVar2.getInputType() | 1;
            inputType = z3 ? inputType | 128 : inputType & -129;
            jVar2.lUT = z3;
            jVar2.setInputType(inputType);
            if (z3) {
                transformationMethod = jVar2.fVJ;
            }
            jVar2.setTransformationMethod(transformationMethod);
            jVar2.dYM = false;
        }
        if (this.dWJ.dXu == null || !this.dWJ.dXu.booleanValue()) {
            this.dWL.setEnabled(true);
            this.dWL.setClickable(true);
        } else {
            this.dWL.setEnabled(false);
            this.dWL.setFocusable(false);
            this.dWL.setFocusableInTouchMode(false);
            this.dWL.setClickable(false);
        }
        String ma = be.ma(this.dWJ.dXj);
        z2 = true;
        switch (ma.hashCode()) {
            case -1364013995:
                if (ma.equals("center")) {
                    z2 = false;
                    break;
                }
                break;
            case 108511772:
                if (ma.equals("right")) {
                    z2 = true;
                    break;
                }
                break;
        }
        switch (z2) {
            case false:
                this.dWL.hL(1);
                break;
            case true:
                this.dWL.hL(5);
                break;
            default:
                this.dWL.hL(3);
                break;
        }
        if (this.dWJ.dXv.booleanValue()) {
            this.dWL.setVisibility(8);
        } else {
            this.dWL.setVisibility(0);
        }
        if (this.dWJ.dXz != null) {
            this.dWL.dYN = this.dWJ.dXz.booleanValue();
        }
    }

    private void SZ() {
        if (this.dWJ.dXw.booleanValue()) {
            SQ();
        }
        if (this.dWM != null && this.dWL != null) {
            this.dWM.dYz = this.dWL;
            SO();
            if (com.tencent.mm.plugin.appbrand.ui.f.dg(this.dWL) && this.dWL.hasFocus()) {
                this.dWM.show();
            }
        }
    }

    private void SN() {
        if (this.dGH != null && this.dGH.get() != null) {
            d bF = d.bF((View) this.dGH.get());
            if (bF != null && bF.getChildAt(0) != null) {
                bF.getChildAt(0).scrollTo(0, 0);
            }
        }
    }

    private boolean j(View view, int i, int i2, int i3, int i4) {
        if (view == null || this.dGH == null || this.dGH.get() == null) {
            return false;
        }
        b bVar = ((com.tencent.mm.plugin.appbrand.page.h) this.dGH.get()).dOh;
        if (bVar == null) {
            return false;
        }
        boolean z;
        l lVar = ((com.tencent.mm.plugin.appbrand.page.h) this.dGH.get()).dNn;
        if (lVar == null || lVar.getView() == null || view == null) {
            z = false;
        } else {
            boolean z2;
            LayoutParams layoutParams;
            if (view != null) {
                if (bVar.bC(view)) {
                    z2 = true;
                } else if (bVar.dWA != null) {
                    for (int i5 = 0; i5 < bVar.dWA.getChildCount(); i5++) {
                        if (view == bVar.dWA.getChildAt(i5)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    z = false;
                } else {
                    bVar.j(lVar);
                    if (bVar.bC(view)) {
                        if (((com.tencent.mm.plugin.appbrand.widget.input.b.a) view).SK()) {
                            bVar.removeView(view);
                            bVar.a(lVar, view, i, i2, i3, i4);
                        } else if (view.getLayoutParams() != null) {
                            layoutParams = (LayoutParams) view.getLayoutParams();
                            layoutParams.leftMargin = i3 - lVar.getScrollX();
                            layoutParams.topMargin = i4 - lVar.getScrollY();
                            layoutParams.width = i;
                            layoutParams.height = i2;
                            view.setLayoutParams(layoutParams);
                        }
                        z = true;
                    } else if (view.getLayoutParams() == null && (view.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
                        if (!(view.getWidth() == i && view.getHeight() == i2 && view.getLeft() == i3 && view.getTop() == i4)) {
                            AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                            layoutParams2.x = i3;
                            layoutParams2.y = i4;
                            layoutParams2.width = i;
                            layoutParams2.height = i2;
                            view.setLayoutParams(layoutParams2);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            z2 = false;
            if (z2) {
                bVar.j(lVar);
                if (bVar.bC(view)) {
                    if (((com.tencent.mm.plugin.appbrand.widget.input.b.a) view).SK()) {
                        bVar.removeView(view);
                        bVar.a(lVar, view, i, i2, i3, i4);
                    } else if (view.getLayoutParams() != null) {
                        layoutParams = (LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = i3 - lVar.getScrollX();
                        layoutParams.topMargin = i4 - lVar.getScrollY();
                        layoutParams.width = i;
                        layoutParams.height = i2;
                        view.setLayoutParams(layoutParams);
                    }
                    z = true;
                } else {
                    if (view.getLayoutParams() == null) {
                    }
                    z = false;
                }
            } else {
                z = false;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    private void bE(View view) {
        if (view != null && this.dWJ.dXa) {
            view.setVisibility(8);
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            } else if (this.dGH != null && this.dGH.get() != null) {
                b bVar = ((com.tencent.mm.plugin.appbrand.page.h) this.dGH.get()).dOh;
                if (bVar != null) {
                    bVar.bD(view);
                }
            }
        }
    }

    public final void SO() {
        if (this.dWM != null) {
            this.dWM.dYp = this.dWQ;
            this.dWM.dYq = this.dWR;
            this.dWM.dYs = this.dWS;
        }
    }

    private void kK(boolean z) {
        if (this.dWL != null) {
            e(this.dWL.getText().toString(), this.dWH, z);
        }
    }

    public final i SQ() {
        if (this.dWM != null) {
            return this.dWM;
        }
        if (this.dGH == null || this.dGH.get() == null) {
            return null;
        }
        i bJ = i.bJ((View) this.dGH.get());
        this.dWM = bJ;
        return bJ;
    }

    public final void SR() {
        if (SQ() != null) {
            this.dWM.hide();
        }
    }

    public final g SS() {
        if (this.dWN != null) {
            return this.dWN;
        }
        if (this.dGH == null || this.dGH.get() == null) {
            return null;
        }
        g bI = g.bI((View) this.dGH.get());
        this.dWN = bI;
        return bI;
    }

    public final void ST() {
        if (SS() != null) {
            this.dWN.setVisibility(8);
        }
    }

    public final void SU() {
        SR();
        if (this.dWN != null && this.dWL != null && this.dWL.isShown()) {
            this.dWN.setVisibility(0);
            SV();
            this.dWN.setInputEditText(this.dWL);
            a(this.dWL);
            this.dWL.post(new c(this) {
                final /* synthetic */ c dWU;

                {
                    this.dWU = r2;
                }

                public final View SW() {
                    return this.dWU.dWN;
                }
            });
        }
    }

    private static void a(EditText editText) {
        if (editText != null) {
            c.d(editText);
        }
    }

    public final void SV() {
        if (this.dWN != null) {
            g gVar = this.dWN;
            gVar.dYe.setXMode(be.n(dWT.get(this.dWJ.dWY), 0));
        }
    }

    static {
        Map hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        dWT = Collections.unmodifiableMap(hashMap);
    }
}
