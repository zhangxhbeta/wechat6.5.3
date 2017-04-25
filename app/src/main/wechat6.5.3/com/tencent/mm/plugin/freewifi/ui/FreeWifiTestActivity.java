package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.g;

public class FreeWifiTestActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903669);
        findViewById(2131757125).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiTestActivity gcV;

            {
                this.gcV = r1;
            }

            public final void onClick(View view) {
                Toast.makeText(aa.getContext(), "test message", 0).show();
            }
        });
        findViewById(2131757126).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiTestActivity gcV;

            {
                this.gcV = r1;
            }

            public final void onClick(View view) {
                g.a(this.gcV, "t12345", "t54331", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 gcW;

                    {
                        this.gcW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, null);
            }
        });
    }
}
