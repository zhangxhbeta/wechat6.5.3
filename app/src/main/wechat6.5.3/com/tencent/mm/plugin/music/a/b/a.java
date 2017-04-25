package com.tencent.mm.plugin.music.a.b;

import com.tencent.mm.ai.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public com.tencent.mm.ai.a big;
    private b cQA;
    private e cii;
    public yk hDp;
    public boolean pRh;

    public a(com.tencent.mm.ai.a aVar, boolean z) {
        int i;
        this.big = aVar;
        this.pRh = z;
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new yj();
        aVar2.czo = new yk();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        aVar2.czm = 520;
        this.cQA = aVar2.Bv();
        yj yjVar = (yj) this.cQA.czk.czs;
        yjVar.mAi = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            yjVar.mAj = m.H(aVar.field_songWebUrl.getBytes());
        }
        if (c.HI()) {
            i = 0;
        } else {
            i = 1;
        }
        yjVar.mAk = i;
        if (c.HH()) {
            i = 1;
        } else {
            i = 0;
        }
        yjVar.mAl = i;
        v.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[]{Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(yjVar.mAk), Integer.valueOf(yjVar.mAl)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hDp = (yk) this.cQA.czl.czs;
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }
}
