package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class a extends w {
    public final boolean eH(int i) {
        return i != 0 && i < 604372991;
    }

    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    public final void transfer(int i) {
        v.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            ak.yW();
            g wE = c.wE();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizInfo.username").append(", BizInfo.extInfo");
            stringBuilder.append(" from rcontact , BizInfo");
            stringBuilder.append(" where rcontact.username").append(" = BizInfo.username");
            stringBuilder.append(" and (rcontact.type").append(" & 1 ) != 0 ");
            stringBuilder.append(" and ( rcontact.verifyFlag").append(" & 8 ) != 0 ");
            String stringBuilder2 = stringBuilder.toString();
            List<String> linkedList = new LinkedList();
            v.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", stringBuilder2);
            Cursor rawQuery = wE.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                while (!rawQuery.isAfterLast()) {
                    BizInfo bizInfo = new BizInfo();
                    bizInfo.b(rawQuery);
                    if (bizInfo.aX(false).CV() == 1) {
                        linkedList.add(bizInfo.field_username);
                    }
                    rawQuery.moveToNext();
                }
                rawQuery.close();
            }
            if (linkedList.size() > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update BizInfo set type").append(" = 1 where 1 !=1 ");
                for (String append : linkedList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                v.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", stringBuilder.toString());
                u.Dy().dF("BizInfo", append);
            }
        }
    }
}
