package b.a.d;

import b.a.g.d;
import java.io.Serializable;

public final class i implements Serializable {
    public final String mIu;
    private final String pPo;
    public final String token;

    public i(String str, String str2) {
        this(str, str2, null);
    }

    public i(String str, String str2, String str3) {
        d.c(str, "Token can't be null");
        d.c(str2, "Secret can't be null");
        this.token = str;
        this.mIu = str2;
        this.pPo = str3;
    }

    public final String toString() {
        return String.format("Token[%s , %s]", new Object[]{this.token, this.mIu});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.token.equals(iVar.token) && this.mIu.equals(iVar.mIu)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.token.hashCode() * 31) + this.mIu.hashCode();
    }
}
