package com.tencent.mm.plugin.game.c;

import android.content.Context;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    public int bfb = 2;
    public c ghX;
    public boolean ghY = false;
    public int mode = 1;
    public int progress = 0;
    public int status = 0;

    public j(c cVar) {
        this.ghX = cVar;
    }

    public final void bW(Context context) {
        if (this.ghX != null) {
            int i = this.ghX.bxx;
            int i2 = this.ghX.bxx;
            v.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[]{this.ghX.field_appId, Integer.valueOf(i)});
            if (i == 2) {
                i2 = 3;
            }
            if (i2 == 3 && !g.o(context, "wx3909f6add1206543")) {
                i2 = 1;
            }
            if (i2 != 1) {
                f GN = d.bnK().GN(this.ghX.field_appId);
                if (GN.status == 1 || GN.status == 2 || GN.status == 3) {
                    i2 = 1;
                }
            }
            this.mode = i2;
            v.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[]{this.ghX.field_appId, Integer.valueOf(i2)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void arm() {
        /*
        r10 = this;
        r9 = 3;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r0 = r10.ghX;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r10.mode;
        switch(r0) {
            case 1: goto L_0x0032;
            case 2: goto L_0x009d;
            case 3: goto L_0x009d;
            default: goto L_0x000e;
        };
    L_0x000e:
        r10.status = r6;
    L_0x0010:
        r0 = "MicroMsg.GameDownloadInfo";
        r1 = "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d";
        r2 = new java.lang.Object[r9];
        r3 = r10.ghX;
        r3 = r3.field_appId;
        r2[r6] = r3;
        r3 = r10.mode;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        goto L_0x0008;
    L_0x0032:
        r0 = com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        r1 = r10.ghX;
        r1 = r1.field_appId;
        r0 = r0.GN(r1);
        r1 = r0.bfb;
        r10.bfb = r1;
        r1 = r0.jPw;
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r10.status = r6;
        goto L_0x0008;
    L_0x0049:
        r2 = r0.beE;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x0066;
    L_0x0051:
        r2 = r0.beD;
        r2 = (double) r2;
        r4 = r0.beE;
        r4 = (double) r4;
        r2 = r2 / r4;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 * r4;
        r1 = (int) r2;
        r10.progress = r1;
    L_0x005e:
        r1 = r0.status;
        switch(r1) {
            case 0: goto L_0x006f;
            case 1: goto L_0x0069;
            case 2: goto L_0x006c;
            case 3: goto L_0x0072;
            case 4: goto L_0x0087;
            default: goto L_0x0063;
        };
    L_0x0063:
        r10.status = r6;
        goto L_0x0010;
    L_0x0066:
        r10.progress = r6;
        goto L_0x005e;
    L_0x0069:
        r10.status = r7;
        goto L_0x0010;
    L_0x006c:
        r10.status = r8;
        goto L_0x0010;
    L_0x006f:
        r10.status = r6;
        goto L_0x0010;
    L_0x0072:
        r1 = r0.path;
        r1 = com.tencent.mm.a.e.aR(r1);
        if (r1 == 0) goto L_0x007d;
    L_0x007a:
        r10.status = r9;
        goto L_0x0010;
    L_0x007d:
        r1 = com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        r2 = r0.id;
        r1.dm(r2);
        goto L_0x000e;
    L_0x0087:
        r0 = r10.progress;
        if (r0 == 0) goto L_0x0099;
    L_0x008b:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ak.isConnected(r0);
        if (r0 != 0) goto L_0x0099;
    L_0x0095:
        r10.status = r8;
        goto L_0x0010;
    L_0x0099:
        r10.status = r6;
        goto L_0x0010;
    L_0x009d:
        r0 = r10.ghX;
        if (r0 == 0) goto L_0x0008;
    L_0x00a1:
        com.tencent.mm.plugin.game.c.at.arX();
        r0 = r10.ghX;
        r0 = r0.bxz;
        r0 = com.tencent.mm.plugin.game.c.at.uj(r0);
        r1 = "MicroMsg.GameDownloadInfo";
        r2 = "query download status : %d";
        r3 = new java.lang.Object[r7];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        switch(r0) {
            case 1: goto L_0x00c4;
            case 2: goto L_0x00c4;
            case 3: goto L_0x00c8;
            case 4: goto L_0x00cc;
            default: goto L_0x00c0;
        };
    L_0x00c0:
        r10.status = r6;
        goto L_0x0010;
    L_0x00c4:
        r10.status = r7;
        goto L_0x0010;
    L_0x00c8:
        r10.status = r8;
        goto L_0x0010;
    L_0x00cc:
        r10.status = r9;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c.j.arm():void");
    }

    public final void arn() {
        this.mode = 1;
        this.ghY = true;
    }
}
