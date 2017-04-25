package com.tencent.mm.plugin.wenote.ui.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.f;

public class WNNoteMsgWebViewUI extends WNNoteWebViewBaseUI {
    private long bao = -1;
    private String bmh = null;

    protected final void aqj() {
        super.aqj();
    }

    protected final void NI() {
        this.bao = getIntent().getLongExtra("message_id", -1);
        this.bmh = getIntent().getStringExtra("record_xml");
        super.NI();
        Fd(getString(2131232756));
        iV(true);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteMsgWebViewUI lvs;

            {
                this.lvs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lvs.finish();
                return true;
            }
        }, 2130837595);
        a(1, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteMsgWebViewUI lvs;

            {
                this.lvs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f fVar = new f(this.lvs.nDR.nEl, f.pbS, false);
                fVar.jXn = new c(this) {
                    final /* synthetic */ AnonymousClass2 lvt;

                    {
                        this.lvt = r1;
                    }

                    public final void a(l lVar) {
                        if (this.lvt.lvs.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                            lVar.d(0, this.lvt.lvs.getString(2131232731));
                        }
                        lVar.d(3, this.lvt.lvs.getString(2131234180));
                    }
                };
                fVar.jXo = new d(this) {
                    final /* synthetic */ AnonymousClass2 lvt;

                    {
                        this.lvt = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("Retr_Msg_Type", 2);
                                intent.putExtra("Retr_Msg_Id", this.lvt.lvs.bao);
                                com.tencent.mm.ay.c.a(this.lvt.lvs, ".ui.transmit.SelectConversationUI", intent, 4096);
                                return;
                            case 3:
                                if (this.lvt.lvs.liH != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putLong("msgId", this.lvt.lvs.bao);
                                    try {
                                        com.tencent.mm.pluginsdk.model.c.a(this.lvt.lvs.liH.i(63, bundle).getInt("ret", 0), 37, this.lvt.lvs);
                                        return;
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.WNNoteMsgWebViewUI", e, "", new Object[0]);
                                        return;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                fVar.bKh();
                return false;
            }
        });
        this.lvw.setVisibility(8);
    }

    public void onStart() {
        if (this.lvx) {
            this.lvx = false;
            this.lvv.setVisibility(0);
        }
        super.onStart();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void n(int i, Bundle bundle) {
        super.n(i, bundle);
        switch (i) {
            case 41:
                this.lkl.hH(false);
                return;
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.WNNoteMsgWebViewUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1002:
                    if (intent.getBooleanExtra("kfavorite", false)) {
                        bp bpVar = new bp();
                        com.tencent.mm.pluginsdk.model.d.a(bpVar, intent);
                        bpVar.aZd.aXH = this;
                        a.nhr.z(bpVar);
                        return;
                    }
                    return;
                case 4096:
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
                    if (be.kS(stringExtra)) {
                        v.w("MicroMsg.WNNoteMsgWebViewUI", "want to send record msg, but toUser is null");
                        return;
                    }
                    this.lvu = g.a(this.nDR.nEl, getString(2131232670), false, null);
                    if (this.liH != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("username", stringExtra);
                        bundle.putBoolean("fromsession", true);
                        bundle.putLong("msgId", this.bao);
                        bundle.putString("customText", stringExtra2);
                        try {
                            this.liH.i(62, bundle);
                            return;
                        } catch (Throwable e) {
                            v.a("MicroMsg.WNNoteMsgWebViewUI", e, "", new Object[0]);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void Fd(String str) {
        super.Fd(getString(2131232756));
    }
}
