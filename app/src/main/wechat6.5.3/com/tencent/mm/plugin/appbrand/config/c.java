package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.protocal.c.jf;
import com.tencent.mm.sdk.platformtools.be;
import java.util.Iterator;
import java.util.List;

public final class c {
    public String dCN;
    public String dCO;
    public String dCP;
    public String dCQ;
    public String dCR;
    public Integer dCS;
    public Integer dCT;
    public bjc dCU;
    public bjf dCV;
    public gm dCW;
    private String dCX = null;

    public final List<bjg> Pw() {
        return this.dCW == null ? null : this.dCW.mhi;
    }

    public final String Px() {
        Object obj = null;
        if (!(this.dCV == null || be.bP(this.dCV.moH))) {
            obj = this.dCV.moH;
        }
        if (be.kS(this.dCX) && !be.bP(obj)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = obj.iterator();
            while (it.hasNext()) {
                jf jfVar = (jf) it.next();
                str = be.kS(jfVar.mlw) ? jfVar.mlv : jfVar.mlw;
                if (!be.kS(str)) {
                    stringBuilder.append("、");
                    stringBuilder.append(str);
                }
            }
            str = stringBuilder.toString();
            if (!be.kS(str)) {
                str = str.replaceFirst("、", "");
            }
            this.dCX = str;
        }
        return be.ma(this.dCX);
    }
}
