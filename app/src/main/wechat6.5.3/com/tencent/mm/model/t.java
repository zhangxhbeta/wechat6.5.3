package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public final class t {
    public static void yz() {
        File file = new File(c.xp() + "chatstate.cfg");
        try {
            if (file.exists() && file.length() != 0) {
                InputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Map map = (Map) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        Integer num = (Integer) map.get(str);
                        if (num != null) {
                            ab Mh = c.wK().Mh(str);
                            if (!(Mh == null || !str.equals(Mh.field_username) || Mh.field_chatmode == num.intValue())) {
                                Mh.dg(num.intValue());
                                c.wK().a(Mh, str, true);
                            }
                        }
                    }
                    file.delete();
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.HardCodeUpdateTask", "exception:%s", be.e(e));
        }
    }

    public static void yA() {
        aa wH = c.wH();
        String str = "select * ,rowid from rcontact  where " + aa.nux + " and verifyFlag & " + u.bvo() + " !=0 ";
        v.v("MicroMsg.ContactStorage", "dkbf:" + str);
        Cursor rawQuery = wH.cie.rawQuery(str, null);
        if (rawQuery.moveToFirst()) {
            do {
                com.tencent.mm.e.b.ab uVar = new u();
                uVar.b(rawQuery);
                uVar.tz();
                c.wH().a(uVar.field_username, uVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
    }
}
