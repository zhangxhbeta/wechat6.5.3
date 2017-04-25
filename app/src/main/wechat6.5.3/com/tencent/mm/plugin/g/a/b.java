package com.tencent.mm.plugin.g.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.g.a.a.a {
    public List<String> cOD = new LinkedList();
    public Map<String, List<a>> ihu = new HashMap();
    String ihv;
    public ac ihw = new ac(Looper.getMainLooper());
    a ihx;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ b ihA;
        final /* synthetic */ String ihy;
        final /* synthetic */ a ihz;

        public AnonymousClass2(b bVar, String str, a aVar) {
            this.ihA = bVar;
            this.ihy = str;
            this.ihz = aVar;
        }

        public final void run() {
            b bVar = this.ihA;
            String str = this.ihy;
            a aVar = this.ihz;
            List<a> list = (List) bVar.ihu.get(str);
            if (list != null) {
                for (a aVar2 : list) {
                    if (aVar2 != null && aVar2 == aVar) {
                        list.remove(aVar2);
                        break;
                    }
                }
            } else {
                v.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
            }
            if (list != null && list.isEmpty()) {
                bVar.ihu.remove(str);
                bVar.cOD.remove(str);
                if (bVar.ihv != null && bVar.ihv.equals(str)) {
                    a aVar3 = bVar.ihx;
                    v.i("MicroMsg.scanner.DecodeFile", "cancelled");
                    aVar3.ik = true;
                    bVar.ihx = null;
                }
                bVar.aID();
            }
        }
    }

    public interface a {
        void g(String str, String str2, int i, int i2);

        void yo(String str);
    }

    public final void a(final String str, final a aVar) {
        v.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(aVar.hashCode())});
        if (be.kS(str)) {
            v.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
        } else {
            this.ihw.post(new Runnable(this) {
                final /* synthetic */ b ihA;

                public final void run() {
                    b bVar = this.ihA;
                    String str = str;
                    a aVar = aVar;
                    if (bVar.ihu.containsKey(str)) {
                        List<a> list = (List) bVar.ihu.get(str);
                        if (list != null) {
                            if (list != null) {
                                Object obj;
                                if (list != null && list.size() != 0) {
                                    for (a aVar2 : list) {
                                        if (aVar2 != null && aVar2 == aVar) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    v.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                                }
                                obj = null;
                                if (obj == null) {
                                    list.add(aVar);
                                }
                            }
                            v.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                        }
                        bVar.aID();
                        return;
                    }
                    List linkedList = new LinkedList();
                    linkedList.add(aVar);
                    bVar.ihu.put(str, linkedList);
                    bVar.cOD.add(str);
                    bVar.aID();
                }
            });
        }
    }

    final void aID() {
        if (this.ihx != null) {
            v.d("MicroMsg.FileScanQueueService", "it is scanning");
        } else if (this.ihu.isEmpty()) {
            v.d("MicroMsg.FileScanQueueService", "queue is empty");
        } else {
            this.ihv = (String) this.cOD.get(0);
            this.cOD.remove(0);
            this.ihx = new a();
            a aVar = this.ihx;
            String str = this.ihv;
            v.i("MicroMsg.scanner.DecodeFile", "start decode file: " + str);
            aVar.ihq = this;
            ad.o(new com.tencent.mm.plugin.g.a.a.AnonymousClass1(aVar, str));
        }
    }

    public final int a(final d dVar) {
        this.ihw.post(new Runnable(this) {
            final /* synthetic */ b ihA;

            public final void run() {
                b bVar = this.ihA;
                d dVar = dVar;
                v.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", new Object[]{bVar.ihv, dVar});
                List<a> list = (List) bVar.ihu.get(bVar.ihv);
                if (list != null && dVar != null) {
                    v.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", new Object[]{Integer.valueOf(list.size())});
                    for (a g : list) {
                        g.g(bVar.ihv, dVar.bfz, dVar.aYV, dVar.aYW);
                    }
                } else if (list != null) {
                    for (a g2 : list) {
                        g2.yo(bVar.ihv);
                    }
                }
                bVar.ihu.remove(bVar.ihv);
                bVar.ihv = null;
                bVar.ihx = null;
                bVar.aID();
            }
        });
        return 0;
    }
}
