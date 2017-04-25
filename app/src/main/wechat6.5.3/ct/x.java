package ct;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

public final class x {
    public static aa a(z zVar) {
        aa a;
        bd.b();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a = new ac(zVar).a();
        } catch (Throwable th) {
            a = new aa();
            a.a = -19;
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        bd.b();
        return a;
    }

    public static z a(String str, byte[] bArr) {
        return b(str, bArr);
    }

    private static z b(String str, byte[] bArr) {
        try {
            URL url = new URL(be.c(str));
            z zVar = new z(url.getHost(), new int[]{url.getPort()});
            if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("https://")) {
                zVar.a = true;
            }
            zVar.g = url.getFile();
            zVar.j = bArr;
            zVar.d = str;
            return zVar;
        } catch (MalformedURLException e) {
            throw new ah("url format error:" + str);
        }
    }
}
