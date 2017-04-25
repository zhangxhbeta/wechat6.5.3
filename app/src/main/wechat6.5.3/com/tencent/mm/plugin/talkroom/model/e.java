package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.talkroom.a.a;
import com.tencent.mm.plugin.talkroom.a.b;
import com.tencent.mm.pluginsdk.j.v;
import com.tencent.mm.pluginsdk.j.w;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements w {
    private ac handler;
    private b kkg;
    private HashSet<v> kkh = new HashSet();
    private final String path;

    public e() {
        File file = new File(b.aZY());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = b.aZY() + "talkroomMemberList.info";
        this.handler = new ac(Looper.getMainLooper());
        if (this.kkg != null) {
            return;
        }
        if (com.tencent.mm.a.e.aR(this.path)) {
            try {
                this.kkg = (b) new b().az(com.tencent.mm.a.e.d(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
                this.kkg = new b();
                return;
            }
        }
        this.kkg = new b();
    }

    public final synchronized void a(v vVar) {
        this.kkh.add(vVar);
    }

    public final synchronized void b(v vVar) {
        this.kkh.remove(vVar);
    }

    public final synchronized boolean CB(String str) {
        boolean z;
        Iterator it = this.kkg.kjT.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str) && aVar.hGO == 0) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final synchronized boolean bad() {
        boolean z;
        Iterator it = this.kkg.kjT.iterator();
        loop0:
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.hGO == 0) {
                Iterator it2 = aVar.biC.iterator();
                while (it2.hasNext()) {
                    if (k.xF().equals(((azi) it2.next()).gln)) {
                        z = true;
                        break loop0;
                    }
                }
                continue;
            }
        }
        z = false;
        return z;
    }

    public final synchronized LinkedList<azi> CC(String str) {
        LinkedList<azi> linkedList;
        Iterator it = this.kkg.kjT.iterator();
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

    public final synchronized void a(String str, LinkedList<azi> linkedList, String str2, String str3, int i) {
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[]{str, Integer.valueOf(linkedList.size())});
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator it = this.kkg.kjT.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.kkg.kjT.remove(aVar);
                } else {
                    aVar.biC = linkedList2;
                    aVar.hGO = i;
                }
                awx();
                G(str, str2, str3);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.biC = linkedList2;
            aVar.hGO = i;
            this.kkg.kjT.add(aVar);
        }
        awx();
        G(str, str2, str3);
    }

    private void G(String str, String str2, String str3) {
        Iterator it = this.kkh.iterator();
        while (it.hasNext()) {
            final v vVar = (v) it.next();
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ e kkj;

                public final void run() {
                    vVar.y(str4, str5, str6);
                }
            });
        }
    }

    private boolean awx() {
        if (this.kkg.kjT.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.kkg.toByteArray();
            com.tencent.mm.a.e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
            return false;
        }
    }
}
