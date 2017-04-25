package com.tencent.mm.plugin.mmsight.model.a;

import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static int hnJ = 4;
    static int hnK = 4;
    boolean ecS = false;
    ac handler;
    HandlerThread[] hnL;
    int hnM = 0;
    private int hnN = 0;
    private LinkedList<b> hnO = new LinkedList();
    private a hnP;
    com.tencent.mm.plugin.mmsight.model.a.b.a hnQ = new com.tencent.mm.plugin.mmsight.model.a.b.a(this) {
        final /* synthetic */ a hnR;

        {
            this.hnR = r1;
        }

        public final void a(final b bVar) {
            this.hnR.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hnT;

                public final void run() {
                    a.a(this.hnT.hnR, bVar);
                }
            });
        }
    };

    public interface a {
        void output(byte[] bArr);
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        v.i("MicroMsg.ForwardMgr", "receive buf bufIndex: %d receiveIndex: %d", new Object[]{Integer.valueOf(bVar.hnX), Integer.valueOf(aVar.hnN)});
        if (aVar.hnN == bVar.hnX) {
            aVar.hnN++;
            aVar.hnP.output(bVar.hnV);
            aVar.aAe();
            return;
        }
        aVar.hnO.add(bVar);
        aVar.aAe();
    }

    public a(a aVar) {
        this.hnP = aVar;
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.t.a.ntG, Integer.valueOf(-1))).intValue();
        hnK = intValue;
        if (intValue == -1) {
            hnK = Runtime.getRuntime().availableProcessors();
            hnK = Math.min(hnJ, hnK);
            v.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from runtime %d, availableProcessors: %s", new Object[]{Integer.valueOf(hnK), Integer.valueOf(Runtime.getRuntime().availableProcessors())});
        } else {
            v.i("MicroMsg.ForwardMgr", "ForwardMgr THREAD_COUNT from config %d", new Object[]{Integer.valueOf(hnK)});
        }
        this.hnL = new HandlerThread[hnK];
        SightVideoJNI.initScaleAndRoateBuffer(hnK);
        for (intValue = 0; intValue < this.hnL.length; intValue++) {
            this.hnL[intValue] = e.bJ("BigSightMediaCodecMP4MuxRecorder_FrameBufProcessMgr_" + intValue, -1);
            this.hnL[intValue].start();
        }
        this.ecS = false;
    }

    private void aAe() {
        v.i("MicroMsg.ForwardMgr", "processBufList %d %d", new Object[]{Integer.valueOf(this.hnO.size()), Integer.valueOf(this.hnN)});
        while (this.hnO.size() != 0) {
            int i;
            v.i("MicroMsg.ForwardMgr", "loop processBufList %d %d", new Object[]{Integer.valueOf(this.hnO.size()), Integer.valueOf(this.hnN)});
            Iterator it = this.hnO.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.hnN == bVar.hnX) {
                    this.hnN++;
                    this.hnP.output(bVar.hnV);
                    this.hnO.remove(bVar);
                    i = 1;
                    continue;
                    break;
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return;
            }
        }
    }

    public final boolean aAf() {
        return this.hnN == this.hnM;
    }

    public final void stop() {
        int i = 0;
        v.i("MicroMsg.ForwardMgr", "stop FrameBufProcessMgr %s", new Object[]{be.bur().toString()});
        while (i < this.hnL.length) {
            if (this.hnL[i] != null) {
                this.hnL[i].quit();
                this.hnL[i] = null;
            }
            i++;
        }
        SightVideoJNI.releaseScaleAndRoateBuffer(hnK);
        this.ecS = true;
    }
}
