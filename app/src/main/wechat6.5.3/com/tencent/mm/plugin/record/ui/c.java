package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.e.a.ew;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.sdk.platformtools.v;

public final class c implements a {
    public c(Context context) {
        ew ewVar = new ew();
        ewVar.bdC.context = context;
        com.tencent.mm.sdk.c.a.nhr.z(ewVar);
    }

    public final void a(a.a aVar) {
        v.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[]{Long.valueOf(aVar.iqn)});
        ew ewVar = new ew();
        ewVar.bdC.opType = 1;
        ewVar.bdC.bdF = aVar.bdF;
        ewVar.bdC.bdE = aVar.bdE;
        ewVar.bdC.aZa = aVar.iqn;
        ewVar.bdC.bdG = aVar.bdG;
        ewVar.bdC.width = aVar.width;
        ewVar.bdC.height = aVar.height;
        com.tencent.mm.sdk.c.a.nhr.z(ewVar);
    }

    public final Bitmap a(com.tencent.mm.plugin.record.ui.h.a.c cVar) {
        ew ewVar = new ew();
        ewVar.bdC.opType = 0;
        ewVar.bdC.bdE = cVar.bdE;
        ewVar.bdC.aZa = cVar.iqn;
        com.tencent.mm.sdk.c.a.nhr.z(ewVar);
        v.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[]{Long.valueOf(cVar.iqn), ewVar.bdD.bdK});
        return ewVar.bdD.bdK;
    }

    public final Bitmap a(b bVar) {
        ew ewVar = new ew();
        ewVar.bdC.opType = 2;
        ewVar.bdC.bdJ = false;
        if (bVar.bdH) {
            ewVar.bdC.bdE = bVar.bdE;
            ewVar.bdC.bdH = bVar.bdH;
        } else {
            ewVar.bdC.bdE = bVar.bdE;
            ewVar.bdC.aZa = bVar.iqn;
            ewVar.bdC.maxWidth = bVar.maxWidth;
            ewVar.bdC.bdI = bVar.bdI;
        }
        com.tencent.mm.sdk.c.a.nhr.z(ewVar);
        v.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[]{Long.valueOf(bVar.iqn), bVar.bdE.luu, ewVar.bdD.bdK, Boolean.valueOf(ewVar.bdC.bdH)});
        return ewVar.bdD.bdK;
    }

    public final void aJH() {
        ew ewVar = new ew();
        ewVar.bdC.opType = 4;
        com.tencent.mm.sdk.c.a.nhr.z(ewVar);
    }
}
