package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k.b;
import java.util.Map;

public class GameRegionSelectUI extends MMPreference {
    private f dxf;
    private a gwW;
    private Map<String, a> gxb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        NI();
    }

    protected void onDestroy() {
        a.gzB.asF();
        super.onDestroy();
    }

    public final int Oo() {
        return -1;
    }

    protected final void NI() {
        vD(2131233126);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRegionSelectUI gxc;

            {
                this.gxc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gxc.setResult(0);
                this.gxc.axg();
                this.gxc.finish();
                return true;
            }
        });
        a(0, getString(2131233125), new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRegionSelectUI gxc;

            {
                this.gxc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                if (this.gxc.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) != 1) {
                    i = 1;
                }
                if (i != 0) {
                    g.a(this.gxc, true, this.gxc.getString(2131233123), "", this.gxc.getString(2131233124), this.gxc.getString(2131233122), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 gxd;

                        {
                            this.gxd = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.gxd.gxc.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
                            if (this.gxd.gxc.gwW != null) {
                                e.T(this.gxd.gxc, this.gxd.gxc.gwW.bCq);
                                a.gzB.gzA = true;
                            }
                            Intent intent = new Intent();
                            a bS = e.bS(this.gxd.gxc);
                            if (bS != null) {
                                intent.putExtra("gameRegionName", e.a(bS));
                                this.gxd.gxc.setResult(-1, intent);
                            } else {
                                this.gxd.gxc.setResult(1);
                            }
                            this.gxd.gxc.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 gxd;

                        {
                            this.gxd = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    if (this.gxc.gwW != null) {
                        e.T(this.gxc, this.gxc.gwW.bCq);
                        a.gzB.gzA = true;
                    }
                    Intent intent = new Intent();
                    a bS = e.bS(this.gxc);
                    if (bS != null) {
                        intent.putExtra("gameRegionName", e.a(bS));
                        this.gxc.setResult(-1, intent);
                    } else {
                        this.gxc.setResult(1);
                    }
                    this.gxc.finish();
                }
                return true;
            }
        }, b.nET);
        this.dxf.removeAll();
        this.gxb = a.gzB.asH();
        a bS = e.bS(this);
        if (bS != null) {
            bS.gxa = true;
        }
        for (a bS2 : this.gxb.values()) {
            if (bS2 != null) {
                GameRegionPreference gameRegionPreference = new GameRegionPreference(this);
                if (bS2 == null || be.kS(bS2.bCq)) {
                    v.e("MicroMsg.GameRegionPreference", "setData region error");
                } else {
                    gameRegionPreference.gwW = bS2;
                    gameRegionPreference.setKey(bS2.bCq);
                }
                if (bS2.isDefault) {
                    this.dxf.a(gameRegionPreference, 0);
                } else {
                    this.dxf.a(gameRegionPreference);
                }
            }
        }
        this.dxf.a(new PreferenceCategory(this));
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof GameRegionPreference)) {
            return false;
        }
        a aVar = ((GameRegionPreference) preference).gwW;
        if (aVar == null) {
            return false;
        }
        this.gwW = aVar;
        for (a aVar2 : this.gxb.values()) {
            aVar2.gxa = false;
        }
        aVar.gxa = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
