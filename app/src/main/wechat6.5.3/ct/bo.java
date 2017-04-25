package ct;

import android.os.Bundle;

public abstract class bo {
    private String a;
    private String b;
    private boolean c = true;

    protected abstract boolean a(Bundle bundle);

    public bo(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean b(Bundle bundle) {
        if (this.c) {
            return a(bundle);
        }
        return false;
    }

    public void a() {
    }

    public String toString() {
        return "[name=" + this.a + ",desc=" + this.b + ",enabled=" + this.c + "]";
    }
}
