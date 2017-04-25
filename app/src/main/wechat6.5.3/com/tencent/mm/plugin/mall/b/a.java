package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.oy;
import com.tencent.mm.sdk.platformtools.be;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat eNn = null;
    private static SimpleDateFormat eNo = null;
    private static final String hjn = (e.cnj + "wallet/mall");

    public static void ayW() {
        oy oyVar = new oy();
        oyVar.bqj.bqk = false;
        com.tencent.mm.sdk.c.a.nhr.z(oyVar);
    }

    public static void j(ImageView imageView, String str) {
        c(imageView, str, 0);
    }

    public static void c(ImageView imageView, String str, int i) {
        String str2 = null;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!be.kS(str)) {
                com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                if (!be.kS(str)) {
                    str2 = String.format("%s/%s", new Object[]{hjn, g.m(str.getBytes())});
                }
                aVar.cPv = str2;
                aVar.cPs = true;
                aVar.cPO = true;
                aVar.cPP = false;
                if (i != 0) {
                    aVar.cPH = i;
                }
                n.GL().a(str, imageView, aVar.GU());
            } else if (i != 0) {
                imageView.setImageResource(i);
            }
        }
    }
}
