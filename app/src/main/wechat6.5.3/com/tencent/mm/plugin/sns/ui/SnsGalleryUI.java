package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ak;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.r.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.List;

public class SnsGalleryUI extends SnsBaseGalleryUI implements a {
    private int jMc = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        int max;
        if (this.jMb != null) {
            this.jMb.aWV();
            this.jMb.onDestroy();
        }
        ak.a aSu = ad.aSu();
        String str = this.userName;
        if (aSu.jnh.containsKey(str)) {
            max = Math.max(((Integer) aSu.jnh.get(str)).intValue() - 1, 0);
            aSu.jnh.put(str, Integer.valueOf(max));
        } else {
            max = 0;
        }
        if (max <= 0) {
            aSu.jng.remove(str);
        }
        ad.aSB().M(this);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected final int getLayoutId() {
        return 2130904451;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.jLY.jFZ);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void NI() {
        List arrayList;
        com.tencent.mm.storage.ak bvT;
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.jMc = getIntent().getIntExtra("sns_gallery_position", 0);
        aZ(s.B("sns_table_", (long) intExtra), this.jMc);
        n(booleanExtra, 1);
        this.jMb = new SnsInfoFlip(this);
        this.jMb.jFr = true;
        ak.a aSu = ad.aSu();
        String str = this.userName;
        if (aSu.jnh.containsKey(str)) {
            aSu.jnh.put(str, Integer.valueOf(((Integer) aSu.jnh.get(str)).intValue() + 1));
        } else {
            aSu.jnh.put(str, Integer.valueOf(0));
        }
        ArrayList arrayList2 = (ArrayList) aSu.jng.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            Object obj = arrayList2;
        }
        this.jMb.jOP = true;
        this.jMb.jOR = true;
        this.jMb.jOS = false;
        this.jMb.a(arrayList, this.userName, this.jMc, this.jLW, this);
        this.jMb.jOX = new Runnable(this) {
            final /* synthetic */ SnsGalleryUI jOs;

            {
                this.jOs = r1;
            }

            public final void run() {
                this.jOs.jLY.aVE();
            }
        };
        com.tencent.mm.model.ak.yW();
        u LX = c.wH().LX(this.userName);
        if (LX == null || ((int) LX.chr) <= 0 || !com.tencent.mm.i.a.ei(LX.field_type)) {
            if (this.userName.equals(k.xF())) {
                bvT = com.tencent.mm.storage.ak.bvT();
            } else {
                bvT = com.tencent.mm.storage.ak.bvU();
            }
        } else {
            bvT = com.tencent.mm.storage.ak.bvS();
        }
        this.jMb.jdP = bvT;
        this.jMb.username = this.userName;
        addView(this.jMb);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsGalleryUI jOs;

            {
                this.jOs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jOs.jLY.aVE();
                return true;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsGalleryUI jOs;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String str;
                String str2;
                SnsInfoFlip snsInfoFlip = this.jOs.jMb;
                if (snsInfoFlip.jOJ == null) {
                    str = "";
                } else {
                    b bVar = (b) snsInfoFlip.jOJ.getSelectedItem();
                    str = bVar == null ? "" : bVar.jqo;
                }
                snsInfoFlip = this.jOs.jMb;
                if (snsInfoFlip.jOJ == null) {
                    str2 = null;
                } else {
                    bVar = (b) snsInfoFlip.jOJ.getSelectedItem();
                    str2 = bVar == null ? null : bVar.boL.gID;
                }
                b aWS = this.jOs.jMb.aWS();
                v.d("MicroMsg.SnsGalleryUI", "click selectLocalId " + str);
                v.d("MicroMsg.SnsGalleryUI", "click position " + str2);
                com.tencent.mm.plugin.sns.storage.k Bq = ad.aSE().Bq(str);
                try {
                    int i;
                    int i2 = this.jOs.jMb.jPa;
                    int size = Bq.aUp().mWq.mom.size();
                    if (size <= 1 || i2 <= 1 || i2 > size) {
                        i = 0;
                    } else {
                        i = i2 - 1;
                    }
                    this.jOs.jLY.a(booleanExtra, Bq, aWS.boL, true, i);
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
                }
                return true;
            }
        });
    }

    public final void aY(String str, int i) {
        if (this.jMb != null) {
            if (!(be.kS(str) || i == 3)) {
                SnsInfoFlip snsInfoFlip = this.jMb;
                if (snsInfoFlip.cwd != null) {
                    int i2;
                    for (int i3 = 0; i3 >= 0; i3 = i2) {
                        i2 = i3;
                        while (i2 < snsInfoFlip.cwd.size()) {
                            b bVar = (b) snsInfoFlip.cwd.get(i2);
                            if (!be.kS(bVar.jqo) && bVar.jqo.equals(str)) {
                                snsInfoFlip.cwd.remove(i2);
                                break;
                            }
                            i2++;
                        }
                        i2 = -1;
                    }
                    snsInfoFlip.jOI.notifyDataSetChanged();
                }
            }
            this.jMb.aWU();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String str;
            if (2 == i) {
                if (-1 == i2) {
                    aib com_tencent_mm_protocal_c_aib;
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    if (this.jMb != null) {
                        b aWS = this.jMb.aWS();
                        if (aWS.boL.efm == 6) {
                            com_tencent_mm_protocal_c_aib = aWS.boL;
                        } else {
                            return;
                        }
                    }
                    com_tencent_mm_protocal_c_aib = null;
                    if (com_tencent_mm_protocal_c_aib != null) {
                        String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
                        str = "";
                        String str2 = "";
                        String i3 = i.i(com_tencent_mm_protocal_c_aib);
                        if (FileOp.aR(cA + i3)) {
                            str2 = cA + i3;
                            str = cA + i.c(com_tencent_mm_protocal_c_aib);
                        }
                        if (FileOp.aR(cA + i.o(com_tencent_mm_protocal_c_aib))) {
                            i3 = cA + i.o(com_tencent_mm_protocal_c_aib);
                            cA = cA + i.m(com_tencent_mm_protocal_c_aib);
                        } else {
                            i3 = str2;
                            cA = str;
                        }
                        List<String> g = be.g(stringExtra.split(","));
                        int zZ = i.zZ(i3);
                        for (String str3 : g) {
                            v.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[]{str3, i3, cA, Integer.valueOf(zZ)});
                            j.a.bmt().a(this, str3, i3, cA, 62, zZ, "");
                            j.a.bmt().df(stringExtra2, str3);
                        }
                        com.tencent.mm.ui.snackbar.a.f(this, getString(2131233278));
                    }
                }
            } else if (1 == i) {
                int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
                str = s.B("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
                this.jLY.qJ(intExtra);
                aY(str, 1);
                if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("sns_cmd_list", this.jLY.jFZ);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
    }
}
