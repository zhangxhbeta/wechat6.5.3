package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.sdk.platformtools.be;

public final class h {
    public int backgroundColor;
    public Object data;
    public int end;
    public String jGE;
    public int linkColor;
    public int start;
    public int type;
    public String url;
    public String username;

    public h(String str, int i, Object obj) {
        this.url = str;
        this.data = obj;
        this.type = i;
    }

    public final <T> T l(Class<T> cls) {
        if (cls.isInstance(this.data)) {
            return cls.cast(this.data);
        }
        return null;
    }

    public final int hashCode() {
        int hashCode = super.hashCode();
        if (!be.kS(this.url)) {
            hashCode += this.url.hashCode();
        }
        hashCode = ((hashCode + this.type) + this.end) + this.start;
        if (this.data != null) {
            return hashCode + this.data.hashCode();
        }
        return hashCode;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return hashCode() == ((h) obj).hashCode();
        } else {
            return super.equals(obj);
        }
    }
}
