package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.j.q.e;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.base.s;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import junit.framework.Assert;
import org.json.JSONObject;

public final class j implements a, e.a, com.tencent.mm.v.e {
    private int bcS = 0;
    Activity bij;
    private f dxf;
    o ePs;
    private String eQD;
    u euW;
    private String gDh;
    private boolean hTY;
    private boolean hTZ;
    int hUa;
    private String hUb;
    private int hVI;
    private axg hVO = new axg();
    private boolean hVP;
    private String hVQ = "";
    private int hVR = -1;
    private boolean hVS = false;
    private boolean hVT = false;
    private String hVU;
    private boolean hVV = false;
    private boolean hVW = false;
    private String hVX = null;
    private String hVY = null;
    private int hVZ;
    String hWa;

    public j(Activity activity) {
        this.bij = activity;
    }

    public final boolean pz(String str) {
        Intent intent;
        if (str.equals("contact_info_sns")) {
            ak.yW();
            if (c.isSDCardAvailable()) {
                intent = this.bij.getIntent();
                intent.putExtra("sns_source", this.bcS);
                intent.putExtra("sns_signature", this.euW.bCj);
                intent.putExtra("sns_nickName", this.euW.tT());
                intent.putExtra("sns_title", this.euW.tU());
                if (com.tencent.mm.pluginsdk.j.ak.lyj != null) {
                    intent = com.tencent.mm.pluginsdk.j.ak.lyj.e(intent, this.euW.field_username);
                }
                if (intent == null) {
                    ((MMActivity) this.bij).finish();
                } else {
                    com.tencent.mm.ay.c.b(this.bij, "sns", ".ui.SnsUserUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        ((MMActivity) this.bij).finish();
                    }
                }
            } else {
                s.ey(this.bij);
                return true;
            }
        }
        long longExtra;
        if (str.equals("contact_info_more")) {
            Intent intent2 = new Intent();
            intent2.setClass(this.bij, ContactMoreInfoUI.class);
            intent2.putExtra("Is_RoomOwner", this.bij.getIntent().getBooleanExtra("Is_RoomOwner", false));
            intent2.putExtra("Contact_User", this.euW.field_username);
            intent2.putExtra("KLinkedInAddFriendNickName", this.hVX);
            intent2.putExtra("KLinkedInAddFriendPubUrl", this.hVY);
            String stringExtra = this.bij.getIntent().getStringExtra("room_name");
            if (stringExtra == null) {
                stringExtra = this.bij.getIntent().getStringExtra("Contact_ChatRoomId");
            }
            intent2.putExtra("Contact_ChatRoomId", stringExtra);
            intent2.putExtra("verify_gmail", this.gDh);
            intent2.putExtra("profileName", this.hVU);
            longExtra = this.bij.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra = this.bij.getIntent().getStringExtra("Contact_QQNick");
            intent2.putExtra("Contact_Uin", longExtra);
            intent2.putExtra("Contact_QQNick", stringExtra);
            this.bij.startActivity(intent2);
        } else if (str.equals("contact_info_social")) {
            intent = new Intent();
            intent.setClass(this.bij, ContactSocialInfoUI.class);
            intent.putExtra("Contact_User", this.euW.field_username);
            longExtra = this.bij.getIntent().getLongExtra("Contact_Uin", 0);
            String stringExtra2 = this.bij.getIntent().getStringExtra("Contact_QQNick");
            intent.putExtra("Contact_Uin", longExtra);
            intent.putExtra("Contact_QQNick", stringExtra2);
            intent.putExtra("profileName", this.hVU);
            intent.putExtra("verify_gmail", this.gDh);
            stringExtra2 = this.bij.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra3 = this.bij.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            intent.putExtra("Contact_Mobile_MD5", stringExtra2);
            intent.putExtra("Contact_full_Mobile_MD5", stringExtra3);
            this.bij.startActivity(intent);
        }
        return true;
    }

    final void xR(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.hUa);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.euW.field_username);
        intent.putExtra("Contact_Nick", this.euW.field_nickname);
        intent.putExtra("Contact_RemarkName", this.euW.field_conRemark);
        com.tencent.mm.plugin.profile.a.drp.r(intent, this.bij);
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        String stringExtra;
        String str;
        int i2;
        KeyValuePreference keyValuePreference;
        Assert.assertTrue(uVar != null);
        Assert.assertTrue(be.ma(uVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.dxf = fVar;
        this.euW = uVar;
        this.hTY = z;
        this.hUa = i;
        this.hTZ = this.bij.getIntent().getBooleanExtra("User_Verify", false);
        this.hUb = be.ma(this.bij.getIntent().getStringExtra("Verify_ticket"));
        this.hVP = this.bij.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.hVI = this.bij.getIntent().getIntExtra("Kdel_from", -1);
        this.hVQ = this.bij.getIntent().getStringExtra("Contact_RemarkName");
        this.bcS = this.bij.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.hVS = this.bij.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.hVT = this.bij.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.hVR = this.bij.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.bij.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String ah = be.ah(this.bij.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.gDh = be.ah(this.bij.getIntent().getStringExtra("verify_gmail"), "");
        this.hVU = be.ah(this.bij.getIntent().getStringExtra("profileName"), be.KU(this.gDh));
        this.hVO.cHn = this.hVR;
        this.hVO.cHp = longExtra;
        this.hVO.cHo = ah;
        this.hVX = this.bij.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.hVY = this.bij.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (com.tencent.mm.pluginsdk.j.ak.lyf != null) {
            this.hVO = com.tencent.mm.pluginsdk.j.ak.lyf.b(uVar.field_username, this.hVO);
        }
        this.eQD = this.bij.getIntent().getStringExtra("room_name");
        this.ePs = ak.yW().wO().LC(this.eQD);
        this.hVW = uVar.field_deleteFlag == 1;
        XS();
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099674);
        if (com.tencent.mm.pluginsdk.j.ak.lyj != null) {
            com.tencent.mm.pluginsdk.j.ak.lyj.a(3, this.euW.field_username, this);
        }
        ak.vy().a(30, this);
        this.hWa = "";
        v.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[]{this.euW.tQ()});
        if (!this.euW.tQ()) {
            b bVar = null;
            stringExtra = this.bij.getIntent().getStringExtra("Contact_Mobile_MD5");
            ah = this.bij.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            Object[] objArr;
            if (be.kS(stringExtra) && be.kS(ah)) {
                if (!be.kS(this.euW.field_username)) {
                    b iA = ah.FL().iA(this.euW.field_username);
                    ah = "MicroMsg.ContactWidgetNormal";
                    str = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.euW.field_username;
                    objArr[1] = iA == null ? "true" : "false";
                    v.i(ah, str, objArr);
                    bVar = iA;
                }
            } else if (!(be.kS(stringExtra) && be.kS(ah))) {
                v.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[]{this.euW.field_username, stringExtra, ah});
                bVar = ah.FL().iB(stringExtra);
                if (bVar == null || be.kS(bVar.EB())) {
                    bVar = ah.FL().iB(ah);
                }
                ah = "MicroMsg.ContactWidgetNormal";
                str = "Contact name: %s AddrUpload IS NULL? %s";
                objArr = new Object[2];
                objArr[0] = this.euW.field_username;
                objArr[1] = bVar == null ? "true" : "false";
                v.i(ah, str, objArr);
            }
            if (!(bVar == null || be.kS(bVar.EB()))) {
                this.hWa = be.ma(bVar.EJ()).replace(" ", "");
                v.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[]{this.euW.field_username, this.hWa});
            }
        }
        final NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.dxf.Ow("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            u uVar2 = this.euW;
            i2 = this.hUa;
            ah = this.hUb;
            str = this.hWa;
            String str2 = this.euW.bCz;
            normalUserHeaderPreference.lHr = str;
            normalUserHeaderPreference.lHs = str2;
            normalUserHeaderPreference.a(uVar2, i2, ah);
            normalUserHeaderPreference.aF(this.euW.field_username, this.hVS);
            if (this.hTZ) {
                normalUserHeaderPreference.aF(this.euW.field_username, true);
            }
            normalUserHeaderPreference.lQp = new OnClickListener(this) {
                final /* synthetic */ j hWb;

                {
                    this.hWb = r1;
                }

                public final void onClick(View view) {
                    j jVar = this.hWb;
                    if (jVar.euW == null) {
                        v.e("MicroMsg.ContactWidgetNormal", "contact is null");
                    } else if (com.tencent.mm.i.a.ei(jVar.euW.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_Scene", jVar.hUa);
                        intent.putExtra("Contact_User", jVar.euW.field_username);
                        intent.putExtra("Contact_RoomNickname", jVar.bij.getIntent().getStringExtra("Contact_RoomNickname"));
                        intent.putExtra("view_mode", true);
                        intent.putExtra("contact_phone_number_by_md5", jVar.hWa);
                        intent.putExtra("contact_phone_number_list", jVar.euW.bCz);
                        com.tencent.mm.plugin.profile.a.drp.q(intent, jVar.bij);
                    } else if (be.kS(jVar.euW.field_encryptUsername)) {
                        jVar.xR(jVar.euW.field_username);
                    } else {
                        jVar.xR(jVar.euW.field_encryptUsername);
                    }
                }
            };
            if (this.hTZ && (this.hUa == 30 || this.hUa == 1 || this.hUa == 3 || this.hUa == 12 || this.hUa == 13)) {
                this.hVT = true;
            }
            if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                this.hVT = false;
            }
            normalUserHeaderPreference.aG(this.euW.field_username, this.hVT);
        } else {
            this.dxf.b(normalUserHeaderPreference);
        }
        if (be.kS(this.euW.getProvince())) {
            this.dxf.Ox("contact_info_district");
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_district");
            if (keyValuePreference != null) {
                keyValuePreference.setTitle(this.bij.getString(2131232026));
                keyValuePreference.setSummary(l.eu(this.euW.getProvince()) + (be.kS(this.euW.getCity()) ? "" : "  " + this.euW.getCity()));
                keyValuePreference.jz(false);
                keyValuePreference.setEnabled(false);
            }
        }
        if (this.euW.bCj == null || this.euW.bCj.trim().equals("") || com.tencent.mm.i.a.ei(this.euW.field_type)) {
            this.dxf.Ox("contact_info_signature");
        } else {
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_signature");
            if (keyValuePreference != null) {
                keyValuePreference.ocP = false;
                keyValuePreference.setTitle(this.bij.getString(2131232165));
                keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a(this.bij, this.euW.bCj));
                keyValuePreference.jz(false);
            }
        }
        this.dxf.Ow("contact_info_facebook");
        this.dxf.Ox("contact_info_facebook");
        if ((((this.hVO.cHn & 1) > 0 ? 1 : 0) & com.tencent.mm.ay.c.EH("sns")) == 0 || u.LI(this.euW.field_username) || this.euW.tK()) {
            this.dxf.Ox("contact_info_sns");
        } else {
            g gVar = (g) this.dxf.Ow("contact_info_sns");
            if (!(gVar == null || com.tencent.mm.pluginsdk.j.ak.lyf == null)) {
                gVar.HO(this.euW.field_username);
            }
        }
        this.dxf.Ox("contact_info_verifyuser");
        if (this.hUa == 34) {
            this.dxf.Ox("contact_info_footer_normal");
        }
        if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
            aGM();
            this.dxf.Ox("contact_info_social");
        } else {
            ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.dxf.Ow("contact_info_social");
            if (contactSocialInfoPreference != null) {
                if (be.kS(this.hWa)) {
                    contactSocialInfoPreference.on(8);
                } else {
                    contactSocialInfoPreference.on(0);
                    this.hVZ = 1;
                }
                ak.yW();
                i2 = be.f((Integer) c.vf().get(9, null));
                long longExtra2 = this.bij.getIntent().getLongExtra("Contact_Uin", 0);
                str2 = this.bij.getIntent().getStringExtra("Contact_QQNick");
                if (!(longExtra2 == 0 || i2 == 0)) {
                    if (str2 == null || str2.length() == 0) {
                        af ae = ah.FQ().ae(longExtra2);
                        if (ae == null) {
                            ae = null;
                        }
                        if (ae != null) {
                            ae.getDisplayName();
                        }
                    }
                    if (longExtra2 == -1 || new com.tencent.mm.a.o(longExtra2).longValue() <= 0) {
                        contactSocialInfoPreference.oj(8);
                    } else {
                        contactSocialInfoPreference.oj(0);
                        this.hVZ = 1;
                    }
                }
                if (be.kS(this.gDh) || be.kS(this.hVU)) {
                    contactSocialInfoPreference.ol(8);
                } else {
                    contactSocialInfoPreference.ol(0);
                    this.hVZ = 1;
                }
                stringExtra = com.tencent.mm.h.j.sU().getValue("LinkedinPluginClose");
                Object obj = (be.kS(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0) ? 1 : null;
                if (obj == null || be.kS(this.euW.bCv)) {
                    contactSocialInfoPreference.ok(8);
                } else {
                    contactSocialInfoPreference.ok(0);
                    this.hVZ = 1;
                }
                if (k.xF().equals(this.euW.field_username)) {
                    ak.yW();
                    stringExtra = (String) c.vf().get(t.a.nqZ, null);
                } else {
                    stringExtra = this.euW.bCy;
                }
                ah = null;
                if (!be.kS(stringExtra)) {
                    try {
                        ah = new JSONObject(stringExtra).optString("ShopUrl");
                    } catch (Throwable e) {
                        v.a("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                    }
                }
                v.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[]{stringExtra, ah});
                if (be.kS(ah)) {
                    contactSocialInfoPreference.om(8);
                } else {
                    contactSocialInfoPreference.om(0);
                    this.hVZ = 1;
                }
                if (this.hVZ == 0) {
                    this.dxf.Ox("contact_info_social");
                }
            }
            this.dxf.Ox("contact_info_more");
        }
        if (!com.tencent.mm.i.a.ei(this.euW.field_type)) {
            if (!this.bij.getIntent().getBooleanExtra("Is_RoomOwner", false)) {
                this.dxf.Ox("contact_info_invite_source");
            }
            i2 = this.bij.getIntent().getIntExtra("Contact_Source_FMessage", 0);
            v.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.euW.bbT + ", sourceFMessage = " + i2);
            if (i2 == 0) {
                keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_source");
                switch (this.euW.bbT) {
                    case 18:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131232181));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    case bf.CTRL_INDEX /*22*/:
                    case 23:
                    case 24:
                    case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    case bv.CTRL_INDEX /*27*/:
                    case p.CTRL_INDEX /*28*/:
                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131232187));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    case 30:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131234272));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131232176));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    case 48:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131232183));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    case 58:
                    case 59:
                    case EncrptType.VERIFY_CODE /*60*/:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131233147));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    case 76:
                        if (keyValuePreference != null) {
                            keyValuePreference.ocP = true;
                            keyValuePreference.setTitle(this.bij.getString(2131232188));
                            keyValuePreference.setSummary(this.bij.getString(2131232182));
                            keyValuePreference.jz(false);
                            break;
                        }
                        break;
                    default:
                        this.dxf.b(keyValuePreference);
                        break;
                }
            }
            keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_source");
            switch (i2) {
                case 1:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131232185));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 3:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131232186));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 4:
                case 12:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131232842));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 8:
                case an.CTRL_INDEX /*14*/:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        stringExtra = null;
                        com.tencent.mm.ar.f kG = com.tencent.mm.ar.l.KC().kG(this.euW.field_username);
                        ak.yW();
                        u LX = c.wH().LX(kG.field_chatroomName);
                        if (LX != null) {
                            stringExtra = LX.field_nickname;
                        }
                        if (be.kS(stringExtra)) {
                            keyValuePreference.setSummary(this.bij.getString(2131232179));
                        } else {
                            keyValuePreference.setSummary(this.bij.getString(2131232180, new Object[]{stringExtra}));
                        }
                        keyValuePreference.jz(false);
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 10:
                case as.CTRL_INDEX /*13*/:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131232841));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case am.CTRL_INDEX /*15*/:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131232184));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 17:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        stringExtra = l.er(this.bij.getIntent().getStringExtra("source_from_user_name"));
                        if (be.kS(stringExtra)) {
                            stringExtra = this.bij.getIntent().getStringExtra("source_from_nick_name");
                        }
                        if (be.kS(stringExtra)) {
                            keyValuePreference.setSummary(this.bij.getString(2131232177));
                        } else {
                            keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a(this.bij, this.bij.getString(2131232178, new Object[]{stringExtra})));
                        }
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 25:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131231509));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 30:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131234272));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 48:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131232183));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                case 58:
                case 59:
                case EncrptType.VERIFY_CODE /*60*/:
                    if (keyValuePreference != null) {
                        keyValuePreference.ocP = true;
                        keyValuePreference.setTitle(this.bij.getString(2131232188));
                        keyValuePreference.setSummary(this.bij.getString(2131233147));
                        keyValuePreference.jz(false);
                        break;
                    }
                    break;
                default:
                    this.dxf.b(keyValuePreference);
                    break;
            }
        }
        this.dxf.Ox("contact_info_source");
        this.dxf.Ox("contact_info_invite_source");
        keyValuePreference = (KeyValuePreference) this.dxf.Ow("contact_info_invite_source");
        if (!(!this.bij.getIntent().getBooleanExtra("Is_RoomOwner", false) || keyValuePreference == null || this.ePs == null)) {
            CharSequence charSequence;
            ah = this.ePs.Lz(this.euW.field_username);
            if (this.ePs == null) {
                charSequence = null;
            } else {
                charSequence = null;
                ak.yW();
                u LX2 = c.wH().LX(ah);
                if (LX2 != null && ((int) LX2.chr) > 0) {
                    charSequence = LX2.field_conRemark;
                }
                if (be.kS(charSequence)) {
                    charSequence = this.ePs.er(ah);
                }
                if (be.kS(charSequence) && LX2 != null && ((int) LX2.chr) > 0) {
                    charSequence = LX2.tT();
                }
            }
            if (be.kS(charSequence)) {
                this.dxf.b(keyValuePreference);
            } else {
                keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a(this.bij, charSequence));
            }
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
        boolean booleanExtra = this.bij.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean booleanExtra2 = this.bij.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.bij.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long longExtra3 = this.bij.getIntent().getLongExtra("Contact_Uin", -1);
        if (this.hUa == 30) {
            this.hVP = false;
        }
        if (normalUserFooterPreference == null || !normalUserFooterPreference.a(this.euW, this.hUb, this.hTY, this.hTZ, this.hVP, this.hUa, this.hVI, booleanExtra2, booleanExtra, longExtra3, this.hVQ)) {
            this.dxf.Ox("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.cye.removeAll();
            normalUserFooterPreference.cye.a(new NormalUserFooterPreference.e(this) {
                final /* synthetic */ j hWb;

                public final void aa(String str, boolean z) {
                    normalUserHeaderPreference.aF(str, z);
                    normalUserHeaderPreference.gM(this.hWb.euW.field_username);
                }
            }, Looper.getMainLooper());
        }
        i2 = this.euW.bCn;
        this.dxf.Ox("clear_lbs_info");
        if (this.hVW) {
            this.dxf.removeAll();
            if (normalUserHeaderPreference != null) {
                this.dxf.a(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.dxf.a(normalUserFooterPreference);
            }
        }
        ak.yW();
        c.wH().LT(uVar.field_username);
        boolean equals = k.xF().equals(uVar.field_username);
        v.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[]{Integer.valueOf(this.hVO.cHn)});
        Object obj2 = (this.hVO.cHn & 1) > 0 ? 1 : null;
        if (!(uVar.tK() || u.LI(uVar.field_username) || obj2 == null || com.tencent.mm.pluginsdk.j.ak.lyj == null)) {
            com.tencent.mm.pluginsdk.j.ak.lyj.b(2, uVar.field_username, equals, this.bcS);
        }
        return true;
    }

    private void aGM() {
        boolean z = true;
        int[] iArr = new int[7];
        ContactMoreInfoPreference contactMoreInfoPreference = (ContactMoreInfoPreference) this.dxf.Ow("contact_info_more");
        if (contactMoreInfoPreference != null) {
            int i;
            boolean z2;
            f fVar;
            String str;
            long longExtra = this.bij.getIntent().getLongExtra("Contact_Uin", 0);
            if (longExtra == -1 || new com.tencent.mm.a.o(longExtra).longValue() <= 0) {
                contactMoreInfoPreference.oj(8);
                iArr[0] = 8;
            } else {
                contactMoreInfoPreference.oj(0);
                iArr[0] = 0;
            }
            if (be.kS(this.gDh) || be.kS(this.hVU)) {
                contactMoreInfoPreference.ol(8);
                iArr[1] = 8;
            } else {
                contactMoreInfoPreference.ol(0);
                iArr[1] = 0;
            }
            String value = com.tencent.mm.h.j.sU().getValue("LinkedinPluginClose");
            if (be.kS(value) || Integer.valueOf(value).intValue() == 0) {
                i = true;
            } else {
                i = 0;
            }
            if (i == 0 || be.kS(this.euW.bCv)) {
                contactMoreInfoPreference.ok(8);
                iArr[2] = 8;
            } else {
                contactMoreInfoPreference.ok(0);
                iArr[2] = 0;
            }
            if (k.xF().equals(this.euW.field_username)) {
                ak.yW();
                value = (String) c.vf().get(t.a.nqZ, null);
            } else {
                value = this.euW.bCy;
            }
            if (!be.kS(value)) {
                try {
                    value = new JSONObject(value).optString("ShopUrl");
                } catch (Throwable e) {
                    v.a("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                }
                if (be.kS(value)) {
                    contactMoreInfoPreference.om(0);
                    iArr[3] = 0;
                } else {
                    contactMoreInfoPreference.om(8);
                    iArr[3] = 8;
                }
                if (be.kS(this.euW.bCj)) {
                    iArr[4] = 0;
                } else {
                    iArr[4] = 8;
                }
                if (this.euW.bbT > 0) {
                    iArr[5] = 8;
                } else {
                    iArr[5] = 0;
                }
                iArr[6] = 8;
                z2 = true;
                i = 0;
                while (i < 7) {
                    if (iArr[i] == 0) {
                        z2 = true;
                        break;
                    } else {
                        i++;
                        z2 = false;
                    }
                }
                fVar = this.dxf;
                str = "contact_info_more";
                if (z2) {
                    z = false;
                }
                fVar.aO(str, z);
            }
            value = null;
            if (be.kS(value)) {
                contactMoreInfoPreference.om(8);
                iArr[3] = 8;
            } else {
                contactMoreInfoPreference.om(0);
                iArr[3] = 0;
            }
            if (be.kS(this.euW.bCj)) {
                iArr[4] = 0;
            } else {
                iArr[4] = 8;
            }
            if (this.euW.bbT > 0) {
                iArr[5] = 0;
            } else {
                iArr[5] = 8;
            }
            iArr[6] = 8;
            z2 = true;
            i = 0;
            while (i < 7) {
                if (iArr[i] == 0) {
                    z2 = true;
                    break;
                } else {
                    i++;
                    z2 = false;
                }
            }
            fVar = this.dxf;
            str = "contact_info_more";
            if (z2) {
                z = false;
            }
            fVar.aO(str, z);
        }
    }

    public final boolean XS() {
        if (com.tencent.mm.pluginsdk.j.ak.lyj != null) {
            com.tencent.mm.pluginsdk.j.ak.lyj.a(this, 3);
        }
        ak.vy().b(30, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.dxf.Ow("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.XS();
        }
        FriendPreference friendPreference = (FriendPreference) this.dxf.Ow("contact_info_friend_qq");
        if (friendPreference != null) {
            friendPreference.XS();
        }
        friendPreference = (FriendPreference) this.dxf.Ow("contact_info_friend_mobile");
        if (friendPreference != null) {
            friendPreference.XS();
        }
        friendPreference = (FriendPreference) this.dxf.Ow("contact_info_facebook");
        if (friendPreference != null) {
            friendPreference.XS();
        }
        this.dxf.Ow("contact_info_sns");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.pluginsdk.j.a.bmt().m(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.f(this.bij, this.bij.getString(2131232839));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(boolean z, boolean z2, String str, boolean z3) {
        g gVar = (g) this.dxf.Ow("contact_info_sns");
        if (!(gVar == null || com.tencent.mm.pluginsdk.j.ak.lyf == null)) {
            gVar.HO(this.euW.field_username);
        }
        this.hVO = com.tencent.mm.pluginsdk.j.ak.lyf.b(this.euW.field_username, this.hVO);
        this.dxf.notifyDataSetChanged();
        if (z3) {
            v.d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (com.tencent.mm.pluginsdk.j.ak.lyj != null) {
                com.tencent.mm.pluginsdk.j.ak.lyj.Az(this.euW.field_username);
            }
        }
    }

    public final void b(boolean z, String str, boolean z2) {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() != 30 && kVar.getType() != 458) {
            v.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + kVar.getType());
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 30) {
                m mVar = (m) kVar;
                if (mVar.bdn != 1 && mVar.bdn != 3) {
                    return;
                }
                if (mVar.lzD == null || mVar.lzD.contains(this.euW.field_username)) {
                    NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.dxf.Ow("contact_info_header_normal");
                    NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
                    if (normalUserHeaderPreference != null && normalUserFooterPreference != null && normalUserFooterPreference.hWZ) {
                        v.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                        this.hVS = true;
                        this.hVT = false;
                        normalUserHeaderPreference.aF(this.euW.field_username, true);
                        normalUserHeaderPreference.aG(this.euW.field_username, false);
                        normalUserHeaderPreference.gM(this.euW.field_username);
                        this.bij.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.hVS);
                        this.bij.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.hVT);
                    }
                }
            }
        } else if (i == 4 && i2 == -24 && !be.kS(str)) {
            Toast.makeText(this.bij, str, 1).show();
        }
    }
}
