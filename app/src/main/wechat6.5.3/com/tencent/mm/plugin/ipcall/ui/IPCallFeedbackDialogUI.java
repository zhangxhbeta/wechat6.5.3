package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IPCallFeedbackDialogUI extends MMActivity {
    private g gMl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
        this.gMl = new g(this, this.nDR.nEl, getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0));
        this.gMl.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ IPCallFeedbackDialogUI gMm;

            {
                this.gMm = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.gMm.finish();
            }
        });
        this.gMl.getWindow().setSoftInputMode(16);
        this.gMl.show();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        v.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
        super.onResume();
    }

    protected void onNewIntent(Intent intent) {
        v.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        v.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
        super.onDestroy();
    }

    public void finish() {
        v.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
        if (this.gMl != null && this.gMl.isShowing()) {
            this.gMl.dismiss();
            this.gMl = null;
        }
        super.finish();
    }
}
