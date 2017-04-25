package com.tencent.mm.plugin.luckymoney.b;

import java.util.LinkedList;
import java.util.List;

public final class e {
    public static e had = new e();
    public List<a> eAR = new LinkedList();

    public interface a {
        void b(String str, boolean z, String str2);
    }

    private e() {
    }

    public final void a(String str, boolean z, String str2) {
        for (int i = 0; i < this.eAR.size(); i++) {
            ((a) this.eAR.get(i)).b(str, z, str2);
        }
    }
}
