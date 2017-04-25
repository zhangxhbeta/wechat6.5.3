package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.b;
import com.tencent.mm.sdk.platformtools.ar.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class r extends j implements c<Object, Object> {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private g cuX;
    private long ddm;
    private ar<Object, Object> noa;
    private ar<Object, Object> nob;
    private BlockingQueue<Integer> noc = new LinkedBlockingQueue();
    private BlockingQueue<String> nod = new LinkedBlockingQueue();

    static class a {
        public String cvi = null;
        public int type = -1;

        a() {
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.cvi != null) {
                return this.cvi.equals(aVar.cvi);
            }
            if (aVar.cvi == null) {
                return true;
            }
            return false;
        }
    }

    public r(g gVar) {
        this.cuX = gVar;
        this.noa = new ar(this, com.tencent.mm.kernel.g.vA().htb.getLooper(), 100, 20, 60000, 1);
        this.noa.setTag(Integer.valueOf(1));
        this.nob = new ar(this, com.tencent.mm.kernel.g.vA().htb.getLooper(), 100, 20, 60000, 1);
        this.nob.setTag(Integer.valueOf(3));
    }

    public final Object get(int i, Object obj) {
        Assert.assertTrue("db is null", this.cuX != null);
        Object obj2 = this.noa.get(Integer.valueOf(i));
        if (obj2 == null && !this.noc.contains(Integer.valueOf(i))) {
            a aVar = new a();
            Cursor query = this.cuX.query("userinfo", null, "id=" + i, null, null, null, null);
            if (query.getCount() > 0) {
                query.moveToFirst();
                aVar.type = query.getInt(1);
                aVar.cvi = query.getString(2);
                obj2 = j(aVar.type, aVar.cvi);
                this.noa.q(Integer.valueOf(i), aVar);
            }
            query.close();
            if (obj2 == null) {
                return obj;
            }
        } else if (obj2 instanceof a) {
            a aVar2 = (a) obj2;
            obj2 = j(aVar2.type, aVar2.cvi);
            if (obj2 == null) {
                return obj;
            }
        }
        return obj2;
    }

    public final Object get(com.tencent.mm.storage.t.a aVar, Object obj) {
        if (aVar == null) {
            return obj;
        }
        String name = aVar.name();
        if (be.kS(name)) {
            return obj;
        }
        String str;
        String[] split = name.split("_");
        String str2 = split[split.length - 1];
        if (str2.equals("SYNC")) {
            str = split[split.length - 2];
        } else {
            str = str2;
        }
        String substring = name.substring(0, name.lastIndexOf(str) + str.length());
        Assert.assertTrue("db is null", this.cuX != null);
        Object obj2 = this.nob.get(substring);
        if (obj2 == null && !this.nod.contains(substring)) {
            a aVar2 = new a();
            Cursor query = this.cuX.query("userinfo2", null, "sid=?", new String[]{substring}, null, null, null);
            if (query.getCount() > 0) {
                query.moveToFirst();
                aVar2.type = query.getInt(1);
                aVar2.cvi = query.getString(2);
                obj2 = j(aVar2.type, aVar2.cvi);
                this.nob.q(substring, aVar2);
            }
            query.close();
            if (obj2 == null) {
                obj2 = obj;
            }
        } else if (obj2 instanceof a) {
            a aVar3 = (a) obj2;
            obj2 = j(aVar3.type, aVar3.cvi);
            if (obj2 == null) {
                obj2 = obj;
            }
        }
        if (a(str, obj2, false)) {
            return obj2;
        }
        return obj;
    }

    public final boolean b(com.tencent.mm.storage.t.a aVar, boolean z) {
        Object obj = get(aVar, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            return z;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void set(int i, Object obj) {
        boolean q;
        Assert.assertTrue("db is null", this.cuX != null);
        if (obj == null) {
            q = this.noa.q(Integer.valueOf(i), null);
            if (q && !this.noc.contains(Integer.valueOf(i))) {
                this.noc.add(Integer.valueOf(i));
            }
        } else {
            a aVar = new a();
            aVar.type = bh(obj);
            if (aVar.type != -1) {
                aVar.cvi = obj.toString();
                q = this.noa.q(Integer.valueOf(i), aVar);
                if (q && this.noc.contains(Integer.valueOf(i))) {
                    this.noc.remove(Integer.valueOf(i));
                }
            } else {
                return;
            }
        }
        if (q) {
            b(obj == null ? 5 : 4, this, Integer.valueOf(i));
        }
    }

    public final void a(com.tencent.mm.storage.t.a aVar, Object obj) {
        if (aVar != null) {
            String name = aVar.name();
            if (!be.kS(name)) {
                boolean z;
                String[] split = name.split("_");
                String str = split[split.length - 1];
                if (str.equals("SYNC")) {
                    str = split[split.length - 2];
                    z = true;
                } else {
                    z = false;
                }
                if (a(str, obj, true)) {
                    boolean q;
                    String substring = name.substring(0, str.length() + name.lastIndexOf(str));
                    if (obj == null) {
                        q = this.nob.q(substring, null);
                        if (q && !this.nod.contains(substring)) {
                            this.nod.add(substring);
                        }
                    } else {
                        a aVar2 = new a();
                        aVar2.type = bh(obj);
                        if (aVar2.type != -1) {
                            aVar2.cvi = obj.toString();
                            q = this.nob.q(substring, aVar2);
                            if (q && this.nod.contains(substring)) {
                                this.nod.remove(substring);
                            }
                        } else {
                            return;
                        }
                    }
                    if (q) {
                        b(obj == null ? 5 : 4, this, aVar);
                    }
                    if (z) {
                        iB(true);
                    }
                }
            }
        }
    }

    private static boolean a(String str, Object obj, boolean z) {
        if (obj == null && z) {
            return true;
        }
        if (str.equals("INT") && (obj instanceof Integer)) {
            return true;
        }
        if (str.equals("LONG") && (obj instanceof Long)) {
            return true;
        }
        if (str.equals("STRING") && (obj instanceof String)) {
            return true;
        }
        if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            return true;
        }
        if (str.equals("FLOAT") && (obj instanceof Float)) {
            return true;
        }
        if (str.equals("DOUBLE") && (obj instanceof Double)) {
            return true;
        }
        if (z) {
            v.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
        }
        return false;
    }

    private static int bh(Object obj) {
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 2;
        }
        if (obj instanceof String) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 5;
        }
        if (obj instanceof Double) {
            return 6;
        }
        v.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
        return -1;
    }

    private static Object j(int i, String str) {
        switch (i) {
            case 1:
                try {
                    return Integer.valueOf(str);
                } catch (Throwable e) {
                    v.e("MicroMsg.ConfigStorage", "exception:%s", be.e(e));
                    break;
                }
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                return Double.valueOf(str);
        }
        return null;
    }

    protected final boolean EP() {
        if (this.cuX != null && !this.cuX.buA()) {
            return true;
        }
        String str = "MicroMsg.ConfigStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.cuX == null ? "null" : Boolean.valueOf(this.cuX.buA());
        v.w(str, str2, objArr);
        return false;
    }

    public final boolean Ke() {
        if (this.cuX.inTransaction()) {
            v.i("MicroMsg.ConfigStorage", "summer preAppend inTransaction return false");
            return false;
        }
        this.ddm = this.cuX.er(Thread.currentThread().getId());
        if (this.ddm > 0) {
            return true;
        }
        v.i("MicroMsg.ConfigStorage", "summer preAppend ticket: " + this.ddm + " return false");
        return false;
    }

    public final void a(ar<Object, Object> arVar, b<Object, Object> bVar) {
        Object obj = bVar.lTL;
        Object obj2 = bVar.values;
        int i = bVar.nkN;
        ContentValues contentValues;
        switch (((Integer) arVar.getTag()).intValue()) {
            case 1:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar = (a) obj2;
                        if (aVar.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put("id", (Integer) bVar.lTL);
                            contentValues.put("type", Integer.valueOf(aVar.type));
                            contentValues.put("value", aVar.cvi.toString());
                            this.cuX.replace("userinfo", "id", contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.cuX.delete("userinfo", "id=" + obj, null);
                    return;
                } else {
                    return;
                }
            case 3:
                if (i == 1) {
                    if (obj2 != null && (obj2 instanceof a)) {
                        a aVar2 = (a) obj2;
                        if (aVar2.type != -1) {
                            contentValues = new ContentValues();
                            contentValues.put("sid", (String) bVar.lTL);
                            contentValues.put("type", Integer.valueOf(aVar2.type));
                            contentValues.put("value", aVar2.cvi.toString());
                            this.cuX.replace("userinfo2", "id", contentValues);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 2) {
                    this.cuX.delete("userinfo2", "sid=" + obj, null);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void Kf() {
        if (this.ddm > 0) {
            this.cuX.es(this.ddm);
        }
    }

    public final void iB(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.noa.iy(z);
        this.nob.iy(z);
        v.i("MicroMsg.ConfigStorage", "summer config appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final void setInt(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public final int getInt(int i, int i2) {
        Integer num = (Integer) get(i, null);
        return num == null ? i2 : num.intValue();
    }

    public final void setLong(int i, long j) {
        set(i, Long.valueOf(j));
    }

    public final long vc(int i) {
        Long l = (Long) get(i, null);
        return l == null ? 0 : l.longValue();
    }
}
