package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.v;

public abstract class m implements OnClickListener {
    private long iZR = -1;

    public abstract void ayv();

    public void onClick(View view) {
        v.i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.iZR != -1) {
            if ((System.nanoTime() - this.iZR) / 1000000 < 3000) {
                v.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[]{Long.valueOf((System.nanoTime() - this.iZR) / 1000000), Long.valueOf(3000)});
                return;
            }
        }
        this.iZR = System.nanoTime();
        ayv();
    }
}
