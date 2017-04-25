package com.tencent.mm.wallet_core.e.a;

import org.json.JSONObject;

public abstract class j extends g {
    private String biS = "";
    private int errCode = 0;
    public boolean pji = false;
    public boolean pjj = false;

    public void a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.biS = str;
    }

    public final boolean aKe() {
        return !this.pjj;
    }
}
