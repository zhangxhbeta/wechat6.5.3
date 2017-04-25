package com.tencent.mm.bg;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class h {
    private ah aSW = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ h nxY;

        {
            this.nxY = r1;
        }

        public final boolean oU() {
            if (this.nxY.nxF.isOpen()) {
                this.nxY.bxZ();
            }
            return false;
        }
    }, false);
    private String nmg = null;
    g nxF;
    private BlockingQueue<a> nxX = new LinkedBlockingQueue();

    public static class a {
        public int nkN;
        public String nmc;
        public String nme;
        public String nxZ;
        public String[] nya;
        public ContentValues values;

        public final void F(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                this.nya = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.nya[i] = new String(strArr[i]);
                }
            }
        }
    }

    public h(g gVar, String str) {
        this.nxF = gVar;
        this.nmg = str;
    }

    public final int bxZ() {
        v.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.nmg, Boolean.valueOf(this.nxF.inTransaction()), Integer.valueOf(this.nxX.size()));
        if (!this.nxX.isEmpty()) {
            long j;
            if (this.nxF.inTransaction()) {
                j = 0;
            } else {
                j = this.nxF.er(Thread.currentThread().getId());
            }
            while (!this.nxX.isEmpty()) {
                a aVar = (a) this.nxX.poll();
                if (aVar == null) {
                    v.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.nmg);
                } else if (this.nxF == null || !this.nxF.isOpen()) {
                    v.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.nmg);
                } else if (aVar.nkN == 2) {
                    this.nxF.insert(this.nmg, aVar.nmc, aVar.values);
                } else if (aVar.nkN == 5) {
                    this.nxF.delete(this.nmg, aVar.nxZ, aVar.nya);
                } else if (aVar.nkN == 1) {
                    this.nxF.dF(this.nmg, aVar.nme);
                } else if (aVar.nkN == 4) {
                    this.nxF.replace(this.nmg, aVar.nmc, aVar.values);
                } else if (aVar.nkN == 3) {
                    this.nxF.update(this.nmg, aVar.values, aVar.nxZ, aVar.nya);
                }
            }
            if (j > 0) {
                this.nxF.es(j);
            }
        }
        return 0;
    }

    final int a(a aVar) {
        this.nxX.add(aVar);
        if (this.nxX.size() >= 40) {
            bxZ();
        }
        if (this.aSW.btC()) {
            this.aSW.ea(60000);
        }
        return 0;
    }
}
