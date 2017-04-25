package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView extends RelativeLayout implements com.tencent.mm.model.d.a, g {
    public String cPu;
    private ac cnC = new ac();
    private int duration = 0;
    private boolean eJx = false;
    public g eJz = null;
    public View fIV;
    public ProgressBar fpm;
    private boolean iVA = true;
    public a iVB;
    private ViewGroup iVC;
    public a iVD;
    private double iVE = 0.0d;
    public TextView iVF;
    public String iVG = "";
    public View iVH;
    public View iVI;
    public boolean iVJ = true;
    private int iVK = 0;
    private int iVL = 0;
    public boolean iVM = false;
    private long iVN = 0;
    private Animation iVO = new AlphaAnimation(1.0f, 0.0f);
    private Animation iVP = new AlphaAnimation(0.0f, 1.0f);
    private Runnable iVQ = new Runnable(this) {
        final /* synthetic */ VideoPlayView iVS;

        {
            this.iVS = r1;
        }

        public final void run() {
            this.iVS.aPA();
        }
    };
    public int iVR = 0;
    private int iVy = 320;
    private int iVz = 240;

    public interface a {
        void aPD();

        void aPE();

        void fF(boolean z);

        void pD(int i);
    }

    static /* synthetic */ void k(VideoPlayView videoPlayView) {
        if (videoPlayView.iVH.getVisibility() == 0) {
            videoPlayView.aPA();
        } else {
            videoPlayView.aPz();
        }
    }

    public final void setVideoPath(String str) {
        this.cPu = str;
        v.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[]{this.cPu});
        this.eJz.setVideoPath(this.cPu);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iVO.setDuration(200);
        this.iVP.setDuration(200);
        View.inflate(getContext(), 2130904569, this);
        this.iVH = findViewById(2131759618);
        this.iVI = findViewById(2131759619);
        this.fpm = (ProgressBar) findViewById(2131757495);
        this.iVC = (ViewGroup) findViewById(2131756998);
        this.eJz = o.do(getContext());
        this.eJz.fD(false);
        this.iVC.addView((View) this.eJz, 0, new LayoutParams(-1, -1));
        this.iVF = (TextView) findViewById(2131759210);
        this.fIV = this.iVF;
        this.eJz.a(new com.tencent.mm.pluginsdk.ui.tools.g.a(this) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final void abH() {
                v.d("MicroMsg.VideoPlayView", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                this.iVS.fC(true);
            }

            public final void bp(int i, int i2) {
                v.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.iVS.eJz.stop();
            }

            public final void pa() {
                v.d("MicroMsg.VideoPlayView", "on completion " + be.bur().toString());
                if (!this.iVS.iVM) {
                    this.iVS.iVE = 0.0d;
                }
                this.iVS.i(0.0d);
                this.iVS.iVD.fA(false);
                this.iVS.pC(0);
                this.iVS.aPz();
                if (System.currentTimeMillis() - this.iVS.iVN < 2000) {
                    v.i("MicroMsg.VideoPlayView", "Too short onCompletion");
                    return;
                }
                this.iVS.iVN = System.currentTimeMillis();
                if (this.iVS.iVB != null) {
                    this.iVS.iVB.aPE();
                }
            }

            public final int bq(final int i, final int i2) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iVV;

                    public final void run() {
                        v.i("MicroMsg.VideoPlayView", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            this.iVV.iVS.duration = i2;
                            if (this.iVV.iVS.iVD != null && this.iVV.iVS.iVA) {
                                this.iVV.iVS.iVA = false;
                            }
                            this.iVV.iVS.iVB.pD(i2);
                        }
                        if (this.iVV.iVS.iVD != null) {
                            if (this.iVV.iVS.iVD.aPr() != i2) {
                                this.iVV.iVS.iVD.pz(i2);
                            }
                            this.iVV.iVS.iVD.py(i);
                        }
                        if (this.iVV.iVS.fpm.getVisibility() == 0) {
                            this.iVV.iVS.fpm.setVisibility(8);
                        }
                    }
                });
                return 0;
            }

            public final void br(int i, int i2) {
                this.iVS.iVy = i;
                this.iVS.iVz = i2;
            }
        });
        if (this.eJz instanceof VideoSightView) {
            ((VideoSightView) this.eJz).lUB = false;
        }
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayView.k(this.iVS);
                } else {
                    motionEvent.getAction();
                }
                return true;
            }
        });
        aPA();
        ((View) this.eJz).post(new Runnable(this) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (this.iVS.getContext() instanceof MMActivity) {
                    ((MMActivity) this.iVS.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    if (this.iVS.eJz instanceof VideoSightView) {
                        ((VideoSightView) this.iVS.eJz).pv(displayMetrics.widthPixels);
                    }
                }
                ((View) this.iVS.eJz).requestLayout();
                ((View) this.iVS.eJz).postInvalidate();
            }
        });
    }

    private void aPz() {
        ((View) this.iVD).setVisibility(0);
        this.iVH.setVisibility(0);
        if (this.iVJ) {
            this.iVI.setVisibility(0);
        }
        int i = this.iVR == 2 ? 0 : be.kS(this.iVG) ? 0 : 1;
        if (i != 0) {
            this.fIV.setVisibility(0);
        }
        this.cnC.removeCallbacks(this.iVQ);
        this.cnC.postDelayed(this.iVQ, 3000);
    }

    public final void aPA() {
        if (this.iVD != null) {
            ((View) this.iVD).setVisibility(8);
        }
        this.iVH.setVisibility(8);
        this.iVI.setVisibility(8);
        this.fIV.setVisibility(8);
    }

    public final boolean start() {
        fC(true);
        return true;
    }

    public final void pause() {
        pC(-1);
    }

    private void fC(boolean z) {
        this.eJz.i(this.iVE);
        this.eJz.start();
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final void run() {
                if (this.iVS.iVD != null) {
                    this.iVS.iVD.fA(true);
                }
            }
        });
        v.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.iVE);
        if (this.iVB != null) {
            this.iVB.fF(z);
        }
    }

    private void pC(int i) {
        this.iVE = i >= 0 ? (double) i : this.eJz.aPB();
        v.i("MicroMsg.VideoPlayView", "pause play " + this.iVE + " lastTime: " + i + " last " + this.eJz.aPB());
        this.eJz.pause();
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final void run() {
                if (this.iVS.iVD != null) {
                    this.iVS.iVD.fA(false);
                }
            }
        });
        if (this.iVB != null) {
            this.iVB.aPD();
        }
    }

    public final boolean isPlaying() {
        return this.eJz.isPlaying();
    }

    public final String aOV() {
        return this.cPu;
    }

    public final boolean h(Context context, boolean z) {
        return this.eJz.h(context, z);
    }

    public final void stop() {
        this.eJz.stop();
    }

    public final void onDetach() {
        this.eJz.onDetach();
    }

    public final void fD(boolean z) {
        this.eJz.fD(z);
    }

    public final double aPB() {
        return this.eJz.aPB();
    }

    public final void a(com.tencent.mm.pluginsdk.ui.tools.g.a aVar) {
        this.eJz.a(aVar);
    }

    public final int getCurrentPosition() {
        return this.eJz.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.duration == 0) {
            return this.eJz.getDuration();
        }
        return this.duration;
    }

    public final void i(double d) {
        this.eJz.i(d);
        this.iVD.py((int) d);
    }

    public final void fE(boolean z) {
        this.eJz.fE(z);
    }

    public final void update(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVL == 0 || this.iVK == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.iVL = displayMetrics.heightPixels;
            this.iVK = displayMetrics.widthPixels;
            if (this.iVL < this.iVK) {
                this.iVL = displayMetrics.widthPixels;
                this.iVK = displayMetrics.heightPixels;
            }
            v.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.iVL + " screen_width:" + this.iVK);
        }
        ViewGroup.LayoutParams layoutParams2 = this.iVC.getLayoutParams();
        if (this.iVD == null) {
            layoutParams = null;
        } else {
            layoutParams = (LayoutParams) ((View) this.iVD).getLayoutParams();
        }
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        if (i == 1) {
            layoutParams3.width = this.iVK;
            layoutParams3.height = (int) (((((double) this.iVK) * 1.0d) * ((double) this.iVz)) / ((double) this.iVy));
            if (this.iVD != null) {
                layoutParams.bottomMargin = b.a(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.iVK;
            layoutParams3.width = (int) (((((double) this.iVK) * 1.0d) * ((double) this.iVy)) / ((double) this.iVz));
            if (this.iVD != null) {
                layoutParams.bottomMargin = b.a(getContext(), 0.0f);
            }
        }
        if (this.iVD != null) {
            this.iVD.aPt();
            ((View) this.iVD).setLayoutParams(layoutParams);
            if (this.iVD instanceof AdVideoPlayerLoadingBar) {
                this.cnC.postDelayed(new Runnable(this) {
                    final /* synthetic */ VideoPlayView iVS;

                    {
                        this.iVS = r1;
                    }

                    public final void run() {
                        if (!this.iVS.eJz.isPlaying()) {
                            ((AdVideoPlayerLoadingBar) this.iVS.iVD).aPu();
                        }
                    }
                }, 500);
            }
        }
        v.i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.eJz).setLayoutParams(layoutParams3);
        if (this.eJz instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.eJz).co(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.iVC.setLayoutParams(layoutParams2);
        ((View) this.eJz).requestLayout();
    }

    public final long aPC() {
        return 0;
    }

    public final void dJ(boolean z) {
        this.eJx = z;
    }
}
