package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.widget.ImageView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!be.kS(str)) {
                a aVar = new a();
                aVar.cPu = k.jc(str);
                aVar.cPs = true;
                aVar.cPO = true;
                aVar.cPP = z;
                if (i != 0) {
                    aVar.cPL = i;
                }
                n.GL().a(str, imageView, aVar.GU());
            }
        }
    }

    public static String aOL() {
        g aNP = k.aNP();
        List<f> arrayList = new ArrayList();
        Cursor rawQuery = aNP.cie.rawQuery("SELECT * FROM " + aNP.getTableName() + " where status != 1", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.b(rawQuery);
                arrayList.add(fVar);
            }
            rawQuery.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar2 : arrayList) {
            stringBuilder.append(fVar2.field_reserved1);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
