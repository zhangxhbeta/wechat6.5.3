package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.e.p;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;

public final class f {
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    private Context aHq = aa.getContext();
    public com.tencent.mm.plugin.emoji.a.a.a fcY;
    public boolean fcZ = false;
    public Context fda;
    public Fragment fdb;
    public int fdc;
    public long fdd = 0;
    public String fde = "";
    public b fdf;
    private String fdg;
    private com.tencent.mm.plugin.emoji.h.b fdh = new com.tencent.mm.plugin.emoji.h.b(2003);
    public String fdi;

    public interface a {
        void a(com.tencent.mm.plugin.emoji.a.a aVar);
    }

    public interface b {
        void B(String str, String str2, String str3);

        void afo();
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar != null && aVar.eYF != null && this.fcY != null && this.fcY.eZW != null) {
            ol olVar = aVar.eYF.fai;
            if (olVar != null) {
                String str;
                String str2 = olVar.mdM;
                String str3 = olVar.mqd;
                String str4 = olVar.mqo;
                String str5 = olVar.mqp;
                int aey = aVar.aey();
                (aVar.eYF == null ? null : Integer.valueOf(aVar.eYF.fak)).intValue();
                c cVar = this.fcY.eZW;
                boolean z = cVar.faf;
                boolean z2 = aVar.eYF.fam;
                String str6 = "MicroMsg.emoji.PayOrDownloadComponent";
                String str7 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    str = str4;
                }
                objArr[1] = str;
                objArr[2] = Integer.valueOf(aey);
                v.i(str6, str7, objArr);
                this.fdg = str2;
                int i;
                ah rb;
                switch (aey) {
                    case -1:
                        if (e.a(olVar)) {
                            i = 3;
                        } else if (e.b(olVar) || (!z && TextUtils.isEmpty(olVar.mqg))) {
                            i = 3;
                        } else if (z) {
                            rb = cVar.rb(str2);
                            if (TextUtils.isEmpty(rb.nvf)) {
                                i = rb.nvd;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 4;
                        }
                        this.fcY.an(str2, i);
                        return;
                    case 0:
                        if (this.fcY != null) {
                            this.fcY.an(str2, 3);
                            return;
                        }
                        return;
                    case 3:
                    case 5:
                        if (com.tencent.mm.plugin.emoji.h.a.d(olVar)) {
                            com.tencent.mm.plugin.emoji.e.a.afC();
                            com.tencent.mm.plugin.emoji.e.a.afD();
                            return;
                        }
                        B(str2, null, str3);
                        if (this.fcY != null) {
                            this.fcY.ao(str2, 0);
                        }
                        v.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        g.iuh.h(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(this.fdc), "", str2, Long.valueOf(this.fdd), this.fde});
                        return;
                    case 4:
                    case 12:
                        if (!this.fcZ) {
                            Intent intent = new Intent();
                            intent.putExtra("key_product_id", str2);
                            if (z) {
                                intent.putExtra("key_currency_type", "");
                                intent.putExtra("key_price", str4);
                            } else {
                                intent.putExtra("key_currency_type", str5);
                                intent.putExtra("key_price", str4);
                            }
                            com.tencent.mm.ay.c.b(this.fda, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                            this.fcZ = true;
                            g.iuh.h(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.fdc), "", str2, Long.valueOf(this.fdd), this.fde});
                            return;
                        }
                        return;
                    case 7:
                        if (z2) {
                            if ((this.fdb != null ? 1 : null) != null) {
                                com.tencent.mm.plugin.emoji.h.b bVar = this.fdh;
                                Fragment fragment = this.fdb;
                                v.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                                Intent intent2 = new Intent();
                                intent2.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                                intent2.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                                com.tencent.mm.ay.c.a(fragment, ".ui.transmit.SelectConversationUI", intent2, bVar.dRo);
                                fragment.aG().overridePendingTransition(2130968646, 2130968623);
                            } else {
                                this.fdh.q((Activity) this.fda);
                            }
                            this.fdh.fqT = str2;
                            g.iuh.h(12069, new Object[]{Integer.valueOf(1), str2});
                            return;
                        } else if (aVar.eYF.fao) {
                            str4 = aVar.eYF.fai.mdM;
                            String str8 = aVar.eYF.fai.mqd;
                            str2 = this.fdi;
                            if (this.fda != null) {
                                i = this.fdc == 9 ? 3 : 4;
                                Intent intent3 = new Intent();
                                intent3.setClass(this.fda, EmojiStoreV2RewardUI.class);
                                intent3.putExtra("extra_id", str4);
                                intent3.putExtra("extra_name", str8);
                                intent3.putExtra("name", str2);
                                intent3.putExtra("scene", this.fdc);
                                intent3.putExtra("pageType", i);
                                intent3.putExtra("searchID", this.fdd);
                                this.fda.startActivity(intent3);
                                g.iuh.h(12738, new Object[]{str4, Integer.valueOf(i), Integer.valueOf(this.fdc), Integer.valueOf(0)});
                                return;
                            }
                            v.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                            return;
                        } else {
                            return;
                        }
                    case 9:
                        ak.vy().a(new p(str2, 2), 0);
                        return;
                    case 10:
                        rb = cVar.rb(str2);
                        if (rb != null) {
                            switch (rb.nve) {
                                case 10233:
                                    str = getString(2131232348);
                                    break;
                                case 10234:
                                    str = getString(2131232344);
                                    break;
                                case 10235:
                                    str = getString(2131232438);
                                    break;
                                default:
                                    str = getString(2131232443);
                                    break;
                            }
                            com.tencent.mm.ui.base.g.A(this.fda, str, null);
                            return;
                        }
                        return;
                    case 11:
                        v.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                        return;
                    default:
                        v.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                        return;
                }
            }
        }
    }

    private void B(String str, String str2, String str3) {
        if (this.fdf != null) {
            this.fdf.B(str, str2, str3);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            v.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:" + i3);
            str = intent.getStringExtra("key_err_msg");
            v.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:" + str);
        }
        String str2 = str;
        this.fcZ = false;
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    if (this.fcY != null && this.fcY.eZW != null) {
                        if (intent != null && r0 == 0) {
                            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                            Object obj = null;
                            int size = stringArrayListExtra.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj2;
                                String str3 = (String) stringArrayListExtra.get(i4);
                                str = (String) stringArrayListExtra2.get(i4);
                                ah rb = this.fcY.eZW.rb(str3);
                                if (this.fdg.equals(str3)) {
                                    obj = 1;
                                    B(str3, str, rb.fkg);
                                    this.fcY.ao(this.fdg, 0);
                                    com.tencent.mm.ui.base.g.bf(this.fda, str2);
                                    v.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str3});
                                    if (stringArrayListExtra.size() > 1) {
                                        v.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                        if (this.fdf != null) {
                                            this.fdf.afo();
                                            obj2 = 1;
                                        }
                                    }
                                    obj2 = obj;
                                } else {
                                    this.fcY.an(this.fdg, 5);
                                    obj2 = obj;
                                }
                                i4++;
                                obj = obj2;
                            }
                            if (obj == null) {
                                rC(str2);
                            }
                            if (k.xS()) {
                                g.iuh.a(166, 4, 1, false);
                                return;
                            } else {
                                g.iuh.a(166, 0, 1, false);
                                return;
                            }
                        } else if (intent != null && r0 == 103) {
                            B(this.fdg, null, this.fcY.eZW.rb(this.fdg).fkg);
                            this.fcY.ao(this.fdg, 0);
                            v.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{this.fdg});
                            rC(str2);
                            if (k.xS()) {
                                g.iuh.a(166, 7, 1, false);
                                return;
                            } else {
                                g.iuh.a(166, 3, 1, false);
                                return;
                            }
                        } else if (intent == null || r0 != 100000000) {
                            if (!(this.fdg == null || this.fcY == null || this.fcY.eZW == null)) {
                                this.fcY.eZW.qZ(this.fdg);
                                com.tencent.mm.plugin.emoji.a.a qX = this.fcY.qX(this.fdg);
                                if (qX != null) {
                                    qX.aeD();
                                }
                            }
                            rC(str2);
                            if (k.xS()) {
                                g.iuh.a(166, 5, 1, false);
                            } else {
                                g.iuh.a(166, 1, 1, false);
                            }
                            v.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[]{str2});
                            return;
                        } else {
                            if (k.xS()) {
                                g.iuh.a(166, 6, 1, false);
                            } else {
                                g.iuh.a(166, 2, 1, false);
                            }
                            v.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                            return;
                        }
                    }
                    return;
                case 2003:
                    str = this.fdh.fqT;
                    if (!be.kS(str)) {
                        com.tencent.mm.plugin.emoji.h.b.a(intent, str, (Activity) this.fda);
                        g.iuh.h(12069, new Object[]{Integer.valueOf(3), str});
                        return;
                    }
                    return;
                default:
                    v.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                    return;
            }
        } else if (i != 2001) {
        } else {
            if (k.xS()) {
                g.iuh.a(166, 6, 1, false);
            } else {
                g.iuh.a(166, 2, 1, false);
            }
        }
    }

    private void rC(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(2131232352);
        }
        com.tencent.mm.ui.base.g.a(this.fda, str, "", new OnClickListener(this) {
            final /* synthetic */ f fdj;

            {
                this.fdj = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private String getString(int i) {
        return this.aHq.getString(i);
    }
}
