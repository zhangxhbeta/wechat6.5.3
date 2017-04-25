package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends w {
    public final boolean eH(int i) {
        return i != 0 && i < 637735215;
    }

    public final String getTag() {
        return "MicroMsg.App.BizPlaceTopDataTransfer";
    }

    public final void transfer(int i) {
        v.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (eH(i)) {
            v.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
            long currentTimeMillis = System.currentTimeMillis();
            g.iuh.a(336, 0, 1, true);
            ak.yW();
            com.tencent.mm.bg.g wE = c.wE();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select conv.username");
            stringBuilder.append(" from ");
            stringBuilder.append("rconversation");
            stringBuilder.append(" as conv, ");
            stringBuilder.append("rcontact");
            stringBuilder.append(" as ct ");
            stringBuilder.append(" where conv.");
            stringBuilder.append("parentRef");
            stringBuilder.append("='");
            stringBuilder.append("officialaccounts");
            stringBuilder.append("' and conv.");
            stringBuilder.append("username");
            stringBuilder.append(" = ct.");
            stringBuilder.append("username");
            stringBuilder.append(" and ct.");
            stringBuilder.append("verifyFlag");
            stringBuilder.append(" & ");
            stringBuilder.append(8);
            stringBuilder.append(" = 0");
            v.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", stringBuilder.toString());
            Cursor rawQuery = wE.rawQuery(r0, null);
            if (rawQuery == null) {
                v.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            v.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("update ");
            stringBuilder2.append("rconversation");
            stringBuilder2.append(" set ");
            stringBuilder2.append("parentRef");
            stringBuilder2.append("='' where ");
            stringBuilder2.append("username");
            stringBuilder2.append(" in (");
            if (rawQuery.moveToFirst()) {
                g.iuh.a(336, 1, 1, true);
                stringBuilder2.append("'");
                stringBuilder2.append(rawQuery.getString(0));
                stringBuilder2.append("'");
                int i2 = 1;
                while (rawQuery.moveToNext()) {
                    stringBuilder2.append(",");
                    stringBuilder2.append("'");
                    stringBuilder2.append(rawQuery.getString(0));
                    stringBuilder2.append("'");
                    i2++;
                }
                stringBuilder2.append(")");
                String stringBuilder3 = stringBuilder2.toString();
                v.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", Integer.valueOf(i2));
                v.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", stringBuilder3);
                rawQuery.close();
                if (wE.dF("rconversation", stringBuilder2.toString())) {
                    g.iuh.a(336, 2, 1, true);
                } else {
                    g.iuh.a(336, 3, 1, true);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                v.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
                return;
            }
            rawQuery.close();
            v.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
        }
    }
}
