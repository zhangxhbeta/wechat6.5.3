package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.c.d;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class w {
    public static void a(i iVar, int i) {
        if (iVar == null) {
            v.w("MicroMsg.ModFavItemLogic", "modeTag, item info is null");
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        aix com_tencent_mm_protocal_c_aix = new aix();
        com_tencent_mm_protocal_c_aix.mJs = 4;
        com_tencent_mm_protocal_c_aix.mJt = 0;
        linkedList.add(com_tencent_mm_protocal_c_aix);
        LinkedList linkedList2 = new LinkedList();
        aja com_tencent_mm_protocal_c_aja = new aja();
        com_tencent_mm_protocal_c_aja.gmM = "favitem.taglist";
        com_tencent_mm_protocal_c_aja.efm = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int size = iVar.field_tagProto.mub.size();
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(be.KJ((String) iVar.field_tagProto.mub.get(i2))).append("</tag>");
        }
        com_tencent_mm_protocal_c_aja.itR = stringBuffer.toString();
        v.v("MicroMsg.ModFavItemLogic", "do net scene mod tag, id=%d, tag=%s", new Object[]{Integer.valueOf(iVar.field_id), com_tencent_mm_protocal_c_aja.itR});
        linkedList2.add(com_tencent_mm_protocal_c_aja);
        if (iVar.field_id > 0) {
            ak.vy().a(new ad(iVar.field_id, linkedList, linkedList2), 0);
            g.iuh.h(11122, new Object[]{Integer.valueOf(iVar.field_id), Integer.valueOf(size), Integer.valueOf(h.aln().alJ()), Integer.valueOf(i)});
            return;
        }
        f fVar;
        d als = h.als();
        long j = iVar.field_localId;
        g alq = h.alq();
        v.d("MicroMsg.FavModInfoStorage", "get mod info sql %s, {%d, %d}", new Object[]{"select * from FavEditInfo where localId =  ? and type =  ?", Long.valueOf(j), Integer.valueOf(0)});
        com.tencent.mm.sdk.h.d dVar = alq.cie;
        Cursor rawQuery = dVar.rawQuery("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j), "0"});
        if (rawQuery == null) {
            fVar = null;
        } else {
            fVar = null;
            if (rawQuery.moveToFirst()) {
                fVar = new f();
                fVar.b(rawQuery);
            }
            rawQuery.close();
        }
        if (fVar == null) {
            fVar = new f();
            i2 = 1;
        } else {
            i2 = 0;
        }
        fVar.field_localId = j;
        qa qaVar = new qa();
        qaVar.fMd = linkedList;
        qaVar.mtE = linkedList2;
        fVar.field_modItem = qaVar;
        fVar.field_time = be.Ni();
        fVar.field_type = 0;
        fVar.field_scene = i;
        if (i2 != 0) {
            h.alq().b(fVar);
        } else {
            h.alq().a(fVar, new String[]{"localId"});
        }
        als.run();
    }

    public static void a(long j, LinkedList<aix> linkedList, LinkedList<aja> linkedList2) {
        aix com_tencent_mm_protocal_c_aix = new aix();
        com_tencent_mm_protocal_c_aix.mJs = 4;
        com_tencent_mm_protocal_c_aix.mJt = 0;
        linkedList.add(com_tencent_mm_protocal_c_aix);
        b alp = h.alp();
        List<a> linkedList3 = new LinkedList();
        Cursor rawQuery = alp.cie.rawQuery("select * from FavCdnInfo where favLocalId = " + j + " and type = 0" + " and status = 3", null);
        boolean sY;
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            v.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList3.size())});
            for (a aVar : linkedList3) {
                sY = v.sY(aVar.field_dataId);
                if (!be.kS(aVar.field_cdnUrl) || sY) {
                    v.e("MicroMsg.ModFavItemLogic", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[]{aVar.field_cdnUrl, Boolean.valueOf(sY), Long.valueOf(j)});
                } else {
                    aja com_tencent_mm_protocal_c_aja = new aja();
                    com_tencent_mm_protocal_c_aja.gmM = "dataitem." + aVar.field_dataId + ".cdn_dataurl";
                    com_tencent_mm_protocal_c_aja.itR = aVar.field_cdnUrl;
                    linkedList2.add(com_tencent_mm_protocal_c_aja);
                    com_tencent_mm_protocal_c_aja = new aja();
                    com_tencent_mm_protocal_c_aja.gmM = "dataitem." + aVar.field_dataId + ".cdn_datakey";
                    com_tencent_mm_protocal_c_aja.itR = aVar.field_cdnKey;
                    linkedList2.add(com_tencent_mm_protocal_c_aja);
                    com_tencent_mm_protocal_c_aja = new aja();
                    com_tencent_mm_protocal_c_aja.gmM = "dataitem." + aVar.field_dataId;
                    com_tencent_mm_protocal_c_aja.mJy = "datastatus";
                    com_tencent_mm_protocal_c_aja.itR = "0";
                    linkedList2.add(com_tencent_mm_protocal_c_aja);
                    i bB = h.alu().bB(aVar.field_favLocalId);
                    if (bB != null) {
                        if ((bB.field_type == 4 ? 1 : 0) != 0) {
                            pw a = v.a(bB, aVar.field_dataId);
                            aja com_tencent_mm_protocal_c_aja2 = new aja();
                            com_tencent_mm_protocal_c_aja2.gmM = "dataitem." + aVar.field_dataId + ".stream_videoid";
                            com_tencent_mm_protocal_c_aja2.itR = a.msC;
                            linkedList2.add(com_tencent_mm_protocal_c_aja2);
                        }
                    }
                }
            }
        }
        do {
            a aVar2 = new a();
            aVar2.b(rawQuery);
            linkedList3.add(aVar2);
        } while (rawQuery.moveToNext());
        if (rawQuery != null) {
            rawQuery.close();
        }
        v.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList3.size())});
        for (a aVar3 : linkedList3) {
            sY = v.sY(aVar3.field_dataId);
            if (be.kS(aVar3.field_cdnUrl)) {
            }
            v.e("MicroMsg.ModFavItemLogic", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[]{aVar3.field_cdnUrl, Boolean.valueOf(sY), Long.valueOf(j)});
        }
    }
}
