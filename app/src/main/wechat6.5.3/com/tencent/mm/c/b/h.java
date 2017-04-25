package com.tencent.mm.c.b;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class h implements com.tencent.mm.compatible.b.d.a, com.tencent.mm.v.h {
    a aUW = null;
    b aUX;
    private a aUY = null;
    private String aUZ;
    private boolean aVa = false;
    private boolean aVb = false;
    long aVc;
    long aVd = 0;
    public int aVe = 0;
    boolean aVf = false;
    boolean aVg = false;
    int aVh = 0;
    private com.tencent.mm.compatible.b.b.a aVi = com.tencent.mm.compatible.b.b.a.UNKNOWN;
    protected com.tencent.mm.v.h.b aVj;
    protected com.tencent.mm.v.h.a aVk = null;
    private boolean aVl = false;
    private ah aVm = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ h aVn;

        {
            this.aVn = r1;
        }

        public final boolean oU() {
            String str = this.aVn.mFileName;
            if (str != null) {
                p lJ = m.Lz().lJ(str);
                if (lJ == null) {
                    v.d("MicroMsg.VoiceLogic", "startSend null record : " + str);
                } else if (lJ.status == 1) {
                    lJ.status = 2;
                    lJ.bkU = 64;
                    q.a(lJ);
                }
            }
            m.LB().run();
            v.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + this.aVn.mFileName);
            return false;
        }
    }, true);
    String mFileName = SQLiteDatabase.KeyEmpty;

    private final class a implements Runnable {
        final /* synthetic */ h aVn;
        ac handler;

        public a(final h hVar) {
            this.aVn = hVar;
            this.handler = new ac(this) {
                final /* synthetic */ a aVp;

                public final void handleMessage(Message message) {
                    if (this.aVp.aVn.aVh > 0) {
                        v.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (this.aVp.aVn.aVj == null));
                        this.aVp.aVn.aVh = 2;
                        if (this.aVp.aVn.aVj != null) {
                            this.aVp.aVn.aVj.Bw();
                        }
                    }
                }
            };
        }

        public final void run() {
            boolean z = true;
            synchronized (this.aVn) {
                if (this.aVn.aUW == null) {
                    v.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                    return;
                }
                String str = this.aVn.mFileName;
                if (this.aVn.aVg) {
                    z = false;
                }
                v.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", q.G(str, z), Boolean.valueOf(this.aVn.aVg));
                if (this.aVn.aUW.bx(q.G(str, z))) {
                    this.aVn.aUX.requestFocus();
                } else {
                    q.lG(this.aVn.mFileName);
                    this.aVn.mFileName = null;
                    this.aVn.aUW = null;
                    v.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + this.aVn.mFileName + "]");
                }
                this.aVn.aVd = be.Nj();
                v.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + this.aVn.mFileName + "] time:" + be.az(this.aVn.aVc));
                this.handler.sendEmptyMessageDelayed(0, 1);
            }
        }
    }

    public h(Context context, boolean z) {
        this.aUX = new b(context);
        this.aVg = z;
        v.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
    }

    public final void reset() {
        if (this.aUW != null) {
            this.aUW.pb();
            this.aUX.si();
            v.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = SQLiteDatabase.KeyEmpty;
        this.aVc = 0;
        this.aUY = null;
        this.aVi = com.tencent.mm.compatible.b.b.a.UNKNOWN;
        this.aVh = 0;
        this.aVd = 0;
    }

    public final int pp() {
        return this.aVe;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean pq() {
        if (this.aUW != null && this.aUW.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public final int getMaxAmplitude() {
        if (this.aUW == null) {
            return 0;
        }
        return this.aUW.getMaxAmplitude();
    }

    public final boolean by(String str) {
        v.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + str);
        reset();
        this.aUZ = str;
        this.aVc = be.Nj();
        if (str == null) {
            v.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            return false;
        }
        this.aVa = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((k.xJ() & 16384) == 0) {
                this.aVb = true;
            } else {
                this.aVb = false;
            }
        }
        if (!this.aVg) {
            if (this.aVa) {
                this.mFileName = u.lI(k.xF());
            } else if (this.aVb) {
                this.mFileName = u.lI("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                v.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                return false;
            }
            ak.yX().a((com.tencent.mm.compatible.b.d.a) this);
            this.aVf = false;
            this.aVl = false;
            if (!d.qX() || ak.yX().qU()) {
                ps();
            } else {
                this.aVl = true;
                ak.yX().qS();
                ad.g(new Runnable(this) {
                    final /* synthetic */ h aVn;

                    {
                        this.aVn = r1;
                    }

                    public final void run() {
                        if (!this.aVn.aVf) {
                            v.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
                            this.aVn.ps();
                        }
                    }
                }, 1000);
            }
            return true;
        }
        this.mFileName = q.lE(str);
        if (this.mFileName != null) {
        }
        v.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        return false;
    }

    public final boolean cancel() {
        v.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            v.d("MicroMsg.SceneVoice.Recorder", "stop synchronized Record :" + this.mFileName);
            if (this.aUW != null) {
                this.aUW.pb();
                this.aUX.si();
            }
        }
        ak.yX().b((com.tencent.mm.compatible.b.d.a) this);
        if (this.aVl) {
            ak.yX().qT();
            this.aVl = false;
        }
        String str = this.mFileName;
        if (str != null) {
            v.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
            p lJ = m.Lz().lJ(str);
            if (lJ != null) {
                lJ.status = 8;
                lJ.cyu = o.le(str);
                lJ.bkU = 64;
                q.a(lJ);
            }
        }
        m.LB().run();
        if (!(this.aUW == null || be.kS(this.mFileName) || this.aVg)) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.cfS = this.mFileName;
            aVar.cfT = pr();
            aVar.cfU = 1;
            aVar.aZk = this.aUW.pc();
            g.iuh.Y(10513, aVar.sg());
        }
        this.mFileName = SQLiteDatabase.KeyEmpty;
        return true;
    }

    public boolean ph() {
        boolean z = true;
        boolean z2 = false;
        if (this.aVm != null) {
            this.aVm.QI();
            this.aVm.removeCallbacksAndMessages(null);
        }
        ak.yX().b((com.tencent.mm.compatible.b.d.a) this);
        if (this.aVl) {
            ak.yX().qT();
            this.aVl = false;
        }
        this.aVe = (int) pr();
        v.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.aVe));
        if (!(this.aUW == null || be.kS(this.mFileName) || this.aVg)) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.cfS = this.mFileName;
            aVar.cfT = (long) this.aVe;
            aVar.cfU = 2;
            aVar.aZk = this.aUW.pc();
            g.iuh.Y(10513, aVar.sg());
        }
        synchronized (this) {
            v.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s", this.mFileName, this.aUW);
            if (this.aUW != null) {
                this.aUW.pb();
                this.aUX.si();
            }
        }
        if (this.aVh != 2) {
            q.lG(this.mFileName);
            this.mFileName = null;
            v.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + be.az(this.aVc));
        } else {
            if (((long) this.aVe) < 800 || (this.aVa && ((long) this.aVe) < 1000)) {
                v.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.aVe);
                q.lG(this.mFileName);
                this.mFileName = SQLiteDatabase.KeyEmpty;
                z = false;
            } else {
                q.g(this.mFileName, this.aVe, 0);
                m.LB().run();
                v.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = SQLiteDatabase.KeyEmpty;
            z2 = z;
        }
        this.aVh = -1;
        return z2;
    }

    public final long pr() {
        if (this.aVd == 0) {
            return 0;
        }
        return be.az(this.aVd);
    }

    public final void cK(int i) {
        v.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + i);
        if (i == 1) {
            ps();
        }
    }

    final void ps() {
        if (!this.aVf) {
            this.aVf = true;
            if (this.aVg) {
                this.aVi = com.tencent.mm.compatible.b.b.a.SPEEX;
                this.aUW = new com.tencent.mm.modelvoice.k();
            } else {
                this.aVi = com.tencent.mm.compatible.b.b.qP();
                String value = j.sU().getValue("VoiceFormat");
                String value2 = j.sU().getValue("VoiceFormatToQQ");
                if (this.aVi == com.tencent.mm.compatible.b.b.a.PCM) {
                    if (4 == be.getInt(value, 4) && g.b.po()) {
                        this.aVi = com.tencent.mm.compatible.b.b.a.SILK;
                    }
                    if (this.aUZ != null && this.aUZ.endsWith("@qqim")) {
                        this.aVi = com.tencent.mm.compatible.b.b.a.AMR;
                    }
                }
                if (this.aVi == com.tencent.mm.compatible.b.b.a.PCM) {
                    v.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
                    this.aVi = com.tencent.mm.compatible.b.b.a.AMR;
                }
                v.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, this.aVi, Boolean.valueOf(g.b.po()));
                this.aUW = new t(this.aVi);
            }
            com.tencent.mm.v.h.a anonymousClass3 = new com.tencent.mm.v.h.a(this) {
                final /* synthetic */ h aVn;

                {
                    this.aVn = r1;
                }

                public final void onError() {
                    this.aVn.aUX.si();
                    v.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + this.aVn.mFileName);
                    q.lG(this.aVn.mFileName);
                    if (this.aVn.aVk != null) {
                        this.aVn.aVk.onError();
                    }
                }
            };
            if (this.aUW != null) {
                this.aUW.a(anonymousClass3);
            }
            this.aUY = new a(this);
            e.a(this.aUY, "SceneVoiceRecorder_record");
            this.aVh = 1;
            this.aVm.ea(3000);
            v.d("MicroMsg.SceneVoice.Recorder", "start end time:" + be.az(this.aVc));
        }
    }

    public final void a(com.tencent.mm.v.h.a aVar) {
        this.aVk = aVar;
    }

    public final void a(com.tencent.mm.v.h.b bVar) {
        this.aVj = bVar;
    }

    public final int pt() {
        if (this.aVg) {
            return 1;
        }
        if (this.aVi == com.tencent.mm.compatible.b.b.a.PCM || this.aVi == com.tencent.mm.compatible.b.b.a.AMR) {
            return 0;
        }
        if (this.aVi == com.tencent.mm.compatible.b.b.a.SILK) {
            return 2;
        }
        return -1;
    }
}
