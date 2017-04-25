package com.tencent.mm.plugin.favorite.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.o;
import com.tencent.mm.plugin.favorite.b.t;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.plugin.favorite.ui.c.a.c;
import com.tencent.mm.plugin.favorite.ui.post.FavPostVoiceUI;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements a, c {
    private d eus = new d(this) {
        final /* synthetic */ FavoriteIndexUI fOT;

        {
            this.fOT = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (this.fOT.fOM) {
                case 0:
                    if (menuItem != null) {
                        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (adapterContextMenuInfo.position >= this.fOT.fMU.getHeaderViewsCount()) {
                                    v.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                    com.tencent.mm.plugin.favorite.b.v.a(this.fOT.fON.kJ((adapterContextMenuInfo.position - this.fOT.fMU.getHeaderViewsCount()) - 1), null);
                                    return;
                                }
                                return;
                            case 1:
                                this.fOT.startTime = be.Nh();
                                v.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                this.fOT.fOP = this.fOT.fON.kJ((adapterContextMenuInfo.position - this.fOT.fMU.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.b(this.fOT, this.fOT.fOP);
                                return;
                            case 2:
                                v.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                i kJ = this.fOT.fON.kJ((adapterContextMenuInfo.position - this.fOT.fMU.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent(this.fOT.nDR.nEl, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", kJ.field_localId);
                                this.fOT.nDR.nEl.startActivity(intent);
                                return;
                            case 3:
                                this.fOT.startTime = be.Nh();
                                v.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                this.fOT.fOS = this.fOT.fON.kJ((adapterContextMenuInfo.position - this.fOT.fMU.getHeaderViewsCount()) - 1);
                                this.fOT.fOS = this.fOT.fOS.alG();
                                if (this.fOT.fOS == null || this.fOT.fOS.field_type != 3) {
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("Select_Conv_Type", 3);
                                    intent2.putExtra("scene_from", 1);
                                    intent2.putExtra("mutil_select_is_ret", true);
                                    if (this.fOT.fOS != null) {
                                        intent2.putExtra("select_fav_local_id", this.fOT.fOS.field_localId);
                                    }
                                    if (!(this.fOT.fOS == null || FavoriteIndexUI.kI(this.fOT.fOS.field_type) == -1)) {
                                        intent2.putExtra("Retr_Msg_Type", this.fOT.fOS.field_type);
                                    }
                                    com.tencent.mm.ay.c.a(this.fOT, ".ui.transmit.SelectConversationUI", intent2, 4106);
                                    return;
                                }
                                g.bf(this.fOT.getApplicationContext(), this.fOT.getString(2131232724));
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private l eyZ;
    private int fOM = 0;
    private b fON;
    private com.tencent.mm.plugin.favorite.ui.base.b fOO;
    private i fOP;
    private e fOQ = new e(this) {
        final /* synthetic */ FavoriteIndexUI fOT;

        {
            this.fOT = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            this.fOT.fNa.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass9 fPg;

                {
                    this.fPg = r1;
                }

                public final void run() {
                    this.fPg.fOT.fNa.amT();
                }
            });
        }
    };
    private OnItemLongClickListener fOR = new OnItemLongClickListener(this) {
        final /* synthetic */ FavoriteIndexUI fOT;

        {
            this.fOT = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < this.fOT.fMU.getHeaderViewsCount()) {
                v.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
            } else {
                this.fOT.eyZ.a(view, i, j, this.fOT, this.fOT.eus);
            }
            return true;
        }
    };
    private i fOS;
    private long startTime = 0;

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, final List list) {
        if (list != null && !list.isEmpty()) {
            final p a = g.a(favoriteIndexUI.nDR.nEl, favoriteIndexUI.getString(2131232642), false, null);
            ak.vA().x(new Runnable(favoriteIndexUI) {
                final /* synthetic */ FavoriteIndexUI fOT;

                public final void run() {
                    com.tencent.mm.plugin.favorite.b.v.as(list);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 fOV;

                        {
                            this.fOV = r1;
                        }

                        public final void run() {
                            a.dismiss();
                        }

                        public final String toString() {
                            return super.toString() + "|batchDelFavItems";
                        }
                    });
                }
            });
        }
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, i iVar) {
        favoriteIndexUI.fON.a(true, iVar);
        favoriteIndexUI.fMU.setOnItemLongClickListener(null);
        favoriteIndexUI.V(11, false);
        com.tencent.mm.plugin.favorite.ui.base.b bVar = favoriteIndexUI.fOO;
        if (!bVar.fPG) {
            if (bVar.fPH != null) {
                if (bVar.fPH instanceof ViewStub) {
                    bVar.fPH = ((ViewStub) bVar.fPH).inflate();
                }
                bVar.fPL = (ImageButton) bVar.fPH.findViewById(2131756931);
                bVar.fPL.setEnabled(false);
                bVar.fPL.setContentDescription(bVar.fPL.getContext().getString(2131235700));
                bVar.fPL.setOnClickListener(new OnClickListener(bVar) {
                    final /* synthetic */ b fPP;

                    {
                        this.fPP = r1;
                    }

                    public final void onClick(View view) {
                        if (this.fPP.fPO != null) {
                            this.fPP.fPO.amI();
                        }
                    }
                });
                bVar.fPM = (ImageButton) bVar.fPH.findViewById(2131756932);
                bVar.fPM.setEnabled(false);
                bVar.fPM.setContentDescription(bVar.fPM.getContext().getString(2131232308));
                bVar.fPM.setOnClickListener(new OnClickListener(bVar) {
                    final /* synthetic */ b fPP;

                    {
                        this.fPP = r1;
                    }

                    public final void onClick(View view) {
                        if (this.fPP.fPO != null) {
                            this.fPP.fPO.amJ();
                        }
                    }
                });
                bVar.fPN = (ImageButton) bVar.fPH.findViewById(2131756933);
                bVar.fPN.setEnabled(false);
                bVar.fPN.setContentDescription(bVar.fPN.getContext().getString(2131232278));
                bVar.fPN.setOnClickListener(new OnClickListener(bVar) {
                    final /* synthetic */ b fPP;

                    {
                        this.fPP = r1;
                    }

                    public final void onClick(View view) {
                        if (this.fPP.fPO != null) {
                            this.fPP.fPO.amA();
                        }
                    }
                });
                bVar.fPG = true;
            } else {
                return;
            }
        }
        if (bVar.fPH.getVisibility() != 0) {
            bVar.fPH.setVisibility(0);
            bVar.fPH.startAnimation(AnimationUtils.loadAnimation(bVar.fPH.getContext(), 2130968622));
        }
    }

    static /* synthetic */ void h(FavoriteIndexUI favoriteIndexUI) {
        ja jaVar = new ja();
        jaVar.bjr.context = favoriteIndexUI.nDR.nEl;
        jaVar.bjr.type = 9;
        com.tencent.mm.sdk.c.a.nhr.z(jaVar);
        jb jbVar = new jb();
        jbVar.bjB.context = favoriteIndexUI.nDR.nEl;
        jbVar.bjB.type = 3;
        jbVar.bjB.bjy = 1;
        com.tencent.mm.sdk.c.a.nhr.z(jbVar);
    }

    static /* synthetic */ int kI(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 16) {
            return 11;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 14) {
            return 13;
        }
        return i == 6 ? 9 : 2;
    }

    public void onCreate(Bundle bundle) {
        this.fNb = this;
        super.onCreate(bundle);
        h.alo().cW(false);
        vD(2131232672);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.fOT.fON.fPo) {
                    this.fOT.amG();
                } else {
                    this.fOT.finish();
                }
                return true;
            }
        });
        this.fMU.setOnItemLongClickListener(this.fOR);
        ak.vy().a(438, this.fOQ);
        ak.vy().a(401, this.fOQ);
        this.eyZ = new l(this);
        a(11, 2131230799, 2131165188, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavoriteIndexUI.h(this.fOT);
                return true;
            }
        });
        this.fOO = new com.tencent.mm.plugin.favorite.ui.base.b();
        com.tencent.mm.plugin.favorite.ui.base.b bVar = this.fOO;
        View findViewById = findViewById(2131756930);
        bVar.fPG = false;
        bVar.fPH = findViewById;
        this.fOO.fPO = new com.tencent.mm.plugin.favorite.ui.base.b.a(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final void amI() {
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 1);
                intent.putExtra("mutil_select_is_ret", true);
                int amQ = this.fOT.fON.amQ();
                if (amQ == 1) {
                    intent.putExtra("select_fav_local_id", ((i) this.fOT.fON.cZ(false).get(0)).field_localId);
                    if (this.fOT.fON.cZ(false).get(0) != null && ((i) this.fOT.fON.cZ(false).get(0)).field_type == 3) {
                        g.bf(this.fOT.getApplicationContext(), this.fOT.getString(2131232724));
                        return;
                    }
                }
                intent.putExtra("Retr_Msg_Type", 17);
                intent.putExtra("select_fav_select_count", amQ);
                com.tencent.mm.ay.c.a(this.fOT, ".ui.transmit.SelectConversationUI", intent, 4105);
            }

            public final void amA() {
                g.a(this.fOT.nDR.nEl, this.fOT.getString(2131232641), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 fOU;

                    {
                        this.fOU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FavoriteIndexUI.a(this.fOU.fOT, this.fOU.fOT.fON.cZ(true));
                        com.tencent.mm.plugin.report.service.g.iuh.h(11125, new Object[]{Integer.valueOf(r0.size()), Integer.valueOf(3)});
                        if (this.fOU.fOT.fON.fPo) {
                            this.fOU.fOT.amG();
                        }
                    }
                }, null);
            }

            public final void amJ() {
                if (this.fOT.fON.amQ() > 0) {
                    if (this.fOT.fON.amQ() > 1) {
                        Intent intent = new Intent(this.fOT.nDR.nEl, FavTagEditUI.class);
                        intent.putExtra("key_fav_scene", 3);
                        this.fOT.startActivityForResult(intent, 4104);
                        return;
                    }
                    i iVar = (i) this.fOT.fON.cZ(false).get(0);
                    Intent intent2 = new Intent(this.fOT.nDR.nEl, FavTagEditUI.class);
                    intent2.putExtra("key_fav_scene", 3);
                    intent2.putExtra("key_fav_item_id", iVar.field_localId);
                    this.fOT.startActivity(intent2);
                    if (this.fOT.fON.fPo) {
                        this.fOT.amG();
                    }
                }
            }
        };
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final void run() {
                List list;
                long currentTimeMillis = System.currentTimeMillis();
                j alu = h.alu();
                Cursor rawQuery = alu.cie.rawQuery("select " + j.fKI + " from FavItemInfo where flag" + " =  -1 and itemStatus = 0 ", null);
                if (rawQuery == null) {
                    list = null;
                } else if (rawQuery.getCount() == 0) {
                    rawQuery.close();
                    list = null;
                } else {
                    List linkedList = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        i iVar = new i();
                        iVar.b(rawQuery);
                        linkedList.add(iVar);
                    }
                    rawQuery.close();
                    list = linkedList;
                }
                if (list != null) {
                    v.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[]{Integer.valueOf(list.size()), Long.valueOf(currentTimeMillis)});
                    if (list.size() != 0) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            h.alu().d((i) list.get(i));
                        }
                        v.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
            }
        });
    }

    protected final void amv() {
        super.amv();
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final void run() {
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        h.alo().cW(true);
        if (this.fON != null) {
            this.fON.finish();
        }
        ak.vy().b(438, this.fOQ);
        ak.vy().b(401, this.fOQ);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (4 != i || !this.fON.fPo) {
            return super.onKeyUp(i, keyEvent);
        }
        amG();
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        o oVar = new o();
        i kJ = this.fON.kJ((((AdapterContextMenuInfo) contextMenuInfo).position - this.fMU.getHeaderViewsCount()) - 1);
        switch (this.fOM) {
            case 0:
                contextMenu.setHeaderTitle(2131231164);
                boolean g = oVar.g(kJ);
                if (!g) {
                    contextMenu.add(0, 3, 0, 2131232723);
                }
                if (g && com.tencent.mm.plugin.favorite.b.v.s(kJ)) {
                    contextMenu.add(0, 3, 0, 2131232723);
                }
                contextMenu.add(0, 2, 0, 2131232647);
                contextMenu.add(0, 0, 0, 2131232640);
                contextMenu.add(0, 1, 0, 2131232688);
                return;
            default:
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                return;
        }
    }

    private void amG() {
        this.fON.a(false, null);
        this.fMU.setOnItemLongClickListener(this.fOR);
        V(11, true);
        com.tencent.mm.plugin.favorite.ui.base.b bVar = this.fOO;
        if (bVar.fPG && bVar.fPH.getVisibility() != 8) {
            bVar.fPH.setVisibility(8);
            bVar.fPH.startAnimation(AnimationUtils.loadAnimation(bVar.fPH.getContext(), 2130968623));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.fOM) {
            case 0:
                if (this.fON != null) {
                    this.fON.onItemClick(adapterView, view, i, j);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a amr() {
        if (this.fON == null) {
            this.fON = new b(this.fJV, false);
            this.fON.a(new com.tencent.mm.plugin.favorite.ui.a.a.a(this) {
                final /* synthetic */ FavoriteIndexUI fOT;

                {
                    this.fOT = r1;
                }

                public final void amK() {
                    this.fOT.fNa.da(true);
                }
            });
            this.fON.fPv = this;
        }
        return this.fON;
    }

    protected final void ams() {
        this.fNa.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final void run() {
                this.fOT.fNa.amT();
            }
        });
    }

    protected final boolean amt() {
        int i;
        switch (this.fOM) {
            case 3:
                Cursor rawQuery = h.alu().rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
                if (rawQuery == null) {
                    i = 0;
                    break;
                }
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                rawQuery.close();
                break;
            default:
                i = h.alu().getCount();
                break;
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    protected final void amu() {
        switch (this.fOM) {
            case 3:
                this.fMV.setCompoundDrawablesWithIntrinsicBounds(0, 2131165527, 0, 0);
                this.fMV.setCompoundDrawablePadding(com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 10));
                this.fMV.setText(2131232650);
                return;
            default:
                this.fMV.setCompoundDrawablesWithIntrinsicBounds(0, 2130838214, 0, 0);
                this.fMV.setCompoundDrawablePadding(com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 10));
                this.fMV.setText(2131232649);
                return;
        }
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI fOT;

            {
                this.fOT = r1;
            }

            public final void run() {
                this.fOT.fNa.amT();
            }
        });
        v.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected final void initHeaderView() {
        super.initHeaderView();
        this.fNa.da(false);
    }

    private void a(List<i> list, String str, String str2) {
        if (list != null && !list.isEmpty() && !be.kS(str2)) {
            boolean dE = m.dE(str2);
            o oVar = new o();
            List<i> linkedList = new LinkedList();
            boolean z = false;
            for (i iVar : list) {
                if (!z) {
                    z = o.h(iVar);
                }
                if (!oVar.g(iVar)) {
                    linkedList.add(iVar);
                    t.a(dE ? t.c.Chatroom : t.c.Chat, iVar, t.d.Samll, dE ? com.tencent.mm.model.i.el(str2) : 0);
                }
            }
            String string;
            if (linkedList.isEmpty()) {
                v.w("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                string = getString(2131232724);
                if (z) {
                    string = getString(2131230745);
                }
                g.bf(getApplicationContext(), string);
                return;
            }
            final p a = g.a(this.nDR.nEl, getString(2131232670), false, null);
            com.tencent.mm.plugin.favorite.b.p.a(this.nDR.nEl, str2, str, (List) linkedList, new Runnable(this) {
                final /* synthetic */ FavoriteIndexUI fOT;

                public final void run() {
                    a.dismiss();
                    com.tencent.mm.ui.snackbar.a.f(this.fOT, this.fOT.getString(2131232839));
                }
            });
            for (i iVar2 : linkedList) {
                if (iVar2 != null && iVar2.field_type == 5) {
                    String str3 = "";
                    if (iVar2.field_favProto.mtc != null) {
                        str3 = iVar2.field_favProto.mtc.mur;
                    }
                    if (iVar2.field_favProto.mtP != null && be.kS(r1)) {
                        str3 = iVar2.field_favProto.mtP.cZp;
                    }
                    if (!be.kS(str3)) {
                        v.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                        string = "";
                        try {
                            string = URLEncoder.encode(str3, "UTF-8");
                        } catch (Throwable e) {
                            v.a("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(13378, new Object[]{string, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                    }
                }
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11125, new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(1)});
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String stringExtra;
        String stringExtra2;
        if (i2 == -1) {
            int i3 = 2;
            stringExtra = intent.getStringExtra("custom_send_text");
            switch (i) {
                case 4096:
                    final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        i3 = 0;
                        this.fMX.post(new Runnable(this) {
                            final /* synthetic */ FavoriteIndexUI fOT;

                            public final void run() {
                                this.fOT.fMR = true;
                                com.tencent.mm.plugin.favorite.b.l.ar(stringArrayListExtra);
                            }
                        });
                        break;
                    }
                    v.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                    return;
                    break;
                case 4097:
                    final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                    final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                    final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                    final String ah = be.ah(intent.getStringExtra("Kwebmap_locaion"), "");
                    final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                    final String stringExtra3 = intent.getStringExtra("kPoiName");
                    final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                    this.fMX.post(new Runnable(this) {
                        final /* synthetic */ FavoriteIndexUI fOT;

                        public final void run() {
                            this.fOT.fMR = true;
                            double d = doubleExtra;
                            double d2 = doubleExtra2;
                            int i = intExtra;
                            String str = ah;
                            CharSequence charSequence = charSequenceExtra;
                            String str2 = stringExtra3;
                            List<String> list = stringArrayListExtra2;
                            qc qcVar = new qc();
                            qcVar.Je(str);
                            qcVar.k(d);
                            qcVar.j(d2);
                            qcVar.uJ(i);
                            qcVar.Jf(str2);
                            i iVar = new i();
                            iVar.field_type = 6;
                            iVar.field_sourceType = 6;
                            iVar.field_favProto.b(qcVar);
                            if (!(charSequence == null || be.kS(charSequence.toString()))) {
                                iVar.field_favProto.Jk(charSequence.toString());
                                iVar.field_favProto.dT(be.Ni());
                                com.tencent.mm.plugin.report.service.g.iuh.h(10873, new Object[]{Integer.valueOf(6)});
                            }
                            com.tencent.mm.plugin.favorite.b.l.f(iVar);
                            if (!(list == null || list.isEmpty())) {
                                for (String sO : list) {
                                    iVar.sO(sO);
                                }
                            }
                            com.tencent.mm.plugin.favorite.c.a.u(iVar);
                            com.tencent.mm.plugin.report.service.g.iuh.h(10648, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                            com.tencent.mm.plugin.favorite.b.v.bN(iVar.field_localId);
                            long j = iVar.field_localId;
                            i bB = h.alu().bB(j);
                            if (bB != null && bB.field_favProto.mta != null) {
                                com.tencent.mm.plugin.favorite.c.a(j, bB.field_favProto.mta, "", "", new ArrayList(), this.fOT.nDR.nEl);
                            }
                        }
                    });
                    i3 = 0;
                    break;
                case 4098:
                    Context applicationContext = getApplicationContext();
                    ak.yW();
                    stringExtra = com.tencent.mm.pluginsdk.ui.tools.l.a(applicationContext, intent, com.tencent.mm.model.c.wP());
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_ImgPath", stringExtra);
                        com.tencent.mm.plugin.favorite.c.drp.a(this, intent2, 4099);
                        break;
                    }
                    v.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                    return;
                case 4099:
                    stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        i3 = 0;
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(stringExtra);
                        this.fMX.post(new Runnable(this) {
                            final /* synthetic */ FavoriteIndexUI fOT;

                            public final void run() {
                                this.fOT.fMR = true;
                                com.tencent.mm.plugin.favorite.b.l.ar(arrayList);
                            }
                        });
                        break;
                    }
                    v.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                    return;
                case 4100:
                    stringExtra2 = intent.getStringExtra("choosed_file_path");
                    if (!be.kS(stringExtra2)) {
                        File file = new File(stringExtra2);
                        if (file.exists()) {
                            if (file.length() < 26214400) {
                                Object obj;
                                if (be.kS(stringExtra2)) {
                                    obj = null;
                                } else {
                                    file = new File(stringExtra2);
                                    if (file.exists()) {
                                        i iVar = new i();
                                        iVar.field_type = 8;
                                        iVar.field_sourceType = 6;
                                        com.tencent.mm.plugin.favorite.b.l.f(iVar);
                                        iVar.field_favProto.Jl(file.getName());
                                        pw pwVar = new pw();
                                        pwVar.IK(stringExtra2);
                                        pwVar.ip(true);
                                        pwVar.Iw(file.getName());
                                        pwVar.uG(iVar.field_type);
                                        pwVar.IG(com.tencent.mm.a.e.aS(stringExtra2));
                                        iVar.field_favProto.mtR.add(pwVar);
                                        com.tencent.mm.plugin.favorite.c.a.u(iVar);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(10648, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                }
                                if (obj == null) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = 0;
                                this.fMR = true;
                                break;
                            }
                            i3 = 3;
                            break;
                        }
                        i3 = 1;
                        break;
                    }
                    i3 = 1;
                    break;
                case 4101:
                case 4102:
                    i3 = 0;
                    this.fMR = true;
                    break;
                case 4103:
                    long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                    if (-1 != longExtra) {
                        i3 = this.fON.bP(longExtra);
                        if (-1 != i3) {
                            this.fMU.removeFooterView(this.fMY);
                            this.fMU.setSelection(i3);
                            return;
                        }
                        return;
                    }
                    return;
                case 4104:
                    final List cZ = this.fON.cZ(false);
                    final String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                    if (!(cZ.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                        final p a = g.a(this.nDR.nEl, "", false, null);
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ FavoriteIndexUI fOT;

                            public final void run() {
                                com.tencent.mm.plugin.favorite.b.v.a(cZ, stringArrayExtra);
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 fOX;

                                    {
                                        this.fOX = r1;
                                    }

                                    public final void run() {
                                        a.dismiss();
                                    }

                                    public final String toString() {
                                        return super.toString() + "|batchAddFavTags";
                                    }
                                });
                            }
                        });
                        com.tencent.mm.plugin.report.service.g.iuh.h(11125, new Object[]{Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2)});
                        break;
                    }
                case 4105:
                    v.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    a(this.fON.cZ(false), stringExtra, r4);
                    break;
                case 4106:
                    v.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    List arrayList2 = new ArrayList();
                    arrayList2.add(this.fOS);
                    a(arrayList2, stringExtra, r4);
                    break;
            }
            if (i3 == 0) {
                g.bf(this.nDR.nEl, getString(2131232695));
            } else if (1 == i3) {
                g.bf(this.nDR.nEl, getString(2131232652));
            } else if (3 == i3) {
                Toast.makeText(this.nDR.nEl, getString(2131232747), 1).show();
            } else if (this.fON.fPo) {
                amG();
            }
        } else if ((this.fOS != null && this.fOS.field_type == 5) || (this.fOP != null && this.fOP.field_type == 5)) {
            stringExtra2 = "";
            if (this.fOP == null || this.fOP.field_favProto.mtP == null) {
                if (this.fOS.field_favProto.mtc != null) {
                    stringExtra2 = this.fOS.field_favProto.mtc.mur;
                }
                if (this.fOS.field_favProto.mtP != null && be.kS(r2)) {
                    stringExtra2 = this.fOS.field_favProto.mtP.cZp;
                }
            } else {
                stringExtra2 = this.fOP.field_favProto.mtP.cZp;
            }
            if (!be.kS(stringExtra2)) {
                v.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
                stringExtra = "";
                try {
                    stringExtra2 = URLEncoder.encode(stringExtra2, "UTF-8");
                } catch (Throwable e) {
                    v.a("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                    stringExtra2 = stringExtra;
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(13378, new Object[]{stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void bO(long j) {
        if (this.fON.fPo) {
            com.tencent.mm.plugin.favorite.ui.base.b bVar = this.fOO;
            boolean z = this.fON.amQ() > 0;
            if (bVar.fPG) {
                bVar.fPL.setEnabled(z);
                bVar.fPM.setEnabled(z);
                bVar.fPN.setEnabled(z);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(0, 10, 0, 2131235684);
        add.setIcon(2131165207);
        android.support.v4.view.l.a(add, 2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 10) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this.nDR.nEl, FavSearchUI.class);
        if (this.fON.fPo) {
            intent.putExtra("key_search_type", 2);
            startActivityForResult(intent, 4103);
        } else {
            startActivity(intent);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.FavoriteIndexUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                    intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                    intent.putExtra("map_view_type", 3);
                    com.tencent.mm.plugin.favorite.c.drp.a(intent, 4097, this);
                    return;
                }
                g.a(this, getString(2131234162), "", getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI fOT;

                    {
                        this.fOT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.fOT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI fOT;

                    {
                        this.fOT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case 80:
                if (iArr[0] == 0) {
                    startActivityForResult(new Intent(this, FavPostVoiceUI.class), 4102);
                    overridePendingTransition(0, 0);
                    return;
                }
                g.a(this, getString(2131234163), "", getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI fOT;

                    {
                        this.fOT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.fOT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI fOT;

                    {
                        this.fOT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            default:
                return;
        }
    }

    public final void amH() {
        this.nDR.nEl.startActivity(new Intent(this.nDR.nEl, FavCleanUI.class));
    }
}
