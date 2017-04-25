package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.f.a;
import com.tencent.mm.plugin.emoji.model.f.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, a, b, e {
    private ListView Eq;
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String aZD;
    protected final int ffN = 131074;
    private final int ffO = 131075;
    private final int ffP = 131076;
    private final String ffQ = "product_id";
    private final String ffR = "progress";
    private final String ffS = DownloadInfo.STATUS;
    private c ffY = new c<cb>(this) {
        final /* synthetic */ CustomSmileyPreviewUI fgt;

        {
            this.fgt = r2;
            this.nhz = cb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cb cbVar = (cb) bVar;
            if (!be.kS(this.fgt.aZD) && this.fgt.aZD.equals(cbVar.aZC.aZD)) {
                CustomSmileyPreviewUI customSmileyPreviewUI = this.fgt;
                String str = cbVar.aZC.aZD;
                int i = cbVar.aZC.status;
                int i2 = cbVar.aZC.progress;
                v.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), cbVar.aZC.aZE});
                if (i == 6) {
                    Message obtain = Message.obtain();
                    obtain.getData().putString("product_id", str);
                    obtain.getData().putInt("progress", i2);
                    obtain.what = 131075;
                    if (customSmileyPreviewUI.mHandler != null) {
                        customSmileyPreviewUI.mHandler.sendMessage(obtain);
                    }
                } else {
                    v.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                    Message obtain2 = Message.obtain();
                    obtain2.getData().putString("product_id", str);
                    obtain2.getData().putInt(DownloadInfo.STATUS, i);
                    obtain2.what = 131076;
                    if (customSmileyPreviewUI.mHandler != null) {
                        customSmileyPreviewUI.mHandler.sendMessage(obtain2);
                    }
                }
                if (!(customSmileyPreviewUI.fgg == null || customSmileyPreviewUI.fgg.eZW == null)) {
                    f qY = customSmileyPreviewUI.fgg.eZW.qY(str);
                    if (qY != null) {
                        qY.fal = r4;
                    }
                }
            }
            return false;
        }
    };
    private g ffZ;
    private com.tencent.mm.storage.a.c ffo;
    com.tencent.mm.plugin.emoji.a.f fgg;
    private View fgh;
    private ImageView fgi;
    private TextView fgj;
    private TextView fgk;
    private vl fgl;
    private oh fgm = new oh();
    private String fgn;
    private com.tencent.mm.plugin.emoji.model.f fgo;
    private long fgp;
    String fgq;
    private String fgr;
    private c fgs = new c<ly>(this) {
        final /* synthetic */ CustomSmileyPreviewUI fgt;

        {
            this.fgt = r2;
            this.nhz = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ly lyVar = (ly) bVar;
            if (this.fgt.fgp != 0 && lyVar.bnd.bng == this.fgt.fgp) {
                v.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                com.tencent.mm.ui.base.g.a(this.fgt.nDR.nEl, lyVar.bnd.bne, "", this.fgt.getString(2131231875), false, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 fgu;

                    {
                        this.fgu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        this.fgu.fgt.finish();
                    }
                });
            }
            return false;
        }
    };
    ac mHandler = new ac(this) {
        final /* synthetic */ CustomSmileyPreviewUI fgt;

        {
            this.fgt = r1;
        }

        public final void handleMessage(Message message) {
            int i;
            String string;
            switch (message.what) {
                case 2:
                    this.fgt.a(this.fgt.aZD, this.fgt.ffo);
                    return;
                case 131075:
                    i = message.getData().getInt("progress");
                    string = message.getData().getString("product_id");
                    if (be.kS(string)) {
                        v.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                        return;
                    } else if (this.fgt.fgg != null && this.fgt.fgg.eZW != null) {
                        this.fgt.fgg.ao(string, i);
                        this.fgt.fgg.acO();
                        return;
                    } else {
                        return;
                    }
                case 131076:
                    i = message.getData().getInt(DownloadInfo.STATUS);
                    string = message.getData().getString("product_id");
                    if (be.kS(string)) {
                        v.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                        return;
                    } else if (this.fgt.fgg != null && this.fgt.fgg.eZW != null) {
                        this.fgt.fgg.an(string, i);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void e(CustomSmileyPreviewUI customSmileyPreviewUI) {
        customSmileyPreviewUI.ffo = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(customSmileyPreviewUI.ffo.EB());
        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(customSmileyPreviewUI, com.tencent.mm.ui.widget.f.pbS, false);
        fVar.jXn = new n.c(customSmileyPreviewUI) {
            final /* synthetic */ CustomSmileyPreviewUI fgt;

            {
                this.fgt = r1;
            }

            public final void a(l lVar) {
                if (!(this.fgt.ffo.field_catalog == com.tencent.mm.storage.a.c.nwR || this.fgt.ffo.bxG())) {
                    lVar.dg(0, 2131230819);
                }
                if (this.fgt.ffo.field_catalog == com.tencent.mm.storage.a.c.nwR || be.kS(this.fgt.ffo.field_groupId) || (!be.kS(this.fgt.ffo.field_groupId) && j.a.bmr().rl(this.fgt.ffo.field_groupId))) {
                    lVar.dg(1, 2131234560);
                }
                lVar.dg(2, 2131232342);
            }
        };
        fVar.jXo = new d(customSmileyPreviewUI) {
            final /* synthetic */ CustomSmileyPreviewUI fgt;

            {
                this.fgt = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        MMActivity mMActivity = this.fgt;
                        com.tencent.mm.storage.a.c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(mMActivity.getIntent().getStringExtra("custom_smiley_preview_md5"));
                        if (NF == null) {
                            v.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                            return;
                        } else if (NF.field_catalog == com.tencent.mm.storage.a.c.nwN) {
                            return;
                        } else {
                            if (NF.field_catalog == com.tencent.mm.storage.a.c.nwR) {
                                com.tencent.mm.ui.base.g.bf(mMActivity, mMActivity.getString(2131230902));
                                return;
                            } else {
                                com.tencent.mm.plugin.emoji.model.g.aft().a(mMActivity.nDR.nEl, NF, 4, mMActivity.fgq);
                                return;
                            }
                        }
                    case 1:
                        CustomSmileyPreviewUI.j(this.fgt);
                        return;
                    case 2:
                        CustomSmileyPreviewUI.k(this.fgt);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void j(CustomSmileyPreviewUI customSmileyPreviewUI) {
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.a.drp.l(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.g.iuh.h(12789, new Object[]{Integer.valueOf(1), customSmileyPreviewUI.ffo.EB(), Integer.valueOf(1), customSmileyPreviewUI.ffo.field_designerID, customSmileyPreviewUI.ffo.field_groupId, customSmileyPreviewUI.fgq});
    }

    static /* synthetic */ void k(CustomSmileyPreviewUI customSmileyPreviewUI) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.fgr);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        intent.putExtra("k_username", customSmileyPreviewUI.fgq);
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.fgp);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        com.tencent.mm.ay.c.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int getLayoutId() {
        return 2130903444;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(412, this);
        ak.vy().a(521, this);
        ak.vy().a(411, this);
        ak.vy().a(239, this);
        com.tencent.mm.sdk.c.a.nhr.e(this.ffY);
        com.tencent.mm.sdk.c.a.nhr.e(this.fgs);
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        ak.vy().b(412, this);
        ak.vy().b(521, this);
        ak.vy().b(411, this);
        ak.vy().b(239, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.ffY);
        com.tencent.mm.sdk.c.a.nhr.f(this.fgs);
        super.onDestroy();
    }

    protected final void NI() {
        Fd("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.fgp = getIntent().getLongExtra("msg_id", 0);
        this.fgq = getIntent().getStringExtra("msg_sender");
        this.fgr = getIntent().getStringExtra("msg_content");
        v.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[]{stringExtra});
        Object ma = be.ma(stringExtra);
        if (TextUtils.isEmpty(ma)) {
            v.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        MMEmojiView mMEmojiView = (MMEmojiView) findViewById(2131755434);
        if (mMEmojiView == null) {
            v.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail emojiView is null.");
            finish();
            return;
        }
        String str;
        String str2;
        Object[] objArr;
        boolean z;
        com.tencent.mm.plugin.report.service.g gVar;
        this.ffo = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(ma);
        if (this.ffo.bxG()) {
            InputStream ba = com.tencent.mm.storage.a.c.ba(this, this.ffo.getName());
            if (ba != null) {
                mMEmojiView.a(ba, this.ffo.getName());
            } else {
                str = "MicroMsg.emoji.CustomSmileyPreviewUI";
                str2 = "input stream is null. emoji name is:%s";
                objArr = new Object[1];
                objArr[0] = this.ffo == null ? "null" : this.ffo.getName();
                v.e(str, str2, objArr);
            }
        } else {
            mMEmojiView.a(this.ffo, "");
            if (!(this.ffo == null || this.ffo.bxL())) {
                com.tencent.mm.plugin.emoji.d.d.aeS();
                com.tencent.mm.plugin.emoji.d.d.a(this.ffo, true);
            }
        }
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        str = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(2131755437);
        com.tencent.mm.pluginsdk.model.app.f aC = com.tencent.mm.pluginsdk.model.app.g.aC(stringExtra2, true);
        str2 = (aC == null || aC.field_appName == null || aC.field_appName.trim().length() <= 0) ? str : aC.field_appName;
        if (stringExtra2 != null && stringExtra2.length() > 0) {
            boolean z2;
            if (str2 == null || str2.trim().length() == 0 || str2.equals("weixinfile") || str2.equals("invalid_appname")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                textView.setText(getString(2131231902, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.nDR.nEl, aC, str2)}));
                textView.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.chat.l.b bVar = new com.tencent.mm.pluginsdk.ui.chat.l.b();
                bVar.appId = stringExtra2;
                bVar.bmm = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(stringExtra2, 2, com.tencent.mm.bd.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), 2130838795));
                } else {
                    a(this, textView, b);
                }
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ CustomSmileyPreviewUI fgt;

                    {
                        this.fgt = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.fgt.finish();
                        return true;
                    }
                });
                if (this.ffo.field_catalog != com.tencent.mm.storage.a.c.nwR || this.ffo.bxG()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.ffo.field_catalog == com.tencent.mm.storage.a.c.nwR || be.kS(this.ffo.field_groupId) || (!be.kS(this.ffo.field_groupId) && j.a.bmr().rl(this.ffo.field_groupId))) {
                    z = true;
                }
                a(0, 2130838681, new OnMenuItemClickListener(this) {
                    final /* synthetic */ CustomSmileyPreviewUI fgt;

                    {
                        this.fgt = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        CustomSmileyPreviewUI.e(this.fgt);
                        return true;
                    }
                });
                iU(z);
                this.fgh = findViewById(2131756686);
                this.fgi = (ImageView) this.fgh.findViewById(2131756687);
                this.fgj = (TextView) this.fgh.findViewById(2131756688);
                this.fgk = (TextView) this.fgh.findViewById(2131756689);
                this.fgh.setVisibility(8);
                if (!(this.ffo == null || be.kS(this.ffo.field_designerID))) {
                    this.fgl = com.tencent.mm.plugin.emoji.model.g.afx().fcn.NI(this.ffo.field_designerID);
                    agA();
                    ak.vy().a(new i(this.ffo.field_designerID), 0);
                }
                this.fgh.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ CustomSmileyPreviewUI fgt;

                    {
                        this.fgt = r1;
                    }

                    public final void onClick(View view) {
                        if (this.fgt.fgl == null || this.fgt.fgl.mxZ == null) {
                            v.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.fgt.nDR.nEl, EmojiStoreV2DesignerUI.class);
                        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, this.fgt.fgl.mxZ.mxS);
                        intent.putExtra("name", this.fgt.fgl.mxZ.gkB);
                        intent.putExtra("headurl", this.fgt.fgl.mxZ.mqz);
                        intent.putExtra("extra_scence", 9);
                        this.fgt.nDR.nEl.startActivity(intent);
                    }
                });
                gVar = com.tencent.mm.plugin.report.service.g.iuh;
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = this.aZD;
                objArr[2] = ma;
                if (this.ffo != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.ffo.field_designerID;
                }
                objArr[3] = stringExtra;
                gVar.h(12067, objArr);
            }
        }
        textView.setVisibility(8);
        this.aZD = this.ffo.field_groupId;
        ak.vy().a(new com.tencent.mm.plugin.emoji.e.j(this.aZD), 0);
        this.Eq = (ListView) findViewById(16908298);
        this.fgg = new com.tencent.mm.plugin.emoji.a.f(this.nDR.nEl);
        this.fgg.eZX = this;
        this.fgg.eZp = true;
        this.fgg.eZs = false;
        this.Eq.setOnItemClickListener(this);
        this.Eq.setAdapter(this.fgg);
        this.fgg.eZV = this.Eq;
        if (!be.kS(this.aZD)) {
            k NK = com.tencent.mm.plugin.emoji.model.g.afx().fcl.NK(this.aZD);
            if (!(NK == null || NK.field_content == null)) {
                vp vpVar = new vp();
                try {
                    vpVar.az(NK.field_content);
                    this.fgm = vpVar.myd;
                    this.fgn = NK.field_lan;
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[]{be.e(e)});
                }
            }
            if (this.fgm == null || be.kS(this.fgn) || !this.fgn.equalsIgnoreCase(u.dJ(this.nDR.nEl))) {
                ak.vy().a(new com.tencent.mm.plugin.emoji.e.k(this.aZD, 1), 0);
            } else {
                com.tencent.mm.plugin.emoji.a.a.c agB = agB();
                if (this.fgg != null) {
                    this.fgg.a(agB);
                }
                ak.vy().a(new com.tencent.mm.plugin.emoji.e.k(this.aZD, 1, this.fgm.efl), 0);
            }
        }
        this.fgo = new com.tencent.mm.plugin.emoji.model.f();
        this.fgo.fda = this;
        this.fgo.fcY = this.fgg;
        this.fgo.fdc = 9;
        this.fgo.fdf = this;
        a(this.aZD, this.ffo);
        b(/* anonymous class already generated */);
        if (this.ffo.field_catalog != com.tencent.mm.storage.a.c.nwR) {
        }
        z = false;
        z = true;
        a(0, 2130838681, /* anonymous class already generated */);
        iU(z);
        this.fgh = findViewById(2131756686);
        this.fgi = (ImageView) this.fgh.findViewById(2131756687);
        this.fgj = (TextView) this.fgh.findViewById(2131756688);
        this.fgk = (TextView) this.fgh.findViewById(2131756689);
        this.fgh.setVisibility(8);
        this.fgl = com.tencent.mm.plugin.emoji.model.g.afx().fcn.NI(this.ffo.field_designerID);
        agA();
        ak.vy().a(new i(this.ffo.field_designerID), 0);
        this.fgh.setOnClickListener(/* anonymous class already generated */);
        gVar = com.tencent.mm.plugin.report.service.g.iuh;
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.aZD;
        objArr[2] = ma;
        if (this.ffo != null) {
            stringExtra = this.ffo.field_designerID;
        } else {
            stringExtra = "";
        }
        objArr[3] = stringExtra;
        gVar.h(12067, objArr);
    }

    private void agA() {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ CustomSmileyPreviewUI fgt;

            {
                this.fgt = r1;
            }

            public final void run() {
                if (this.fgt.fgl == null || this.fgt.fgl.mxZ == null) {
                    this.fgt.fgh.setVisibility(8);
                    return;
                }
                this.fgt.fgh.setVisibility(0);
                this.fgt.fgj.setText(this.fgt.fgl.mxZ.gkB);
                com.tencent.mm.ae.n.GL().a(this.fgt.fgl.mxZ.mqz, this.fgt.fgi, com.tencent.mm.plugin.emoji.d.g.bm(this.fgt.ffo.field_groupId, this.fgt.fgl.mxZ.mqz));
            }
        });
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(2131493128);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        switch (kVar.getType()) {
            case 239:
                this.fgl = ((i) kVar).afL();
                agA();
                return;
            case 411:
                com.tencent.mm.plugin.emoji.model.g.afx().fck.a(12, ((m) kVar).afP());
                return;
            case 412:
                com.tencent.mm.plugin.emoji.e.k kVar2 = (com.tencent.mm.plugin.emoji.e.k) kVar;
                String str2;
                String str3;
                Object[] objArr;
                com.tencent.mm.plugin.emoji.a.a.c agB;
                if (i == 0) {
                    if (i2 == 0) {
                        this.fgm = kVar2.afN();
                        if (this.fgm == null || TextUtils.isEmpty(this.aZD) || !this.aZD.equals(this.fgm.mdM)) {
                            str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                            str3 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
                            objArr = new Object[2];
                            objArr[0] = this.aZD;
                            objArr[1] = this.fgm == null ? "" : this.fgm.mdM;
                            v.i(str2, str3, objArr);
                            return;
                        }
                        agB = agB();
                        if (this.fgg != null) {
                            this.fgg.a(agB);
                        }
                        this.mHandler.sendEmptyMessage(0);
                        v.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.fgm.mdM);
                        return;
                    } else if (i2 != 1) {
                        return;
                    } else {
                        return;
                    }
                } else if (i2 != 5) {
                    return;
                } else {
                    if (this.fgm == null || kVar2.afN() == null || TextUtils.isEmpty(this.aZD) || !this.aZD.equals(this.fgm.mdM) || this.fgm.mqi == kVar2.afN().mqi) {
                        str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                        str3 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
                        objArr = new Object[2];
                        objArr[0] = this.aZD;
                        objArr[1] = this.fgm == null ? "" : this.fgm.mdM;
                        v.i(str2, str3, objArr);
                        return;
                    }
                    this.fgm.mqi = kVar2.afN().mqi;
                    agB = agB();
                    if (this.fgg != null) {
                        this.fgg.a(agB);
                    }
                    this.mHandler.sendEmptyMessage(0);
                    v.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.fgm.mdM);
                    return;
                }
            case 521:
                if (i2 == 0) {
                    this.mHandler.sendEmptyMessage(2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private com.tencent.mm.plugin.emoji.a.a.c agB() {
        List arrayList = new ArrayList();
        ol olVar = new ol();
        olVar.mql = this.fgm.mql;
        olVar.gnp = this.fgm.gnp;
        olVar.mqd = this.fgm.mqd;
        olVar.mqi = this.fgm.mqi;
        olVar.mqe = this.fgm.mqe;
        olVar.mqm = this.fgm.mqm;
        olVar.mqh = this.fgm.mqh;
        olVar.mqg = this.fgm.mqg;
        olVar.mqo = this.fgm.mqo;
        olVar.mqp = this.fgm.mqp;
        olVar.mdM = this.fgm.mdM;
        arrayList.add(new f(olVar));
        return new com.tencent.mm.plugin.emoji.a.a.c(arrayList);
    }

    private void a(String str, com.tencent.mm.storage.a.c cVar) {
        if (!be.kS(str) && cVar != null) {
            if (!be.kS(str) && cVar.field_catalog != com.tencent.mm.storage.a.a.nwK && cVar.field_catalog != com.tencent.mm.storage.a.a.nwJ && ((cVar.field_type != com.tencent.mm.storage.a.c.nwW || cVar.field_type != com.tencent.mm.storage.a.c.nwX) && com.tencent.mm.plugin.emoji.model.g.afx().fcj.NC(str))) {
                if (this.Eq != null) {
                    this.Eq.setVisibility(0);
                }
                if (this.fgg == null) {
                    return;
                }
                if (com.tencent.mm.plugin.emoji.model.g.afx().fcj.ND(str)) {
                    this.fgg.eZq = true;
                } else {
                    this.fgg.eZq = false;
                }
            } else if (this.Eq != null) {
                this.Eq.setVisibility(8);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aex();
        objArr[1] = TextUtils.isEmpty(aVar.aez()) ? "" : aVar.aez();
        objArr[2] = Integer.valueOf(aVar.aey());
        v.i(str, str2, objArr);
        this.fgo.a(aVar);
    }

    public final void B(String str, String str2, String str3) {
        this.ffZ = new g(str, str2, str3);
        ak.vy().a(this.ffZ, 0);
    }

    public final void afo() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.fgg != null && i >= 0 && i < this.fgg.getCount()) {
            f jG = this.fgg.jG(i);
            Intent intent = new Intent();
            intent.setClass(this, EmojiStoreDetailUI.class);
            ol olVar = jG.fai;
            if (olVar == null) {
                intent = null;
            } else {
                intent.putExtra("extra_id", olVar.mdM);
                intent.putExtra("extra_name", olVar.mqd);
                intent.putExtra("extra_copyright", olVar.mqn);
                intent.putExtra("extra_coverurl", olVar.mql);
                intent.putExtra("extra_description", olVar.mqe);
                intent.putExtra("extra_price", olVar.mqg);
                intent.putExtra("extra_type", olVar.mqh);
                intent.putExtra("extra_flag", olVar.mqi);
                intent.putExtra("preceding_scence", 4);
                intent.putExtra("call_by", 1);
                intent.putExtra("download_entrance_scene", 9);
                intent.putExtra("check_clickflag", true);
                intent.putExtra("extra_status", jG.mStatus);
                intent.putExtra("extra_progress", jG.rT);
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (!be.kS(stringExtra)) {
                    intent.putExtra("to_talker_name", stringExtra);
                }
            }
            startActivity(intent);
        }
    }
}
