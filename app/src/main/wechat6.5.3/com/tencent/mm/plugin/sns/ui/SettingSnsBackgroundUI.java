package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.at;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public class SettingSnsBackgroundUI extends MMPreference {
    private SharedPreferences cnm;
    private f dxf;
    protected String filePath;

    public final int Oo() {
        return 2131099733;
    }

    public void onCreate(Bundle bundle) {
        v.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        this.cnm = getSharedPreferences(aa.bti(), 0);
        NI();
    }

    protected void onNewIntent(Intent intent) {
        v.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        v.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    }

    public void onResume() {
        super.onResume();
        if (this.dxf != null) {
            this.dxf.notifyDataSetChanged();
        }
    }

    private void b(int i, Intent intent) {
        if (ak.uM()) {
            ak.yY();
        }
        String str;
        switch (i) {
            case 2:
                v.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = l.a(getApplicationContext(), intent, ad.xi());
                if (this.filePath != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_ImgPath", this.filePath);
                    str = "CropImage_OutputPath";
                    intent2.putExtra(str, ad.xi() + g.m((this.filePath + System.currentTimeMillis()).getBytes()));
                    a.drp.a(this, intent2, 6);
                    return;
                }
                return;
            case 5:
                v.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent != null) {
                    this.filePath = l.a(getApplicationContext(), intent, ad.xi());
                    if (this.filePath != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_ImgPath", this.filePath);
                        a.drp.a(this, intent, intent3, ad.xi(), 6, new com.tencent.mm.ui.tools.a.a(this) {
                            final /* synthetic */ SettingSnsBackgroundUI jJP;

                            {
                                this.jJP = r1;
                            }

                            public final String BX(String str) {
                                return ad.xi() + g.m((this.jJP.filePath + System.currentTimeMillis()).getBytes());
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case 6:
                v.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ SettingSnsBackgroundUI jJP;

                    {
                        this.jJP = r1;
                    }

                    public final void run() {
                        a.drq.oy();
                    }
                });
                if (intent != null) {
                    this.filePath = intent.getStringExtra("CropImage_OutputPath");
                    if (this.filePath != null) {
                        v.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                        at aSA = ad.aSA();
                        String str2 = this.filePath;
                        new LinkedList().add(new h(str2, 2));
                        if (!(aSA.aSk() == null || aSA.aSk().equals(""))) {
                            str = al.cA(ad.xh(), aSA.aSk());
                            FileOp.jS(str);
                            FileOp.deleteFile(str + aSA.aSk() + "bg_");
                            FileOp.p(str2, str + aSA.aSk() + "bg_");
                            j aSG = ad.aSG();
                            i Bu = aSG.Bu(aSA.aSk());
                            Bu.field_bgId = "";
                            aSG.c(Bu);
                        }
                        aSA.aTg();
                        aSA.aSk();
                        au auVar = new au(7);
                        auVar.cF(str2, "");
                        auVar.ql(1);
                        auVar.commit();
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                }
                return;
            default:
                v.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                return;
        }
    }

    protected void onActivityResult(final int i, final int i2, final Intent intent) {
        v.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i + " " + i2);
        if (i2 == -1) {
            v.d("MicroMsg.SettingSnsBackgroundUI", "result ok " + ak.uz());
            if (ad.aSn()) {
                new ac(Looper.myLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ SettingSnsBackgroundUI jJP;

                    public final void run() {
                        this.jJP.b(i, intent);
                    }
                }, 2000);
                return;
            }
            v.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
            b(i, intent);
        } else if (i == 2 || i == 5 || i == 6) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SettingSnsBackgroundUI jJP;

                {
                    this.jJP = r1;
                }

                public final void run() {
                    a.drq.oy();
                }
            });
        }
    }

    protected final void NI() {
        vD(2131235152);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.dxf.Ow("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.cnm.getString("artist_name", "");
            v.d("MicroMsg.SettingSnsBackgroundUI", "artistName" + string);
            snsArtistPreference.jLU = string;
            snsArtistPreference.aWv();
            this.dxf.notifyDataSetChanged();
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingSnsBackgroundUI jJP;

            {
                this.jJP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jJP.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                l.a(this, 5, null);
                return true;
            }
            s.ey(this);
            return false;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                v.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.nDR.nEl});
                if (!com.tencent.mm.pluginsdk.i.a.a(this.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                    return false;
                }
                XQ();
                return true;
            }
            s.ey(this);
            return false;
        } else if (!str.equals("settings_sns_bg_select_bg")) {
            return false;
        } else {
            startActivity(new Intent(this, ArtistUI.class));
            return true;
        }
    }

    private void XQ() {
        if (!l.d(this, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(2131234875), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ SettingSnsBackgroundUI jJP;

                        {
                            this.jJP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.jJP.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
