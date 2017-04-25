package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.a.e;
import com.tencent.mm.bf.b;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.c.bhc;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhe;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11001));
        arrayList.add(Integer.valueOf(11004));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        Throwable e;
        if (i == 11001) {
            bhc com_tencent_mm_protocal_c_bhc = new bhc();
            try {
                com_tencent_mm_protocal_c_bhc.az(bArr);
            } catch (IOException e2) {
            }
            if (b.buL().nnc > com_tencent_mm_protocal_c_bhc.myF) {
                InputStream open;
                try {
                    open = aa.getContext().getAssets().open("color_emoji");
                    try {
                        byte[] d = com.tencent.mm.loader.stub.b.d(open);
                        e.c(open);
                        return d;
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            v.a("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            e.c(open);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            e.c(open);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                    v.a("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                    e.c(open);
                    return null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    e.c(open);
                    throw e;
                }
            }
        } else if (i == 11004) {
            a.sy(9);
            bhd com_tencent_mm_protocal_c_bhd = new bhd();
            try {
                com_tencent_mm_protocal_c_bhd.az(bArr);
            } catch (IOException e5) {
            }
            bhe com_tencent_mm_protocal_c_bhe = new bhe();
            f bmr = j.a.bmr();
            if (bmr != null) {
                for (c cVar : bmr.rj(com_tencent_mm_protocal_c_bhd.mjc)) {
                    if (!be.kS(cVar.EB())) {
                        com_tencent_mm_protocal_c_bhe.meA.add(cVar.EB());
                    }
                }
            }
            if (com_tencent_mm_protocal_c_bhe.meA.size() == 0) {
                qw qwVar = new qw();
                String[] strArr = new String[]{com_tencent_mm_protocal_c_bhd.mjc};
                qwVar.bsA.bsB = strArr;
                qwVar.bsA.aYt = 1;
                com.tencent.mm.sdk.c.a.nhr.z(qwVar);
            }
            try {
                return com_tencent_mm_protocal_c_bhe.toByteArray();
            } catch (IOException e6) {
            }
        }
        return null;
    }
}
