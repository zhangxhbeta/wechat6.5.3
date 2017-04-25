package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.pluginsdk.k.a.c.g;
import com.tencent.mm.pluginsdk.k.a.c.g.b;
import com.tencent.mm.pluginsdk.k.a.c.u;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k extends g<a> {
    private final a lDT = new a(this, 0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new u());

    private static final class a extends d<a> {
        protected a(a aVar) {
            super(aVar);
        }

        public final void run() {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", ((a) this.lEi).lCO);
            a aVar = (a) this.lEi;
            int i = aVar.aYo;
            int i2 = aVar.aYp;
            int i3 = aVar.aYq;
            try {
                l lVar;
                aVar = (a) this.lEi;
                l lVar2 = new l(aVar.aYo, aVar.aYp, aVar.filePath, aVar.lCP, aVar.lCQ, aVar.lCR, aVar.lCS, aVar.lCV, aVar.aYr, aVar.lCT, aVar.lCU, aVar.lCX, aVar.lCW, aVar.url, aVar.lCY, aVar.lCZ, aVar.aYq);
                if (lVar2.lDu) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", lVar2.lCO);
                    lVar2.lDU = lVar2.filePath + ".decompressed";
                    lVar2.state = 32;
                    if (lVar2.bnX() != null) {
                        lVar2.state = 16;
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.lCO);
                    }
                    lVar = lVar2;
                } else if (lVar2.lDv) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", lVar2.lCO);
                    lVar2.lDU = lVar2.filePath + ".decrypted";
                    lVar2.state = 32;
                    if (lVar2.bnX() != null) {
                        lVar2.state = 16;
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.lCO);
                    }
                    lVar = lVar2;
                } else {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", lVar2.lCO);
                    lVar2.lDU = lVar2.filePath;
                    lVar2.state = 32;
                    if (lVar2.bnX() != null) {
                        lVar2.state = 16;
                        v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.lCO);
                    }
                    lVar = lVar2;
                }
                v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.bnY(), lVar.lCO);
                if (16 != lVar.state) {
                    if (lVar.lDv) {
                        lVar.lDU = lVar.filePath;
                        lVar.lDV = lVar.filePath + ".decrypted";
                        lVar.state = 1;
                    } else if (lVar.lDu) {
                        lVar.lDU = lVar.filePath;
                        lVar.lDV = lVar.filePath + ".decompressed";
                        lVar.state = 2;
                    } else {
                        lVar.lDU = lVar.filePath;
                        lVar.state = 4;
                    }
                }
                String bnX = lVar.bnV().bnW().bnX();
                if (be.kS(bnX)) {
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath + ".decompressed");
                } else {
                    b.lDs.a(i, i2, bnX, i3);
                }
                if (Thread.interrupted()) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) this.lEi).lCO);
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath);
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath + ".decompressed");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (Thread.interrupted()) {
                    v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) this.lEi).lCO);
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath);
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(((a) this.lEi).filePath + ".decompressed");
                }
            }
        }
    }

    protected final /* synthetic */ d a(b bVar) {
        return new a((a) bVar);
    }

    k() {
    }

    final void a(a aVar) {
        if (Hd(aVar.lCO)) {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", aVar.lCO);
            return;
        }
        int i;
        if (!(aVar.lCP && aVar.aYq == aVar.lCS && aVar.lCS >= 0) && (aVar.lCP || !aVar.lCQ)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", aVar.lCO);
            super.b(aVar);
        }
    }

    protected final a bnU() {
        return this.lDT;
    }
}
