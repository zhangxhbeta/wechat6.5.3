package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.br;

enum n {
    NAVIGATE_TO(an.NAME),
    NAVIGATE_BACK(am.NAME),
    REDIRECT_TO(as.NAME),
    SWITCH_TAB(br.NAME);
    
    private final String type;

    private n(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
