package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.h;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.chatroom.c.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements e {
    private static int eSz = 5;
    private String bdo;
    private boolean bhx;
    private p dFI;
    private boolean ePa;
    private o ePs;
    private String eQD;
    private String eQR;
    private int eQS;
    private String eQT;
    private boolean eQU;
    private GridView eSl;
    private b eSs;
    private String eSt;
    private String eSu;
    private com.tencent.mm.ui.tools.p eSv;
    private String eSw;
    private MMEditText eSx;
    private int eSy;
    private String mTitle;
    private String username;
    private int vI;

    private static class a {
        u euW;
        int type;

        public a(int i, u uVar) {
            this.type = i;
            this.euW = uVar;
        }
    }

    private class b extends BaseAdapter {
        private List<a> bir = new ArrayList();
        private String ePn;
        private o ePs;
        private com.tencent.mm.model.c eRX;
        final /* synthetic */ SeeRoomMemberUI eSA;
        public String eSD;
        private boolean eSE = false;
        private String eSF = null;
        private List<a> eSG;
        private List<String> ejp;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            return jr(i);
        }

        public b(SeeRoomMemberUI seeRoomMemberUI, Context context, o oVar, String str, List<String> list, String str2) {
            this.eSA = seeRoomMemberUI;
            this.ePs = oVar;
            this.ePn = str;
            this.ejp = list;
            this.eSF = str2;
            this.mContext = context;
            this.eRX = ak.yW();
            aj(i.ej(str));
        }

        public final void aj(List<String> list) {
            if (list != null) {
                this.bir.clear();
                for (int i = 0; i < list.size(); i++) {
                    u LX = com.tencent.mm.model.c.wH().LX((String) list.get(i));
                    if (LX == null || !LX.field_username.equals(this.eSF)) {
                        this.bir.add(new a(1, LX));
                    } else {
                        this.bir.add(0, new a(1, LX));
                    }
                }
                this.bir.add(new a(2, null));
                if (this.eSA.eQU) {
                    this.bir.add(new a(3, null));
                }
                this.eSG = this.bir;
                notifyDataSetChanged();
            }
        }

        public final a jr(int i) {
            return (a) this.bir.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, 2130904320, null);
                cVar = new c();
                cVar.dtX = (ImageView) view.findViewById(2131756320);
                cVar.exG = (TextView) view.findViewById(2131756322);
                cVar.exG.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a aVar = (a) this.bir.get(i);
            if (aVar != null && aVar.type == 1) {
                CharSequence charSequence;
                u uVar = aVar.euW;
                com.tencent.mm.pluginsdk.ui.a.b.m(cVar.dtX, uVar.field_username);
                String a = SeeRoomMemberUI.a(this.ePs, uVar.field_username);
                if (be.kS(uVar.field_conRemark)) {
                    Object obj = a;
                } else {
                    charSequence = uVar.field_conRemark;
                }
                if (be.kS(charSequence)) {
                    charSequence = uVar.tT();
                }
                if (!(a == null || a.equals("") || charSequence.equals(a))) {
                    charSequence = a + "( " + charSequence + " )";
                }
                cVar.exG.setVisibility(0);
                cVar.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, charSequence, cVar.exG.getTextSize()));
            } else if (aVar != null && aVar.type == 2) {
                cVar.exG.setVisibility(4);
                cVar.dtX.setImageResource(2130837697);
            } else if (aVar != null && aVar.type == 3) {
                cVar.exG.setVisibility(4);
                cVar.dtX.setImageResource(2130837698);
            }
            return view;
        }

        public final void qO(String str) {
            this.eSE = true;
            this.eSD = str;
            List arrayList = new ArrayList();
            if (be.kS(str)) {
                this.bir = this.eSG;
            } else {
                for (a aVar : this.eSG) {
                    if (!(aVar == null || aVar.euW == null || aVar.type != 1)) {
                        u uVar = aVar.euW;
                        if (uVar.field_conRemark != null && uVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (!be.kS(SeeRoomMemberUI.a(this.ePs, uVar.field_username)) && SeeRoomMemberUI.a(this.ePs, uVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (uVar.tT() != null && uVar.tT().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (uVar.pE() != null && uVar.pE().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (uVar.pD() != null && uVar.pD().contains(str)) {
                            arrayList.add(aVar);
                        } else if (uVar.field_username != null && uVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.i.a.ei(uVar.field_type)) {
                            ak.yW();
                            ba Nw = com.tencent.mm.model.c.wI().Nw(uVar.field_username);
                            if (!(Nw == null || Nw.field_conRemark == null || !Nw.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                }
                v.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
                this.bir = arrayList;
            }
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.bir.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    private static class c {
        public ImageView dtX;
        public TextView exG;

        private c() {
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, int i) {
        if (seeRoomMemberUI.eSs.jr(i).type == 1) {
            String str = seeRoomMemberUI.eSs.jr(i).euW.field_username;
            v.d("MicroMsg.SeeRoomMemberUI", "roomPref del " + i + " userName : " + str);
            ak.yW();
            if (be.ah((String) com.tencent.mm.model.c.vf().get(2, null), "").equals(str)) {
                g.f(seeRoomMemberUI.nDR.nEl, 2131234595, 2131231164);
            } else {
                seeRoomMemberUI.qM(str);
            }
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, Context context) {
        if (context != null && adf()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", seeRoomMemberUI.getString(2131231754, new Object[]{com.tencent.mm.sdk.platformtools.u.bsY()}));
            intent.putExtra("geta8key_username", k.xF());
            intent.putExtra("showShare", false);
            com.tencent.mm.ay.c.b(seeRoomMemberUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, String str, String str2, String str3) {
        if (be.kS(str2)) {
            ak.yW();
            ba Nw = com.tencent.mm.model.c.wI().Nw(str);
            if (!(Nw == null || be.kS(Nw.field_encryptUsername))) {
                str2 = Nw.field_conRemark;
            }
        }
        if (!be.kS(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomMemberUI.bhx && seeRoomMemberUI.ePs != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomMemberUI.ePs.er(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomMemberUI.eQR);
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(str);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                mv mvVar = new mv();
                mvVar.bof.intent = intent;
                mvVar.bof.username = str;
                com.tencent.mm.sdk.c.a.nhr.z(mvVar);
            }
            if (seeRoomMemberUI.bhx) {
                if (LX != null && LX.bvm()) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10298, LX.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (seeRoomMemberUI.ePa) {
                intent.putExtra("Contact_Scene", 44);
                if (!k.eo(LX.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Is_RoomOwner", seeRoomMemberUI.eQU);
            intent.putExtra("Contact_ChatRoomId", seeRoomMemberUI.eQD);
            com.tencent.mm.plugin.chatroom.a.drp.d(intent, seeRoomMemberUI);
        }
    }

    static /* synthetic */ void d(SeeRoomMemberUI seeRoomMemberUI) {
        String b = be.b(i.ej(seeRoomMemberUI.eQD), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(2131230883));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", r.oHJ);
        intent.putExtra("always_select_contact", b);
        intent.putExtra("scene", 4);
        com.tencent.mm.ay.c.a(seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    static /* synthetic */ void e(SeeRoomMemberUI seeRoomMemberUI) {
        com.tencent.mm.plugin.report.service.g.iuh.a(219, 8, 1, true);
        List ej = i.ej(seeRoomMemberUI.eQD);
        String b = be.b(ej, ",");
        int size = ej.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.eQD);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", b);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.eQU);
        intent.putExtra("list_attr", r.oHJ);
        intent.putExtra("room_name", seeRoomMemberUI.eQD);
        intent.putExtra("room_owner_name", seeRoomMemberUI.ePs.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelRoomMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.iuh.a(219, 2, 1, true);
        ak.vy().a(990, this);
        ak.vy().a(179, this);
        ak.vy().a(120, this);
        ak.vy().a(610, this);
        this.eQD = getIntent().getStringExtra("RoomInfo_Id");
        this.bdo = getIntent().getStringExtra("Chat_User");
        this.eSu = getIntent().getStringExtra("Chatroom_member_list");
        this.bhx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ePa = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.eQU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.eQT = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.ePs = ak.yW().wO().LC(this.bdo == null ? this.eQD : this.bdo);
        this.eQS = getIntent().getIntExtra("room_member_count", 0);
        this.eQR = getIntent().getStringExtra("room_name");
        this.vI = getIntent().getIntExtra("offset", 0);
        this.eSy = getIntent().getIntExtra("first_pos", 0);
        NI();
        if (this.eSs != null) {
            adA();
            this.eSl.setSelection(this.eSy * eSz < this.eSs.getCount() ? this.eSy * eSz : this.eSs.getCount() - 1);
            this.eSl.postDelayed(new Runnable(this) {
                final /* synthetic */ SeeRoomMemberUI eSA;

                {
                    this.eSA = r1;
                }

                public final void run() {
                    if (VERSION.SDK_INT >= 19) {
                        this.eSA.eSl.scrollListBy(this.eSA.vI);
                        return;
                    }
                    SeeRoomMemberUI.a((Object) this.eSA.eSl, "trackMotionScroll", new Object[]{Integer.valueOf(-this.eSA.vI), Integer.valueOf(-this.eSA.vI)}, new Class[]{Integer.TYPE, Integer.TYPE});
                }
            }, 100);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.eSs != null) {
            this.eSs.qO(this.eSx.getText().toString());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eSl.setNumColumns(bA(this));
    }

    private static int bA(Context context) {
        if (context == null) {
            return 0;
        }
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(2131493143) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(2131493152) * 2.0f) + context.getResources().getDimension(2131493160)))));
        v.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[]{Integer.valueOf(width)});
        eSz = width;
        return width;
    }

    protected final void NI() {
        Fd(this.mTitle + "(" + this.eQS + ")");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI eSA;

            {
                this.eSA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eSA.setResult(0);
                this.eSA.finish();
                return true;
            }
        });
        this.eSx = (MMEditText) findViewById(2131756569);
        this.eSl = (GridView) findViewById(2131759031);
        this.eSl.setNumColumns(bA(this));
        this.eSl.setColumnWidth(getResources().getDimensionPixelSize(2131493143));
        o oVar = this.ePs;
        String str = this.eQD;
        List linkedList = new LinkedList();
        if (!be.kS(this.eSt)) {
            linkedList = be.g(this.eSt.split(","));
        }
        ak.yW();
        ax Nr = com.tencent.mm.model.c.wN().Nr("@t.qq.com");
        if (Nr != null) {
            linkedList.add(Nr.name);
        }
        this.eSs = new b(this, this, oVar, str, linkedList, this.eQT);
        this.eSx.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SeeRoomMemberUI eSA;

            {
                this.eSA = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.eSA.eSs.qO(charSequence.toString());
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.eSl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI eSA;

            {
                this.eSA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a jr = this.eSA.eSs.jr(i);
                if (jr.type == 2) {
                    v.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
                    com.tencent.mm.plugin.report.service.g.iuh.a(219, 6, 1, true);
                    SeeRoomMemberUI.d(this.eSA);
                } else if (jr.type == 3) {
                    v.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
                    SeeRoomMemberUI.e(this.eSA);
                } else if (jr.type == 1) {
                    u uVar = this.eSA.eSs.jr(i).euW;
                    if (uVar == null) {
                        v.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                        return;
                    }
                    this.eSA.username = uVar.field_username;
                    String str = uVar.field_nickname;
                    String a = SeeRoomMemberUI.a(this.eSA.ePs, this.eSA.username);
                    if (be.kS(a)) {
                        this.eSA.eSw = uVar.tU();
                    } else {
                        this.eSA.eSw = a;
                    }
                    t.h(this.eSA.eSx.getText().toString(), 1, 6, i + 1);
                    SeeRoomMemberUI.a(this.eSA, this.eSA.username, this.eSA.eSw, str);
                }
            }
        });
        this.eSl.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI eSA;

            {
                this.eSA = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (this.eSA.eQU) {
                    u uVar = this.eSA.eSs.jr(i).euW;
                    if (uVar != null) {
                        if (!this.eSA.ePs.field_roomowner.equals(uVar.field_username)) {
                            g.a(this.eSA, this.eSA.getString(2131234580), "", new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass8 eSB;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SeeRoomMemberUI.a(this.eSB.eSA, i);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass8 eSB;

                                {
                                    this.eSB = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                } else {
                    v.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
                }
                return true;
            }
        });
        this.eSl.setAdapter(this.eSs);
    }

    private void adA() {
        this.ePs = ak.yW().wO().LC(this.bdo == null ? this.eQD : this.bdo);
        List ej = i.ej(this.eQD);
        if (this.eSs != null) {
            this.eSs.aj(ej);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.eSv != null) {
            this.eSv.bJs();
        }
    }

    protected void onDestroy() {
        ak.vy().b(990, this);
        ak.vy().b(179, this);
        ak.vy().b(120, this);
        ak.vy().b(610, this);
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904321;
    }

    private void qM(String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            final com.tencent.mm.plugin.chatroom.c.g gVar = new com.tencent.mm.plugin.chatroom.c.g(this.eQD, linkedList);
            getString(2131231164);
            this.dFI = g.a(this, getString(2131234578), true, new OnCancelListener(this) {
                final /* synthetic */ SeeRoomMemberUI eSA;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(gVar);
                }
            });
            ak.vy().a(gVar, 0);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
        if (dm != null) {
            dm.a(this, null, null);
        } else if (i != 0 || i2 != 0) {
            if (kVar.getType() == 179 && i2 == -66) {
                g.A(this, getString(2131232275), getString(2131231164));
            }
            if (kVar.getType() == 120) {
                a(i2, (d) kVar);
            } else if (kVar.getType() == 610) {
                g.A(this, getString(2131233323), getString(2131231164));
            }
        } else if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 120:
                    a(i2, (d) kVar);
                    adA();
                    break;
                case 179:
                    adA();
                    break;
                case 610:
                    g.A(this, getString(2131233324), null);
                    break;
            }
            if (this.ePs != null) {
                Fd(this.mTitle + "(" + this.ePs.DM().size() + ")");
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (!m.ev(stringExtra)) {
                        g.A(this, getString(2131234616), getString(2131231164));
                        return;
                    } else if (qN(stringExtra)) {
                        g.A(this, getString(2131230816), getString(2131231164));
                        return;
                    } else if (be.g(stringExtra.split(",")) != null) {
                        final String stringExtra2 = intent.getStringExtra("Select_Contact");
                        o LC = ak.yW().wO().LC(this.eQD);
                        if (LC == null) {
                            return;
                        }
                        if (LC.bvf() == 2) {
                            com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, getString(2131234554), getString(2131234346), getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                                final /* synthetic */ SeeRoomMemberUI eSA;

                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        this.eSA.m(stringExtra2, str, 2131233332);
                                    }
                                }
                            });
                            return;
                        } else {
                            m(stringExtra, null, 2131230828);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            case 2:
                if (intent != null) {
                    qM(intent.getStringExtra("Select_Contact"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m(String str, String str2, int i) {
        if (!m.ev(str)) {
            g.A(this, getString(2131234616), getString(2131231164));
        } else if (qN(str)) {
            g.A(this, getString(2131230816), getString(2131231164));
        } else {
            List g = be.g(str.split(","));
            if (g != null) {
                final d dVar = new d(this.eQD, g, str2);
                getString(2131231164);
                this.dFI = g.a(this, getString(i), true, new OnCancelListener(this) {
                    final /* synthetic */ SeeRoomMemberUI eSA;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(dVar);
                    }
                });
                ak.vy().a(dVar, 0);
            }
        }
    }

    private void a(int i, d dVar) {
        Object obj = null;
        String str = "";
        String str2 = "";
        String string = aa.getContext().getString(2131231758);
        final List list = dVar.eOM;
        final List list2 = dVar.eOO;
        final List list3 = dVar.bix;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            o LD = ak.yW().wO().LD(this.eQD);
            if (i == -116 && adf() && !be.kS(LD.field_roomowner)) {
                str = getString(2131234613);
                str2 = getString(2131234612);
                obj = 1;
            }
            if (i == -23) {
                str = getString(2131234619);
                str2 = getString(2131234618);
            }
            if (i == -109) {
                str = getString(2131234615);
                str2 = getString(2131234614);
            }
            if (i == -122) {
                str = getString(2131234619);
                Object[] objArr = new Object[2];
                str2 = null;
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(this.ePs.field_roomowner);
                if (LX != null && ((int) LX.chr) > 0) {
                    str2 = LX.field_conRemark;
                }
                if (be.kS(str2)) {
                    str2 = this.ePs.field_roomowner;
                    if (this.ePs == null) {
                        str2 = null;
                    } else {
                        str2 = this.ePs.er(str2);
                    }
                }
                if (be.kS(str2) && LX != null && ((int) LX.chr) > 0) {
                    str2 = LX.tT();
                }
                if (be.kS(str2)) {
                    str2 = this.ePs.field_roomowner;
                }
                objArr[0] = str2;
                objArr[1] = Integer.valueOf(LD.bvg());
                str2 = getString(2131234617, objArr);
            }
            list2 = dVar.eON;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.bhN && (list2 == null || list2.size() <= 0 || dVar.bhN != list3.size() + list2.size()))) {
                list2 = dVar.eON;
                if (list2 != null && list2.size() > 0) {
                    str2 = str2 + getString(2131232876, new Object[]{be.b(ah(list2), string)});
                }
                list2 = dVar.biw;
                if (list2 != null && list2.size() > 0) {
                    str = getString(2131230814);
                    str2 = str2 + getString(2131232886, new Object[]{be.b(ah(list2), string)});
                }
                list2 = dVar.biu;
                if (list2 != null && list2.size() > 0) {
                    str = getString(2131230814);
                    str2 = str2 + getString(2131232877, new Object[]{be.b(ah(list2), string)});
                }
                Collection collection = dVar.eOO;
                if (!(list3 == null || list3.isEmpty()) || (collection != null && collection.size() > 0)) {
                    List arrayList = new ArrayList();
                    arrayList.addAll(list3);
                    arrayList.addAll(collection);
                    d(dVar.biB, list3);
                    str2 = str2 + getString(2131232863, new Object[]{be.b(ah(arrayList), string)});
                    if (list3 != null && list3.isEmpty()) {
                        str2 = null;
                    }
                }
                if (str2 != null && str2.length() > 0) {
                    if (obj != null) {
                        g.a(this, str2, str, new OnClickListener(this) {
                            final /* synthetic */ SeeRoomMemberUI eSA;

                            {
                                this.eSA = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SeeRoomMemberUI.a(this.eSA, this.eSA);
                            }
                        }, null);
                    } else {
                        g.A(this, str2, str);
                    }
                }
                LD.bvf();
                return;
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            str2 = "";
            String string2 = aa.getContext().getString(2131231758);
            if (!(list2 == null || list2.isEmpty())) {
                str2 = getString(2131232862, new Object[]{be.b(ah(list2), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str2 = str2 + getString(2131232863, new Object[]{be.b(ah(linkedList), string2)});
            }
            g.a(this, str2, "", getString(2131232855), new OnClickListener(this) {
                final /* synthetic */ SeeRoomMemberUI eSA;

                {
                    this.eSA = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.eSA.adA();
                }
            });
            d(dVar.biB, linkedList);
            return;
        }
        string = getString(2131230815);
        String string3 = getString(2131233304);
        String string4 = getString(2131231010);
        final d dVar2 = dVar;
        AnonymousClass12 anonymousClass12 = new OnClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI eSA;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.eSA.d(dVar2.biB, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                final com.tencent.mm.plugin.chatroom.c.k kVar = new com.tencent.mm.plugin.chatroom.c.k(this.eSA.eQD, arrayList);
                ak.vy().a(kVar, 0);
                SeeRoomMemberUI seeRoomMemberUI = this.eSA;
                SeeRoomMemberUI seeRoomMemberUI2 = this.eSA;
                this.eSA.getString(2131231164);
                seeRoomMemberUI.dFI = g.a(seeRoomMemberUI2, this.eSA.getString(2131234605), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass12 eSC;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(kVar);
                    }
                });
            }
        };
        g.b(this, string, null, string3, string4, anonymousClass12, new OnClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI eSA;

            {
                this.eSA = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            h.a(str, linkedList, getString(2131231757), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private static boolean adf() {
        return be.getInt(j.sU().getValue("ChatroomGlobalSwitch"), 1) == 1;
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
            u LX = com.tencent.mm.model.c.wH().LX(obj2);
            if (!(LX == null || ((int) LX.chr) == 0)) {
                obj2 = LX.tU();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    private boolean qN(String str) {
        if (be.ma(k.xF()).equals(str)) {
            return true;
        }
        List<String> ej = i.ej(this.eQD);
        if (ej == null) {
            return false;
        }
        boolean z = false;
        for (String equals : ej) {
            boolean z2;
            if (equals.equals(str)) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    protected static String a(o oVar, String str) {
        if (oVar == null) {
            return "";
        }
        return oVar.er(str);
    }

    private static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        if (obj == null) {
            return null;
        }
        Method declaredMethod;
        Object invoke;
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (Throwable e) {
                v.a("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (Throwable e2) {
                v.a("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (Throwable e3) {
                v.a("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (Throwable e32) {
                v.a("MicroMsg.SeeRoomMemberUI", e32, "", new Object[0]);
                invoke = null;
            } catch (Throwable e322) {
                v.a("MicroMsg.SeeRoomMemberUI", e322, "", new Object[0]);
            }
            return invoke;
        }
        invoke = null;
        return invoke;
        cls = cls.getSuperclass();
    }
}
