package b.a.d;

import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    public Map<String, String> pOZ = new HashMap();

    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public final /* bridge */ /* synthetic */ e bRk() {
        return super.bRk();
    }

    public final /* bridge */ /* synthetic */ j bRl() {
        return super.bRl();
    }

    public final /* bridge */ /* synthetic */ String bRm() {
        return super.bRm();
    }

    public final /* bridge */ /* synthetic */ String bRn() {
        return super.bRn();
    }

    public final /* bridge */ /* synthetic */ g bRo() {
        return super.bRo();
    }

    public final /* bridge */ /* synthetic */ e bRp() {
        return super.bRp();
    }

    public final /* bridge */ /* synthetic */ String bRq() {
        return super.bRq();
    }

    public final /* bridge */ /* synthetic */ void er(String str, String str2) {
        super.er(str, str2);
    }

    public final /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    public c(j jVar, String str) {
        super(jVar, str);
    }

    public final void eq(String str, String str2) {
        Map map = this.pOZ;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
        } else {
            throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{"scope", "oauth_"}));
        }
    }

    public final String toString() {
        return String.format("@OAuthRequest(%s, %s)", new Object[]{super.bRl(), super.getUrl()});
    }
}
