package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

public final class t {
    public float height;
    public String iconUrl;
    public float jvJ;
    public float width;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (tVar.iconUrl.equals(this.iconUrl) && tVar.width == this.width && tVar.height == this.height && tVar.jvJ == this.jvJ) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
