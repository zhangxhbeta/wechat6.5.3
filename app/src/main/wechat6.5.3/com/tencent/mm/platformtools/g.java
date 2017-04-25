package com.tencent.mm.platformtools;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import junit.framework.Assert;

public final class g {
    private static SparseArray<a> doQ = new SparseArray();

    public static final class a extends com.tencent.mm.bg.g {
        public final boolean doR;
        SparseBooleanArray doS = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            v.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.doR = z;
            this.path = str;
        }

        public final void gG(int i) {
            v.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.doS.delete(i);
            if (this.doS.size() <= 0) {
                v.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.wB();
                g.doQ.remove(this.path.hashCode());
            }
        }

        @Deprecated
        public final void wB() {
            v.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", be.bur());
            if (this.doS.size() <= 1) {
                super.wB();
            }
        }

        @Deprecated
        public final void cQ(String str) {
            v.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.doS.size() <= 1) {
                super.cQ(str);
            }
        }
    }

    public static final a a(int i, String str, HashMap<Integer, c> hashMap, boolean z) {
        boolean z2 = (be.kS(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        a aVar = (a) doQ.get(hashCode);
        if (aVar == null) {
            aVar = new a(str, z);
            if (z) {
                String str2 = SQLiteDatabase.KeyEmpty;
                String str3 = SQLiteDatabase.KeyEmpty;
                ak.yW();
                if (!aVar.a(str2, str, str3, (long) com.tencent.mm.model.c.ww(), p.rJ(), hashMap, true)) {
                    throw new b((byte) 0);
                }
            } else if (!aVar.b(str, hashMap, true, false)) {
                throw new b((byte) 0);
            }
            doQ.put(hashCode, aVar);
        } else {
            Assert.assertTrue(z == aVar.doR);
            long auU = aVar.auU();
            for (c pS : hashMap.values()) {
                for (String str4 : pS.pS()) {
                    v.d("MicroMsg.GeneralDBHelper", "init sql:" + str4);
                    try {
                        aVar.dF(null, str4);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            aVar.es(auU);
        }
        v.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        aVar.doS.put(i, true);
        return aVar;
    }
}
