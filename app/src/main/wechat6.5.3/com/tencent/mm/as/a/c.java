package com.tencent.mm.as.a;

import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    public static void a(n nVar, int i) {
        if (nVar == null) {
            v.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            return;
        }
        int i2;
        long Nj = be.Nj();
        k.KV();
        String lc = o.lc(nVar.getFileName());
        long j = 0;
        long j2 = 0;
        if (d.kR(lc)) {
            i2 = 1;
            b bVar = new b();
            j = bVar.kQ(lc);
            j2 = bVar.dfN != null ? bVar.dfN.dfK : 0;
        } else {
            v.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        long j3 = nVar.bmL;
        lc = n.kY(nVar.Lg());
        long j4 = (long) nVar.cyu;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j3).append(";").append(lc).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j).append(";");
        stringBuilder.append(j2).append(";").append(i);
        v.d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + be.az(Nj));
        g.iuh.h(11098, Integer.valueOf(8000), r0);
    }
}
