package com.tencent.mm.plugin.sns.e;

import android.database.Cursor;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.axh;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Vector;

public final class x extends k implements j, d {
    private static Vector<String> jkU = new Vector();
    private final int aYX;
    private boolean bcR;
    private b cif;
    public e cii;
    private boolean jjU;
    private long jjV = 0;
    long jjW = 0;
    public int jjY = 0;
    private long jkG = 0;
    private String jkI = "";
    private boolean jkJ = false;
    private boolean jkK = false;
    private int jkV = 0;
    private boolean jkW = false;
    private boolean jkX = false;
    String userName;

    public static synchronized boolean Am(String str) {
        boolean z;
        synchronized (x.class) {
            if (jkU.contains(str)) {
                z = false;
            } else {
                jkU.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean An(String str) {
        synchronized (x.class) {
            jkU.remove(str);
        }
        return true;
    }

    public x(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        this.userName = str;
        this.jjV = j;
        this.bcR = z;
        if (j == 0) {
            v.i("MicroMsg.NetSceneSnsUserPage", "fp userName " + str);
        } else {
            v.i("MicroMsg.NetSceneSnsUserPage", "np userName " + str);
        }
        this.aYX = z ? 4 : 8;
        a aVar = new a();
        aVar.czn = new axh();
        aVar.czo = new axi();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.czm = 212;
        aVar.czp = 99;
        aVar.czq = 1000000099;
        this.cif = aVar.Bv();
        axh com_tencent_mm_protocal_c_axh = (axh) this.cif.czk.czs;
        com_tencent_mm_protocal_c_axh.mdw = str;
        com_tencent_mm_protocal_c_axh.mSW = j;
        if (j == 0) {
            z2 = true;
        }
        this.jjU = z2;
        int Ax = ad.aSu().Ax(str);
        l aSE = ad.aSE();
        if (!this.jjU) {
            j2 = j;
        }
        this.jjW = aSE.a(j2, Ax, str, z);
        com_tencent_mm_protocal_c_axh.mUm = this.jjW;
        int a = c.a(this.jjW, j, str);
        com_tencent_mm_protocal_c_axh.mUn = a;
        com_tencent_mm_protocal_c_axh.mcP = i;
        if (this.jjU) {
            this.jkI = ad.aSG().Bu(str).field_md5;
            if (this.jkI == null) {
                this.jkI = "";
            }
            com_tencent_mm_protocal_c_axh.mSV = this.jkI;
        }
        this.jkG = j;
        v.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + Ax + " maxId:" + i.cE(j) + " minId:" + i.cE(this.jjW) + " lastReqTime:" + a + " snsSource " + i);
    }

    private void aSc() {
        l aSE = ad.aSE();
        String str = this.userName;
        boolean z = this.bcR;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(l.ao(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25) and  (snsId != 0  )  limit ").append(4);
        Cursor rawQuery = aSE.cie.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count <= 3 && count > 0) {
            this.jkK = true;
        } else if (count == 0) {
            this.jkJ = true;
        }
    }

    private void a(axi com_tencent_mm_protocal_c_axi, String str) {
        ah.a(this.userName, this.aYX, com_tencent_mm_protocal_c_axi.mfQ, str);
        if (this.jjV == 0) {
            this.jjV = ((awa) com_tencent_mm_protocal_c_axi.mfQ.getFirst()).mjq;
        } else {
            this.jjV = c.cG(this.jjV);
        }
        this.jjW = ((awa) com_tencent_mm_protocal_c_axi.mfQ.getLast()).mjq;
        v.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[]{this.userName, Long.valueOf(this.jjV), Long.valueOf(this.jjW), Integer.valueOf(com_tencent_mm_protocal_c_axi.mUp)});
        c.a(this.userName, this.jjV, this.jjW, com_tencent_mm_protocal_c_axi.mUp);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        axi com_tencent_mm_protocal_c_axi = (axi) ((b) pVar).czl.czs;
        if (pVar.ze().lWU == 207 || pVar.ze().lWU == 203 || pVar.ze().lWU == 0) {
            this.jjY = com_tencent_mm_protocal_c_axi.mSZ;
            v.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + com_tencent_mm_protocal_c_axi.mSZ + " , objCount:  " + com_tencent_mm_protocal_c_axi.mJw);
            String cF = i.cF(this.jjV);
            if (!this.jjU) {
                v.d("MicroMsg.NetSceneSnsUserPage", "np  " + com_tencent_mm_protocal_c_axi.mfQ.size());
                if (com_tencent_mm_protocal_c_axi.mfQ.isEmpty()) {
                    this.jkX = pVar.ze().lWU == 203;
                    ad.aSE().c(this.userName, this.bcR, cF);
                    this.jkJ = true;
                    this.jjW = this.jjV;
                } else {
                    a(com_tencent_mm_protocal_c_axi, cF);
                }
                An(this.userName);
                this.cii.a(i2, i3, str, this);
                return;
            } else if (this.jkI.equals(com_tencent_mm_protocal_c_axi.mSV)) {
                this.jjW = ad.aSE().a(this.jjU ? 0 : this.jkG, this.jjY, this.userName, this.bcR);
                v.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[]{Long.valueOf(this.jjW)});
                aSc();
                An(this.userName);
                this.cii.a(i2, i3, str, this);
                return;
            } else {
                String cE;
                String str2;
                v.i("MicroMsg.NetSceneSnsUserPage", "fp  " + com_tencent_mm_protocal_c_axi.mfQ.size());
                if (this.jjU && !this.jkI.equals(com_tencent_mm_protocal_c_axi.mSV)) {
                    this.jkV = com_tencent_mm_protocal_c_axi.mUy;
                    com.tencent.mm.plugin.sns.storage.i Bu = ad.aSG().Bu(this.userName);
                    Bu.field_icount = this.jkV;
                    axg com_tencent_mm_protocal_c_axg = com_tencent_mm_protocal_c_axi.mFA;
                    if (com_tencent_mm_protocal_c_axg != null) {
                        cE = i.cE(com_tencent_mm_protocal_c_axg.cHp);
                        String xh = ad.xh();
                        str2 = this.userName + "bg_";
                        String str3 = this.userName + "tbg_";
                        if (Bu.field_bgUrl == null || !Bu.field_bgId.equals(cE)) {
                            Bu.field_older_bgId = Bu.field_bgId;
                            if (FileOp.aR(al.cA(xh, this.userName) + str2)) {
                                FileOp.deleteFile(al.cA(xh, this.userName) + str3);
                                FileOp.n(al.cA(xh, this.userName), str2, str3);
                            }
                            this.jkW = true;
                            Bu.aUx();
                            v.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + com_tencent_mm_protocal_c_axg.cHo);
                        }
                        Bu.field_bgId = cE;
                        Bu.field_bgUrl = com_tencent_mm_protocal_c_axg.cHo;
                        Bu.field_snsBgId = com_tencent_mm_protocal_c_axg.cHp;
                    }
                    ad.aSG().a(Bu);
                }
                ad.aSG().cL(this.userName, com_tencent_mm_protocal_c_axi.mSV);
                if (pVar.ze().lWU == 207) {
                    ad.aSG().cM(this.userName, "");
                    String str4;
                    if (com_tencent_mm_protocal_c_axi.mfQ.isEmpty()) {
                        l aSE = ad.aSE();
                        str4 = this.userName;
                        boolean z = this.bcR;
                        aSE.g(z, l.ao(str4, z) + " AND  (snsId != 0  ) ");
                        this.jjW = this.jjV;
                    } else {
                        l aSE2 = ad.aSE();
                        cE = this.userName;
                        boolean z2 = this.bcR;
                        str2 = i.cF(((awa) com_tencent_mm_protocal_c_axi.mfQ.getFirst()).mjq);
                        str4 = l.ao(cE, z2) + " AND  (snsId != 0  ) ";
                        if (l.By(str2)) {
                            str4 = str4 + " AND " + aSE2.BB(str2);
                        }
                        aSE2.g(z2, str4);
                        ad.aSE().c(this.userName, this.bcR, i.cF(((awa) com_tencent_mm_protocal_c_axi.mfQ.getLast()).mjq));
                        a(com_tencent_mm_protocal_c_axi, cF);
                    }
                    aSc();
                    An(this.userName);
                    this.cii.a(i2, i3, str, this);
                    return;
                } else if (com_tencent_mm_protocal_c_axi.mfQ.size() == 0) {
                    v.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.cii.a(i2, i3, str, this);
                    return;
                } else {
                    a(com_tencent_mm_protocal_c_axi, cF);
                    An(this.userName);
                    this.cii.a(i2, i3, str, this);
                    return;
                }
            }
        }
        An(this.userName);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 212;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final long aRO() {
        return this.jjW;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean aRK() {
        return this.jjU;
    }

    public final boolean aRL() {
        return this.jkJ;
    }

    public final boolean aRP() {
        return this.jkW;
    }

    public final boolean aRN() {
        return this.jkX;
    }

    public final boolean aRM() {
        return this.jkK;
    }
}
