package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.a.k;
import com.tencent.mm.ba.b;
import com.tencent.mm.plugin.backup.d.o;
import com.tencent.mm.plugin.backup.d.p;
import com.tencent.mm.plugin.backup.movemodel.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class a extends b {
    final int eak;
    public o edT = new o();
    public p edU = new p();
    final String edV;
    final String edW;
    private boolean edX = false;
    final byte[] key;

    public a(String str, String str2, byte[] bArr, String str3, int i) {
        v.i("MicroMsg.BackupAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", str3, str, str2, be.bur());
        this.edT.eew = new b(k.c(str.getBytes(), bArr));
        this.edT.efk = 0;
        this.edT.ID = str3;
        this.edV = str2;
        this.edW = str3;
        this.key = bArr;
        this.eak = i;
    }

    public int getType() {
        return 1;
    }

    public final com.tencent.mm.ba.a Ud() {
        return this.edU;
    }

    public final com.tencent.mm.ba.a Ue() {
        return this.edT;
    }

    public final void Uf() {
        if (this.edU.eeO != 0) {
            v.e("MicroMsg.BackupAuthScene", "errType %d", Integer.valueOf(this.edU.eeO));
            hV(30050002);
            e(4, this.edU.eeO, "not not success");
        } else if (this.edW.equals(this.edU.ID)) {
            String str = new String(k.b(this.edU.eew.lVU, this.key));
            this.edX = str.length() != this.edV.length() ? false : str.equals(this.edV);
            v.i("MicroMsg.BackupAuthScene", "check ok result:%b", Boolean.valueOf(this.edX));
            if (this.edX) {
                e(0, 0, "auth ok");
                this.edT.eew = new b(k.c(this.edV.getBytes(), this.key));
                this.edT.efk = 1;
                this.edT.ID = this.edW;
                bP(true);
                return;
            }
            v.e("MicroMsg.BackupAuthScene", "check ok failed");
            hV(30050002);
            e(4, 1, "not ok packet");
        } else {
            v.e("MicroMsg.BackupAuthScene", "not the same id");
            hV(30050028);
            e(4, -1, "not the same id");
        }
    }

    private void hV(int i) {
        if (this.eak == d.ekP) {
            com.tencent.mm.plugin.backup.g.b.UT().il(i);
        }
    }
}
