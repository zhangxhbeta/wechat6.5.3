package com.tencent.mm.plugin.luckymoney.b;

import android.os.Bundle;

public final class b {
    public Bundle gZY = new Bundle();
    public String mType;

    public b(String str) {
        this.mType = str;
    }

    public final void s(Bundle bundle) {
        this.gZY.putAll(bundle);
    }
}
