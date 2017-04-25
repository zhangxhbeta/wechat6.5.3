package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this);
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            XQ();
        }
    }

    private void XQ() {
        l.d(this, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 0);
        getWindow().getDecorView().setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ShareImageRedirectUI oUH;

            {
                this.oUH = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(this.oUH, 2131235305, 1).show();
                this.oUH.finish();
                return false;
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.ShareImageRedirectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    g.a((Context) this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ShareImageRedirectUI oUH;

                        {
                            this.oUH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oUH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.oUH.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ ShareImageRedirectUI oUH;

                        {
                            this.oUH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oUH.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        getWindow().getDecorView().setOnTouchListener(null);
        if (i2 != -1) {
            finish();
            return;
        }
        Intent intent2;
        switch (i) {
            case 0:
                Context applicationContext = getApplicationContext();
                ak.yW();
                this.imagePath = l.a(applicationContext, intent, c.wP());
                if (this.imagePath != null) {
                    intent2 = new Intent(this, ShareImageSelectorUI.class);
                    intent2.putExtra("intent_extra_image_path", this.imagePath);
                    startActivityForResult(intent2, 2);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("Select_Contact");
                }
                if (arrayList != null && arrayList.size() == 1) {
                    Intent intent3 = new Intent(this, ChattingUI.class);
                    intent3.putExtra("Chat_User", (String) arrayList.get(0));
                    startActivity(intent3);
                    finish();
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    intent2 = new Intent();
                    intent2.putExtra("Ksnsupload_type", 0);
                    intent2.putExtra("sns_kemdia_path", this.imagePath);
                    com.tencent.mm.ay.c.b((Context) this, "sns", ".ui.SnsUploadUI", intent2);
                    finish();
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                return;
        }
    }
}
