package com.tencent.mm.modelstat;

import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class m {
    static {
        bd.reset();
    }

    public static void r(int i, int i2, int i3) {
        if (aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext())) {
            v.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            s(i, i2, 0);
            return;
        }
        v.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        t(i, i2, 0);
    }

    public static void s(int i, int i2, int i3) {
        j jVar = new j();
        jVar.dcJ = i;
        jVar.dcV = i2;
        jVar.bkU = 8390656;
        c(jVar);
        a(jVar, i3);
        p.Km().a(jVar);
    }

    public static void t(int i, int i2, int i3) {
        j jVar = new j();
        jVar.dcI = i;
        jVar.dcU = i2;
        jVar.bkU = 4195328;
        c(jVar);
        a(jVar, i3);
        p.Km().a(jVar);
    }

    private static void c(j jVar) {
        bd.update();
        jVar.dcK = (int) bd.buc();
        jVar.dcW = (int) bd.bub();
        jVar.dcL = (int) bd.bua();
        jVar.dcX = (int) bd.btZ();
        jVar.dcY = (int) bd.bug();
        jVar.dda = (int) bd.buf();
        jVar.dcZ = (int) bd.bue();
        jVar.ddb = (int) bd.bud();
        jVar.bkU = (((((((jVar.bkU | 8192) | 33554432) | 4096) | 16777216) | 134217728) | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) | 67108864) | SQLiteDatabase.CREATE_IF_NECESSARY;
    }

    private static void a(j jVar, int i) {
        switch (i) {
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
            case 123:
                jVar.dcD = jVar.dcI + jVar.dcJ;
                jVar.bkU |= 32;
                return;
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                jVar.dcP = jVar.dcU + jVar.dcV;
                jVar.bkU |= 131072;
                return;
            case 127:
                jVar.dcR = jVar.dcU + jVar.dcV;
                jVar.bkU |= 524288;
                return;
            case FileUtils.S_IWUSR /*128*/:
                jVar.dcF = jVar.dcI + jVar.dcJ;
                jVar.bkU |= FileUtils.S_IWUSR;
                return;
            case 138:
            case 139:
                jVar.dcB = jVar.dcI + jVar.dcJ;
                jVar.bkU |= 8;
                return;
            case 149:
                jVar.dcT = jVar.dcU + jVar.dcV;
                jVar.bkU |= 2097152;
                return;
            case 150:
                jVar.dcH = jVar.dcI + jVar.dcJ;
                jVar.bkU |= 512;
                return;
            case 522:
                jVar.dcN = jVar.dcU + jVar.dcV;
                jVar.bkU |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                return;
            default:
                return;
        }
    }
}
