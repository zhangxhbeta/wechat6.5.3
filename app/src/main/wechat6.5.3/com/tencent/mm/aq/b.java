package com.tencent.mm.aq;

import com.tencent.mm.c.b.g;
import com.tencent.mm.c.c.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class b implements a {
    public BlockingQueue<g.a> daj = new ArrayBlockingQueue(1024);
    public String mFileName = null;

    public final boolean AZ() {
        v.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        d dVar = new d();
        ak.yW();
        String wX = c.wX();
        try {
            v.i("MicroMsg.SpeexEncoderWorker", "path " + wX);
            File file = new File(wX);
            if (!file.exists()) {
                file.mkdir();
            }
            dVar.bA(wX + this.mFileName + ".temp");
            while (this.daj.size() > 0) {
                g.a aVar = (g.a) this.daj.poll();
                if (aVar.buf != null && aVar.aUT > 0) {
                    dVar.a(aVar, 0);
                }
            }
            dVar.pv();
            try {
                new File(wX + this.mFileName + ".temp").renameTo(new File(wX + this.mFileName + ".spx"));
            } catch (Throwable e) {
                v.e("MicroMsg.SpeexEncoderWorker", "exception:%s", be.e(e));
            }
            d.JU().start();
        } catch (Exception e2) {
            v.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", e2);
        }
        return true;
    }

    public final boolean Ba() {
        return false;
    }
}
