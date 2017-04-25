package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    private boolean gVN = false;
    private final ah gVW = new ah(new a(this) {
        final /* synthetic */ BaseVoicePrintUI kpq;

        {
            this.kpq = r1;
        }

        public final boolean oU() {
            if (this.kpq.kpi != null) {
                int maxAmplitude;
                p a = this.kpq.kpi;
                if (a.aSV != null) {
                    maxAmplitude = a.aSV.getMaxAmplitude();
                    if (maxAmplitude > p.aVI) {
                        p.aVI = maxAmplitude;
                    }
                    v.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.aVI + " per:" + ((maxAmplitude * 100) / p.aVI));
                    maxAmplitude = (maxAmplitude * 100) / p.aVI;
                } else {
                    maxAmplitude = 0;
                }
                BaseVoicePrintUI.a(this.kpq, (float) maxAmplitude);
            }
            return true;
        }
    }, true);
    String koM = null;
    Button kpe;
    View kpf;
    VoicePrintVolumeMeter kpg;
    VoiceTipInfoView kph;
    p kpi = null;
    String kpj = null;
    private boolean kpk = false;
    private View kpl;
    private boolean kpm = false;
    private final p.a kpn = new p.a(this) {
        final /* synthetic */ BaseVoicePrintUI kpq;

        {
            this.kpq = r1;
        }

        public final void baV() {
            p a = this.kpq.kpi;
            if (a.aSV != null) {
                a.aSV.pb();
                v.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
            }
            a.aST = "";
            a.koW = null;
            a.kfN = 0;
            a.fTb = 0;
            if (a.djL != null) {
                a.djL.si();
            }
            v.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
            this.kpq.kpj = null;
            ad.o(new Runnable(this.kpq) {
                final /* synthetic */ BaseVoicePrintUI kpq;

                {
                    this.kpq = r1;
                }

                public final void run() {
                    this.kpq.kph.rz(2131235826);
                    this.kpq.kph.bbm();
                    this.kpq.kpe.setPressed(false);
                    this.kpq.kpe.setEnabled(false);
                    this.kpq.kpg.stop();
                }
            });
        }
    };
    ah kpo = new ah(new a(this) {
        final /* synthetic */ BaseVoicePrintUI kpq;

        {
            this.kpq = r1;
        }

        public final boolean oU() {
            VoiceTipInfoView c = this.kpq.kph;
            if (c.kpT.getAnimation() == null) {
                View view = c.kpT;
                Context context = c.getContext();
                a.a anonymousClass1 = new a.a(c) {
                    final /* synthetic */ VoiceTipInfoView kqy;

                    {
                        this.kqy = r1;
                    }

                    public final void bba() {
                    }

                    public final void bbb() {
                    }
                };
                float width = (float) view.getWidth();
                v.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i = (int) (width + ((float) iArr[0]));
                v.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i)});
                Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968688);
                loadAnimation.setDuration(200);
                loadAnimation.setStartOffset(0);
                loadAnimation.setRepeatCount(0);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass1(anonymousClass1));
                view.startAnimation(loadAnimation);
            }
            return false;
        }
    }, true);
    private ac kpp = new ac(Looper.getMainLooper(), new ac.a(this) {
        final /* synthetic */ BaseVoicePrintUI kpq;

        {
            this.kpq = r1;
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            v.d("MicroMsg.BaseVoicePrintUI", "start record");
            ao.a(aa.getContext(), 2131235641, new ao.a(this) {
                final /* synthetic */ AnonymousClass5 kpr;

                {
                    this.kpr = r1;
                }

                public final void pa() {
                    v.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
                }
            });
            this.kpq.kpj = "voice_pt_voice_print_record.rec";
            p a = this.kpq.kpi;
            String d = this.kpq.kpj;
            BaseVoicePrintUI baseVoicePrintUI = this.kpq;
            a.aST = d;
            v.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[]{a.aST});
            ak.yX().a(a);
            int qS = ak.yX().qS();
            a.kfK = false;
            a.djL = new b(baseVoicePrintUI);
            if (qS != 0) {
                a.cK(100);
            } else {
                new ac(a) {
                    final /* synthetic */ p kpa;

                    {
                        this.kpa = r1;
                    }

                    public final void handleMessage(Message message) {
                        v.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
                        if (!this.kpa.kfK) {
                            ak.yX().b(this.kpa);
                            ak.yX().qT();
                            this.kpa.cK(200);
                        }
                    }
                }.sendEmptyMessageDelayed(0, 50);
            }
            this.kpq.gVW.ea(100);
            BaseVoicePrintUI baseVoicePrintUI2 = this.kpq;
            baseVoicePrintUI2.kph.bbn();
            VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI2.kph;
            v.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(voiceTipInfoView.eXB.getVisibility()), Boolean.valueOf(voiceTipInfoView.kqt)});
            if (voiceTipInfoView.eXB.getVisibility() != 0 || voiceTipInfoView.kqt) {
                v.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
                voiceTipInfoView.eXB.clearAnimation();
                voiceTipInfoView.eXB.setVisibility(4);
                voiceTipInfoView.eXB.invalidate();
            } else {
                voiceTipInfoView.eXB.clearAnimation();
                voiceTipInfoView.kqt = true;
                a.a(voiceTipInfoView.eXB, voiceTipInfoView.getContext(), new a.a(voiceTipInfoView) {
                    final /* synthetic */ VoiceTipInfoView kqy;

                    {
                        this.kqy = r1;
                    }

                    public final void bba() {
                    }

                    public final void bbb() {
                        this.kqy.eXB.setVisibility(4);
                        this.kqy.kqt = false;
                    }
                });
            }
            baseVoicePrintUI2.kph.CM(baseVoicePrintUI2.koM);
            baseVoicePrintUI2.kpo.QI();
            baseVoicePrintUI2.kpo.ea(500);
            baseVoicePrintUI2.kpf.setVisibility(0);
            VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI2.kpg;
            voicePrintVolumeMeter.reset();
            voicePrintVolumeMeter.gCX = true;
            voicePrintVolumeMeter.kqb.ea((long) VoicePrintVolumeMeter.gWP);
            voicePrintVolumeMeter.bbg();
            return true;
        }
    });

    protected abstract void axf();

    protected abstract void baZ();

    static /* synthetic */ void a(BaseVoicePrintUI baseVoicePrintUI, float f) {
        float f2 = 10.0f;
        if (f >= 10.0f) {
            f2 = f;
        }
        if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.kpg;
        f2 /= 100.0f;
        if (f2 > voicePrintVolumeMeter.kqp) {
            voicePrintVolumeMeter.kqq = true;
        } else {
            voicePrintVolumeMeter.kqq = false;
        }
        voicePrintVolumeMeter.kqp = f2;
    }

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.kpl.setVisibility(0);
        if (baseVoicePrintUI.kpm) {
            baseVoicePrintUI.kpl.setVisibility(0);
            return;
        }
        baseVoicePrintUI.kpm = true;
        View view = baseVoicePrintUI.kpl;
        View view2 = baseVoicePrintUI.kpe;
        a.a anonymousClass8 = new a.a(baseVoicePrintUI) {
            final /* synthetic */ BaseVoicePrintUI kpq;

            {
                this.kpq = r1;
            }

            public final void bba() {
            }

            public final void bbb() {
                this.kpq.kpl.setVisibility(0);
                this.kpq.kpm = false;
            }
        };
        view.clearAnimation();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        v.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", new Object[]{Arrays.toString(iArr)});
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        v.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", new Object[]{Integer.valueOf(iArr[1] - iArr2[1])});
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass7(anonymousClass8));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        this.kph = (VoiceTipInfoView) findViewById(2131759661);
        this.kpe = (Button) findViewById(2131759663);
        this.kpf = findViewById(2131757414);
        this.kpg = (VoicePrintVolumeMeter) findViewById(2131757415);
        this.kpl = findViewById(2131759664);
        this.kph.bbn();
        this.kpg.gWD = this.kpe;
        this.kpi = new p();
        this.kpi.koZ = this.kpn;
        this.kpe.setOnTouchListener(new OnTouchListener(this) {
            private long gWv = 0;
            final /* synthetic */ BaseVoicePrintUI kpq;
            private boolean kps = false;

            {
                this.kpq = r3;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.kpq.gVN = false;
                        if (!be.kS(this.kpq.koM)) {
                            this.gWv = System.currentTimeMillis();
                            this.kpq.kpe.setPressed(true);
                            this.kpq.kpk = true;
                            this.kpq.baX();
                            this.kpq.kpp.sendEmptyMessageDelayed(1, 300);
                            v.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        this.kpq.kpe.setPressed(false);
                        this.kpq.kpp.removeMessages(1);
                        if (System.currentTimeMillis() - this.gWv < 300) {
                            v.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                            this.kpq.gVN = false;
                        } else {
                            this.kpq.gVN = true;
                        }
                        v.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[]{Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.kpq.gVN)});
                        this.kpq.kpg.stop();
                        this.kpq.gVW.QI();
                        this.kpq.kpi.ph();
                        if (!this.kpq.gVN) {
                            this.kpq.kph.rz(2131235817);
                            this.kpq.kph.bbm();
                            break;
                        }
                        BaseVoicePrintUI baseVoicePrintUI = this.kpq;
                        v.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                        if (!baseVoicePrintUI.kpi.koY) {
                            baseVoicePrintUI.kpo.QI();
                            baseVoicePrintUI.kph.rz(2131235817);
                            baseVoicePrintUI.kph.bbm();
                            baseVoicePrintUI.kpj = null;
                        }
                        baseVoicePrintUI.kpf.setVisibility(8);
                        baseVoicePrintUI.kph.bbk();
                        baseVoicePrintUI.kph.CM(baseVoicePrintUI.koM);
                        v.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[]{this.kpq.kpj});
                        if (!be.kS(this.kpq.kpj)) {
                            this.kpq.baZ();
                        }
                        this.gWv = 0;
                        this.kps = false;
                        this.kpq.gVN = false;
                        break;
                }
                return false;
            }
        });
        findViewById(2131759676).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseVoicePrintUI kpq;

            {
                this.kpq = r1;
            }

            public final void onClick(View view) {
                this.kpq.finish();
            }
        });
        axf();
    }

    protected final void baW() {
        ad.g(new Runnable(this) {
            final /* synthetic */ BaseVoicePrintUI kpq;

            {
                this.kpq = r1;
            }

            public final void run() {
                if (!this.kpq.kpk) {
                    BaseVoicePrintUI.i(this.kpq);
                }
            }
        }, 1300);
    }

    protected final void baX() {
        if (this.kpl.getVisibility() != 4 && this.kpl.getVisibility() != 8) {
            if (this.kpm) {
                this.kpl.setVisibility(4);
                return;
            }
            this.kpm = true;
            a.a(this.kpl, this, new a.a(this) {
                final /* synthetic */ BaseVoicePrintUI kpq;

                {
                    this.kpq = r1;
                }

                public final void bba() {
                }

                public final void bbb() {
                    this.kpq.kpl.setVisibility(4);
                    this.kpq.kpm = false;
                }
            });
        }
    }

    protected final int getLayoutId() {
        return 2130904585;
    }

    protected void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.kpg;
        voicePrintVolumeMeter.kqb.QI();
        voicePrintVolumeMeter.kqa.htb.getLooper().quit();
        v.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        v.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(m.as("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(m.as("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    protected final void baY() {
        rx(2131235820);
    }

    protected final void rx(int i) {
        this.kph.bbj();
        this.kph.rz(i);
        this.kph.bbm();
    }
}
