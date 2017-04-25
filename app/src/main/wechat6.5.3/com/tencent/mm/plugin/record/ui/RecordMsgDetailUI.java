package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.f;

public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private long bao = -1;
    private String bmh = null;
    private c iqr = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void aJJ() {
        this.bao = getIntent().getLongExtra("message_id", -1);
        this.bmh = getIntent().getStringExtra("record_xml");
        this.iqr = m.yy(this.bmh);
        a fVar = new f();
        fVar.ipS = this.iqr.cqE;
        fVar.bao = this.bao;
        fVar.bmh = this.bmh;
        super.aJJ();
        this.iqo.a(fVar);
        s.aJE().a((e) this.iqo);
    }

    protected final h aJK() {
        return new e(this, new g());
    }

    protected void onDestroy() {
        super.onDestroy();
        s.aJE().b((e) this.iqo);
    }

    protected final String aJL() {
        return be.ah(this.iqr.title, "");
    }

    protected final String aJM() {
        return ((pw) this.iqr.cqE.getFirst()).msQ;
    }

    protected final String aJN() {
        return ((pw) this.iqr.cqE.getLast()).msQ;
    }

    protected final void aJO() {
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgDetailUI iqs;

            {
                this.iqs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f fVar = new f(this.iqs.nDR.nEl, f.pbS, false);
                fVar.jXn = new n.c(this) {
                    final /* synthetic */ AnonymousClass1 iqt;

                    {
                        this.iqt = r1;
                    }

                    public final void a(l lVar) {
                        lVar.d(0, this.iqt.iqs.getString(2131232731));
                        lVar.d(2, this.iqt.iqs.getString(2131234180));
                    }
                };
                fVar.jXo = new d(this) {
                    final /* synthetic */ AnonymousClass1 iqt;

                    {
                        this.iqt = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("Retr_Msg_Type", 10);
                                intent.putExtra("Retr_Msg_Id", this.iqt.iqs.bao);
                                com.tencent.mm.ay.c.a(this.iqt.iqs, ".ui.transmit.SelectConversationUI", intent, 1001);
                                return;
                            case 2:
                                bp bpVar = new bp();
                                com.tencent.mm.pluginsdk.model.d.a(bpVar, this.iqt.iqs.bao);
                                bpVar.aZd.aZl = 9;
                                bpVar.aZd.aXH = this.iqt.iqs;
                                a.nhr.z(bpVar);
                                return;
                            default:
                                return;
                        }
                    }
                };
                fVar.bKh();
                return true;
            }
        });
    }

    protected final void b(int i, int i2, Intent intent) {
        if (-1 != i2) {
            v.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[]{Integer.valueOf(i2)});
        } else if (1001 == i) {
            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (be.kS(stringExtra)) {
                v.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                return;
            }
            ak.yW();
            final at ek = com.tencent.mm.model.c.wJ().ek(this.bao);
            if (ek.field_msgId != this.bao) {
                v.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
                return;
            }
            final p a = g.a(this.nDR.nEl, getString(2131232670), false, null);
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ RecordMsgDetailUI iqs;

                public final void run() {
                    m.a(stringExtra, stringExtra2, ek);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 iqv;

                        {
                            this.iqv = r1;
                        }

                        public final void run() {
                            a.dismiss();
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|onActivityResult";
                }
            });
        } else if (1002 == i && intent.getBooleanExtra("kfavorite", false)) {
            bp bpVar = new bp();
            com.tencent.mm.pluginsdk.model.d.a(bpVar, intent);
            bpVar.aZd.aXH = this;
            bpVar.aZd.aZl = 8;
            a.nhr.z(bpVar);
        }
    }
}
