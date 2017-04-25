package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.h.b;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.FavTextEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;

public class FavoriteTextDetailUI extends MMActivity {
    private static final int fRH = b.sG();
    private l eyZ;
    private long fRB;
    private TextView fRI;
    private ClipboardManager fRJ;
    private i fRK;
    private d fRL = new d(this) {
        final /* synthetic */ FavoriteTextDetailUI fRM;

        {
            this.fRM = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    this.fRM.fRJ.setText(this.fRM.fRg.field_favProto.desc);
                    g.bf(this.fRM.nDR.nEl, this.fRM.nDR.nEl.getString(2131231016));
                    return;
                default:
                    return;
            }
        }
    };
    private i fRg;
    private FavDetailTitleView fRu;
    private FavDetailFooterView fRv;
    private FavTagEntrance fRw;

    protected final int getLayoutId() {
        return 2130903629;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRI = (TextView) findViewById(2131757007);
        this.fRu = (FavDetailTitleView) findViewById(2131756929);
        this.fRv = (FavDetailFooterView) findViewById(2131756928);
        this.fRw = (FavTagEntrance) findViewById(2131757005);
        this.fRJ = (ClipboardManager) getSystemService("clipboard");
        this.fRB = getIntent().getLongExtra("key_detail_info_id", -1);
        f.ux(5);
        this.eyZ = new l(this.nDR.nEl);
        this.eyZ.a(this.fRI, this, this.fRL);
        Fd(getString(2131232643));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteTextDetailUI fRM;

            {
                this.fRM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fRM.finish();
                return true;
            }
        });
        a(0, 2131235683, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteTextDetailUI fRM;

            {
                this.fRM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.fRM.nDR.nEl, com.tencent.mm.ui.widget.f.pbS, false);
                fVar.jXn = new c(this) {
                    final /* synthetic */ AnonymousClass2 fRN;

                    {
                        this.fRN = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        if (this.fRN.fRM.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                            lVar.d(2, this.fRN.fRM.getString(2131232731));
                        }
                        lVar.d(0, this.fRN.fRM.getString(2131232645));
                        lVar.d(3, this.fRN.fRM.getString(2131232647));
                        lVar.d(4, this.fRN.fRM.getString(2131231020));
                    }
                };
                fVar.jXo = new d(this) {
                    final /* synthetic */ AnonymousClass2 fRN;

                    {
                        this.fRN = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent(this.fRN.fRM, FavTextEditUI.class);
                                intent.putExtra("key_value", this.fRN.fRM.fRg.field_favProto.desc);
                                intent.putExtra("key_max_count", FavoriteTextDetailUI.fRH);
                                intent.putExtra("key_show_confirm", true);
                                intent.putExtra("key_fav_item_id", this.fRN.fRM.fRg.field_id);
                                this.fRN.fRM.startActivityForResult(intent, 1);
                                return;
                            case 2:
                                String str = this.fRN.fRM.fRg.field_favProto.desc;
                                FavoriteTextDetailUI favoriteTextDetailUI = this.fRN.fRM;
                                if (be.kS(str)) {
                                    v.e("MicroMsg.FavApplication", "shareTextToFriend content null");
                                } else {
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("Retr_Msg_content", str);
                                    intent2.putExtra("Retr_Msg_Type", 4);
                                    intent2.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.favorite.c.drp.l(intent2, favoriteTextDetailUI);
                                }
                                com.tencent.mm.plugin.report.service.g.iuh.h(10651, new Object[]{Integer.valueOf(this.fRN.fRM.fRg.field_type), Integer.valueOf(1)});
                                return;
                            case 3:
                                intent = new Intent(this.fRN.fRM.nDR.nEl, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.fRN.fRM.fRg.field_localId);
                                this.fRN.fRM.nDR.nEl.startActivity(intent);
                                return;
                            case 4:
                                g.a(this.fRN.fRM.nDR.nEl, this.fRN.fRM.getString(2131231021), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 fRO;

                                    {
                                        this.fRO = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = g.a(this.fRO.fRN.fRM.nDR.nEl, this.fRO.fRN.fRM.getString(2131231021), false, null);
                                        com.tencent.mm.plugin.favorite.b.v.a(this.fRO.fRN.fRM.fRB, new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 fRP;

                                            public final void run() {
                                                a.dismiss();
                                                v.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.fRP.fRO.fRN.fRM.fRB)});
                                                this.fRP.fRO.fRN.fRM.finish();
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
        h.alu().c(this.fRw);
    }

    protected void onDestroy() {
        h.alu().d(this.fRw);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        anc();
    }

    protected void onPause() {
        super.onPause();
    }

    private void anc() {
        this.fRg = h.alu().bB(this.fRB);
        if (this.fRg == null) {
            v.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.fRB)});
            return;
        }
        this.fRw.bQ(this.fRg.field_localId);
        this.fRw.av(this.fRg.field_tagProto.mub);
        if (this.fRK == null || this.fRK.field_edittime != this.fRg.field_edittime) {
            this.fRK = this.fRg;
            this.fRu.x(this.fRg);
            this.fRv.x(this.fRg);
            this.fRI.setText(this.fRg.field_favProto.desc);
            e.e(this.fRI, 1);
            return;
        }
        v.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, getString(2131231015));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i && -1 == i2) {
            g.bf(this.nDR.nEl, getString(2131231147));
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ FavoriteTextDetailUI fRM;

                {
                    this.fRM = r1;
                }

                public final void run() {
                    this.fRM.anc();
                }
            }, 250);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }
}
