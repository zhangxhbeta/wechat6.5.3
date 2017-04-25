package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import java.util.LinkedList;

public final class r implements l {
    public final int a(dx dxVar, boolean z, at atVar, String str, LinkedList<g> linkedList) {
        return atVar.field_content == null ? 0 : atVar.field_content.getBytes().length;
    }

    public final int a(String str, dx dxVar, at atVar) {
        String str2 = new String(dxVar.mbW.mQy);
        au wJ = b.Vd().wJ();
        atVar.setContent(str2);
        switch (dxVar.efm) {
            case 50:
                atVar.dh(6);
                break;
        }
        if (atVar.field_msgId == 0) {
            a.e(atVar);
        } else {
            wJ.b(dxVar.mcb, atVar);
        }
        return 0;
    }
}
