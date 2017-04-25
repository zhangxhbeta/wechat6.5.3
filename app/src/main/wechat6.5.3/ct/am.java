package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class am extends bh {
    private static ArrayList e;
    private static Map f;
    public ArrayList a = null;
    public String b = SQLiteDatabase.KeyEmpty;
    private int c = 0;
    private Map d = null;

    public final void a(bf bfVar) {
        this.c = bfVar.a(this.c, 0, true);
        if (e == null) {
            e = new ArrayList();
            e.add(SQLiteDatabase.KeyEmpty);
        }
        this.a = (ArrayList) bfVar.a(e, 1, true);
        this.b = bfVar.a(2, false);
        if (f == null) {
            f = new HashMap();
            f.put(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        }
        this.d = (Map) bfVar.a(f, 3, false);
    }

    public final void a(bg bgVar) {
        bgVar.a(this.c, 0);
        bgVar.a(this.a, 1);
        if (this.b != null) {
            bgVar.a(this.b, 2);
        }
        if (this.d != null) {
            bgVar.a(this.d, 3);
        }
    }
}
