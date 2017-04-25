package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements j {
    private final b cif;
    private e cii;
    private ArrayList<String> fdN;

    public d(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.czn = new ev();
        aVar.czo = new ew();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        aVar.czm = 696;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fdN = arrayList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            v.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            ak.yW();
            c.vf().a(t.a.noC, Boolean.valueOf(true));
            g.iuh.a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            c.vf().a(t.a.noC, Boolean.valueOf(false));
            f fVar = com.tencent.mm.plugin.emoji.model.g.afx().fch;
            List list = this.fdN;
            if (list == null || list.size() <= 0) {
                v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[]{Integer.valueOf(list.size())});
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE");
                stringBuilder.append(" EmojiInfo ");
                stringBuilder.append(" SET ");
                stringBuilder.append("source");
                stringBuilder.append("=");
                stringBuilder.append(com.tencent.mm.storage.a.c.nxe);
                stringBuilder.append(" where ");
                stringBuilder.append("md5");
                stringBuilder.append(" IN (");
                for (int i4 = 0; i4 < list.size(); i4++) {
                    stringBuilder.append("'" + ((String) list.get(i4)) + "'");
                    if (i4 < list.size() - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append(")");
                v.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                fVar.cie.dF("EmojiInfo", stringBuilder.toString());
            }
            g.iuh.a(164, 2, 1, false);
        } else {
            g.iuh.a(164, 3, 1, false);
        }
        ew ewVar = (ew) this.cif.czl.czs;
        if (ewVar.meC != null && ewVar.meC.size() > 0) {
            v.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            com.tencent.mm.plugin.emoji.model.g.afx().fch.aj(ewVar.meC);
            ak.yW();
            c.vf().set(348165, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.b.a.ct(true);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 696;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        ((ev) this.cif.czk.czs).meA = new LinkedList(this.fdN);
        if (this.fdN != null && this.fdN.size() > 0) {
            return a(eVar, this.cif, this);
        }
        v.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
        ak.yW();
        c.vf().set(348162, Boolean.valueOf(false));
        return -1;
    }
}
