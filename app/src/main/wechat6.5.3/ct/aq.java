package ct;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class aq {
    private Cipher a;
    private Cipher b;

    public aq(byte[] bArr) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.a = Cipher.getInstance("AES/ECB/PKCS5Padding");
            this.a.init(1, secretKeySpec);
            this.b = Cipher.getInstance("AES/ECB/PKCS5Padding");
            this.b.init(2, secretKeySpec);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final byte[] a(byte[] bArr) {
        try {
            return this.a.doFinal(bArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
