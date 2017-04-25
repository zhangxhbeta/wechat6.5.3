package com.tencent.mm.at;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d extends a implements j {
    int aYJ;
    private b cif;
    e cii;
    ah cxS;
    int dag;
    boolean diB;
    private long dkc;
    private boolean dkd;
    private String[] dkf;
    private int dkh;
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

    public d(String str, int i) {
        this.aYJ = 0;
        this.diB = false;
        this.dag = 0;
        this.filename = null;
        this.dkc = -1;
        this.dkd = false;
        this.dkh = 0;
        this.dkf = new String[0];
        this.cxS = new ah(new a(this) {
            final /* synthetic */ d dki;

            {
                this.dki = r1;
            }

            public final boolean oU() {
                long aQ = (long) com.tencent.mm.a.e.aQ(this.dki.filename);
                v.d("MicroMsg.NetSceneVoiceInput", g.sm() + " onTimerExpired: file:" + this.dki.filename + " nowlen:" + aQ + " oldoff:" + this.dki.dag + " isFin:" + this.dki.diB);
                if (aQ - ((long) this.dki.dag) < 3300 && !this.dki.diB) {
                    return true;
                }
                if (this.dki.a(this.dki.czE, this.dki.cii) == -1) {
                    this.dki.aYJ = g.sk() + 40000;
                    this.dki.cii.a(3, -1, "doScene failed", this.dki);
                }
                return false;
            }
        }, true);
        this.dkc = (long) (be.Ni()).hashCode();
        this.filename = str;
        this.dkh = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        int aQ = com.tencent.mm.a.e.aQ(this.filename);
        v.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", this.filename, Integer.valueOf(aQ), Integer.valueOf(this.dag), Boolean.valueOf(this.diB));
        if (aQ <= 0) {
            v.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.aYJ = g.sk() + 40000;
            return -1;
        }
        int i = aQ - this.dag;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.diB) {
            v.e("MicroMsg.NetSceneVoiceInput", g.sm() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.diB);
            this.aYJ = g.sk() + 40000;
            return -1;
        } else if (this.diB) {
            this.dkd = true;
        }
        v.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", this.filename, Integer.valueOf(aQ), Boolean.valueOf(this.diB), Boolean.valueOf(this.diB), Boolean.valueOf(this.dkd));
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.dag, i);
        if (c == null) {
            v.e("MicroMsg.NetSceneVoiceInput", g.sm() + " read failed :" + this.filename + " read:" + i);
            this.aYJ = g.sk() + 40000;
            return -1;
        }
        b.a aVar = new b.a();
        aVar.czn = new bcc();
        aVar.czo = new bcd();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        aVar.czm = 349;
        aVar.czp = 158;
        aVar.czq = 1000000158;
        this.cif = aVar.Bv();
        bcc com_tencent_mm_protocal_c_bcc = (bcc) this.cif.czk.czs;
        ak.yW();
        com_tencent_mm_protocal_c_bcc.gln = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_bcc.mfg = new are().ba(c);
        v.d("MicroMsg.NetSceneVoiceInput", g.sm() + " read file:" + this.filename + " readlen:" + c.length + " datalen:" + com_tencent_mm_protocal_c_bcc.mfg.mQw.toByteArray().length + " dataiLen:" + com_tencent_mm_protocal_c_bcc.mfg.mQu + " md5:" + com.tencent.mm.a.g.m(c) + " datamd5:" + com.tencent.mm.a.g.m(com_tencent_mm_protocal_c_bcc.mfg.mQw.toByteArray()));
        com_tencent_mm_protocal_c_bcc.mfb = this.dag;
        com_tencent_mm_protocal_c_bcc.mXJ = this.dkc;
        com_tencent_mm_protocal_c_bcc.mfh = this.dkd ? 1 : 0;
        com_tencent_mm_protocal_c_bcc.mXK = 0;
        com_tencent_mm_protocal_c_bcc.mdF = 0;
        com_tencent_mm_protocal_c_bcc.mXL = this.dkh;
        com_tencent_mm_protocal_c_bcc.mdC = 0;
        v.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.dkc);
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
        v.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bcc com_tencent_mm_protocal_c_bcc = (bcc) ((b) pVar).czk.czs;
        bcd com_tencent_mm_protocal_c_bcd = (bcd) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneVoiceInput", g.sm() + " onGYNetEnd  file:" + this.filename + " endflag:" + com_tencent_mm_protocal_c_bcd.mfh);
            if (com_tencent_mm_protocal_c_bcc.mfh == 1) {
                if (!(com_tencent_mm_protocal_c_bcd.mXM == null || com_tencent_mm_protocal_c_bcd.mXM.mQw == null)) {
                    this.dkf = new String[]{com_tencent_mm_protocal_c_bcd.mXM.mQw.brp()};
                }
                this.cii.a(i2, i3, str, this);
                return;
            }
            this.dag = com_tencent_mm_protocal_c_bcc.mfg.mQu + com_tencent_mm_protocal_c_bcc.mfb;
            long j = this.diB ? 0 : 500;
            v.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.cxS.ea(j);
            return;
        }
        v.e("MicroMsg.NetSceneVoiceInput", g.sm() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 349;
    }
}
