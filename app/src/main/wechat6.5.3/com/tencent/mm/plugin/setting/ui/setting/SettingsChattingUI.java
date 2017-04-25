package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.lt;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.h;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private f dxf;
    private boolean eut = false;
    private ProgressDialog iKE = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        vD(2131234993);
        this.dxf = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsChattingUI iLX;

            {
                this.iLX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLX.axg();
                this.iLX.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            ak.yW();
            checkBoxPreference.ocf = ((Boolean) c.vf().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.odB = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_enter_button_send");
        if (checkBoxPreference != null) {
            ak.yW();
            checkBoxPreference.ocf = ((Boolean) c.vf().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.odB = false;
        }
        Preference Ow = this.dxf.Ow("settings_text_size");
        if (Ow != null) {
            Ow.setSummary(getString(SetTextSizeUI.cw(this)));
        }
        this.dxf.notifyDataSetChanged();
    }

    public final int Oo() {
        return 2131099726;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.dnU;
        boolean z2;
        if (str.equals("settings_voice_play_mode")) {
            ak.yW();
            boolean booleanValue = ((Boolean) c.vf().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsChattingUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            if (booleanValue) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr[1] = Boolean.valueOf(z2);
            v.d(str2, str3, objArr);
            ak.yW();
            r vf = c.vf();
            if (!booleanValue) {
                z = true;
            }
            vf.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            v.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
            ak.yW();
            c.vf().set(66832, Boolean.valueOf(z2));
            return true;
        } else if (str.equals("settings_bak_chat")) {
            startActivity(new Intent().setClassName(this.nDR.nEl, "com.tencent.mm.plugin.backup.moveui.BakMoveUI"));
            return true;
        } else if (str.equals("settings_chatting_bg")) {
            r0 = new Intent();
            r0.setClass(this, SettingsChattingBackgroundUI.class);
            this.nDR.nEl.startActivity(r0);
            return true;
        } else if (str.equals("settings_emoji_manager")) {
            r0 = new Intent();
            r0.putExtra("10931", 2);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "emoji", ".ui.EmojiMineUI", r0);
            return true;
        } else if (!str.equals("settings_reset")) {
            return false;
        } else {
            g.b(this.nDR.nEl, getResources().getString(2131235125), "", getString(2131231012), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ SettingsChattingUI iLX;

                {
                    this.iLX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    int i2 = 0;
                    com.tencent.mm.plugin.report.service.g.iuh.a(324, 0, 1, false);
                    this.iLX.eut = false;
                    SettingsChattingUI settingsChattingUI = this.iLX;
                    SettingsChattingUI settingsChattingUI2 = this.iLX;
                    this.iLX.getString(2131231164);
                    settingsChattingUI.iKE = g.a(settingsChattingUI2, this.iLX.getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 iLY;

                        {
                            this.iLY = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.iLY.iLX.eut = true;
                        }
                    });
                    ak.yW();
                    List bvK = c.wK().bvK();
                    if (bvK.size() > 0) {
                        List s = h.s(bvK);
                        if (s != null) {
                            while (i2 < s.size()) {
                                if (((Boolean) s.get(i2)).booleanValue()) {
                                    a.drq.bq((String) bvK.get(i2));
                                }
                                i2++;
                            }
                        }
                    }
                    aw.a(new aw.a(this) {
                        final /* synthetic */ AnonymousClass2 iLY;

                        {
                            this.iLY = r1;
                        }

                        public final boolean zp() {
                            return this.iLY.iLX.eut;
                        }

                        public final void zo() {
                            if (this.iLY.iLX.iKE != null) {
                                this.iLY.iLX.iKE.dismiss();
                                this.iLY.iLX.iKE = null;
                            }
                            com.tencent.mm.sdk.c.a.nhr.z(new lt());
                        }
                    });
                }
            }, null);
            return true;
        }
    }
}
