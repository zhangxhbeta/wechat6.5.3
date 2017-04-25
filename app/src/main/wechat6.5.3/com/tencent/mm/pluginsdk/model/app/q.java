package com.tencent.mm.pluginsdk.model.app;

final class q {
    public String appId;
    public int cYK;

    public q(String str, int i) {
        this.appId = str;
        this.cYK = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (qVar.appId.equals(this.appId) && qVar.cYK == this.cYK) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.appId + this.cYK;
    }
}
