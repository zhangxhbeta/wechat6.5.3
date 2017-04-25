package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class al extends bh {
    private static Map h;
    private static an i;
    private static aj j;
    private static Map k;
    private static Map l;
    public Map a = null;
    public an b = null;
    public aj c = null;
    private String d = SQLiteDatabase.KeyEmpty;
    private int e = 0;
    private Map f = null;
    private Map g = null;

    public final void a(bf bfVar) {
        this.d = bfVar.a(0, true);
        this.e = bfVar.a(this.e, 1, true);
        if (h == null) {
            h = new HashMap();
            h.put(SQLiteDatabase.KeyEmpty, new am());
        }
        this.a = (Map) bfVar.a(h, 2, true);
        if (i == null) {
            i = new an();
        }
        this.b = (an) bfVar.a(i, 3, false);
        if (j == null) {
            j = new aj();
        }
        this.c = (aj) bfVar.a(j, 4, false);
        if (k == null) {
            k = new HashMap();
            k.put(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        }
        this.f = (Map) bfVar.a(k, 5, false);
        if (l == null) {
            l = new HashMap();
            String str = SQLiteDatabase.KeyEmpty;
            byte[] bArr = new byte[1];
            bArr[0] = (byte) 0;
            l.put(str, bArr);
        }
        this.g = (Map) bfVar.a(l, 6, false);
    }

    public final void a(bg bgVar) {
        bgVar.a(this.d, 0);
        bgVar.a(this.e, 1);
        bgVar.a(this.a, 2);
        if (this.b != null) {
            bgVar.a(this.b, 3);
        }
        if (this.c != null) {
            bgVar.a(this.c, 4);
        }
        if (this.f != null) {
            bgVar.a(this.f, 5);
        }
        if (this.g != null) {
            bgVar.a(this.g, 6);
        }
    }
}
