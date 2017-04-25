package com.tencent.mm.ui.f;

import com.tencent.mm.ui.f.e.b;

public abstract class a implements b {
    public /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (getPriority() < bVar.getPriority()) {
            return -1;
        }
        return getPriority() > bVar.getPriority() ? 1 : 0;
    }
}
