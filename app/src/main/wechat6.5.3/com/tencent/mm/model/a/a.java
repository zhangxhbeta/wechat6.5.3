package com.tencent.mm.model.a;

import java.util.HashMap;

public final class a {
    public String cvN;
    public String cvO;
    public String cvP;
    public String cvQ;
    public HashMap<String, d> cvR = new HashMap();

    public final d ga(String str) {
        if (this.cvR == null || !this.cvR.containsKey(str)) {
            return null;
        }
        return (d) this.cvR.get(str);
    }
}
