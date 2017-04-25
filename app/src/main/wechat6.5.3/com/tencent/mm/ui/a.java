package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.i;

public abstract class a extends i implements i {
    private Bundle jKK;
    private boolean nzg;
    private boolean nzh;
    private boolean nzi;
    private boolean nzj;
    protected boolean nzk = false;
    protected boolean nzl = false;
    protected boolean nzm;

    protected abstract void bys();

    protected abstract void byt();

    protected abstract void byu();

    protected abstract void byv();

    protected abstract void byw();

    protected abstract void byx();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.jKK = bundle;
        this.nzh = true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void onResume() {
        super.onResume();
        byC();
        LauncherUI bzB = LauncherUI.bzB();
        if (bzB != null && bzB.nBe) {
            this.nzk = true;
            if (this.nzl) {
                byE();
                this.nzl = false;
            }
        }
    }

    public final void byB() {
        byz();
        this.nzi = true;
    }

    public final void byE() {
        if (this.nzk) {
            if (this.nzh) {
                bys();
                this.nzh = false;
            } else if (this.nzg) {
                byx();
                bys();
                v.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
                this.nzg = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.nzi) {
                byA();
                this.nzi = false;
            }
            byt();
            v.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.nzj = true;
            this.nzk = false;
        }
    }

    public final void byD() {
        this.nzl = true;
    }

    public final void onPause() {
        super.onPause();
        this.nzm = true;
        if (!this.nzm) {
            return;
        }
        if (this.nzj) {
            long currentTimeMillis = System.currentTimeMillis();
            byv();
            v.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.nzj = false;
            this.nzm = false;
            return;
        }
        this.nzm = false;
    }

    public final void onStop() {
        super.onStop();
        byw();
    }

    public final void onStart() {
        super.onStart();
        LauncherUI bzB = LauncherUI.bzB();
        if (bzB != null && bzB.nBe) {
            byu();
        }
    }

    public void onDestroy() {
        byx();
        super.onDestroy();
    }
}
