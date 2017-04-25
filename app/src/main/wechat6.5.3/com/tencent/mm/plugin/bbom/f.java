package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.ax;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.at;

public final class f implements com.tencent.mm.plugin.f.a.a.f {
    private String enX = null;

    public f(String str) {
        this.enX = str;
    }

    public final void a(aih com_tencent_mm_protocal_c_aih, at atVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append("<strangerantispamticket ticket=\"" + this.enX + "\"></strangerantispamticket>");
        stringBuilder.append(be.ma(ax.zq()));
        String str = (be.kS(com_tencent_mm_protocal_c_aih.mbZ) || !com_tencent_mm_protocal_c_aih.mbZ.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : com_tencent_mm_protocal_c_aih.mbZ;
        com_tencent_mm_protocal_c_aih.mbZ = str;
        com_tencent_mm_protocal_c_aih.mbZ = com_tencent_mm_protocal_c_aih.mbZ.replace("<msgsource>", stringBuilder.toString());
    }
}
