package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class i extends LinearLayout implements a {
    private static final a dYB = new e();
    private MMActivity aWn;
    private int dYA = 0;
    private final Runnable dYo = new Runnable(this) {
        final /* synthetic */ i dYC;

        {
            this.dYC = r1;
        }

        public final void run() {
            if (this.dYC.dYt != null && this.dYC.dYt.Tf()) {
                if (this.dYC.dYt.Te()) {
                    v.d("MicroMsg.AppBrandSmileyPanelWrapper", "postMeasure inLayout, skip");
                    this.dYC.post(this);
                    return;
                }
                i.b(this.dYC);
            }
        }
    };
    c dYp;
    b dYq;
    private boolean dYr = false;
    d dYs;
    private AppBrandSmileyPanel dYt;
    private f dYu;
    private ImageButton dYv;
    private boolean dYw;
    private View dYx;
    private boolean dYy;
    public EditText dYz;
    private int state = 0;

    interface a {
        void b(i iVar, int i);

        void l(i iVar);

        void m(i iVar);

        void n(i iVar);

        void o(i iVar);
    }

    public interface b {
        void kL(boolean z);
    }

    public interface c {
        boolean oI(String str);
    }

    public interface d {
        void hD(int i);
    }

    private static final class f extends FrameLayout {
        boolean dYF = false;

        public f(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(2130903130, this);
        }

        protected final void onMeasure(int i, int i2) {
            if (this.dYF) {
                i = MeasureSpec.makeMeasureSpec(0, 1073741824);
                i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    private static final class e implements a {
        private e() {
        }

        public final void l(i iVar) {
            if (iVar.isShown()) {
                iVar.dYt.setVisibility(0);
            }
            iVar.dYt.blO();
        }

        public final void m(i iVar) {
            if (com.tencent.mm.plugin.appbrand.ui.f.dg(iVar)) {
                iVar.to(8);
                iVar.bRI();
                return;
            }
            if (iVar.isShown()) {
                iVar.dYt.setVisibility(0);
            }
            if (iVar.dYw) {
                iVar.dYt.blN();
            } else {
                iVar.dYt.blO();
            }
        }

        public final void b(i iVar, int i) {
            if (com.tencent.mm.plugin.appbrand.ui.f.dg(iVar)) {
                iVar.to(8);
            } else if (iVar.dYt != null && i > 0) {
                iVar.hG(iVar.dYA);
            }
        }

        public final void n(i iVar) {
            iVar.aWn.aJs();
            iVar.SR();
        }

        public final void o(i iVar) {
            iVar.aWn.axg();
            iVar.Tj();
            iVar.hF(j.aD(iVar.aWn));
        }
    }

    static /* synthetic */ void b(i iVar) {
        v.d("MicroMsg.AppBrandSmileyPanelWrapper", "forceMeasurePanel enter");
        iVar.dYt.requestLayout();
    }

    public static i bJ(View view) {
        return (i) view.getRootView().findViewById(2131755015);
    }

    public final void hF(int i) {
        dYB.b(this, i);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        v.d("MicroMsg.AppBrandSmileyPanelWrapper", "smileyPanelWrapper onLayout");
    }

    public final void hG(int i) {
        int i2 = 0;
        if (!com.tencent.mm.plugin.appbrand.ui.f.dg(this)) {
            v.d("MicroMsg.AppBrandSmileyPanelWrapper", "refreshRootOffset, offset = %d", new Object[]{Integer.valueOf(i)});
            this.dYA = i;
            int aD = j.aD(aa.getContext());
            if (this.state != 0) {
                i = 0;
            }
            aD += i;
            AppBrandSmileyPanel appBrandSmileyPanel = this.dYt;
            if (aD > 0 && appBrandSmileyPanel.dYh != aD) {
                appBrandSmileyPanel.dYh = aD;
                i2 = 1;
            }
            if (i2 != 0) {
                this.dYo.run();
            }
        }
    }

    public final void bH(boolean z) {
        v.d("MicroMsg.AppBrandSmileyPanelWrapper", "onKeyboardStateChanged, kbShown = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            to(0);
            SR();
        } else if (!isShown()) {
        } else {
            if (this.dYw && 1 == this.state) {
                Tj();
            } else {
                hide();
            }
        }
    }

    private void kL(boolean z) {
        if (!this.dYr && this.dYq != null) {
            this.dYr = true;
            this.dYq.kL(z);
            this.dYr = false;
        }
    }

    public i(Context context) {
        super(context);
        this.aWn = (MMActivity) context;
        super.setId(2131755015);
        setOrientation(1);
        this.dYu = new f(getContext());
        f fVar = this.dYu;
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, aa.getResources().getDrawable(2131165971));
        stateListDrawable.addState(new int[0], aa.getResources().getDrawable(2131165970));
        this.dYv = (ImageButton) fVar.findViewById(2131755455);
        this.dYv.setSelected(false);
        this.dYv.setImageDrawable(stateListDrawable);
        this.dYv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ i dYC;

            {
                this.dYC = r1;
            }

            public final void onClick(View view) {
                if (view.isSelected()) {
                    i.dYB.n(this.dYC);
                    view.setSelected(false);
                    return;
                }
                i.dYB.o(this.dYC);
                view.setSelected(true);
            }
        });
        this.dYx = fVar.findViewById(2131755454);
        this.dYx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ i dYC;

            {
                this.dYC = r1;
            }

            public final void onClick(View view) {
                this.dYC.kL(true);
            }
        });
        addView(this.dYu);
        this.dYt = new AppBrandSmileyPanel(getContext());
        this.dYt.setVisibility(8);
        this.dYt.setBackgroundResource(2130837784);
        this.dYt.a(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a(this) {
            final /* synthetic */ i dYC;

            {
                this.dYC = r1;
            }

            public final void append(String str) {
                if (this.dYC.dYp != null) {
                    this.dYC.dYp.oI(str);
                }
            }

            public final void Tm() {
                if (this.dYC.dYp != null) {
                    this.dYC.dYp.oI("[DELETE_EMOTION]");
                }
            }
        });
        addView(this.dYt);
        Tk();
    }

    public final void setId(int i) {
    }

    private void hK(final int i) {
        final boolean z = this.dYr;
        post(new Runnable(this) {
            final /* synthetic */ i dYC;

            public final void run() {
                int e = this.dYC.state;
                if (this.dYC.isShown()) {
                    this.dYC.state = i;
                } else {
                    this.dYC.state = 2;
                }
                if (this.dYC.dYs != null && e != this.dYC.state && !z) {
                    this.dYC.dYs.hD(this.dYC.state);
                }
            }
        });
    }

    private void bRI() {
        SR();
        if (this.dYz != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.dYz.getContext().getSystemService("input_method");
            if (!inputMethodManager.showSoftInput(this.dYz, 1)) {
                inputMethodManager.showSoftInput(this.dYz, 2);
                return;
            }
            return;
        }
        this.aWn.aJs();
    }

    private void Tj() {
        dYB.m(this);
        this.dYv.setSelected(true);
        hK(1);
    }

    private void SR() {
        dYB.l(this);
        this.dYv.setSelected(false);
        hK(0);
    }

    private void Tk() {
        boolean z = false;
        if (this.dYu != null) {
            f fVar = this.dYu;
            if (((!this.dYw ? 1 : 0) & (!this.dYy ? 1 : 0)) != 0 || com.tencent.mm.plugin.appbrand.ui.f.dg(this)) {
                z = true;
            }
            fVar.dYF = z;
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        v.d("MicroMsg.AppBrandSmileyPanelWrapper", "smileyPanelWrapper, onMeasure");
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        to(8);
        if (this.aWn != null) {
            if (this.dYz != null) {
                this.aWn.cx(this.dYz);
            } else {
                this.aWn.axg();
            }
        }
        this.dYt.onDestroy();
        this.dYv.setOnClickListener(null);
        this.dYp = null;
        removeAllViews();
        this.aWn = null;
    }

    public final void setVisibility(int i) {
        if (i == 8) {
            kL(false);
            hide();
        } else if (i == 0) {
            show();
        } else {
            to(i);
        }
    }

    final void to(int i) {
        if (i == 0 && com.tencent.mm.plugin.appbrand.ui.f.dg(this)) {
            i = 8;
        }
        if (getVisibility() != i) {
            super.setVisibility(i);
        }
    }

    public final void bRJ() {
        int i = 0;
        this.dYw = false;
        if (this.dYv != null) {
            ImageButton imageButton = this.dYv;
            if (!this.dYw) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
    }

    public final void bJ(boolean z) {
        this.dYy = z;
        if (this.dYx != null) {
            this.dYx.setVisibility(this.dYy ? 0 : 4);
        }
    }

    public final void show() {
        bRI();
        bRJ();
        bJ(this.dYy);
        Tk();
        if (!isShown()) {
            to(0);
        }
        hG(this.dYA);
    }

    public final void hide() {
        if (isShown()) {
            to(8);
            if (this.aWn != null) {
                this.aWn.axg();
            }
            SR();
        }
    }
}
