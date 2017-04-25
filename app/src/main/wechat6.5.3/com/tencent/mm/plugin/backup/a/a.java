package com.tencent.mm.plugin.backup.a;

import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.s;
import com.tencent.mm.plugin.backup.d.t;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class a extends b {
    private s ecM = new s();
    private t ecN = new t();

    public a(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList) {
        v.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size()));
        this.ecM.eer = str;
        this.ecM.efv = j;
        this.ecM.efw = j2;
        this.ecM.efx = str2;
        this.ecM.efy = str3;
        this.ecM.efg = linkedList;
    }

    public final int getType() {
        return 15;
    }

    public final com.tencent.mm.ba.a Ud() {
        return this.ecN;
    }

    public final com.tencent.mm.ba.a Ue() {
        return this.ecM;
    }

    public final void Uf() {
        v.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        e(0, 0, "success");
    }
}
