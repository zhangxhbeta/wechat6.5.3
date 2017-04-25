package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDebug;
import java.util.ArrayList;
import java.util.List;

public final class m {
    private static List<String> cyP = null;
    private static int cyQ = 0;
    private static a cyR = new a(new b());

    static class b implements com.tencent.mm.sdk.platformtools.ah.a {
        Runnable cyT;

        b() {
        }

        public final boolean oU() {
            int size = m.cyP.size();
            v.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + size);
            if (size <= 2000 || m.cyQ >= SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
                if (this.cyT != null) {
                    this.cyT.run();
                }
                m.cyQ = 0;
                return false;
            }
            ak.yW();
            long er = c.wE().er(Thread.currentThread().getId());
            for (int i = size - 1; i >= size - 30; i--) {
                m.Bm();
                String str = (String) m.cyP.get(i);
                m.cyP.remove(i);
                n.AX();
                d.t(str, false);
                n.AX();
                d.t(str, true);
                n.Bo().gR(str);
            }
            ak.yW();
            c.wE().es(er);
            return true;
        }
    }

    static class a extends ah {
        final b cyS;

        public a(b bVar) {
            super(bVar, true);
            this.cyS = bVar;
        }
    }

    static /* synthetic */ int Bm() {
        int i = cyQ;
        cyQ = i + 1;
        return i;
    }

    public static void d(Runnable runnable) {
        List list = null;
        if (ak.uz()) {
            Cursor rawQuery = n.Bo().cuX.rawQuery("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null);
            int count = rawQuery.getCount();
            if (count == 0) {
                rawQuery.close();
            } else {
                list = new ArrayList();
                rawQuery.moveToFirst();
                for (int i = 0; i < count; i++) {
                    rawQuery.moveToPosition(i);
                    list.add(rawQuery.getString(0));
                }
                rawQuery.close();
            }
            cyP = list;
            if (list != null && cyP.size() > 0) {
                cyR.cyS.cyT = runnable;
                cyR.ea(10);
            }
        }
    }

    public static void Bi() {
        cyQ = 0;
        cyR.QI();
    }
}
