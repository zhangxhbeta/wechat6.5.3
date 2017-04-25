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

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    public boolean bee = false;
    private View dtW = null;
    private boolean ecK = false;
    public b iUG = null;
    private ImageView iUH;
    private ImageView iUI = null;
    private ImageView iUJ = null;
    private ImageView iUK = null;
    private TextView iUL;
    private TextView iUM;
    public int iUN = 0;
    private int iUO = 0;
    private float iUP = 0.0f;
    private int iUQ = -1;
    private int iUR = -1;
    private int iUS = -1;
    private int iUT = -1;
    private int kB = 0;

    static /* synthetic */ int a(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i) {
        int width = ((snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getWidth() - snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getPaddingLeft()) - snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.iUI.getLayoutParams();
        if (i < (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getPaddingLeft()) - width) {
            return (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getPaddingLeft()) - width;
        }
        return i > snsAdNativeLandingPagesVideoPlayerLoadingBar.aPs() ? snsAdNativeLandingPagesVideoPlayerLoadingBar.aPs() - width : i - width;
    }

    static /* synthetic */ int d(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        int paddingLeft = (int) (((((double) (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getLayoutParams()).leftMargin - (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.iUI.getLayoutParams()).leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.iUJ.getPaddingLeft()))) * 1.0d) / ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.aPs())) * ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.iUN));
        return paddingLeft < 0 ? 0 : paddingLeft;
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(b bVar) {
        this.iUG = bVar;
    }

    private void init() {
        this.dtW = View.inflate(getContext(), 2130904434, this);
        this.iUH = (ImageView) this.dtW.findViewById(2131759273);
        this.iUI = (ImageView) this.dtW.findViewById(2131759272);
        this.iUJ = (ImageView) this.dtW.findViewById(2131759274);
        this.iUK = (ImageView) this.dtW.findViewById(2131759269);
        this.iUL = (TextView) this.dtW.findViewById(2131759270);
        this.iUM = (TextView) this.dtW.findViewById(2131759271);
        this.iUJ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar iVx;

            {
                this.iVx = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    v.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    this.iVx.ecK = false;
                    this.iVx.iUP = motionEvent.getX();
                    if (this.iVx.iUG != null) {
                        this.iVx.iUG.aPv();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.iVx.iUJ.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.iVx, ((int) (x - this.iVx.iUP)) + layoutParams.leftMargin);
                    this.iVx.iUJ.setLayoutParams(layoutParams);
                    int d = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.iVx);
                    if (this.iVx.iUN > 0) {
                        layoutParams = (LayoutParams) this.iVx.iUH.getLayoutParams();
                        layoutParams.width = (int) (((((double) d) * 1.0d) / ((double) this.iVx.iUN)) * ((double) this.iVx.aPs()));
                        this.iVx.iUH.setLayoutParams(layoutParams);
                    }
                    this.iVx.iUL.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.pA(d / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.pA(d % 60));
                    this.iVx.ecK = true;
                } else if (this.iVx.ecK) {
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.iVx);
                    if (this.iVx.iUG != null) {
                        v.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : " + d2);
                        this.iVx.iUG.pB(d2);
                    }
                    this.iVx.ecK = false;
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

    public final void fA(boolean z) {
        this.bee = z;
        if (z) {
            this.iUK.setImageResource(2131165673);
        } else {
            this.iUK.setImageResource(2131165675);
        }
    }

    public final void py(int i) {
        this.kB = i;
        aPu();
    }

    public final int aPr() {
        return this.iUN;
    }

    public final void pz(final int i) {
        if (this.iUJ.isShown() && this.iUJ.getWidth() == 0) {
            post(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar iVx;

                public final void run() {
                    this.iVx.pz(i);
                }
            });
            return;
        }
        this.iUN = i;
        this.kB = 0;
        this.iUM.setText(pA(this.iUN / 60) + ":" + pA(this.iUN % 60));
        aPu();
    }

    private int aPs() {
        this.iUO = this.iUI.getWidth();
        return this.iUO;
    }

    public final void aPt() {
        this.iUO = 0;
    }

    private void aPu() {
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
