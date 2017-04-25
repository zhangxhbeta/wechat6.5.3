package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;

public class BottleWizardStep1 extends MMActivity {
    private ImageView euS = null;

    static /* synthetic */ boolean a(BottleWizardStep1 bottleWizardStep1) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            g.a(bottleWizardStep1, "", bottleWizardStep1.getResources().getStringArray(2131296273), "", new g.c(bottleWizardStep1) {
                final /* synthetic */ BottleWizardStep1 euT;

                {
                    this.euT = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            v.i("MicroMsg.BottleWizardStep1", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.euT.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.euT.nDR.nEl});
                            if (a.a(this.euT.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                                this.euT.XQ();
                                return;
                            }
                            return;
                        case 1:
                            l.a(this.euT, 2, null);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        s.ey(bottleWizardStep1);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void XP() {
        Bitmap a;
        Bitmap a2 = b.a(u.LM(k.xF()), false, -1);
        if (a2 == null) {
            a = b.a(k.xF(), false, -1);
        } else {
            a = a2;
        }
        this.euS = (ImageView) findViewById(2131755693);
        if (a != null) {
            this.euS.setImageBitmap(a);
        }
    }

    protected void onResume() {
        super.onResume();
        NI();
        XP();
    }

    protected final int getLayoutId() {
        return 2130903193;
    }

    protected final void NI() {
        vD(2131231509);
        ((LinearLayout) findViewById(2131755692)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BottleWizardStep1 euT;

            {
                this.euT = r1;
            }

            public final void onClick(View view) {
                BottleWizardStep1.a(this.euT);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep1 euT;

            {
                this.euT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.euT.axg();
                this.euT.finish();
                return true;
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep1 euT;

            {
                this.euT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.euT.startActivity(new Intent().setClass(this.euT, BottleWizardStep2.class));
                this.euT.finish();
                return true;
            }
        });
    }

    private void XQ() {
        if (!l.d(this, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(2131234875), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.BottleWizardStep1", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BottleWizardStep1 euT;

                        {
                            this.euT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.euT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String a;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ak.yW();
                    a = l.a(applicationContext, intent, c.wP());
                    if (a != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_ImgPath", a);
                        StringBuilder stringBuilder = new StringBuilder();
                        n.AX();
                        intent2.putExtra("CropImage_OutputPath", stringBuilder.append(d.s(u.LM(k.xF()), true)).append(".crop").toString());
                        com.tencent.mm.plugin.bottle.a.drp.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ak.yW();
                a = l.a(applicationContext, intent, c.wP());
                if (a != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", a);
                    intent2.putExtra("CropImage_ImgPath", a);
                    com.tencent.mm.plugin.bottle.a.drp.a(this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    a = intent.getStringExtra("CropImage_OutputPath");
                    if (a == null) {
                        v.e("MicroMsg.BottleWizardStep1", "crop picture failed");
                        return;
                    } else {
                        new com.tencent.mm.pluginsdk.model.n(this.nDR.nEl, a).a(2, new Runnable(this) {
                            final /* synthetic */ BottleWizardStep1 euT;

                            {
                                this.euT = r1;
                            }

                            public final void run() {
                                this.euT.XP();
                            }
                        });
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
