package com.c.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b extends a {
    private z aHl;

    private static class a implements Runnable {
        private final WeakReference<b> aHm;
        private final p aHn;

        private a(b bVar, p pVar) {
            if (bVar == null || pVar == null) {
                throw new Exception("CoreAssembly: HandleMsgTask: null arg");
            }
            this.aHm = new WeakReference(bVar);
            this.aHn = pVar;
        }

        public final void run() {
            b bVar = (b) this.aHm.get();
            if (bVar != null) {
                switch (this.aHn.what) {
                    case 202:
                        f fVar = (f) this.aHn;
                        if (fVar.aKK == 1) {
                            bVar.a(fVar.aKL, fVar.aKk, fVar.aKl);
                            return;
                        } else {
                            bVar.a(fVar.aKK, fVar.aJX, fVar.aKk, fVar.aKl);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    abstract void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2);

    abstract void a(float f, float f2, int i, float f3, float f4, float f5, long j);

    abstract void a(int i, String str, long j, long j2);

    abstract void a(x xVar, long j, long j2);

    abstract void a(List<ScanResult> list, long j, long j2);

    b() {
        super(ab.nI(), r.nl(), u.nC(), k.nh());
    }

    synchronized void a(Handler handler, a aVar) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.aHl = z.b(handler);
        super.a(handler, aVar);
    }

    final void a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    final void a(a aVar, a[] aVarArr) {
        aVarArr[0] = aVar;
        aVarArr[1] = null;
        aVarArr[2] = null;
        aVarArr[3] = a(aVar);
    }

    public void a(p pVar) {
        switch (pVar.what) {
            case MMGIFException.D_GIF_ERR_OPEN_FAILED /*101*/:
                a(((a) pVar).aNV, pVar.aKk, pVar.aKl);
                return;
            case 201:
                b(pVar);
                return;
            case 202:
                b(pVar);
                return;
            case 301:
                e eVar = (e) pVar;
                a(eVar.x, eVar.y, eVar.aMN, eVar.aML, eVar.aMM, eVar.aJq, eVar.aKl);
                return;
            case 401:
                b bVar = (b) pVar;
                a(bVar.lat, bVar.lng, Double.valueOf(bVar.aJo).intValue(), Math.round(bVar.aJp), Math.round(bVar.aJq), bVar.aJs, bVar.aJt, bVar.aJr, bVar.aJu, bVar.aKl);
                return;
            default:
                return;
        }
    }

    a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(Math.max(aVar.aHt, 10000));
    }

    private void b(p pVar) {
        if (this.aHl != null) {
            try {
                this.aHl.execute(new a(pVar));
            } catch (Exception e) {
            }
        }
    }
}
