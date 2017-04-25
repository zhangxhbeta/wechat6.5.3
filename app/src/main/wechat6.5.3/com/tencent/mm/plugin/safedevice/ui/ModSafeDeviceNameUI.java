package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.safedevice.a.b;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class ModSafeDeviceNameUI extends MMActivity implements e {
    private String aZN;
    private long dhH;
    private ProgressDialog dwR = null;
    private String ePB;
    private EditText iuE;
    private String iuF;
    private String iuG;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onResume() {
        ak.vy().a(361, this);
        super.onResume();
    }

    protected void onPause() {
        ak.vy().b(361, this);
        super.onPause();
    }

    protected final void NI() {
        this.iuF = getIntent().getStringExtra("safe_device_name");
        this.iuG = getIntent().getStringExtra("safe_device_uid");
        this.aZN = getIntent().getStringExtra("safe_device_type");
        Fd(a.O(this, 2131234705));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModSafeDeviceNameUI iuH;

            {
                this.iuH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iuH.finish();
                return true;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModSafeDeviceNameUI iuH;

            {
                this.iuH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iuH.ePB = this.iuH.iuE.getText().toString();
                if (!be.kS(this.iuH.ePB)) {
                    this.iuH.axg();
                    final b bVar = new b(this.iuH.iuG, this.iuH.ePB, this.iuH.aZN);
                    ak.vy().a(bVar, 0);
                    this.iuH.dwR = g.a(this.iuH, a.O(this.iuH, 2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 iuJ;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(bVar);
                        }
                    });
                }
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new MMEditText.b(this) {
            final /* synthetic */ ModSafeDeviceNameUI iuH;

            {
                this.iuH = r1;
            }

            public final void aKK() {
                if (this.iuH.iuE.getText().toString().trim().length() > 0) {
                    this.iuH.iT(true);
                } else {
                    this.iuH.iT(false);
                }
            }
        };
        this.iuE = (EditText) findViewById(2131758331);
        c cVar = new c(this.iuE, null, 32);
        cVar.pct = anonymousClass3;
        this.iuE.addTextChangedListener(cVar);
        if (be.kS(this.iuF)) {
            iT(false);
        } else {
            this.iuE.setText(this.iuF);
        }
    }

    protected final int getLayoutId() {
        return 2130904093;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.safedevice.a.c cVar = new com.tencent.mm.plugin.safedevice.a.c();
            cVar.field_devicetype = this.aZN;
            cVar.field_name = this.ePB;
            cVar.field_uid = this.iuG;
            cVar.field_createtime = this.dhH;
            f.aKJ().a(cVar, new String[0]);
            g.bf(this, a.O(this, 2131234709));
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ ModSafeDeviceNameUI iuH;

                {
                    this.iuH = r1;
                }

                public final void run() {
                    this.iuH.finish();
                }
            }, 1000);
        } else if (!com.tencent.mm.plugin.a.a.drq.a(this, i, i2, str)) {
        }
    }
}
