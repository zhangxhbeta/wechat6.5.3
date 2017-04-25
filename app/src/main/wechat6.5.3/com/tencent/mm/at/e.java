package com.tencent.mm.at;

import android.os.Message;
import com.tencent.mm.c.b.c;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.k;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public final class e implements com.tencent.mm.v.e {
    public static int aVI = 100;
    private static final String dkj = (t.cng + "tmp_voiceaddr.spx");
    private static final String dkk = (t.cng + "tmp_voiceaddr.amr");
    c aTF;
    private com.tencent.mm.c.b.c.a aUn = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ e dku;

        {
            this.dku = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2;
            v.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & WebView.NORMAL_MODE_ALPHA) | (bArr[(i2 * 2) + 1] << 8));
            }
            if (this.dku.dks != null) {
                this.dku.dks.a(sArr, i / 2, aVar);
            }
            e.a(this.dku, sArr, i / 2);
            if (this.dku.dkr != null) {
                i2 = this.dku.dkr.a(new com.tencent.mm.c.b.g.a(bArr, i), 0);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                this.dku.finish();
                v.e("MicroMsg.SceneVoiceAddr", "write to file failed");
                return;
            }
            e eVar = this.dku;
            eVar.dkm = i2 + eVar.dkm;
            if (this.dku.dkm > 3300 && !this.dku.dkn) {
                v.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                this.dku.handler.sendEmptyMessage(0);
                this.dku.dkn = true;
            }
            if (aVar.ptC == 2 || aVar.ptC == 3) {
                v.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + aVar.ptC);
                this.dku.finish();
            }
        }

        public final void as(int i, int i2) {
        }
    };
    public int dke = 1;
    public int dkl = 0;
    int dkm = 0;
    boolean dkn = false;
    private int dko = 500000;
    public boolean dkp = false;
    b dkq = null;
    com.tencent.mm.c.c.a dkr;
    com.tencent.qqpinyin.voicerecoapi.c dks = null;
    private a dkt = null;
    ac handler = new ac(this) {
        final /* synthetic */ e dku;

        {
            this.dku = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 2) {
                if (this.dku.dkq != null) {
                    this.dku.dkq.LM();
                }
            } else if (message.what == 0) {
                if (this.dku.dke == 0) {
                    v.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                    ak.vy().a(349, this.dku);
                } else {
                    ak.vy().a(206, this.dku);
                }
                if (this.dku.dke != 0) {
                    this.dku.dkt = new c(e.d(this.dku), this.dku.dke);
                } else if (this.dku.dkp) {
                    this.dku.dkt = new d(e.d(this.dku), 1);
                } else {
                    this.dku.dkt = new d(e.d(this.dku), 0);
                }
                ak.vy().a(this.dku.dkt, 0);
            } else if (message.what == 3 && this.dku.dkq != null) {
                this.dku.dkq.a(new String[0], -1);
            }
        }
    };

    class a implements Runnable {
        final /* synthetic */ e dku;

        public a(e eVar) {
            this.dku = eVar;
        }

        public final void run() {
            synchronized (this.dku) {
                v.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                try {
                    new File(e.d(this.dku)).delete();
                } catch (Exception e) {
                    v.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + e.d(this.dku), e);
                }
                this.dku.aTF = new c(this.dku.dkp ? 8000 : 16000, 3);
                this.dku.aTF.aUc = -19;
                this.dku.aTF.al(false);
                if (!this.dku.dkp) {
                    this.dku.dkr = new d();
                    if (!this.dku.dkr.bA(e.d(this.dku))) {
                        v.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                        this.dku.dkr.pv();
                        this.dku.dkr = null;
                    }
                }
                if (this.dku.dkp || p.ceJ.cdA <= 0) {
                    this.dku.aTF.r(5, false);
                } else {
                    this.dku.aTF.r(p.ceJ.cdA, true);
                }
                this.dku.aTF.am(false);
                this.dku.dks = new com.tencent.qqpinyin.voicerecoapi.c(this.dku.dko);
                int start = this.dku.dks.start();
                if (start != 0) {
                    v.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + start);
                    this.dku.reset();
                } else {
                    this.dku.aTF.aUn = this.dku.aUn;
                    if (!this.dku.aTF.pj()) {
                        v.e("MicroMsg.SceneVoiceAddr", "start record failed");
                        this.dku.reset();
                    }
                }
            }
        }
    }

    public interface b {
        void LM();

        void a(String[] strArr, long j);

        void aV(int i, int i2);
    }

    static /* synthetic */ void a(e eVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > eVar.dkl) {
                eVar.dkl = s;
            }
        }
    }

    static /* synthetic */ String d(e eVar) {
        return !eVar.dkp ? dkj : dkk;
    }

    public e(b bVar, int i) {
        int i2 = 500000;
        this.dkq = bVar;
        this.dke = i;
        if (this.dke != 1) {
            i2 = 1500000;
        }
        this.dko = i2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dke == 0) {
            v.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            ak.vy().b(349, (com.tencent.mm.v.e) this);
        } else {
            ak.vy().b(206, (com.tencent.mm.v.e) this);
        }
        String[] LH = ((a) kVar).LH();
        long LI = ((a) kVar).LI();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(LH == null ? -1 : LH.length);
        v.i(str2, str3, objArr);
        if (this.dkq == null) {
            return;
        }
        if (i2 == 0 && i == 0) {
            this.dkq.a(LH, LI);
            return;
        }
        this.dkq.aV(i, i2);
        cancel();
    }

    private void finish() {
        v.i("MicroMsg.SceneVoiceAddr", "finish");
        v.h("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.dkt != null) {
            this.dkt.LG();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.dkn) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
    }

    public final void cancel() {
        this.dkq = null;
        finish();
    }

    private void reset() {
        v.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            if (this.aTF != null) {
                this.aTF.pb();
                this.aTF = null;
            }
            if (this.dkr != null) {
                this.dkr.pv();
                this.dkr = null;
            }
            if (this.dks != null) {
                this.dks.stop();
            }
            this.dks = null;
            if (this.dkt != null) {
                this.dkt.LG();
                this.dkt = null;
            }
            this.dkm = 0;
            this.dkn = false;
        }
    }
}
