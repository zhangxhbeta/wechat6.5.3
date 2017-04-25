package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.ba.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bht;
import com.tencent.mm.protocal.c.bhu;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bic;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String lcc = "";

    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11019));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(11021));
        arrayList.add(Integer.valueOf(11031));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 11019:
                List W;
                boolean z2;
                bht com_tencent_mm_protocal_c_bht = new bht();
                try {
                    com_tencent_mm_protocal_c_bht.az(bArr);
                } catch (IOException e) {
                }
                bhu com_tencent_mm_protocal_c_bhu = new bhu();
                com_tencent_mm_protocal_c_bhu.ncH = com_tencent_mm_protocal_c_bht.ncH;
                if (com_tencent_mm_protocal_c_bhu.ncH) {
                    ak.yW();
                    W = c.wJ().W(com_tencent_mm_protocal_c_bht.mdw, com_tencent_mm_protocal_c_bht.mNN);
                } else {
                    ak.yW();
                    W = c.wJ().V(com_tencent_mm_protocal_c_bht.mdw, com_tencent_mm_protocal_c_bht.mNN);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < W.size()) {
                    com_tencent_mm_protocal_c_bhu.mBf.add(h.H((at) W.get(i2)));
                    i2++;
                }
                if (W.size() > 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com_tencent_mm_protocal_c_bhu.ncp = z2;
                try {
                    return com_tencent_mm_protocal_c_bhu.toByteArray();
                } catch (Throwable e2) {
                    v.a("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
            case 11020:
                a.cL(9, 0);
                a.sy(8);
                bhy com_tencent_mm_protocal_c_bhy = new bhy();
                try {
                    com_tencent_mm_protocal_c_bhy.az(bArr);
                    this.lcc = com_tencent_mm_protocal_c_bhy.mdw;
                    bhz com_tencent_mm_protocal_c_bhz = new bhz();
                    ak.yW();
                    List V = c.wJ().V(com_tencent_mm_protocal_c_bhy.mdw, com_tencent_mm_protocal_c_bhy.mNN);
                    int i3 = 0;
                    while (i3 < 10 && i3 < V.size()) {
                        com_tencent_mm_protocal_c_bhz.mBf.add(h.H((at) V.get(i3)));
                        i3++;
                    }
                    if (V.size() <= 10) {
                        z = false;
                    }
                    com_tencent_mm_protocal_c_bhz.ncp = z;
                    try {
                        return com_tencent_mm_protocal_c_bhz.toByteArray();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    return null;
                }
                break;
            case 11021:
                this.lcc = "";
                break;
            case 11031:
                a.cL(12, 0);
                a.sy(14);
                bib com_tencent_mm_protocal_c_bib = new bib();
                try {
                    com_tencent_mm_protocal_c_bib.az(bArr);
                } catch (IOException e4) {
                }
                ak.yW();
                at ek = c.wJ().ek(com_tencent_mm_protocal_c_bib.ncz);
                bic com_tencent_mm_protocal_c_bic = new bic();
                String iU = q.iU(ek.field_imgPath);
                com_tencent_mm_protocal_c_bic.ncT = o.e(iU, 0, true);
                com_tencent_mm_protocal_c_bic.ncz = com_tencent_mm_protocal_c_bib.ncz;
                com_tencent_mm_protocal_c_bic.mdy = new b(FileOp.c(iU, 0, -1));
                q.A(ek);
                try {
                    return com_tencent_mm_protocal_c_bic.toByteArray();
                } catch (IOException e5) {
                    return null;
                }
        }
        return null;
    }

    protected final boolean sA(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    protected final boolean sz(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
