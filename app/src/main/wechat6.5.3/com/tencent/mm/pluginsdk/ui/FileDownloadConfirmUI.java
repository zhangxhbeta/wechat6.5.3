package com.tencent.mm.pluginsdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class FileDownloadConfirmUI extends MMBaseActivity {
    private h doc = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903518);
        final long longExtra = getIntent().getLongExtra("extra_download_id", -1);
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ FileDownloadConfirmUI lGr;

            public final void onClick(DialogInterface dialogInterface, int i) {
                d.bnK().dm(longExtra);
                v.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[]{Long.valueOf(longExtra)});
            }
        };
        OnClickListener anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ FileDownloadConfirmUI lGr;

            {
                this.lGr = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        OnDismissListener anonymousClass3 = new OnDismissListener(this) {
            final /* synthetic */ FileDownloadConfirmUI lGr;

            {
                this.lGr = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.lGr.finish();
            }
        };
        a aVar = new a(this);
        aVar.Op("");
        aVar.wn(2131232763);
        aVar.wp(2131231183).a(anonymousClass1);
        aVar.wq(2131231104).b(anonymousClass2);
        aVar.a(anonymousClass3);
        this.doc = aVar.RX();
        this.doc.show();
        v.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    }

    protected void onStop() {
        super.onStop();
        this.doc.dismiss();
    }
}
