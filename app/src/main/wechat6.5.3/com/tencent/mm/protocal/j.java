package com.tencent.mm.protocal;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.az;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class j {

    public interface c {

        public static class a {
            public static c lWC;
        }

        void a(f fVar, g gVar, int i, int i2, String str);

        p aD(int i, int i2);

        int zb();
    }

    public static abstract class f extends com.tencent.mm.protocal.l.c implements com.tencent.mm.protocal.l.a {
        public byte[] lWF;

        public abstract String getUri();

        public final void aU(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.lWF = bArr;
        }
    }

    public static abstract class g extends com.tencent.mm.protocal.l.d implements com.tencent.mm.protocal.l.b {
        public byte[] dlf;
        public String dli;
        public baq lWG = new baq();
        public byte[] lWH;
        public int lWI = 0;

        public final void aV(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.dlf = bArr;
        }
    }

    public static class a extends f implements com.tencent.mm.protocal.l.a {
        public do lWB = new do();
        public String username;

        public final byte[] zf() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.dP(SQLiteDatabase.KeyEmpty);
            if (this.lWQ == 12) {
                i = 1;
            } else {
                com.tencent.mm.kernel.g.vx();
                i = com.tencent.mm.kernel.g.vw().cjT.getInt(46, 0);
            }
            v.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            this.lWS = ad.brG();
            if (CdnLogic.MediaType_FAVORITE_VIDEO == q.dqj && q.dqk > 0) {
                q.dqk = 0;
                ad.y(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0);
            }
            aqp com_tencent_mm_protocal_c_aqp = this.lWB.meu;
            com_tencent_mm_protocal_c_aqp.mPU = l.a(this);
            com_tencent_mm_protocal_c_aqp.mem = com.tencent.mm.compatible.d.p.rJ();
            com_tencent_mm_protocal_c_aqp.men = bb.eN(i);
            com_tencent_mm_protocal_c_aqp.meo = 0;
            com_tencent_mm_protocal_c_aqp.mep = com.tencent.mm.kernel.a.uR();
            com_tencent_mm_protocal_c_aqp.cHf = bb.zw();
            com_tencent_mm_protocal_c_aqp.eeA = d.lWf;
            com_tencent_mm_protocal_c_aqp.meq = az.bxj();
            com_tencent_mm_protocal_c_aqp.fvz = u.bsY();
            com_tencent_mm_protocal_c_aqp.fvy = be.buj();
            com.tencent.mm.kernel.g.vx();
            v.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) com.tencent.mm.kernel.g.vw().cjT.get(18), Integer.valueOf(com_tencent_mm_protocal_c_aqp.mel.mfy));
            com_tencent_mm_protocal_c_aqp.mel.mfw.mgX = new are().ba(be.KG(r0));
            dp dpVar = this.lWB.met;
            nr nrVar = new nr();
            nrVar.mpx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(nrVar.mpx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            aU(bArr2);
            String str = "MicroMsg.AutoReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(nrVar.mpx);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = be.bk(bArr);
            objArr[5] = be.bk(bArr2);
            v.d(str, str2, objArr);
            nrVar.mes = new are().ba(bArr);
            dpVar.mew = nrVar;
            try {
                return this.lWB.toByteArray();
            } catch (Throwable e) {
                v.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", be.e(e));
                return null;
            }
        }

        public final int zg() {
            return 702;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class b extends g implements com.tencent.mm.protocal.l.b {
        public final int y(byte[] bArr) {
            try {
                this.lWG = (baq) this.lWG.az(bArr);
                l.a(this, this.lWG.mQl);
                this.lWI = 0;
                if (this.lWG.mQl.mcj == 0 && (this.lWG.mXf == null || this.lWG.mXf.fvo == 0 || be.bl(m.a(this.lWG.mXf.mdU)))) {
                    v.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.lWG.mQl.mcj = -1;
                }
                v.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.lWV);
                com.tencent.mm.kernel.a.dP(r0);
                return this.lWG.mQl.mcj;
            } catch (Throwable e) {
                v.e("MicroMsg.MMAuth", "toProtoBuf :%s", be.e(e));
                this.lWG.mQl.mcj = -1;
                return -1;
            }
        }
    }

    public static class d extends f implements com.tencent.mm.protocal.l.a {
        public ahp lWD = new ahp();
        public boolean lWE = false;

        public final byte[] zf() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.dP(SQLiteDatabase.KeyEmpty);
            if (this.lWQ == 16) {
                i = 1;
            } else if (this.lWE) {
                i = 3;
            } else {
                com.tencent.mm.kernel.g.vx();
                i = com.tencent.mm.kernel.g.vw().cjT.getInt(46, 0);
            }
            v.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (CdnLogic.MediaType_FAVORITE_VIDEO == q.dqj && q.dqk > 0) {
                q.dqk = 0;
                ad.y(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0);
            }
            this.lWS = ad.brG();
            aqp com_tencent_mm_protocal_c_aqp = this.lWD.mHl;
            com_tencent_mm_protocal_c_aqp.mPU = l.a(this);
            com_tencent_mm_protocal_c_aqp.mem = com.tencent.mm.compatible.d.p.rJ();
            com_tencent_mm_protocal_c_aqp.men = bb.eN(i);
            com_tencent_mm_protocal_c_aqp.meo = 0;
            com_tencent_mm_protocal_c_aqp.mep = com.tencent.mm.kernel.a.uR();
            com_tencent_mm_protocal_c_aqp.cHf = bb.zw();
            com_tencent_mm_protocal_c_aqp.eeA = d.lWf;
            com_tencent_mm_protocal_c_aqp.meq = az.bxj();
            com_tencent_mm_protocal_c_aqp.fvz = u.bsY();
            com_tencent_mm_protocal_c_aqp.fvy = be.buj();
            com_tencent_mm_protocal_c_aqp.lZo = com.tencent.mm.sdk.platformtools.f.nhU;
            if (10012 == q.dqj && q.dqk > 0) {
                com_tencent_mm_protocal_c_aqp.lZo = q.dqk;
            }
            com_tencent_mm_protocal_c_aqp.mip = d.lWa;
            com_tencent_mm_protocal_c_aqp.mio = d.lWb;
            com_tencent_mm_protocal_c_aqp.mHg = d.lWc;
            com_tencent_mm_protocal_c_aqp.mpz = com.tencent.mm.compatible.d.p.getSimCountryIso();
            com.tencent.mm.kernel.g.vx();
            v.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) com.tencent.mm.kernel.g.vw().cjT.get(18), Integer.valueOf(com_tencent_mm_protocal_c_aqp.mel.mfy));
            com_tencent_mm_protocal_c_aqp.mel.mfw.mgX = new are().ba(be.KG(r0));
            ahq com_tencent_mm_protocal_c_ahq = this.lWD.mHk;
            com_tencent_mm_protocal_c_ahq.mgD = new are().ba(be.buh());
            nr nrVar = new nr();
            nrVar.mpx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(nrVar.mpx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            aU(bArr2);
            String str = "MicroMsg.ManualReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(nrVar.mpx);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = be.bk(bArr);
            objArr[5] = be.bk(bArr2);
            v.d(str, str2, objArr);
            nrVar.mes = new are().ba(bArr);
            com_tencent_mm_protocal_c_ahq.mew = nrVar;
            v.i("MicroMsg.ManualReq", "summerauth IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", com_tencent_mm_protocal_c_aqp.mem, com_tencent_mm_protocal_c_aqp.men, com_tencent_mm_protocal_c_aqp.mep, com_tencent_mm_protocal_c_aqp.cHf, com_tencent_mm_protocal_c_aqp.eeA, com_tencent_mm_protocal_c_aqp.meq, com_tencent_mm_protocal_c_aqp.fvz, com_tencent_mm_protocal_c_aqp.fvy, Integer.valueOf(com_tencent_mm_protocal_c_aqp.lZo), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.aPW), com_tencent_mm_protocal_c_aqp.mip, com_tencent_mm_protocal_c_aqp.mio, com_tencent_mm_protocal_c_aqp.mHg, com_tencent_mm_protocal_c_aqp.mpz);
            try {
                return this.lWD.toByteArray();
            } catch (Throwable e) {
                v.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", be.e(e));
                return null;
            }
        }

        public final int zg() {
            return 701;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static class e extends g implements com.tencent.mm.protocal.l.b {
        public final int y(byte[] bArr) {
            try {
                this.lWG = (baq) this.lWG.az(bArr);
                l.a(this, this.lWG.mQl);
                this.lWI = 0;
                if (this.lWG.mQl.mcj == 0 && (this.lWG.mXf == null || this.lWG.mXf.fvo == 0 || be.bl(m.a(this.lWG.mXf.mdU)))) {
                    v.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.lWG.mQl.mcj = -1;
                }
                v.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.lWV);
                com.tencent.mm.kernel.a.dP(r0);
                return this.lWG.mQl.mcj;
            } catch (Throwable e) {
                v.e("MicroMsg.MMAuth", "toProtoBuf :%s", be.e(e));
                this.lWG.mQl.mcj = -1;
                return -1;
            }
        }
    }
}
