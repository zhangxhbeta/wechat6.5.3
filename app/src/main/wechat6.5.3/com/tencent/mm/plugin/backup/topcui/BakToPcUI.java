package com.tencent.mm.plugin.backup.topcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.backup.bakpcmodel.c.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI extends MMWizardActivity implements a {
    private Button emR;
    private Button emS;
    private TextView emT;
    private TextView emU;
    private ac handler = new ac(Looper.getMainLooper());
    private int of = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            NI();
            this.of = b.UK().egh;
            v.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.of)});
            b.UK().egb = this;
            WE();
        }
    }

    public final void NI() {
        vD(2131231310);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakToPcUI emV;

            {
                this.emV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                b.UK().hW(1);
                this.emV.bAv();
                return true;
            }
        });
        this.emR = (Button) findViewById(2131755536);
        this.emR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakToPcUI emV;

            {
                this.emV = r1;
            }

            public final void onClick(View view) {
                if (this.emV.of == 0) {
                    b.UO().csO = 1;
                    b.UK().hW(0);
                    MMWizardActivity.w(this.emV, new Intent(this.emV, BakWaitingUI.class));
                }
            }
        });
        this.emS = (Button) findViewById(2131755537);
        this.emS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakToPcUI emV;

            {
                this.emV = r1;
            }

            public final void onClick(View view) {
                if (this.emV.of == 0) {
                    b.UO().csO = 2;
                    b.UO().zR();
                    b.UK().hW(1);
                    this.emV.bAv();
                }
            }
        });
        this.emT = (TextView) findViewById(2131755534);
        this.emT.setText(b.UK().eaU);
        this.emU = (TextView) findViewById(2131755535);
        this.emU.setText(b.UK().eaV);
    }

    protected final int getLayoutId() {
        return 2130903155;
    }

    public void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.of)});
        b.UK().egb = null;
    }

    public final void UA() {
        this.of = 0;
        this.emR.setVisibility(0);
        this.emS.setVisibility(0);
        new ac(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ BakToPcUI emV;

            {
                this.emV = r1;
            }

            public final void run() {
                this.emV.WE();
            }
        });
    }

    private void WE() {
        if (this.of == 0) {
            this.emR.setEnabled(true);
            this.emS.setEnabled(true);
            return;
        }
        this.emR.setEnabled(false);
        this.emS.setEnabled(false);
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakToPcUI emV;

            public final void run() {
                v.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    v.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.emV.getString(2131231231));
                    intent.putExtra("rawUrl", this.emV.getString(2131236705, new Object[]{u.bsY()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    c.b(this.emV, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                this.emV.bAv();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        b.UO().csO = 3;
        b.UO().zR();
        b.UK().hW(1);
        bAv();
        return true;
    }
}
