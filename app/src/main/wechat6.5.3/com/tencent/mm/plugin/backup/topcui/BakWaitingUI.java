package com.tencent.mm.plugin.backup.topcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.bakpcmodel.c.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements c {
    private boolean emW;
    private ac handler = new ac(Looper.getMainLooper());
    private int of;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            b.UK().ega = this;
            this.of = b.UK().egh;
            this.emW = getIntent().getBooleanExtra("from_back_finish", false);
            v.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.of), Boolean.valueOf(this.emW)});
            NI();
            WF();
        }
    }

    protected final void NI() {
        vD(2131231310);
        if (this.emW) {
            findViewById(2131755538).setVisibility(8);
        } else {
            findViewById(2131755538).setVisibility(0);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakWaitingUI emX;

            {
                this.emX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.emX.bAv();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903159;
    }

    public final void hZ(int i) {
        this.of = i;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI emX;

            {
                this.emX = r1;
            }

            public final void run() {
                this.emX.WF();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        b.UK().ega = null;
        v.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.of), Boolean.valueOf(this.emW)});
    }

    public final void ia(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI emX;

            public final void run() {
                v.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    v.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.emX.getString(2131231231));
                    intent.putExtra("rawUrl", this.emX.getString(2131236705, new Object[]{u.bsY()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    com.tencent.mm.ay.c.b(this.emX, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    final void WF() {
        if (6 == this.of || 1 == this.of) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.of);
            MMWizardActivity.w(this, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bAv();
        return true;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI emX;

            public final void run() {
                v.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    v.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.emX.getString(2131231231));
                    intent.putExtra("rawUrl", this.emX.getString(2131236705, new Object[]{u.bsY()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    com.tencent.mm.ay.c.b(this.emX, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                MMWizardActivity.w(this.emX, new Intent(this.emX, BakConnErrorUI.class));
            }
        });
    }
}
