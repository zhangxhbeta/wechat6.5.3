package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.backup.d.h;
import com.tencent.mm.plugin.backup.d.i;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends b {
    public h eef = new h();
    public i eeg = new i();

    public c(String str) {
        v.i("MicroMsg.BackupStartScene", "init id:%s", str);
        this.eef.ID = str;
    }

    public final int getType() {
        return 3;
    }

    public final a Ud() {
        return this.eeg;
    }

    public final a Ue() {
        return this.eef;
    }

    public final void Uf() {
        v.i("MicroMsg.BackupStartScene", "onSceneEnd");
        if (this.eeg.eeO != 0) {
            v.e("MicroMsg.BackupStartScene", "errType %d", Integer.valueOf(this.eeg.eeO));
            e(4, this.eeg.eeO, "BackupStartScene not success");
        } else if (b.UZ().equals(this.eeg.ID)) {
            b.UL().ebo = this.eeg.eeG;
            e(0, this.eeg.eeO, "BackupStartScene ok");
        } else {
            v.e("MicroMsg.BackupStartScene", "not the same id");
            e(4, -1, "not the same id");
        }
    }
}
