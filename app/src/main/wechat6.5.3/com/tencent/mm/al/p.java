package com.tencent.mm.al;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends c<jx> {
    public p() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return HP();
    }

    private static boolean HP() {
        if (!ak.uz() || ak.uG()) {
            boolean z = false;
        } else {
            int i = 1;
        }
        if (i != 0) {
            ak.yW();
            if (be.ax(be.a((Long) com.tencent.mm.model.c.vf().get(68097, null), 0)) * 1000 > 3600000) {
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                LinkedList linkedList = new LinkedList();
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                byte[] d = e.d(stringBuilder.append(com.tencent.mm.model.c.xp()).append("eggresult.rep").toString(), 0, -1);
                if (d != null) {
                    try {
                        Iterator it = ((h) new h().az(d)).cUn.iterator();
                        while (it.hasNext()) {
                            afj com_tencent_mm_protocal_c_afj;
                            g gVar = (g) it.next();
                            if (gVar.cUl != 0) {
                                com_tencent_mm_protocal_c_afj = new afj();
                                com_tencent_mm_protocal_c_afj.itH = 17;
                                com_tencent_mm_protocal_c_afj.itR = gVar.cTZ + "," + gVar.cUl;
                                linkedList.add(com_tencent_mm_protocal_c_afj);
                            }
                            if (gVar.cUm != 0) {
                                com_tencent_mm_protocal_c_afj = new afj();
                                com_tencent_mm_protocal_c_afj.itH = 18;
                                com_tencent_mm_protocal_c_afj.itR = gVar.cTZ + "," + gVar.cUm;
                                linkedList.add(com_tencent_mm_protocal_c_afj);
                            }
                        }
                        stringBuilder = new StringBuilder();
                        ak.yW();
                        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(com.tencent.mm.model.c.xp()).append("eggresult.rep").toString());
                    } catch (Throwable e) {
                        v.e("MicroMsg.PostTaskReportEgg", "exception:%s", be.e(e));
                    }
                    if (!linkedList.isEmpty()) {
                        bl.a(linkedList);
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68097, Long.valueOf(be.Nh()));
                    }
                }
                return false;
            }
        }
        v.d("MicroMsg.PostTaskReportEgg", "report egg done");
        return false;
    }
}
