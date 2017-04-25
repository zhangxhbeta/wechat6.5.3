package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.favorite.ui.base.FavVoiceBaseView;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.f;

public class FavoriteVoiceDetailUI extends MMActivity implements a {
    private i fLP;
    private u fMi;
    private long fRB;
    private FavVoiceBaseView fRQ;
    private FavDetailTitleView fRc;
    private FavDetailFooterView fRd;
    private FavTagEntrance fRe;

    protected final int getLayoutId() {
        return 2130903630;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(getString(2131232643));
        this.fRB = getIntent().getLongExtra("key_detail_info_id", -1);
        this.fLP = h.alu().bB(this.fRB);
        if (this.fLP == null) {
            v.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            this.fRc = (FavDetailTitleView) findViewById(2131756929);
            this.fRc.x(this.fLP);
            this.fRd = (FavDetailFooterView) findViewById(2131756928);
            this.fRd.x(this.fLP);
            this.fMi = new u();
            this.fRQ = (FavVoiceBaseView) findViewById(2131757008);
            u.a aVar = this.fRQ;
            aVar.fMi = this.fMi;
            aVar.fMi.a(aVar);
            pw n = com.tencent.mm.plugin.favorite.b.v.n(this.fLP);
            String f = com.tencent.mm.plugin.favorite.b.v.f(n);
            int sZ = com.tencent.mm.plugin.favorite.b.v.sZ(n.msh);
            if (!e.aR(f)) {
                com.tencent.mm.plugin.favorite.b.v.m(this.fLP);
            }
            this.fRQ.y(f, sZ, n.duration);
            this.fRe = (FavTagEntrance) findViewById(2131757005);
            this.fRe.bQ(this.fLP.field_localId);
            this.fRe.av(this.fLP.field_tagProto.mub);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ FavoriteVoiceDetailUI fRR;

                {
                    this.fRR = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.fRR.finish();
                    return true;
                }
            });
            a(0, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ FavoriteVoiceDetailUI fRR;

                {
                    this.fRR = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    f fVar = new f(this.fRR.nDR.nEl, f.pbS, false);
                    fVar.jXn = new c(this) {
                        final /* synthetic */ AnonymousClass2 fRS;

                        {
                            this.fRS = r1;
                        }

                        public final void a(l lVar) {
                            lVar.d(0, this.fRS.fRR.getString(2131232647));
                            lVar.d(1, this.fRS.fRR.nDR.nEl.getString(2131231020));
                        }
                    };
                    fVar.jXo = new d(this) {
                        final /* synthetic */ AnonymousClass2 fRS;

                        {
                            this.fRS = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent(this.fRS.fRR.nDR.nEl, FavTagEditUI.class);
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", this.fRS.fRR.fLP.field_localId);
                                    this.fRS.fRR.nDR.nEl.startActivity(intent);
                                    return;
                                case 1:
                                    g.a(this.fRS.fRR.nDR.nEl, this.fRS.fRR.getString(2131231021), "", new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 fRT;

                                        {
                                            this.fRT = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            final p a = g.a(this.fRT.fRS.fRR.nDR.nEl, this.fRT.fRS.fRR.getString(2131231021), false, null);
                                            final long j = this.fRT.fRS.fRR.fLP.field_localId;
                                            final long j2 = (long) this.fRT.fRS.fRR.fLP.field_id;
                                            com.tencent.mm.plugin.favorite.b.v.a(this.fRT.fRS.fRR.fLP.field_localId, new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 fRW;

                                                public final void run() {
                                                    a.dismiss();
                                                    v.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
                                                    this.fRW.fRT.fRS.fRR.finish();
                                                }
                                            });
                                        }
                                    }, null);
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
        h.alu().c(this);
        if (this.fRe != null) {
            h.alu().c(this.fRe);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fRQ.XV();
        this.fMi.destroy();
        h.alu().d(this);
        if (this.fRe != null) {
            h.alu().d(this.fRe);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.fRQ.alO();
        this.fMi.pause();
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        this.fLP = h.alu().bB(this.fRB);
        if (this.fLP == null) {
            v.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
        } else if (this.fLP.field_favProto.mtR.size() > 0) {
            pw n = com.tencent.mm.plugin.favorite.b.v.n(this.fLP);
            this.fRQ.y(com.tencent.mm.plugin.favorite.b.v.f(n), com.tencent.mm.plugin.favorite.b.v.sZ(n.msh), n.duration);
        }
    }
}
