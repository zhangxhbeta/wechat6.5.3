package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.modelsearch.i;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, com.tencent.mm.plugin.brandservice.a.d.a, com.tencent.mm.plugin.brandservice.ui.base.BaseSortView.a {
    private boolean Tg;
    private String dRA;
    private HashMap<String, SpannableString> eAa = new HashMap();
    private d eAb = new d();
    private int eAc = 251658241;
    private l eAd;
    private boolean eAe = false;
    public a eAf;
    private String eAg;
    private View eAh;
    private TextView eAi;
    private n.d eAj = new n.d(this) {
        final /* synthetic */ BrandServiceSortView eAk;

        {
            this.eAk = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            if (be.kS(this.eAk.dRA)) {
                v.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
            } else if (menuItem.getItemId() == 0) {
                v.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[]{Integer.valueOf(i)});
                ak.yW();
                u LX = c.wH().LX(this.eAk.dRA);
                BrandServiceSortView.a(this.eAk, e.hw(this.eAk.dRA), this.eAk.getContext(), LX, menuItem.getGroupId());
            }
        }
    };
    public boolean eyG;
    private ListView ezM;

    public interface a {
        boolean Yv();
    }

    public static class b implements com.tencent.mm.modelbiz.j.a.a {
        static Bitmap eAm = null;
        public View dtW;
        ImageView dtX;
        TextView euh;
        public TextView exF;
        ImageView eze;
        View ezf;
        String iconUrl;
        String username;

        public b() {
            com.tencent.mm.modelbiz.u.DG().a(this);
        }

        public final void YJ() {
            if (this.dtX != null) {
                Bitmap b = j.b(this.username, this.iconUrl, 0);
                if (b == null) {
                    this.dtX.setImageResource(2130837790);
                } else if (be.kS(this.username) || this.dtX.getTag() == null) {
                    v.e("MicroMsg.BrandServiceSortView", "error in refreshAvatar, %s", new Object[]{this.username});
                } else if (this.username.equals(this.dtX.getTag())) {
                    this.dtX.setImageBitmap(b);
                }
            }
        }

        public final void hO(String str) {
            if (str != null && str.equals(this.username)) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ b eAn;

                    {
                        this.eAn = r1;
                    }

                    public final void run() {
                        this.eAn.YJ();
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, TextView textView, Context context, String str, int i) {
        if (textView == null) {
            v.w("MicroMsg.BrandServiceSortView", "display area is null");
        } else if (be.kS(str)) {
            v.w("MicroMsg.BrandServiceSortView", "remark is null");
        } else {
            SpannableString spannableString = (SpannableString) brandServiceSortView.eAa.get(str);
            if (spannableString == null) {
                try {
                    v.d("MicroMsg.BrandServiceSortView", "new one %s", new Object[]{str});
                    CharSequence spannableString2 = new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.a(context, str, i));
                    brandServiceSortView.eAa.put(str, spannableString2);
                    textView.setText(spannableString2);
                    return;
                } catch (Exception e) {
                    v.w("MicroMsg.BrandServiceSortView", "error, set empty str");
                    textView.setText("");
                    return;
                }
            }
            v.v("MicroMsg.BrandServiceSortView", "match one %s", new Object[]{str});
            textView.setText(spannableString);
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, BizInfo bizInfo, final Context context, u uVar, final int i) {
        v.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog");
        if (bizInfo == null || context == null || !(context instanceof Activity) || uVar == null) {
            v.e("MicroMsg.BrandServiceSortView", "bizInfo(%s) or context(%s) or contact(%s) is null", new Object[]{bizInfo, context, uVar});
            return;
        }
        final String str = uVar.field_username;
        ak.vA().x(new Runnable(brandServiceSortView) {
            final /* synthetic */ BrandServiceSortView eAk;

            public final void run() {
                BizInfo ho = com.tencent.mm.modelbiz.u.Dy().ho(str);
                ak.yW();
                com.tencent.mm.plugin.brandservice.a.drq.a(ho, (Activity) context, c.wH().LX(str), false, new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 eAl;

                    {
                        this.eAl = r1;
                    }

                    public final void run() {
                        List list = this.eAl.eAk.ezO.ezP;
                        if (i >= 0 && list != null && i < list.size()) {
                            list.remove(i);
                            ad.o(this.eAl.eAk.ezO.eAq);
                        }
                    }
                });
            }
        });
    }

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        L(false);
        refresh();
        d dVar = this.eAb;
        if (!(this == null || dVar.exl.contains(this))) {
            v.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            dVar.exl.add(this);
        }
        this.eAd = new l(getContext());
        this.ezS = this;
        this.abT = new OnItemClickListener(this) {
            final /* synthetic */ BrandServiceSortView eAk;

            {
                this.eAk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof b)) {
                    v.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
                    return;
                }
                b bVar = (b) tag;
                if (be.kS(bVar.username)) {
                    v.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
                    return;
                }
                i.jF(bVar.username);
                t.h(this.eAk.eAg, 12, 4, i - 1);
                if (this.eAk.eyG) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", bVar.username);
                    intent.putExtra("Select_Conv_User", bVar.username);
                    if (this.eAk.getContext() instanceof Activity) {
                        Activity activity = (Activity) this.eAk.getContext();
                        activity.setResult(-1, intent);
                        activity.finish();
                        return;
                    }
                }
                String str = bVar.username;
                Context context = this.eAk.getContext();
                v.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                Intent putExtra = new Intent().putExtra("Chat_User", str);
                putExtra.putExtra("finish_direct", true);
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                com.tencent.mm.plugin.brandservice.a.drp.e(putExtra, context);
            }
        };
        this.dWv = this;
    }

    public final void refresh() {
        List list;
        List list2;
        this.eAb.init();
        d dVar = this.eAb;
        switch (this.eAc) {
            case 2:
                list = dVar.exn;
                break;
            default:
                list = dVar.exo;
                break;
        }
        if (list != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) list.get(i);
                if (!(bVar == null || bVar.euW == null)) {
                    f fVar = new f();
                    fVar.data = bVar;
                    int i2 = bVar.euW.field_showHead;
                    if (i2 >= 97 && i2 <= bu.CTRL_INDEX) {
                        i2 -= 32;
                    }
                    if (i2 < 65 || i2 > 90) {
                        fVar.eAs = "#";
                    } else {
                        fVar.eAs = ((char) i2);
                    }
                    arrayList.add(fVar);
                }
            }
            list2 = arrayList;
        } else {
            list2 = null;
        }
        Z(list2);
        super.refresh();
    }

    public final void release() {
        com.tencent.mm.modelbiz.u.DG().Ds();
        d dVar = this.eAb;
        if (this == null) {
            v.w("MicroMsg.BrandService.BrandServiceMgr", "removeListener:onChange is null");
            dVar.exl.remove(null);
        }
        d dVar2 = this.eAb;
        ak.vy().b(387, dVar2);
        if (dVar2.exm) {
            List arrayList = new ArrayList(dVar2.exn.size() + dVar2.exo.size());
            for (com.tencent.mm.plugin.brandservice.a.b add : dVar2.exn) {
                arrayList.add(add);
            }
            for (com.tencent.mm.plugin.brandservice.a.b add2 : dVar2.exo) {
                arrayList.add(add2);
            }
            ak.vy().a(new k(arrayList), 0);
        }
    }

    public final boolean a(String str, f fVar) {
        if (!(be.kS(str) || fVar == null)) {
            this.eAg = str;
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
            if (bVar == null || bVar.euW == null) {
                v.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                return false;
            }
            u uVar = bVar.euW;
            String tU = uVar.tU();
            String pE = uVar.pE();
            String pF = uVar.pF();
            String toUpperCase = str.toUpperCase();
            if (!(be.kS(tU) || tU.toUpperCase().indexOf(toUpperCase) == -1) || (!(be.kS(pE) || pE.toUpperCase().indexOf(toUpperCase) == -1) || (!be.kS(pF) && pF.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), 2130903197, this);
    }

    public final VerticalScrollBar Yx() {
        return (VerticalScrollBar) findViewById(2131755706);
    }

    public final ListView getListView() {
        this.ezM = (ListView) findViewById(2131755705);
        if (this.eAh == null) {
            this.eAh = inflate(getContext(), 2130903435, null);
            if (!(this.ezM == null || this.eAh == null)) {
                this.eAi = (TextView) this.eAh.findViewById(2131756548);
                this.ezM.addFooterView(this.eAh, null, false);
            }
        }
        return this.ezM;
    }

    public final View Yy() {
        return findViewById(2131755704);
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.e.a Yz() {
        return new com.tencent.mm.plugin.brandservice.ui.base.e.a(this) {
            final /* synthetic */ BrandServiceSortView eAk;

            {
                this.eAk = r1;
            }

            public final View a(f fVar, View view, boolean z, boolean z2) {
                b bVar;
                long Nj = be.Nj();
                Context context = this.eAk.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(2130903196, null);
                    bVar = new b();
                    bVar.exF = (TextView) view.findViewById(2131755697);
                    bVar.dtW = view.findViewById(2131755698);
                    bVar.dtX = (ImageView) view.findViewById(2131755700);
                    bVar.eze = (ImageView) view.findViewById(2131755703);
                    bVar.euh = (TextView) view.findViewById(2131755702);
                    bVar.ezf = view.findViewById(2131755699);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
                if (bVar2 == null) {
                    v.e("MicroMsg.BrandServiceSortView", "should not be empty");
                } else {
                    if (this.eAk.ezQ && z) {
                        bVar.exF.setText(fVar.eAs);
                        bVar.exF.setVisibility(0);
                    } else {
                        bVar.exF.setVisibility(8);
                    }
                    bVar.username = bVar2.userName;
                    bVar.iconUrl = bVar2.exj.field_brandIconURL;
                    bVar.dtX.setTag(bVar2.userName);
                    bVar.YJ();
                    BrandServiceSortView.a(this.eAk, bVar.euh, context, bVar2.euW.tU(), (int) bVar.euh.getTextSize());
                    v.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar2.exj.field_status)});
                    ImageView imageView = bVar.eze;
                    int i = (this.eAk.eAe && bVar2.exj.field_status == 1) ? 0 : 8;
                    imageView.setVisibility(i);
                    if (this.eAk.mMode == 0 && z2) {
                        bVar.ezf.setBackgroundResource(2130838048);
                    } else {
                        bVar.ezf.setBackgroundResource(2130838468);
                    }
                    if (this.eAk.ezR) {
                        bVar.dtW.setPadding(bVar.dtW.getPaddingLeft(), bVar.dtW.getPaddingTop(), (int) this.eAk.getContext().getResources().getDimension(2131492961), bVar.dtW.getPaddingBottom());
                    } else {
                        bVar.dtW.setPadding(bVar.dtW.getPaddingLeft(), bVar.dtW.getPaddingTop(), (int) this.eAk.getContext().getResources().getDimension(2131493168), bVar.dtW.getPaddingBottom());
                    }
                    v.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[]{Long.valueOf(be.az(Nj))});
                }
                return view;
            }
        };
    }

    public final void Yj() {
        refresh();
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.eAd.a(adapterView, i, j, this, this.eAj);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (contextMenuInfo == null) {
            v.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            return;
        }
        v.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        f fVar = (f) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (fVar == null || fVar.data == null) {
            v.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[]{fVar});
            return;
        }
        u uVar = ((com.tencent.mm.plugin.brandservice.a.b) fVar.data).euW;
        if (uVar == null) {
            v.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            return;
        }
        this.dRA = uVar.field_username;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(getContext(), uVar.tU()));
        BizInfo hw = e.hw(uVar.field_username);
        if (hw != null && !hw.Cy()) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, 2131233702);
        }
    }

    public final void aa(List<f> list) {
        if (this.eAi != null && list != null) {
            this.eAi.setText(getContext().getString(2131231551, new Object[]{Integer.valueOf(list.size())}));
        }
    }

    public final void L(boolean z) {
        this.Tg = z;
        BaseSortView.h(this.eAi, z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eAf != null) {
            this.eAf.Yv();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
