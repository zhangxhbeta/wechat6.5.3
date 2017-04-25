package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import junit.framework.Assert;

public final class l extends a {
    private final long cAs = 15000;
    private c fys = null;
    boolean fyt = false;
    boolean fyu = false;
    Runnable fyv = new Runnable(this) {
        final /* synthetic */ l fyw;

        {
            this.fyw = r1;
        }

        public final void run() {
            this.fyw.fyt = true;
            if (!this.fyw.fyu) {
                this.fyw.fys.a(-1, -1, -2, "TimeOut", null);
            }
        }

        public final String toString() {
            return super.toString() + "|mAsyncTimeOut";
        }
    };

    public l(c cVar) {
        Assert.assertNotNull(cVar);
        this.fys = cVar;
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        if (!this.fyu && !this.fyt) {
            ak.vA().btx().removeCallbacks(this.fyv);
            final long j2 = j;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            final p pVar2 = pVar;
            ak.vA().btx().post(new Runnable(this) {
                final /* synthetic */ l fyw;

                public final void run() {
                    this.fyw.fys.a(j2, i3, i4, str2, pVar2);
                }

                public final String toString() {
                    return super.toString() + "|onTaskEnd";
                }
            });
        }
    }
}
