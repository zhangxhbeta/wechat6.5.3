package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.k;
import com.tencent.mm.model.y;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean lo = false;
    private byte[] ciN = new byte[0];

    protected void onCreate(Bundle bundle) {
        boolean z;
        v.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", Boolean.valueOf(lo));
        super.onCreate(bundle);
        setContentView(2130903145);
        synchronized (this.ciN) {
            if (lo) {
                v.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                finish();
            }
        }
        final String stringExtra = getIntent().getStringExtra("key_user");
        final int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(k.xF())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        v.i(str, str2, objArr);
        if (stringExtra == null) {
            v.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            v.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", Integer.valueOf(intExtra));
            finish();
        } else {
            getString(2131231164);
            final ProgressDialog a = g.a((Context) this, getString(2131236692), false, null);
            ak.vy().a(new ay(new a(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI nAY;

                public final void a(e eVar) {
                    synchronized (this.nAY.ciN) {
                        JSAPIUploadLogHelperUI.lo = true;
                    }
                    ak.vy().a(1, SQLiteDatabase.KeyEmpty, 0, false);
                    v.bta();
                    ak.vy().a(2, stringExtra, intExtra, ak.uz());
                }
            }), 0);
            final OnDismissListener anonymousClass2 = new OnDismissListener(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI nAY;

                {
                    this.nAY = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    if (!this.nAY.isFinishing()) {
                        this.nAY.finish();
                    }
                }
            };
            ak.a(new y(this) {
                final /* synthetic */ JSAPIUploadLogHelperUI nAY;

                public final void eh(int i) {
                    h f;
                    if (i < 0) {
                        v.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", Integer.valueOf(i));
                        ak.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        f = g.f(this.nAY, 2131235726, 2131231164);
                        if (f != null) {
                            f.setOnDismissListener(anonymousClass2);
                        }
                        synchronized (this.nAY.ciN) {
                            JSAPIUploadLogHelperUI.lo = false;
                        }
                    } else if (i >= 100) {
                        v.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        ak.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        f = g.f(this.nAY, 2131235730, 2131231164);
                        if (f != null) {
                            f.setOnDismissListener(anonymousClass2);
                        }
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.report.service.g.iuh.h(12975, Long.valueOf(currentTimeMillis));
                        synchronized (this.nAY.ciN) {
                            JSAPIUploadLogHelperUI.lo = false;
                        }
                    } else {
                        v.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", Integer.valueOf(i));
                        if (a != null) {
                            a.setMessage(this.nAY.getString(2131235727) + i + "%");
                        }
                    }
                }
            });
        }
    }

    protected void onDestroy() {
        v.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", Boolean.valueOf(lo));
        super.onDestroy();
    }
}
