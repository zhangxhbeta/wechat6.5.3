package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.be;

public final class a {
    public String bhe;
    public String hcm;
    public String hcn;
    public String kMP;

    public final boolean bfE() {
        return (be.kS(this.bhe) || be.kS(this.hcm) || be.kS(this.hcn) || be.kS(this.kMP)) ? false : true;
    }
}
