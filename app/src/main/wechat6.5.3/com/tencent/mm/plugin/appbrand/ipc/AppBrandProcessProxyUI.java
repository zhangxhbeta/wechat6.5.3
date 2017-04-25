package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI extends MMActivity implements b {
    private AppBrandProxyUIProcessTask dEn;
    private ProcessRequest dEo;
    private boolean dEp = false;
    private volatile boolean dEq = false;
    private h dEr;
    private a dEs;

    private class a implements OnClickListener, OnDismissListener {
        private boolean dEA;
        final /* synthetic */ AppBrandProcessProxyUI dEy;

        private a(AppBrandProcessProxyUI appBrandProcessProxyUI) {
            this.dEy = appBrandProcessProxyUI;
            this.dEA = false;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            hc(i);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            hc(-2);
            this.dEy.a(null);
        }

        private void hc(int i) {
            if (!this.dEA) {
                this.dEA = true;
                ResultReceiver resultReceiver = (ResultReceiver) this.dEy.getIntent().getParcelableExtra("key_result_receiver");
                if (resultReceiver != null) {
                    resultReceiver.send(i, null);
                }
            }
        }
    }

    static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, _Req _Req, final b<_Result> bVar) {
        Context context2;
        Parcelable parcelable;
        if (context == null) {
            context2 = aa.getContext();
        } else {
            context2 = context;
        }
        String name = _Req.PF().getName();
        if (cls == null) {
            cls = AppBrandProcessProxyUI.class;
        }
        Intent putExtra = new Intent(context2, cls).putExtra("key_model_class_name", name);
        String str = "key_result_receiver";
        if (bVar == null) {
            parcelable = null;
        } else {
            parcelable = new ResultReceiver(ac.fetchFreeHandler(Looper.getMainLooper())) {
                protected final void onReceiveResult(int i, Bundle bundle) {
                    if (bundle == null) {
                        bVar.c(null);
                        return;
                    }
                    bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                    bVar.c((ProcessResult) bundle.getParcelable("key_result_parcel"));
                }
            };
        }
        putExtra = putExtra.putExtra(str, parcelable).putExtra("key_running_mode", 1);
        putExtra.putExtra("key_request_parcel", _Req);
        if (context2 instanceof Activity) {
            putExtra.putExtra("key_need_light_status", f.b(((Activity) context2).getWindow()));
        } else {
            putExtra.addFlags(268435456);
        }
        context2.startActivity(putExtra);
    }

    static void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnClickListener onClickListener3) {
        if (context == null) {
            context = aa.getContext();
        }
        Intent putExtra = new Intent(context, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(ac.fetchFreeHandler(Looper.getMainLooper())) {
            protected final void onReceiveResult(int i, Bundle bundle) {
                if (-1 == i && onClickListener != null) {
                    onClickListener.onClick(null, i);
                }
                if (-2 == i && onClickListener2 != null) {
                    onClickListener2.onClick(null, i);
                }
                if (-3 == i && onClickListener3 != null) {
                    onClickListener3.onClick(null, i);
                }
            }
        }).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        context.startActivity(putExtra);
    }

    public final int getLayoutId() {
        return -1;
    }

    protected final void PK() {
        super.PK();
        aq(1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        f.a(getWindow());
        f.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra;
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                stringExtra = getIntent().getStringExtra("key_model_class_name");
                v.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[]{stringExtra});
                if (!be.kS(stringExtra)) {
                    this.dEn = a.nm(stringExtra);
                    if (this.dEn == null) {
                        v.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[]{stringExtra});
                    } else {
                        if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                            this.dEo = (ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                            if (this.dEo == null) {
                                v.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[]{stringExtra});
                            }
                        } else {
                            this.dEo = null;
                        }
                        this.dEn.dEB = this;
                        this.dEn.a(this.dEo);
                        z = true;
                    }
                }
                if (!z) {
                    break;
                }
                return;
            case 2:
                stringExtra = aH(getIntent().getStringExtra("key_alert_title"), "");
                String aH = aH(getIntent().getStringExtra("key_alert_message"), getString(2131231164));
                String aH2 = aH(getIntent().getStringExtra("key_alert_confirm"), "");
                final String aH3 = aH(getIntent().getStringExtra("key_alert_deny"), "");
                this.dEs = new a();
                this.dEr = g.a(this, aH, stringExtra, aH2, aH3, false, this.dEs, this.dEs);
                this.dEr.setOnDismissListener(this.dEs);
                this.dEr.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ AppBrandProcessProxyUI dEy;

                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getAction() == 1) {
                            if (!be.kS(aH3)) {
                                this.dEy.dEs.onClick(this.dEy.dEr, -3);
                                dialogInterface.dismiss();
                            }
                            this.dEy.a(null);
                        }
                        return false;
                    }
                });
                return;
        }
        finish();
    }

    private static String aH(String str, String str2) {
        return be.kS(str) ? str2 : str;
    }

    protected void onResume() {
        super.onResume();
        if (getIntent().getIntExtra("key_running_mode", 0) == 2) {
            v.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
            return;
        }
        v.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[]{Boolean.valueOf(this.dEp), Boolean.valueOf(PM()), this.dEo.getClass().getName()});
        if (this.dEp && this.dEo.PN() && !r0) {
            a(null);
        }
        this.dEp = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dEr != null && this.dEr.isShowing()) {
            this.dEr.dismiss();
            this.dEr = null;
            this.dEs = null;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.dEo.getClass().getName()});
        this.dEp = false;
    }

    public void finish() {
        super.finish();
        if (this.dEn != null) {
            this.dEn.PE();
        }
    }

    public final MMActivity PL() {
        return this;
    }

    public final void a(final ProcessResult processResult) {
        this.dEq = true;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ AppBrandProcessProxyUI dEy;

            public final void run() {
                this.dEy.b(processResult);
                this.dEy.finish();
            }
        });
    }

    public final boolean PM() {
        return this.nDT || isFinishing() || this.dEq;
    }

    public final void b(ProcessResult processResult) {
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (resultReceiver != null && processResult != null) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
    }
}
