package ct;

import android.content.Context;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import ct.b.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class cb implements TencentHttpClient {
    private static final List<String> a = Arrays.asList(new String[]{"lbssp.map.qq.com", "lbs.map.qq.com"});
    private static x b;

    public cb(Context context, String str) {
        try {
            a.a(context, "0M3006CS7U0ZC2K3", str, "test_uuid", a);
            b = a.a();
        } catch (Throwable e) {
            a.a("TxNewHttpClient", "<init>", e);
        }
    }

    public final Pair<byte[], String> postSync(String str, byte[] bArr) {
        if (b == null) {
            throw new IOException("can not init net sdk");
        }
        try {
            z a = x.a(str, bArr);
            a.a("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            a.a();
            aa a2 = x.a(a);
            if (a2 == null) {
                throw new IOException("null response");
            }
            switch (a2.a()) {
                case -2:
                    return Pair.create("{}".getBytes(), "utf-8");
                case 0:
                    return Pair.create(a2.b(), a(a2.a("content-type")));
                default:
                    throw new IOException("net sdk error: " + a2.a());
            }
        } catch (ah e) {
            throw new IOException(e.getMessage());
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static String a(String str) {
        String str2 = "GBK";
        if (str == null) {
            return str2;
        }
        for (String trim : str.split(";")) {
            String trim2 = trim2.trim();
            int indexOf = trim2.indexOf("charset=");
            if (-1 != indexOf) {
                return trim2.substring(indexOf + 8, trim2.length());
            }
        }
        return str2;
    }
}
