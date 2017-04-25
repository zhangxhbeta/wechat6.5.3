package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class VoiceCreateUI extends BaseVoicePrintUI implements a {
    private int koL = 1;
    private l kpB;
    private o kpC = null;
    private View kpD;
    private NoiseDetectMaskView kpE;
    private View kpF = null;
    private Button kpG = null;
    private int kpH = 0;
    private c kpI = new c<qd>(this) {
        final /* synthetic */ VoiceCreateUI kpJ;

        {
            this.kpJ = r2;
            this.nhz = qd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            v.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", new Object[]{Boolean.valueOf(((qd) bVar).brr.brs)});
            if (((qd) bVar).brr.brs) {
                VoiceCreateUI.a(this.kpJ);
            } else {
                VoiceCreateUI.b(this.kpJ);
            }
            return false;
        }
    };

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        g.iuh.h(11390, new Object[]{Integer.valueOf(4)});
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.kpE;
        if (noiseDetectMaskView.fpm != null) {
            noiseDetectMaskView.fpm.setVisibility(8);
        }
        noiseDetectMaskView.kpt.setText(2131235824);
        noiseDetectMaskView.kpu.setVisibility(0);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.kpF.setVisibility(0);
        voiceCreateUI.kpD.setVisibility(0);
        voiceCreateUI.kpf.setVisibility(0);
        View view = voiceCreateUI.kpE;
        a.a anonymousClass6 = new a.a(voiceCreateUI) {
            final /* synthetic */ VoiceCreateUI kpJ;

            {
                this.kpJ = r1;
            }

            public final void bba() {
            }

            public final void bbb() {
                this.kpJ.kpE.setVisibility(8);
                VoiceCreateUI.h(this.kpJ);
            }
        };
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass6(anonymousClass6));
        view.startAnimation(translateAnimation);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.kph.bbi();
        voiceCreateUI.koL = 1;
        voiceCreateUI.kpB.koL = 71;
        ak.vy().a(new d(71, ""), 0);
    }

    protected final void baZ() {
        v.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", new Object[]{this.kpj});
        if (!be.kS(this.kpj)) {
            this.kpe.setEnabled(false);
            this.kph.bbi();
            l lVar;
            f fVar;
            if (this.koL == 1) {
                lVar = this.kpB;
                fVar = new f(this.kpj, 71, lVar.koN, 0);
                fVar.kot = true;
                ak.vy().a(fVar, 0);
                lVar.koL = 71;
            } else if (this.koL == 2) {
                lVar = this.kpB;
                fVar = new f(this.kpj, 72, lVar.koN, lVar.kow);
                fVar.kot = true;
                ak.vy().a(fVar, 0);
                lVar.koL = 72;
            }
        }
    }

    protected final void axf() {
        this.kpB = new l(this);
        findViewById(2131756773).setVisibility(8);
        this.kph.ry(2131235825);
        this.kph.bbl();
        this.kpe.setEnabled(false);
        this.kpC = new o();
        this.kpD = findViewById(2131759662);
        this.kpE = (NoiseDetectMaskView) findViewById(2131759032);
        this.kpF = findViewById(2131759676);
        this.kpG = (Button) findViewById(2131756773);
        this.kpG.setVisibility(8);
        this.kpG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceCreateUI kpJ;

            {
                this.kpJ = r1;
            }

            public final void onClick(View view) {
                this.kpJ.baX();
                a.a(this.kpJ.kph, new a.a(this) {
                    final /* synthetic */ AnonymousClass2 kpK;

                    {
                        this.kpK = r1;
                    }

                    public final void bba() {
                        this.kpK.kpJ.kpG.setVisibility(8);
                        this.kpK.kpJ.kph.ry(2131235825);
                        this.kpK.kpJ.kph.kpT.setVisibility(0);
                        this.kpK.kpJ.kpe.setEnabled(true);
                        this.kpK.kpJ.kpe.setVisibility(0);
                    }

                    public final void bbb() {
                    }
                });
            }
        });
        this.kpE.kpv = new NoiseDetectMaskView.b(this) {
            final /* synthetic */ VoiceCreateUI kpJ;

            {
                this.kpJ = r1;
            }

            public final void bbd() {
                g.iuh.h(11390, new Object[]{Integer.valueOf(5)});
                this.kpJ.start();
            }
        };
        this.kpE.kpw = new NoiseDetectMaskView.a(this) {
            final /* synthetic */ VoiceCreateUI kpJ;

            {
                this.kpJ = r1;
            }

            public final void bbc() {
                this.kpJ.bbf();
                o f = this.kpJ.kpC;
                v.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
                f.koR.pb();
                f.koS.QI();
                this.kpJ.finish();
            }
        };
        com.tencent.mm.sdk.c.a.nhr.e(this.kpI);
        this.kpF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceCreateUI kpJ;

            {
                this.kpJ = r1;
            }

            public final void onClick(View view) {
                this.kpJ.bbf();
                this.kpJ.finish();
            }
        });
        start();
    }

    private void start() {
        v.d("MicroMsg.VoiceCreateUI", "start create");
        this.kpC.reset();
        NoiseDetectMaskView noiseDetectMaskView = this.kpE;
        if (noiseDetectMaskView.fpm != null) {
            noiseDetectMaskView.fpm.setVisibility(0);
        }
        noiseDetectMaskView.kpt.setText(2131235821);
        noiseDetectMaskView.kpu.setVisibility(8);
        v.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.kpF.setVisibility(4);
        this.kpD.setVisibility(4);
        this.kpf.setVisibility(4);
        this.kpE.setVisibility(0);
        o oVar = this.kpC;
        v.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        oVar.reset();
        if (oVar.koR.bx(m.as("voice_pt_voice_print_noise_detect.rec", true))) {
            v.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            oVar.koR.pb();
            oVar.reset();
            v.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        oVar.koS.ea(100);
    }

    public final void CJ(String str) {
        v.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        baW();
        this.koM = str;
        this.kph.bbj();
        this.kph.bbk();
        this.kph.CM(str);
        this.kpe.setEnabled(true);
    }

    public final void CK(String str) {
        v.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.koM = str;
        this.kph.bbj();
        this.kph.bbk();
        this.kph.CM(str);
        this.kpe.setEnabled(true);
    }

    public final void o(boolean z, int i) {
        v.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (z) {
            switch (i) {
                case 71:
                    v.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.kpe.setEnabled(false);
                    this.koL = 2;
                    baX();
                    a.a(this.kph, new a.a(this) {
                        final /* synthetic */ VoiceCreateUI kpJ;

                        {
                            this.kpJ = r1;
                        }

                        public final void bba() {
                            this.kpJ.kph.reset();
                            this.kpJ.kph.bbk();
                            this.kpJ.kph.bbl();
                            this.kpJ.kpe.setVisibility(4);
                            this.kpJ.kph.ry(2131235823);
                            this.kpJ.kpG.setVisibility(0);
                            this.kpJ.kph.bbj();
                        }

                        public final void bbb() {
                        }
                    });
                    return;
                case j.CTRL_INDEX /*72*/:
                    this.kpH = 0;
                    v.d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    intent = new Intent();
                    intent.setClass(this, VoicePrintFinishUI.class);
                    intent.putExtra("kscene_type", 72);
                    startActivity(intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 71:
                return;
            case j.CTRL_INDEX /*72*/:
                bbf();
                this.kpH++;
                if (this.kpH >= 2) {
                    v.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                    this.kpH = 0;
                    startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                    overridePendingTransition(2130968680, 2130968677);
                    finish();
                    return;
                }
                this.kpe.setEnabled(true);
                this.kph.bbj();
                this.kph.rz(2131235827);
                this.kph.bbm();
                return;
            default:
                return;
        }
    }

    public final void baS() {
        baY();
        bbf();
    }

    private void bbf() {
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        l lVar = this.kpB;
        ak.vy().b(611, lVar);
        ak.vy().b(612, lVar);
        lVar.koO = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.kpI);
    }

    public void onBackPressed() {
        super.onBackPressed();
        bbf();
    }
}
