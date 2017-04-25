package com.tencent.mm.plugin.webview.d;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.v;

public class ag {
    public static ag leA;
    public boolean hasInit;
    public e leB = null;

    public static ag bim() {
        if (leA != null) {
            return leA;
        }
        synchronized (ag.class) {
            if (leA == null) {
                leA = new ag();
            }
        }
        return leA;
    }

    public final void setNetWorkState(int i) {
        String str = "MicroMsg.WebViewVideoProxy";
        String str2 = "set networkd state = %d, callbacker == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.leB == null);
        v.i(str, str2, objArr);
        if (this.leB != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i);
            try {
                this.leB.i(5005, bundle);
            } catch (Exception e) {
                v.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
