package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    public int cKy;
    public final b cif;
    private e cii;
    private List<String> fdM;

    public c(int i, List<String> list) {
        a aVar = new a();
        aVar.czn = new dr();
        aVar.czo = new ds();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        aVar.czm = 698;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.cKy = i;
        this.fdM = list;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            v.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.noC, Boolean.valueOf(true));
            g.iuh.a(164, 7, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.noC, Boolean.valueOf(false));
            if (this.cKy == 1) {
                g.iuh.a(164, 5, 1, false);
            } else {
                g.iuh.a(164, 8, 1, false);
            }
        } else {
            g.iuh.a(164, 6, 1, false);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        dr drVar = (dr) this.cif.czk.czs;
        drVar.meB = this.cKy;
        drVar.meA = new LinkedList(this.fdM);
        if (drVar.meA == null || drVar.meA.size() <= 0) {
            v.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            v.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[]{Integer.valueOf(drVar.meA.size())});
            for (int i = 0; i < drVar.meA.size(); i++) {
                v.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[]{drVar.meA.get(i)});
            }
        }
        return a(eVar, this.cif, this);
    }
}
