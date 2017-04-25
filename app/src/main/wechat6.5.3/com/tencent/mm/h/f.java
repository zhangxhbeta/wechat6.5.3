package com.tencent.mm.h;

import com.tencent.mm.e.a.bt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f {
    private HashMap<String, String> cgT = new HashMap();
    private boolean cgU = false;

    public final synchronized String getValue(String str) {
        if (!this.cgU) {
            v.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            sW();
        }
        v.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", str.trim(), this.cgT.get(str));
        return (String) this.cgT.get(str);
    }

    public final int getInt(String str, int i) {
        try {
            i = Integer.parseInt(getValue(str));
        } catch (Exception e) {
            v.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + str);
        }
        return i;
    }

    public final synchronized List<String> dy(String str) {
        List<String> arrayList;
        if (!this.cgU) {
            v.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
            sW();
        }
        arrayList = new ArrayList();
        if (!be.kS(str)) {
            for (String str2 : this.cgT.keySet()) {
                if (str2.matches(str)) {
                    arrayList.add(this.cgT.get(str2));
                }
            }
        }
        v.d("MicroMsg.DynamicConfig", "searchValues, entry:%s, size:%d", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Deprecated
    public final synchronized void put(String str, String str2) {
        if (!(str == null || str2 == null)) {
            v.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", str.trim(), str2);
            this.cgT.put(str, str2);
        }
    }

    public final synchronized void sW() {
        g.vx();
        if (g.vw() != null) {
            g.vx();
            if (g.vw().vf() != null) {
                this.cgU = true;
                g.vx();
                i((String) g.vw().vf().get(278529, null), false);
            }
        }
        g.vx();
        if (g.vw() != null) {
            g.vx();
            if (g.vw().vf() != null) {
                this.cgU = true;
                g.vx();
                i((String) g.vw().vf().get(278530, null), true);
            }
        }
    }

    public final synchronized void a(String str, Map<String, String> map, boolean z) {
        if (!be.kS(str)) {
            v.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", Boolean.valueOf(z), com.tencent.mm.a.g.aX(str));
            if (z) {
                g.vx();
                g.vw().vf().set(278530, str);
            } else {
                g.vx();
                g.vw().vf().set(278529, str);
                g.vx();
                g.vw().vf().set(278530, SQLiteDatabase.KeyEmpty);
            }
            if (map != null) {
                a(map, z);
            } else {
                i(str, z);
            }
            a.nhr.z(new bt());
        }
    }

    private void i(String str, boolean z) {
        a(bf.q(str, "sysmsg"), z);
    }

    private void a(Map<String, String> map, boolean z) {
        if (map != null) {
            if (!z) {
                this.cgT.clear();
            }
            int i = 0;
            while (i < 10000) {
                String str;
                if (z) {
                    str = ".sysmsg.dynacfg_split.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i));
                } else {
                    str = ".sysmsg.dynacfg.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i));
                }
                String str2 = str + ".$key";
                str = (String) map.get(str);
                str2 = (String) map.get(str2);
                if (str2 == null || be.kS(str2.trim())) {
                    break;
                }
                this.cgT.put(str2.trim(), str != null ? str : SQLiteDatabase.KeyEmpty);
                v.d("MicroMsg.DynamicConfig", "put %s %s", str2.trim(), str);
                i++;
            }
            v.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", this.cgT.toString());
        }
    }
}
