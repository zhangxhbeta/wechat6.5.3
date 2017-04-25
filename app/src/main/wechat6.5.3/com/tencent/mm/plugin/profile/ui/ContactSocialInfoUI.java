package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

public class ContactSocialInfoUI extends MMPreference {
    private String ble;
    private f ezq;
    private u fnD;
    private long hUJ;
    private String hUK;
    private b hUT;
    private String hUU;
    private String hUV;
    private String hUW;
    private String hUX;
    private String hUY;
    private String hUZ;
    private String hVa;
    private JSONObject hVb;

    static /* synthetic */ void a(ContactSocialInfoUI contactSocialInfoUI, final String str, final String str2) {
        if (be.kS(str) || be.kS(str2)) {
            Toast.makeText(contactSocialInfoUI.nDR.nEl, contactSocialInfoUI.nDR.nEl.getString(2131232148), 0).show();
            return;
        }
        n.AX();
        Bitmap gJ = d.gJ(str);
        if (gJ == null) {
            Toast.makeText(contactSocialInfoUI.nDR.nEl, contactSocialInfoUI.nDR.nEl.getString(2131232149), 0).show();
            final e eVar = new e();
            eVar.a(str, new e.b(contactSocialInfoUI) {
                final /* synthetic */ ContactSocialInfoUI hVc;

                public final int aG(int i, int i2) {
                    eVar.Bb();
                    v.i("MicroMsg.ContactSocialInfoUI", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        n.AX();
                        if (this.hVc.o(str2, d.gJ(str))) {
                            Toast.makeText(this.hVc.nDR.nEl, this.hVc.nDR.nEl.getString(2131232150), 0).show();
                            return 0;
                        }
                    }
                    Toast.makeText(this.hVc.nDR.nEl, this.hVc.nDR.nEl.getString(2131232148), 0).show();
                    return 0;
                }
            });
        } else if (contactSocialInfoUI.o(str2, gJ)) {
            Toast.makeText(contactSocialInfoUI.nDR.nEl, contactSocialInfoUI.nDR.nEl.getString(2131232150), 0).show();
        } else {
            Toast.makeText(contactSocialInfoUI.nDR.nEl, contactSocialInfoUI.nDR.nEl.getString(2131232148), 0).show();
        }
    }

    public final int Oo() {
        return 2131099689;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ble = be.ma(getIntent().getStringExtra("Contact_User"));
        ak.yW();
        this.fnD = c.wH().LX(this.ble);
        NI();
    }

    protected final void NI() {
        vD(2131232173);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSocialInfoUI hVc;

            {
                this.hVc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hVc.finish();
                return true;
            }
        });
        this.ezq = this.ocZ;
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (be.kS(stringExtra) && be.kS(stringExtra2)) {
            if (be.kS(this.fnD.field_username)) {
                this.hUT = ah.FL().iA(this.ble);
            } else {
                this.hUT = ah.FL().iA(this.fnD.field_username);
            }
        } else if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
            this.hUT = ah.FL().iB(stringExtra);
            if (this.hUT == null || this.hUT.EB() == null || this.hUT.EB().length() <= 0) {
                this.hUT = ah.FL().iB(stringExtra2);
                if (!(this.hUT == null || this.hUT.EB() == null)) {
                    this.hUT.EB().length();
                }
            }
        }
        if (this.hUT == null || this.hUT.EB() == null || this.hUT.EB().length() <= 0) {
            v.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.hUU);
        } else {
            this.hUV = be.ma(this.hUT.ED()) + " " + be.ma(this.hUT.EJ()).replace(" ", "");
        }
        j("contact_info_social_mobile", this.hUV, true);
        ak.yW();
        int f = be.f((Integer) c.vf().get(9, null));
        this.hUJ = getIntent().getLongExtra("Contact_Uin", 0);
        this.hUK = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.hUJ == 0 || f == 0)) {
            if (this.hUK == null || this.hUK.length() == 0) {
                af ae = ah.FQ().ae(this.hUJ);
                if (ae == null) {
                    ae = null;
                }
                if (ae != null) {
                    this.hUK = ae.getDisplayName();
                }
            }
            this.hUW = be.ma(this.hUK);
            this.hUW += " " + new o(this.hUJ).longValue();
        }
        j("contact_info_social_qq", this.hUW, true);
        stringExtra = j.sU().getValue("LinkedinPluginClose");
        boolean z = be.kS(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0;
        if (!z || be.kS(this.fnD.bCv)) {
            this.hUX = "";
        } else {
            this.hUX = this.fnD.bCw;
        }
        j("contact_info_social_linkedin", this.hUX, true);
        j("contact_info_social_facebook", this.hUY, false);
        this.hVa = be.ah(getIntent().getStringExtra("verify_gmail"), "");
        this.hUZ = be.ah(getIntent().getStringExtra("profileName"), be.KU(this.hVa));
        if (be.kS(this.hVa) || be.kS(this.hUZ)) {
            j("contact_info_social_googlecontacts", "", false);
        } else {
            j("contact_info_social_googlecontacts", this.hUZ + '\n' + this.hVa, false);
        }
        if (k.xF().equals(this.fnD.field_username)) {
            ak.yW();
            stringExtra = (String) c.vf().get(a.nqZ, null);
            v.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[]{stringExtra});
        } else {
            stringExtra = this.fnD.bCy;
            v.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[]{stringExtra});
        }
        if (!be.kS(stringExtra)) {
            try {
                this.hVb = new JSONObject(stringExtra);
            } catch (Throwable e) {
                v.a("MicroMsg.ContactSocialInfoUI", e, "", new Object[0]);
                this.hVb = null;
            }
        }
        if (this.hVb != null) {
            j("contact_info_social_weishop", this.hVb.optString("ShopName"), true);
        } else {
            j("contact_info_social_weishop", "", false);
        }
    }

    private void j(String str, String str2, boolean z) {
        if (be.kS(str2) || be.kS(str)) {
            this.ezq.Ox(str);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ezq.Ow(str);
        if (keyValuePreference != null) {
            keyValuePreference.ocS = true;
            keyValuePreference.ocU = 5;
            if (z) {
                keyValuePreference.eNB = getResources().getColor(2131689819);
            }
            keyValuePreference.setSummary(str2);
            keyValuePreference.jz(false);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.hUT == null || this.fnD == null)) {
                ak.yW();
                if (c.wH().LT(this.hUT.getUsername())) {
                    String[] stringArray = (this.hUT == null || be.kS(this.hUT.cyx)) ? getResources().getStringArray(2131296267) : getResources().getStringArray(2131296266);
                    if (com.tencent.mm.plugin.profile.a.drq.oB()) {
                        List g = be.g(stringArray);
                        g.add(getResources().getString(2131231860));
                        stringArray = (String[]) g.toArray(new String[g.size()]);
                        g.iuh.h(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
                    }
                    com.tencent.mm.ui.base.g.a(this, null, stringArray, null, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ ContactSocialInfoUI hVc;

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    if (this.hVc.hUV != null && this.hVc.hUV.length() != 0) {
                                        int lastIndexOf = this.hVc.hUV.lastIndexOf(32) + 1;
                                        if (lastIndexOf > 0) {
                                            this.hVc.xN(this.hVc.hUV.substring(lastIndexOf));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 1:
                                    if (this.hVc.hUV != null && this.hVc.hUV.length() != 0) {
                                        String substring = this.hVc.hUV.substring(0, this.hVc.hUV.lastIndexOf(32));
                                        if (substring != null && substring.length() != 0) {
                                            m.b(this.hVc.fnD, substring.trim());
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 2:
                                    if (stringArray != null && stringArray.length > 2 && this.hVc.hUT != null && this.hVc.fnD != null) {
                                        if (!(this.hVc.hUT == null || be.kS(this.hVc.hUT.cyx))) {
                                            ContactSocialInfoUI.a(this.hVc, this.hVc.fnD.field_username, this.hVc.hUT.cyx);
                                            return;
                                        }
                                    }
                                    return;
                                    break;
                                case 3:
                                    break;
                                default:
                                    return;
                            }
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putInt("fromScene", 2);
                            intent.putExtra("reportArgs", bundle);
                            com.tencent.mm.plugin.profile.a.drp.k(intent, this.hVc);
                        }
                    });
                } else if (!(this.hUV == null || this.hUV.length() == 0)) {
                    int lastIndexOf = this.hUV.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        xN(this.hUV.substring(lastIndexOf));
                    }
                }
            }
        } else if (str.equals("contact_info_social_qq")) {
            com.tencent.mm.ui.base.g.a(this, null, new String[]{getResources().getString(2131232115), getResources().getString(2131232116)}, null, new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ ContactSocialInfoUI hVc;

                {
                    this.hVc = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            ke keVar = new ke();
                            keVar.bla.opType = 0;
                            keVar.bla.blc = this.hVc.hUJ + "@qqim";
                            keVar.bla.bld = this.hVc.hUK;
                            com.tencent.mm.sdk.c.a.nhr.z(keVar);
                            if (keVar.blb.aYN) {
                                Intent intent = new Intent();
                                intent.putExtra("Chat_User", this.hVc.hUJ + "@qqim");
                                com.tencent.mm.plugin.profile.a.drp.e(intent, this.hVc);
                                return;
                            }
                            return;
                        case 1:
                            new com.tencent.mm.pluginsdk.ui.applet.k(this.hVc).HB(this.hVc.hUJ);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (str.equals("contact_info_social_linkedin")) {
            str = this.fnD.bCx;
            if (be.kS(str)) {
                v.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_username", k.xF());
                com.tencent.mm.ay.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        } else if (!(str.equals("contact_info_social_facebook") || str.equals("contact_info_social_googlecontacts") || !str.equals("contact_info_social_weishop") || this.hVb == null)) {
            ak.yW();
            if (c.vf().get(a.nrA, null) == null) {
                com.tencent.mm.ui.base.g.a(this, 2131232175, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ ContactSocialInfoUI hVc;

                    {
                        this.hVc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.hVc.aGE();
                        ak.yW();
                        c.vf().a(a.nrA, Integer.valueOf(1));
                    }
                }, null);
            } else {
                aGE();
            }
        }
        return false;
    }

    private boolean o(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return com.tencent.mm.modelfriend.m.a(str, this.nDR.nEl, byteArrayOutputStream.toByteArray());
    }

    private void xN(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + str));
        startActivity(intent);
    }

    private void aGE() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.hVb.optString("ShopUrl"));
        intent.putExtra("geta8key_username", k.xF());
        com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
