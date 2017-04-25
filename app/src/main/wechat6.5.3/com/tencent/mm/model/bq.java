package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public final class bq {
    public boolean aHp = false;
    public Set<a> cvH = new HashSet();

    public interface a {
        boolean Ae();
    }

    public final boolean a(a aVar) {
        if (!this.aHp) {
            return this.cvH.add(aVar);
        }
        v.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
        return false;
    }

    public final boolean b(a aVar) {
        if (!this.aHp) {
            return this.cvH.remove(aVar);
        }
        v.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
        return false;
    }
}
