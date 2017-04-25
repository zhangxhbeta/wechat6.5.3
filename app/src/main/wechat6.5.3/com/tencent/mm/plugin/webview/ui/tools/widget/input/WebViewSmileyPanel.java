package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements e, com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a {
    private View Hq = null;
    private boolean dYF = false;
    private MMActivity eBk;
    private MMDotView fjs;
    private c lse;
    private a lsl;
    private WebViewSmileyViewPager lsm = null;
    private boolean lsn = true;

    public interface a {
        void Tm();

        void append(String str);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void W(int i) {
        a blQ = this.lse.blQ();
        int pageCount = blQ.getPageCount();
        int i2 = i - blQ.fkP;
        if (pageCount <= 1) {
            this.fjs.setVisibility(4);
            return;
        }
        this.fjs.setVisibility(0);
        this.fjs.wt(pageCount);
        this.fjs.wu(i2);
    }

    public final void X(int i) {
    }

    public final void blM() {
        if (this.lsm != null) {
            this.lse.lsn = j.aF(getContext());
            b bVar = (b) this.lsm.xA;
            if (bVar != null) {
                bVar.lst.clear();
                bVar.lse = this.lse;
                bVar.notifyDataSetChanged();
            } else {
                bVar = new b();
                bVar.lse = this.lse;
                this.lsm.a(bVar);
            }
            this.lsm.post(new Runnable(this) {
                final /* synthetic */ WebViewSmileyPanel lso;

                {
                    this.lso = r1;
                }

                public final void run() {
                    this.lso.W(this.lso.lsm.xB);
                }
            });
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        blP();
    }

    public void onMeasure(int i, int i2) {
        if (this.dYF) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.aF(getContext());
        super.onMeasure(i, i2);
    }

    @SuppressLint({"WrongCall"})
    public final void bi(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void a(a aVar) {
        this.lsl = aVar;
        this.lse.lsq = this.lsl;
    }

    public final void onDestroy() {
        c cVar = this.lse;
        cVar.lsp = null;
        cVar.fda = null;
        if (this.Hq != null) {
            ((ViewGroup) this.Hq.getParent()).removeView(this.Hq);
            ((ViewGroup) this.Hq).removeAllViews();
            this.Hq = null;
        }
        this.eBk = null;
    }

    public final void blN() {
        if (this.Hq != null) {
            this.Hq.setVisibility(0);
        }
    }

    public final void blO() {
        if (this.Hq != null) {
            this.Hq.setVisibility(4);
        }
    }

    private void init() {
        this.eBk = (MMActivity) getContext();
        this.lse = Td();
        this.lse.fda = getContext();
        this.lse.lsq = this.lsl;
    }

    public c Td() {
        return new c();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.dYF = false;
        } else {
            this.dYF = true;
        }
        super.setVisibility(i);
        if (!this.dYF) {
            this.eBk.axg();
            NI();
        }
    }

    public final void to(int i) {
        super.setVisibility(i);
    }

    public final void NI() {
        if (this.Hq == null || getChildCount() <= 0) {
            if (this.Hq == null) {
                this.Hq = View.inflate(aa.getContext(), 2130904710, null);
            } else if (this.Hq.getParent() != null) {
                ((ViewGroup) this.Hq.getParent()).removeView(this.Hq);
            }
            this.lsm = (WebViewSmileyViewPager) this.Hq.findViewById(2131759218);
            this.lsm.b(this);
            this.lsm.lse = this.lse;
            this.lsm.lss = this;
            this.fjs = (MMDotView) this.Hq.findViewById(2131759219);
            this.fjs.wt(1);
            blP();
            addView(this.Hq, new LayoutParams(-1, -1));
            return;
        }
        this.Hq.setVisibility(0);
    }

    private void blP() {
        if (this.fjs != null) {
            boolean aF = j.aF(getContext());
            if (aF != this.lsn) {
                RelativeLayout.LayoutParams layoutParams;
                if (aF) {
                    this.fjs.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131493152));
                    layoutParams = (RelativeLayout.LayoutParams) this.fjs.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131493441);
                    this.fjs.setLayoutParams(layoutParams);
                } else {
                    this.fjs.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131493144));
                    layoutParams = (RelativeLayout.LayoutParams) this.fjs.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.fjs.setLayoutParams(layoutParams);
                }
                this.lsn = aF;
            }
        }
    }
}
