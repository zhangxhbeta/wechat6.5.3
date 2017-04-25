package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.b;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.m;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private long bYN;
    private long dbx = 0;
    public String eyL;
    private m eyM;
    private EnterpriseBizContactListView eyN;
    private ac eyO;
    private boolean eyP = false;

    protected final int getLayoutId() {
        return 2130903527;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eyL = getIntent().getStringExtra("enterprise_biz_name");
        this.bYN = System.currentTimeMillis() / 1000;
        if (this.eyO == null) {
            this.eyO = new ac(this) {
                final /* synthetic */ EnterpriseBizContactListUI eyQ;

                {
                    this.eyQ = r1;
                }

                public final void handleMessage(Message message) {
                    if (message != null && message.what == 1 && this.eyQ != null && !this.eyQ.isFinishing()) {
                        u.DI().a(this.eyQ.eyL, null);
                        u.Dy();
                        List hr = d.hr(this.eyQ.eyL);
                        for (int i = 0; i < hr.size(); i++) {
                            String str = (String) hr.get(i);
                            if (com.tencent.mm.model.m.eC(str) && (e.hD(str) || e.hC(str))) {
                                u.DI().a(str, null);
                            }
                        }
                    }
                }
            };
        } else {
            this.eyO.removeMessages(1);
        }
        this.eyO.sendEmptyMessageDelayed(1, 500);
    }

    protected void onResume() {
        super.onResume();
        if (com.tencent.mm.model.m.eC(this.eyL)) {
            NI();
            if (!this.eyP) {
                int i;
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i2 = -1;
                if (this.eyN != null) {
                    i2 = this.eyN.eyU;
                }
                b gZ = u.DF().gZ(this.eyL);
                if (gZ != null) {
                    i = gZ.field_qyUin;
                } else {
                    i = 0;
                }
                g.iuh.h(12892, new Object[]{this.eyL, Integer.valueOf(intExtra), Integer.valueOf(i2), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i)});
                v.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{this.eyL, Integer.valueOf(intExtra), Integer.valueOf(i2), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i)});
                this.eyP = true;
                return;
            }
            return;
        }
        v.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[]{this.eyL});
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.eyN != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.bYN > 0 && this.dbx > 0) {
            long j = this.dbx - this.bYN;
            b gZ = u.DF().gZ(this.eyL);
            int i = gZ != null ? gZ.field_qyUin : 0;
            int i2 = gZ != null ? gZ.field_userUin : 0;
            g.iuh.h(13465, new Object[]{"", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j)});
            v.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j)});
        }
        super.onDestroy();
    }

    public void finish() {
        this.dbx = System.currentTimeMillis() / 1000;
        super.finish();
    }

    protected final void NI() {
        ak.yW();
        Fd(c.wH().LX(this.eyL).tT());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactListUI eyQ;

            {
                this.eyQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eyQ.axg();
                this.eyQ.finish();
                return true;
            }
        });
        if (!be.kS(this.eyL)) {
            BizInfo hw = e.hw(this.eyL);
            if (hw != null && hw.Cz()) {
                a(1, 2131230800, 2131165188, new OnMenuItemClickListener(this) {
                    final /* synthetic */ EnterpriseBizContactListUI eyQ;

                    {
                        this.eyQ = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (this.eyQ.eyM != null) {
                            this.eyQ.eyM.dismiss();
                            this.eyQ.eyM = null;
                        }
                        this.eyQ.eyM = new m(this.eyQ.nDR.nEl);
                        this.eyQ.eyM.jXn = new n.c(this) {
                            final /* synthetic */ AnonymousClass2 eyR;

                            {
                                this.eyR = r1;
                            }

                            public final void a(l lVar) {
                                lVar.S(1, 2131232472, 2131165195);
                                lVar.S(2, 2131232155, 2131165801);
                                lVar.S(3, 2131232463, 2131165196);
                                lVar.S(4, 2131230801, 2131165208);
                            }
                        };
                        this.eyQ.eyM.jXo = new n.d(this) {
                            final /* synthetic */ AnonymousClass2 eyR;

                            {
                                this.eyR = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        intent = new Intent();
                                        intent.putExtra("from_userName", this.eyR.eyQ.eyL);
                                        com.tencent.mm.ay.c.b(this.eyR.eyQ.nDR.nEl, "setting", ".ui.setting.SelfQRCodeUI", intent);
                                        return;
                                    case 2:
                                        intent = new Intent();
                                        intent.putExtra("Select_Talker_Name", this.eyR.eyQ.eyL);
                                        intent.putExtra("Select_block_List", this.eyR.eyQ.eyL);
                                        intent.putExtra("Select_Send_Card", true);
                                        intent.putExtra("Select_Conv_Type", 3);
                                        com.tencent.mm.ay.c.a(this.eyR.eyQ, ".ui.transmit.SelectConversationUI", intent, 1);
                                        return;
                                    case 3:
                                        intent = new Intent(this.eyR.eyQ, EnterpriseBizContactPlainListUI.class);
                                        intent.putExtra("enterprise_biz_name", this.eyR.eyQ.eyL);
                                        intent.putExtra("enterprise_scene", 2);
                                        this.eyR.eyQ.startActivity(intent);
                                        return;
                                    case 4:
                                        intent = new Intent();
                                        intent.putExtra("Contact_User", this.eyR.eyQ.eyL);
                                        a.drp.d(intent, this.eyR.eyQ);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        this.eyQ.eyM.dQ();
                        return false;
                    }
                });
            }
        }
        this.eyN = (EnterpriseBizContactListView) findViewById(2131756769);
        this.eyN.eyL = this.eyL;
        this.eyN.eyS = false;
        this.eyN.refresh();
        this.eyN.Yw();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    j.a.bmt().m(stringExtra, stringExtra2, booleanExtra);
                    j.a.bmt().df(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.f(this, this.nDR.nEl.getString(2131232839));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
