package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.c.b.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;

public final class g {
    public static int ksK = 0;
    public static int ksL = 0;
    public static int ksx = 3;
    private com.tencent.mm.c.b.c.a gGI = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ g ksN;

        {
            this.ksN = r1;
        }

        public final void d(byte[] bArr, int i) {
            synchronized (this.ksN.ksI) {
                if (this.ksN.ksy == 2 && this.ksN.ksw != null) {
                    if (this.ksN.ksC == 1) {
                        this.ksN.ksA = System.currentTimeMillis();
                        this.ksN.ksB = this.ksN.ksA;
                        this.ksN.ksC = 0;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.ksN.ksD = (int) ((currentTimeMillis - this.ksN.ksB) - ((long) (g.ksL * 20)));
                        this.ksN.ksA = currentTimeMillis;
                    }
                    if (this.ksN.ksz <= 10) {
                        this.ksN.ksz = 92;
                    }
                    this.ksN.ksz = ((this.ksN.ksw.bbr() + 24) + (this.ksN.ksz * 3)) / 4;
                    if (this.ksN.ksE == 1) {
                        this.ksN.ksG = this.ksN.ksw.bbo();
                        if (this.ksN.ksG >= this.ksN.ksz) {
                            g.d(this.ksN, this.ksN.ksz);
                        }
                        this.ksN.ksz = this.ksN.ksG;
                        this.ksN.ksE = 0;
                    } else {
                        this.ksN.ksz = 0;
                    }
                    this.ksN.kqI.ksc.recordCallback(bArr, i, this.ksN.ksz);
                    g.ksL++;
                }
            }
        }

        public final void as(int i, int i2) {
        }
    };
    c hza = null;
    public e kqI = null;
    private long ksA = 0;
    private long ksB = 0;
    private int ksC = 1;
    private int ksD = 0;
    private int ksE = 1;
    private long ksF = 0;
    private int ksG = 0;
    private int ksH = 0;
    final Object ksI = new Object();
    public int ksJ = 0;
    b ksM;
    b ksw = null;
    public int ksy = 1;
    int ksz = 92;

    class a implements Runnable {
        private c gGK = null;
        private b gGr = null;
        final /* synthetic */ g ksN;

        public a(g gVar, b bVar, c cVar) {
            this.ksN = gVar;
            this.gGr = bVar;
            this.gGK = cVar;
        }

        public final void run() {
            if (this.gGr != null) {
                this.gGr.bbs();
                this.gGr.bbp();
                this.gGr = null;
            }
            v.d("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
            if (this.gGK != null) {
                this.gGK.pb();
                this.gGK = null;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ g ksN;
        boolean ksO = false;

        b(g gVar) {
            this.ksN = gVar;
        }

        public final void run() {
            while (this.ksN.ksy == 2 && !this.ksO) {
                if (this.ksN.kqI.bbJ() && this.ksN.kqI.ksc.videoDecode(this.ksN.kqI.ksc.kwx) == 1) {
                    int i = this.ksN.kqI.ksc.field_remoteImgWidth;
                    int i2 = this.ksN.kqI.ksc.field_remoteImgHeight;
                    int i3 = this.ksN.kqI.ksc.field_remoteImgLength;
                    if (i3 > 0 && this.ksN.kqI.ksd != null) {
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.ksN.kqI.ksc;
                        com_tencent_mm_plugin_voip_model_v2protocal.kwR++;
                        this.ksN.kqI.ksd.a(i, i2, i3 / 4, this.ksN.kqI.ksc.kwx);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    v.a("MicroMsg.Voip.VoipDeviceHandler", e, "", new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ int d(g gVar, int i) {
        int i2 = gVar.ksG - i;
        gVar.ksG = i2;
        return i2;
    }

    static /* synthetic */ void k(g gVar) {
        gVar.hza = new c(v2protocal.hyT, 1);
        gVar.hza.cL(20);
        gVar.hza.am(true);
        gVar.hza.pi();
        gVar.hza.aUc = -19;
        gVar.hza.r(1, false);
        gVar.hza.al(true);
        gVar.hza.aUn = gVar.gGI;
        if (!(gVar.hza.pj() || gVar.hza.aTS == 13)) {
            gVar.ksJ = 1;
        }
        com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + gVar.ksJ);
        gVar.kqI.rA(gVar.ksJ);
        gVar.kqI.ksc.kxf.ksZ = (byte) 1;
    }

    public g(e eVar) {
        this.kqI = eVar;
    }

    public final int bbO() {
        if (this.hza == null || this.kqI.ksc.kxf.ksZ != (byte) 1) {
            return 0;
        }
        return this.hza.aTS;
    }

    public final int bbt() {
        if (this.ksw == null || this.kqI.ksc.kxf.ksZ != (byte) 1) {
            return 0;
        }
        return this.ksw.bbt();
    }

    public final void bbP() {
        if (this.ksy == ksx) {
            com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
            return;
        }
        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.ksy = ksx;
        if (this.ksM != null) {
            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
            this.ksM.ksO = true;
            e.remove(this.ksM);
            this.ksM = null;
        }
        this.ksE = 1;
        this.ksG = 0;
        this.ksz = 92;
        this.ksA = 0;
        this.ksB = 0;
        this.ksC = 1;
        this.ksD = 0;
        this.ksJ = 0;
        this.kqI.ksc.kvU = bbO();
        this.kqI.ksc.kvV = bbt();
        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.kqI.ksc;
        int pl = (this.hza == null || this.kqI.ksc.kxf.ksZ != (byte) 1) ? -2 : this.hza.pl();
        com_tencent_mm_plugin_voip_model_v2protocal.kvY = pl;
        com_tencent_mm_plugin_voip_model_v2protocal = this.kqI.ksc;
        if (this.ksw == null || this.kqI.ksc.kxf.ksZ != (byte) 1) {
            pl = 0;
        } else {
            pl = this.ksw.bbu();
        }
        com_tencent_mm_plugin_voip_model_v2protocal.kwf = (int) ((((float) ak.yX().getStreamVolume(pl)) / ((float) ak.yX().getStreamMaxVolume(pl))) * 100.0f);
        synchronized (this.ksI) {
            if (!(this.ksw == null || this.hza == null)) {
                e.b(new a(this, this.ksw, this.hza), "VoipDeviceHandler_stopDev", 10);
                this.ksw = null;
                this.hza = null;
            }
        }
    }
}
