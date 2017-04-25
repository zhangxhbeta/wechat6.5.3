package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class bi {
    private static HashMap e = null;
    private HashMap a = new HashMap();
    private bf b = new bf();
    private String c = "GBK";
    private bj d = new bj();

    public final void a(int i) {
        this.d.b = i;
    }

    public final void a(String str) {
        this.d.d = str;
    }

    public final void a(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (obj == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (obj instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            bg bgVar = new bg();
            bgVar.a(this.c);
            bgVar.a(obj, 0);
            ByteBuffer a = bgVar.a();
            Object obj2 = new byte[a.position()];
            System.arraycopy(a.array(), 0, obj2, 0, obj2.length);
            this.a.put(str, obj2);
        }
    }

    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            bf bfVar = new bf(bArr, (byte) 0);
            bfVar.b = this.c;
            this.d.a(bfVar);
            bfVar = new bf(this.d.e);
            bfVar.b = this.c;
            if (e == null) {
                HashMap hashMap = new HashMap();
                e = hashMap;
                hashMap.put(SQLiteDatabase.KeyEmpty, new byte[0]);
            }
            this.a = (HashMap) bfVar.a(new HashMap(), e, 0, false);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final byte[] a() {
        bg bgVar = new bg(0);
        bgVar.a(this.c);
        bgVar.a(this.a, 0);
        this.d.a = (short) 3;
        bj bjVar = this.d;
        ByteBuffer a = bgVar.a();
        Object obj = new byte[a.position()];
        System.arraycopy(a.array(), 0, obj, 0, obj.length);
        bjVar.e = obj;
        bgVar = new bg(0);
        bgVar.a(this.c);
        this.d.a(bgVar);
        a = bgVar.a();
        Object obj2 = new byte[a.position()];
        System.arraycopy(a.array(), 0, obj2, 0, obj2.length);
        int length = obj2.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(obj2).flip();
        return allocate.array();
    }

    public final Object b(String str, Object obj) {
        if (!this.a.containsKey(str)) {
            return null;
        }
        byte[] bArr = (byte[]) this.a.get(str);
        try {
            this.b.a = ByteBuffer.wrap(bArr);
            this.b.b = this.c;
            return this.b.a(obj, 0, true);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    public final void b(String str) {
        this.d.c = str;
    }
}
