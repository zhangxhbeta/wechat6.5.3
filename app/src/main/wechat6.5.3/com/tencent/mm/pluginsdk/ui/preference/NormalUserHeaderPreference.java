package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements b, a, d.a {
    MMActivity aWn;
    u euW;
    private boolean fyL = false;
    private ImageView hTO;
    private TextView hTR;
    private String hUb;
    private boolean hVP;
    private boolean hVW = false;
    private boolean hWY = false;
    private TextView hfz;
    private ImageView iRe;
    int iRy;
    public String lHr;
    public String lHs;
    private TextView lPN;
    private TextView lPO;
    private TextView lPP;
    private View lPQ;
    private Button lPR;
    private Button lPS;
    private TextView lPT;
    private ImageView lPU;
    private CheckBox lPV;
    private ImageView lPW;
    private ImageView lPX;
    private LinearLayout lPY;
    private Button lPZ;
    private FMessageListView lQa;
    private int lQb = 0;
    private boolean lQc = false;
    private boolean lQd = false;
    private boolean lQe = false;
    private boolean lQf = false;
    private boolean lQg = false;
    private boolean lQh = false;
    private boolean lQi = false;
    private boolean lQj = false;
    private String lQk;
    private ProfileMobilePhoneView lQl;
    private ProfileDescribeView lQm;
    private ProfileLabelView lQn;
    private TextView lQo;
    public OnClickListener lQp;
    public String lQq = null;

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        this.fyL = false;
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWn = (MMActivity) context;
        this.fyL = false;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        if (this.lQa != null) {
            this.lQa.detach();
        }
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        v.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.hfz = (TextView) view.findViewById(2131755445);
        this.hTR = (TextView) view.findViewById(2131756460);
        this.lPT = (TextView) view.findViewById(2131756469);
        this.lPN = (TextView) view.findViewById(2131756473);
        this.lPO = (TextView) view.findViewById(2131756470);
        this.lPR = (Button) view.findViewById(2131756471);
        this.lPS = (Button) view.findViewById(2131756472);
        this.lQl = (ProfileMobilePhoneView) view.findViewById(2131756477);
        ProfileMobilePhoneView profileMobilePhoneView = this.lQl;
        ak.yW();
        profileMobilePhoneView.lHB = ((Boolean) c.vf().get(t.a.nqG, Boolean.valueOf(false))).booleanValue();
        this.lQm = (ProfileDescribeView) view.findViewById(2131756478);
        this.lQn = (ProfileLabelView) view.findViewById(2131756479);
        this.lQo = (TextView) view.findViewById(2131756476);
        this.lQm.setOnClickListener(this.lQp);
        this.lQn.setOnClickListener(this.lQp);
        this.lQo.setOnClickListener(this.lQp);
        if (k.eo(this.euW.field_username) || (!be.kS(this.euW.field_username) && m.fg(this.euW.field_username))) {
            this.lQo.setVisibility(8);
            this.lQl.setVisibility(8);
            this.lQm.setVisibility(8);
            this.lQn.setVisibility(8);
        } else {
            ProfileMobilePhoneView profileMobilePhoneView2 = this.lQl;
            v.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[]{this.lHr, this.lHs});
            profileMobilePhoneView2.lHr = r2;
            profileMobilePhoneView2.lHs = r3;
            profileMobilePhoneView2.aGZ();
            if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                this.lQl.setVisibility(0);
            } else {
                this.lQl.setVisibility(8);
            }
            boolean H = this.lQm.H(this.euW);
            boolean H2 = this.lQn.H(this.euW);
            if (H || H2) {
                this.lQo.setVisibility(8);
            } else {
                if (this.lQi || this.lQg) {
                    this.lQo.setVisibility(8);
                } else {
                    this.lQo.setVisibility(0);
                }
                if (this.lQq != null && (this.lQq.equals("ContactWidgetBottleContact") || this.lQq.equals("ContactWidgetQContact"))) {
                    this.lQo.setVisibility(8);
                }
            }
        }
        this.lPP = (TextView) view.findViewById(2131756482);
        this.lPZ = (Button) view.findViewById(2131756474);
        this.lQa = (FMessageListView) view.findViewById(2131756480);
        a.a aVar = new a.a();
        aVar.bdo = this.euW.field_username;
        aVar.scene = this.iRy;
        aVar.hUb = this.hUb;
        aVar.type = 0;
        if (this.iRy == 18) {
            aVar.type = 1;
        } else if (aw.eM(this.iRy)) {
            aVar.type = 2;
        }
        this.lQa.lPk = aVar;
        a.lPk = aVar;
        this.lPQ = view.findViewById(2131756475);
        this.lPY = (LinearLayout) view.findViewById(2131756463);
        this.hTO = (ImageView) view.findViewById(2131755444);
        this.iRe = (ImageView) view.findViewById(2131756464);
        this.lPU = (ImageView) view.findViewById(2131756465);
        this.lPV = (CheckBox) view.findViewById(2131756468);
        this.lPW = (ImageView) view.findViewById(2131756467);
        this.lPX = (ImageView) view.findViewById(2131756466);
        this.fyL = true;
        NI();
        if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
            v.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.lQa.setVisibility(8);
            if (this.lQa.getVisibility() == 8 && this.lQo.getVisibility() == 8 && this.lQn.getVisibility() == 8 && this.lQm.getVisibility() == 8 && this.lPP.getVisibility() == 8) {
                this.lPQ.setVisibility(8);
            }
        } else if (this.hUb == null || this.hUb.length() == 0) {
            v.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.iRy + ", verifyTicket = " + this.hUb);
            this.lQa.setVisibility(8);
            if (this.lQa.getVisibility() == 8 && this.lQo.getVisibility() == 8 && this.lQn.getVisibility() == 8 && this.lQm.getVisibility() == 8 && this.lPP.getVisibility() == 8) {
                this.lPQ.setVisibility(8);
            }
        } else {
            b[] a;
            v.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.iRy);
            if (this.iRy == 18) {
                v.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = b.a(this.aWn, l.KE().kK(this.euW.field_username));
            } else if (aw.eM(this.iRy)) {
                v.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = b.a(this.aWn, l.KF().kP(this.euW.field_username));
            } else {
                v.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = b.a(this.aWn, l.KC().kF(this.euW.field_username));
            }
            if (a == null || a.length == 0) {
                v.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.lQa.setVisibility(8);
                if (this.lQa.getVisibility() == 8 && this.lQo.getVisibility() == 8 && this.lQn.getVisibility() == 8 && this.lQm.getVisibility() == 8 && this.lPP.getVisibility() == 8) {
                    this.lPQ.setVisibility(8);
                }
            } else {
                v.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (b bVar : a) {
                    if (bVar != null) {
                        v.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.cID + ", digest = " + bVar.cqK + ", addScene = " + bVar.iRy);
                    }
                }
                this.lQa.setVisibility(0);
                if (this.lQa.getVisibility() == 0 || this.lQo.getVisibility() == 0 || this.lQn.getVisibility() == 0 || this.lQm.getVisibility() == 0 || this.lPP.getVisibility() == 0) {
                    this.lPQ.setVisibility(0);
                }
                for (b a2 : a) {
                    this.lQa.a(a2);
                }
            }
        }
        super.onBindView(view);
    }

    private boolean aGC() {
        return this.fyL && this.euW != null;
    }

    private void aKp() {
        com.tencent.mm.pluginsdk.ui.a.b.m(this.hTO, this.euW.field_username);
        if (this.hTO != null) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bd.a.N(this.mContext, 2131492963), com.tencent.mm.bd.a.N(this.mContext, 2131492963));
            layoutParams.setMargins(0, 0, com.tencent.mm.bd.a.N(this.mContext, 2131493138), 0);
            this.hTO.setLayoutParams(layoutParams);
        }
    }

    private void NI() {
        int i = 0;
        if (!aGC()) {
            v.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.fyL + "contact = " + this.euW);
        } else if (this.hVW) {
            this.lPT.setVisibility(0);
            this.hfz.setText(e.a(this.aWn, be.ma(this.euW.tT()) + " ", this.hfz.getTextSize()));
            aKp();
            this.lPZ.setVisibility(8);
            this.hTR.setVisibility(8);
            this.lQa.setVisibility(8);
            if (this.lQa.getVisibility() == 8 && this.lQo.getVisibility() == 8 && this.lQn.getVisibility() == 8 && this.lQm.getVisibility() == 8 && this.lPP.getVisibility() == 8) {
                this.lPQ.setVisibility(8);
            }
            this.lPR.setVisibility(8);
            this.lPS.setVisibility(8);
            this.lPV.setVisibility(8);
            if (this.lQn != null) {
                this.lQn.setVisibility(8);
            }
            if (this.lQl != null) {
                this.lQl.setVisibility(8);
            }
            if (this.lQm != null) {
                this.lQm.setVisibility(8);
            }
            if (this.lQo != null) {
                this.lQo.setVisibility(8);
            }
            if (this.lPO != null) {
                this.lPO.setVisibility(8);
            }
        } else {
            boolean ew = u.ew(this.euW.field_username);
            if (ew) {
                this.hfz.setText("");
                if (u.LM(k.xF()).equals(this.euW.field_username)) {
                    this.lPZ.setVisibility(0);
                    this.lPZ.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ NormalUserHeaderPreference lQr;

                        {
                            this.lQr = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.ay.c.w(this.lQr.aWn, "bottle", ".ui.BottlePersonalInfoUI");
                        }
                    });
                }
            } else {
                this.hfz.setText(e.a(this.aWn, be.ma(this.euW.tT()) + " ", this.hfz.getTextSize()));
            }
            this.iRe.setVisibility(0);
            this.lQe = true;
            if (this.euW.bBZ == 1) {
                this.iRe.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165606));
                this.iRe.setContentDescription(this.mContext.getString(2131234254));
            } else if (this.euW.bBZ == 2) {
                this.iRe.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165605));
                this.iRe.setContentDescription(this.mContext.getString(2131234253));
            } else if (this.euW.bBZ == 0) {
                this.iRe.setVisibility(8);
                this.lQe = false;
            }
            if (this.euW.field_verifyFlag != 0) {
                Bitmap c;
                this.lPU.setVisibility(0);
                if (ab.a.csb != null) {
                    c = BackwardSupportUtil.b.c(ab.a.csb.eI(this.euW.field_verifyFlag), 2.0f);
                } else {
                    c = null;
                }
                this.lPU.setImageBitmap(c);
                this.lQb = c == null ? 0 : c.getWidth();
            }
            aKp();
            this.hTO.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NormalUserHeaderPreference lQr;

                {
                    this.lQr = r1;
                }

                public final void onClick(View view) {
                    String str = this.lQr.euW.field_username;
                    f fVar = new f(this.lQr.aWn, str);
                    if (u.ew(str)) {
                        u.LM(str);
                    }
                    fVar.boy();
                }
            });
            if (u.LJ(this.euW.field_username)) {
                this.hTR.setText(this.mContext.getString(2131231053) + this.euW.tV());
            } else if (u.LH(this.euW.field_username)) {
                this.hTR.setText(this.mContext.getString(2131231062) + this.euW.tV());
            } else if (this.hVP) {
                if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                    bqD();
                } else if (this.euW.bCm == null || this.euW.bCm.equals("")) {
                    this.hTR.setText(2131231035);
                } else {
                    this.hTR.setText(this.euW.bCm);
                }
            } else if (ew) {
                this.hTR.setText((be.ma(com.tencent.mm.model.l.eu(this.euW.getProvince())) + " " + be.ma(this.euW.getCity())).trim());
            } else {
                if (!u.LI(this.euW.field_username) && this.aWn.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (be.kS(this.euW.pD()) && (u.LL(this.euW.field_username) || m.eB(this.euW.field_username))) {
                        this.hTR.setVisibility(8);
                    } else if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                        bqD();
                    }
                }
                this.hTR.setVisibility(8);
            }
            if (m.fg(this.euW.field_username)) {
                this.lPP.setVisibility(0);
            } else {
                this.lPP.setVisibility(8);
            }
            bqF();
            bqE();
            bqG();
            if (be.kS(this.lQk)) {
                this.lPN.setVisibility(8);
            } else {
                if (!k.eo(this.euW.field_username) && be.ma(this.euW.field_conRemark).length() > 0) {
                    this.hTR.setVisibility(8);
                }
                this.lPN.setVisibility(0);
                this.lPN.setText(e.a(this.aWn, this.aWn.getString(2131232016) + this.lQk, this.lPN.getTextSize()));
            }
            this.lPR.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NormalUserHeaderPreference lQr;

                {
                    this.lQr = r1;
                }

                public final void onClick(View view) {
                    this.lQr.lQg = false;
                    NormalUserHeaderPreference normalUserHeaderPreference = this.lQr;
                    ak.yW();
                    u LX = c.wH().LX(normalUserHeaderPreference.euW.field_username);
                    if (!(LX == null || ((int) LX.chr) == 0 || !LX.field_username.equals(normalUserHeaderPreference.euW.field_username))) {
                        normalUserHeaderPreference.euW = LX;
                    }
                    if (com.tencent.mm.i.a.ei(normalUserHeaderPreference.euW.field_type)) {
                        Intent intent = new Intent();
                        intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
                        intent.putExtra("Contact_Scene", normalUserHeaderPreference.iRy);
                        intent.putExtra("Contact_User", normalUserHeaderPreference.euW.field_username);
                        intent.putExtra("Contact_RoomNickname", normalUserHeaderPreference.aWn.getIntent().getStringExtra("Contact_RoomNickname"));
                        ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
                        return;
                    }
                    intent = new Intent();
                    intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
                    intent.putExtra("Contact_Scene", normalUserHeaderPreference.iRy);
                    intent.putExtra("Contact_mode_name_type", 0);
                    intent.putExtra("Contact_ModStrangerRemark", true);
                    intent.putExtra("Contact_User", normalUserHeaderPreference.euW.field_username);
                    intent.putExtra("Contact_Nick", normalUserHeaderPreference.euW.field_nickname);
                    intent.putExtra("Contact_RemarkName", normalUserHeaderPreference.euW.field_conRemark);
                    ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
                }
            });
            this.lPS.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NormalUserHeaderPreference lQr;

                {
                    this.lQr = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", this.lQr.euW.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 3);
                    com.tencent.mm.ay.c.b(this.lQr.aWn, "sns", ".ui.SnsPermissionUI", intent);
                }
            });
            if (this.lQe) {
                i = com.tencent.mm.bd.a.fromDPToPix(this.aWn, 17) + 0;
            }
            int i2 = this.lQb + i;
            if (this.lQc) {
                i2 += com.tencent.mm.bd.a.fromDPToPix(this.aWn, 27);
            }
            if (this.lQd) {
                i2 += com.tencent.mm.bd.a.fromDPToPix(this.aWn, 27);
            }
            if (this.lQf) {
                i2 += com.tencent.mm.bd.a.fromDPToPix(this.aWn, 30);
            }
            if (com.tencent.mm.bd.a.dt(this.mContext)) {
                i2 += com.tencent.mm.bd.a.fromDPToPix(this.aWn, 88);
            } else {
                i2 += com.tencent.mm.bd.a.fromDPToPix(this.aWn, 64);
            }
            this.hfz.setMaxWidth(this.aWn.getResources().getDisplayMetrics().widthPixels - (i2 + com.tencent.mm.bd.a.fromDPToPix(this.aWn, 60)));
        }
    }

    private void bqD() {
        this.hTR.setVisibility(0);
        if (!be.kS(this.euW.pD())) {
            this.hTR.setText(this.mContext.getString(2131231058) + this.euW.pD());
        } else if (u.LL(this.euW.field_username) || m.eB(this.euW.field_username)) {
            this.hTR.setVisibility(8);
        } else {
            this.hTR.setText(this.mContext.getString(2131231058) + be.ma(this.euW.tV()));
        }
    }

    public final void aF(String str, boolean z) {
        if (str != null && str.equals(this.euW.field_username)) {
            this.lQg = z;
        }
    }

    public final void aG(String str, boolean z) {
        if (str != null && str.equals(this.euW.field_username)) {
            this.lQh = z;
        }
    }

    public final void a(u uVar, int i, String str) {
        boolean z;
        boolean z2 = true;
        onDetach();
        ak.yW();
        c.wH().a(this);
        ak.yW();
        c.wI().a(this);
        n.AX().d(this);
        this.euW = uVar;
        this.iRy = i;
        this.hUb = str;
        this.hVP = this.aWn.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.lQj = this.aWn.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.lQg = this.aWn.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.lQh = this.aWn.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.lQi = this.aWn.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.hWY = this.aWn.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.lQk = this.aWn.getIntent().getStringExtra("Contact_RoomNickname");
        if (uVar.field_deleteFlag == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hVW = z;
        String str2 = "initView: contact username is null";
        if (be.ma(uVar.field_username).length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        NI();
    }

    public final void onDetach() {
        if (this.lQa != null) {
            this.lQa.detach();
        }
        if (this.lQj) {
            l.KD().kA(this.euW.field_username);
        }
        this.aWn.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.lQg);
        this.aWn.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.lQh);
        ak.yW();
        c.wH().b(this);
        n.AX().e(this);
        ak.yW();
        c.wI().b(this);
    }

    private void bqE() {
        int i = 0;
        if (this.lPW != null && m.ev(this.euW.field_username)) {
            this.lQd = this.euW.tO();
            this.lPW.setVisibility(this.lQd ? 0 : 8);
        }
        if (this.lPX != null && m.ev(this.euW.field_username)) {
            boolean z;
            String str = this.euW.field_username;
            if (j.ak.lyh != null) {
                z = j.ak.lyh.z(str, 5);
            } else {
                z = false;
            }
            this.lQc = z;
            ImageView imageView = this.lPX;
            if (!this.lQc) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    private void bqF() {
        if (k.eo(this.euW.field_username) || be.ma(this.euW.field_conRemark).length() <= 0) {
            this.lPO.setVisibility(8);
            this.hfz.setText(e.a(this.aWn, be.ma(this.euW.tT()) + " ", this.hfz.getTextSize()));
            if (this.lQi) {
                this.lPR.setVisibility(0);
                this.lQo.setVisibility(8);
            } else if (this.lQg) {
                this.lPR.setVisibility(0);
                this.lQo.setVisibility(8);
            } else {
                if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                    this.lPR.setVisibility(8);
                }
                boolean H = this.lQm.H(this.euW);
                boolean H2 = this.lQn.H(this.euW);
                if (H || H2) {
                    this.lQo.setVisibility(8);
                }
            }
        } else {
            this.hfz.setText(e.a(this.aWn, be.ma(this.euW.field_conRemark) + " ", this.hfz.getTextSize()));
            this.lPO.setVisibility(0);
            this.lPO.setText(e.a(this.aWn, this.mContext.getString(2131232101) + this.euW.tT(), this.lPO.getTextSize()));
            this.lPR.setVisibility(8);
        }
        if (this.hWY && !com.tencent.mm.i.a.ei(this.euW.field_type)) {
            this.lPS.setVisibility(0);
        } else if (this.lQh) {
            this.lPS.setVisibility(0);
            if (com.tencent.mm.bd.a.dt(this.aWn)) {
                this.lPS.setTextSize(0, (float) this.aWn.getResources().getDimensionPixelSize(2131493128));
                this.lPR.setTextSize(0, (float) this.aWn.getResources().getDimensionPixelSize(2131493128));
            }
        } else {
            this.lPS.setVisibility(8);
        }
        if (u.ew(this.euW.field_username)) {
            this.hfz.setText("");
        }
        if (this.iRy == 76 && this.euW.field_username != null && this.euW.field_username.endsWith("@stranger")) {
            this.hfz.setText(e.a(this.aWn, be.ma(this.euW.field_nickname) + " ", this.hfz.getTextSize()));
        }
        if (this.lPS.getVisibility() == 0 && this.lPO.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPO.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131493199);
            this.lPO.setLayoutParams(layoutParams);
        }
    }

    private void bqG() {
        this.lPV.setClickable(false);
        if (m.ev(this.euW.field_username) && com.tencent.mm.i.a.ei(this.euW.field_type) && !k.eo(this.euW.field_username)) {
            this.lPV.setVisibility(0);
            if (this.euW.tL()) {
                this.lPV.setChecked(true);
                this.lQf = true;
                return;
            }
            this.lPV.setChecked(false);
            this.lPV.setVisibility(8);
            this.lQf = false;
            return;
        }
        this.lQf = false;
        this.lPV.setVisibility(8);
    }

    public final void gM(String str) {
        if (!aGC()) {
            v.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.fyL + "contact = " + this.euW);
        } else if (be.ma(str).length() <= 0) {
            v.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = " + str);
        } else if (str.equals(this.euW.field_username)) {
            NI();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        v.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
        if (obj == null || !(obj instanceof String)) {
            v.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
            return;
        }
        String str = (String) obj;
        v.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.euW);
        if (!aGC()) {
            v.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.fyL + "contact = " + this.euW);
        } else if (be.ma(str).length() > 0 && this.euW != null && this.euW.field_username.equals(str)) {
            ak.yW();
            this.euW = c.wH().LX(str);
            ad.o(new Runnable(this) {
                final /* synthetic */ NormalUserHeaderPreference lQr;

                {
                    this.lQr = r1;
                }

                public final void run() {
                    int i = 0;
                    this.lQr.bqF();
                    this.lQr.bqG();
                    this.lQr.bqE();
                    if (this.lQr.lQa != null) {
                        boolean z;
                        FMessageListView g = this.lQr.lQa;
                        if (com.tencent.mm.i.a.ei(this.lQr.euW.field_type)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int childCount = g.getChildCount();
                        v.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
                        if (childCount <= 2) {
                            v.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = " + childCount);
                            return;
                        }
                        if (g.lPt != null) {
                            g.lPt.setVisibility(z ? 0 : 8);
                        }
                        if (g.lPu != null) {
                            a aVar = g.lPu;
                            if (!z) {
                                i = 8;
                            }
                            aVar.setVisibility(i);
                        }
                    }
                }
            });
        }
    }

    public final void a(final ba baVar) {
        ad.o(new Runnable(this) {
            final /* synthetic */ NormalUserHeaderPreference lQr;

            public final void run() {
                if (this.lQr.euW != null && baVar != null && this.lQr.euW.field_username.equals(baVar.field_encryptUsername)) {
                    this.lQr.euW.bQ(baVar.field_conRemark);
                    if (this.lQr.aGC()) {
                        this.lQr.bqF();
                    } else {
                        v.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lQr.fyL + "contact = " + this.lQr.euW.field_username);
                    }
                }
            }
        });
    }
}
