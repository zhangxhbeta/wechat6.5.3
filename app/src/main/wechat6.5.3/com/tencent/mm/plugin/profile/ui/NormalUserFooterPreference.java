package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.k;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import java.util.LinkedList;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements com.tencent.mm.sdk.h.g.a {
    private MMActivity aWn;
    private String biB;
    protected com.tencent.mm.sdk.h.h<e, String> cye = new com.tencent.mm.sdk.h.h<e, String>(this) {
        final /* synthetic */ NormalUserFooterPreference hXa;

        {
            this.hXa = r1;
        }

        public final /* synthetic */ void a(Object obj, Looper looper) {
            e eVar = (e) obj;
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            super.a(eVar, looper);
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            e eVar = (e) obj;
            String str = (String) obj2;
            if (str.equals("show_btn")) {
                eVar.aa(this.hXa.euW.field_username, true);
            } else if (str.equals("hide_btn")) {
                eVar.aa(this.hXa.euW.field_username, false);
            }
        }
    };
    public ProgressDialog dwR = null;
    private String enX = null;
    private u euW;
    private boolean fyL;
    private boolean hTY;
    private int hUa;
    private String hUb = "";
    private int hVI;
    private String hVQ = "";
    private boolean hVW = false;
    private int hVl = 0;
    private boolean hWE = false;
    private boolean hWF;
    private boolean hWG;
    private boolean hWH = false;
    private boolean hWI = false;
    private a hWJ;
    private View hWK;
    private Button hWL;
    private Button hWM;
    private Button hWN;
    private View hWO;
    private Button hWP;
    private View hWQ;
    private Button hWR;
    private Button hWS;
    private Button hWT;
    private Button hWU;
    private Button hWV;
    private Button hWW;
    private TextView hWX;
    private boolean hWY = false;
    public boolean hWZ = false;
    private long hWq = 0;
    private Button hhL;

    abstract class a implements com.tencent.mm.v.e {
        boolean eut = false;
        final /* synthetic */ NormalUserFooterPreference hXa;
        private l hXb = null;

        protected abstract void aGR();

        static /* synthetic */ void a(a aVar) {
            aVar.hXa.hWX.setVisibility(8);
            m.g(aVar.hXa.euW);
            aVar.hXa.euW.ts();
            aVar.aGR();
        }

        static /* synthetic */ void b(a aVar) {
            aVar.hXa.hWX.setVisibility(0);
            m.f(aVar.hXa.euW);
            aVar.hXa.euW.tr();
            aVar.aGR();
        }

        static /* synthetic */ void c(a aVar) {
            int i = 7;
            Intent intent = new Intent();
            switch (aVar.hXa.hUa) {
                case 1:
                case 2:
                case 3:
                case 12:
                case as.CTRL_INDEX /*13*/:
                case 58:
                case 59:
                case EncrptType.VERIFY_CODE /*60*/:
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.ar.a.w(45, aVar.hXa.euW.field_username));
                    i = 45;
                    break;
                case 9:
                case an.CTRL_INDEX /*14*/:
                    i = 35;
                    break;
                case 18:
                    i = aVar.hXa.hWE ? 2 : 1;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.ar.a.kx(aVar.hXa.euW.field_username));
                    break;
                case bf.CTRL_INDEX /*22*/:
                case 23:
                case 24:
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                case bv.CTRL_INDEX /*27*/:
                case p.CTRL_INDEX /*28*/:
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    i = aVar.hXa.hWE ? 4 : 3;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.ar.a.ky(aVar.hXa.euW.field_username));
                    break;
                case 25:
                    i = aVar.hXa.hWE ? 6 : 5;
                    if (!aVar.hXa.hWE) {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.ar.a.kz(!be.kS(aVar.hXa.euW.nul) ? aVar.hXa.euW.nul : aVar.hXa.euW.field_username));
                        break;
                    } else {
                        intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.ar.a.w(i, aVar.hXa.euW.field_username));
                        break;
                    }
                case 30:
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.ar.a.w(7, aVar.hXa.euW.field_username));
                    break;
                default:
                    i = 999;
                    break;
            }
            intent.putExtra("k_username", aVar.hXa.euW.field_username);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            com.tencent.mm.ay.c.b(aVar.hXa.aWn, "webview", ".ui.tools.WebViewUI", intent);
        }

        public a(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
        }

        protected void ws() {
            aGR();
            aGT();
            this.hXa.hhL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final void onClick(View view) {
                    a aVar;
                    if (this.hXc.hXa.hWG) {
                        aVar = this.hXc;
                        String str = aVar.hXa.euW.field_username;
                        Intent intent = new Intent();
                        intent.addFlags(67108864);
                        if (aVar.hXa.hTY) {
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("Chat_Mode", 1);
                            ((Activity) aVar.hXa.mContext).setResult(-1, intent);
                            return;
                        }
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("Chat_Mode", 1);
                        com.tencent.mm.plugin.profile.a.drp.e(intent, aVar.hXa.mContext);
                        return;
                    }
                    aVar = this.hXc;
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    if (aVar.hXa.hTY) {
                        intent2.putExtra("Chat_User", aVar.hXa.euW.field_username);
                        intent2.putExtra("Chat_Mode", 1);
                        ((Activity) aVar.hXa.mContext).setResult(-1, intent2);
                        return;
                    }
                    intent2.putExtra("Chat_User", aVar.hXa.euW.field_username);
                    intent2.putExtra("Chat_Mode", 1);
                    com.tencent.mm.plugin.profile.a.drp.e(intent2, aVar.hXa.mContext);
                }
            });
            this.hXa.hWW.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", this.hXc.hXa.euW.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 4);
                    com.tencent.mm.ay.c.b(this.hXc.hXa.aWn, "sns", ".ui.SnsPermissionUI", intent);
                }
            });
            this.hXa.hWU.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final void onClick(View view) {
                    a aVar = this.hXc;
                    qh qhVar = new qh();
                    com.tencent.mm.sdk.c.a.nhr.z(qhVar);
                    if (!aVar.hXa.euW.field_username.equals(qhVar.bry.bdo) && (qhVar.bry.brA || qhVar.bry.brB)) {
                        Toast.makeText(aVar.hXa.aWn.nDR.nEl, qhVar.bry.brz ? 2131231572 : 2131231573, 0).show();
                        v.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
                    } else if (!com.tencent.mm.ah.a.aT(aVar.hXa.aWn)) {
                        pd pdVar = new pd();
                        pdVar.bqt.bqv = true;
                        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                        String str = pdVar.bqu.bqx;
                        if (be.kS(str)) {
                            aVar.aGU();
                            return;
                        }
                        v.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: " + str);
                        com.tencent.mm.ui.base.g.b(aVar.hXa.aWn, aVar.hXa.aWn.getString(2131235616), "", aVar.hXa.aWn.getString(2131231107), aVar.hXa.aWn.getString(2131231010), new DialogInterface.OnClickListener(aVar) {
                            final /* synthetic */ a hXc;

                            {
                                this.hXc = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                pd pdVar = new pd();
                                pdVar.bqt.bqw = true;
                                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                                this.hXc.aGU();
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener(aVar) {
                            final /* synthetic */ a hXc;

                            {
                                this.hXc = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                }
            });
            this.hXa.hWP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final void onClick(View view) {
                    a.c(this.hXc);
                }
            });
            this.hXa.hWR.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final void onClick(View view) {
                    a.c(this.hXc);
                }
            });
            this.hXa.hWV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final void onClick(View view) {
                    a.c(this.hXc);
                }
            });
        }

        protected void onDetach() {
        }

        public void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        }

        protected final void aGS() {
            this.hXa.aWn.a(0, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ a hXc;

                {
                    this.hXc = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.hXc.hXa.aWn, com.tencent.mm.ui.widget.f.pbS, false);
                    fVar.jXo = new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ AnonymousClass1 hXd;

                        {
                            this.hXd = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            com.tencent.mm.modelfriend.b bVar = null;
                            NormalUserFooterPreference normalUserFooterPreference;
                            Intent intent;
                            a aVar;
                            View inflate;
                            TextView textView;
                            final CheckBox checkBox;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    this.hXd.hXc.hXa.cye.bg("hide_btn");
                                    this.hXd.hXc.hXa.cye.Ls();
                                    a aVar2 = this.hXd.hXc;
                                    normalUserFooterPreference = aVar2.hXa;
                                    ak.yW();
                                    normalUserFooterPreference.euW = com.tencent.mm.model.c.wH().LX(aVar2.hXa.euW.field_username);
                                    if (com.tencent.mm.i.a.ei(aVar2.hXa.euW.field_type)) {
                                        intent = new Intent();
                                        intent.putExtra("Contact_Scene", aVar2.hXa.hUa);
                                        intent.putExtra("Contact_User", aVar2.hXa.euW.field_username);
                                        intent.putExtra("Contact_RoomNickname", aVar2.hXa.aWn.getIntent().getStringExtra("Contact_RoomNickname"));
                                        intent.putExtra("contact_phone_number_list", aVar2.hXa.euW.bCz);
                                        String str = "";
                                        if (!aVar2.hXa.euW.tQ()) {
                                            String stringExtra = aVar2.hXa.aWn.getIntent().getStringExtra("Contact_Mobile_MD5");
                                            String stringExtra2 = aVar2.hXa.aWn.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                                            if (be.kS(stringExtra) && be.kS(stringExtra2)) {
                                                if (!be.kS(aVar2.hXa.euW.field_username)) {
                                                    bVar = ah.FL().iA(aVar2.hXa.euW.field_username);
                                                }
                                            } else if (!(be.kS(stringExtra) && be.kS(stringExtra2))) {
                                                bVar = ah.FL().iB(stringExtra);
                                                if (bVar == null || be.kS(bVar.EB())) {
                                                    bVar = ah.FL().iB(stringExtra2);
                                                }
                                            }
                                            if (!(bVar == null || be.kS(bVar.EB()))) {
                                                str = be.ma(bVar.EJ()).replace(" ", "");
                                            }
                                        }
                                        intent.putExtra("contact_phone_number_by_md5", str);
                                        com.tencent.mm.plugin.profile.a.drp.q(intent, aVar2.hXa.mContext);
                                        return;
                                    }
                                    aVar2.xS(aVar2.hXa.euW.field_username);
                                    return;
                                case 2:
                                    if (this.hXd.hXc.hXa.euW.tL()) {
                                        m.k(this.hXd.hXc.hXa.euW);
                                        com.tencent.mm.ui.base.g.bf(this.hXd.hXc.hXa.aWn, this.hXd.hXc.hXa.aWn.getString(2131232198));
                                    } else {
                                        m.j(this.hXd.hXc.hXa.euW);
                                        com.tencent.mm.ui.base.g.bf(this.hXd.hXc.hXa.aWn, this.hXd.hXc.hXa.aWn.getString(2131232038));
                                    }
                                    normalUserFooterPreference = this.hXd.hXc.hXa;
                                    ak.yW();
                                    normalUserFooterPreference.euW = com.tencent.mm.model.c.wH().LX(this.hXd.hXc.hXa.euW.field_username);
                                    return;
                                case 3:
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("sns_permission_userName", this.hXd.hXc.hXa.euW.field_username);
                                    intent2.putExtra("sns_permission_anim", true);
                                    intent2.putExtra("sns_permission_block_scene", 1);
                                    com.tencent.mm.ay.c.b(this.hXd.hXc.hXa.aWn, "sns", ".ui.SnsPermissionUI", intent2);
                                    return;
                                case 4:
                                    aVar = this.hXd.hXc;
                                    intent = new Intent();
                                    intent.putExtra("Select_Talker_Name", aVar.hXa.euW.field_username);
                                    intent.putExtra("Select_block_List", aVar.hXa.euW.field_username);
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("Select_Send_Card", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.profile.a.drp.a(intent, aVar.hXa.aWn);
                                    return;
                                case 5:
                                    if (this.hXd.hXc.hXa.euW.tK()) {
                                        a.a(this.hXd.hXc);
                                        return;
                                    }
                                    inflate = View.inflate(this.hXd.hXc.hXa.mContext, 2130903966, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(2131758197);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(2131232097);
                                    checkBox = (CheckBox) inflate.findViewById(2131758198);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(2131758199);
                                    textView.setText(2131232098);
                                    if (this.hXd.hXc.hXa.euW.bbT == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.g.a(this.hXd.hXc.hXa.mContext, true, this.hXd.hXc.hXa.mContext.getString(2131232096), inflate, this.hXd.hXc.hXa.mContext.getString(2131231107), this.hXd.hXc.hXa.mContext.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass1 hXf;

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            a.b(this.hXf.hXd.hXc);
                                            if (this.hXf.hXd.hXc.hXa.euW.bbT == 18) {
                                                this.hXf.hXd.hXc.hXa.hUa = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(this.hXf.hXd.hXc);
                                                }
                                            }
                                        }
                                    }, null);
                                    return;
                                case 6:
                                    CharSequence string;
                                    inflate = View.inflate(this.hXd.hXc.hXa.mContext, 2130903966, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(2131758197);
                                    textView.setPadding(0, 0, 0, 0);
                                    if (m.eA(this.hXd.hXc.hXa.euW.field_username)) {
                                        string = this.hXd.hXc.hXa.mContext.getString(2131232272, new Object[]{this.hXd.hXc.hXa.euW.tU()});
                                    } else {
                                        string = this.hXd.hXc.hXa.mContext.getString(2131232271, new Object[]{this.hXd.hXc.hXa.euW.tU()});
                                    }
                                    textView.setText(string);
                                    checkBox = (CheckBox) inflate.findViewById(2131758198);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(2131758199);
                                    textView.setText(2131232098);
                                    if (this.hXd.hXc.hXa.euW.bbT == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.g.a(this.hXd.hXc.hXa.mContext, true, this.hXd.hXc.hXa.mContext.getString(2131232022), inflate, this.hXd.hXc.hXa.mContext.getString(2131231020), this.hXd.hXc.hXa.mContext.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass1 hXf;

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.hXf.hXd.hXc.aGV();
                                            if (this.hXf.hXd.hXc.hXa.euW.bbT == 18) {
                                                this.hXf.hXd.hXc.hXa.hUa = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(this.hXf.hXd.hXc);
                                                }
                                            }
                                        }
                                    }, null, 2131689512);
                                    return;
                                case 7:
                                    aVar = this.hXd.hXc;
                                    v.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + aVar.hXa.euW.field_username);
                                    com.tencent.mm.plugin.base.a.c.I(aVar.hXa.aWn, aVar.hXa.euW.field_username);
                                    ad.g(new Runnable(aVar) {
                                        final /* synthetic */ a hXc;

                                        {
                                            this.hXc = r1;
                                        }

                                        public final void run() {
                                            com.tencent.mm.plugin.base.a.c.H(this.hXc.hXa.aWn, this.hXc.hXa.euW.field_username);
                                        }
                                    }, 1000);
                                    com.tencent.mm.ui.base.g.bf(aVar.hXa.aWn, aVar.hXa.aWn.getString(2131230902));
                                    return;
                                case 9:
                                    a.c(this.hXd.hXc);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.jXn = new com.tencent.mm.ui.base.n.c(this) {
                        final /* synthetic */ AnonymousClass1 hXd;

                        {
                            this.hXd = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            CharSequence string;
                            lVar.S(1, 2131232091, 2131165341);
                            if (this.hXd.hXc.hXa.euW.tL()) {
                                string = this.hXd.hXc.hXa.aWn.getResources().getString(2131232197);
                            } else {
                                string = this.hXd.hXc.hXa.aWn.getResources().getString(2131232037);
                            }
                            lVar.a(2, string, 2131165343);
                            if (com.tencent.mm.ay.c.EH("sns") && (com.tencent.mm.model.k.xQ() & 32768) == 0) {
                                lVar.S(3, 2131232104, 2131165334);
                            }
                            lVar.S(4, 2131232156, 2131165344);
                            lVar.S(9, 2131231490, 2131165317);
                            if (this.hXd.hXc.hXa.euW.tK()) {
                                string = this.hXd.hXc.hXa.aWn.getString(2131232100);
                            } else {
                                string = this.hXd.hXc.hXa.aWn.getString(2131232096);
                            }
                            lVar.a(5, string, 2131165314);
                            if (!this.hXd.hXc.hXa.hWI) {
                                lVar.S(6, 2131231397, 2131165320);
                            }
                            lVar.S(7, 2131231995, 2131165321);
                        }
                    };
                    fVar.bKh();
                    return true;
                }
            });
        }

        protected final void m(final boolean z, final boolean z2) {
            if (!z || !z2) {
                this.hXa.aWn.a(0, 2130838681, new OnMenuItemClickListener(this) {
                    final /* synthetic */ a hXc;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.hXc.hXa.aWn, com.tencent.mm.ui.widget.f.pbS, false);
                        fVar.jXo = new com.tencent.mm.ui.base.n.d(this) {
                            final /* synthetic */ AnonymousClass9 hXi;

                            {
                                this.hXi = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        this.hXi.hXc.xS(this.hXi.hXc.hXa.euW.field_username);
                                        return;
                                    case 5:
                                        com.tencent.mm.ui.base.g.a(this.hXi.hXc.hXa.mContext, this.hXi.hXc.hXa.mContext.getString(2131232097), this.hXi.hXc.hXa.mContext.getString(2131232096), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 hXj;

                                            {
                                                this.hXj = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                a.b(this.hXj.hXi.hXc);
                                            }
                                        }, null);
                                        return;
                                    case 8:
                                        a.a(this.hXi.hXc);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        fVar.jXn = new com.tencent.mm.ui.base.n.c(this) {
                            final /* synthetic */ AnonymousClass9 hXi;

                            {
                                this.hXi = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                if (!z) {
                                    lVar.S(1, 2131232091, 2131165341);
                                }
                                if (!z2) {
                                    if (this.hXi.hXc.hXa.euW.tK()) {
                                        lVar.S(8, 2131232100, 2131165314);
                                    } else if (!m.eB(this.hXi.hXc.hXa.euW.field_username)) {
                                        lVar.S(5, 2131232096, 2131165314);
                                    }
                                }
                            }
                        };
                        fVar.bKh();
                        return true;
                    }
                });
            }
        }

        protected void aGT() {
            if (this.hXa.hVW) {
                this.hXa.aWn.iU(false);
            } else if (!com.tencent.mm.model.k.xF().equals(this.hXa.euW.field_username)) {
                if (!com.tencent.mm.i.a.ei(this.hXa.euW.field_type)) {
                    m(false, false);
                } else if (!m.fg(this.hXa.euW.field_username)) {
                    aGS();
                }
            }
        }

        final void aGU() {
            if (this.hXb == null) {
                this.hXb = new l(this.hXa.mContext);
                this.hXb.jXn = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ a hXc;

                    {
                        this.hXc = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.dg(2, 2131231059);
                        lVar.dg(1, 2131231061);
                    }
                };
                this.hXb.jXo = new com.tencent.mm.ui.base.n.d(this) {
                    final /* synthetic */ a hXc;

                    {
                        this.hXc = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                this.hXc.hXa.aGP();
                                return;
                            case 2:
                                this.hXc.hXa.aGQ();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            this.hXb.aXZ();
        }

        final void xS(String str) {
            if (be.kS(str)) {
                v.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", this.hXa.hUa);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", this.hXa.euW.field_username);
            intent.putExtra("Contact_Nick", this.hXa.euW.field_nickname);
            intent.putExtra("Contact_RemarkName", this.hXa.euW.field_conRemark);
            com.tencent.mm.plugin.profile.a.drp.r(intent, this.hXa.mContext);
        }

        protected final void aGV() {
            com.tencent.mm.modelfriend.h hVar = null;
            String str = this.hXa.euW.field_username;
            this.hXa.euW.tq();
            ak.yW();
            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.c(str));
            if (!m.eA(str)) {
                this.eut = false;
                Context context = this.hXa.mContext;
                this.hXa.mContext.getString(2131231164);
                final com.tencent.mm.ui.base.p a = com.tencent.mm.ui.base.g.a(context, this.hXa.mContext.getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ a hXc;

                    {
                        this.hXc = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.hXc.eut = true;
                    }
                });
                aw.a(str, new com.tencent.mm.model.aw.a(this) {
                    final /* synthetic */ a hXc;

                    public final boolean zp() {
                        return this.hXc.eut;
                    }

                    public final void zo() {
                        if (a != null) {
                            a.dismiss();
                        }
                    }
                });
                ak.yW();
                com.tencent.mm.model.c.wH().a(str, this.hXa.euW);
                ak.yW();
                com.tencent.mm.model.c.wK().Mf(str);
                switch (this.hXa.hUa) {
                    case 10:
                        com.tencent.mm.modelsimple.d.A(this.hXa.mContext, str);
                        break;
                    case 12:
                        af iM = ah.FQ().iM(str);
                        if (iM != null) {
                            iM.cIB = 1;
                            ah.FQ().a(iM.cIA, iM);
                            break;
                        }
                        break;
                    case as.CTRL_INDEX /*13*/:
                        com.tencent.mm.modelfriend.b iA = ah.FL().iA(str);
                        if (!(iA == null || be.kS(iA.cHb))) {
                            iA.status = 1;
                            ah.FL().a(iA.EB(), iA);
                        }
                        com.tencent.mm.modelsimple.d.A(this.hXa.mContext, str);
                        break;
                    case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                        com.tencent.mm.modelfriend.i FM = ah.FM();
                        Cursor rawQuery = FM.cuX.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                hVar = new com.tencent.mm.modelfriend.h();
                                hVar.b(rawQuery);
                            }
                            rawQuery.close();
                        }
                        if (hVar != null) {
                            hVar.status = 100;
                            ah.FM().a(hVar);
                            break;
                        }
                        break;
                    case 58:
                    case 59:
                    case EncrptType.VERIFY_CODE /*60*/:
                        ah.FT().u(str, 2);
                        break;
                }
                if (this.hXa.hUa == 9) {
                    v.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + this.hXa.euW.bbT);
                    switch (this.hXa.euW.bbT) {
                        case 10:
                        case as.CTRL_INDEX /*13*/:
                            v.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                            com.tencent.mm.modelsimple.d.A(this.hXa.mContext, str);
                            break;
                        default:
                            break;
                    }
                }
            }
            ak.yW();
            com.tencent.mm.model.c.wH().Mc(str);
            ak.yW().wO().LG(str);
            if (this.hXa.hVI == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.profile.a.drp.t(intent, this.hXa.mContext);
                return;
            }
            this.hXa.aWn.setResult(-1, this.hXa.aWn.getIntent().putExtra("_delete_ok_", true));
            ((Activity) this.hXa.mContext).finish();
        }
    }

    public interface e {
        void aa(String str, boolean z);
    }

    class c extends a {
        final /* synthetic */ NormalUserFooterPreference hXa;

        static /* synthetic */ void a(c cVar) {
            int i = 0;
            if (((int) cVar.hXa.euW.chr) == 0) {
                ak.yW();
                com.tencent.mm.model.c.wH().O(cVar.hXa.euW);
                ak.yW();
                com.tencent.mm.model.c.wH().LX(cVar.hXa.euW.field_username);
            }
            if (((int) cVar.hXa.euW.chr) <= 0) {
                v.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
                return;
            }
            if (!com.tencent.mm.i.a.ei(cVar.hXa.euW.field_type) && cVar.hXa.hUa == 15) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                Object[] objArr = new Object[4];
                objArr[0] = cVar.hXa.euW.field_username;
                objArr[1] = Integer.valueOf(3);
                if (!be.kS(ah.FL().iA(cVar.hXa.euW.field_username).EB())) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(cVar.hXa.euW.bCz.toString().split(",").length >= 5 ? 5 : cVar.hXa.euW.bCz.toString().split(",").length);
                gVar.h(12040, objArr);
            }
            m.n(cVar.hXa.euW);
            NormalUserFooterPreference normalUserFooterPreference = cVar.hXa;
            ak.yW();
            normalUserFooterPreference.euW = com.tencent.mm.model.c.wH().LX(cVar.hXa.euW.field_username);
            cVar.aGR();
        }

        public c(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void ws() {
            super.ws();
        }

        protected void onDetach() {
            super.onDetach();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void aGR() {
            /*
            r7 = this;
            r1 = 1;
            r2 = 0;
            r6 = 8;
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.field_username;
            r0 = com.tencent.mm.model.m.fn(r0);
            if (r0 != 0) goto L_0x0083;
        L_0x0012:
            r0 = r1;
        L_0x0013:
            junit.framework.Assert.assertTrue(r0);
            r0 = r7.hXa;
            r0 = r0.hWK;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hWQ;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hVW;
            if (r0 == 0) goto L_0x008f;
        L_0x0030:
            r0 = r7.hXa;
            r0 = r0.hWM;
            r1 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$c$1;
            r1.<init>(r7);
            r0.setOnClickListener(r1);
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.field_type;
            r0 = com.tencent.mm.i.a.ei(r0);
            if (r0 == 0) goto L_0x0085;
        L_0x004c:
            r0 = r7.hXa;
            r0 = r0.hWM;
            r0.setVisibility(r2);
        L_0x0055:
            r0 = r7.hXa;
            r0 = r0.hWT;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hhL;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hWW;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hWU;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hWX;
            r0.setVisibility(r6);
        L_0x0082:
            return;
        L_0x0083:
            r0 = r2;
            goto L_0x0013;
        L_0x0085:
            r0 = r7.hXa;
            r0 = r0.hWM;
            r0.setVisibility(r6);
            goto L_0x0055;
        L_0x008f:
            r0 = r7.hXa;
            r0 = r0.hWT;
            r3 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$c$2;
            r3.<init>(r7);
            r0.setOnClickListener(r3);
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.field_type;
            r0 = com.tencent.mm.i.a.ei(r0);
            if (r0 != 0) goto L_0x00e5;
        L_0x00ab:
            r0 = r7.hXa;
            r0 = r0.hWT;
            r0.setVisibility(r2);
            r0 = r7.hXa;
            r0 = r0.hhL;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hWW;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hWU;
            r0.setVisibility(r6);
        L_0x00cf:
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.tK();
            if (r0 == 0) goto L_0x01bc;
        L_0x00db:
            r0 = r7.hXa;
            r0 = r0.hWX;
            r0.setVisibility(r2);
            goto L_0x0082;
        L_0x00e5:
            r0 = r7.hXa;
            r0 = r0.hWT;
            r0.setVisibility(r6);
            r0 = r7.hXa;
            r0 = r0.hhL;
            r0.setVisibility(r2);
            r0 = r7.hXa;
            r0 = r0.aGO();
            if (r0 != 0) goto L_0x0166;
        L_0x00ff:
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.field_username;
            r3 = com.tencent.mm.model.k.xF();
            r0 = r0.equals(r3);
            if (r0 != 0) goto L_0x0166;
        L_0x0111:
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.field_username;
            r0 = com.tencent.mm.model.m.fn(r0);
            if (r0 != 0) goto L_0x0166;
        L_0x011f:
            r0 = r7.hXa;
            r0 = r0.euW;
            r0 = r0.field_username;
            r0 = com.tencent.mm.model.m.fg(r0);
            if (r0 != 0) goto L_0x0166;
        L_0x012d:
            r0 = r7.hXa;
            r0 = r0.hWU;
            r0.setVisibility(r2);
        L_0x0136:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.wH();
            r3 = r7.hXa;
            r3 = r3.euW;
            r3 = r3.field_username;
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r3);
            if (r4 == 0) goto L_0x0170;
        L_0x014b:
            r1 = r2;
        L_0x014c:
            if (r1 == 0) goto L_0x00cf;
        L_0x014e:
            r0 = r7.hXa;
            r0 = r0.hWV;
            r0.setVisibility(r2);
            r0 = r7.hXa;
            r1 = r7.hXa;
            r1 = r1.euW;
            r1 = r1.bbT;
            r0.hUa = r1;
            goto L_0x00cf;
        L_0x0166:
            r0 = r7.hXa;
            r0 = r0.hWU;
            r0.setVisibility(r6);
            goto L_0x0136;
        L_0x0170:
            r4 = new java.lang.StringBuilder;
            r5 = "select count(*) from ";
            r4.<init>(r5);
            r5 = com.tencent.mm.storage.aa.LR(r3);
            r4 = r4.append(r5);
            r5 = " where type & ";
            r4 = r4.append(r5);
            r5 = com.tencent.mm.i.a.tF();
            r4 = r4.append(r5);
            r5 = " !=0 and username=";
            r4 = r4.append(r5);
            r3 = com.tencent.mm.bg.g.dM(r3);
            r3 = r4.append(r3);
            r3 = r3.toString();
            r0 = r0.cie;
            r4 = 0;
            r0 = r0.rawQuery(r3, r4);
            r3 = r0.getCount();
            if (r3 <= 0) goto L_0x01c7;
        L_0x01af:
            r0.moveToFirst();
            r3 = r0.getInt(r2);
            if (r3 <= 0) goto L_0x01c7;
        L_0x01b8:
            r0.close();
            goto L_0x014c;
        L_0x01bc:
            r0 = r7.hXa;
            r0 = r0.hWX;
            r0.setVisibility(r6);
            goto L_0x0082;
        L_0x01c7:
            r1 = r2;
            goto L_0x01b8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.aGR():void");
        }

        protected final void aGW() {
            if (((int) this.hXa.euW.chr) == 0) {
                ak.yW();
                if (com.tencent.mm.model.c.wH().O(this.hXa.euW) != -1) {
                    NormalUserFooterPreference normalUserFooterPreference = this.hXa;
                    ak.yW();
                    normalUserFooterPreference.euW = com.tencent.mm.model.c.wH().LX(this.hXa.euW.field_username);
                }
            }
            if (this.hXa.hWF || this.hXa.hUa == 12) {
                v.d("MicroMsg.NormalUserFooterPreference", "qqNum " + this.hXa.hWq + " qqReamrk " + this.hXa.hVQ);
                if (!(this.hXa.hWq == 0 || this.hXa.hVQ == null || this.hXa.hVQ.equals(""))) {
                    af ae = ah.FQ().ae(this.hXa.hWq);
                    if (ae == null) {
                        ae = new af();
                        ae.cID = "";
                        ae.cIA = this.hXa.hWq;
                        ae.cIJ = this.hXa.hVQ;
                        ae.username = this.hXa.euW.field_username;
                        ae.FJ();
                        ah.FQ().a(ae);
                    } else {
                        ae.cIA = this.hXa.hWq;
                        ae.cIJ = this.hXa.hVQ;
                        ae.username = this.hXa.euW.field_username;
                        ae.FJ();
                        ah.FQ().a(this.hXa.hWq, ae);
                    }
                }
            } else if (this.hXa.hUa == 58 || this.hXa.hUa == 59 || this.hXa.hUa == 60) {
                ah.FT().u(this.hXa.euW.field_username, 1);
            }
            String stringExtra = this.hXa.aWn.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.hXa.aWn.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String ma = be.ma(stringExtra);
            stringExtra2 = be.ma(stringExtra2);
            if (!(ma.equals("") && stringExtra2.equals(""))) {
                com.tencent.mm.modelfriend.b iB = ah.FL().iB(ma);
                if (iB == null) {
                    iB = ah.FL().iB(stringExtra2);
                } else {
                    stringExtra2 = ma;
                }
                if (iB != null) {
                    ah.FL().a(stringExtra2, iB);
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.hXa.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                final /* synthetic */ c hXl;

                {
                    this.hXl = r1;
                }

                public final void a(boolean z, boolean z2, String str, String str2) {
                    if (z) {
                        this.hXl.hXa.cye.bg("hide_btn");
                        this.hXl.hXa.cye.Ls();
                        this.hXl.hXa.hWY = true;
                        c.a(this.hXl);
                    } else if (z2) {
                        com.tencent.mm.ar.l.KD().A(str, 2);
                    } else {
                        v.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = " + str);
                    }
                    if (z || z2) {
                        Intent intent = this.hXl.hXa.aWn.getIntent();
                        int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
                        int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
                        if (intExtra > 0 && intExtra2 > 0) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(10991, new Object[]{Integer.valueOf(intExtra), Integer.valueOf(6), Integer.valueOf(intExtra2)});
                        }
                    }
                }
            });
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(this.hXa.hUa));
            ma = this.hXa.aWn.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra3 = this.hXa.aWn.getIntent().getStringExtra("source_from_nick_name");
            aVar.lJi = ma;
            aVar.lJj = stringExtra3;
            aVar.lJf = new com.tencent.mm.pluginsdk.ui.applet.a.b(this) {
                final /* synthetic */ c hXl;

                public final boolean avs() {
                    String stringExtra = this.hXl.hXa.aWn.getIntent().getStringExtra("room_name");
                    Intent intent = new Intent(this.hXl.hXa.aWn, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", this.hXl.hXa.euW.field_username);
                    intent.putExtra("Contact_Scene", this.hXl.hXa.hUa);
                    intent.putExtra("room_name", stringExtra);
                    intent.putExtra("source_from_user_name", ma);
                    intent.putExtra("source_from_nick_name", stringExtra3);
                    this.hXl.hXa.aWn.startActivity(intent);
                    return true;
                }
            };
            if (be.kS(this.hXa.biB)) {
                aVar.b(this.hXa.euW.field_username, linkedList, false);
                return;
            }
            ma = this.hXa.euW.field_username;
            aVar.biB = this.hXa.biB;
            aVar.b(ma, linkedList, false);
        }
    }

    class d extends a {
        final /* synthetic */ NormalUserFooterPreference hXa;

        public d(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aGT() {
        }

        protected final void aGR() {
            Assert.assertTrue(m.eP(this.hXa.euW.field_username));
            this.hXa.hWK.setVisibility(8);
            this.hXa.hWQ.setVisibility(8);
            this.hXa.hWT.setVisibility(8);
            this.hXa.hhL.setVisibility(0);
            this.hXa.hWW.setVisibility(8);
            this.hXa.hWU.setVisibility(8);
            this.hXa.hWV.setVisibility(8);
            this.hXa.hWX.setVisibility(8);
        }
    }

    class f extends a {
        final /* synthetic */ NormalUserFooterPreference hXa;

        public f(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aGT() {
            if (this.hXa.euW == null || !com.tencent.mm.i.a.ei(this.hXa.euW.field_type)) {
                m(false, true);
            } else {
                aGS();
            }
        }

        protected final void aGR() {
            this.hXa.hWK.setVisibility(8);
            this.hXa.hWQ.setVisibility(0);
            this.hXa.hWT.setVisibility(8);
            this.hXa.hhL.setVisibility(8);
            this.hXa.hWW.setVisibility(8);
            this.hXa.hWU.setVisibility(8);
            this.hXa.hWV.setVisibility(8);
            this.hXa.hWX.setVisibility(8);
            this.hXa.hWS.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ f hXo;

                {
                    this.hXo = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", this.hXo.hXa.euW.field_username);
                    intent.putExtra("Contact_Scene", this.hXo.hXa.hUa);
                    com.tencent.mm.plugin.profile.a.drp.a(intent, this.hXo.hXa.mContext);
                }
            });
        }
    }

    class g extends a {
        final /* synthetic */ NormalUserFooterPreference hXa;

        public g(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        public final void aGT() {
        }

        protected final void aGR() {
            boolean z = true;
            Assert.assertTrue(!com.tencent.mm.model.k.eo(this.hXa.euW.field_username));
            if (m.fn(this.hXa.euW.field_username)) {
                z = false;
            }
            Assert.assertTrue(z);
            this.hXa.hWK.setVisibility(8);
            this.hXa.hWQ.setVisibility(8);
            this.hXa.hhL.setText(2131232158);
            this.hXa.hhL.setVisibility(0);
            this.hXa.hWU.setVisibility(8);
            this.hXa.hWT.setVisibility(8);
            this.hXa.hWX.setVisibility(8);
        }
    }

    class h extends a {
        final /* synthetic */ NormalUserFooterPreference hXa;

        public h(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aGT() {
        }

        protected final void aGR() {
            this.hXa.hWK.setVisibility(8);
            this.hXa.hhL.setVisibility(0);
            if (this.hXa.aGO() || this.hXa.euW.field_username.equals(com.tencent.mm.model.k.xF()) || m.fn(this.hXa.euW.field_username) || m.fg(this.hXa.euW.field_username)) {
                this.hXa.hWU.setVisibility(8);
            } else {
                this.hXa.hWU.setVisibility(0);
            }
            this.hXa.hhL.setText(2131232157);
            this.hXa.hWT.setVisibility(8);
            this.hXa.hWQ.setVisibility(8);
            this.hXa.hWX.setVisibility(8);
        }
    }

    class b extends c {
        final /* synthetic */ NormalUserFooterPreference hXa;

        public b(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aGT() {
            if (this.hXa.euW == null) {
                v.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
            } else if (com.tencent.mm.i.a.ei(this.hXa.euW.field_type) && (!com.tencent.mm.i.a.ei(this.hXa.euW.field_type) || !u.ew(this.hXa.euW.field_username))) {
                aGS();
            } else if (u.ew(this.hXa.euW.field_username)) {
                m(true, true);
            } else {
                m(false, true);
            }
        }

        protected final void aGR() {
            this.hXa.hWK.setVisibility(8);
            if (!com.tencent.mm.i.a.ei(this.hXa.euW.field_type) || (com.tencent.mm.i.a.ei(this.hXa.euW.field_type) && u.ew(this.hXa.euW.field_username))) {
                this.hXa.hWQ.setVisibility(0);
                this.hXa.hhL.setVisibility(8);
                this.hXa.hWW.setVisibility(8);
            } else {
                this.hXa.hWQ.setVisibility(8);
                this.hXa.hhL.setVisibility(0);
                if (!(this.hXa.aGO() || this.hXa.euW.field_username.equals(com.tencent.mm.model.k.xF()))) {
                    this.hXa.hWU.setVisibility(0);
                    this.hXa.hWT.setVisibility(8);
                    this.hXa.hWV.setVisibility(8);
                    this.hXa.hWX.setVisibility(8);
                    if (this.hXa.hWH) {
                        this.hXa.hWQ.setVisibility(8);
                        this.hXa.hWT.setVisibility(0);
                        this.hXa.hWT.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ b hXk;

                            {
                                this.hXk = r1;
                            }

                            public final void onClick(View view) {
                                this.hXk.aGW();
                            }
                        });
                    }
                    this.hXa.hWS.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ b hXk;

                        {
                            this.hXk = r1;
                        }

                        public final void onClick(View view) {
                            if (this.hXk.hXa.hWI && com.tencent.mm.aw.a.bmn()) {
                                Intent intent = new Intent();
                                intent.putExtra("Chat_User", this.hXk.hXa.euW.field_encryptUsername);
                                intent.putExtra("lbs_mode", true);
                                intent.putExtra("lbs_ticket", this.hXk.hXa.enX);
                                intent.putExtra("add_scene", this.hXk.hXa.hUa);
                                com.tencent.mm.plugin.profile.a.drp.e(intent, this.hXk.hXa.aWn);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("Contact_User", this.hXk.hXa.euW.field_username);
                            intent.putExtra("Contact_Scene", this.hXk.hXa.hUa);
                            com.tencent.mm.plugin.profile.a.drp.a(intent, this.hXk.hXa.mContext);
                        }
                    });
                }
            }
            this.hXa.hWU.setVisibility(8);
            this.hXa.hWT.setVisibility(8);
            this.hXa.hWV.setVisibility(8);
            this.hXa.hWX.setVisibility(8);
            if (this.hXa.hWH) {
                this.hXa.hWQ.setVisibility(8);
                this.hXa.hWT.setVisibility(0);
                this.hXa.hWT.setOnClickListener(/* anonymous class already generated */);
            }
            this.hXa.hWS.setOnClickListener(/* anonymous class already generated */);
        }
    }

    class i extends c implements com.tencent.mm.v.e {
        ProgressDialog dwR;
        final /* synthetic */ NormalUserFooterPreference hXa;

        public i(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected void aGR() {
            onDetach();
            onStart();
            super.aGR();
        }

        final void onStart() {
            onStop();
            ak.vy().a(30, this);
        }

        final void onStop() {
            ak.vy().b(30, this);
        }

        protected void onDetach() {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (this.hXa.hWK != null) {
                this.hXa.hWK.setVisibility(8);
            }
            if (this.hXa.hWQ != null) {
                this.hXa.hWQ.setVisibility(0);
            }
            if (this.hXa.hhL != null) {
                this.hXa.hhL.setVisibility(8);
            }
            if (this.hXa.hWW != null) {
                this.hXa.hWW.setVisibility(8);
            }
            if (this.hXa.hWU != null) {
                this.hXa.hWU.setVisibility(8);
            }
            if (this.hXa.hWT != null) {
                this.hXa.hWT.setVisibility(8);
            }
            if (this.hXa.hWX != null) {
                this.hXa.hWX.setVisibility(8);
            }
            onStop();
        }

        protected void aGX() {
            if (this.hXa.hWJ != null) {
                this.hXa.hWJ.onDetach();
            }
            this.hXa.hWJ = new c(this.hXa);
            this.hXa.hWJ.ws();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r9, int r10, java.lang.String r11, com.tencent.mm.v.k r12) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 0;
            r5 = 4;
            r2 = 0;
            r1 = 1;
            r0 = "MicroMsg.NormalUserFooterPreference";
            r3 = new java.lang.StringBuilder;
            r4 = "onSceneEnd, errType = ";
            r3.<init>(r4);
            r3 = r3.append(r9);
            r4 = ", errCode = ";
            r3 = r3.append(r4);
            r3 = r3.append(r10);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.d(r0, r3);
            r0 = r12.getType();
            r3 = 30;
            if (r0 == r3) goto L_0x002f;
        L_0x002e:
            return;
        L_0x002f:
            r8.onStop();
            r0 = r8.dwR;
            if (r0 == 0) goto L_0x003d;
        L_0x0036:
            r0 = r8.dwR;
            r0.dismiss();
            r8.dwR = r6;
        L_0x003d:
            r0 = r8.hXa;
            r0 = r0.mContext;
            r0 = com.tencent.mm.sdk.platformtools.be.bm(r0);
            if (r0 == 0) goto L_0x002e;
        L_0x0047:
            if (r9 != 0) goto L_0x0127;
        L_0x0049:
            if (r10 != 0) goto L_0x0127;
        L_0x004b:
            r0 = r12;
            r0 = (com.tencent.mm.pluginsdk.model.m) r0;
            r0 = r0.bdn;
            r2 = "MicroMsg.NormalUserFooterPreference";
            r3 = new java.lang.StringBuilder;
            r4 = "VerifyBaseHandler onSceneEnd, opCode = ";
            r3.<init>(r4);
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.d(r2, r3);
            if (r0 == r1) goto L_0x006b;
        L_0x0068:
            r1 = 3;
            if (r0 != r1) goto L_0x002e;
        L_0x006b:
            r12 = (com.tencent.mm.pluginsdk.model.m) r12;
            r1 = r12.lzD;
            if (r1 == 0) goto L_0x002e;
        L_0x0071:
            r0 = r8.hXa;
            r0 = r0.euW;
            r0 = r0.field_username;
            r0 = r1.contains(r0);
            if (r0 == 0) goto L_0x002e;
        L_0x007f:
            r0 = r8.hXa;
            r0.hWY = true;
            r2 = r8.hXa;
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.wH();
            r3 = r8.hXa;
            r3 = r3.euW;
            r3 = r3.field_username;
            r0 = r0.LX(r3);
            if (r0 == 0) goto L_0x00a0;
        L_0x009b:
            r4 = r0.chr;
            r3 = (int) r4;
            if (r3 != 0) goto L_0x011c;
        L_0x00a0:
            r0 = r8.hXa;
            r0 = r0.euW;
            com.tencent.mm.model.ak.yW();
            r3 = com.tencent.mm.model.c.wH();
            r3 = r3.M(r0);
            if (r3 != 0) goto L_0x0109;
        L_0x00b3:
            r3 = "MicroMsg.NormalUserFooterPreference";
            r4 = new java.lang.StringBuilder;
            r5 = "insert contact failed, username = ";
            r4.<init>(r5);
            r0 = r0.field_username;
            r0 = r4.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.v.e(r3, r0);
        L_0x00cb:
            r2.euW = r6;
            r0 = r8.hXa;
            r0 = r0.euW;
            if (r0 == 0) goto L_0x00df;
        L_0x00d6:
            r0 = r8.hXa;
            r0 = r0.euW;
            com.tencent.mm.model.m.n(r0);
        L_0x00df:
            r8.aGX();
            r2 = r1.iterator();
        L_0x00e6:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x011e;
        L_0x00ec:
            r0 = r2.next();
            r1 = r0;
            r1 = (java.lang.String) r1;
            r0 = r8.hXa;
            r0 = r0.aWn;
            r0 = r0 instanceof com.tencent.mm.plugin.profile.ui.ContactInfoUI;
            if (r0 == 0) goto L_0x00e6;
        L_0x00fd:
            r0 = r8.hXa;
            r0 = r0.aWn;
            r0 = (com.tencent.mm.plugin.profile.ui.ContactInfoUI) r0;
            r0.xM(r1);
            goto L_0x00e6;
        L_0x0109:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.wH();
            r3 = r8.hXa;
            r3 = r3.euW;
            r3 = r3.field_username;
            r0 = r0.LX(r3);
        L_0x011c:
            r6 = r0;
            goto L_0x00cb;
        L_0x011e:
            r0 = com.tencent.mm.model.ak.oH();
            r0.qs();
            goto L_0x002e;
        L_0x0127:
            if (r9 != r5) goto L_0x0189;
        L_0x0129:
            r0 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
            if (r10 != r0) goto L_0x0189;
        L_0x012d:
            r12 = (com.tencent.mm.pluginsdk.model.m) r12;
            r0 = r12.bdn;
            r3 = "MicroMsg.NormalUserFooterPreference";
            r4 = "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d";
            r1 = new java.lang.Object[r1];
            r5 = java.lang.Integer.valueOf(r0);
            r1[r2] = r5;
            com.tencent.mm.sdk.platformtools.v.w(r3, r4, r1);
            r1 = 3;
            if (r0 != r1) goto L_0x002e;
        L_0x0145:
            r0 = r8.hXa;
            r0 = r0.aWn;
            r1 = r8.hXa;
            r1 = r1.aWn;
            r2 = 2131232200; // 0x7f0805c8 float:1.8080503E38 double:1.0529686133E-314;
            r1 = r1.getString(r2);
            r2 = r8.hXa;
            r2 = r2.aWn;
            r3 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
            r2 = r2.getString(r3);
            r3 = r8.hXa;
            r3 = r3.aWn;
            r4 = 2131230900; // 0x7f0800b4 float:1.8077866E38 double:1.052967971E-314;
            r3 = r3.getString(r4);
            r4 = r8.hXa;
            r4 = r4.aWn;
            r5 = 2131231010; // 0x7f080122 float:1.8078089E38 double:1.0529680254E-314;
            r4 = r4.getString(r5);
            r5 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$4;
            r5.<init>(r8);
            com.tencent.mm.ui.base.g.b(r0, r1, r2, r3, r4, r5, r6);
            goto L_0x002e;
        L_0x0189:
            if (r9 != r5) goto L_0x01a4;
        L_0x018b:
            r0 = -24;
            if (r10 != r0) goto L_0x01a4;
        L_0x018f:
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r11);
            if (r0 != 0) goto L_0x01a4;
        L_0x0195:
            r0 = r8.hXa;
            r0 = r0.aWn;
            r0 = android.widget.Toast.makeText(r0, r11, r1);
            r0.show();
            goto L_0x002e;
        L_0x01a4:
            switch(r9) {
                case 1: goto L_0x01ac;
                case 2: goto L_0x01e0;
                case 3: goto L_0x01a7;
                case 4: goto L_0x0208;
                default: goto L_0x01a7;
            };
        L_0x01a7:
            r0 = r2;
        L_0x01a8:
            if (r0 == 0) goto L_0x002e;
        L_0x01aa:
            goto L_0x002e;
        L_0x01ac:
            r0 = com.tencent.mm.model.ak.vy();
            r0 = r0.BK();
            if (r0 == 0) goto L_0x01cb;
        L_0x01b6:
            r0 = r8.hXa;
            r0 = r0.mContext;
            r2 = com.tencent.mm.model.ak.vy();
            r2 = r2.getNetworkServerIp();
            r3 = java.lang.String.valueOf(r10);
            com.tencent.mm.pluginsdk.ui.i.u(r0, r2, r3);
            r0 = r1;
            goto L_0x01a8;
        L_0x01cb:
            r0 = r8.hXa;
            r0 = r0.mContext;
            r0 = com.tencent.mm.network.aa.bk(r0);
            if (r0 == 0) goto L_0x01de;
        L_0x01d5:
            r0 = r8.hXa;
            r0 = r0.mContext;
            com.tencent.mm.pluginsdk.ui.i.dl(r0);
            r0 = r1;
            goto L_0x01a8;
        L_0x01de:
            r0 = r2;
            goto L_0x01a8;
        L_0x01e0:
            r0 = r8.hXa;
            r0 = r0.mContext;
            r3 = r8.hXa;
            r3 = r3.mContext;
            r4 = 2131232875; // 0x7f08086b float:1.8081872E38 double:1.052968947E-314;
            r5 = new java.lang.Object[r7];
            r6 = java.lang.Integer.valueOf(r7);
            r5[r2] = r6;
            r2 = java.lang.Integer.valueOf(r10);
            r5[r1] = r2;
            r2 = r3.getString(r4, r5);
            r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r0 = android.widget.Toast.makeText(r0, r2, r3);
            r0.show();
            r0 = r1;
            goto L_0x01a8;
        L_0x0208:
            r0 = -100;
            if (r10 != r0) goto L_0x022f;
        L_0x020c:
            r0 = r8.hXa;
            r0 = r0.mContext;
            r2 = com.tencent.mm.model.ak.uA();
            r3 = r8.hXa;
            r3 = r3.mContext;
            r4 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
            r3 = com.tencent.mm.bd.a.O(r3, r4);
            r4 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$2;
            r4.<init>(r8);
            r5 = new com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$3;
            r5.<init>(r8);
            com.tencent.mm.ui.base.g.a(r0, r2, r3, r4, r5);
            r0 = r1;
            goto L_0x01a8;
        L_0x022f:
            if (r9 != r5) goto L_0x0251;
        L_0x0231:
            r0 = -34;
            if (r10 != r0) goto L_0x0251;
        L_0x0235:
            r0 = r8.hXa;
            r0 = r0.aWn;
            r3 = 2131232851; // 0x7f080853 float:1.8081823E38 double:1.052968935E-314;
            r0 = r0.getString(r3);
        L_0x0242:
            r3 = r8.hXa;
            r3 = r3.aWn;
            r0 = android.widget.Toast.makeText(r3, r0, r1);
            r0.show();
            goto L_0x01a7;
        L_0x0251:
            if (r9 != r5) goto L_0x0265;
        L_0x0253:
            r0 = -94;
            if (r10 != r0) goto L_0x0265;
        L_0x0257:
            r0 = r8.hXa;
            r0 = r0.aWn;
            r3 = 2131232852; // 0x7f080854 float:1.8081825E38 double:1.0529689355E-314;
            r0 = r0.getString(r3);
            goto L_0x0242;
        L_0x0265:
            r0 = r8.hXa;
            r0 = r0.aWn;
            r3 = 2131234920; // 0x7f081068 float:1.808602E38 double:1.052969957E-314;
            r0 = r0.getString(r3);
            goto L_0x0242;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
        }
    }

    class j extends i implements com.tencent.mm.v.e {
        final /* synthetic */ NormalUserFooterPreference hXa;

        public j(NormalUserFooterPreference normalUserFooterPreference) {
            this.hXa = normalUserFooterPreference;
            super(normalUserFooterPreference);
        }

        protected final void aGT() {
            if (this.hXa.euW == null || !com.tencent.mm.i.a.ei(this.hXa.euW.field_type)) {
                m(false, true);
            } else {
                aGS();
            }
        }

        protected final void aGR() {
            super.aGR();
            this.hXa.hWK.setVisibility(0);
            this.hXa.hWT.setVisibility(8);
            this.hXa.hhL.setVisibility(8);
            this.hXa.hWW.setVisibility(8);
            this.hXa.hWU.setVisibility(8);
            this.hXa.hWV.setVisibility(8);
            this.hXa.hWQ.setVisibility(8);
            this.hXa.hWX.setVisibility(8);
            switch (this.hXa.hUa) {
                case 1:
                case 2:
                case 3:
                case 12:
                case as.CTRL_INDEX /*13*/:
                case 18:
                case bf.CTRL_INDEX /*22*/:
                case 23:
                case 24:
                case 25:
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                case bv.CTRL_INDEX /*27*/:
                case p.CTRL_INDEX /*28*/:
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                case 30:
                case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                case 58:
                case 59:
                case EncrptType.VERIFY_CODE /*60*/:
                    this.hXa.hWP.setVisibility(0);
                    this.hXa.hWO.setVisibility(0);
                    break;
                default:
                    this.hXa.hWP.setVisibility(8);
                    this.hXa.hWO.setVisibility(8);
                    break;
            }
            if (this.hXa.euW.tK()) {
                this.hXa.hWN.setText(this.hXa.aWn.getString(2131232100));
                this.hXa.hWX.setVisibility(0);
            } else {
                this.hXa.hWN.setText(this.hXa.aWn.getString(2131232096));
            }
            this.hXa.hWL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j hXq;

                {
                    this.hXq = r1;
                }

                public final void onClick(View view) {
                    i iVar = this.hXq;
                    iVar.onStart();
                    Context context = iVar.hXa.mContext;
                    iVar.hXa.mContext.getString(2131231164);
                    iVar.dwR = com.tencent.mm.ui.base.g.a(context, iVar.hXa.mContext.getString(2131232021), true, new OnCancelListener(iVar) {
                        final /* synthetic */ i hXp;

                        {
                            this.hXp = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.hXp.onStop();
                        }
                    });
                    ak.vy().a(new com.tencent.mm.pluginsdk.model.m(iVar.hXa.euW.field_username, iVar.hXa.hUb, iVar.hXa.hUa), 0);
                }
            });
            this.hXa.hWN.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j hXq;

                {
                    this.hXq = r1;
                }

                public final void onClick(View view) {
                    if (this.hXq.hXa.euW.tK()) {
                        m.g(this.hXq.hXa.euW);
                        this.hXq.hXa.euW.ts();
                        this.hXq.aGR();
                        return;
                    }
                    com.tencent.mm.ui.base.g.a(this.hXq.hXa.mContext, this.hXq.hXa.mContext.getString(2131232097), this.hXq.hXa.mContext.getString(2131232096), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 hXr;

                        {
                            this.hXr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            m.f(this.hXr.hXq.hXa.euW);
                            this.hXr.hXq.hXa.euW.tr();
                            this.hXr.hXq.aGR();
                        }
                    }, null);
                }
            });
        }

        protected final void onDetach() {
            super.onDetach();
        }

        protected final void aGX() {
            super.aGX();
        }

        public final void a(int i, int i2, String str, k kVar) {
            super.a(i, i2, str, kVar);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        this.aWn = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWn = (MMActivity) context;
        init();
    }

    private void init() {
        this.fyL = false;
        this.hWJ = null;
    }

    private void NI() {
        if (!this.fyL || this.euW == null) {
            v.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.fyL + " contact = " + this.euW);
            return;
        }
        if (this.hWJ != null) {
            this.hWJ.ws();
        }
        aGO();
    }

    public final void onBindView(View view) {
        v.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.hWK = view.findViewById(2131756444);
        this.hWL = (Button) view.findViewById(2131756445);
        this.hWM = (Button) view.findViewById(2131756452);
        this.hWP = (Button) view.findViewById(2131756448);
        this.hWO = view.findViewById(2131756447);
        this.hWN = (Button) view.findViewById(2131756446);
        this.hWT = (Button) view.findViewById(2131756453);
        this.hWQ = view.findViewById(2131756449);
        this.hWR = (Button) view.findViewById(2131756451);
        this.hWS = (Button) view.findViewById(2131756450);
        this.hhL = (Button) view.findViewById(2131756454);
        this.hWW = (Button) view.findViewById(2131756457);
        this.hWU = (Button) view.findViewById(2131756455);
        this.hWV = (Button) view.findViewById(2131756456);
        this.hWX = (TextView) view.findViewById(2131756458);
        this.fyL = true;
        NI();
        super.onBindView(view);
        if (this.aWn.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.hWL != null) {
            this.hWL.performClick();
        }
    }

    public final boolean a(u uVar, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        XS();
        Assert.assertTrue(uVar != null);
        Assert.assertTrue(be.ma(uVar.field_username).length() > 0);
        if (u.LM(com.tencent.mm.model.k.xF()).equals(uVar.field_username)) {
            return false;
        }
        this.euW = uVar;
        this.hUb = str;
        this.hTY = z;
        this.hUa = i;
        this.hVI = i2;
        this.hWG = be.a(Boolean.valueOf(m.eA(uVar.field_username)), false);
        this.hWE = z4;
        this.hWF = z5;
        this.hWq = j;
        this.hVQ = str2;
        this.hWZ = false;
        this.hVW = uVar.field_deleteFlag == 1;
        this.hWY = this.aWn.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.hVl = this.aWn.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.hWH = this.aWn.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.hWI = this.aWn.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.enX = this.aWn.getIntent().getStringExtra("lbs_ticket");
        if (!com.tencent.mm.model.k.eo(uVar.field_username)) {
            ak.yW();
            if (!com.tencent.mm.model.c.wN().has(uVar.field_username)) {
                if (u.LH(uVar.field_username)) {
                    this.hWJ = new h(this);
                } else if (m.eP(uVar.field_username)) {
                    this.hWJ = new d(this);
                } else if (m.eA(uVar.field_username)) {
                    this.hWJ = new g(this);
                } else if (u.LI(uVar.field_username)) {
                    this.hWJ = new f(this);
                } else if (com.tencent.mm.i.a.ei(uVar.field_type) && !u.ew(uVar.field_username)) {
                    this.hWJ = new c(this);
                    this.hWZ = true;
                } else if (z2) {
                    this.hWJ = new j(this);
                    this.hWZ = true;
                } else if (z3 || u.ew(uVar.field_username)) {
                    this.hWJ = new b(this);
                } else {
                    this.hWJ = new c(this);
                    this.hWZ = true;
                }
                NI();
                return true;
            }
        }
        this.hWJ = new c(this);
        this.hWZ = true;
        NI();
        return true;
    }

    public final boolean aGO() {
        if (this.hWY && com.tencent.mm.i.a.ei(this.euW.field_type)) {
            this.hWW.setVisibility(0);
            return true;
        }
        this.hWW.setVisibility(8);
        return false;
    }

    public final boolean XS() {
        if (this.hWJ != null) {
            this.hWJ.onDetach();
        }
        this.cye.removeAll();
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        return true;
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        if (be.ma(str).length() <= 0 || this.euW == null) {
            return;
        }
        if (str.equals(this.euW.field_username) || str.equals(this.euW.field_encryptUsername)) {
            ak.yW();
            this.euW = com.tencent.mm.model.c.wH().LX(this.euW.field_username);
            ad.o(new Runnable(this) {
                final /* synthetic */ NormalUserFooterPreference hXa;

                {
                    this.hXa = r1;
                }

                public final void run() {
                    this.hXa.aGO();
                }
            });
        }
    }

    public final void aGP() {
        v.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.aWn, "android.permission.RECORD_AUDIO", 82, "", "")), be.bur(), this.aWn});
        if (com.tencent.mm.pluginsdk.i.a.a(this.aWn, "android.permission.RECORD_AUDIO", 82, "", "")) {
            qi qiVar = new qi();
            qiVar.brC.bdn = 5;
            qiVar.brC.bdo = this.euW.field_username;
            qiVar.brC.context = this.aWn;
            qiVar.brC.brx = 4;
            com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        }
    }

    public final void aGQ() {
        v.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.aWn, "android.permission.CAMERA", 19, "", "")), be.bur(), this.aWn});
        if (com.tencent.mm.pluginsdk.i.a.a(this.aWn, "android.permission.CAMERA", 19, "", "")) {
            v.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.aWn, "android.permission.RECORD_AUDIO", 19, "", "")), be.bur(), this.aWn});
            if (com.tencent.mm.pluginsdk.i.a.a(this.aWn, "android.permission.RECORD_AUDIO", 19, "", "")) {
                qi qiVar = new qi();
                qiVar.brC.bdn = 5;
                qiVar.brC.bdo = this.euW.field_username;
                qiVar.brC.context = this.aWn;
                qiVar.brC.brx = 2;
                com.tencent.mm.sdk.c.a.nhr.z(qiVar);
            }
        }
    }
}
