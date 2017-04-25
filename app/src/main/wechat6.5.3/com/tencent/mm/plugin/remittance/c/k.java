package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class k {
    public static void yF(String str) {
        if (!be.kS(str)) {
            String aKf = aKf();
            v.d("Micromsg.RemittanceLogic", "cur friendsListStr=" + aKf);
            StringBuilder stringBuilder = new StringBuilder();
            if (!be.kS(aKf)) {
                String[] split = aKf.split(",");
                if (split != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!str.equals(split[i2])) {
                            stringBuilder.append(split[i2]);
                            stringBuilder.append(",");
                            i++;
                            if (i >= 4) {
                                break;
                            }
                        }
                    }
                }
            }
            stringBuilder.insert(0, ",");
            stringBuilder.insert(0, str);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            v.d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
            ak.yW();
            c.vf().set(327733, stringBuilder.toString());
            ak.yW();
            c.vf().iB(true);
        }
    }

    public static String aKf() {
        ak.yW();
        return be.ma((String) c.vf().get(327733, null));
    }
}
