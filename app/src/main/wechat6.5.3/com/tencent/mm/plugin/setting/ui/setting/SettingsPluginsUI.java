package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.af.b;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsPluginsUI extends MMPreference {
    private static int iMB = 1;
    private static HashMap<String, Integer> iMC = new HashMap<String, Integer>() {
        {
            put("qmessage", Integer.valueOf(2));
            put("qqmail", Integer.valueOf(3));
            put("medianote", Integer.valueOf(4));
            put("qqsync", Integer.valueOf(5));
            put("lbsapp", Integer.valueOf(6));
            put("shakeapp", Integer.valueOf(7));
            put("newsapp", Integer.valueOf(8));
            put("masssendapp", Integer.valueOf(9));
            put("feedsapp", Integer.valueOf(10));
            put("voipapp", Integer.valueOf(11));
            put("voiceinputapp", Integer.valueOf(12));
            put("linkedinplugin", Integer.valueOf(13));
            put("floatbottle", Integer.valueOf(14));
            put("googlecontact", Integer.valueOf(15));
            put("facebookapp", Integer.valueOf(16));
            put("voicevoipapp", Integer.valueOf(17));
            put("gh_43f2581f6fd6", Integer.valueOf(18));
        }
    };
    private f dxf;
    private boolean iMD;
    private boolean iME;

    public final int Oo() {
        return 2131099730;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        NI();
        g.iuh.h(12846, new Object[]{Integer.valueOf(iMB)});
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235095);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPluginsUI iMF;

            {
                this.iMF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMF.axg();
                this.iMF.finish();
                return true;
            }
        });
    }

    public void onResume() {
        int i;
        PluginPreference pluginPreference;
        PluginPreference pluginPreference2;
        PluginTextPreference pluginTextPreference;
        int i2 = 1;
        super.onResume();
        this.dxf.removeAll();
        this.dxf.a(new PreferenceSmallCategory(this));
        List<PluginPreference> arrayList = new ArrayList();
        List<PluginPreference> arrayList2 = new ArrayList();
        boolean yn = k.yn();
        if (yn) {
            boolean z = yn;
        } else {
            if (be.getInt(j.sU().getValue("BindQQSwitch"), 1) == 1) {
                i = 1;
            } else {
                yn = false;
            }
            int i3 = i;
        }
        if (i3 == 0) {
            v.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (i3 != 0 && c.EH("qqmail")) {
            PluginPreference pluginPreference3 = new PluginPreference(this);
            if (pluginPreference3.zm("qqmail")) {
                pluginPreference3.setTitle(pluginPreference3.iJP);
                if ((k.xQ() & 1) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference3);
                } else if (b.Hb()) {
                    arrayList2.add(pluginPreference3);
                }
            }
        }
        if (i3 != 0 && c.EH("qmessage")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("qmessage")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 32) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else if (b.Hb()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (c.EH("profile")) {
            pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.zm("qqsync")) {
                pluginPreference2.setTitle(pluginPreference2.iJP);
                if (k.yb()) {
                    arrayList.add(pluginPreference2);
                } else if (b.Hb()) {
                    arrayList2.add(pluginPreference2);
                }
            }
        }
        if (c.EH("bottle")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("floatbottle")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 64) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (c.EH("nearby")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("lbsapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 512) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (c.EH("shake")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("shakeapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 256) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.zm("medianote")) {
            pluginPreference.setTitle(pluginPreference.iJP);
            if ((k.xQ() & 16) == 0) {
                i = 1;
            } else {
                yn = false;
            }
            if (i != 0) {
                arrayList.add(pluginPreference);
            } else if (b.Hb()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (c.EH("readerapp")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("newsapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 524288) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else if (b.Hb()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.zm("facebookapp")) {
            pluginPreference.setTitle(pluginPreference.iJP);
            if ((k.xQ() & 8192) == 0) {
                i = 1;
            } else {
                yn = false;
            }
            if (i != 0) {
                arrayList.add(pluginPreference);
            } else if (b.Ha()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (be.He()) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("googlecontact")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 8388608) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else if (b.Hc()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (c.EH("masssend")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("masssendapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 65536) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (c.EH("sns")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("feedsapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 32768) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
                ak.yW();
                this.iMD = be.a((Boolean) com.tencent.mm.model.c.vf().get(-2046825369, null), false);
                if (this.iMD) {
                    pluginPreference.fgx = 0;
                    pluginPreference.aO(getString(2131231102), 2130838762);
                } else {
                    pluginPreference.fgx = 8;
                    pluginPreference.aO("", -1);
                }
            }
        }
        if (c.EH("voip")) {
            c.brh();
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("voipapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 1048576) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
                ak.yW();
                this.iME = be.a((Boolean) com.tencent.mm.model.c.vf().get(-2046825368, null), false);
                if (this.iME) {
                    pluginPreference.fgx = 0;
                    pluginPreference.aO(getString(2131231102), 2130838762);
                } else {
                    pluginPreference.fgx = 8;
                    pluginPreference.aO("", -1);
                }
            }
        }
        c.brh();
        if (!b.GZ()) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.zm("voiceinputapp")) {
                pluginPreference.setTitle(pluginPreference.iJP);
                if ((k.xQ() & 33554432) == 0) {
                    i = 1;
                } else {
                    yn = false;
                }
                if (i != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (c.EH("voip")) {
            c.brh();
            j.sV();
            if (com.tencent.mm.h.c.sN() == 0) {
                i = 1;
            } else {
                yn = false;
            }
            if (i == 0) {
                pluginPreference = new PluginPreference(this);
                if (pluginPreference.zm("voicevoipapp")) {
                    pluginPreference.setTitle(pluginPreference.iJP);
                    if ((k.xQ() & 4194304) == 0) {
                        i = 1;
                    } else {
                        yn = false;
                    }
                    if (i != 0) {
                        arrayList.add(pluginPreference);
                    } else {
                        arrayList2.add(pluginPreference);
                    }
                    pluginPreference.fgx = 8;
                    pluginPreference.aO("", -1);
                }
            }
        }
        if (c.EH("sport")) {
            pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.zm("gh_43f2581f6fd6")) {
                pluginPreference2.setTitle(pluginPreference2.iJP);
                ak.yW();
                if (a.ei(com.tencent.mm.model.c.wH().LX("gh_43f2581f6fd6").field_type)) {
                    arrayList.add(pluginPreference2);
                } else {
                    arrayList2.add(pluginPreference2);
                }
            }
        }
        String value = j.sU().getValue("LinkedinPluginClose");
        if (be.kS(value) || Integer.valueOf(value).intValue() == 0) {
            pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.zm("linkedinplugin")) {
                pluginPreference2.setTitle(pluginPreference2.iJP);
                if ((k.xQ() & 16777216) != 0) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    arrayList.add(pluginPreference2);
                } else {
                    arrayList2.add(pluginPreference2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.odt = 2131165908;
            pluginTextPreference.wP(2131235102);
            this.dxf.a(pluginTextPreference);
        }
        for (PluginPreference pluginPreference22 : arrayList) {
            pluginPreference22.iJQ = 255;
            this.dxf.a(pluginPreference22);
        }
        this.dxf.a(new PreferenceSmallCategory(this));
        pluginTextPreference = new PluginTextPreference(this);
        pluginTextPreference.odt = 2131165909;
        pluginTextPreference.wP(2131235110);
        this.dxf.a(pluginTextPreference);
        if (arrayList2.isEmpty()) {
            this.dxf.a(new PluginEmptyTextPreference(this));
        }
        for (PluginPreference pluginPreference222 : arrayList2) {
            pluginPreference222.iJQ = 136;
            this.dxf.a(pluginPreference222);
        }
        this.dxf.a(new PreferenceSmallCategory(this));
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str != null && str.equals("display_in_addr_book")) {
            boolean isChecked = ((CheckBoxPreference) fVar.Ow(str)).isChecked();
            ak.yW();
            com.tencent.mm.model.c.vf().set(35, Boolean.valueOf(isChecked));
            return true;
        } else if (!(preference instanceof PluginPreference)) {
            return false;
        } else {
            str = ((PluginPreference) preference).iJO;
            if ("feedsapp".equals(str) && this.iMD) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(-2046825369, Boolean.valueOf(false));
            }
            if ("voipapp".equals(str) && this.iME) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(-2046825368, Boolean.valueOf(false));
            }
            c.b(this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
            g.iuh.h(12846, new Object[]{iMC.get(str)});
            v.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[]{str, iMC.get(str)});
            return true;
        }
    }
}
