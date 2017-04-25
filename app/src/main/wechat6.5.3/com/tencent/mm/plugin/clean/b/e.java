package com.tencent.mm.plugin.clean.b;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.b.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.File;
import java.util.ArrayList;

public final class e extends Thread implements com.tencent.mm.plugin.clean.b.a.a.a {
    private ac cnC = new ac(Looper.getMainLooper());
    private g eUD;
    private ArrayList<a> eUE;
    private int eUF = 0;
    private b eUr;
    private int eUt = 0;
    private int eUu = 0;
    private boolean eUv;
    private long endTime = 0;
    private long startTime = 0;

    class a extends com.tencent.mm.plugin.clean.b.a.a {
        final /* synthetic */ e eUG;
        private a eUH;

        public a(e eVar, a aVar) {
            this.eUG = eVar;
            super(eVar);
            this.eUH = aVar;
        }

        public final void execute() {
            ak.yW();
            at ek = c.wJ().ek(this.eUH.aYG);
            if (ek.field_msgId != 0) {
                ek.bNr |= 1;
                ek.bKL = true;
                ak.yW();
                c.wJ().a(this.eUH.aYG, ek);
            }
            File file = new File(this.eUH.filePath);
            e.a(this.eUG, file.length());
            file.delete();
        }
    }

    static /* synthetic */ int a(e eVar, long j) {
        int i = (int) (((long) eVar.eUF) + j);
        eVar.eUF = i;
        return i;
    }

    public e(b bVar, g gVar, ArrayList<a> arrayList) {
        this.eUr = bVar;
        this.eUD = gVar;
        this.eUE = arrayList;
    }

    public final void run() {
        this.startTime = System.currentTimeMillis();
        this.eUt = this.eUE.size();
        v.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", new Object[]{Integer.valueOf(this.eUt)});
        if (this.eUt == 0) {
            adH();
            return;
        }
        int i = 0;
        while (!this.eUv && i < this.eUE.size()) {
            v.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), ((a) this.eUE.get(i)).filePath});
            a aVar = new a(this, r0);
            while (!this.eUr.a(aVar)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            v.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", new Object[]{r0.filePath});
            i++;
        }
    }

    private void adH() {
        this.endTime = System.currentTimeMillis();
        v.i("MicroMsg.DeleteFileController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.eUD != null && !this.eUv) {
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ e eUG;

                {
                    this.eUG = r1;
                }

                public final void run() {
                    this.eUG.eUD.aR((long) this.eUG.eUF);
                }
            });
        }
    }

    public final void adU() {
        v.i("MicroMsg.DeleteFileController", "stop analyseController");
        this.eUv = true;
        interrupt();
    }

    public final void adG() {
        interrupt();
        this.eUu++;
        if (!(this.eUD == null || this.eUv)) {
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ e eUG;

                {
                    this.eUG = r1;
                }

                public final void run() {
                    this.eUG.eUD.bv(this.eUG.eUu, this.eUG.eUt);
                }
            });
        }
        if (this.eUu == this.eUt) {
            adH();
        }
    }
}
