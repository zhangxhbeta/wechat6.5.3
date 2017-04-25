package com.tencent.mm.performance.wxperformancetool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

@a(3)
public class MemoryLeakActivity extends Activity {
    private String dnU;
    private h doc;
    private ac mHandler = new ac(this) {
        final /* synthetic */ MemoryLeakActivity dod;

        {
            this.dod = r1;
        }

        public final void handleMessage(Message message) {
            if (((WeakReference) d.dol.get(this.dod.dnU)).get() == null) {
                this.dod.finish();
            } else {
                this.dod.doc.show();
            }
        }
    };

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903145);
        h.a aVar = new h.a(this);
        aVar.Op("memory leak");
        this.dnU = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        final String replace = stringExtra2.replace(".", "_");
        aVar.Oq(stringExtra + stringExtra2 + "\n\npath:" + com.tencent.mm.bh.a.nyP + replace + ".zip");
        aVar.jk(true);
        aVar.Os("dumphprof").a(new OnClickListener(this) {
            final /* synthetic */ MemoryLeakActivity dod;

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.bh.a.NT(replace);
                if (this.dod.doc != null && this.dod.doc.isShowing()) {
                    this.dod.doc.dismiss();
                }
                this.dod.finish();
            }
        });
        aVar.Ot("cancel").b(new OnClickListener(this) {
            final /* synthetic */ MemoryLeakActivity dod;

            {
                this.dod = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.dod.doc != null && this.dod.doc.isShowing()) {
                    this.dod.doc.dismiss();
                }
                this.dod.finish();
            }
        });
        aVar.a(new OnDismissListener(this) {
            final /* synthetic */ MemoryLeakActivity dod;

            {
                this.dod = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.dod.finish();
            }
        });
        this.doc = aVar.RX();
        com.tencent.mm.bh.a.bym();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
    }

    protected void onDestroy() {
        super.onDestroy();
        d.dol.remove(this.dnU);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.doc != null && this.doc.isShowing()) {
            this.doc.dismiss();
            this.doc = null;
        }
    }
}
