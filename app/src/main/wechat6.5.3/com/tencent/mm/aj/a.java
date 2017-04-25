package com.tencent.mm.aj;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String cSV = SQLiteDatabase.KeyEmpty;
    public static String cSW = SQLiteDatabase.KeyEmpty;
    public String TEXT;
    public String TYPE;
    public at bmk;
    public String cSX = SQLiteDatabase.KeyEmpty;
    public String cSY;
    public LinkedList<String> cSZ = new LinkedList();
    public LinkedList<Integer> cTa = new LinkedList();
    public LinkedList<Integer> cTb = new LinkedList();
    public Map<String, String> values;

    public static abstract class a {
        private static HashMap<String, a> cTc = new HashMap();

        public abstract a a(Map<String, String> map, at atVar);

        public static void a(String str, a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (cTc) {
                cTc.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, at atVar) {
            if (map == null) {
                v.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            a a;
            String str = (String) map.get(".sysmsg.$type");
            synchronized (cTc) {
                a aVar = (a) cTc.get(str.toLowerCase());
                if (aVar == null) {
                    v.w("MicroMsg.BaseNewXmlMsg", "TYPE is unDefine");
                }
                a = aVar.a((Map) map, atVar);
            }
            return a;
        }
    }

    protected abstract boolean HK();

    a(Map<String, String> map) {
        this.values = map;
    }

    a(Map<String, String> map, at atVar) {
        this.values = map;
        this.bmk = atVar;
    }

    public final boolean HJ() {
        if (this.values == null || this.values.size() <= 0) {
            v.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            return false;
        }
        if (this.values.containsKey(".sysmsg.$type")) {
            this.TYPE = (String) this.values.get(".sysmsg.$type");
        }
        cSV = ".sysmsg." + this.TYPE + ".text";
        if (this.values.containsKey(cSV)) {
            this.TEXT = (String) this.values.get(cSV);
        }
        cSW = ".sysmsg." + this.TYPE + ".link.scene";
        if (this.values.containsKey(cSW)) {
            this.cSY = (String) this.values.get(cSW);
        }
        return HK();
    }
}
