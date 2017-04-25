package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    public ac hzT;
    public a hzU = new a();
    public a hzt;

    private class a {
        public int angle;
        public boolean fHM;
        public Bitmap ggw;
        public int h;
        final /* synthetic */ j hzV;
        public int hzW;
        public int hzX;
        public int[] hzY;
        public int w;

        private a(j jVar) {
            this.hzV = jVar;
        }
    }

    public class b implements Runnable {
        final /* synthetic */ j hzV;

        public b(j jVar) {
            this.hzV = jVar;
        }

        public final void run() {
            this.hzV.hzU.fHM = true;
            if (this.hzV.hzU.ggw != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.hzV.hzt != null) {
                    this.hzV.hzt.a(k.xF(), this.hzV.hzU.ggw, this.hzV.hzU.hzX, this.hzV.hzU.angle);
                }
                if (System.currentTimeMillis() - currentTimeMillis > 30) {
                    v.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
                this.hzV.hzU.fHM = false;
            }
            try {
                Thread.sleep(20);
            } catch (Throwable e) {
                v.a("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
            }
        }
    }

    public j(a aVar) {
        this.hzt = aVar;
    }
}
