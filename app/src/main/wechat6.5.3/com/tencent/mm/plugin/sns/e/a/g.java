package com.tencent.mm.plugin.sns.e.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.a.b.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.lucky.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends e {
    private boolean crU = false;

    public g(a aVar, a aVar2) {
        super(aVar, aVar2);
        com.tencent.mm.plugin.report.service.g.iuh.a(150, 10, 1, true);
    }

    public final boolean aTk() {
        if (this.jow.jdH != null) {
            int queryQuality;
            String str;
            String c = i.c(this.boL);
            this.crU = p.BH(this.jow.getPath() + this.jow.aTi());
            if (this.joL) {
                this.crU = true;
            }
            if (this.crU) {
                com.tencent.mm.plugin.report.service.g.iuh.a(22, 64, 1, true);
            }
            String str2 = this.jow.getPath() + this.jow.aTi();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options, null, 0, new int[0]);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || be.kS(options.outMimeType)) {
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long jP = FileOp.jP(str2);
            if (jP <= 0) {
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 23, 1, true);
            }
            long Nj = be.Nj();
            String h = i.h(this.boL);
            FileOp.p(this.jow.getPath() + this.jow.aTi(), this.jow.getPath() + h);
            v.v("MicroMsg.SnsDownloadThumb", "file src" + FileOp.aR(this.jow.getPath() + h));
            long Nj2 = be.Nj();
            if (!p.a(this.jow.getPath(), this.jow.aTi(), c, (float) ad.aSL())) {
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 27, 1, true);
            }
            Nj2 = be.az(Nj2);
            FileOp.deleteFile(this.jow.getPath() + this.jow.aTi());
            Nj = be.az(Nj);
            if (!FileOp.aR(this.jow.getPath() + c)) {
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 31, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(Nj), Integer.valueOf(this.joI), Thread.currentThread().getName(), ad.aSP(), e.cni});
            if (this.jow.jdH.jdO == 0 || this.jow.jdH.jdO == 5) {
                h = i.d(this.boL);
                p.b(this.jow.getPath(), c, h, (float) ad.aSK());
                str = h;
            } else {
                str = c;
            }
            c.a(this.jow.getPath() + str, this.jow.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, jP, Nj2);
            this.jov = i.zS(this.jow.getPath() + str);
            boolean b = i.b(this.jov);
            v.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.crU + " srcImgFileSize: " + jP);
            if (!b) {
                com.tencent.mm.plugin.report.service.g.iuh.a(150, 65, 1, true);
                if (this.joN) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(150, 50, 1, true);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(150, 51, 1, true);
                }
                if (this.joM) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(150, 54, 1, true);
                }
                if (this.joL) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(150, 57, 1, true);
                }
            }
            if (this.crU && !b) {
                com.tencent.mm.plugin.report.service.g.iuh.a(22, 65, 1, true);
            }
            if (this.joN && b) {
                b.kZ(139);
            }
        }
        return true;
    }

    protected final int aTm() {
        return 3;
    }
}
