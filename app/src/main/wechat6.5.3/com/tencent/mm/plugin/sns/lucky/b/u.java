package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.model.bo.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import java.math.BigInteger;

public final class u implements b {
    public final void a(a aVar) {
        if (aVar == null || aVar.czu == null || aVar.czu.mbW == null) {
            v.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            return;
        }
        String a = m.a(aVar.czu.mbW);
        v.d("MicroMsg.SimpleExperimentLsn", "recv addMsg " + a);
        String J = J(a, "<TimelineObject", "</TimelineObject>");
        if (be.kS(J)) {
            v.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            return;
        }
        String J2 = J(a, "<RecXml", "</RecXml>");
        if (be.kS(J2)) {
            v.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            return;
        }
        a = J(a, "<ADInfo", "</ADInfo>");
        if (be.kS(a)) {
            v.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            return;
        }
        azr ko = d.ko(J);
        apu com_tencent_mm_protocal_c_apu = new apu();
        com_tencent_mm_protocal_c_apu.mPk = m.lY(a);
        awp com_tencent_mm_protocal_c_awp = new awp();
        com_tencent_mm_protocal_c_apu.mPj = com_tencent_mm_protocal_c_awp;
        com_tencent_mm_protocal_c_awp.mTX = m.lY(J2);
        awa com_tencent_mm_protocal_c_awa = new awa();
        com_tencent_mm_protocal_c_awa.mjq = new BigInteger(ko.gID).longValue();
        com_tencent_mm_protocal_c_awa.hNS = ko.hNS;
        com_tencent_mm_protocal_c_awa.mdw = ko.gln;
        com_tencent_mm_protocal_c_awa.mTg = m.H(J.getBytes());
        com_tencent_mm_protocal_c_awp.mSF = com_tencent_mm_protocal_c_awa;
        com.tencent.mm.plugin.sns.e.a.b(com_tencent_mm_protocal_c_apu);
    }

    private static String J(String str, String str2, String str3) {
        if (be.kS(str) || be.kS(str2) || be.kS(str3)) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            return "";
        }
        return str.substring(indexOf, indexOf2 + str3.length());
    }
}
