package com.tencent.mm.p;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public final class b {
    SparseArray<a> ciB = new SparseArray();
    HashMap<com.tencent.mm.storage.t.a, a> ciC = new HashMap();
    SparseArray<b> ciD = new SparseArray();
    HashMap<com.tencent.mm.storage.t.a, b> ciE = new HashMap();
    private Random ciF = new Random();
    r ciG = null;

    public class a {
        String bax;
        final /* synthetic */ b ciH;
        int cix;
        com.tencent.mm.storage.t.a ciy;
        int type;
        public String value;

        public a(b bVar) {
            this.ciH = bVar;
        }
    }

    public class b {
        com.tencent.mm.storage.t.a ciA;
        final /* synthetic */ b ciH;
        int ciI;
        SparseArray<String> ciJ = new SparseArray();
        HashMap<String, String> ciK = new HashMap();

        public b(b bVar) {
            this.ciH = bVar;
        }
    }

    private static String dM(String str) {
        return str.replaceAll("\\|", "%7C");
    }

    private static String unescape(String str) {
        return str.replaceAll("%7C", "|");
    }

    final void a(a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(dM(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(dM(aVar.bax));
        if (aVar.ciy != null) {
            this.ciG.a(aVar.ciy, stringBuffer.toString());
        } else {
            this.ciG.set(aVar.cix, stringBuffer.toString());
        }
    }

    final void a(b bVar) {
        StringBuffer stringBuffer = new StringBuffer();
        int i;
        if (bVar.ciA != null) {
            i = 0;
            for (Entry entry : bVar.ciK.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (i != 0) {
                    stringBuffer.append("|");
                }
                stringBuffer.append(str);
                stringBuffer.append("|");
                stringBuffer.append(dM(str2));
                i++;
            }
            this.ciG.a(bVar.ciA, stringBuffer.toString());
            return;
        }
        for (int i2 = 0; i2 < bVar.ciJ.size(); i2++) {
            i = bVar.ciJ.keyAt(i2);
            str2 = (String) bVar.ciJ.get(i);
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(i);
            stringBuffer.append("|");
            stringBuffer.append(dM(str2));
        }
        this.ciG.set(bVar.ciI, stringBuffer.toString());
    }

    private a et(int i) {
        String str = (String) this.ciG.get(i, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            v.e("MicroMsg.NewBandageDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(i, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            v.e("MicroMsg.NewBandageDecoder", "exception:%s", be.e(e));
            v.e("MicroMsg.NewBandageDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private a b(com.tencent.mm.storage.t.a aVar) {
        String str = (String) this.ciG.get(aVar, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            v.e("MicroMsg.NewBandageDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            v.e("MicroMsg.NewBandageDecoder", "exception:%s", be.e(e));
            v.e("MicroMsg.NewBandageDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private b eu(int i) {
        String str = (String) this.ciG.get(i, null);
        if (str == null) {
            return ev(i);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            v.e("MicroMsg.NewBandageDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b ev = ev(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                ev.ciJ.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
            }
            return ev;
        } catch (Throwable e) {
            v.e("MicroMsg.NewBandageDecoder", "exception:%s", be.e(e));
            v.e("MicroMsg.NewBandageDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    final b c(com.tencent.mm.storage.t.a aVar) {
        String str = (String) this.ciG.get(aVar, null);
        if (str == null) {
            return d(aVar);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            v.e("MicroMsg.NewBandageDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b d = d(aVar);
            for (int i = 0; i < split.length; i += 2) {
                d.ciK.put(split[i], unescape(split[i + 1]));
            }
            return d;
        } catch (Throwable e) {
            v.e("MicroMsg.NewBandageDecoder", "exception:%s", be.e(e));
            v.e("MicroMsg.NewBandageDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    final String ur() {
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.ciF.nextInt(Math.abs(this.ciF.nextInt(Integer.MAX_VALUE))) % 10000;
        return String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
    }

    final b ev(int i) {
        b bVar = new b(this);
        bVar.ciI = i;
        return bVar;
    }

    private b d(com.tencent.mm.storage.t.a aVar) {
        b bVar = new b(this);
        bVar.ciA = aVar;
        return bVar;
    }

    final a a(int i, int i2, String str, String str2) {
        a aVar = new a(this);
        aVar.cix = i;
        aVar.type = i2;
        aVar.value = str;
        aVar.bax = str2;
        return aVar;
    }

    final a a(com.tencent.mm.storage.t.a aVar, int i, String str, String str2) {
        a aVar2 = new a(this);
        aVar2.ciy = aVar;
        aVar2.type = i;
        aVar2.value = str;
        aVar2.bax = str2;
        return aVar2;
    }

    public final a ew(int i) {
        a aVar = (a) this.ciB.get(i);
        if (aVar == null) {
            aVar = et(i);
            if (aVar != null) {
                this.ciB.put(i, aVar);
            }
        }
        return aVar;
    }

    public final a e(com.tencent.mm.storage.t.a aVar) {
        a aVar2 = (a) this.ciC.get(aVar);
        if (aVar2 == null) {
            aVar2 = b(aVar);
            if (aVar2 != null) {
                this.ciC.put(aVar, aVar2);
            }
        }
        return aVar2;
    }

    final b ex(int i) {
        b bVar = (b) this.ciD.get(i);
        if (bVar != null) {
            return bVar;
        }
        bVar = eu(i);
        if (bVar == null) {
            v.e("MicroMsg.NewBandageDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.ciD.put(i, bVar);
        return bVar;
    }

    public final a p(int i, int i2, int i3) {
        v.d("MicroMsg.NewBandageDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a ew = ew(i);
        if (ew == null) {
            v.d("MicroMsg.NewBandageDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((ew.type & i3) == 0) {
            v.d("MicroMsg.NewBandageDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b ex = ex(i2);
            if (ex != null) {
                String str = (String) ex.ciJ.get(i);
                if (str != null && str.equals(ew.bax)) {
                    return null;
                }
                if (str == null) {
                    ex.ciJ.put(i, ur());
                    a(ex);
                }
                return ew;
            }
            v.e("MicroMsg.NewBandageDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }
}
