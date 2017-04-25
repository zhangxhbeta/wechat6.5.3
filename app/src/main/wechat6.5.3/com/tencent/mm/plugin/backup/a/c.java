package com.tencent.mm.plugin.backup.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.e;
import com.tencent.mm.plugin.backup.d.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends b {
    private e edf = new e();
    private f edg = new f();

    public c(LinkedList<String> linkedList) {
        v.i("MicroMsg.BackupRequestSessionScene", "init sessionName:%s", linkedList);
        this.edf.eex = linkedList;
        this.edf.eey = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.edf.eey.add(Long.valueOf(0));
            this.edf.eey.add(Long.valueOf(0));
        }
    }

    public final int getType() {
        return 11;
    }

    public final a Ud() {
        return this.edg;
    }

    public final a Ue() {
        return this.edf;
    }

    public final void Uf() {
        v.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd");
        com.tencent.mm.plugin.backup.g.b.UL().ebp = this.edg.eex;
        com.tencent.mm.plugin.backup.g.b.UL().ebq = this.edg.eey;
        v.i("MicroMsg.BackupRequestSessionScene", "summerbak requestsession resp, sessionName size:%d, name:%s", Integer.valueOf(this.edg.eex.size()), this.edg.eex.toString());
        v.i("MicroMsg.BackupRequestSessionScene", "summerbak requestsession resp, TimeInterval:%s", this.edg.eey.toString());
        e(0, 0, "BackupRequestSession ok");
    }
}
