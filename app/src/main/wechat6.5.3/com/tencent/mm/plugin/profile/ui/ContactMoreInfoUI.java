package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import org.json.JSONObject;

public class ContactMoreInfoUI extends MMActivity {
    private String bZy;
    o ePs;
    private String eQD;
    boolean eQU = false;
    private u fnD;
    private String gDh;
    private ProfileNormalItemView hUA;
    private ProfileNormalItemView hUB;
    private ProfileNormalItemView hUC;
    private ProfileNormalItemView hUD;
    private ProfileNormalItemView hUE;
    private ProfileNormalItemView hUF;
    private String hUG;
    private String hUH;
    private String hUI;
    private long hUJ;
    private String hUK;
    String hUL = null;
    private ProfileNormalItemView hUz;

    protected final int getLayoutId() {
        return 2130903414;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aGD();
        NI();
    }

    protected final void NI() {
        ProfileNormalItemView profileNormalItemView;
        ProfileNormalItemView profileNormalItemView2;
        String str = null;
        boolean z = false;
        super.NI();
        this.hUz = (ProfileNormalItemView) findViewById(2131756483);
        this.hUA = (ProfileNormalItemView) findViewById(2131756485);
        this.hUB = (ProfileNormalItemView) findViewById(2131756486);
        this.hUE = (ProfileNormalItemView) findViewById(2131756487);
        this.hUE.hRE.setSingleLine(false);
        this.hUF = (ProfileNormalItemView) findViewById(2131756488);
        this.hUC = (ProfileNormalItemView) findViewById(2131756484);
        this.hUD = (ProfileNormalItemView) findViewById(2131756489);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactMoreInfoUI hUM;

            {
                this.hUM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hUM.finish();
                return true;
            }
        });
        aGD();
        this.ePs = ak.yW().wO().LC(this.eQD);
        String value = j.sU().getValue("LinkedinPluginClose");
        boolean z2 = be.kS(value) || Integer.valueOf(value).intValue() == 0;
        boolean z3;
        if (!z2 || be.kS(this.fnD.bCv)) {
            this.hUz.setVisibility(8);
            z3 = false;
        } else {
            this.hUz.setVisibility(0);
            if (be.kS(this.hUG)) {
                this.hUG = this.fnD.bCw;
            }
            profileNormalItemView = this.hUz;
            profileNormalItemView.hXs = this.hUG;
            profileNormalItemView.hXt = new OnClickListener(this) {
                final /* synthetic */ ContactMoreInfoUI hUM;

                {
                    this.hUM = r1;
                }

                public final void onClick(View view) {
                    if (be.kS(this.hUM.hUH)) {
                        this.hUM.hUH = this.hUM.fnD.bCx;
                    }
                    if (!be.kS(this.hUM.hUH)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", this.hUM.hUH);
                        intent.putExtra("geta8key_username", k.xF());
                        c.b(this.hUM, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
            };
            z3 = profileNormalItemView.or(getResources().getColor(2131690171)).aGZ();
        }
        this.hUA.setVisibility(0);
        profileNormalItemView = this.hUA;
        profileNormalItemView.hXs = this.gDh;
        boolean aGZ = profileNormalItemView.aGZ();
        ak.yW();
        int f = be.f((Integer) com.tencent.mm.model.c.vf().get(9, null));
        this.hUJ = getIntent().getLongExtra("Contact_Uin", 0);
        this.hUK = getIntent().getStringExtra("Contact_QQNick");
        if (this.hUJ == 0 || f == 0) {
            this.hUB.setVisibility(8);
            z2 = false;
        } else {
            if (this.hUK == null || this.hUK.length() == 0) {
                af ae = ah.FQ().ae(this.hUJ);
                if (ae == null) {
                    ae = null;
                }
                if (ae != null) {
                    this.hUK = ae.getDisplayName();
                }
            }
            CharSequence charSequence = be.ma(this.hUK) + " " + new com.tencent.mm.a.o(this.hUJ).longValue();
            this.hUB.setVisibility(0);
            profileNormalItemView2 = this.hUB;
            profileNormalItemView2.hXs = charSequence;
            profileNormalItemView2.hXt = new OnClickListener(this) {
                final /* synthetic */ ContactMoreInfoUI hUM;

                {
                    this.hUM = r1;
                }

                public final void onClick(View view) {
                    g.a(this.hUM, null, new String[]{this.hUM.getResources().getString(2131232115), this.hUM.getResources().getString(2131232116)}, null, new g.c(this.hUM) {
                        final /* synthetic */ ContactMoreInfoUI hUM;

                        {
                            this.hUM = r1;
                        }

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    ke keVar = new ke();
                                    keVar.bla.opType = 0;
                                    keVar.bla.blc = this.hUM.hUJ + "@qqim";
                                    keVar.bla.bld = this.hUM.hUK;
                                    a.nhr.z(keVar);
                                    if (keVar.blb.aYN) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Chat_User", this.hUM.hUJ + "@qqim");
                                        com.tencent.mm.plugin.profile.a.drp.e(intent, this.hUM);
                                        return;
                                    }
                                    return;
                                case 1:
                                    new com.tencent.mm.pluginsdk.ui.applet.k(this.hUM).HB(this.hUM.hUJ);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
            };
            z2 = profileNormalItemView2.aGZ();
        }
        profileNormalItemView2 = this.hUE;
        profileNormalItemView2.hXs = e.a(this, this.fnD.bCj);
        boolean aGZ2 = profileNormalItemView2.aGZ();
        switch (this.fnD.bbT) {
            case 1:
                this.hUF.oq(2131232185);
                break;
            case 3:
                this.hUF.oq(2131232186);
                break;
            case 4:
            case 12:
                this.hUF.oq(2131232842);
                break;
            case 8:
            case an.CTRL_INDEX /*14*/:
                com.tencent.mm.i.a LX;
                String str2;
                this.hUF.oq(2131232179);
                f kH = l.KC().kH(this.fnD.field_username);
                if (kH != null) {
                    ak.yW();
                    LX = com.tencent.mm.model.c.wH().LX(kH.field_chatroomName);
                } else {
                    LX = null;
                }
                if (LX == null || ((int) LX.chr) == -1) {
                    str2 = null;
                } else {
                    str2 = LX.field_nickname;
                }
                if (!be.kS(str2)) {
                    this.hUF.hXs = getString(2131232180, new Object[]{str2});
                    break;
                } else {
                    this.hUF.hXs = getString(2131232179);
                    break;
                }
                break;
            case 10:
            case as.CTRL_INDEX /*13*/:
                this.hUF.oq(2131232841);
                break;
            case am.CTRL_INDEX /*15*/:
                break;
            case 17:
                this.hUF.oq(2131232177);
                break;
            case 18:
                this.hUF.oq(2131232181);
                break;
            case bf.CTRL_INDEX /*22*/:
            case 23:
            case 24:
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
            case bv.CTRL_INDEX /*27*/:
            case p.CTRL_INDEX /*28*/:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
                this.hUF.oq(2131232187);
                break;
            case 25:
                this.hUF.oq(2131231509);
                break;
            case 30:
                this.hUF.oq(2131234272);
                break;
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                this.hUF.oq(2131232176);
                break;
            case 48:
                this.hUF.oq(2131232183);
                break;
            case 58:
            case 59:
            case EncrptType.VERIFY_CODE /*60*/:
                this.hUF.oq(2131233147);
                break;
            case 76:
                this.hUF.oq(2131232182);
                break;
            default:
                this.hUF.hXs = null;
                break;
        }
        this.hUF.oq(2131232184);
        boolean aGZ3 = this.hUF.aGZ();
        boolean z4 = z(this.fnD);
        if (!this.eQU) {
            this.hUD.setVisibility(8);
        } else if (this.ePs != null) {
            ProfileNormalItemView profileNormalItemView3 = this.hUD;
            String Lz = this.ePs.Lz(this.fnD.field_username);
            if (this.ePs != null) {
                ak.yW();
                u LX2 = com.tencent.mm.model.c.wH().LX(Lz);
                if (LX2 != null && ((int) LX2.chr) > 0) {
                    str = LX2.field_conRemark;
                }
                if (be.kS(str)) {
                    str = this.ePs.er(Lz);
                }
                if (be.kS(str) && LX2 != null && ((int) LX2.chr) > 0) {
                    str = LX2.tT();
                }
                if (be.kS(str)) {
                    v.i("MicroMsg.ContactMoreInfoUI", "nickname is null");
                    str = Lz;
                }
            }
            profileNormalItemView3.hXs = e.a(this, be.ma(str));
            profileNormalItemView3.aGZ();
            z = true;
        }
        if (!aGZ2 && !aGZ3 && !z4 && !r1 && !aGZ && !r0 && !r2) {
            finish();
        }
    }

    private boolean z(u uVar) {
        String str;
        CharSequence optString;
        if (k.xF().equals(uVar.field_username)) {
            ak.yW();
            str = (String) com.tencent.mm.model.c.vf().get(t.a.nqZ, null);
        } else {
            str = uVar.bCy;
        }
        if (!be.kS(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.hUL = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (Throwable e) {
                v.a("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (be.kS(this.hUL)) {
                this.hUC.setVisibility(0);
                this.hUC.hXs = optString;
                this.hUC.or(getResources().getColor(2131690171));
                ProfileNormalItemView profileNormalItemView = this.hUC;
                profileNormalItemView.hXt = new OnClickListener(this) {
                    final /* synthetic */ ContactMoreInfoUI hUM;

                    {
                        this.hUM = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", this.hUM.hUL);
                        intent.putExtra("geta8key_username", k.xF());
                        c.b(this.hUM, "webview", ".ui.tools.WebViewUI", intent);
                    }
                };
                profileNormalItemView.aGZ();
                return true;
            }
            this.hUC.setVisibility(8);
            return false;
        }
        optString = null;
        if (be.kS(this.hUL)) {
            this.hUC.setVisibility(8);
            return false;
        }
        this.hUC.setVisibility(0);
        this.hUC.hXs = optString;
        this.hUC.or(getResources().getColor(2131690171));
        ProfileNormalItemView profileNormalItemView2 = this.hUC;
        profileNormalItemView2.hXt = /* anonymous class already generated */;
        profileNormalItemView2.aGZ();
        return true;
    }

    private void aGD() {
        this.eQU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.eQD = getIntent().getStringExtra("Contact_ChatRoomId");
        this.bZy = getIntent().getStringExtra("Contact_User");
        ak.yW();
        this.fnD = com.tencent.mm.model.c.wH().LX(this.bZy);
        this.hUG = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.hUH = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.gDh = getIntent().getStringExtra("verify_gmail");
        this.hUI = getIntent().getStringExtra("profileName");
    }
}
