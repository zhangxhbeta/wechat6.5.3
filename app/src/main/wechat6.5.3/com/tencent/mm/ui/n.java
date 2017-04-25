package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.v;

public abstract class n implements OnMenuItemClickListener {
    private long iZR = -1;

    public abstract void bfd();

    public boolean onMenuItemClick(MenuItem menuItem) {
        v.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.iZR != -1) {
            if ((System.nanoTime() - this.iZR) / 1000000 < 500) {
                v.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf((System.nanoTime() - this.iZR) / 1000000), Long.valueOf(500));
                return false;
            }
        }
        this.iZR = System.nanoTime();
        bfd();
        return false;
    }
}
