package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.b;
import com.tencent.mm.u.d;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map.Entry;

public class BottlePersonalInfoUI extends MMPreference implements a {
    private SharedPreferences cnm;
    private f dxf;
    private c euO;
    private HashMap<Integer, Integer> euP = new HashMap();
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n.AX().d(this);
        NI();
    }

    public void onDestroy() {
        com.tencent.mm.plugin.bottle.a.drq.ow();
        n.AX().e(this);
        super.onDestroy();
    }

    protected final void NI() {
        boolean z = true;
        vD(2131235169);
        this.dxf = this.ocZ;
        this.dxf.addPreferencesFromResource(2131099660);
        this.cnm = this.cnm;
        this.status = k.xJ();
        if (getIntent().getBooleanExtra("is_allow_set", true)) {
            this.euO = new c(this, this.dxf);
        } else {
            f fVar = this.dxf;
            fVar.Ox("settings_sex");
            fVar.Ox("settings_district");
            fVar.Ox("settings_signature");
            fVar.Ox("bottle_settings_change_avatar_alert");
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("bottle_settings_show_at_main");
        if ((this.status & 32768) == 0) {
            z = false;
        }
        checkBoxPreference.ocf = z;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottlePersonalInfoUI euQ;

            {
                this.euQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.euQ.finish();
                return true;
            }
        });
    }

    public void onResume() {
        HeadImgPreference headImgPreference = (HeadImgPreference) this.dxf.Ow("bottle_settings_change_avatar");
        Bitmap a = b.a(u.LM(k.xF()), false, -1);
        if (a == null) {
            a = b.a(k.xF(), false, -1);
        }
        if (a != null) {
            headImgPreference.C(a);
        }
        headImgPreference.lwQ = new OnClickListener(this) {
            final /* synthetic */ BottlePersonalInfoUI euQ;

            {
                this.euQ = r1;
            }

            public final void onClick(View view) {
                new com.tencent.mm.pluginsdk.ui.f(this.euQ.nDR.nEl, u.LM(k.xF())).boy();
            }
        };
        if (this.euO != null) {
            this.euO.update();
        }
        super.onResume();
    }

    public void onPause() {
        c.XM();
        ak.yW();
        c.vf().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.euP.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            ak.yW();
            c.wG().b(new g(intValue, intValue2));
            v.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch  " + intValue + " " + intValue2);
        }
        this.euP.clear();
        super.onPause();
    }

    public final int Oo() {
        return 2131099659;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.dnU;
        if (str.equals("bottle_settings_change_avatar")) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                l.a(this, 2, null);
                return true;
            }
            s.ey(this);
            return false;
        } else if (str.equals("settings_district")) {
            return this.euO.XO();
        } else {
            if (str.equals("settings_signature")) {
                return this.euO.XN();
            }
            if (str.equals("bottle_settings_show_at_main")) {
                boolean z = this.cnm.getBoolean("bottle_settings_show_at_main", true);
                v.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch change : open = " + z + " item value = 32768 functionId = 14");
                if (z) {
                    this.status |= 32768;
                } else {
                    this.status &= -32769;
                }
                if (z) {
                    i = 1;
                }
                this.euP.put(Integer.valueOf(14), Integer.valueOf(i));
                return true;
            } else if (!str.equals("bottle_settings_clear_data")) {
                return false;
            } else {
                com.tencent.mm.ui.base.g.b(this.nDR.nEl, this.nDR.nEl.getString(2131232017), "", this.nDR.nEl.getString(2131231012), this.nDR.nEl.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BottlePersonalInfoUI euQ;

                    {
                        this.euQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        i.XH();
                    }
                }, null);
                return true;
            }
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
                        n.AX();
                        intent2.putExtra("CropImage_OutputPath", d.s(u.LM(k.xF()), true));
                        intent2.putExtra("CropImage_ImgPath", a);
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
                        v.e("MicroMsg.BottleSettignsPersonalInfoUI", "crop picture failed");
                        return;
                    } else {
                        new com.tencent.mm.pluginsdk.model.n(this.nDR.nEl, a).a(2, null);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void gM(String str) {
        if (str != null && str.equals(u.LM(k.xF()))) {
            Bitmap decodeResource;
            Bitmap a = b.a(str, false, -1);
            if (a == null) {
                a = b.a(k.xF(), false, -1);
            }
            if (a == null) {
                decodeResource = BitmapFactory.decodeResource(getResources(), 2130838080);
            } else {
                decodeResource = a;
            }
            ((HeadImgPreference) this.dxf.Ow("bottle_settings_change_avatar")).C(decodeResource);
        }
    }
}
