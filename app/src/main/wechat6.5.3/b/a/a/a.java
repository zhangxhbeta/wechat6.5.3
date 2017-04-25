package b.a.a;

import b.a.b.b;
import b.a.d.h;
import b.a.g.d;
import java.io.OutputStream;

public final class a {
    public String mEw;
    public String pOQ;
    public String pOR;
    public String pOS = "oob";
    public b.a.a.a.a pOT;
    public h pOU = h.Header;
    public OutputStream pOV = null;

    public static b.a.a.a.a y(Class<? extends b.a.a.a.a> cls) {
        d.c(cls, "Api class cannot be null");
        try {
            return (b.a.a.a.a) cls.newInstance();
        } catch (Exception e) {
            throw new b("Error while creating the Api object", e);
        }
    }
}
