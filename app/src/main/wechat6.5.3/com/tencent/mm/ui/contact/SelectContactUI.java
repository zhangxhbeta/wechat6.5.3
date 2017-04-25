package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.h;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class SelectContactUI extends MMBaseSelectContactUI implements e {
    private String biB;
    private TextView dMQ;
    private HashSet<String> dud;
    private ProgressDialog dwR;
    private String eCW;
    private int eSM;
    private List<String> ejp;
    private int oEe;
    private boolean oIA = false;
    private TextView oIj;
    private TextView oIk;
    private TextView oIl;
    private TextView oIm;
    private HashSet<String> oIn;
    private boolean oIo;
    private boolean oIp;
    private String oIq;
    private String oIr;
    private boolean oIs;
    private ig oIt;
    private boolean oIu;
    private boolean oIv = true;
    private boolean oIw = false;
    private String oIx;
    private AlphaAnimation oIy;
    private AlphaAnimation oIz;
    private b ovN = new b(this) {
        final /* synthetic */ SelectContactUI oIB;

        {
            this.oIB = r2;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.sdk.c.b bVar) {
            if (bVar instanceof ig) {
                ig igVar = (ig) bVar;
                if (this.oIB.oIt != null) {
                    if (this.oIB.dwR != null) {
                        this.oIB.dwR.dismiss();
                        this.oIB.dwR = null;
                    }
                    this.oIB.oIt = null;
                    this.oIB.oIs = false;
                    this.oIB.biB = igVar.bip.bit;
                    if (!a.a(this.oIB, i, i2, str, 4)) {
                        int i3;
                        if (i == 0 && i2 == 0 && !be.kS(this.oIB.biB)) {
                            h.a(this.oIB.biB, igVar.bip.biy, this.oIB.getString(2131231756), false, SQLiteDatabase.KeyEmpty);
                            List list = igVar.bip.bix;
                            if (list != null && list.size() > 0) {
                                List linkedList = new LinkedList();
                                for (i3 = 0; i3 < list.size(); i3++) {
                                    linkedList.add(list.get(i3));
                                }
                                h.a(this.oIB.biB, linkedList, this.oIB.getString(2131231757), true, "weixin://findfriend/verifycontact/" + this.oIB.biB + "/");
                            }
                            this.oIB.cE(be.g(new String[]{this.oIB.biB}));
                            return;
                        }
                        String str2 = SQLiteDatabase.KeyEmpty;
                        String str3 = SQLiteDatabase.KeyEmpty;
                        String string = aa.getContext().getString(2131231758);
                        if (i2 == -23) {
                            str2 = this.oIB.getString(2131234619);
                            str3 = this.oIB.getString(2131234618);
                        }
                        List list2 = igVar.bip.bix;
                        List list3 = igVar.bip.biv;
                        if (list2 == null || list2.size() <= 0 || (list2.size() != igVar.bip.bis && (list3 == null || list3.size() <= 0 || igVar.bip.bis != list2.size() + list3.size()))) {
                            list2 = igVar.bip.biv;
                            if (list2 != null && list2.size() > 0 && igVar.bip.bis == list2.size()) {
                                str2 = this.oIB.getString(2131233496);
                                str3 = str3 + this.oIB.getString(2131232876, new Object[]{be.b(SelectContactUI.ah(list2), string)});
                            }
                            list2 = igVar.bip.biu;
                            if (list2 != null && list2.size() > 0) {
                                str2 = this.oIB.getString(2131233496);
                                str3 = str3 + this.oIB.getString(2131232877, new Object[]{be.b(SelectContactUI.ah(list2), string)});
                            }
                            if (str2 == null || str2.length() <= 0) {
                                Toast.makeText(this.oIB, this.oIB.getString(2131232865, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                                return;
                            }
                            g.A(this.oIB, str3, str2);
                            return;
                        }
                        LinkedList linkedList2 = new LinkedList();
                        for (i3 = 0; i3 < list2.size(); i3++) {
                            linkedList2.add(list2.get(i3));
                        }
                        SelectContactUI.a(this.oIB, linkedList2, list3);
                    }
                }
            }
        }
    };
    private String title;

    static /* synthetic */ void a(SelectContactUI selectContactUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new j(selectContactUI, new j.a(selectContactUI) {
            final /* synthetic */ SelectContactUI oIB;

            {
                this.oIB = r1;
            }

            public final void cr(boolean z) {
            }
        }).f(linkedList, linkedList2);
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, final LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = aa.getContext().getString(2131231758);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        g.a((Context) selectContactUI, selectContactUI.getString(2131232885, new Object[]{be.b(ah(arrayList), string)}), selectContactUI.getString(2131233496), selectContactUI.getString(2131232884), selectContactUI.getString(2131232883), true, new OnClickListener(selectContactUI) {
            final /* synthetic */ SelectContactUI oIB;

            public final void onClick(DialogInterface dialogInterface, int i) {
                SelectContactUI.a(this.oIB, linkedList);
            }
        }, null);
    }

    static /* synthetic */ void d(SelectContactUI selectContactUI) {
        List jZ = selectContactUI.jZ(false);
        jZ.remove(k.xF());
        if (jZ.size() == 1) {
            selectContactUI.finish();
            selectContactUI.a(ChattingUI.class, new Intent().putExtra("Chat_User", (String) jZ.get(0)));
            return;
        }
        selectContactUI.oIt = new ig();
        selectContactUI.oIt.bio.biq = SQLiteDatabase.KeyEmpty;
        selectContactUI.oIt.bio.bir = jZ;
        com.tencent.mm.sdk.c.a.nhr.z(selectContactUI.oIt);
        selectContactUI.getString(2131231164);
        selectContactUI.dwR = g.a((Context) selectContactUI, selectContactUI.getString(2131233497), true, new OnCancelListener(selectContactUI) {
            final /* synthetic */ SelectContactUI oIB;

            {
                this.oIB = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.oIB.oIs = false;
                if (this.oIB.oIt != null) {
                    this.oIB.oIt.bio.bin = true;
                    com.tencent.mm.sdk.c.a.nhr.z(this.oIB.oIt);
                }
            }
        });
    }

    protected final void NH() {
        super.NH();
        this.eSM = getIntent().getIntExtra("list_attr", r.oHI);
        this.title = getIntent().getStringExtra("titile");
        this.eCW = getIntent().getStringExtra("sub_title");
        this.oEe = getIntent().getIntExtra("list_type", -1);
        this.oIv = getIntent().getBooleanExtra("show_too_many_member", true);
        if (m.yq().size() == 0) {
            r.do(this.eSM, FileUtils.S_IRUSR);
        }
        this.oIo = getIntent().getBooleanExtra("Add_SendCard", false);
        this.oIp = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.oIo || this.oIp) {
            this.oIq = be.ah(getIntent().getStringExtra("be_send_card_name"), SQLiteDatabase.KeyEmpty);
            this.oIr = be.ah(getIntent().getStringExtra("received_card_name"), SQLiteDatabase.KeyEmpty);
        }
        this.ejp = new ArrayList();
        this.dud = new HashSet();
        this.oIn = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!be.kS(stringExtra)) {
            this.oIn.addAll(be.g(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!be.kS(stringExtra)) {
            this.dud.addAll(be.g(stringExtra.split(",")));
        }
        Collection hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!be.kS(stringExtra2)) {
            hashSet.addAll(be.g(stringExtra2.split(",")));
        }
        Collection hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(r.bHP());
        hashSet2.addAll(r.bHQ());
        if (this.oIo) {
            hashSet2.removeAll(r.bHP());
        }
        this.ejp.addAll(hashSet2);
        bHW();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(30, (e) this);
        ak.vy().a(138, (e) this);
        b.a(ig.class.getName(), this.ovN);
        v.i("MicroMsg.SelectContactUI", "create!");
        if (!be.kS(this.eCW)) {
            NY(this.eCW);
        }
        if (r.dn(this.eSM, 64)) {
            a(1, getString(2131231107), new OnMenuItemClickListener(this) {
                final /* synthetic */ SelectContactUI oIB;

                {
                    this.oIB = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean z = r.dn(this.oIB.eSM, 4096) && this.oIB.jZ(r.dn(this.oIB.eSM, 8192)).size() > 1;
                    if (!z) {
                        return this.oIB.cE(this.oIB.jY(r.dn(this.oIB.eSM, 8192)));
                    }
                    if (!this.oIB.oIs) {
                        this.oIB.oIs = true;
                        SelectContactUI.d(this.oIB);
                    }
                    v.i("MicroMsg.SelectContactUI", "Create the chatroom");
                    return true;
                }
            }, com.tencent.mm.ui.k.b.nET);
        }
        NN();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectContactUI oIB;

            {
                this.oIB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oIB.axg();
                this.oIB.finish();
                if (!this.oIB.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    ad.g(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 oIC;

                        {
                            this.oIC = r1;
                        }

                        public final void run() {
                            this.oIC.oIB.moveTaskToBack(true);
                        }
                    }, 80);
                }
                return true;
            }
        });
        Iterator it = this.dud.iterator();
        while (it.hasNext()) {
            this.hkH.aD((String) it.next(), false);
        }
    }

    protected void onDestroy() {
        ak.vy().b(30, (e) this);
        ak.vy().b(138, (e) this);
        b.b(ig.class.getName(), this.ovN);
        super.onDestroy();
    }

    public final void gJ(int i) {
        int headerViewsCount = i - this.ieb.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            v.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i));
            return;
        }
        com.tencent.mm.ui.contact.a.a xS = bHH().xS(headerViewsCount);
        if (xS != null && xS.euW != null) {
            String str = xS.euW.field_username;
            v.i("MicroMsg.SelectContactUI", "ClickUser=%s", str);
            if (r.dn(this.eSM, 64)) {
                if (!r.dn(this.eSM, 131072) || this.dud.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                    Ph(str);
                } else if (!this.oIn.contains(str)) {
                    bHM();
                    if (this.dud.contains(str)) {
                        this.hkH.Hq(str);
                        this.dud.remove(str);
                    } else {
                        str = getIntent().getStringExtra("too_many_member_tip_string");
                        if (be.kS(str)) {
                            str = getString(2131234864, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        g.a(this.nDR.nEl, str, getString(2131231139), new OnClickListener(this) {
                            final /* synthetic */ SelectContactUI oIB;

                            {
                                this.oIB = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
                NN();
                bHW();
                this.oHc.notifyDataSetChanged();
                return;
            }
            cE(be.g(new String[]{str}));
        }
    }

    private void bHW() {
        if (!this.oIv) {
            return;
        }
        if (this.oEe == 1 || this.oEe == 0) {
            int size;
            int size2 = this.oIn != null ? this.oIn.size() : 0;
            if (this.dud != null) {
                size = this.dud.size();
            } else {
                size = 0;
            }
            size2 += size;
            size = be.KL(com.tencent.mm.h.j.sU().getValue("ChatRoomInviteStartCount"));
            if (size > 0 && size2 == size + 1 && !this.oIA) {
                if (this.dMQ == null) {
                    this.dMQ = (TextView) findViewById(2131755215);
                }
                if (this.dMQ.getVisibility() != 0) {
                    this.dMQ.setText(2131234562);
                    this.dMQ.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ SelectContactUI oIB;

                        {
                            this.oIB = r1;
                        }

                        public final void onClick(View view) {
                            this.oIB.oIA = true;
                            this.oIB.bHX();
                        }
                    });
                    if (this.oIy == null) {
                        this.oIy = new AlphaAnimation(0.0f, 1.0f);
                    }
                    this.oIy.setDuration(300);
                    if (this.oIz != null) {
                        this.oIz.cancel();
                    }
                    this.dMQ.setVisibility(0);
                    this.dMQ.startAnimation(this.oIy);
                }
            } else if (size2 < size) {
                bHX();
                this.oIA = false;
            }
        }
    }

    protected final boolean NJ() {
        return true;
    }

    protected final String NK() {
        return this.title;
    }

    protected final n NL() {
        boolean z = false;
        c.a aVar = new c.a();
        aVar.oER = r.dn(this.eSM, 16);
        aVar.oEQ = r.dn(this.eSM, 32);
        aVar.oES = !r.dn(this.eSM, 4);
        if (!r.dn(this.eSM, 1)) {
            z = true;
        }
        aVar.oET = z;
        aVar.oEU = r.dn(this.eSM, FileUtils.S_IWUSR);
        if (aVar.oEU) {
            this.oIw = true;
            aVar.oEV = getIntent().getStringExtra("wechat_sport_contact");
            aVar.oEW = getIntent().getStringExtra("wechat_sport_recent_like");
            this.oIx = aVar.oEV;
        }
        return new c(this, this.ejp, r.dn(this.eSM, 1), r.dn(this.eSM, 64), aVar);
    }

    protected final p NM() {
        if (this.oIw) {
            return new q(this, this.ejp, r.dn(this.eSM, 64), this.oIx);
        }
        return new p(this, this.ejp, r.dn(this.eSM, 64), this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (r.dn(this.eSM, FileUtils.S_IRUSR)) {
            if (this.oIj == null) {
                String string;
                View.OnClickListener anonymousClass11 = new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI oIB;

                    {
                        this.oIB = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent(this.oIB, GroupCardSelectUI.class);
                        intent.putExtra("group_select_type", true);
                        boolean dn = r.dn(this.oIB.eSM, 16384);
                        intent.putExtra("group_select_need_result", dn);
                        if (!dn) {
                            this.oIB.startActivity(intent);
                        } else if (this.oIB.oEe == 14) {
                            intent.putExtra("group_multi_select", true);
                            intent.putExtra("already_select_contact", t.b(this.oIB.jY(true), ","));
                            intent.putExtra("max_limit_num", this.oIB.getIntent().getIntExtra("max_limit_num", 9));
                            this.oIB.startActivityForResult(intent, 4);
                        } else {
                            this.oIB.startActivityForResult(intent, 0);
                        }
                    }
                };
                if (this.oEe == 14) {
                    string = getString(2131230874);
                } else {
                    string = getString(2131230858);
                }
                this.oIj = a(listView, anonymousClass11, string);
            }
            this.oIj.setVisibility(i);
        }
        if (r.dn(this.eSM, 512)) {
            if (this.oIk == null) {
                this.oIk = a(listView, new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI oIB;

                    {
                        this.oIB = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(11140, Integer.valueOf(0));
                        c.w(this.oIB, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                    }
                }, getString(2131232786));
            }
            this.oIk.setVisibility(i);
        }
        if (r.dn(this.eSM, 1024)) {
            if (this.oIl == null) {
                this.oIl = a(listView, new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI oIB;

                    {
                        this.oIB = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent(this.oIB, GroupCardSelectUI.class);
                        intent.putExtra("group_select_type", false);
                        this.oIB.startActivityForResult(intent, 1);
                    }
                }, getString(2131230859));
            }
            this.oIl.setVisibility(i);
        }
        if (r.dn(this.eSM, 2048)) {
            if (this.oIm == null) {
                this.oIm = a(listView, new View.OnClickListener(this) {
                    final /* synthetic */ SelectContactUI oIB;

                    {
                        this.oIB = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("list_attr", 16384);
                        c.b(this.oIB, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
                    }
                }, getString(2131230868));
            }
            this.oIm.setVisibility(i);
            this.oIm.setTextSize(16.0f * com.tencent.mm.bd.a.ds(this.oIm.getContext()));
        }
        if (r.dn(this.eSM, 2048)) {
            if (this.oIm != null) {
                this.oIm.setBackgroundResource(2130838048);
            }
        } else if (r.dn(this.eSM, 1024)) {
            if (this.oIl != null) {
                this.oIl.setBackgroundResource(2130838048);
            }
        } else if (r.dn(this.eSM, 512)) {
            if (this.oIk != null) {
                this.oIk.setBackgroundResource(2130838048);
            }
        } else if (r.dn(this.eSM, FileUtils.S_IRUSR) && this.oIj != null) {
            this.oIj.setBackgroundResource(2130838048);
        }
    }

    private TextView a(ListView listView, View.OnClickListener onClickListener, String str) {
        View inflate = q.em(this).inflate(2130903780, null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(2131757427);
        textView.setText(str);
        listView.addHeaderView(inflate);
        return textView;
    }

    private boolean cE(final List<String> list) {
        v.i("MicroMsg.SelectContactUI", "handleSelect %s", list);
        if (!r.dn(this.eSM, 65536)) {
            return cF(list);
        }
        String string;
        if (list != null) {
            if (list.size() == 1) {
                string = getString(2131234862, new Object[]{l.er((String) list.get(0))});
            } else if (list.size() > 1) {
                String string2 = getString(2131231152);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 3) {
                        stringBuilder.append("...");
                        break;
                    }
                    stringBuilder.append(l.er((String) list.get(i)));
                    if (i < list.size() - 1) {
                        stringBuilder.append(string2);
                    }
                }
                string = getString(2131234862, new Object[]{stringBuilder.toString()});
            }
            this.oIu = true;
            g.a(this.nDR.nEl, string, null, true, new OnClickListener(this) {
                final /* synthetic */ SelectContactUI oIB;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oIB.oIu = this.oIB.cF(list);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SelectContactUI oIB;

                {
                    this.oIB = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oIB.oIu = false;
                }
            });
            return this.oIu;
        }
        string = null;
        this.oIu = true;
        g.a(this.nDR.nEl, string, null, true, /* anonymous class already generated */, /* anonymous class already generated */);
        return this.oIu;
    }

    private boolean cF(List<String> list) {
        boolean endsWith;
        Intent intent;
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (be.kS(this.oIq)) {
                this.oIq = be.b((List) list, ",");
            } else if (be.kS(this.oIr)) {
                this.oIr = be.b((List) list, ",");
            } else {
                v.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", this.oIq, this.oIr);
                return false;
            }
            endsWith = this.oIr.endsWith("@chatroom");
            intent = new Intent();
            intent.putExtra("be_send_card_name", this.oIq);
            intent.putExtra("received_card_name", this.oIr);
            intent.putExtra("Is_Chatroom", endsWith);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            v.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", list.toString());
            ArrayList jY = jY(false);
            jY.remove(k.xF());
            boolean z = false;
            for (String str : list) {
                if (!be.kS(str)) {
                    if (!(jY.contains(str) || k.xF().equals(str))) {
                        ak.yW();
                        ab LX = com.tencent.mm.model.c.wH().LX(str);
                        if (!(LX == null || ((int) LX.chr) == 0 || !com.tencent.mm.i.a.ei(LX.field_type))) {
                            Ph(str);
                            jY.add(str);
                            endsWith = true;
                            z = endsWith;
                        }
                    }
                }
                endsWith = z;
                z = endsWith;
            }
            if (z) {
                NN();
                bHH().notifyDataSetChanged();
            } else {
                List jY2 = jY(false);
                jY2.remove(k.xF());
                final String b = be.b(jY2, ",");
                if (be.bP(jY2)) {
                    r0 = new Intent();
                    r0.putExtra("Select_Contact", b);
                    r0.putExtra("Select_Conv_User", b);
                    r0.putExtra("Select_Contact", b);
                    r0.putExtra("Select_Contacts_To_Create_New_Label", b);
                    setResult(0, r0);
                    finish();
                } else {
                    g.a(this.nDR.nEl, true, getString(2131235455), SQLiteDatabase.KeyEmpty, getString(2131235454), getString(2131235453), new OnClickListener(this) {
                        final /* synthetic */ SelectContactUI oIB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.SelectContactUI", "return the result,and create new label");
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", b);
                            intent.putExtra("Select_Conv_User", b);
                            intent.putExtra("Select_Contact", b);
                            intent.putExtra("Select_Contacts_To_Create_New_Label", b);
                            this.oIB.setResult(-1, intent);
                            this.oIB.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SelectContactUI oIB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.SelectContactUI", "return the result");
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", b);
                            intent.putExtra("Select_Conv_User", b);
                            intent.putExtra("Select_Contact", b);
                            this.oIB.setResult(-1, intent);
                            this.oIB.finish();
                        }
                    });
                }
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            v.i("MicroMsg.SelectContactUI", "Recommend Friends");
            u.a(this.nDR.nEl, this.oIr, list);
        } else if (r.dn(this.eSM, 16384)) {
            v.i("MicroMsg.SelectContactUI", "return the result");
            r0 = new Intent();
            String b2 = be.b((List) list, ",");
            r0.putExtra("Select_Contact", b2);
            r0.putExtra("Select_Conv_User", b2);
            r0.putExtra("Select_Contact", b2);
            setResult(-1, r0);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            v.i("MicroMsg.SelectContactUI", "Share Image");
            final ArrayList jY3 = jY(true);
            jY3.remove(k.xF());
            if (jY3.size() > 0) {
                this.dwR = g.a(this.nDR.nEl, getString(2131233725), false, null);
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ SelectContactUI oIB;

                    public final void run() {
                        String xF = k.xF();
                        Iterator it = jY3.iterator();
                        int i = 0;
                        String str = null;
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            v.d("MicroMsg.SelectContactUI", "toSend, %s", str2);
                            int i2 = i + (m.dE(str2) ? 1 : 0);
                            com.tencent.mm.v.k kVar = new com.tencent.mm.ae.k(4, xF, str2, this.oIB.getIntent().getStringExtra("shareImagePath"), 0, null, 0, SQLiteDatabase.KeyEmpty, str, true, 2130837922);
                            ak.vy().a(kVar, 0);
                            if (kVar.aXd != null) {
                                str = kVar.aXd.field_imgPath;
                            }
                            i = i2;
                        }
                        this.oIB.dwR.dismiss();
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("Select_Contact", jY3);
                        this.oIB.setResult(-1, intent);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11048, Integer.valueOf(1), Integer.valueOf(jY3.size() - i), Integer.valueOf(i));
                        this.oIB.finish();
                    }
                });
            }
        } else if (list.size() > 0) {
            v.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", list.toString());
            finish();
            intent = new Intent();
            intent.setClass(this, ChattingUI.class);
            intent.putExtra("Chat_User", (String) list.get(0));
            intent.addFlags(67108864);
            startActivity(intent);
        } else {
            v.e("MicroMsg.SelectContactUI", "unkown action: User=%s", list.toString());
        }
        return true;
    }

    private void NN() {
        if (!r.dn(this.eSM, 64) || this.dud.size() <= 0) {
            aq(1, getString(2131231107));
            U(1, false);
            return;
        }
        aq(1, getString(2131231107) + "(" + this.dud.size() + ")");
        U(1, true);
    }

    private ArrayList<String> jY(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.dud.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !m.eA(str)) {
                hashSet.add(str);
            } else {
                List<String> ek = i.ek(str);
                if (ek != null) {
                    for (String str2 : ek) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    private ArrayList<String> jZ(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.dud.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !m.eA(str)) {
                hashSet.add(str);
            } else {
                List<String> ek = i.ek(str);
                if (ek != null) {
                    for (String str2 : ek) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.oIn);
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (!be.bm((Context) this) || a.a(this, i, i2, str, 4)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    bHH().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        } else if (i == 4 && i2 == -24 && !be.kS(str)) {
            Toast.makeText(this, str, 1).show();
        }
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.dud.contains(aVar.euW.field_username);
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.oIn.contains(aVar.euW.field_username);
    }

    public final int[] ayD() {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(131072));
        if (!r.dn(this.eSM, 1)) {
            arrayList.add(Integer.valueOf(131076));
        }
        if (!r.dn(this.eSM, 4)) {
            arrayList.add(Integer.valueOf(131075));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public final void mf(String str) {
        this.dud.remove(str);
        bHH().notifyDataSetChanged();
        NN();
    }

    private void Ph(String str) {
        if (!this.oIn.contains(str)) {
            bHM();
            this.hkH.Hq(str);
            if (this.dud.contains(str)) {
                this.dud.remove(str);
            } else {
                this.dud.add(str);
            }
        }
    }

    private static List<String> ah(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ak.uz()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ak.yW();
            com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(obj2);
            if (!(LX == null || ((int) LX.chr) == 0)) {
                obj2 = LX.tU();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 0:
                    if (!be.kS(intent.getStringExtra("Select_Conv_User"))) {
                        cE(be.g(new String[]{intent.getStringExtra("Select_Conv_User")}));
                        return;
                    }
                    return;
                case 1:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (!be.kS(stringExtra)) {
                        cE(be.g(stringExtra.split(",")));
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        if (!be.kS(intent.getStringExtra("Select_Contact"))) {
                            cE(be.g(new String[]{intent.getStringExtra("Select_Contact")}));
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (be.kS(stringExtra)) {
                        v.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    v.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    if (r.dn(this.eSM, 64)) {
                        for (String str : stringExtra.split(",")) {
                            if (this.dud.add(str)) {
                                this.hkH.Hq(str);
                            }
                        }
                        NN();
                        bHH().notifyDataSetChanged();
                        return;
                    }
                    cE(be.g(new String[]{stringExtra}));
                    return;
                case 4:
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    Iterator it = this.dud.iterator();
                    while (it.hasNext()) {
                        this.hkH.Hr((String) it.next());
                    }
                    this.dud.clear();
                    if (!be.kS(stringExtra2)) {
                        this.dud.addAll(be.g(stringExtra2.split(",")));
                    }
                    Iterator it2 = this.dud.iterator();
                    while (it2.hasNext()) {
                        this.hkH.aD((String) it2.next(), false);
                    }
                    NN();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean azF() {
        if (this.oIw) {
            return false;
        }
        return true;
    }

    protected final void wt(String str) {
        com.tencent.mm.plugin.report.service.g.iuh.h(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.setClass(this, SelectLabelContactUI.class);
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(jY(r.dn(this.eSM, 8192)));
        hashSet.addAll(this.oIn);
        intent.putExtra("always_select_contact", be.b(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", be.b(new ArrayList(hashSet), ","));
        if (r.dn(this.eSM, 64)) {
            intent.putExtra("list_attr", r.s(16384, 64, 131072));
            if (this.oEe == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
    }

    private void bHX() {
        if (this.dMQ == null) {
            this.dMQ = (TextView) findViewById(2131755215);
        }
        if (this.dMQ.getVisibility() != 8) {
            if (this.oIz == null) {
                this.oIz = new AlphaAnimation(1.0f, 0.0f);
                this.oIz.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ SelectContactUI oIB;

                    {
                        this.oIB = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        this.oIB.dMQ.setVisibility(8);
                    }
                });
            }
            this.oIz.setDuration(300);
            if (this.oIy != null) {
                this.oIy.cancel();
            }
            this.dMQ.startAnimation(this.oIz);
        }
    }
}
