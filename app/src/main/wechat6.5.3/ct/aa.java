package ct;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class aa {
    public int a = 1;
    public String b = null;
    public byte[] c = null;
    public InputStream d = null;
    public String e;
    public long f;
    public Map g = new HashMap();

    public final int a() {
        return this.a;
    }

    public final String a(String str) {
        return this.g != null ? (String) this.g.get(str) : null;
    }

    public final byte[] b() {
        return this.c;
    }
}
