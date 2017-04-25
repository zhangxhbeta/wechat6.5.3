package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.t;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingBackgroundUI extends MMPreference {
    private f dxf;
    private boolean iLV;
    private String username;

    static /* synthetic */ void aNj() {
        b HT = t.HT();
        Cursor rawQuery = HT.cuX.rawQuery("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null);
        if (rawQuery == null) {
            v.i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            return;
        }
        t.HS();
        if (rawQuery.moveToFirst()) {
            a aVar = new a();
            while (!rawQuery.isAfterLast()) {
                aVar.b(rawQuery);
                com.tencent.mm.loader.stub.b.deleteFile(n.z(aVar.getUsername(), true));
                com.tencent.mm.loader.stub.b.deleteFile(n.z(aVar.getUsername(), false));
                rawQuery.moveToNext();
            }
        }
        rawQuery.close();
        if (HT.cuX.delete("chattingbginfo", null, null) > 0) {
            HT.Ls();
        }
    }

    public final int Oo() {
        return 2131099720;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 2);
                    intent2.putExtra("CropImage_bg_vertical", fo(true));
                    intent2.putExtra("CropImage_bg_horizontal", fo(false));
                    h hVar = com.tencent.mm.plugin.setting.a.drp;
                    ak.yW();
                    hVar.a(this, intent, intent2, c.wP(), 4, null);
                    return;
                }
                return;
            case 2:
                Context applicationContext = getApplicationContext();
                ak.yW();
                String a = l.a(applicationContext, intent, c.wP());
                if (a != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 2);
                    intent3.putExtra("CropImage_ImgPath", a);
                    intent3.putExtra("CropImage_bg_vertical", fo(true));
                    intent3.putExtra("CropImage_bg_horizontal", fo(false));
                    com.tencent.mm.plugin.setting.a.drp.a(this, intent3, 4);
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    ak.yW();
                    c.vf().set(66820, Integer.valueOf(-1));
                    g.iuh.h(10198, new Object[]{Integer.valueOf(-1)});
                    v.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[]{Integer.valueOf(-1)});
                    if (!this.iLV) {
                        b HT = t.HT();
                        a jt = HT.jt(this.username);
                        if (jt != null) {
                            jt.cTU = -1;
                            HT.b(jt);
                            break;
                        }
                        jt = new a();
                        jt.username = this.username;
                        jt.cTU = -1;
                        HT.a(jt);
                        break;
                    }
                    ak.yW();
                    c.vf().set(12311, Integer.valueOf(-1));
                    t.HS().fS(1);
                    break;
                }
                break;
        }
        if (!this.iLV) {
            setResult(-1);
            finish();
        }
    }

    protected final void NI() {
        vD(2131234994);
        this.dxf = this.ocZ;
        this.iLV = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.iLV) {
            Preference Ow = this.dxf.Ow("settings_chatting_bg_apply_to_all");
            if (Ow != null) {
                this.dxf.b(Ow);
            }
        }
        this.username = getIntent().getStringExtra("username");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsChattingBackgroundUI iLW;

            {
                this.iLW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLW.axg();
                this.iLW.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.iLV);
            intent.putExtra("username", this.username);
            startActivityForResult(intent, 3);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            l.a(this, 1, null);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            v.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.nDR.nEl});
            if (!com.tencent.mm.pluginsdk.i.a.a(this.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                return false;
            }
            XQ();
            return true;
        } else if (!str.equals("settings_chatting_bg_apply_to_all")) {
            return false;
        } else {
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131234995), "", new OnClickListener(this) {
                final /* synthetic */ SettingsChattingBackgroundUI iLW;

                {
                    this.iLW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsChattingBackgroundUI.aNj();
                }
            }, null);
            return true;
        }
    }

    private void XQ() {
        if (!l.d(this, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(2131234875), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.SettingsChattingBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ SettingsChattingBackgroundUI iLW;

                        {
                            this.iLW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.iLW.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String fo(boolean z) {
        t.HS();
        if (this.iLV) {
            return n.z("default", z);
        }
        return n.z(this.username, z);
    }
}
