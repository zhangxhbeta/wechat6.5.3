package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.fk;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;

public class SettingsFontUI extends MMActivity {
    final float iLZ = SetTextSizeUI.cv(this.nDR.nEl);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final int getLayoutId() {
        return 2130904357;
    }

    protected final void NI() {
        vD(2131235168);
        new StringBuilder("fontSizeBefore=").append(this.iLZ);
        final TextView textView = (TextView) findViewById(2131759081);
        final TextView textView2 = (TextView) findViewById(2131759083);
        final TextView textView3 = (TextView) findViewById(2131759084);
        b.m((ImageView) findViewById(2131759082), k.xF());
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(2131759085);
        float cv = SetTextSizeUI.cv(this.nDR.nEl);
        if (cv < 0.875f || cv > 1.375f) {
            cv = 1.0f;
        }
        int i = cv == 0.875f ? 0 : cv == 1.125f ? 2 : cv == 1.25f ? 3 : cv == 1.375f ? 4 : 1;
        fontSelectorView.iNI = i;
        fontSelectorView.iNJ = new a(this) {
            final /* synthetic */ SettingsFontUI iMd;

            public final void pi(int i) {
                float f = 1.0f;
                switch (i) {
                    case 0:
                        f = 0.875f;
                        break;
                    case 2:
                        f = 1.125f;
                        break;
                    case 3:
                        f = 1.25f;
                        break;
                    case 4:
                        f = 1.375f;
                        break;
                }
                com.tencent.mm.bd.a.c(this.iMd.nDR.nEl, f);
                u.c(this.iMd.nDR.nEl, f);
                bl.zQ().b(25, new Object[]{Float.valueOf(SetTextSizeUI.T(f))});
                Editor edit = this.iMd.nDR.nEl.getSharedPreferences(aa.bti(), 0).edit();
                edit.putFloat("current_text_size_scale_key", f);
                edit.commit();
                textView.setTextSize(1, SetTextSizeUI.S(f));
                textView2.setTextSize(1, SetTextSizeUI.S(f));
                textView3.setTextSize(1, SetTextSizeUI.S(f));
                f *= (float) this.iMd.nDR.nEl.getResources().getDimensionPixelSize(2131492960);
                this.iMd.nDR.nEs.setTextSize(0, f);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsFontUI iMd;

            {
                this.iMd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMd.finish();
                this.iMd.U(this.iMd.iLZ);
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        U(this.iLZ);
        return true;
    }

    private void U(float f) {
        float f2 = this.nDR.nEl.getSharedPreferences(aa.bti(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.a.drp.t(intent, this.nDR.nEl);
            fk fkVar = new fk();
            fkVar.beM.beN = f;
            fkVar.beM.beO = f2;
            com.tencent.mm.sdk.c.a.nhr.z(fkVar);
        }
    }
}
