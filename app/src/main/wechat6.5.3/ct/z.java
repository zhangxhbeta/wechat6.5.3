package ct;

import android.text.TextUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class z {
    public boolean a = false;
    public boolean b = true;
    public String c = null;
    public String d = null;
    public int[] e = null;
    public String f = SQLiteDatabase.KeyEmpty;
    public String g = null;
    public boolean h = true;
    public boolean i = true;
    public byte[] j = null;
    public long k = 0;
    public long l = 0;
    public int m = WXMediaMessage.THUMB_LENGTH_LIMIT;
    public int n = 10000;
    public int o = 3;
    public boolean p = true;
    public String q = SQLiteDatabase.KeyEmpty;
    private Map r = new HashMap();
    private volatile boolean s = false;

    public z(String str, int[] iArr) {
        this.c = str;
        this.e = iArr;
        if (this.e == null || this.e[0] == -1) {
            this.f = this.c;
        } else {
            this.f = this.c + ":" + this.e[0];
        }
        this.q = be.b(this.c);
        this.k = System.currentTimeMillis();
    }

    public final void a() {
        this.m = WXMediaMessage.THUMB_LENGTH_LIMIT;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.r.put(str, str2);
        }
    }

    public final Map b() {
        Map hashMap = new HashMap();
        hashMap.putAll(this.r);
        return hashMap;
    }
}
