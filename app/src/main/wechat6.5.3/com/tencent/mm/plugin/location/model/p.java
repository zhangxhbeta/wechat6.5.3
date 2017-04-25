package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.pluginsdk.j.ab;
import com.tencent.mm.pluginsdk.j.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements ac {
    private List<ab> cJC = new LinkedList();
    private b gTl;
    private com.tencent.mm.sdk.platformtools.ac handler;
    private final String path;

    public p() {
        File file = new File(l.awm());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = l.awm() + "trackroominfolist.info";
        this.handler = new com.tencent.mm.sdk.platformtools.ac(Looper.getMainLooper());
        if (this.gTl != null) {
            return;
        }
        if (e.aR(this.path)) {
            try {
                this.gTl = (b) new b().az(e.d(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                v.a("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                this.gTl = new b();
                return;
            }
        }
        this.gTl = new b();
    }

    public final synchronized void a(ab abVar) {
        this.cJC.add(abVar);
    }

    public final synchronized void b(ab abVar) {
        this.cJC.remove(abVar);
    }

    public final synchronized LinkedList<String> vH(String str) {
        LinkedList<String> linkedList;
        Iterator it = this.gTl.gRH.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.biC.clone();
                break;
            }
        }
        linkedList = new LinkedList();
        return linkedList;
    }

    public final synchronized a vI(String str) {
        a aVar;
        Iterator it = this.gTl.gRH.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                break;
            }
        }
        aVar = null;
        return aVar;
    }

    public final synchronized void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        v.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[]{str, Integer.valueOf(linkedList.size()), Double.valueOf(d), Double.valueOf(d2)});
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator it = this.gTl.gRH.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.gTl.gRH.remove(aVar);
                } else {
                    aVar.biC = linkedList2;
                    aVar.gRG = str2;
                    aVar.latitude = d;
                    aVar.longitude = d2;
                }
                awx();
                G(str, str3, str4);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.biC = linkedList2;
            aVar.gRG = str2;
            aVar.latitude = d;
            aVar.longitude = d2;
            this.gTl.gRH.add(aVar);
        }
        awx();
        G(str, str3, str4);
    }

    private void G(String str, String str2, String str3) {
        for (final ab abVar : this.cJC) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ p gTp;

                public final void run() {
                    abVar.Gj(str4);
                }
            });
        }
    }

    private boolean awx() {
        v.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[]{Integer.valueOf(this.gTl.gRH.size())});
        if (this.gTl.gRH.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.gTl.toByteArray();
            e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean vJ(String str) {
        return vH(str).size() > 0;
    }

    public final boolean awy() {
        Iterator it = this.gTl.gRH.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((a) it.next()).biC.iterator();
            while (it2.hasNext()) {
                if (((String) it2.next()).equals(k.xF())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean bY(String str, String str2) {
        return vH(str).contains(str2);
    }

    public final String awz() {
        if (this.gTl != null) {
            return this.gTl.gRI;
        }
        return "";
    }

    public final void vK(String str) {
        if (this.gTl != null) {
            this.gTl.gRI = str;
        }
        awx();
    }
}
