package b.a.d;

import java.io.OutputStream;

public final class a {
    public final String mEw;
    public final String pOQ;
    public final String pOR;
    public final String pOS;
    public final h pOU;
    private final OutputStream pOV;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.pOQ = str;
        this.pOR = str2;
        this.pOS = str3;
        this.pOU = hVar;
        this.mEw = str4;
        this.pOV = outputStream;
    }

    public final void sP(String str) {
        if (this.pOV != null) {
            try {
                this.pOV.write(new StringBuilder(String.valueOf(str)).append("\n").toString().getBytes("UTF8"));
            } catch (Throwable e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
