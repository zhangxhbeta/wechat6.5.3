package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avj;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.v.k implements j {
    public static List<Long> jjT = Collections.synchronizedList(new LinkedList());
    private b cif;
    public e cii;
    private String hqT;
    private long jdG;

    public static boolean cH(long j) {
        if (jjT.contains(Long.valueOf(j))) {
            return false;
        }
        jjT.add(Long.valueOf(j));
        return true;
    }

    private static boolean cI(long j) {
        jjT.remove(Long.valueOf(j));
        return true;
    }

    public k(long j, int i) {
        boolean z;
        this.jdG = j;
        a aVar = new a();
        aVar.czn = new avj();
        aVar.czo = new avk();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        aVar.czm = 683;
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        this.hqT = stringBuilder.append(c.xp()).append("ad_detail_session").toString();
        byte[] c = FileOp.c(this.hqT, 0, -1);
        this.cif = aVar.Bv();
        ((avj) this.cif.czk.czs).mjq = j;
        ((avj) this.cif.czk.czs).mSH = m.H(c);
        ((avj) this.cif.czk.czs).maG = i;
        String str = "MicroMsg.NetSceneSnsAdObjectDetial";
        StringBuilder append = new StringBuilder("req snsId ").append(j).append(" ").append(i.cE(j)).append(" scene ").append(i).append(" buf is null? ");
        if (c == null) {
            z = true;
        } else {
            z = false;
        }
        v.d(str, append.append(z).toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 683;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        byte[] a;
        Object obj = 1;
        v.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 4 && i3 == 1) {
                a = m.a(((avk) this.cif.czl.czs).mSH);
                if (a != null) {
                    FileOp.deleteFile(this.hqT);
                    FileOp.b(this.hqT, a, a.length);
                }
                obj = null;
            } else {
                obj = null;
            }
        }
        if (obj == null) {
            this.cii.a(i2, i3, str, this);
            cI(this.jdG);
            return;
        }
        a = m.a(((avk) this.cif.czl.czs).mSH);
        FileOp.deleteFile(this.hqT);
        FileOp.b(this.hqT, a, a.length);
        avi com_tencent_mm_protocal_c_avi = ((avk) this.cif.czl.czs).mSI;
        if (com_tencent_mm_protocal_c_avi != null) {
            v.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + m.b(com_tencent_mm_protocal_c_avi.mSF.mTg));
            v.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + com_tencent_mm_protocal_c_avi.mSG);
        }
        if (com_tencent_mm_protocal_c_avi == null || com_tencent_mm_protocal_c_avi.mSF == null || com_tencent_mm_protocal_c_avi.mSF.mJm <= 0) {
            if (!(com_tencent_mm_protocal_c_avi == null || com_tencent_mm_protocal_c_avi.mSF == null)) {
                v.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + com_tencent_mm_protocal_c_avi.mSF.mTn.size() + " like: " + com_tencent_mm_protocal_c_avi.mSF.mTk.size());
            }
            a.a(com_tencent_mm_protocal_c_avi);
            this.cii.a(i2, i3, str, this);
            cI(this.jdG);
            return;
        }
        v.i("MicroMsg.NetSceneSnsAdObjectDetial", com_tencent_mm_protocal_c_avi.mSF.mjq + " will remove by get detail ");
        cI(this.jdG);
        ad.aSF().delete(com_tencent_mm_protocal_c_avi.mSF.mjq);
        ad.aSH().cX(com_tencent_mm_protocal_c_avi.mSF.mjq);
        this.cii.a(i2, i3, str, this);
    }
}
