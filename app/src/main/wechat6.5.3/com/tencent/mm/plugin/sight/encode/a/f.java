package com.tencent.mm.plugin.sight.encode.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.plugin.sight.encode.a.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public final class f {
    public b iXd = b.Stop;
    SparseArray<WeakReference<a>> iXe = new SparseArray();
    ac iXf = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ f iXg;

        public final void handleMessage(Message message) {
            if (257 == message.what) {
                b bVar = (b) message.obj;
                for (int i = 0; i < this.iXg.iXe.size(); i++) {
                    a aVar = (a) ((WeakReference) this.iXg.iXe.valueAt(i)).get();
                    if (aVar != null) {
                        switch (bVar) {
                            case Start:
                                aVar.onStart();
                                break;
                            case Stop:
                                aVar.onStop();
                                break;
                            case Sent:
                                aVar.aPT();
                                break;
                            case Error:
                                aVar.onError();
                                break;
                            default:
                                break;
                        }
                    }
                }
            } else if (258 == message.what) {
                r0 = (a) message.obj;
                if (r0 != null) {
                    this.iXg.iXe.put(r0.hashCode(), new WeakReference(r0));
                }
            } else if (259 == message.what) {
                r0 = (a) message.obj;
                if (r0 != null) {
                    this.iXg.iXe.remove(r0.hashCode());
                }
            }
        }
    };

    public final void b(b bVar) {
        v.i("MicroMsg.SightMediaStatusHandler", "status change to %s", bVar.toString());
        this.iXd = bVar;
        this.iXf.sendMessage(this.iXf.obtainMessage(257, bVar));
    }
}
