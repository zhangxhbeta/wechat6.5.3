package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.nio.charset.Charset;

public final class t {
    public static i f(a aVar) {
        i iVar;
        Exception exception;
        i iVar2 = new i();
        ak.yW();
        String str = (String) c.vf().get(aVar, null);
        if (str == null) {
            v.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            return iVar2;
        }
        try {
            iVar = (i) new i().az(str.getBytes(Charset.forName("ISO-8859-1")));
            if (iVar == null) {
                try {
                    iVar = new i();
                } catch (Exception e) {
                    Exception exception2 = e;
                    iVar2 = iVar;
                    exception = exception2;
                    v.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
                    iVar = iVar2;
                    if (iVar == null) {
                        return iVar;
                    }
                    return new i();
                }
            }
        } catch (Exception e2) {
            exception = e2;
            v.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
            iVar = iVar2;
            if (iVar == null) {
                return new i();
            }
            return iVar;
        }
        if (iVar == null) {
            return new i();
        }
        return iVar;
    }
}
