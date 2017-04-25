package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private int dwT = -1;
    private ListView hFk;
    private TextView ieY;
    private LinkedList<qy> oNS = new LinkedList();
    private boolean oNT;
    private b oOG;
    private LinkedList<aka> oOH = new LinkedList();
    private boolean oOI = false;

    static /* synthetic */ void c(RecommendFriendUI recommendFriendUI) {
        for (int i = 0; i < recommendFriendUI.oOG.bIF().length; i++) {
            ak.yW();
            c.wG().b(new h(recommendFriendUI.oOG.bIF()[i], recommendFriendUI.dwT));
            q qVar = new q();
            qVar.username = recommendFriendUI.oOG.bIF()[i];
            qVar.cHW = recommendFriendUI.dwT;
            qVar.cCe = (int) be.Nh();
            ah.FP().a(qVar);
        }
        g.a(recommendFriendUI.nDR.nEl, 2131233328, 2131231164, new OnClickListener(recommendFriendUI) {
            final /* synthetic */ RecommendFriendUI oOJ;

            {
                this.oOJ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.oOJ.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903811;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dwT = be.getInt(getIntent().getStringExtra("recommend_type"), 0);
        this.oNT = false;
        ak.vy().a(135, this);
        NI();
    }

    protected final void NI() {
        this.ieY = (TextView) findViewById(2131757510);
        if (this.dwT == 1) {
            vD(2131235117);
            this.ieY.setText(2131235121);
        } else if (this.dwT == 2) {
            vD(2131235116);
            this.ieY.setText(2131235120);
        } else {
            vD(2131235032);
            this.ieY.setText(2131235122);
        }
        this.oOG = new b(getLayoutInflater());
        this.hFk = (ListView) findViewById(2131757509);
        this.hFk.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ RecommendFriendUI oOJ;

            {
                this.oOJ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 0;
                if (this.oOJ.oNT) {
                    RecommendFriendUI recommendFriendUI = this.oOJ;
                    b b = this.oOJ.oOG;
                    if (b.oNT) {
                        i2 = ((qy) b.oNS.get(i)).muJ;
                    }
                    recommendFriendUI.xX(i2);
                    return;
                }
                this.oOJ.oOG.gO(i);
                if (this.oOJ.oOG.bIF().length > 0) {
                    this.oOJ.iU(true);
                } else {
                    this.oOJ.iU(false);
                }
            }
        });
        this.hFk.setAdapter(this.oOG);
        a(0, getString(2131233327), new OnMenuItemClickListener(this) {
            final /* synthetic */ RecommendFriendUI oOJ;

            {
                this.oOJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int length = this.oOJ.oOG.bIF().length;
                g.a(this.oOJ.nDR.nEl, this.oOJ.nDR.nEl.getResources().getQuantityString(2131361807, length, new Object[]{Integer.valueOf(length)}), this.oOJ.getString(2131231164), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 oOK;

                    {
                        this.oOK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RecommendFriendUI.c(this.oOK.oOJ);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 oOK;

                    {
                        this.oOK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        iU(false);
        this.oOI = true;
        final o oVar = new o(this.dwT);
        ak.vy().a(oVar, 0);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwR = g.a(actionBarActivity, getString(2131233330), true, new OnCancelListener(this) {
            final /* synthetic */ RecommendFriendUI oOJ;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(oVar);
                this.oOJ.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecommendFriendUI oOJ;

            {
                this.oOJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oOJ.goBack();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new View.OnClickListener(this) {
            final /* synthetic */ RecommendFriendUI oOJ;

            {
                this.oOJ = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.oOJ.hFk);
            }
        };
    }

    private void goBack() {
        if (this.dwT != 0) {
            finish();
        } else if (this.oNT || this.oOI) {
            finish();
        } else {
            bIH();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        ak.vy().b(135, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 0 && i2 == 0 && kVar.getType() == 135) {
            this.oOH = ((ajx) ((o) kVar).cif.czl.czs).mzB;
            this.oNS = ((ajx) ((o) kVar).cif.czl.czs).mcs;
            this.oOI = false;
            if (this.oOH.size() <= 0) {
                bIG();
                return;
            } else if (this.dwT == 0 && this.oNS.size() <= 0) {
                bIG();
                return;
            } else if (this.dwT != 0) {
                xX(-1);
                return;
            } else {
                bIH();
                return;
            }
        }
        bIG();
    }

    private void bIG() {
        this.ieY.setVisibility(0);
        this.hFk.setVisibility(8);
    }

    private void xX(int i) {
        v.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.oOH.size());
        this.oOG.e(this.oOH, i);
        this.hFk.setAdapter(this.oOG);
        this.oNT = false;
        if (this.dwT == 0) {
            String str = "";
            int i2 = 0;
            while (i2 < this.oNS.size()) {
                String str2;
                if (i == ((qy) this.oNS.get(i2)).muJ) {
                    str2 = ((qy) this.oNS.get(i2)).muK;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
            Fd(str);
        }
        this.oOG.oNT = this.oNT;
        this.oOG.notifyDataSetChanged();
    }

    private void bIH() {
        Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", this.dwT == 0);
        v.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.oNS.size());
        this.oOG.oNS = this.oNS;
        this.hFk.setAdapter(this.oOG);
        iU(false);
        this.oNT = true;
        vD(2131235032);
        this.oOG.oNT = this.oNT;
        this.oOG.notifyDataSetChanged();
    }
}
