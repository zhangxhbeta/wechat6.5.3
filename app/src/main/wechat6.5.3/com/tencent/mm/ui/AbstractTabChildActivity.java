package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.b;
import com.tencent.mm.sdk.platformtools.v;

public abstract class AbstractTabChildActivity extends ActionBarActivity {

    public static abstract class a extends p implements b, com.tencent.mm.pluginsdk.ui.tools.p.a, i {
        private boolean nzg;
        private boolean nzh;
        private boolean nzi;
        protected boolean nzj;
        protected boolean nzk = false;
        protected boolean nzl = false;
        protected boolean nzm;

        public abstract void byA();

        public abstract void bys();

        public abstract void byt();

        public abstract void byu();

        public abstract void byv();

        public abstract void byw();

        public abstract void byx();

        public abstract void byy();

        public abstract void byz();

        public final void Oh() {
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.nzh = true;
        }

        public int getLayoutId() {
            return 0;
        }

        public final void byB() {
            byz();
            this.nzi = true;
        }

        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }

        public void onResume() {
            super.onResume();
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null && bzB.nBe) {
                this.nzk = true;
                if (this.nzl) {
                    byE();
                    this.nzl = false;
                }
            }
        }

        public final void byC() {
        }

        public final void byD() {
            this.nzl = true;
        }

        public void onPause() {
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

        public final void byE() {
            if (this.nzk) {
                if (this.nzh) {
                    bys();
                    this.nzh = false;
                } else if (this.nzg) {
                    byx();
                    bys();
                    v.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
                    this.nzg = false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (this.nzi) {
                    this.nzi = false;
                    byA();
                }
                byt();
                v.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
                this.nzj = true;
                this.nzk = false;
            }
        }

        public final void onStop() {
            super.onStop();
            byw();
        }

        public void onStart() {
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

        public boolean aXG() {
            return false;
        }
    }
}
