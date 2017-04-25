package com.tencent.mm.plugin.sns.e;

import android.database.Cursor;
import com.tencent.mm.e.a.oc;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.axc;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.s;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class v extends k implements j, d {
    private static Vector<String> jjX = new Vector();
    public int Tr = 0;
    final int aYX;
    private boolean cXI = false;
    private b cif;
    public e cii;
    public boolean jjU;
    private long jjV = 0;
    long jjW = 0;
    public int jjY = 0;
    public int jjZ = 0;
    private long jkG = 0;
    private long jkH = 0;
    private String jkI = "";
    private boolean jkJ = false;
    private boolean jkK = false;

    public static synchronized boolean Ak(String str) {
        boolean z;
        synchronized (v.class) {
            if (jjX.contains(str)) {
                z = false;
            } else {
                jjX.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Al(String str) {
        synchronized (v.class) {
            jjX.remove(str);
        }
        return true;
    }

    public v(long j) {
        int i;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        aVar.czn = new axc();
        aVar.czo = new axd();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.czm = 211;
        aVar.czp = 98;
        aVar.czq = 1000000098;
        this.cif = aVar.Bv();
        if (ak.isWifi(aa.getContext())) {
            i = 1;
        } else if (ak.is3G(aa.getContext())) {
            i = 3;
        } else if (ak.is4G(aa.getContext())) {
            i = 4;
        } else if (ak.is2G(aa.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.jjV = j;
        this.jjU = j == 0;
        this.aYX = 2;
        axc com_tencent_mm_protocal_c_axc = (axc) this.cif.czk.czs;
        com_tencent_mm_protocal_c_axc.mfm = i;
        com_tencent_mm_protocal_c_axc.mSW = j;
        int aTa = ad.aSu().aTa();
        l aSE = ad.aSE();
        if (this.jjU) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.jjW = aSE.d(j2, aTa, true);
        com_tencent_mm_protocal_c_axc.mUm = this.jjW;
        com_tencent_mm_protocal_c_axc.mUn = c.a(this.jjW, j, "@__weixintimtline");
        if (this.jjU) {
            this.jkH = ad.aSE().d(0, 1, true);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.jkH);
            com_tencent_mm_protocal_c_axc.mUo = this.jkH;
            i Bu = ad.aSG().Bu("@__weixintimtline");
            this.jkI = Bu == null ? "" : Bu.field_md5;
            if (this.jkI == null) {
                this.jkI = "";
            }
            com_tencent_mm_protocal_c_axc.mSV = this.jkI;
            if (Bu == null || Bu.field_adsession == null) {
                com_tencent_mm_protocal_c_axc.mSH = new are().ba(new byte[0]);
            } else {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", new Object[]{Bu.field_adsession});
                com_tencent_mm_protocal_c_axc.mSH = new are().ba(Bu.field_adsession);
            }
        }
        this.jkG = j;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + aTa + " max:" + j + " min:" + this.jjW + " ReqTime:" + com_tencent_mm_protocal_c_axc.mUn + " nettype: " + i);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", new Object[]{com.tencent.mm.plugin.sns.data.i.cE(j), com.tencent.mm.plugin.sns.data.i.cE(this.jjW), Integer.valueOf(r3)});
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void a(axd com_tencent_mm_protocal_c_axd, String str) {
        ah.a("@__weixintimtline", this.aYX, com_tencent_mm_protocal_c_axd.mfQ, str);
        this.jjW = ((awa) com_tencent_mm_protocal_c_axd.mfQ.getLast()).mjq;
        if (this.jjV == 0) {
            this.jjV = ((awa) com_tencent_mm_protocal_c_axd.mfQ.getFirst()).mjq;
        } else {
            this.jjV = c.cG(this.jjV);
        }
        c.a("@__weixintimtline", this.jjV, this.jjW, com_tencent_mm_protocal_c_axd.mUp);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        axd com_tencent_mm_protocal_c_axd = (axd) ((b) pVar).czl.czs;
        if (pVar.ze().lWU == 207 || pVar.ze().lWU == 0) {
            int i4;
            if (com_tencent_mm_protocal_c_axd.mTb != null) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + com_tencent_mm_protocal_c_axd.mTb.mUi + " " + com_tencent_mm_protocal_c_axd.mTb.mUh);
                i4 = com_tencent_mm_protocal_c_axd.mTb.mUi;
                com.tencent.mm.plugin.sns.b.a.jdC = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.b.a.jdC = Integer.MAX_VALUE;
                }
                s.nof = com_tencent_mm_protocal_c_axd.mTb.mUh;
            }
            this.jjY = com_tencent_mm_protocal_c_axd.mSZ;
            this.jjZ = com_tencent_mm_protocal_c_axd.mTa;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + com_tencent_mm_protocal_c_axd.mSZ + " , objCount:  " + com_tencent_mm_protocal_c_axd.mJw + " cflag : " + com_tencent_mm_protocal_c_axd.mTa);
            this.Tr = com_tencent_mm_protocal_c_axd.mJw;
            String cF = com.tencent.mm.plugin.sns.data.i.cF(this.jjV);
            if (com_tencent_mm_protocal_c_axd.mfQ.isEmpty()) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + com_tencent_mm_protocal_c_axd.mfQ.size() + " Max " + ((awa) com_tencent_mm_protocal_c_axd.mfQ.getFirst()).mjq + " " + com.tencent.mm.plugin.sns.data.i.cE(((awa) com_tencent_mm_protocal_c_axd.mfQ.getFirst()).mjq) + "  respone min  " + ((awa) com_tencent_mm_protocal_c_axd.mfQ.getLast()).mjq + " " + com.tencent.mm.plugin.sns.data.i.cE(((awa) com_tencent_mm_protocal_c_axd.mfQ.getLast()).mjq));
            }
            if (this.jjU) {
                this.Tr = com_tencent_mm_protocal_c_axd.mJw;
                if (this.jkI.equals(com_tencent_mm_protocal_c_axd.mSV)) {
                    this.jjW = ad.aSE().d(this.jjU ? 0 : this.jkG, this.jjY, true);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", new Object[]{Long.valueOf(this.jjW)});
                    Cursor rawQuery = ad.aSE().cie.rawQuery(l.qE(3), null);
                    i4 = rawQuery.getCount();
                    rawQuery.close();
                    if (i4 < 3 && i4 > 0) {
                        this.jkK = true;
                    } else if (i4 == 0) {
                        this.jkJ = true;
                    }
                    Al("@__weixintimtline");
                    this.cii.a(i2, i3, str, this);
                    return;
                }
                bu buVar;
                String str2;
                String a;
                String b;
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "fp resp list size " + com_tencent_mm_protocal_c_axd.mfQ.size() + " adsize : " + com_tencent_mm_protocal_c_axd.mUq);
                ad.aSG().e("@__weixintimtline", com_tencent_mm_protocal_c_axd.mSV, m.a(com_tencent_mm_protocal_c_axd.mSH));
                for (int i5 = 0; i5 < com_tencent_mm_protocal_c_axd.mUr.size(); i5++) {
                    buVar = (bu) com_tencent_mm_protocal_c_axd.mUr.get(i5);
                    if (this.cXI) {
                        str2 = ad.xq() + "ad.proto";
                        try {
                            byte[] toByteArray = buVar.toByteArray();
                            com.tencent.mm.a.e.b(str2, toByteArray, toByteArray.length);
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                        }
                    }
                    str2 = m.a(buVar.mco);
                    a = m.a(buVar.mcn.mSG);
                    b = m.b(buVar.mcn.mSF.mTg);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + str2);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + a);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + "\r\n");
                }
                if (this.cXI && com_tencent_mm_protocal_c_axd.mUr.size() == 0) {
                    try {
                        byte[] d = com.tencent.mm.a.e.d(ad.xq() + "ad.proto", 0, -1);
                        bu buVar2 = new bu();
                        buVar2.az(d);
                        com_tencent_mm_protocal_c_axd.mUr.add(buVar2);
                        com_tencent_mm_protocal_c_axd.mUq = com_tencent_mm_protocal_c_axd.mUr.size();
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + com_tencent_mm_protocal_c_axd.mUq);
                        if (com_tencent_mm_protocal_c_axd.mUr.size() > 0) {
                            buVar = (bu) com_tencent_mm_protocal_c_axd.mUr.get(0);
                            String a2 = m.a(buVar.mco);
                            str2 = m.a(buVar.mcn.mSG);
                            a = m.b(buVar.mcn.mSF.mTg);
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + a2);
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + str2);
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + "\r\n");
                            b(buVar);
                        }
                    } catch (Exception e2) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e2.getMessage());
                    }
                }
                a.d(com_tencent_mm_protocal_c_axd.mUr, com_tencent_mm_protocal_c_axd.mfQ);
                a.V(com_tencent_mm_protocal_c_axd.mUr);
                if (com_tencent_mm_protocal_c_axd.mUq == 0) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_axd.mUs)});
                    a.c(com_tencent_mm_protocal_c_axd.mUt, com_tencent_mm_protocal_c_axd.mfQ);
                    a.U(com_tencent_mm_protocal_c_axd.mUt);
                }
                LinkedList linkedList = new LinkedList();
                Iterator it = com_tencent_mm_protocal_c_axd.mfQ.iterator();
                while (it.hasNext()) {
                    linkedList.add(Long.valueOf(((awa) it.next()).mjq));
                }
                oc ocVar = new oc();
                ocVar.bpd.bpe = linkedList;
                com.tencent.mm.sdk.c.a.nhr.z(ocVar);
                if (pVar.ze().lWU == 207) {
                    if (com_tencent_mm_protocal_c_axd.mfQ.isEmpty()) {
                        ad.aSE().aUW();
                        this.jjW = this.jjV;
                    } else {
                        l aSE = ad.aSE();
                        b = com.tencent.mm.plugin.sns.data.i.cF(((awa) com_tencent_mm_protocal_c_axd.mfQ.getFirst()).mjq);
                        if (l.By(b)) {
                            aSE.Bx(" where " + aSE.BB(b) + " and " + l.aUV() + " and  (snsId != 0  ) ");
                        }
                        ad.aSE().Bw(com.tencent.mm.plugin.sns.data.i.cF(((awa) com_tencent_mm_protocal_c_axd.mfQ.getLast()).mjq));
                        a(com_tencent_mm_protocal_c_axd, cF);
                        a.W(com_tencent_mm_protocal_c_axd.mfQ);
                    }
                    this.jkJ = true;
                    Al("@__weixintimtline");
                    this.cii.a(i2, i3, str, this);
                    return;
                }
                if (com_tencent_mm_protocal_c_axd.mfQ.isEmpty()) {
                    ad.aSE().aUW();
                    this.jjW = this.jjV;
                    this.jkJ = true;
                } else {
                    a(com_tencent_mm_protocal_c_axd, cF);
                    a.W(com_tencent_mm_protocal_c_axd.mfQ);
                }
                Al("@__weixintimtline");
                this.cii.a(i2, i3, str, this);
                return;
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + com_tencent_mm_protocal_c_axd.mfQ.size());
            if (com_tencent_mm_protocal_c_axd.mfQ.isEmpty()) {
                ad.aSE().Bw(cF);
                this.jkJ = true;
                this.jjW = this.jjV;
            } else {
                a(com_tencent_mm_protocal_c_axd, cF);
            }
            Al("@__weixintimtline");
            this.cii.a(i2, i3, str, this);
            return;
        }
        Al("@__weixintimtline");
        this.cii.a(i2, i3, str, this);
    }

    private static boolean b(bu buVar) {
        if (!ak.isWifi(aa.getContext())) {
            return false;
        }
        try {
            d.ko(m.b(buVar.mcn.mSF.mTg));
            ad.aSz();
            b.aRI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final int getType() {
        return 211;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final String getUserName() {
        return "@__weixintimtline";
    }

    public final boolean aRK() {
        return this.jjU;
    }

    public final boolean aRL() {
        return this.jkJ;
    }

    public final boolean aRM() {
        return this.jkK;
    }

    public final boolean aRN() {
        return false;
    }

    public final long aRO() {
        return this.jjW;
    }

    public final boolean aRP() {
        return false;
    }
}
