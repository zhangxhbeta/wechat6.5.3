package com.tencent.mm.plugin.notification.b;

import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class b {
    int currentIndex;
    public ArrayList<Long> hIJ;

    public b() {
        this.currentIndex = 0;
        this.hIJ = new ArrayList();
        this.currentIndex = 0;
    }

    public final void cp(long j) {
        v.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", new Object[]{Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.hIJ.size())});
        this.hIJ.add(Long.valueOf(j));
    }

    public final long aEs() {
        long j = -1;
        if (this.hIJ.size() > 0 && this.currentIndex < this.hIJ.size()) {
            j = ((Long) this.hIJ.get(this.currentIndex)).longValue();
        }
        v.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", new Object[]{Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.hIJ.size())});
        this.currentIndex++;
        return j;
    }

    public final boolean cq(long j) {
        return this.hIJ.contains(Long.valueOf(j));
    }

    public final void clear() {
        this.hIJ.clear();
        this.currentIndex = 0;
    }

    public final long get(int i) {
        return ((Long) this.hIJ.get(i)).longValue();
    }

    public final void remove(long j) {
        this.hIJ.remove(Long.valueOf(j));
    }
}
