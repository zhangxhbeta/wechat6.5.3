package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

@a(19)
public class DataTransferUI extends MMBaseActivity {
    private p dwE;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(2131231164);
        this.dwE = g.a(this, getString(2131231018), false, null);
        new ac(this) {
            final /* synthetic */ DataTransferUI nAq;

            {
                this.nAq = r1;
            }

            public final void handleMessage(Message message) {
                if (this.nAq.dwE != null && this.nAq.dwE.isShowing()) {
                    v.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
                    this.nAq.dwE.dismiss();
                    this.nAq.finish();
                }
            }
        }.sendEmptyMessageDelayed(0, 60000);
        U(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        v.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        U(intent);
    }

    private void U(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        v.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
    }

    protected void onPause() {
        v.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        v.d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.dwE != null && this.dwE.isShowing()) {
            this.dwE.dismiss();
        }
    }
}
