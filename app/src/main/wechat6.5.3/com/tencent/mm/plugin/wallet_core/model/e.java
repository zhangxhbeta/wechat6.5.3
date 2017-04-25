package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.b.b;

public final class e {
    public int kNL = 0;
    public String kNM = "";
    public int kNN = 0;
    public String kNO = "";
    public int kNP = 0;
    public b kNQ = new b();

    public e(Bundle bundle) {
        this.kNL = bundle.getInt("key_is_gen_cert", 0);
        this.kNN = bundle.getInt("key_is_hint_crt", 0);
        this.kNP = bundle.getInt("key_is_ignore_cert", 0);
        this.kNM = bundle.getString("key_crt_token", "");
        this.kNO = bundle.getString("key_crt_wording", "");
        this.kNQ = new b(this.kNO);
    }

    public final boolean bfK() {
        if (this.kNN == 0 || be.kS(this.kNO)) {
            return false;
        }
        return true;
    }

    public final boolean bfL() {
        if (this.kNL == 1) {
            return true;
        }
        return false;
    }
}
