package ct;

import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class s {
    public String a = SQLiteDatabase.KeyEmpty;
    public int b = -1;

    public s(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final String a() {
        return this.a + ":" + this.b;
    }

    public final boolean a(s sVar) {
        return sVar != null && this.a.equals(sVar.a) && this.b == sVar.b;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split(":");
        if (split.length != 2) {
            return false;
        }
        this.a = split[0];
        try {
            this.b = Integer.parseInt(split[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public final String toString() {
        return this.b == -1 ? this.a : a();
    }
}
