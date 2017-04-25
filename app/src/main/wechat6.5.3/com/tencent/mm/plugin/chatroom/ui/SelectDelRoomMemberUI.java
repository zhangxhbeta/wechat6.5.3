package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectDelRoomMemberUI extends MMActivity {
    private ListView Eq;
    private boolean bhx;
    public HashSet<String> dud;
    private boolean ePa;
    private o ePs;
    private String eQD;
    private String eQR;
    private int eQS;
    private String eQT;
    private boolean eQU;
    private int eSM;
    private a eSN;
    private EditText eSO;
    private String eSt;
    private String eSu;
    private String eSw;
    private String username;

    private static class a extends BaseAdapter {
        static List<u> bir = new ArrayList();
        static List<u> eSG;
        private String ePn;
        o ePs;
        private c eRX;
        String eSD;
        private String eSF = null;
        a eSR = null;
        private List<String> ejp;
        private Context mContext;

        private static class a {
            public MaskLayout eST;
            public TextView eSU;
            public ImageView eSV;
            public ImageButton eSW;
            public TextView exG;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return js(i);
        }

        public a(Context context, o oVar, String str, List<String> list, String str2) {
            this.ePs = oVar;
            this.ePn = str;
            this.ejp = list;
            this.mContext = context;
            this.eSF = str2;
            this.eRX = ak.yW();
            aj(i.ej(str));
        }

        public final void aj(List<String> list) {
            if (list != null) {
                bir.clear();
                for (int i = 0; i < list.size(); i++) {
                    u LX = c.wH().LX((String) list.get(i));
                    if (LX == null || !LX.field_username.equals(this.eSF)) {
                        bir.add(LX);
                    } else {
                        bir.add(0, LX);
                    }
                }
                eSG = bir;
                notifyDataSetChanged();
            }
        }

        public static u js(int i) {
            return (u) bir.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            u uVar = (u) bir.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, 2130903447, null);
                this.eSR = new a();
                this.eSR.eST = (MaskLayout) view.findViewById(2131756320);
                this.eSR.exG = (TextView) view.findViewById(2131756322);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                this.eSR.exG.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                this.eSR.eSU = (TextView) view.findViewById(2131756323);
                this.eSR.eSU.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                this.eSR.eSV = (ImageView) view.findViewById(2131756321);
                this.eSR.eSW = (ImageButton) view.findViewById(2131756324);
                view.setTag(this.eSR);
                view2 = view;
            } else {
                this.eSR = (a) view.getTag();
                view2 = view;
            }
            if (uVar != null) {
                final String str;
                CharSequence charSequence;
                CharSequence charSequence2;
                this.eSR.exG.setTextColor(com.tencent.mm.bd.a.M(this.mContext, !m.fn(uVar.field_username) ? 2131690159 : 2131690160));
                if (this.ePs.field_roomowner.equals(uVar.field_username)) {
                    this.eSR.eSW.setVisibility(8);
                    ((LargeTouchableAreasItemView) view2).eQv = null;
                } else {
                    if (((SelectDelRoomMemberUI) this.mContext).dud.contains(uVar.field_username)) {
                        ((LargeTouchableAreasItemView) view2).cp(true);
                    } else {
                        ((LargeTouchableAreasItemView) view2).cp(false);
                    }
                    this.eSR.eSW.setVisibility(0);
                    str = uVar.field_username;
                    ((LargeTouchableAreasItemView) view2).eQv = new com.tencent.mm.plugin.chatroom.ui.LargeTouchableAreasItemView.a(this) {
                        final /* synthetic */ a eSS;

                        public final void cq(boolean z) {
                            if (z) {
                                ((SelectDelRoomMemberUI) this.eSS.mContext).dud.add(str);
                            } else {
                                ((SelectDelRoomMemberUI) this.eSS.mContext).dud.remove(str);
                            }
                            ((SelectDelRoomMemberUI) this.eSS.mContext).NN();
                        }
                    };
                }
                b.m((ImageView) this.eSR.eST.view, uVar.field_username);
                if (uVar.field_verifyFlag == 0) {
                    this.eSR.eST.bCM();
                } else if (com.tencent.mm.model.ab.a.csb != null) {
                    String eJ = com.tencent.mm.model.ab.a.csb.eJ(uVar.field_verifyFlag);
                    if (eJ != null) {
                        this.eSR.eST.d(j.hL(eJ), com.tencent.mm.ui.base.MaskLayout.a.nZN);
                    } else {
                        this.eSR.eST.bCM();
                    }
                } else {
                    this.eSR.eST.bCM();
                }
                str = SelectDelRoomMemberUI.b(this.ePs, uVar.field_username);
                if (be.kS(uVar.field_conRemark)) {
                    Object obj = str;
                } else {
                    charSequence = uVar.field_conRemark;
                }
                if (be.kS(charSequence)) {
                    charSequence = uVar.tT();
                }
                if (!(str == null || str.equals("") || charSequence.equals(str))) {
                    charSequence = str + "( " + charSequence + " )";
                }
                str = "";
                if (com.tencent.mm.i.a.ei(uVar.field_type)) {
                    charSequence2 = uVar.bCt;
                } else {
                    ak.yW();
                    ba Nw = c.wI().Nw(uVar.field_username);
                    if (Nw != null) {
                        charSequence2 = Nw.field_conDescription;
                        if (!be.kS(Nw.field_conRemark)) {
                            charSequence = Nw.field_conRemark;
                        }
                    } else {
                        Object obj2 = str;
                    }
                }
                if (be.kS(charSequence2)) {
                    this.eSR.eSU.setText("");
                } else {
                    this.eSR.eSU.setText(e.a(this.mContext, charSequence2, this.eSR.eSU.getTextSize()));
                }
                this.eSR.exG.setText(e.a(this.mContext, charSequence, this.eSR.exG.getTextSize()));
            }
            return view2;
        }

        public final int getCount() {
            return bir.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ ArrayList a(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        ArrayList arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = selectDelRoomMemberUI.dud.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    static /* synthetic */ void a(SelectDelRoomMemberUI selectDelRoomMemberUI, String str, String str2, String str3) {
        if (be.kS(str2)) {
            ak.yW();
            ba Nw = c.wI().Nw(str);
            if (!(Nw == null || be.kS(Nw.field_encryptUsername))) {
                str2 = Nw.field_conRemark;
            }
        }
        if (!be.kS(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (selectDelRoomMemberUI.bhx && selectDelRoomMemberUI.ePs != null) {
                intent.putExtra("Contact_RoomNickname", selectDelRoomMemberUI.ePs.er(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", selectDelRoomMemberUI.eQR);
            ak.yW();
            u LX = c.wH().LX(str);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                mv mvVar = new mv();
                mvVar.bof.intent = intent;
                mvVar.bof.username = str;
                com.tencent.mm.sdk.c.a.nhr.z(mvVar);
            }
            if (selectDelRoomMemberUI.bhx) {
                if (LX != null && LX.bvm()) {
                    g.iuh.Y(10298, LX.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (selectDelRoomMemberUI.ePa) {
                intent.putExtra("Contact_Scene", 44);
                if (!k.eo(LX.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Contact_ChatRoomId", selectDelRoomMemberUI.eQD);
            com.tencent.mm.plugin.chatroom.a.drp.d(intent, selectDelRoomMemberUI);
        }
    }

    static /* synthetic */ String b(o oVar, String str) {
        return oVar == null ? null : oVar.er(str);
    }

    protected final int getLayoutId() {
        return 2130903448;
    }

    protected final void NI() {
        super.NI();
        this.eQD = getIntent().getStringExtra("RoomInfo_Id");
        this.eSu = getIntent().getStringExtra("Chatroom_member_list");
        this.bhx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ePa = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.eQU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.eQT = getIntent().getStringExtra("room_owner_name");
        this.ePs = ak.yW().wO().LC(this.eQD);
        this.eQS = getIntent().getIntExtra("room_member_count", 0);
        this.eSM = getIntent().getIntExtra("list_attr", r.oHI);
        this.eQR = getIntent().getStringExtra("room_name");
        Fd(getString(2131234661) + "(" + this.eQS + ")");
        a(1, getString(2131232282), new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI eSP;

            {
                this.eSP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.eSP, this.eSP.getString(2131234581), "", new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 eSQ;

                    {
                        this.eSQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Contact", be.b(SelectDelRoomMemberUI.a(this.eSQ.eSP), ","));
                        this.eSQ.eSP.setResult(-1, intent);
                        this.eSQ.eSP.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 eSQ;

                    {
                        this.eSQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return false;
            }
        }, com.tencent.mm.ui.k.b.nEU);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI eSP;

            {
                this.eSP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eSP.finish();
                return false;
            }
        });
        this.eSO = (EditText) findViewById(2131756569);
        this.eSO.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SelectDelRoomMemberUI eSP;

            {
                this.eSP = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                a b = this.eSP.eSN;
                Object charSequence2 = charSequence.toString();
                b.eSD = charSequence2;
                List arrayList = new ArrayList();
                if (be.kS(charSequence2)) {
                    a.bir = a.eSG;
                } else {
                    for (u uVar : a.eSG) {
                        if (uVar != null) {
                            if (uVar.field_conRemark != null && uVar.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(uVar);
                            } else if (!be.kS(SelectDelRoomMemberUI.b(b.ePs, uVar.field_username)) && SelectDelRoomMemberUI.b(b.ePs, uVar.field_username).contains(charSequence2)) {
                                arrayList.add(uVar);
                            } else if (uVar.tT() != null && uVar.tT().toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(uVar);
                            } else if (uVar.pE() != null && uVar.pE().toUpperCase().contains(charSequence2.toUpperCase())) {
                                arrayList.add(uVar);
                            } else if (uVar.pD() != null && uVar.pD().contains(charSequence2)) {
                                arrayList.add(uVar);
                            } else if (uVar.field_username != null && uVar.field_username.contains(charSequence2)) {
                                arrayList.add(uVar);
                            } else if (!com.tencent.mm.i.a.ei(uVar.field_type)) {
                                ak.yW();
                                ba Nw = c.wI().Nw(uVar.field_username);
                                if (!(Nw == null || Nw.field_conRemark == null || !Nw.field_conRemark.toUpperCase().contains(charSequence2.toUpperCase()))) {
                                    arrayList.add(uVar);
                                }
                            }
                        }
                    }
                    v.i("MicroMsg.SelectDelRoomMemberUI", "--->setMemberListBySearch:search");
                    a.bir = arrayList;
                }
                b.notifyDataSetChanged();
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.Eq = (ListView) findViewById(2131755469);
        u uVar = new u();
        o oVar = this.ePs;
        String str = this.eQD;
        List linkedList = new LinkedList();
        if (!be.kS(this.eSt)) {
            linkedList = be.g(this.eSt.split(","));
        }
        ak.yW();
        ax Nr = c.wN().Nr("@t.qq.com");
        if (Nr != null) {
            linkedList.add(Nr.name);
        }
        this.eSN = new a(this, oVar, str, linkedList, this.eQT);
        this.Eq.setAdapter(this.eSN);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI eSP;

            {
                this.eSP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                u js = a.js(i);
                if (js != null) {
                    this.eSP.username = js.field_username;
                    String str = js.field_nickname;
                    String b = SelectDelRoomMemberUI.b(this.eSP.ePs, this.eSP.username);
                    if (be.kS(b)) {
                        this.eSP.eSw = js.tU();
                    } else {
                        this.eSP.eSw = b;
                    }
                    SelectDelRoomMemberUI.a(this.eSP, this.eSP.username, this.eSP.eSw, str);
                }
            }
        });
        NN();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dud = new HashSet();
        NI();
    }

    public void onResume() {
        super.onResume();
        if (this.eSN != null) {
            this.ePs = ak.yW().wO().LC(this.eQD);
            List ej = i.ej(this.eQD);
            if (this.eSN != null) {
                this.eSN.aj(ej);
            }
        }
    }

    private void NN() {
        if (!r.dn(this.eSM, 64) || this.dud.size() <= 0) {
            aq(1, getString(2131232282));
            U(1, false);
            return;
        }
        aq(1, getString(2131232282) + "(" + this.dud.size() + ")");
        U(1, true);
    }
}
