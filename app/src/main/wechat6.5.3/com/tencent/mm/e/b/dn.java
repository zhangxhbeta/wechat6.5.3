package com.tencent.mm.e.b;

import com.tencent.mm.bg.g;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import junit.framework.Assert;

public final class dn extends g {
    private static dn bXp = null;
    private static HashMap<Integer, c> bXq;

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new c() {
            public final String[] pS() {
                return new String[]{f.a(av.pz(), "FavItemInfo")};
            }
        });
        bXq.put(Integer.valueOf("FavSearchInfo".hashCode()), new c() {
            public final String[] pS() {
                return new String[]{f.a(aw.pz(), "FavSearchInfo")};
            }
        });
        bXq.put(Integer.valueOf("FavEditInfo".hashCode()), new c() {
            public final String[] pS() {
                return new String[]{f.a(au.pz(), "FavEditInfo")};
            }
        });
        bXq.put(Integer.valueOf("FavCdnInfo".hashCode()), new c() {
            public final String[] pS() {
                return new String[]{f.a(as.pz(), "FavCdnInfo")};
            }
        });
        bXq.put(Integer.valueOf("FavConfigInfo".hashCode()), new c() {
            public final String[] pS() {
                return new String[]{f.a(at.pz(), "FavConfigInfo")};
            }
        });
    }

    private dn() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        v.d("MicroMsg.FavoriteDataBase", "db path", new Object[]{stringBuilder.append(com.tencent.mm.model.c.xp()).append("enFavorite.db").toString()});
        ak.yW();
        if (a("", stringBuilder.append(com.tencent.mm.model.c.xp()).append("enFavorite.db").toString(), (long) com.tencent.mm.model.c.ww(), p.rJ(), bXq)) {
            String str = this.nxM;
            if (!be.kS(str)) {
                v.e("MicroMsg.FavoriteDataBase", "dbinit failed :" + str);
                b.r("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            v.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return;
        }
        throw new com.tencent.mm.model.b((byte) 0);
    }

    public static dn pR() {
        if (bXp == null) {
            bXp = new dn();
        }
        return bXp;
    }

    public final void cQ(String str) {
        super.cQ(str);
        bXp = null;
    }
}
