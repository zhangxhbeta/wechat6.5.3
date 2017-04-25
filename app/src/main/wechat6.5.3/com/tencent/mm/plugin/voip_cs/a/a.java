package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.mm.e.a.qg;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class a extends c<qg> {
    public a() {
        this.nhz = qg.class.getName().hashCode();
    }

    private static boolean a(qg qgVar) {
        if ((qgVar instanceof qg) && ak.uz()) {
            d bec = b.bec();
            Object obj = qgVar.brv.brw;
            if (!(obj == null || obj.length == 0)) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                bes com_tencent_mm_protocal_c_bes = new bes();
                try {
                    com_tencent_mm_protocal_c_bes.az(obj2);
                    v.i("MicroMsg.voipcs.VoipCSService", "notify status = " + com_tencent_mm_protocal_c_bes.naD + ",notifySeq = " + bec.kDY);
                    bez com_tencent_mm_protocal_c_bez = new bez();
                    com_tencent_mm_protocal_c_bez.nat = com_tencent_mm_protocal_c_bes.nat;
                    com_tencent_mm_protocal_c_bez.mqT = com_tencent_mm_protocal_c_bes.mqT;
                    com_tencent_mm_protocal_c_bez.naB = com_tencent_mm_protocal_c_bes.naB;
                    com_tencent_mm_protocal_c_bez.naD = com_tencent_mm_protocal_c_bes.naD;
                    com_tencent_mm_protocal_c_bez.naE = com_tencent_mm_protocal_c_bes.naE;
                    com_tencent_mm_protocal_c_bez.naF = com_tencent_mm_protocal_c_bes.naF;
                    com_tencent_mm_protocal_c_bez.naC = com_tencent_mm_protocal_c_bes.naC;
                    bec.a(com_tencent_mm_protocal_c_bez);
                } catch (IOException e) {
                    v.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[]{e});
                }
            }
        }
        return false;
    }
}
