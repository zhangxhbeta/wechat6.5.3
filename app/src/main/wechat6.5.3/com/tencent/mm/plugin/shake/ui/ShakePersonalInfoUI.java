package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI extends MMPreference {
    private f dxf;

    public final int Oo() {
        return 2131099735;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        a.drq.ow();
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235251);
        this.dxf = this.ocZ;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("shake_item_sound");
        ak.yW();
        if (c.vf().get(4112, null) == null) {
            ak.yW();
            c.vf().set(4112, Boolean.valueOf(true));
        }
        ak.yW();
        checkBoxPreference.ocf = be.b((Boolean) c.vf().get(4112, null));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakePersonalInfoUI iRq;

            {
                this.iRq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iRq.finish();
                return true;
            }
        });
        if (!com.tencent.mm.ai.c.HG()) {
            this.dxf.Ox("shake_item_shake_music_list");
        }
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        if (ak.uz()) {
            a.drq.ow();
        }
        if (this.dxf.Ow("shake_item_shake_tv_list") == null) {
            v.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            return;
        }
        if (be.getInt(j.sV().z("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        v.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : " + z);
        if (!z && !q.dqa) {
            this.dxf.aO("shake_item_shake_tv_list", true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if ("shake_item_default_bgimg".equals(str)) {
            ak.yW();
            c.vf().set(4110, Boolean.valueOf(true));
            g.bf(this, getResources().getString(2131235281));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            l.a(this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            ak.yW();
            boolean b = be.b((Boolean) c.vf().get(4112, null));
            ak.yW();
            c.vf().set(4112, Boolean.valueOf(!b));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            Intent intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(2131235250));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(2131235289));
            startActivity(intent);
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.wP()).append("custom_shake_img_filename.jpg").toString());
                    a.drp.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ak.yW();
                    c.vf().set(4110, Boolean.valueOf(false));
                    ak.yW();
                    c.vf().set(4111, stringExtra);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
