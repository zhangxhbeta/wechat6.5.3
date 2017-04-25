package com.tencent.mm.plugin.record.a;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public abstract class f<T extends a> {
    private boolean ipo = false;
    final int ipp = 3;
    private final int ipq = 300000;
    private SparseArray<b> ipr = new SparseArray();
    private LinkedList<T> ips = new LinkedList();

    public interface a {
        int aJB();
    }

    private final class b {
        int dph;
        final /* synthetic */ f ipt;
        long ipu;

        private b(f fVar) {
            this.ipt = fVar;
            this.ipu = SystemClock.elapsedRealtime();
            this.dph = this.ipt.ipp;
        }
    }

    protected abstract void a(T t);

    protected abstract List<T> aJz();

    static /* synthetic */ void a(f fVar) {
        if (fVar.ipo) {
            v.d("MicroMsg.RecordMsgBaseService", "is working, return");
            return;
        }
        b bVar;
        a aVar;
        if (fVar.ips.isEmpty()) {
            for (a aVar2 : fVar.aJz()) {
                bVar = (b) fVar.ipr.get(aVar2.aJB());
                if (bVar == null) {
                    fVar.ipr.put(aVar2.aJB(), new b());
                } else if (bVar.dph >= 0 || SystemClock.elapsedRealtime() - bVar.ipu >= ((long) fVar.ipq)) {
                    if (bVar.dph < 0) {
                        bVar.dph = fVar.ipp;
                    }
                }
                v.d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", new Object[]{Integer.valueOf(aVar2.aJB())});
                if (!fVar.ips.contains(aVar2)) {
                    fVar.ips.add(aVar2);
                }
            }
            v.i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", new Object[]{Integer.valueOf(fVar.ips.size())});
        }
        if (fVar.ips.isEmpty()) {
            v.i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
            fVar.finish();
            return;
        }
        byte b;
        aVar2 = (a) fVar.ips.removeFirst();
        bVar = (b) fVar.ipr.get(aVar2.aJB());
        if (bVar == null) {
            bVar = new b();
            fVar.ipr.put(aVar2.aJB(), bVar);
        }
        bVar.dph--;
        if (bVar.dph < 0) {
            if (((long) fVar.ipq) > SystemClock.elapsedRealtime() - bVar.ipu) {
                b = (byte) 0;
                if (b == (byte) 0) {
                    fVar.a(aVar2);
                } else {
                    fVar.run();
                }
            }
            bVar.dph = fVar.ipp - 1;
        }
        bVar.ipu = SystemClock.elapsedRealtime();
        b = (byte) 1;
        if (b == (byte) 0) {
            fVar.run();
        } else {
            fVar.a(aVar2);
        }
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ f ipt;

            {
                this.ipt = r1;
            }

            public final void run() {
                f.a(this.ipt);
            }

            public final String toString() {
                return super.toString() + "|tryDoJob";
            }
        });
    }

    protected final void aJA() {
        this.ipo = false;
        run();
    }

    final void finish() {
        this.ips.clear();
        this.ipr.clear();
        this.ipo = false;
    }
}
