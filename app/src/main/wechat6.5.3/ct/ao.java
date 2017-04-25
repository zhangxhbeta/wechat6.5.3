package ct;

import java.util.HashMap;
import java.util.Map;

public final class ao extends bh {
    private static Map c;
    public Map a = null;
    public int b = 0;

    public final void a(bf bfVar) {
        if (c == null) {
            c = new HashMap();
            c.put(Integer.valueOf(0), Byte.valueOf((byte) 0));
        }
        this.a = (Map) bfVar.a(c, 0, true);
        this.b = bfVar.a(this.b, 1, true);
    }

    public final void a(bg bgVar) {
        bgVar.a(this.a, 0);
        bgVar.a(this.b, 1);
    }
}
