package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.n;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.k;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int cVh;
    private int fjl;
    private String fjm;
    private String fjn;
    private String fjo;
    private String fjp;
    private String fjq;

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        f fVar = new f(emojiStoreTopicUI.nDR.nEl, f.pbS, false);
        fVar.jXn = new c(emojiStoreTopicUI) {
            final /* synthetic */ EmojiStoreTopicUI fjr;

            {
                this.fjr = r1;
            }

            public final void a(l lVar) {
                lVar.a(1001, this.fjr.getString(2131236669), 2131165344);
                lVar.a(1000, this.fjr.getString(2131236668), 2131165334);
            }
        };
        fVar.jXo = new d(emojiStoreTopicUI) {
            final /* synthetic */ EmojiStoreTopicUI fjr;

            {
                this.fjr = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        ActionBarActivity actionBarActivity = this.fjr.nDR.nEl;
                        String a = this.fjr.fjm;
                        String e = this.fjr.fjo;
                        String b = this.fjr.fjn;
                        g.aft();
                        com.tencent.mm.plugin.emoji.d.l.a(actionBarActivity, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(this.fjr.fjl, this.fjr.fjm, this.fjr.fjo, this.fjr.fjn, this.fjr.fjp, 0), 13);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(this.fjr.fjl)});
                        return;
                    case 1001:
                        com.tencent.mm.plugin.emoji.d.l.bB(this.fjr.nDR.nEl);
                        this.fjr.nDR.nEl.overridePendingTransition(2130968646, 2130968623);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(this.fjr.fjl)});
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.fjl)});
    }

    protected final void agb() {
        super.agb();
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.iuh.h(12740, new Object[]{Integer.valueOf(3), "", "", Integer.valueOf(this.fjl), Integer.valueOf(this.cVh)});
    }

    protected final void NI() {
        this.fjl = getIntent().getIntExtra("topic_id", -1);
        this.fjm = getIntent().getStringExtra("topic_name");
        this.fjp = getIntent().getStringExtra("topic_ad_url");
        this.fjn = getIntent().getStringExtra("topic_icon_url");
        this.fjo = getIntent().getStringExtra("topic_desc");
        this.fjq = getIntent().getStringExtra("sns_object_data");
        this.cVh = getIntent().getIntExtra("extra_scence", 0);
        if (!be.kS(this.fjq)) {
            this.fjl = EmojiLogic.ru(this.fjq);
            this.fjm = EmojiLogic.rv(this.fjq);
            this.fjn = EmojiLogic.rx(this.fjq);
            this.fjo = EmojiLogic.rw(this.fjq);
            this.fjp = EmojiLogic.ry(this.fjq);
        }
        Fd(this.fjm);
        super.NI();
        a(0, 2131165801, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreTopicUI fjr;

            {
                this.fjr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
                if (be.kS(this.fjr.fjm) || be.kS(this.fjr.fjn)) {
                    v.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
                } else {
                    EmojiStoreTopicUI.c(this.fjr);
                }
                return true;
            }
        });
        V(0, false);
        rH(this.fjp);
    }

    protected final void rH(String str) {
        if (this.ffB != null && this.ffC != null && !be.kS(str)) {
            a.getDensity(this);
            com.tencent.mm.storage.a.c a = EmojiLogic.a("Toptic", 8, str, true);
            if (a == null) {
                n.GL().a(str, null, com.tencent.mm.plugin.emoji.d.g.b("Toptic", str, new Object[]{"Toptic", "BANNER"}), new i(this) {
                    final /* synthetic */ EmojiStoreTopicUI fjr;

                    {
                        this.fjr = r1;
                    }

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        EmojiBaseActivity emojiBaseActivity = this.fjr;
                        if (emojiBaseActivity.fgR != null) {
                            emojiBaseActivity.fgR.sendEmptyMessage(1009);
                        }
                    }
                });
                return;
            }
            this.ffC.bN(a.dR(a.field_groupId, a.EB()), null);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void a(e eVar, boolean z, boolean z2) {
        super.a(eVar, z, z2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        agt();
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!be.kS(stringExtra)) {
                v.d("MicroMsg.emoji.EmojiStoreTopicUI", ".." + stringExtra);
                int i3 = this.fjl;
                String str = this.fjm;
                String str2 = this.fjo;
                String str3 = this.fjn;
                String str4 = this.fjp;
                g.aft();
                com.tencent.mm.plugin.emoji.d.l.a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(boolean z, e eVar, boolean z2, boolean z3) {
        super.a(z, eVar, z2, z3);
    }

    protected final int agm() {
        return 7;
    }

    public final int agn() {
        return this.fjl;
    }

    protected final boolean agw() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a age() {
        return new com.tencent.mm.plugin.emoji.a.f(this.nDR.nEl);
    }

    protected final boolean agk() {
        if (be.kS(this.fjp)) {
            return false;
        }
        return true;
    }

    protected final boolean agj() {
        return false;
    }

    public final void g(Message message) {
        super.g(message);
        if (message.what == 1009) {
            rH(this.fjp);
        }
    }

    protected final int agc() {
        return 11;
    }

    protected final int agd() {
        return 14;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (this.ffF) {
            V(0, false);
        } else {
            V(0, true);
        }
    }
}
