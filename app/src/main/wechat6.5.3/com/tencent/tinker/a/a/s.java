package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.t.a.a;

public final class s extends a<s> {
    public String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.value.compareTo(((s) obj).value);
    }

    public s(int i, String str) {
        super(i);
        this.value = str;
    }

    public final int bOL() {
        try {
            return (o.yS(this.value.length()) + ((int) q.Qu(this.value))) + 1;
        } catch (Throwable e) {
            throw new j(e);
        }
    }
}
