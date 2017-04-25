package com.tencent.mm.plugin.favorite.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.favorite.c.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class l {
    public static i a(LinkedList<pw> linkedList, long j) {
        i iVar = null;
        if (j != -1) {
            iVar = h.alu().bB(j);
            iVar.field_favProto.mtR.clear();
        }
        if (iVar == null) {
            iVar = new i();
            iVar.field_type = 18;
            iVar.field_sourceType = 6;
            f(iVar);
            iVar.field_favProto.uM(1);
            iVar.field_favProto.uL(127);
        }
        iVar.field_edittime = be.Nh();
        iVar.field_updateTime = be.Ni();
        iVar.field_favProto.dU(iVar.field_edittime);
        iVar.field_favProto.mtP.dV(be.Ni());
        iVar.field_favProto.ah(linkedList);
        return iVar;
    }

    private static List<String> aq(List<String> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List<String> arrayList = new ArrayList();
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        for (String str : list) {
            try {
                InputStream openRead = FileOp.openRead(str);
                if (openRead != null) {
                    if (MMBitmapFactory.checkIsImageLegal(openRead, decodeResultLogger)) {
                        arrayList.add(str);
                    } else if (decodeResultLogger.getDecodeResult() >= 2000) {
                        g.iuh.Y(12712, KVStatHelper.getKVStatString(openRead, 5, decodeResultLogger));
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    public static boolean ar(List<String> list) {
        List<String> aq = aq(list);
        if (aq == null || aq.size() == 0) {
            v.e("MicroMsg.FavPostLogic", "postImgs path null");
            return false;
        }
        i iVar = new i();
        iVar.field_type = 2;
        iVar.field_sourceType = 6;
        f(iVar);
        for (String str : aq) {
            pw pwVar = new pw();
            pwVar.IK(str);
            pwVar.IJ(v.aw(pwVar.toString(), 2));
            d.b(str, br.CTRL_INDEX, br.CTRL_INDEX, CompressFormat.JPEG, 90, v.g(pwVar));
            pwVar.IL(v.g(pwVar));
            pwVar.uG(2);
            iVar.field_favProto.mtR.add(pwVar);
        }
        a.u(iVar);
        g.iuh.h(10648, new Object[]{Integer.valueOf(2), Integer.valueOf(aq.size())});
        return true;
    }

    public static void f(i iVar) {
        String xF = k.xF();
        qg qgVar = new qg();
        qgVar.Jn(xF);
        qgVar.Jo(xF);
        qgVar.uN(iVar.field_sourceType);
        qgVar.dV(be.Ni());
        iVar.field_favProto.a(qgVar);
        iVar.field_fromUser = qgVar.bhM;
        iVar.field_toUser = qgVar.toUser;
    }
}
