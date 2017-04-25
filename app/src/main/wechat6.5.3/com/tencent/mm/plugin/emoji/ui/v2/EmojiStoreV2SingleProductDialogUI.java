package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    private String aEZ;
    public String bZy;
    private int cVh;
    private h doc;
    private a fcN = new a(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

        {
            this.fpw = r1;
        }

        public final void i(c cVar) {
            if (cVar == null || this.fpw.fpj == null || !this.fpw.fpj.mpC.equals(cVar.EB())) {
                v.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "somethings error.");
            } else {
                EmojiStoreV2SingleProductDialogUI.e(this.fpw);
            }
        }
    };
    private long fdd;
    private nu fpj = new nu();
    private c fpk;
    private View fpl;
    private ProgressBar fpm;
    private MMGIFImageView fpn;
    private ImageView fpo;
    private Button fpp;
    private Button fpq;
    private OnClickListener fpr = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

        {
            this.fpw = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            EmojiStoreV2SingleProductDialogUI.a(this.fpw, this.fpw.fpj);
            g.iuh.h(12787, new Object[]{Integer.valueOf(this.fpw.cVh), Integer.valueOf(2), Long.valueOf(this.fpw.fdd)});
        }
    };
    private OnClickListener fps = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

        {
            this.fpw = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            EmojiStoreV2SingleProductDialogUI.b(this.fpw, this.fpw.fpj);
            g.iuh.h(12787, new Object[]{Integer.valueOf(this.fpw.cVh), Integer.valueOf(1), Long.valueOf(this.fpw.fdd)});
        }
    };
    private View.OnClickListener fpt = new View.OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

        {
            this.fpw = r1;
        }

        public final void onClick(View view) {
            this.fpw.setResult(0);
            this.fpw.finish();
            this.fpw.overridePendingTransition(2130968641, 2130968642);
        }
    };
    private i fpu = new i(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

        {
            this.fpw = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            if (bitmap != null && objArr != null && objArr.length > 0 && this.fpw.mHandler != null && objArr[0] != null && (objArr[0] instanceof nu)) {
                nu nuVar = (nu) objArr[0];
                if (this.fpw.fpj != null && nuVar != null && nuVar.mpC.equals(this.fpw.fpj.mpC)) {
                    EmojiStoreV2SingleProductDialogUI.e(this.fpw);
                }
            }
        }
    };
    private com.tencent.mm.sdk.c.c fpv = new com.tencent.mm.sdk.c.c<bz>(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

        {
            this.fpw = r2;
            this.nhz = bz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bz bzVar = (bz) bVar;
            if (bzVar != null && (bzVar instanceof bz) && this.fpw.fpj != null && bzVar.aZx.aZy.equals(this.fpw.fpj.mpC)) {
                EmojiStoreV2SingleProductDialogUI.e(this.fpw);
            }
            return false;
        }
    };
    private ac mHandler = new ac();

    static /* synthetic */ void a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, nu nuVar) {
        if (be.kS(emojiStoreV2SingleProductDialogUI.bZy)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("Retr_Msg_Type", 5);
            intent.putExtra("Retr_Msg_thumb_path", nuVar.mpC);
            intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
            com.tencent.mm.ay.c.a(emojiStoreV2SingleProductDialogUI, ".ui.transmit.SelectConversationUI", intent, 9001);
            emojiStoreV2SingleProductDialogUI.overridePendingTransition(2130968646, 2130968623);
            return;
        }
        emojiStoreV2SingleProductDialogUI.a(emojiStoreV2SingleProductDialogUI.bZy, nuVar);
    }

    static /* synthetic */ void b(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, nu nuVar) {
        if (nuVar != null) {
            c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(nuVar.mpC);
            ak.yW();
            String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), nuVar.mdM, nuVar.mpC);
            if (NF == null && e.aR(A)) {
                int i = o.JZ(A) ? c.nwT : c.nwS;
                c cVar = new c();
                cVar.field_md5 = nuVar.mpC;
                cVar.field_catalog = c.nwM;
                cVar.field_type = i;
                cVar.field_size = e.aQ(A);
                cVar.field_temp = 1;
                cVar.field_designerID = nuVar.mpD;
                cVar.field_thumbUrl = nuVar.hOx;
                com.tencent.mm.plugin.emoji.model.g.afx().fch.p(cVar);
                NF = cVar;
            }
            if (NF != null) {
                com.tencent.mm.plugin.emoji.model.g.aft().a(emojiStoreV2SingleProductDialogUI, NF, 5, k.xF());
                return;
            }
            return;
        }
        v.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "add failed");
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        if (emojiStoreV2SingleProductDialogUI.mHandler != null) {
            emojiStoreV2SingleProductDialogUI.mHandler.post(new Runnable(emojiStoreV2SingleProductDialogUI) {
                final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

                {
                    this.fpw = r1;
                }

                public final void run() {
                    this.fpw.fpm.setVisibility(8);
                    this.fpw.fpn.setVisibility(0);
                    this.fpw.fpk = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.fpw.fpj.mpC);
                    if (this.fpw.fpk == null || (this.fpw.fpk.field_reserved4 & c.nxh) != c.nxh) {
                        this.fpw.fpn.bN(this.fpw.aEZ, null);
                    } else {
                        this.fpw.fpn.d(j.a.bmr().g(this.fpw.fpk), "");
                    }
                    this.fpw.ahi();
                    this.fpw.fpp.setEnabled(true);
                    this.fpw.fpp.setTextColor(this.fpw.getResources().getColor(2131689767));
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130904555);
        this.cVh = getIntent().getIntExtra("scene", 0);
        this.fdd = getIntent().getLongExtra("searchID", 0);
        this.bZy = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                this.fpj = (nu) this.fpj.az(byteArrayExtra);
                if (this.fpj != null) {
                    this.fpk = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.fpj.mpC);
                    if (!(this.fpk == null || be.kS(this.fpk.field_groupId) || !be.kS(this.fpj.mdM))) {
                        this.fpj.mdM = this.fpk.field_groupId;
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.c.a.nhr.e(this.fpv);
            com.tencent.mm.plugin.emoji.model.g.afr().fcN = this.fcN;
            this.fpl = q.em(this).inflate(2130903509, null);
            this.fpm = (ProgressBar) this.fpl.findViewById(2131756738);
            this.fpn = (MMGIFImageView) this.fpl.findViewById(2131756737);
            this.fpo = (ImageView) this.fpl.findViewById(2131756736);
            this.fpo.setOnClickListener(this.fpt);
            this.doc = com.tencent.mm.ui.base.g.a(this, this.fpl, "");
            this.doc.a(getString(2131231149), false, this.fpr);
            this.doc.b(getString(2131230902), false, this.fps);
            this.doc.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ EmojiStoreV2SingleProductDialogUI fpw;

                {
                    this.fpw = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.fpw.setResult(0);
                    this.fpw.finish();
                }
            });
            this.fpp = this.doc.getButton(-1);
            this.fpp.setTextColor(getResources().getColor(2131689767));
            this.fpq = this.doc.getButton(-2);
            ak.yW();
            this.aEZ = EmojiLogic.A(com.tencent.mm.model.c.wY(), this.fpj.mdM, this.fpj.mpC);
            if (e.aQ(this.aEZ) <= 0) {
                this.fpn.setVisibility(0);
                this.fpm.setVisibility(8);
                this.fpk = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.fpj.mpC);
                if (this.fpk == null && (this.fpk.field_reserved4 & c.nxh) == c.nxh) {
                    this.fpn.d(j.a.bmr().g(this.fpk), "");
                } else {
                    this.fpn.bN(this.aEZ, null);
                }
                ahi();
            }
            this.fpn.setVisibility(8);
            this.fpm.setVisibility(0);
            this.fpq.setText(2131232366);
            this.fpp.setText(2131231149);
            this.fpq.setEnabled(false);
            this.fpq.setTextColor(getResources().getColor(2131689773));
            this.fpp.setEnabled(false);
            this.fpp.setTextColor(getResources().getColor(2131689773));
            com.tencent.mm.ae.a.a afq = com.tencent.mm.plugin.emoji.model.g.afq();
            String str = this.fpj.glb;
            String str2 = this.fpj.glb;
            afq.a(str, null, com.tencent.mm.plugin.emoji.d.g.c(this.aEZ, this.fpj), this.fpu);
            return;
        }
        setResult(0);
        finish();
        com.tencent.mm.sdk.c.a.nhr.e(this.fpv);
        com.tencent.mm.plugin.emoji.model.g.afr().fcN = this.fcN;
        this.fpl = q.em(this).inflate(2130903509, null);
        this.fpm = (ProgressBar) this.fpl.findViewById(2131756738);
        this.fpn = (MMGIFImageView) this.fpl.findViewById(2131756737);
        this.fpo = (ImageView) this.fpl.findViewById(2131756736);
        this.fpo.setOnClickListener(this.fpt);
        this.doc = com.tencent.mm.ui.base.g.a(this, this.fpl, "");
        this.doc.a(getString(2131231149), false, this.fpr);
        this.doc.b(getString(2131230902), false, this.fps);
        this.doc.setOnDismissListener(/* anonymous class already generated */);
        this.fpp = this.doc.getButton(-1);
        this.fpp.setTextColor(getResources().getColor(2131689767));
        this.fpq = this.doc.getButton(-2);
        ak.yW();
        this.aEZ = EmojiLogic.A(com.tencent.mm.model.c.wY(), this.fpj.mdM, this.fpj.mpC);
        if (e.aQ(this.aEZ) <= 0) {
            this.fpn.setVisibility(8);
            this.fpm.setVisibility(0);
            this.fpq.setText(2131232366);
            this.fpp.setText(2131231149);
            this.fpq.setEnabled(false);
            this.fpq.setTextColor(getResources().getColor(2131689773));
            this.fpp.setEnabled(false);
            this.fpp.setTextColor(getResources().getColor(2131689773));
            com.tencent.mm.ae.a.a afq2 = com.tencent.mm.plugin.emoji.model.g.afq();
            String str3 = this.fpj.glb;
            String str22 = this.fpj.glb;
            afq2.a(str3, null, com.tencent.mm.plugin.emoji.d.g.c(this.aEZ, this.fpj), this.fpu);
            return;
        }
        this.fpn.setVisibility(0);
        this.fpm.setVisibility(8);
        this.fpk = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.fpj.mpC);
        if (this.fpk == null) {
        }
        this.fpn.bN(this.aEZ, null);
        ahi();
    }

    protected void onResume() {
        super.onResume();
        ahi();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!be.kS(stringExtra) && this.fpj != null) {
                v.d("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "UserName:%s ,MD5:%s", new Object[]{stringExtra, this.fpj.mpC});
                a(stringExtra, this.fpj);
                j.a.bmt().df(intent.getStringExtra("custom_send_text"), stringExtra);
            }
        }
    }

    private void ahi() {
        this.fpk = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(this.fpj.mpC);
        if (this.fpk != null && this.fpk.field_catalog == com.tencent.mm.storage.a.a.nwL && be.kS(this.fpk.field_groupId)) {
            this.fpq.setEnabled(false);
            this.fpq.setText(2131230902);
            this.fpq.setTextColor(getResources().getColor(2131689773));
        } else if (e.aR(this.aEZ)) {
            this.fpq.setEnabled(true);
            this.fpq.setText(2131232366);
            this.fpq.setTextColor(getResources().getColor(2131689767));
        } else {
            this.fpq.setEnabled(false);
            this.fpq.setEnabled(false);
            this.fpq.setText(2131232366);
            this.fpq.setTextColor(getResources().getColor(2131689773));
        }
    }

    private void a(String str, nu nuVar) {
        if (be.kS(str) || nuVar == null) {
            v.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "username or emoji is null.");
            return;
        }
        c cVar;
        c NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(nuVar.mpC);
        if (NF == null) {
            ak.yW();
            String A = EmojiLogic.A(com.tencent.mm.model.c.wY(), nuVar.mdM, nuVar.mpC);
            if (e.aR(A)) {
                NF = com.tencent.mm.plugin.emoji.model.g.afx().fch.a(nuVar.mpC, "", c.nwM, o.JZ(A) ? c.nwT : c.nwS, e.aQ(A), "");
                NF.field_designerID = nuVar.mpD;
                NF.field_thumbUrl = nuVar.hOx;
            }
            cVar = NF;
        } else {
            NF.field_designerID = nuVar.mpD;
            NF.field_thumbUrl = nuVar.hOx;
            cVar = NF;
        }
        for (String str2 : be.g(be.ah(str, "").split(","))) {
            if (cVar != null) {
                com.tencent.mm.plugin.emoji.model.g.aft().a(str2, cVar, null);
                setResult(-1);
                finish();
                overridePendingTransition(2130968641, 2130968642);
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.fpv);
        com.tencent.mm.plugin.emoji.model.g.afr().fcN = null;
        super.onDestroy();
    }
}
