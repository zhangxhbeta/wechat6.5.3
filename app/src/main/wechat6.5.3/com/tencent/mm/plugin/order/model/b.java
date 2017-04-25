package com.tencent.mm.plugin.order.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> hMP = new HashSet();

    public b() {
        amB();
    }

    private void amB() {
        this.hMP.clear();
        ak.yW();
        for (String str : be.g(((String) c.vf().get(204803, "")).split(";"))) {
            if (!(be.kS(str) || this.hMP.contains(str))) {
                this.hMP.add(str);
            }
        }
        ak.yW();
        c.vf().set(204817, Integer.valueOf(this.hMP.size()));
        v.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.hMP.size());
    }

    public final void aFJ() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.hMP.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!be.kS(str)) {
                stringBuffer.append(str + ";");
            }
        }
        ak.yW();
        c.vf().set(204803, stringBuffer.toString());
    }
}
