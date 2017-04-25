package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.as.u;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.favorite.b.b.a;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.o;
import com.tencent.mm.plugin.favorite.b.t;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.f;

public class FavoriteSightDetailUI extends MMActivity implements a, g.a {
    private pw bdE;
    private o fOv = new o();
    private i fOz;
    private MMPinProgressBtn fRA;
    private long fRB;
    private FavDetailTitleView fRu;
    private FavDetailFooterView fRv;
    private FavTagEntrance fRw;
    private View fRx;
    private com.tencent.mm.plugin.sight.decode.a.a fRy;
    private ImageView fRz;

    protected final int getLayoutId() {
        return 2130903627;
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRB = getIntent().getLongExtra("key_detail_info_id", -1);
        this.fOz = h.alu().bB(this.fRB);
        if (this.fOz == null) {
            v.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.fRB)});
            finish();
            return;
        }
        t.j(this.fOz);
        this.bdE = com.tencent.mm.plugin.favorite.b.v.n(this.fOz);
        this.fRu = (FavDetailTitleView) findViewById(2131756929);
        this.fRv = (FavDetailFooterView) findViewById(2131756928);
        this.fRw = (FavTagEntrance) findViewById(2131757005);
        this.fRy = (com.tencent.mm.plugin.sight.decode.a.a) findViewById(2131755052);
        this.fRz = (ImageView) findViewById(2131755281);
        this.fRA = (MMPinProgressBtn) findViewById(2131758183);
        this.fRx = findViewById(2131759207);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493067) * 2;
        this.fRy.pv(Math.min(displayMetrics.widthPixels - dimensionPixelSize, displayMetrics.heightPixels - dimensionPixelSize));
        this.fRw.bQ(this.fOz.field_localId);
        this.fRw.av(this.fOz.field_tagProto.mub);
        this.fRu.x(this.fOz);
        this.fRv.x(this.fOz);
        this.fRx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI fRC;

            {
                this.fRC = r1;
            }

            public final void onClick(View view) {
                if (!u.bj(view.getContext()) && !com.tencent.mm.ah.a.aT(view.getContext())) {
                    v.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(this.fRC.fOz.field_id), Long.valueOf(this.fRC.fOz.field_localId), Integer.valueOf(this.fRC.fOz.field_itemStatus)});
                    if (this.fRC.fOz.isDone()) {
                        if (com.tencent.mm.plugin.favorite.b.v.c(this.fRC.bdE)) {
                            t.a(t.a.EnterFullScreen, this.fRC.fOz);
                            Intent intent = new Intent(view.getContext(), FavoriteFileDetailUI.class);
                            intent.putExtra("key_detail_info_id", this.fRC.fOz.field_localId);
                            intent.putExtra("key_detail_data_id", this.fRC.bdE.luu);
                            intent.putExtra("key_detail_can_delete", false);
                            view.getContext().startActivity(intent);
                            return;
                        } else if (be.kS(this.fRC.bdE.mrS)) {
                            com.tencent.mm.ui.base.g.bf(this.fRC.nDR.nEl, this.fRC.getString(2131232718));
                            return;
                        } else {
                            v.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                        }
                    } else if (this.fRC.fOz.alD()) {
                        if (be.kS(this.fRC.bdE.mrS)) {
                            com.tencent.mm.ui.base.g.bf(this.fRC.nDR.nEl, this.fRC.getString(2131232718));
                            return;
                        }
                    } else if (!this.fRC.fOz.alC()) {
                        if (this.fRC.fOz.alA()) {
                            return;
                        }
                    } else {
                        return;
                    }
                    if (this.fRC.fOz.alB()) {
                        com.tencent.mm.plugin.favorite.b.v.l(this.fRC.fOz);
                    } else {
                        com.tencent.mm.plugin.favorite.b.v.m(this.fRC.fOz);
                    }
                }
            }
        });
        Fd(getString(2131232643));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI fRC;

            {
                this.fRC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fRC.finish();
                return true;
            }
        });
        a(0, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI fRC;

            {
                this.fRC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f fVar = new f(this.fRC.nDR.nEl, f.pbS, false);
                fVar.jXn = new c(this) {
                    final /* synthetic */ AnonymousClass3 fRD;

                    {
                        this.fRD = r1;
                    }

                    public final void a(l lVar) {
                        int i = (!this.fRD.fRC.fOz.aly() || this.fRD.fRC.fOv.g(this.fRD.fRC.fOz)) ? 0 : 1;
                        if (i != 0) {
                            lVar.d(0, this.fRD.fRC.getString(2131232731));
                        }
                        lVar.d(3, this.fRD.fRC.getString(2131232647));
                        lVar.d(2, this.fRD.fRC.nDR.nEl.getString(2131231020));
                    }
                };
                fVar.jXo = new d(this) {
                    final /* synthetic */ AnonymousClass3 fRD;

                    {
                        this.fRD = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", this.fRD.fRC.fOz.field_localId);
                                com.tencent.mm.ay.c.a(this.fRD.fRC.nDR.nEl, ".ui.transmit.SelectConversationUI", intent, 1);
                                return;
                            case 2:
                                com.tencent.mm.ui.base.g.a(this.fRD.fRC.nDR.nEl, this.fRD.fRC.getString(2131231021), "", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 fRE;

                                    {
                                        this.fRE = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = com.tencent.mm.ui.base.g.a(this.fRE.fRD.fRC.nDR.nEl, this.fRE.fRD.fRC.getString(2131231021), false, null);
                                        com.tencent.mm.plugin.favorite.b.v.a(this.fRE.fRD.fRC.fOz.field_localId, new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 fRF;

                                            public final void run() {
                                                a.dismiss();
                                                v.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(this.fRF.fRE.fRD.fRC.fOz.field_localId), Integer.valueOf(this.fRF.fRE.fRD.fRC.fOz.field_id)});
                                                this.fRF.fRE.fRD.fRC.finish();
                                            }
                                        });
                                    }
                                }, null);
                                return;
                            case 3:
                                intent = new Intent(this.fRD.fRC.nDR.nEl, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.fRD.fRC.fOz.field_localId);
                                this.fRD.fRC.nDR.nEl.startActivity(intent);
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
        h.alu().c(this.fRw);
        h.alu().c(this);
        h.alp().a((a) this);
    }

    protected void onDestroy() {
        if (this.fRw != null) {
            h.alu().d(this.fRw);
        }
        h.alu().d(this);
        h.alp().b((a) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        dc(false);
    }

    protected void onPause() {
        super.onPause();
        this.fRy.clear();
    }

    private void dc(boolean z) {
        if (this.fOz.isDone()) {
            if (com.tencent.mm.plugin.favorite.b.v.c(this.bdE)) {
                this.fRz.setVisibility(8);
                this.fRA.setVisibility(8);
                String f = com.tencent.mm.plugin.favorite.b.v.f(this.bdE);
                if (!f.equals(this.fRy.aOV())) {
                    this.fRy.s(com.tencent.mm.plugin.favorite.c.g.a(this.bdE, this.fOz));
                }
                this.fRy.ag(f, false);
                return;
            } else if (be.kS(this.bdE.mrS)) {
                this.fRz.setImageResource(2130839161);
            } else {
                v.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                this.fRz.setImageResource(2131165914);
            }
        } else if (this.fOz.alD()) {
            if (be.kS(this.bdE.mrS)) {
                this.fRz.setImageResource(2130839161);
                if (z) {
                    com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(2131232718));
                }
            } else {
                this.fRz.setImageResource(2131165914);
                if (z) {
                    com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(2131232297));
                }
            }
        } else if (this.fOz.alB()) {
            this.fRz.setImageResource(2131165914);
            if (z) {
                com.tencent.mm.ui.base.g.bf(this.nDR.nEl, getString(2131235726));
            }
        } else if (this.fOz.alC() || this.fOz.alA()) {
            this.fRz.setVisibility(8);
            this.fRA.setVisibility(0);
            com.tencent.mm.plugin.favorite.b.a sL = h.alp().sL(this.bdE.luu);
            if (sL != null) {
                this.fRA.setProgress((int) (sL.getProgress() * 100.0f));
            } else {
                this.fRA.setProgress(0);
            }
            this.fRy.clear();
            this.fRy.s(com.tencent.mm.plugin.favorite.c.g.a(this.bdE, this.fOz));
            return;
        } else {
            v.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            this.fRz.setImageResource(2131165914);
        }
        this.fRz.setVisibility(0);
        this.fRA.setVisibility(8);
        this.fRy.clear();
        this.fRy.s(com.tencent.mm.plugin.favorite.c.g.a(this.bdE, this.fOz));
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        v.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.fOz.field_localId)});
        i bB = h.alu().bB(this.fOz.field_localId);
        if (bB == null) {
            v.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            return;
        }
        this.fOz = bB;
        this.bdE = com.tencent.mm.plugin.favorite.b.v.n(bB);
        ad.o(new Runnable(this) {
            final /* synthetic */ FavoriteSightDetailUI fRC;

            {
                this.fRC = r1;
            }

            public final void run() {
                this.fRC.dc(true);
            }
        });
    }

    public final void b(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar == null || aVar.field_dataId == null) {
            v.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            return;
        }
        v.v("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[]{this.bdE.luu, aVar.field_dataId});
        if (aVar.field_dataId.equals(this.bdE.luu)) {
            final int progress = (int) (aVar.getProgress() * 100.0f);
            this.fRA.post(new Runnable(this) {
                final /* synthetic */ FavoriteSightDetailUI fRC;

                public final void run() {
                    this.fRC.fRA.setProgress(progress);
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final p a = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131232670), false, null);
            com.tencent.mm.plugin.favorite.b.p.a(this.nDR.nEl, stringExtra, str, this.fOz, new Runnable(this) {
                final /* synthetic */ FavoriteSightDetailUI fRC;

                public final void run() {
                    a.dismiss();
                }
            });
            boolean dE = m.dE(stringExtra);
            t.a(dE ? t.c.Chatroom : t.c.Chat, this.fOz, t.d.Samll, dE ? com.tencent.mm.model.i.el(stringExtra) : 0);
            com.tencent.mm.ui.snackbar.a.f(this, getString(2131232839));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }
}
