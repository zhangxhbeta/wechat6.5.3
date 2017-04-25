package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.brandservice.ui.base.BaseSortView;
import com.tencent.mm.plugin.brandservice.ui.base.f;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    String eyL;
    boolean eyS;
    private ListView eyT;
    int eyU = -1;
    b eyV;
    private a eyW;

    private static class a implements e {
        p dwg;
        public String eyY;
        l eyZ;
        WeakReference<EnterpriseBizContactListView> eza;

        class AnonymousClass1 implements OnCreateContextMenuListener {
            final /* synthetic */ a ezb;
            final /* synthetic */ int kz;

            AnonymousClass1(a aVar, int i) {
                this.ezb = aVar;
                this.kz = i;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(this.kz, 1, 0, 2131232469);
            }
        }

        class AnonymousClass3 implements OnClickListener {
            final /* synthetic */ String chh;
            final /* synthetic */ a ezb;
            final /* synthetic */ Context val$context;

            AnonymousClass3(a aVar, String str, Context context) {
                this.ezb = aVar;
                this.chh = str;
                this.val$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                final com.tencent.mm.plugin.profile.a.c cVar = new com.tencent.mm.plugin.profile.a.c(this.chh, true);
                ak.vy().a(1394, this.ezb);
                ak.vy().a(cVar, 0);
                a aVar = this.ezb;
                Context context = this.val$context;
                this.val$context.getString(2131231164);
                aVar.dwg = g.a(context, this.val$context.getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass3 ezd;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(cVar);
                        ak.vy().b(1394, this.ezd.ezb);
                    }
                });
            }
        }

        public a(EnterpriseBizContactListView enterpriseBizContactListView) {
            this.eza = new WeakReference(enterpriseBizContactListView);
        }

        protected final void finalize() {
            ak.vy().b(1394, this);
            super.finalize();
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.dismiss();
            }
            if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
                ays aGA = ((com.tencent.mm.plugin.profile.a.c) kVar).aGA();
                ayt aGz = ((com.tencent.mm.plugin.profile.a.c) kVar).aGz();
                if (aGz == null || aGz.mhP == null || aGz.mhP.ret != 0) {
                    if (aGz == null || aGz.mhP == null) {
                        v.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                        return;
                    }
                    v.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(aGz.mhP.ret)});
                } else if (aGA.mVW) {
                    BizInfo hw = com.tencent.mm.modelbiz.e.hw(aGA.mhJ);
                    hw.field_brandFlag |= 1;
                    ail com_tencent_mm_protocal_c_ail = new ail();
                    com_tencent_mm_protocal_c_ail.cHq = hw.field_brandFlag;
                    com_tencent_mm_protocal_c_ail.gln = aGA.mhJ;
                    ak.yW();
                    com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.j.a(47, com_tencent_mm_protocal_c_ail));
                    u.Dy().a(hw, new String[0]);
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mf(hw.field_username);
                    ak.yW();
                    if (com.tencent.mm.model.c.wK().Mq(hw.field_enterpriseFather) <= 0) {
                        ak.yW();
                        com.tencent.mm.model.c.wK().Mf(hw.field_enterpriseFather);
                    } else {
                        ak.yW().cra.Lx(hw.field_enterpriseFather);
                    }
                    EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.eza.get();
                    if (enterpriseBizContactListView != null) {
                        enterpriseBizContactListView.refresh();
                    }
                }
            }
        }
    }

    public interface b {
        boolean Yv();
    }

    public static class c {
        public View dtW;
        ImageView dtX;
        TextView euh;
        public TextView exF;
        ImageView eze;
        View ezf;
        String iconUrl;
        String username;
    }

    private class d implements Comparator<f> {
        final /* synthetic */ EnterpriseBizContactListView eyX;

        private d(EnterpriseBizContactListView enterpriseBizContactListView) {
            this.eyX = enterpriseBizContactListView;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            f fVar = (f) obj;
            f fVar2 = (f) obj2;
            String str = fVar.eAs;
            String str2 = fVar2.eAs;
            int compareToIgnoreCase = (str == null || str2 == null) ? 0 : str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase != 0) {
                if (str.equalsIgnoreCase("#")) {
                    compareToIgnoreCase = 1;
                }
                return str2.equalsIgnoreCase("#") ? -1 : compareToIgnoreCase;
            } else {
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
                com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) fVar2.data;
                if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                    int tm = bVar.euW.tm();
                    int tm2 = bVar2.euW.tm();
                    Object obj3 = ((tm < 97 || tm > bu.CTRL_INDEX) && (tm < 65 || tm > 90)) ? 1 : null;
                    Object obj4 = ((tm2 < 97 || tm2 > bu.CTRL_INDEX) && (tm2 < 65 || tm2 > 90)) ? 1 : null;
                    if (obj3 != null && obj4 == null) {
                        return 1;
                    }
                    if (obj3 == null && obj4 != null) {
                        return -1;
                    }
                }
                int compareToIgnoreCase2 = (bVar.euW == null || bVar.euW.pF() == null || bVar.euW.pF().length() <= 0 || bVar2.euW == null || bVar2.euW.pF() == null || bVar2.euW.pF().length() <= 0) ? 0 : bVar.euW.pF().compareToIgnoreCase(bVar2.euW.pF());
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase2 = (bVar.euW == null || bVar.euW.field_nickname == null || bVar.euW.field_nickname.length() <= 0 || bVar2.euW == null || bVar2.euW.field_nickname == null || bVar2.euW.field_nickname.length() <= 0) ? 0 : bVar.euW.field_nickname.compareToIgnoreCase(bVar2.euW.field_nickname);
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase = (bVar.euW == null || bVar.euW.field_username == null || bVar.euW.field_username.length() <= 0 || bVar2.euW == null || bVar2.euW.field_username == null || bVar2.euW.field_username.length() <= 0) ? 0 : bVar.euW.field_username.compareToIgnoreCase(bVar2.euW.field_username);
                return compareToIgnoreCase == 0 ? 0 : compareToIgnoreCase;
            }
        }
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i) {
        if (textView != null && !be.kS(str)) {
            try {
                textView.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.a(context, str, i)));
            } catch (Exception e) {
                textView.setText("");
            }
        }
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void refresh() {
        List arrayList = new ArrayList();
        u.Dy();
        Cursor u = com.tencent.mm.modelbiz.d.u(this.eyL, this.eyS);
        while (u.moveToNext()) {
            com.tencent.mm.plugin.brandservice.a.b bVar = new com.tencent.mm.plugin.brandservice.a.b();
            if (u != null) {
                com.tencent.mm.storage.u uVar = new com.tencent.mm.storage.u();
                uVar.b(u);
                BizInfo bizInfo = new BizInfo();
                bizInfo.b(u);
                bVar.userName = uVar.field_username;
                bVar.euW = uVar;
                bVar.exj = bizInfo;
            }
            if (bVar.euW != null) {
                f fVar = new f();
                fVar.data = bVar;
                if (bVar.exj.CB()) {
                    fVar.eAs = "!1";
                } else if (bVar.euW.tP()) {
                    fVar.eAs = "!2";
                } else {
                    int tm = bVar.euW.tm();
                    if (tm >= 97 && tm <= bu.CTRL_INDEX) {
                        tm -= 32;
                    }
                    if (tm < 65 || tm > 90) {
                        fVar.eAs = "#";
                    } else {
                        fVar.eAs = ((char) tm);
                    }
                }
                arrayList.add(fVar);
            }
        }
        u.close();
        this.eyU = arrayList.size();
        Collections.sort(arrayList, new d());
        Z(arrayList);
        super.refresh();
    }

    public final void Yw() {
        this.abT = new OnItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactListView eyX;

            {
                this.eyX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof c)) {
                    c cVar = (c) tag;
                    if (!be.kS(cVar.username)) {
                        boolean hD = com.tencent.mm.modelbiz.e.hD(cVar.username);
                        boolean hC = com.tencent.mm.modelbiz.e.hC(cVar.username);
                        BizInfo hw = com.tencent.mm.modelbiz.e.hw(cVar.username);
                        String CD = hw == null ? null : hw.CD();
                        if (CD == null) {
                            CD = "";
                        }
                        if (hD) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", CD);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", cVar.username);
                            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent.addFlags(67108864);
                            com.tencent.mm.ay.c.b(this.eyX.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        } else if (hC) {
                            r1 = new Intent();
                            r1.putExtra("Contact_User", cVar.username);
                            r1.addFlags(67108864);
                            r1.putExtra("biz_chat_from_scene", 3);
                            com.tencent.mm.ay.c.a(this.eyX.getContext(), ".ui.bizchat.BizChatConversationUI", r1);
                        } else {
                            r1 = new Intent();
                            r1.addFlags(67108864);
                            r1.putExtra("finish_direct", true);
                            r1.putExtra("Chat_User", cVar.username);
                            r1.putExtra("chat_from_scene", 2);
                            Context context = this.eyX.getContext();
                            v.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                            com.tencent.mm.plugin.brandservice.a.drp.e(r1, context);
                        }
                    }
                }
            }
        };
        if (this.mMode == 0) {
            this.dWv = new OnItemLongClickListener(this) {
                final /* synthetic */ EnterpriseBizContactListView eyX;

                {
                    this.eyX = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.eyX.eyW == null) {
                        this.eyX.eyW = new a(this.eyX);
                    }
                    a a = this.eyX.eyW;
                    if (a.eyZ == null) {
                        EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.eza.get();
                        if (enterpriseBizContactListView == null) {
                            return false;
                        }
                        a.eyZ = new l(enterpriseBizContactListView.getContext());
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        return false;
                    }
                    a.eyY = ((c) tag).username;
                    if (be.kS(a.eyY) || com.tencent.mm.modelbiz.e.hC(a.eyY)) {
                        return false;
                    }
                    a.eyZ.a(adapterView, i, j, new AnonymousClass1(a, i), new com.tencent.mm.ui.base.n.d(a) {
                        final /* synthetic */ a ezb;

                        {
                            this.ezb = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            if (!be.kS(this.ezb.eyY) && menuItem.getItemId() == 1) {
                                a aVar = this.ezb;
                                String str = this.ezb.eyY;
                                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) aVar.eza.get();
                                if (enterpriseBizContactListView != null) {
                                    Context context = enterpriseBizContactListView.getContext();
                                    g.b(context, context.getString(2131232460), "", context.getString(2131232459), context.getString(2131231010), new AnonymousClass3(aVar, str, context), null);
                                }
                            }
                        }
                    });
                    return true;
                }
            };
        }
    }

    public static void release() {
        u.DG().Ds();
    }

    public final boolean a(String str, f fVar) {
        if (!(be.kS(str) || fVar == null)) {
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
            if (bVar == null) {
                return false;
            }
            String tU = bVar.euW.tU();
            String pE = bVar.euW.pE();
            String pF = bVar.euW.pF();
            String toUpperCase = str.toUpperCase();
            if (!(be.kS(tU) || tU.toUpperCase().indexOf(toUpperCase) == -1) || (!(be.kS(pE) || pE.toUpperCase().indexOf(toUpperCase) == -1) || (!be.kS(pF) && pF.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), 2130903528, this);
    }

    public final VerticalScrollBar Yx() {
        return (VerticalScrollBar) findViewById(2131755706);
    }

    public final ListView getListView() {
        this.eyT = (ListView) findViewById(2131755705);
        return this.eyT;
    }

    public final View Yy() {
        TextView textView = (TextView) findViewById(2131755704);
        textView.setText(2131232470);
        return textView;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.e.a Yz() {
        return new com.tencent.mm.plugin.brandservice.ui.base.e.a(this) {
            final /* synthetic */ EnterpriseBizContactListView eyX;

            {
                this.eyX = r1;
            }

            public final View a(f fVar, View view, boolean z, boolean z2) {
                c cVar;
                long Nj = be.Nj();
                Context context = this.eyX.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(2130903525, null);
                    cVar = new c();
                    cVar.exF = (TextView) view.findViewById(2131755697);
                    cVar.dtW = view.findViewById(2131755698);
                    cVar.dtX = (ImageView) view.findViewById(2131755700);
                    cVar.eze = (ImageView) view.findViewById(2131755703);
                    cVar.euh = (TextView) view.findViewById(2131755702);
                    cVar.ezf = view.findViewById(2131755699);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
                if (bVar == null) {
                    v.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
                } else {
                    Object obj = null;
                    if (bVar.exj.CB()) {
                        obj = 1;
                    }
                    if (this.eyX.ezQ && z) {
                        if (fVar.eAs.equals("!2")) {
                            cVar.exF.setText(this.eyX.getContext().getString(2131232476));
                            cVar.exF.setVisibility(0);
                        } else if (!fVar.eAs.equals("!1")) {
                            cVar.exF.setText(fVar.eAs);
                            cVar.exF.setVisibility(0);
                        }
                        if (obj == null) {
                            cVar.username = bVar.userName;
                            cVar.dtX.setImageResource(2131165495);
                            EnterpriseBizContactListView.a(cVar.euh, context, this.eyX.getResources().getString(2131232456), (int) cVar.euh.getTextSize());
                        } else {
                            cVar.username = bVar.userName;
                            cVar.iconUrl = bVar.exj.field_brandIconURL;
                            cVar.dtX.setTag(bVar.userName);
                            com.tencent.mm.pluginsdk.ui.a.b.m(cVar.dtX, cVar.username);
                            EnterpriseBizContactListView.a(cVar.euh, context, bVar.euW.tU(), (int) cVar.euh.getTextSize());
                        }
                        v.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar.exj.field_status)});
                        cVar.eze.setVisibility(bVar.exj.field_status != 1 ? 0 : 8);
                        if (this.eyX.mMode == 0 || !z2) {
                            cVar.ezf.setBackgroundResource(2130838468);
                        } else {
                            cVar.ezf.setBackgroundResource(2130838048);
                        }
                        if (this.eyX.ezR) {
                            cVar.dtW.setPadding(cVar.dtW.getPaddingLeft(), cVar.dtW.getPaddingTop(), (int) this.eyX.getContext().getResources().getDimension(2131493168), cVar.dtW.getPaddingBottom());
                        } else {
                            cVar.dtW.setPadding(cVar.dtW.getPaddingLeft(), cVar.dtW.getPaddingTop(), (int) this.eyX.getContext().getResources().getDimension(2131492961), cVar.dtW.getPaddingBottom());
                        }
                        v.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(be.az(Nj))});
                    }
                    cVar.exF.setVisibility(8);
                    if (obj == null) {
                        cVar.username = bVar.userName;
                        cVar.iconUrl = bVar.exj.field_brandIconURL;
                        cVar.dtX.setTag(bVar.userName);
                        com.tencent.mm.pluginsdk.ui.a.b.m(cVar.dtX, cVar.username);
                        EnterpriseBizContactListView.a(cVar.euh, context, bVar.euW.tU(), (int) cVar.euh.getTextSize());
                    } else {
                        cVar.username = bVar.userName;
                        cVar.dtX.setImageResource(2131165495);
                        EnterpriseBizContactListView.a(cVar.euh, context, this.eyX.getResources().getString(2131232456), (int) cVar.euh.getTextSize());
                    }
                    v.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar.exj.field_status)});
                    if (bVar.exj.field_status != 1) {
                    }
                    cVar.eze.setVisibility(bVar.exj.field_status != 1 ? 0 : 8);
                    if (this.eyX.mMode == 0) {
                    }
                    cVar.ezf.setBackgroundResource(2130838468);
                    if (this.eyX.ezR) {
                        cVar.dtW.setPadding(cVar.dtW.getPaddingLeft(), cVar.dtW.getPaddingTop(), (int) this.eyX.getContext().getResources().getDimension(2131493168), cVar.dtW.getPaddingBottom());
                    } else {
                        cVar.dtW.setPadding(cVar.dtW.getPaddingLeft(), cVar.dtW.getPaddingTop(), (int) this.eyX.getContext().getResources().getDimension(2131492961), cVar.dtW.getPaddingBottom());
                    }
                    v.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(be.az(Nj))});
                }
                return view;
            }
        };
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eyV != null) {
            this.eyV.Yv();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
