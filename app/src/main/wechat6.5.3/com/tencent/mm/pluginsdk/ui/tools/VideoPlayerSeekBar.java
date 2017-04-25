package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.v;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar {
    public boolean bee = false;
    private PInt lUp = new PInt();
    private int lUq = -1;
    private int lUr = -1;
    private int lUs = -1;

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        int bqV = ((LayoutParams) videoPlayerSeekBar.iUI.getLayoutParams()).leftMargin - videoPlayerSeekBar.bqV();
        pInt.value = (int) (((((double) (i - bqV)) * 1.0d) / ((double) videoPlayerSeekBar.aPs())) * ((double) videoPlayerSeekBar.iUN));
        if (pInt.value <= 0) {
            pInt.value = 0;
            return i - bqV > bqV ? i - bqV : bqV;
        } else if (pInt.value < videoPlayerSeekBar.iUN) {
            return i - bqV;
        } else {
            pInt.value = videoPlayerSeekBar.iUN;
            return videoPlayerSeekBar.aPs() - (((videoPlayerSeekBar.bqU() - videoPlayerSeekBar.bqV()) - videoPlayerSeekBar.bqW()) / 2);
        }
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void init() {
        this.dtW = View.inflate(getContext(), 2130904571, this);
        this.iUH = (ImageView) this.dtW.findViewById(2131759273);
        this.iUI = (ImageView) this.dtW.findViewById(2131759272);
        this.iUJ = (ImageView) this.dtW.findViewById(2131759274);
        this.iUK = (ImageView) this.dtW.findViewById(2131759269);
        this.iUL = (TextView) this.dtW.findViewById(2131759270);
        this.iUM = (TextView) this.dtW.findViewById(2131759271);
        this.iUJ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ VideoPlayerSeekBar lUt;

            {
                this.lUt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    v.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
                    this.lUt.ecK = false;
                    this.lUt.iUP = motionEvent.getX();
                    if (this.lUt.iUG != null) {
                        this.lUt.iUG.aPv();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.lUt.iUJ.getLayoutParams();
                    int a = VideoPlayerSeekBar.a(this.lUt, ((int) (x - this.lUt.iUP)) + layoutParams.leftMargin, this.lUt.lUp);
                    layoutParams.leftMargin = a;
                    this.lUt.iUJ.setLayoutParams(layoutParams);
                    int i = this.lUt.lUp.value;
                    if (this.lUt.iUN > 0) {
                        layoutParams = (LayoutParams) this.lUt.iUH.getLayoutParams();
                        layoutParams.width = a;
                        this.lUt.iUH.setLayoutParams(layoutParams);
                    }
                    this.lUt.iUL.setText(AdVideoPlayerLoadingBar.pA(i / 60) + ":" + AdVideoPlayerLoadingBar.pA(i % 60));
                    this.lUt.ecK = true;
                } else if (this.lUt.ecK) {
                    int a2 = this.lUt.kB = this.lUt.lUp.value;
                    if (this.lUt.iUG != null) {
                        v.i("MicroMsg.VideoPlayerSeekBar", "current time : " + a2);
                        this.lUt.iUG.pB(a2);
                    }
                    this.lUt.ecK = false;
                }
                return true;
            }
        });
    }

    private int bqU() {
        if (this.lUq == -1) {
            this.lUq = this.iUJ.getWidth();
        }
        return this.lUq;
    }

    private int bqV() {
        if (this.lUr == -1) {
            this.lUr = this.iUJ.getPaddingLeft();
        }
        return this.lUr;
    }

    private int bqW() {
        if (this.lUs == -1) {
            this.lUs = this.iUJ.getPaddingRight();
        }
        return this.lUs;
    }

    protected final int getLayoutId() {
        return 2130904571;
    }

    public final void py(int i) {
        v.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + i);
        if (i < 0) {
            i = 0;
        }
        if (i >= this.iUN) {
            i = this.iUN;
        }
        if (this.kB != i) {
            this.kB = i;
            aPu();
        }
    }

    public final void pz(int i) {
        this.iUN = i;
        this.kB = 0;
        this.iUM.setText(AdVideoPlayerLoadingBar.pA(this.iUN / 60) + ":" + AdVideoPlayerLoadingBar.pA(this.iUN % 60));
        aPu();
    }

    public final void aPu() {
        if (this.iUN != 0 && !this.ecK && this.iUJ != null && aPs() != 0) {
            this.iUL.setText(AdVideoPlayerLoadingBar.pA(this.kB / 60) + ":" + AdVideoPlayerLoadingBar.pA(this.kB % 60));
            LayoutParams layoutParams = (LayoutParams) this.iUJ.getLayoutParams();
            int aPs = aPs();
            int i = this.kB;
            if (i <= 0) {
                this.iUI.getLayoutParams();
                i = 0;
            } else {
                i = i >= this.iUN ? aPs - (((bqU() - bqV()) - bqW()) / 2) : (int) (((((double) i) * 1.0d) / ((double) this.iUN)) * ((double) aPs));
            }
            layoutParams.leftMargin = i;
            this.iUJ.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.iUH.getLayoutParams();
            layoutParams.width = (int) (((double) aPs) * ((((double) this.kB) * 1.0d) / ((double) this.iUN)));
            this.iUH.setLayoutParams(layoutParams);
        }
    }

    public final void g(OnClickListener onClickListener) {
        if (this.iUK != null) {
            this.iUK.setOnClickListener(onClickListener);
        }
    }

    public final void fA(boolean z) {
        this.bee = z;
        super.fA(z);
    }
}
