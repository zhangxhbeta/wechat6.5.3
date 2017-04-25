package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.m;

public class ArtistUI extends MMActivity implements e {
    private SharedPreferences cnm;
    private p dwg = null;
    private ListView eyT;
    private String gRN = "";
    private e jDQ;
    private ArtistHeader jDR;
    private k jDS = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String d = u.d(getSharedPreferences(aa.bti(), 0));
        v.d("MicroMsg.ArtistUI", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.gRN = d;
        v.d("MicroMsg.ArtistUI", "lan " + this.gRN);
        ak.vy().a(159, this);
        this.cnm = getSharedPreferences(aa.bti(), 0);
        NI();
        ad.aSz().a(this.jDR);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dwg != null) {
            this.dwg = null;
        }
        if (this.jDR != null) {
            ad.aSz().b(this.jDR);
        }
        ad.aSB().M(this);
        ak.vy().b(159, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void NI() {
        vD(2131235152);
        getString(2131231164);
        this.dwg = g.a(this, getString(2131231085), true, new OnCancelListener(this) {
            final /* synthetic */ ArtistUI jDT;

            {
                this.jDT = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.eyT = (ListView) findViewById(2131759288);
        a.drq.ai(false);
        this.jDQ = new e(this, this.gRN, new b(this) {
            final /* synthetic */ ArtistUI jDT;

            {
                this.jDT = r1;
            }

            public final void qI(int i) {
                Intent intent = new Intent();
                intent.putExtra("sns_gallery_is_artist", true);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_artist_lan", this.jDT.gRN);
                intent.putExtra("sns_gallery_showtype", 2);
                intent.setClass(this.jDT, ArtistBrowseUI.class);
                this.jDT.startActivity(intent);
            }
        }, new e.a(this) {
            final /* synthetic */ ArtistUI jDT;

            {
                this.jDT = r1;
            }

            public final void a(de deVar) {
                if (this.jDT.jDR != null) {
                    this.jDT.jDR.setVisibility(0);
                    ArtistHeader b = this.jDT.jDR;
                    if (deVar == null) {
                        v.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
                    } else {
                        b.jDE = deVar;
                        ad.aSB().b(deVar.mdK.mdL, b.jDJ.dtz, b.context.hashCode(), com.tencent.mm.storage.ak.nvx);
                        b.jDJ.jDO.setText(deVar.gkB);
                        b.jDJ.emb.setText(deVar.mdJ);
                        b.jDJ.dtB.setText(deVar.aXz);
                        b.jDJ.jDP.setText(deVar.mdI);
                    }
                    String str = deVar.gkB;
                    if (!(str == null || str.equals(""))) {
                        this.jDT.cnm.edit().putString("artist_name", str).commit();
                    }
                    if (this.jDT.jDQ != null) {
                        this.jDT.jDQ.notifyDataSetChanged();
                    }
                }
                this.jDT.dwg.dismiss();
            }

            public final void aVm() {
                if (this.jDT.jDS == null && this.jDT.dwg != null) {
                    v.d("MicroMsg.ArtistUI", "onNothingBgGet");
                    a.drq.ai(true);
                }
            }
        });
        this.jDR = new ArtistHeader(this);
        this.eyT.addHeaderView(this.jDR);
        this.eyT.setAdapter(this.jDQ);
        this.jDQ.notifyDataSetChanged();
        this.jDR.setVisibility(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ArtistUI jDT;

            {
                this.jDT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jDT.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904438;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).BI() == 4) {
            v.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case 159:
                        if (this.jDQ != null) {
                            this.jDQ.Ol();
                        }
                        this.jDS = null;
                        return;
                    default:
                        return;
                }
            } else if (kVar.getType() == 159 && this.dwg != null) {
                this.dwg.dismiss();
                return;
            } else {
                return;
            }
        }
        v.d("MicroMsg.ArtistUI", "another scene");
    }
}
