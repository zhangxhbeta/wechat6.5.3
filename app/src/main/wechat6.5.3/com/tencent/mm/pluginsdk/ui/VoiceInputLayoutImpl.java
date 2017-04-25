package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnTouchListener hsc = new OnTouchListener(this) {
        final /* synthetic */ VoiceInputLayoutImpl lID;

        {
            this.lID = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.lID.lIA = false;
                    this.lID.lIB = System.currentTimeMillis();
                    v.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[]{Integer.valueOf(this.lID.lIh), Long.valueOf(this.lID.lIB)});
                    k a = this.lID.lIz;
                    v.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[]{Integer.valueOf(a.lIh)});
                    a.lIh = 6;
                    a.hvM.cancel();
                    a.lHF = 0.0f;
                    a.invalidateSelf();
                    this.lID.B(false, false);
                    break;
                case 1:
                    v.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[]{Integer.valueOf(this.lID.lIh), Boolean.valueOf(this.lID.lIA)});
                    if (!this.lID.lIA) {
                        this.lID.B(false, true);
                        break;
                    }
                    this.lID.B(true, false);
                    this.lID.lIA = false;
                    this.lID.lIB = 0;
                    break;
            }
            return false;
        }
    };
    private boolean lIA = false;
    private long lIB;
    private OnLongClickListener lIC = new OnLongClickListener(this) {
        final /* synthetic */ VoiceInputLayoutImpl lID;

        {
            this.lID = r1;
        }

        public final boolean onLongClick(View view) {
            v.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[]{Integer.valueOf(this.lID.lIh)});
            this.lID.lIA = true;
            k a = this.lID.lIz;
            v.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[]{Integer.valueOf(a.lIh)});
            a.lIh = 7;
            a.hvM.cancel();
            a.lHF = 0.0f;
            a.invalidateSelf();
            return true;
        }
    };
    private View lIy;
    private k lIz;

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.lIy = inflate(context, 2130904581, this).findViewById(2131759642);
        this.lIy.setLayerType(1, null);
        this.lIz = new k(context);
        this.lIy.setBackground(this.lIz);
        this.lIy.setEnabled(true);
        this.lIy.setOnTouchListener(this.hsc);
        this.lIy.setOnLongClickListener(this.lIC);
        hW(true);
        if (!isInEditMode() && !boY()) {
            boX();
        }
    }

    public final void B(boolean z, boolean z2) {
        v.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[]{Integer.valueOf(this.lIh), Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (this.lIh == 1) {
            if (z || z2) {
                if (z && !z2) {
                    Q(4, this.lIA);
                    Q(this.lIh, this.lIA);
                    this.lIz.bRM();
                }
            } else if (boY()) {
                boO();
            } else {
                boX();
            }
        } else if (this.lIh == 2) {
            if (z2) {
                this.lIz.hT(this.lIA);
                Q(4, this.lIA);
                return;
            }
            if (z) {
                Q(4, this.lIA);
            }
            Q(this.lIh, this.lIA);
            bf();
        } else if (!z && !z2) {
            Q(this.lIh, this.lIA);
            boP();
        } else if (z && !z2) {
            Q(4, this.lIA);
            Q(this.lIh, this.lIA);
            this.lIz.bRM();
        }
    }

    private void boX() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl lID;

            {
                this.lID = r1;
            }

            public final void run() {
                k a = this.lID.lIz;
                v.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[]{Integer.valueOf(a.lIh)});
                a.lIh = 5;
                a.hvM.cancel();
                a.lHF = 0.0f;
                a.invalidateSelf();
            }
        });
        boR();
    }

    private static boolean boY() {
        int BJ = ak.vy().BJ();
        return BJ == 4 || BJ == 6;
    }

    protected final void hU(boolean z) {
        runOnUiThread(new Runnable(this, true) {
            final /* synthetic */ VoiceInputLayoutImpl lID;

            public final void run() {
                this.lID.lIz.hT(true);
            }
        });
    }

    protected final void hV(boolean z) {
        if (!z) {
            Q(17, false);
        }
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl lID;

            {
                this.lID = r1;
            }

            public final void run() {
                k a = this.lID.lIz;
                v.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[]{Integer.valueOf(a.lIh)});
                a.lIh = 4;
                a.hvM.cancel();
                a.lHF = 0.0f;
                a.hvM.setInterpolator(new AccelerateDecelerateInterpolator());
                a.hvM.setDuration(1000);
                a.hvM.setRepeatCount(-1);
                a.hvM.start();
            }
        });
    }

    protected final void onReset() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl lID;

            {
                this.lID = r1;
            }

            public final void run() {
                this.lID.lIz.bRM();
            }
        });
    }

    protected final void tP(final int i) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl lID;

            public final void run() {
                boolean z = true;
                k a = this.lID.lIz;
                v.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[]{Integer.valueOf(i)});
                if (i >= 28) {
                    z = false;
                }
                a.lIe = z;
                a.invalidateSelf();
            }
        });
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ad.o(runnable);
        } else {
            runnable.run();
        }
    }

    private void Q(int i, boolean z) {
        log_13905 com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (z) {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.lIA || this.lIB == 0)) {
                voiceInputBehavior.longClickTime = System.currentTimeMillis() - this.lIB;
            }
        } else {
            voiceInputBehavior.click = i;
        }
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.iuh.a(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
        v.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail)});
    }
}
