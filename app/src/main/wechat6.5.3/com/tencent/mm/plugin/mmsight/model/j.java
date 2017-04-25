package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.as.r;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.sdk.platformtools.v;

public final class j implements r {
    public final void lt(String str) {
        final n kZ = k.KV().kZ(str);
        if (kZ != null) {
            k.KV();
            final String lc = o.lc(str);
            ahn com_tencent_mm_protocal_c_ahn = kZ.dhU;
            VideoTransPara Ej = d.En().Ej();
            if (com_tencent_mm_protocal_c_ahn != null) {
                v.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ahn.mHe), str, lc});
                if (com_tencent_mm_protocal_c_ahn.mHe > 1) {
                    p.lh(str);
                    return;
                }
            }
            if (i.a(lc, Ej, com_tencent_mm_protocal_c_ahn, new f(this) {
                final /* synthetic */ j hnv;

                public final boolean azE() {
                    v.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[]{lc});
                    kZ.cyu = o.le(lc);
                    k.KV().b(kZ);
                    return true;
                }
            })) {
                if (com_tencent_mm_protocal_c_ahn != null) {
                    com_tencent_mm_protocal_c_ahn.mHe++;
                    kZ.dhU = com_tencent_mm_protocal_c_ahn;
                }
                k.KV().b(kZ);
                i.tv(kZ.dhL);
                if (i.b(lc, Ej, com_tencent_mm_protocal_c_ahn, new f(this) {
                    final /* synthetic */ j hnv;

                    public final boolean azE() {
                        i.tw(kZ.dhL);
                        v.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[]{lc});
                        kZ.cyu = o.le(lc);
                        k.KV().b(kZ);
                        return true;
                    }
                }) < 0) {
                    v.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                    g.iuh.a(440, 45, 1, false);
                    p.lh(str);
                }
            }
        }
    }
}
