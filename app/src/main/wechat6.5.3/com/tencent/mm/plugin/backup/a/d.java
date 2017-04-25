package com.tencent.mm.plugin.backup.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.y;
import com.tencent.mm.plugin.backup.d.z;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class d extends b {
    private y edh = new y();
    public z edi = new z();

    public d(String str, LinkedList<Long> linkedList, LinkedList<String> linkedList2, LinkedList<String> linkedList3) {
        v.i("MicroMsg.BackupRequestSessionScene", "init sessionName:%s", linkedList);
        this.edh.eer = str;
        this.edh.efG = linkedList;
        this.edh.efH = linkedList2;
        this.edh.efI = linkedList3;
    }

    public final int getType() {
        return 13;
    }

    public final a Ud() {
        return this.edi;
    }

    public final a Ue() {
        return this.edh;
    }

    public final void Uf() {
        v.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd");
        e(0, 0, "success");
    }
}
