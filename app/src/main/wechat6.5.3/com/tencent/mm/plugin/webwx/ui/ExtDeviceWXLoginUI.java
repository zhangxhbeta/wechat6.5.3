package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.j;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.plugin.webwx.a.d;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements e {
    private String bnM = null;
    private ProgressDialog gNy = null;
    private String lsS = null;
    private boolean lsT = false;
    private Button lsU;
    private TextView lsV;
    private int type = 0;

    static /* synthetic */ boolean a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        final b bVar = new b(extDeviceWXLoginUI.bnM);
        ak.vy().a(bVar, 0);
        extDeviceWXLoginUI.gNy = g.a(extDeviceWXLoginUI.nDR.nEl, extDeviceWXLoginUI.getString(2131233521), true, new OnCancelListener(extDeviceWXLoginUI) {
            final /* synthetic */ ExtDeviceWXLoginUI lsW;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(bVar);
                if (this.lsW.gNy != null) {
                    this.lsW.gNy.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ boolean c(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        final d dVar = new d(extDeviceWXLoginUI.bnM, extDeviceWXLoginUI.lsS);
        ak.vy().a(dVar, 0);
        extDeviceWXLoginUI.gNy = g.a(extDeviceWXLoginUI.nDR.nEl, extDeviceWXLoginUI.getString(2131233521), true, new OnCancelListener(extDeviceWXLoginUI) {
            final /* synthetic */ ExtDeviceWXLoginUI lsW;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(dVar);
                if (this.lsW.gNy != null) {
                    this.lsW.gNy.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ void d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(2131756580);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        v.d("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height)});
        extDeviceWXLoginUI.findViewById(2131756582).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cU().cV().hide();
        NI();
        overridePendingTransition(2130968646, 2130968589);
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void NI() {
        this.bnM = getIntent().getStringExtra("intent.key.login.url");
        this.type = getIntent().getIntExtra("intent.key.type", 0);
        CharSequence stringExtra = getIntent().getStringExtra("intent.key.title.string");
        int intExtra = getIntent().getIntExtra("intent.key.icon.type", 0);
        CharSequence stringExtra2 = getIntent().getStringExtra("intent.key.ok.string");
        CharSequence stringExtra3 = getIntent().getStringExtra("intent.key.cancel.string");
        CharSequence stringExtra4 = getIntent().getStringExtra("intent.key.content.string");
        this.lsS = getIntent().getStringExtra("intent.key.ok.session.list");
        v.d("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s", new Object[]{Integer.valueOf(this.type), stringExtra, stringExtra2, stringExtra4});
        Fd("");
        if (!be.kS(stringExtra)) {
            ((TextView) findViewById(2131756583)).setText(stringExtra);
        }
        if (!be.kS(stringExtra4)) {
            ((TextView) findViewById(2131756584)).setText(stringExtra4);
        }
        ImageView imageView = (ImageView) findViewById(2131756582);
        if (intExtra != 1) {
            if (intExtra == 2) {
                imageView.setImageResource(2131165420);
            } else if (intExtra == 3) {
                imageView.setImageResource(2131165419);
            }
            this.lsV = (TextView) findViewById(2131756586);
            this.lsV.setText(stringExtra3);
            this.lsV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExtDeviceWXLoginUI lsW;

                {
                    this.lsW = r1;
                }

                public final void onClick(View view) {
                    ExtDeviceWXLoginUI.a(this.lsW);
                }
            });
            this.lsU = (Button) findViewById(2131756585);
            if (be.kS(stringExtra2)) {
                this.lsU.setText(stringExtra2);
                if (this.type == 0) {
                    this.lsU.setEnabled(true);
                } else if (this.type == -1) {
                    this.lsU.setEnabled(false);
                } else if (this.type == -2) {
                    this.lsU.setEnabled(true);
                }
            } else {
                this.lsU.setVisibility(4);
            }
            this.lsU.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExtDeviceWXLoginUI lsW;

                {
                    this.lsW = r1;
                }

                public final void onClick(View view) {
                    if (this.lsW.type == 0) {
                        ExtDeviceWXLoginUI.c(this.lsW);
                    } else if (this.lsW.type == -2) {
                        Intent intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                        intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                        intent.putExtra("from_album", false);
                        intent.putExtra("show_intro", false);
                        intent.setFlags(65536);
                        c.b(this.lsW, "scanner", ".ui.BaseScanUI", intent);
                        this.lsW.finish();
                    }
                }
            });
            this.nDR.dtW.post(new Runnable(this) {
                final /* synthetic */ ExtDeviceWXLoginUI lsW;

                {
                    this.lsW = r1;
                }

                public final void run() {
                    ExtDeviceWXLoginUI.d(this.lsW);
                }
            });
            ((TextView) findViewById(2131756581)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExtDeviceWXLoginUI lsW;

                {
                    this.lsW = r1;
                }

                public final void onClick(View view) {
                    this.lsW.finish();
                }
            });
            ak.vy().a(972, this);
            ak.vy().a(973, this);
        }
        imageView.setImageResource(2131165425);
        this.lsV = (TextView) findViewById(2131756586);
        this.lsV.setText(stringExtra3);
        this.lsV.setOnClickListener(/* anonymous class already generated */);
        this.lsU = (Button) findViewById(2131756585);
        if (be.kS(stringExtra2)) {
            this.lsU.setVisibility(4);
        } else {
            this.lsU.setText(stringExtra2);
            if (this.type == 0) {
                this.lsU.setEnabled(true);
            } else if (this.type == -1) {
                this.lsU.setEnabled(false);
            } else if (this.type == -2) {
                this.lsU.setEnabled(true);
            }
        }
        this.lsU.setOnClickListener(/* anonymous class already generated */);
        this.nDR.dtW.post(/* anonymous class already generated */);
        ((TextView) findViewById(2131756581)).setOnClickListener(/* anonymous class already generated */);
        ak.vy().a(972, this);
        ak.vy().a(973, this);
    }

    protected void onPause() {
        super.onPause();
        if (this.lsT && ak.uz()) {
            rc rcVar = new rc();
            rcVar.muR = 27;
            rcVar.muS = k.eF(k.xL()) ? 1 : 2;
            ak.yW();
            com.tencent.mm.model.c.wG().b(new j.a(23, rcVar));
            this.lsT = false;
        }
    }

    protected final int getLayoutId() {
        return 2130903462;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968589, 2130968644);
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(972, this);
        ak.vy().b(973, this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.gNy != null) {
            this.gNy.dismiss();
            this.gNy = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() != 972) {
                kVar.getType();
            }
            this.type = 0;
            finish();
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!be.kS(str)) {
            ((TextView) findViewById(2131756584)).setText(str);
        }
        if (this.type == -1) {
            if (this.lsU != null) {
                this.lsU.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.lsU != null) {
                this.lsU.setEnabled(true);
                this.lsU.setText(2131236633);
            }
            if (this.lsV != null) {
                this.lsV.setVisibility(4);
            }
        }
        v.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
