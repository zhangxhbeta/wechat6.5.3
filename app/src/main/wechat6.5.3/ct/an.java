package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class an extends bh {
    private static Map c;
    public Map a = null;
    public long b = 0;

    public final void a(bf bfVar) {
        if (c == null) {
            c = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(SQLiteDatabase.KeyEmpty);
            c.put(valueOf, arrayList);
        }
        this.a = (Map) bfVar.a(c, 0, false);
        this.b = bfVar.a(this.b, 1, false);
    }

    public final void a(bg bgVar) {
        if (this.a != null) {
            bgVar.a(this.a, 0);
        }
        bgVar.a(this.b, 1);
    }
}
