package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.as.u;
import com.tencent.mm.at.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class p extends com.tencent.mm.ui.tools.p {
    private VoiceSearchLayout iHo;
    public boolean lUX = true;
    int lUY;
    int lUZ;
    a lVa;
    private com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a lVb = new com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a(this) {
        final /* synthetic */ p lVc;

        {
            this.lVc = r1;
        }

        public final void bpe() {
            if (!u.bj(aa.getContext()) && !com.tencent.mm.ah.a.aT(aa.getContext())) {
                v.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
                g.iuh.h(10453, Integer.valueOf(this.lVc.lUY), Integer.valueOf(3));
                if (this.lVc.lVa != null) {
                    this.lVc.lVa.Yt();
                }
            }
        }

        public final void bpf() {
            v.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
            g.iuh.h(10453, Integer.valueOf(this.lVc.lUY), Integer.valueOf(4));
            if (this.lVc.oUr != null) {
                this.lVc.oUr.ke(true);
                this.lVc.oUr.kf(true);
            }
            if (this.lVc.lVa != null) {
                this.lVc.lVa.Yu();
            }
        }

        public final void a(boolean z, String[] strArr, long j) {
            v.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", Boolean.valueOf(z), Long.valueOf(j));
            if (this.lVc.lVa != null) {
                this.lVc.lVa.a(z, strArr, j, this.lVc.lUZ);
            }
        }
    };

    public interface a extends b {
        void Yt();

        void Yu();

        void a(boolean z, String[] strArr, long j, int i);
    }

    public p(byte b) {
        super(true, true);
    }

    public final void a(a aVar) {
        this.lVa = aVar;
        this.oUs = aVar;
    }

    public final void o(VoiceSearchLayout voiceSearchLayout) {
        this.iHo = voiceSearchLayout;
        this.lUZ = 1;
        if (1 == this.lUZ) {
            this.lUY = 2;
        } else {
            this.lUY = 1;
        }
    }

    public final void cancel() {
        v.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.iHo != null) {
            this.iHo.boP();
        }
        if (this.oUr != null) {
            this.oUr.ke(true);
            this.oUr.kf(true);
        }
    }

    protected final boolean bra() {
        boolean z = false;
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.lUX);
        if (this.iHo == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        v.d(str, str2, objArr);
        return this.lUX;
    }

    protected final void brb() {
        boolean z = true;
        v.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.oUr != null) {
            this.oUr.ke(false);
            this.oUr.kf(false);
        }
        if (this.iHo != null && this.iHo.getVisibility() == 8) {
            v.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
            VoiceSearchLayout voiceSearchLayout = this.iHo;
            int i = this.lUZ;
            v.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.aP(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")));
            if (com.tencent.mm.pluginsdk.i.a.aP(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
                v.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.bhY);
                voiceSearchLayout.lIR = i;
                voiceSearchLayout.bhY = true;
                voiceSearchLayout.lIQ = false;
                if (voiceSearchLayout.lIO != null) {
                    voiceSearchLayout.lIO.bpe();
                }
                voiceSearchLayout.setVisibility(0);
                voiceSearchLayout.exb.ea(50);
                voiceSearchLayout.a(true, null);
                voiceSearchLayout.lJb = 0;
                voiceSearchLayout.lIV = new e(new e.b(voiceSearchLayout) {
                    final /* synthetic */ VoiceSearchLayout lJc;

                    {
                        this.lJc = r1;
                    }

                    public final void LM() {
                        VoiceSearchLayout.k(this.lJc);
                        this.lJc.a(false, null);
                        if (this.lJc.exb != null) {
                            this.lJc.exb.QI();
                        }
                    }

                    public final void a(String[] strArr, long j) {
                        try {
                            v.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
                            if (strArr != null) {
                                v.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                                for (String str : strArr) {
                                    v.d("MicroMsg.VoiceSearchLayout", "search username  :" + str);
                                }
                            }
                            this.lJc.reset();
                            this.lJc.lIO.a(true, strArr, j);
                        } catch (Throwable e) {
                            v.a("MicroMsg.VoiceSearchLayout", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }

                    public final void aV(int i, int i2) {
                        Toast.makeText(this.lJc.getContext(), "onError errorType: " + i + " errCode: " + i2, 0).show();
                        this.lJc.reset();
                        this.lJc.lIO.a(false, null, -1);
                    }
                }, i);
                e eVar = voiceSearchLayout.lIV;
                v.i("MicroMsg.SceneVoiceAddr", "start record");
                if (!(eVar.dke == 0 && ak.is2G(aa.getContext()))) {
                    z = false;
                }
                eVar.dkp = z;
                com.tencent.mm.sdk.i.e.a(new a(eVar), "SceneVoiceAddr_record");
            } else if (voiceSearchLayout.getContext() instanceof Activity) {
                com.tencent.mm.pluginsdk.i.a.e((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO");
            }
        }
    }

    public final void a(Activity activity, Menu menu) {
        super.a(activity, menu);
        if (this.iHo != null) {
            this.iHo.lIO = this.lVb;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            boolean z = this.iHo != null && this.iHo.getVisibility() == 0;
            v.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
            cancel();
            if (z) {
                return true;
            }
        }
        v.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void brc() {
        cancel();
    }
}
