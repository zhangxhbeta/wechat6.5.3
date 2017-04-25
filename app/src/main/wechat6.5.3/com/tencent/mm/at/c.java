package com.tencent.mm.at;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.c.bdw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c extends a implements j {
    int aYJ;
    private b cif;
    e cii;
    ah cxS;
    int dag;
    boolean diB;
    private long dkc;
    private boolean dkd;
    private int dke;
    private String[] dkf;
    String filename;

    public final void LG() {
        this.diB = true;
    }

    public final String[] LH() {
        return this.dkf;
    }

    public final long LI() {
        return this.dkc;
    }

    public c(String str, int i) {
        this.aYJ = 0;
        this.dag = 0;
        this.filename = null;
        this.dkc = -1;
        this.dkd = false;
        this.diB = false;
        this.dkf = new String[0];
        this.cxS = new ah(new a(this) {
            final /* synthetic */ c dkg;

            {
                this.dkg = r1;
            }

            public final boolean oU() {
                long aQ = (long) com.tencent.mm.a.e.aQ(this.dkg.filename);
                v.d("MicroMsg.NetSceneVoiceAddr", g.sm() + " onTimerExpired: file:" + this.dkg.filename + " nowlen:" + aQ + " oldoff:" + this.dkg.dag + " isFin:" + this.dkg.diB);
                if (aQ - ((long) this.dkg.dag) < 3300 && !this.dkg.diB) {
                    return true;
                }
                if (this.dkg.a(this.dkg.czE, this.dkg.cii) == -1) {
                    this.dkg.aYJ = g.sk() + 40000;
                    this.dkg.cii.a(3, -1, "doScene failed", this.dkg);
                }
                return false;
            }
        }, true);
        this.dkc = be.Ni();
        this.filename = str;
        this.dke = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.cii = eVar2;
        int aQ = com.tencent.mm.a.e.aQ(this.filename);
        v.d("MicroMsg.NetSceneVoiceAddr", g.sm() + " read file:" + this.filename + " filelen:" + aQ + " oldoff:" + this.dag + " isFin:" + this.diB);
        if (aQ <= 0) {
            v.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.aYJ = g.sk() + 40000;
            return -1;
        }
        int i2 = aQ - this.dag;
        if (i2 <= 3960) {
            if (i2 >= 3300 || this.diB) {
                if (this.diB) {
                    this.dkd = true;
                }
                i = i2;
            } else {
                v.e("MicroMsg.NetSceneVoiceAddr", g.sm() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.diB);
                this.aYJ = g.sk() + 40000;
                return -1;
            }
        }
        v.d("MicroMsg.NetSceneVoiceAddr", g.sm() + " read file:" + this.filename + " filelen:" + aQ + " oldoff:" + this.dag + " isFin:" + this.diB + " endFlag:" + this.dkd);
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.dag, i);
        if (c == null) {
            v.e("MicroMsg.NetSceneVoiceAddr", g.sm() + " read failed :" + this.filename + " read:" + i);
            this.aYJ = g.sk() + 40000;
            return -1;
        }
        b.a aVar = new b.a();
        aVar.czn = new bdv();
        aVar.czo = new bdw();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.czm = 206;
        aVar.czp = 94;
        aVar.czq = 1000000094;
        this.cif = aVar.Bv();
        bdv com_tencent_mm_protocal_c_bdv = (bdv) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bdv.mfg = new are().ba(c);
        v.d("MicroMsg.NetSceneVoiceAddr", g.sm() + " read file:" + this.filename + " readlen:" + c.length + " datalen:" + com_tencent_mm_protocal_c_bdv.mfg.mQw.toByteArray().length + " dataiLen:" + com_tencent_mm_protocal_c_bdv.mfg.mQu + " md5:" + com.tencent.mm.a.g.m(c) + " datamd5:" + com.tencent.mm.a.g.m(com_tencent_mm_protocal_c_bdv.mfg.mQw.toByteArray()));
        ak.yW();
        com_tencent_mm_protocal_c_bdv.gln = (String) com.tencent.mm.model.c.vf().get(2, SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_bdv.mfb = this.dag;
        com_tencent_mm_protocal_c_bdv.mXJ = this.dkc;
        com_tencent_mm_protocal_c_bdv.mfh = this.dkd ? 1 : 0;
        com_tencent_mm_protocal_c_bdv.mXK = 0;
        com_tencent_mm_protocal_c_bdv.mdF = 0;
        com_tencent_mm_protocal_c_bdv.mXL = 0;
        com_tencent_mm_protocal_c_bdv.mdC = 0;
        com_tencent_mm_protocal_c_bdv.mZB = this.dke;
        v.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.dkc);
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 20;
    }

    protected final void a(a aVar) {
        this.cii.a(3, g.sk() + 40000, "ecurityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneVoiceAddr", g.sm() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bdv com_tencent_mm_protocal_c_bdv = (bdv) ((b) pVar).czk.czs;
        bdw com_tencent_mm_protocal_c_bdw = (bdw) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneVoiceAddr", g.sm() + " onGYNetEnd  file:" + this.filename + " endflag:" + com_tencent_mm_protocal_c_bdw.mfh + " lst:" + com_tencent_mm_protocal_c_bdw.mfO);
            if (com_tencent_mm_protocal_c_bdv.mfh == 1) {
                this.dkf = new String[com_tencent_mm_protocal_c_bdw.mfO.size()];
                for (int i4 = 0; i4 < com_tencent_mm_protocal_c_bdw.mfO.size(); i4++) {
                    this.dkf[i4] = ((arf) com_tencent_mm_protocal_c_bdw.mfO.get(i4)).mQy;
                }
                this.cii.a(i2, i3, str, this);
                return;
            }
            this.dag = com_tencent_mm_protocal_c_bdv.mfg.mQu + com_tencent_mm_protocal_c_bdv.mfb;
            long j = this.diB ? 0 : 500;
            v.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.cxS.ea(j);
            return;
        }
        v.e("MicroMsg.NetSceneVoiceAddr", g.sm() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 206;
    }
}
