package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.mm.plugin.favorite.b.o;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.c.a;
import com.tencent.mm.plugin.favorite.ui.c.e;
import com.tencent.mm.pluginsdk.ui.applet.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private String fOs;
    private b fOt = null;
    private Set<Integer> fOu = new HashSet();
    private o fOv = new o();
    private String toUser;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.fOs = getIntent().getStringExtra("key_fav_item_id");
        if (this.fOs != null) {
            for (String str : this.fOs.split(",")) {
                int i = be.getInt(str, Integer.MAX_VALUE);
                if (Integer.MAX_VALUE != i) {
                    this.fOu.add(Integer.valueOf(i));
                }
            }
        }
        this.fOu.remove(Integer.valueOf(3));
        this.fOt.f(this.fOu);
        this.fOv.fKK = false;
        this.fOt.a(this.fOv);
        this.fMX.post(new Runnable(this) {
            final /* synthetic */ FavSelectUI fOw;

            {
                this.fOw = r1;
            }

            public final void run() {
                this.fOw.fOt.amO();
                this.fOw.amv();
            }
        });
        a(0, 2131165207, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSelectUI fOw;

            {
                this.fOw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.fOw.nDR.nEl, FavSearchUI.class);
                intent.putExtra("key_to_user", this.fOw.toUser);
                intent.putExtra("key_fav_item_id", this.fOw.fOs);
                intent.putExtra("key_search_type", 1);
                this.fOw.startActivityForResult(intent, 0);
                return true;
            }
        });
        vD(2131232728);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavSelectUI fOw;

            {
                this.fOw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fOw.finish();
                return true;
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final a.b bVar = (a.b) view.getTag();
        if (bVar == null) {
            v.w("MicroMsg.FavSelectUI", "on item click, holder is null");
        } else if (bVar.fLP == null) {
            v.w("MicroMsg.FavSelectUI", "on item click, info is null");
        } else if (bVar.fLP.field_type == 3) {
            com.tencent.mm.ui.snackbar.a.f(this, getString(2131230746));
        } else {
            c cVar = new c(this.nDR.nEl);
            cVar.ba(this.toUser);
            e.a(cVar, this.nDR.nEl, bVar.fLP);
            cVar.d(Boolean.valueOf(true)).tS(2131231149).a(new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                final /* synthetic */ FavSelectUI fOw;

                public final void a(boolean z, String str, int i) {
                    this.fOw.axg();
                    if (z) {
                        final p a = g.a(this.fOw.nDR.nEl, this.fOw.getString(2131232670), false, null);
                        com.tencent.mm.plugin.favorite.b.p.a(this.fOw.nDR.nEl, this.fOw.toUser, str, bVar.fLP, new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 fOx;

                            public final void run() {
                                if (a != null) {
                                    a.dismiss();
                                }
                                com.tencent.mm.ui.snackbar.a.f(this.fOx.fOw, this.fOx.fOw.getString(2131232839));
                                ad.g(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 fOy;

                                    {
                                        this.fOy = r1;
                                    }

                                    public final void run() {
                                        this.fOy.fOx.fOw.finish();
                                    }
                                }, 1800);
                            }
                        });
                    }
                }
            }).iji.show();
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a amr() {
        if (this.fOt == null) {
            this.fOt = new b(this.fJV, false);
        }
        return this.fOt;
    }

    protected final void ams() {
    }

    protected final boolean amt() {
        return h.alu().getCount() > 0;
    }

    protected final void amu() {
        this.fMV.setCompoundDrawablesWithIntrinsicBounds(0, 2130838214, 0, 0);
        this.fMV.setCompoundDrawablePadding(com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 10));
        this.fMV.setText(2131232649);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && -1 == i2) {
            finish();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fOt != null) {
            this.fOt.finish();
        }
    }
}
