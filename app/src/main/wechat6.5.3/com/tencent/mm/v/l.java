package com.tencent.mm.v;

import com.tencent.mm.model.al;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.sdk.platformtools.v;

public abstract class l extends k implements j {
    protected int czX = 3;
    private boolean czY = false;

    public abstract void BG();

    public abstract e BH();

    public abstract void a(int i, int i2, String str, p pVar);

    public abstract hu c(p pVar);

    public abstract ajs d(p pVar);

    public abstract acg e(p pVar);

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 4 && i3 == -301) {
            v.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[]{Integer.valueOf(this.czX)});
            if (pVar != null) {
                v.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                al.a(true, c(pVar), d(pVar), e(pVar));
            }
            this.czX--;
            if (this.czX <= 0) {
                BG();
                this.czY = false;
                return;
            }
            v.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            a(this.czE, BH());
            return;
        }
        a(i2, i3, str, pVar);
    }
}
