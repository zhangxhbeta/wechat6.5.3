package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.List;

public final class s extends n {
    public List<a> iBY = new ArrayList();
    public String jwf = "";
    public float jwg;
    public String jwh = "";
    public int jwi;
    public int jwj;
    public int jwk;
    public int jwl;
    public String jwm = "";

    public static class a {
        public String jwn = "";
        public String label = "";
        public float value;

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.label.equals(this.label) && aVar.jwn.equals(this.jwn) && aVar.value == this.value) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (int) (((float) (this.label.hashCode() + this.jwn.hashCode())) + this.value);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r5 != r4) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
        if (r2 == 0) goto L_0x0079;
    L_0x0009:
        r5 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s) r5;
        r2 = r5.jwf;
        if (r2 != 0) goto L_0x004d;
    L_0x000f:
        r2 = r4.jwf;
        if (r2 != 0) goto L_0x004b;
    L_0x0013:
        r2 = r5.jwg;
        r3 = r4.jwg;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x004b;
    L_0x001b:
        r2 = r5.jwh;
        if (r2 != 0) goto L_0x0058;
    L_0x001f:
        r2 = r4.jwh;
        if (r2 != 0) goto L_0x004b;
    L_0x0023:
        r2 = r5.jwi;
        r3 = r4.jwi;
        if (r2 != r3) goto L_0x004b;
    L_0x0029:
        r2 = r5.jwj;
        r3 = r4.jwj;
        if (r2 != r3) goto L_0x004b;
    L_0x002f:
        r2 = r5.jwk;
        r3 = r4.jwk;
        if (r2 != r3) goto L_0x004b;
    L_0x0035:
        r2 = r5.jwl;
        r3 = r4.jwl;
        if (r2 != r3) goto L_0x004b;
    L_0x003b:
        r2 = r5.iBY;
        if (r2 != 0) goto L_0x0063;
    L_0x003f:
        r2 = r4.iBY;
        if (r2 != 0) goto L_0x004b;
    L_0x0043:
        r2 = r5.jwm;
        if (r2 != 0) goto L_0x006e;
    L_0x0047:
        r2 = r4.jwm;
        if (r2 == 0) goto L_0x0004;
    L_0x004b:
        r0 = r1;
        goto L_0x0004;
    L_0x004d:
        r2 = r5.jwf;
        r3 = r4.jwf;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x0057:
        goto L_0x0013;
    L_0x0058:
        r2 = r5.jwh;
        r3 = r4.jwh;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x0062:
        goto L_0x0023;
    L_0x0063:
        r2 = r5.iBY;
        r3 = r4.iBY;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x006d:
        goto L_0x0043;
    L_0x006e:
        r2 = r5.jwm;
        r3 = r4.jwm;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x0078:
        goto L_0x0004;
    L_0x0079:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
