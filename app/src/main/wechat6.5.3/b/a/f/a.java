package b.a.f;

import b.a.g.c;
import b.a.g.d;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class a implements b {
    public final String ac(String str, String str2, String str3) {
        try {
            d.es(str, "Base string cant be null or empty string");
            d.es(str2, "Api secret cant be null or empty string");
            Key secretKeySpec = new SecretKeySpec((c.encode(str2) + '&' + c.encode(str3)).getBytes("UTF-8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return new String(b.a.g.a.bR(instance.doFinal(str.getBytes("UTF-8")))).replace("\r\n", "");
        } catch (Exception e) {
            throw new b.a.b.d(str, e);
        }
    }

    public final String bRv() {
        return "HMAC-SHA1";
    }
}
