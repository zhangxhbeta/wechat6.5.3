package com.tencent.mm.plugin.sns.e.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.a.b.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends e {
    public d(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final boolean aTk() {
        Object obj;
        long Nj;
        long j = -1;
        String k = i.k(this.boL);
        String str = this.jow.getPath() + this.jow.aTi();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long jP = FileOp.jP(str);
        if (this.joL || toLowerCase.contains("webp")) {
            obj = null;
        } else if (this.joM || toLowerCase.contains("vcodec")) {
            r16 = 1;
        } else {
            r16 = 2;
        }
        long Nj2;
        long az;
        switch (obj) {
            case null:
                g.iuh.a(22, 64, 1, true);
                FileOp.deleteFile(this.jow.getPath() + k);
                Nj2 = be.Nj();
                p.c(this.jow.getPath(), this.jow.getPath() + this.jow.aTi(), k, false);
                az = be.az(Nj2);
                FileOp.deleteFile(this.jow.getPath() + this.jow.aTi());
                j = be.az(Nj2);
                c.a(this.jow.getPath() + k, this.jow.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, jP, az);
                break;
            case 1:
                v.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[]{this.jow.getPath() + this.jow.aTi()});
                FileOp.deleteFile(this.jow.getPath() + k);
                Nj2 = be.Nj();
                p.c(this.jow.getPath(), this.jow.getPath() + this.jow.aTi(), k, false);
                az = be.az(Nj2);
                FileOp.deleteFile(this.jow.getPath() + this.jow.aTi());
                j = be.az(Nj2);
                c.a(this.jow.getPath() + k, this.jow.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, jP, az);
                break;
            case 2:
                az = -1;
                if (i.zX(this.jow.getPath() + this.jow.aTi())) {
                    v.w("MicroMsg.SnsDownloadImage", "the " + this.jow.mediaId + " is too max ! " + this.jow.url);
                    FileOp.deleteFile(this.jow.getPath() + k);
                    Nj = be.Nj();
                    p.Q(this.jow.getPath(), this.jow.getPath() + this.jow.aTi(), k);
                    az = be.az(Nj);
                    FileOp.deleteFile(this.jow.getPath() + this.jow.aTi());
                    j = be.az(Nj);
                } else {
                    FileOp.n(this.jow.getPath(), this.jow.aTi(), k);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.jow.getPath() + k);
                    if (i == 0) {
                        i = -1;
                    }
                }
                c.a(this.jow.getPath() + k, this.jow.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, jP, az);
                break;
        }
        v.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj == null));
        Nj = FileOp.jP(this.jow.getPath() + k);
        g.iuh.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(j), Long.valueOf(Nj), Thread.currentThread().getName(), ad.aSP(), e.cni});
        Object obj2 = this.jow.jos != 3 ? 1 : null;
        if (!(this.jow.jdH == null || this.jow.jdH.jdO == 4 || this.jow.jdH.jdO == 5)) {
            obj2 = null;
        }
        if (obj2 != null) {
            toLowerCase = i.c(this.boL);
            if (FileOp.aR(this.jow.getPath() + toLowerCase)) {
                FileOp.deleteFile(this.jow.getPath() + toLowerCase);
            }
            long Nj3 = be.Nj();
            p.a(this.jow.getPath(), k, toLowerCase, (float) ad.aSL());
            Nj3 = be.az(Nj3);
            FileOp.jP(this.jow.getPath() + toLowerCase);
            g.iuh.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(Nj3), Long.valueOf(Nj), Thread.currentThread().getName(), ad.aSP(), e.cni});
            toLowerCase = i.d(this.boL);
            if (!FileOp.aR(this.jow.getPath() + toLowerCase)) {
                p.b(this.jow.getPath(), k, toLowerCase, (float) ad.aSK());
            }
        }
        return true;
    }

    protected final int aTm() {
        return 1;
    }
}
