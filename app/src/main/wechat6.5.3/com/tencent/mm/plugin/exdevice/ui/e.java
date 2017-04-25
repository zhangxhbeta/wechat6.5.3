package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e {
    int aeu;
    d fGm;
    int fGn;

    static class a {
        int aeu;
        String fDn;
        d fGm = null;
        int fGn;
        String username;

        public final e akF() {
            return new e(this.aeu, this.fGn, this.fDn, this.username, this.fGm);
        }
    }

    private e(int i, int i2, String str, String str2, d dVar) {
        this.aeu = i;
        this.fGn = i2;
        if (i == 0) {
            return;
        }
        if (dVar != null) {
            this.fGm = dVar;
            return;
        }
        d dVar2 = new d();
        dVar2.field_username = str2;
        dVar2.field_appusername = str;
        dVar2.field_ranknum = 0;
        dVar2.field_selfLikeState = 0;
        dVar2.field_rankID = "";
        dVar2.field_likecount = 0;
        dVar2.field_score = 0;
        this.fGm = dVar2;
    }

    public final String toString() {
        String str = "{ view type: " + this.aeu + " display flag: " + this.fGn;
        if (this.fGm != null) {
            str = str + this.fGm.toString();
        } else {
            str = str + " mExdeviceRankInfo is null";
        }
        return str + "}";
    }
}
