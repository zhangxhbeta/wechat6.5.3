package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.a.n;
import com.tencent.mm.plugin.scanner.a.n.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static int iCB = 1;
    private static int iCC = 1;
    private static ArrayList<String> iCz = new ArrayList();
    private f dxf;
    private r iCA;
    private n iCy;

    static /* synthetic */ void a(VcardContactUI vcardContactUI, Intent intent) {
        int i;
        intent.setFlags(268435456);
        String aKW = vcardContactUI.iCy.iwA.aKW();
        if (be.kS(aKW)) {
            v.e("MicroMsg.scanner.VardContactUI", "no contact user name");
        } else {
            intent.putExtra("name", aKW);
        }
        List list = vcardContactUI.iCy.iwK;
        if (list == null || list.size() <= 0) {
            i = 1;
        } else {
            a(list, intent, 3, 1);
            i = 2;
        }
        List list2 = vcardContactUI.iCy.iwL;
        if (list2 != null && list2.size() > 0) {
            int i2 = i + 1;
            a(list2, intent, 1, i);
            i = i2;
        }
        List list3 = vcardContactUI.iCy.iwM;
        if (list3 != null && list3.size() > 0) {
            int i3 = i + 1;
            a(list3, intent, 2, i);
            i = i3;
        }
        List list4 = vcardContactUI.iCy.iwO;
        if (list4 != null && list4.size() > 0) {
            int i4 = i + 1;
            a(list4, intent, 7, i);
            i = i4;
        }
        List list5 = vcardContactUI.iCy.iwN;
        if (list5 != null && list5.size() > 0) {
            a(list5, intent, 0, i);
        }
        if (!be.kS(vcardContactUI.iCy.iwS)) {
            intent.putExtra("company", vcardContactUI.iCy.iwS);
        }
        if (!be.kS(vcardContactUI.iCy.iwR)) {
            intent.putExtra("notes", vcardContactUI.iCy.iwR);
        }
        if (!be.kS(vcardContactUI.iCy.bCc)) {
            intent.putExtra("email", vcardContactUI.iCy.bCc);
        }
        if (!be.kS(vcardContactUI.iCy.title)) {
            intent.putExtra("job_title", vcardContactUI.iCy.title);
        }
        n nVar = vcardContactUI.iCy;
        a aVar = (nVar.iwH == null || nVar.iwH.aKW().length() <= 0) ? (nVar.iwI == null || nVar.iwI.aKW().length() <= 0) ? (nVar.iwJ == null || nVar.iwJ.aKW().length() <= 0) ? (nVar.iwG == null || nVar.iwG.aKW().length() <= 0) ? null : nVar.iwG : nVar.iwJ : nVar.iwI : nVar.iwH;
        if (aVar != null && aVar.aKW().length() > 0) {
            intent.putExtra("postal", aVar.aKW());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final int Oo() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.dnU.equals("add_vcard_contact")) {
            g.a(this, "", new String[]{getString(2131235746), getString(2131235745)}, "", new c(this) {
                final /* synthetic */ VcardContactUI iCD;

                {
                    this.iCD = r1;
                }

                public final void gT(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            bl.zQ().b(10238, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            VcardContactUI.a(this.iCD, intent);
                            this.iCD.startActivity(intent);
                            return;
                        case 1:
                            bl.zQ().b(10239, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(this.iCD, intent);
                            this.iCD.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        String str;
        if (preference.dnU.equals("v_contact_info_photo_uri") || preference.dnU.equals("v_contact_info_home_page") || preference.dnU.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                r rVar = this.iCA;
                if (!rVar.hXD.btC()) {
                    v.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    v.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    rVar.url = charSequence;
                    ak.yW();
                    str = (String) com.tencent.mm.model.c.vf().get(46, null);
                    if (str == null || str.length() == 0) {
                        rVar.yX(charSequence);
                    } else {
                        ak.vy().a(233, rVar);
                        rVar.iCK = new l(charSequence, null, 4);
                        ak.vy().a(rVar.iCK, 0);
                        rVar.hXD.ea(3000);
                    }
                }
                return true;
            }
        } else if (iCz.contains(preference.dnU) && !preference.dnU.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                g.a(this, "", new String[]{getString(2131231864)}, "", new c(this) {
                    final /* synthetic */ VcardContactUI iCD;

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse("tel:" + str));
                                this.iCD.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        } else if (preference.dnU.equals("v_contact_info_email")) {
            str = preference.getSummary().toString();
            g.a(this, "", new String[]{this.nDR.nEl.getString(2131234905), this.nDR.nEl.getString(2131234904)}, "", new c(this) {
                final /* synthetic */ VcardContactUI iCD;

                public final void gT(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent();
                            String[] strArr = new String[]{str + " " + str};
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", strArr);
                            com.tencent.mm.ay.c.b(this.iCD, "qqmail", ".ui.ComposeUI", intent);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
                            this.iCD.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        return false;
    }

    protected final void NI() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        this.iCA = new r(this);
        this.dxf = this.ocZ;
        this.iCy = n.iwT;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VcardContactUI iCD;

            {
                this.iCD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iCD.finish();
                return true;
            }
        });
        Fd("");
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099742);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.dxf.Ow("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            n nVar = this.iCy;
            if (nVar != null) {
                if (!be.kS(nVar.iwA.aKW())) {
                    vcardContactUserHeaderPreference.iCJ = nVar.iwA.aKW();
                }
                if (!be.kS(nVar.aGX)) {
                    vcardContactUserHeaderPreference.aGX = nVar.aGX;
                }
                if (!be.kS(nVar.iwP)) {
                    vcardContactUserHeaderPreference.iwP = nVar.iwP;
                }
                if (!be.kS(nVar.title)) {
                    vcardContactUserHeaderPreference.title = nVar.title;
                }
            }
        }
        this.dxf.Ox("c_contact_info_wx_id");
        if (be.kS(this.iCy.iwB)) {
            this.dxf.Ox("v_contact_info_photo_uri");
            this.dxf.Ox("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.dxf.Ow("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.iCy.iwB);
                vcardContactLinkPreference.jz(false);
                vcardContactLinkPreference.ocP = false;
                iCB += 2;
                iCC += 2;
            }
        }
        a aVar = this.iCy.iwI;
        if (aVar != null && aVar.aKW().length() > 0) {
            ct(aVar.aKW(), this.nDR.nEl.getString(2131235752));
        }
        aVar = this.iCy.iwJ;
        if (aVar != null && aVar.aKW().length() > 0) {
            ct(aVar.aKW(), this.nDR.nEl.getString(2131235765));
        }
        aVar = this.iCy.iwG;
        if (aVar != null && aVar.aKW().length() > 0) {
            ct(aVar.aKW(), this.nDR.nEl.getString(2131235747));
        }
        aVar = this.iCy.iwH;
        if (aVar != null && aVar.aKW().length() > 0) {
            ct(aVar.aKW(), this.nDR.nEl.getString(2131235747));
        }
        List list = this.iCy.iwM;
        if (list != null && list.size() > 0) {
            b(list, "WorkTel", this.nDR.nEl.getString(2131235766));
        }
        list = this.iCy.iwL;
        if (list != null && list.size() > 0) {
            b(list, "HomeTel", this.nDR.nEl.getString(2131235754));
        }
        list = this.iCy.iwN;
        if (list != null && list.size() > 0) {
            b(list, "VideoTEL", this.nDR.nEl.getString(2131235763));
        }
        list = this.iCy.iwO;
        if (list != null && list.size() > 0) {
            b(list, "NormalTel", this.nDR.nEl.getString(2131235757));
        }
        list = this.iCy.iwK;
        if (list != null && list.size() > 0) {
            b(list, "CellTel", this.nDR.nEl.getString(2131235750));
        }
        if (be.kS(this.iCy.iwS)) {
            this.dxf.Ox("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.iCy.iwS);
                keyValuePreference.jz(false);
                keyValuePreference.ocP = true;
            }
        }
        if (be.kS(this.iCy.iwQ)) {
            this.dxf.Ox("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.iCy.iwQ);
                keyValuePreference.jz(false);
                keyValuePreference.ocP = true;
            }
        }
        if (be.kS(this.iCy.url)) {
            this.dxf.Ox("v_contact_info_home_page");
            this.dxf.Ox("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.dxf.Ow("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.iCy.url);
                vcardContactLinkPreference.jz(false);
                vcardContactLinkPreference.ocP = true;
            }
        }
        if (be.kS(this.iCy.bCc)) {
            this.dxf.Ox("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.dxf.Ow("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.iCy.bCc);
                vcardContactLinkPreference.jz(false);
                vcardContactLinkPreference.ocP = true;
            }
        }
        if (be.kS(this.iCy.iwF)) {
            this.dxf.Ox("v_contact_info_birthday");
            this.dxf.Ox("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.iCy.iwF);
                keyValuePreference.jz(false);
                keyValuePreference.ocP = true;
            }
        }
        if (be.kS(this.iCy.iwR)) {
            this.dxf.Ox("v_contact_info_remark");
            this.dxf.Ox("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.iCy.iwR);
                keyValuePreference.jz(false);
                keyValuePreference.ocP = true;
            }
        }
        if (this.iCy.iwD == null || !this.iCy.iwD.ixb.contains("uri")) {
            this.dxf.Ox("v_contact_info_logo");
            this.dxf.Ox("v_category_logo");
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.dxf.Ow("v_contact_info_logo");
        vcardContactLinkPreference.setSummary(this.iCy.iwD.ixc);
        vcardContactLinkPreference.ocP = false;
        vcardContactLinkPreference.jz(false);
    }

    private void b(List<String> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                KeyValuePreference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!iCz.contains(str + String.valueOf(str3))) {
                    iCz.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle(str2);
                vcardContactLinkPreference.setLayoutResource(2130903996);
                vcardContactLinkPreference.setSummary(str3);
                vcardContactLinkPreference.jz(false);
                vcardContactLinkPreference.ocP = true;
                this.dxf.a(vcardContactLinkPreference, iCB);
            }
        }
    }

    private void ct(String str, String str2) {
        KeyValuePreference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle(str2);
        keyValuePreference.setLayoutResource(2130903996);
        keyValuePreference.jz(false);
        keyValuePreference.setSummary(str);
        keyValuePreference.ocP = false;
        this.dxf.a(keyValuePreference, iCC);
    }

    private static void a(List<String> list, Intent intent, int i, int i2) {
        for (String str : list) {
            if (i2 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i);
            }
        }
    }
}
