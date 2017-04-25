package com.tencent.mm.plugin.product.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> hQu = new ArrayList();

    public d() {
        NH();
    }

    private void NH() {
        this.hQu.clear();
        ak.yW();
        String str = (String) c.vf().get(270340, "");
        v.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : be.g(str2.split(";"))) {
            if (!be.kS(str2)) {
                this.hQu.add(str2);
            }
        }
    }

    public final boolean aGr() {
        v.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.hQu.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.hQu) {
            if (!(be.kS(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        v.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        ak.yW();
        c.vf().set(270340, stringBuffer.toString());
        return true;
    }
}
