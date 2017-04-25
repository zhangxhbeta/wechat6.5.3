package com.tencent.mm.model;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class bm {
    public static ah cvu;
    private Map<String, ag> cvs = new HashMap();
    private Map<ag, Boolean> cvt = new HashMap();
    private String cvv = SQLiteDatabase.KeyEmpty;

    public final synchronized void zT() {
        if (be.kS(this.cvv)) {
            this.cvs.clear();
            this.cvt.clear();
            if (cvu != null) {
                this.cvs = cvu.oK();
                v.i("MicroMsg.MMCore.SubCoreMap", "resetSubCore get sub core map from sub core factory. count:%d", Integer.valueOf(this.cvs.size()));
            }
        } else {
            v.w("MicroMsg.MMCore.SubCoreMap", "ERR: Looping:%s , failed to resetSubCore", this.cvv);
        }
    }

    public final synchronized void aH(boolean z) {
        long Ni = be.Ni();
        this.cvv = "onSdcardMount";
        for (Entry entry : this.cvs.entrySet()) {
            if (be.a((Boolean) this.cvt.get(entry.getValue()), false)) {
                long Ni2 = be.Ni();
                ((ag) entry.getValue()).aH(z);
                v.i("MicroMsg.MMCore.SubCoreMap", "onSdcardMount %s time:%d", entry.getKey(), Long.valueOf(be.ay(Ni2)));
            }
        }
        this.cvv = SQLiteDatabase.KeyEmpty;
        v.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreSdcardMount finish Count:%d time:%d", Integer.valueOf(this.cvs.size()), Long.valueOf(be.ay(Ni)));
    }

    public final synchronized void aG(boolean z) {
        long Ni = be.Ni();
        this.cvv = "onAccountPostReset";
        for (Entry entry : this.cvs.entrySet()) {
            long Ni2 = be.Ni();
            ((ag) entry.getValue()).aG(z);
            this.cvt.put(entry.getValue(), Boolean.valueOf(true));
            v.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreAccountPostReset post:%s %d", entry.getKey(), Long.valueOf(be.ay(Ni2)));
        }
        this.cvv = SQLiteDatabase.KeyEmpty;
        v.i("MicroMsg.MMCore.SubCoreMap", "onSubCoreAccountPostReset finish Count:%d time:%d", Integer.valueOf(this.cvs.size()), Long.valueOf(be.ay(Ni)));
    }

    public final synchronized void zU() {
        long Ni = be.Ni();
        this.cvv = "releaseSubCore";
        for (Entry entry : this.cvs.entrySet()) {
            if (be.a((Boolean) this.cvt.get(entry.getValue()), false)) {
                long Ni2 = be.Ni();
                v.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore release:%s begin...", entry.getKey());
                ((ag) entry.getValue()).th();
                v.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore release:%s %d", entry.getKey(), Long.valueOf(be.ay(Ni2)));
            }
        }
        this.cvv = SQLiteDatabase.KeyEmpty;
        v.i("MicroMsg.MMCore.SubCoreMap", "releaseSubCore finish Count:%d time:%d", Integer.valueOf(this.cvs.size()), Long.valueOf(be.ay(Ni)));
    }

    public final synchronized Map<Integer, c> zV() {
        Map<Integer, c> hashMap;
        this.cvv = "getSubCoreBaseDBFacotries";
        hashMap = new HashMap();
        for (Entry entry : this.cvs.entrySet()) {
            if (((ag) entry.getValue()).ti() != null) {
                hashMap.putAll(((ag) entry.getValue()).ti());
            }
        }
        this.cvv = SQLiteDatabase.KeyEmpty;
        return hashMap;
    }

    public final synchronized void eW(int i) {
        this.cvv = "clearSubCorePluginData";
        for (Entry value : this.cvs.entrySet()) {
            ((ag) value.getValue()).ed(i);
        }
        this.cvv = SQLiteDatabase.KeyEmpty;
    }

    public final synchronized boolean a(String str, ag agVar) {
        if (!be.kS(this.cvv)) {
            Assert.assertTrue("REFUSE to addSubCore doing:" + this.cvv, false);
        }
        this.cvs.put(str, agVar);
        return true;
    }

    public final ag fY(String str) {
        return (ag) this.cvs.get(str);
    }
}
