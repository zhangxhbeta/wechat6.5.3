package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;

public class AdVideoPlayerLoadingBar extends RelativeLayout implements a {
    public View dtW = null;
    public boolean ecK = false;
    public b iUG = null;
    public ImageView iUH;
    public ImageView iUI = null;
    public ImageView iUJ = null;
    public ImageView iUK = null;
    public TextView iUL;
    public TextView iUM;
    public int iUN = 0;
    private int iUO = 0;
    public float iUP = 0.0f;
    private int iUQ = -1;
    private int iUR = -1;
    private int iUS = -1;
    private int iUT = -1;
    public int kB = 0;

    static /* synthetic */ int a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i) {
        int width = ((adVideoPlayerLoadingBar.iUJ.getWidth() - adVideoPlayerLoadingBar.iUJ.getPaddingLeft()) - adVideoPlayerLoadingBar.iUJ.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) adVideoPlayerLoadingBar.iUI.getLayoutParams();
        if (i < (layoutParams.leftMargin - adVideoPlayerLoadingBar.iUJ.getPaddingLeft()) - width) {
            return (layoutParams.leftMargin - adVideoPlayerLoadingBar.iUJ.getPaddingLeft()) - width;
        }
        return i > adVideoPlayerLoadingBar.aPs() ? adVideoPlayerLoadingBar.aPs() - width : i - width;
    }

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutId() {
        return 2130904570;
    }

    public final void a(b bVar) {
        this.iUG = bVar;
    }

    public void init() {
        this.dtW = View.inflate(getContext(), getLayoutId(), this);
        this.iUH = (ImageView) this.dtW.findViewById(2131759273);
        this.iUI = (ImageView) this.dtW.findViewById(2131759272);
        this.iUJ = (ImageView) this.dtW.findViewById(2131759274);
        this.iUK = (ImageView) this.dtW.findViewById(2131759269);
        this.iUL = (TextView) this.dtW.findViewById(2131759270);
        this.iUM = (TextView) this.dtW.findViewById(2131759271);
        this.iUJ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AdVideoPlayerLoadingBar iUU;

            {
                this.iUU = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    v.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
                    this.iUU.ecK = false;
                    this.iUU.iUP = motionEvent.getX();
                    if (this.iUU.iUG != null) {
                        this.iUU.iUG.aPv();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.iUU.iUJ.getLayoutParams();
                    layoutParams.leftMargin = AdVideoPlayerLoadingBar.a(this.iUU, ((int) (x - this.iUU.iUP)) + layoutParams.leftMargin);
                    this.iUU.iUJ.setLayoutParams(layoutParams);
                    int aPq = this.iUU.aPq();
                    if (this.iUU.iUN > 0) {
                        layoutParams = (LayoutParams) this.iUU.iUH.getLayoutParams();
                        layoutParams.width = (int) (((((double) aPq) * 1.0d) / ((double) this.iUU.iUN)) * ((double) this.iUU.aPs()));
                        this.iUU.iUH.setLayoutParams(layoutParams);
                    }
                    this.iUU.iUL.setText(AdVideoPlayerLoadingBar.pA(aPq / 60) + ":" + AdVideoPlayerLoadingBar.pA(aPq % 60));
                    this.iUU.ecK = true;
                } else if (this.iUU.ecK) {
                    int aPq2 = this.iUU.aPq();
                    if (this.iUU.iUG != null) {
                        v.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + aPq2);
                        this.iUU.iUG.pB(aPq2);
                    }
                    this.iUU.ecK = false;
                }
                return true;
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!(i == this.iUQ && i2 == this.iUR && i3 == this.iUS && i4 == this.iUT)) {
            aPu();
        }
        this.iUQ = i;
        this.iUR = i2;
        this.iUS = i3;
        this.iUT = i4;
    }

    public final void d(OnClickListener onClickListener) {
        this.iUK.setOnClickListener(onClickListener);
    }

    public void fA(boolean z) {
        if (z) {
            this.iUK.setImageResource(2131165673);
        } else {
            this.iUK.setImageResource(2131165675);
        }
    }

    protected final int aPq() {
        return (int) (((((double) (((LayoutParams) this.iUJ.getLayoutParams()).leftMargin - (((LayoutParams) this.iUI.getLayoutParams()).leftMargin - this.iUJ.getPaddingLeft()))) * 1.0d) / ((double) aPs())) * ((double) this.iUN));
    }

    public void py(int i) {
        this.kB = i;
        aPu();
    }

    public final int aPr() {
        return this.iUN;
    }

    public void pz(final int i) {
        if (this.iUJ.getWidth() == 0) {
            post(new Runnable(this) {
                final /* synthetic */ AdVideoPlayerLoadingBar iUU;

                public final void run() {
                    this.iUU.pz(i);
                }
            });
            return;
        }
        this.iUN = i;
        this.kB = 0;
        this.iUM.setText(pA(this.iUN / 60) + ":" + pA(this.iUN % 60));
        aPu();
    }

    public final int aPs() {
        this.iUO = this.iUI.getWidth();
        return this.iUO;
    }

    public final void aPt() {
        this.iUO = 0;
    }

    public void aPu() {
        if (this.iUN != 0 && !this.ecK && this.iUJ != null && aPs() != 0) {
            int width = ((this.iUJ.getWidth() - this.iUJ.getPaddingLeft()) - this.iUJ.getPaddingRight()) / 2;
            this.iUL.setText(pA(this.kB / 60) + ":" + pA(this.kB % 60));
            LayoutParams layoutParams = (LayoutParams) this.iUJ.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.iUI.getLayoutParams()).leftMargin - this.iUJ.getPaddingLeft()) + ((int) (((((double) this.kB) * 1.0d) / ((double) this.iUN)) * ((double) aPs())))) - width;
            this.iUJ.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.iUH.getLayoutParams();
            layoutParams.width = (int) (((((double) this.kB) * 1.0d) / ((double) this.iUN)) * ((double) aPs()));
            this.iUH.setLayoutParams(layoutParams);
        }
    }

    public static String pA(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }
}
