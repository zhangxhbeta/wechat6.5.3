package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class bj extends bh {
    private static byte[] k = null;
    private static Map l = null;
    public short a = (short) 3;
    public int b = 0;
    public String c = null;
    public String d = null;
    public byte[] e;
    private byte f = (byte) 0;
    private int g = 0;
    private int h = 0;
    private Map i;
    private Map j;

    public final void a(bf bfVar) {
        try {
            Map hashMap;
            this.a = bfVar.a(this.a, 1, true);
            this.f = bfVar.a(this.f, 2, true);
            this.g = bfVar.a(this.g, 3, true);
            this.b = bfVar.a(this.b, 4, true);
            this.c = bfVar.a(5, true);
            this.d = bfVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.e = bfVar.b(7, true);
            this.h = bfVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            }
            this.i = (Map) bfVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            }
            this.j = (Map) bfVar.a(l, 10, true);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void a(bg bgVar) {
        bgVar.a(this.a, 1);
        bgVar.a(this.f, 2);
        bgVar.a(this.g, 3);
        bgVar.a(this.b, 4);
        bgVar.a(this.c, 5);
        bgVar.a(this.d, 6);
        bgVar.a(this.e, 7);
        bgVar.a(this.h, 8);
        bgVar.a(this.i, 9);
        bgVar.a(this.j, 10);
    }
}
