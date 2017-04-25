package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class c extends w {
    public final boolean eH(int i) {
        return i != 0 && i < 620757033;
    }

    public final void transfer(int i) {
        v.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 620757033) {
            List<String> linkedList = new LinkedList();
            ak.yW();
            Cursor d = com.tencent.mm.model.c.wH().d("@black.android", SQLiteDatabase.KeyEmpty, null);
            if (d != null) {
                d.moveToFirst();
                while (!d.isAfterLast()) {
                    ab uVar = new u();
                    uVar.b(d);
                    linkedList.add(uVar.field_username);
                    d.moveToNext();
                }
                d.close();
            }
            if (linkedList.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation");
                stringBuilder.append(" set parentRef = '@blacklist").append("' where 1 != 1 ");
                for (String append : linkedList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                v.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", stringBuilder.toString());
                ak.yW();
                com.tencent.mm.model.c.wE().dF("rconversation", append);
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
