package com.tencent.mm.plugin.wenote.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mm.as.u;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;

public class WNNoteFavVoiceBaseView extends LinearLayout {
    public int bdW;
    private ac cnC;
    public int duration;
    public int fLw = 0;
    private ViewGroup fQt;
    private ImageButton fQv;
    private TextView fQw;
    public d liH = null;
    private TextView luJ;
    private TextView luK;
    private WNNoteFavVoiceBaseView luL;
    private SeekBar luM;
    public String luN;
    public boolean luO;
    public boolean luP;
    public boolean luQ;
    public double luR;
    public a luS;
    private boolean luT = false;
    private OnSeekBarChangeListener luU = new OnSeekBarChangeListener(this) {
        final /* synthetic */ WNNoteFavVoiceBaseView luV;

        {
            this.luV = r1;
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            v.i("MicroMsg.WNNoteFavVoiceBaseView", "onStopTrackingTouch");
            this.luV.luT = false;
            int f = (int) (((double) (this.luV.duration * seekBar.getProgress())) * 0.01d);
            float au = com.tencent.mm.au.a.au((long) f);
            this.luV.luS.fQA = this.luV.luS.fQz - au;
            this.luV.fLw = f;
            if (this.luV.liH != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("actionCode", 3);
                    this.luV.liH.i(55, bundle);
                } catch (Throwable e) {
                    v.a("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
                }
            }
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            v.i("MicroMsg.WNNoteFavVoiceBaseView", "onStartTrackingTouch");
            this.luV.luT = true;
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            v.i("MicroMsg.WNNoteFavVoiceBaseView", "onProgressChanged");
            if (this.luV.luT) {
                this.luV.fQw.setText(com.tencent.mm.au.a.s(this.luV.getContext(), (int) com.tencent.mm.au.a.au((long) ((int) (((double) (this.luV.duration * seekBar.getProgress())) * 0.01d)))));
            }
        }
    };
    public String path = "";

    private class a extends ac {
        public boolean cOX;
        float fQA;
        int fQB;
        int fQC;
        float fQz;
        public final /* synthetic */ WNNoteFavVoiceBaseView luV;
        public boolean luW;

        private a(WNNoteFavVoiceBaseView wNNoteFavVoiceBaseView) {
            this.luV = wNNoteFavVoiceBaseView;
            this.luW = false;
        }

        public final void kO(int i) {
            this.cOX = false;
            if (!this.luW) {
                this.fQz = com.tencent.mm.au.a.au((long) i);
                if (this.luV.fLw == 0) {
                    this.fQA = this.fQz;
                }
                this.fQC = com.tencent.mm.bd.a.fromDPToPix(this.luV.getContext(), 3);
                this.luV.cnC.post(new Runnable(this) {
                    final /* synthetic */ a luX;

                    {
                        this.luX = r1;
                    }

                    public final void run() {
                        this.luX.luV.fQw.setText(com.tencent.mm.au.a.s(this.luX.luV.getContext(), 0));
                        this.luX.luV.luJ.setText(com.tencent.mm.au.a.s(this.luX.luV.getContext(), (int) this.luX.fQz));
                        if (this.luX.luW) {
                            this.luX.luV.fQv.setImageResource(2130839562);
                        } else {
                            this.luX.luV.fQv.setImageResource(2130839561);
                        }
                        this.luX.luV.fQv.setContentDescription(this.luX.luV.getContext().getResources().getString(2131231108));
                    }
                });
            }
        }

        public final void begin() {
            this.luW = false;
            stop();
            this.cOX = false;
            this.luV.cnC.post(new Runnable(this) {
                final /* synthetic */ a luX;

                {
                    this.luX = r1;
                }

                public final void run() {
                    this.luX.luV.fQv.setImageResource(2130839561);
                    this.luX.luV.fQv.setContentDescription(this.luX.luV.getContext().getResources().getString(2131231108));
                    this.luX.removeMessages(4096);
                    this.luX.sendEmptyMessage(4096);
                }
            });
        }

        public final void pause() {
            this.cOX = true;
            removeMessages(4096);
            this.luV.fQv.setImageResource(2130839562);
            this.luV.fQv.setContentDescription(this.luV.getContext().getResources().getString(2131231124));
        }

        public final void stop() {
            this.cOX = false;
            kO(this.luV.duration);
        }

        public final void amW() {
            if (!this.luV.luT) {
                this.fQB = ((int) ((1.0f - (this.fQA / this.fQz)) * ((float) (this.luV.fQt.getWidth() - this.fQC)))) + this.fQC;
                this.luV.fQw.setText(com.tencent.mm.au.a.s(this.luV.getContext(), (int) (this.fQz - this.fQA)));
                this.luV.luM.setProgress((int) ((1.0f - (this.fQA / this.fQz)) * 100.0f));
                if (this.fQA <= 0.1f) {
                    this.luW = true;
                    this.cOX = false;
                    removeMessages(4096);
                    this.luV.fQw.setText(com.tencent.mm.au.a.s(this.luV.getContext(), 0));
                    this.luV.fQv.setImageResource(2130839562);
                    this.luV.fQv.setContentDescription(this.luV.getContext().getResources().getString(2131231124));
                    this.luV.fLw = 0;
                    this.luV.luM.setProgress(0);
                }
            }
        }

        public final void b(double d, int i, boolean z) {
            this.fQz = com.tencent.mm.au.a.au((long) i);
            this.fQA = (float) Math.max(0.0d, Math.min((double) this.fQz, ((double) this.fQz) * (1.0d - d)));
            this.fQC = com.tencent.mm.bd.a.fromDPToPix(this.luV.getContext(), 3);
            this.luV.fQv.setImageResource(2130839562);
            this.luV.fQv.setContentDescription(this.luV.getContext().getResources().getString(2131231124));
            amW();
            if (z) {
                this.luV.fQv.setImageResource(2130839561);
                this.luV.fQv.setContentDescription(this.luV.getContext().getResources().getString(2131231108));
                removeMessages(4096);
                sendEmptyMessage(4096);
            }
        }

        public final void handleMessage(Message message) {
            if (message.what == 4097) {
                int i = message.arg1;
                if (!this.luW) {
                    this.luV.fQw.setText(com.tencent.mm.au.a.s(this.luV.getContext(), 0));
                    this.luV.luJ.setText(com.tencent.mm.au.a.s(this.luV.getContext(), (int) this.fQz));
                    this.luV.fQv.setImageResource(2130839561);
                    this.luV.fQv.setContentDescription(this.luV.getContext().getResources().getString(2131231108));
                    return;
                }
                return;
            }
            this.fQA = Math.max(0.0f, this.fQA - 0.256f);
            amW();
            if (this.fQA <= 0.1f) {
                this.fQA = this.fQz;
            } else {
                sendEmptyMessageDelayed(4096, 256);
            }
        }
    }

    public WNNoteFavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v.i("MicroMsg.WNNoteFavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[]{Boolean.valueOf(this.luS.cOX)});
        if (this.luS.cOX) {
            this.luS.postDelayed(new Runnable(this) {
                final /* synthetic */ WNNoteFavVoiceBaseView luV;

                {
                    this.luV = r1;
                }

                public final void run() {
                    this.luV.luS.amW();
                }
            }, 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.luL = (WNNoteFavVoiceBaseView) findViewById(2131757008);
        this.fQt = (ViewGroup) findViewById(2131757011);
        this.fQw = (TextView) findViewById(2131757010);
        this.luJ = (TextView) findViewById(2131760103);
        this.fQv = (ImageButton) findViewById(2131757009);
        this.luK = (TextView) findViewById(2131760105);
        this.cnC = new ac();
        this.luM = (SeekBar) findViewById(2131760101);
        this.luM.setProgress(0);
        this.luM.setOnSeekBarChangeListener(this.luU);
        this.luK.setClickable(true);
        this.luK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WNNoteFavVoiceBaseView luV;

            {
                this.luV = r1;
            }

            public final void onClick(View view) {
                this.luV.path = "";
                View l = this.luV.luL;
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (WNNoteFavVoiceBaseView.co(l) * -1));
                translateAnimation.setDuration(500);
                l.startAnimation(translateAnimation);
                l.setVisibility(8);
                this.luV.XV();
                this.luV.bmf();
            }
        });
        this.luS = new a();
        this.fQv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WNNoteFavVoiceBaseView luV;

            {
                this.luV = r1;
            }

            public final void onClick(View view) {
                this.luV.cT(view.getContext());
            }
        });
    }

    public final void cT(Context context) {
        if (!u.bj(context) && !com.tencent.mm.ah.a.aT(context)) {
            if (!f.sj() && !be.kS(this.path)) {
                s.ey(context);
            } else if (this.liH != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("actionCode", 1);
                    this.liH.i(55, bundle);
                } catch (Throwable e) {
                    v.a("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
                }
            }
        }
    }

    public final void aUd() {
        v.d("MicroMsg.WNNoteFavVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{this.path, Integer.valueOf(this.bdW)});
        if (this.liH != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("path", this.path);
                bundle.putInt("voicetype", this.bdW);
                bundle.putInt("position", this.fLw);
                this.liH.i(58, bundle);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
            }
        }
    }

    public final void XV() {
        v.d("MicroMsg.WNNoteFavVoiceBaseView", "stop play");
        if (this.liH != null) {
            try {
                this.liH.i(56, null);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
            }
        }
        this.fLw = 0;
        this.luM.setProgress(0);
        this.luS.stop();
    }

    public final void bmf() {
        v.d("MicroMsg.WNNoteFavVoiceBaseView", "stop play");
        if (this.liH != null) {
            try {
                this.liH.i(59, null);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
            }
        }
    }

    public static int co(View view) {
        int height = view.getHeight();
        if (height != 0) {
            return height;
        }
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }
}
