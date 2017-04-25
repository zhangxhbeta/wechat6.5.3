package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class d {
    private c hat;

    public d() {
        init();
    }

    private void init() {
        this.hat = new c();
        ak.yW();
        String str = (String) c.vf().get(356355, null);
        if (be.kS(str)) {
            this.hat.haj = 2000.0d;
            this.hat.hai = 100;
            this.hat.han = 200.0d;
            this.hat.hao = 0.01d;
            this.hat.ham = 200.0d;
        } else {
            try {
                this.hat.az(str.getBytes("ISO-8859-1"));
            } catch (Exception e) {
                v.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
                this.hat.haj = 2000.0d;
                this.hat.hai = 100;
                this.hat.han = 200.0d;
                this.hat.hao = 0.01d;
                this.hat.ham = 200.0d;
            }
        }
        v.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.hat.haj + " maxTotalNum:" + this.hat.hai + " perGroupMaxValue:" + this.hat.han + " perMinValue:" + this.hat.hao + " perPersonMaxValue:" + this.hat.ham);
    }

    public final void a(c cVar) {
        this.hat = cVar;
        v.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + this.hat.haj + " maxTotalNum:" + this.hat.hai + " perGroupMaxValue:" + this.hat.han + " perMinValue:" + this.hat.hao + " perPersonMaxValue:" + this.hat.ham);
        try {
            String str = new String(this.hat.toByteArray(), "ISO-8859-1");
            ak.yW();
            c.vf().set(356355, str);
            ak.yW();
            c.vf().iB(true);
        } catch (UnsupportedEncodingException e) {
            v.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
        } catch (IOException e2) {
            v.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
        }
    }

    public final c axE() {
        if (this.hat == null) {
            init();
        }
        return this.hat;
    }
}
