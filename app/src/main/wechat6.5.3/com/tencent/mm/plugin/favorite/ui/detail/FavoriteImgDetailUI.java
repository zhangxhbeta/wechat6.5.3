package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.a.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FavoriteImgDetailUI extends MMActivity implements com.tencent.mm.plugin.favorite.b.b.a {
    private OnClickListener fQr = new OnClickListener(this) {
        final /* synthetic */ FavoriteImgDetailUI fRl;

        {
            this.fRl = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.fRl.nDR.nEl, FavImgGalleryUI.class);
            intent.putExtra("key_detail_info_id", this.fRl.fRg.field_localId);
            intent.putExtra("key_detail_data_id", ((pw) view.getTag()).luu);
            this.fRl.startActivity(intent);
        }
    };
    private LinearLayout fRb;
    private FavDetailTitleView fRc;
    private FavDetailFooterView fRd;
    private FavTagEntrance fRe;
    private int fRf = 0;
    private i fRg;
    private HashMap<String, a> fRh = new HashMap();
    private Bitmap fRi;
    private Bitmap fRj;
    private OnLongClickListener fRk = new OnLongClickListener(this) {
        final /* synthetic */ FavoriteImgDetailUI fRl;

        {
            this.fRl = r1;
        }

        public final boolean onLongClick(View view) {
            final pw pwVar = (pw) view.getTag();
            l lVar = new l(this.fRl.nDR.nEl);
            lVar.jXn = new c(this) {
                final /* synthetic */ AnonymousClass5 fRs;

                {
                    this.fRs = r1;
                }

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    if (this.fRs.fRl.fRg.aly()) {
                        lVar.d(2, this.fRs.fRl.nDR.nEl.getString(2131232731));
                    }
                    if (this.fRs.fRl.fRg.alz()) {
                        lVar.d(1, this.fRs.fRl.nDR.nEl.getString(2131232704));
                    }
                    lVar.d(3, this.fRs.fRl.nDR.nEl.getString(2131232726));
                }
            };
            lVar.jXo = new d(this) {
                final /* synthetic */ AnonymousClass5 fRs;

                public final void c(MenuItem menuItem, int i) {
                    String f = v.f(pwVar);
                    if (e.aR(f)) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                com.tencent.mm.plugin.favorite.c.d(f, this.fRs.fRl.nDR.nEl);
                                return;
                            case 2:
                                if (o.JZ(f)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("select_is_ret", true);
                                    com.tencent.mm.ay.c.a(this.fRs.fRl, ".ui.transmit.SelectConversationUI", intent, 1);
                                    return;
                                }
                                com.tencent.mm.plugin.favorite.c.e(f, this.fRs.fRl.nDR.nEl);
                                return;
                            case 3:
                                com.tencent.mm.plugin.favorite.c.a(f, this.fRs.fRl.getString(2131232725), this.fRs.fRl.nDR.nEl);
                                return;
                            default:
                                return;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
                }
            };
            lVar.aXZ();
            return true;
        }
    };

    private static class a {
        pw bdE;
        ImageView bdF;

        private a() {
        }
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, a aVar, Bitmap bitmap) {
        int i = 0;
        if (bitmap == null) {
            bitmap = favoriteImgDetailUI.j(aVar.bdE);
        }
        if (bitmap != null) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "update view bmp[%d, %d], displayWidth %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(favoriteImgDetailUI.fRf)});
        }
        if (bitmap.getWidth() > favoriteImgDetailUI.fRf / 3) {
            LayoutParams layoutParams = aVar.bdF.getLayoutParams();
            layoutParams.height = (int) ((((float) favoriteImgDetailUI.fRf) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
            if (layoutParams.height > 2048) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (VERSION.SDK_INT >= 11) {
                    m mVar = new m();
                    if (width >= 2048 || height >= 2048) {
                        i = 1;
                    }
                }
                if (i != 0) {
                    layoutParams.height = 512;
                    aVar.bdF.setScaleType(ScaleType.CENTER_CROP);
                } else {
                    aVar.bdF.setScaleType(ScaleType.FIT_XY);
                }
            } else {
                aVar.bdF.setScaleType(ScaleType.FIT_XY);
            }
        } else {
            LayoutParams layoutParams2 = aVar.bdF.getLayoutParams();
            if (bitmap.getHeight() > 2048) {
                layoutParams2.height = 512;
                aVar.bdF.setScaleType(ScaleType.CENTER_CROP);
            } else {
                layoutParams2.height = bitmap.getHeight();
                aVar.bdF.setScaleType(ScaleType.CENTER_INSIDE);
            }
        }
        k.h(aVar.bdF, bitmap.getWidth(), bitmap.getHeight());
        String f = v.f(aVar.bdE);
        if (o.JZ(f)) {
            try {
                com.tencent.mm.plugin.gif.a bL = b.atw().bL(f + "_detail", f);
                aVar.bdF.setImageDrawable(bL);
                bL.stop();
                bL.start();
                return;
            } catch (Exception e) {
            }
        }
        aVar.bdF.setImageBitmap(bitmap);
    }

    protected final int getLayoutId() {
        return 2130903624;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        anb();
        this.fRb = (LinearLayout) findViewById(2131757004);
        this.fRc = (FavDetailTitleView) findViewById(2131756929);
        this.fRd = (FavDetailFooterView) findViewById(2131756928);
        this.fRe = (FavTagEntrance) findViewById(2131757005);
        this.fRg = h.alu().bB(getIntent().getLongExtra("key_detail_info_id", -1));
        if (this.fRg == null) {
            finish();
            return;
        }
        this.fRc.x(this.fRg);
        this.fRd.x(this.fRg);
        Iterator it = this.fRg.field_favProto.mtR.iterator();
        int i = 0;
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[]{Integer.valueOf(i), pwVar.luu});
            a aVar = new a();
            aVar.bdE = pwVar;
            int i2 = i + 1;
            View imageView = new ImageView(this.nDR.nEl);
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131493199);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.fRb.addView(imageView, layoutParams);
            imageView.setTag(pwVar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 50));
            imageView.setMinimumHeight(com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 50));
            imageView.setImageResource(2131165527);
            imageView.setOnClickListener(this.fQr);
            imageView.setOnLongClickListener(this.fRk);
            aVar.bdF = imageView;
            this.fRh.put(pwVar.luu, aVar);
            a(aVar);
            i = i2;
        }
        this.fRe.bQ(this.fRg.field_localId);
        this.fRe.av(this.fRg.field_tagProto.mub);
        Fd(getString(2131232643));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteImgDetailUI fRl;

            {
                this.fRl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fRl.finish();
                return true;
            }
        });
        a(0, 2131235683, 2131165201, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteImgDetailUI fRl;

            {
                this.fRl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f fVar = new f(this.fRl.nDR.nEl, f.pbS, false);
                fVar.jXn = new c(this) {
                    final /* synthetic */ AnonymousClass2 fRm;

                    {
                        this.fRm = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.d(2, this.fRm.fRl.getString(2131232731));
                        lVar.d(0, this.fRm.fRl.getString(2131232647));
                        lVar.d(1, this.fRm.fRl.nDR.nEl.getString(2131231020));
                    }
                };
                fVar.jXo = new d(this) {
                    final /* synthetic */ AnonymousClass2 fRm;

                    {
                        this.fRm = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent(this.fRm.fRl.nDR.nEl, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", this.fRm.fRl.fRg.field_localId);
                                this.fRm.fRl.nDR.nEl.startActivity(intent);
                                return;
                            case 1:
                                g.a(this.fRm.fRl.nDR.nEl, this.fRm.fRl.getString(2131231021), "", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 fRn;

                                    {
                                        this.fRn = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final p a = g.a(this.fRn.fRm.fRl.nDR.nEl, this.fRn.fRm.fRl.getString(2131231021), false, null);
                                        v.a(this.fRn.fRm.fRl.fRg.field_localId, new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 fRo;

                                            public final void run() {
                                                a.dismiss();
                                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.fRo.fRn.fRm.fRl.fRg.field_localId)});
                                                this.fRo.fRn.fRm.fRl.finish();
                                            }
                                        });
                                    }
                                }, null);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", this.fRm.fRl.fRg.field_localId);
                                com.tencent.mm.ay.c.a(this.fRm.fRl, ".ui.transmit.SelectConversationUI", intent, 1);
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
        h.alu().c(this.fRe);
        h.alp().a((com.tencent.mm.plugin.favorite.b.b.a) this);
    }

    protected void onDestroy() {
        h.alu().d(this.fRe);
        h.alp().b((com.tencent.mm.plugin.favorite.b.b.a) this);
        super.onDestroy();
    }

    private void anb() {
        DisplayMetrics displayMetrics;
        if (aa.getResources() != null) {
            displayMetrics = aa.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.fRf = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(2131493067) * 2);
        this.fRf = Math.max(this.fRf, 0);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[]{Integer.valueOf(this.fRf)});
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        anb();
        for (Entry value : this.fRh.entrySet()) {
            a((a) value.getValue());
        }
    }

    private void a(final a aVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ FavoriteImgDetailUI fRl;

            public final void run() {
                Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(aVar.bdE, this.fRl.fRg, false);
                if (a == null) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
                    a = this.fRl.j(aVar.bdE);
                }
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 fRr;

                    public final void run() {
                        FavoriteImgDetailUI.a(this.fRr.fRl, aVar, a);
                    }

                    public final String toString() {
                        return super.toString() + "|renderView";
                    }
                });
            }
        });
    }

    private Bitmap j(pw pwVar) {
        boolean z = true;
        if (be.kS(pwVar.mrS)) {
            if (this.fRj == null) {
                this.fRj = com.tencent.mm.compatible.f.a.decodeResource(getResources(), 2131165526);
            }
            return this.fRj;
        }
        Bitmap a = com.tencent.mm.plugin.favorite.c.g.a(pwVar, this.fRg);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        com.tencent.mm.sdk.platformtools.v.d(str, str2, objArr);
        if (a != null) {
            return a;
        }
        if (this.fRi == null) {
            this.fRi = com.tencent.mm.compatible.f.a.decodeResource(getResources(), 2131165527);
        }
        return this.fRi;
    }

    public final void b(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar != null && aVar.isFinished()) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[]{aVar.field_dataId});
            a aVar2 = (a) this.fRh.get(aVar.field_dataId);
            if (aVar2 != null) {
                a(aVar2);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                com.tencent.mm.plugin.favorite.b.o oVar = new com.tencent.mm.plugin.favorite.b.o();
                if (com.tencent.mm.plugin.favorite.b.o.h(this.fRg)) {
                    g.bf(this.nDR.nEl, getString(2131230745));
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[]{stringExtra});
                final p a = g.a(this.nDR.nEl, getString(2131232670), false, null);
                com.tencent.mm.plugin.favorite.b.p.a(this.nDR.nEl, stringExtra, stringExtra2, this.fRg, new Runnable(this) {
                    final /* synthetic */ FavoriteImgDetailUI fRl;

                    public final void run() {
                        a.dismiss();
                        com.tencent.mm.ui.snackbar.a.f(this.fRl, this.fRl.getString(2131232839));
                    }
                });
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onResume() {
        super.onResume();
        for (Entry value : this.fRh.entrySet()) {
            a((a) value.getValue());
        }
    }
}
