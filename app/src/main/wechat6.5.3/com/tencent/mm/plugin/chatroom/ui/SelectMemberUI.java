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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.plugin.chatroom.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SelectMemberUI extends MMActivity implements e {
    private ListView Eq;
    private p dFI;
    private o ePs;
    private String eQD;
    private View eSY;
    private String eSt;
    private MMEditText eSx;
    SelectMemberScrollBar eTh;
    private b eTi;
    private boolean eTj;
    private boolean eTk;
    private int exT;
    private String mTitle;

    public class a {
        final /* synthetic */ SelectMemberUI eTl;
        public u euW;
        public int type = 1;

        public a(SelectMemberUI selectMemberUI, u uVar) {
            this.eTl = selectMemberUI;
            this.euW = uVar;
        }
    }

    public class b extends BaseAdapter {
        private List<a> bir = new ArrayList();
        private o ePs;
        private String eQD;
        private com.tencent.mm.model.c eRX;
        public String eSD;
        private String eSF = null;
        private List<a> eSG;
        final /* synthetic */ SelectMemberUI eTl;
        public final String eTm = new String(Character.toChars(91));
        HashMap<String, Integer> eTn = new HashMap();
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            return jt(i);
        }

        public b(SelectMemberUI selectMemberUI, Context context, o oVar, String str, String str2) {
            this.eTl = selectMemberUI;
            this.ePs = oVar;
            this.eQD = str;
            this.eSF = str2;
            this.mContext = context;
            this.eRX = ak.yW();
            aj(i.ej(this.eQD));
            adC();
        }

        public final void qO(String str) {
            v.i("MicroMsg.SelectMemberAdapter", "search:%s", new Object[]{be.KW(str)});
            this.eSD = str;
            v.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            List arrayList = new ArrayList();
            if (be.kS(str)) {
                this.bir = this.eSG;
            } else {
                for (a aVar : this.eSG) {
                    if (!(aVar == null || aVar.euW == null || aVar.type != 1)) {
                        u uVar = aVar.euW;
                        if (uVar.field_conRemark != null && uVar.field_conRemark.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!be.kS(SeeRoomMemberUI.a(this.ePs, uVar.field_username)) && SeeRoomMemberUI.a(this.ePs, uVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (uVar.tT() != null && uVar.tT().contains(str)) {
                            arrayList.add(aVar);
                        } else if (uVar.pE() != null && uVar.pE().contains(str)) {
                            arrayList.add(aVar);
                        } else if (uVar.pD() != null && uVar.pD().contains(str)) {
                            arrayList.add(aVar);
                        } else if (uVar.field_username != null && uVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.i.a.ei(uVar.field_type)) {
                            ak.yW();
                            ba Nw = com.tencent.mm.model.c.wI().Nw(uVar.field_username);
                            if (!(Nw == null || Nw.field_conRemark == null || !Nw.field_conRemark.contains(str))) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                }
                this.bir = arrayList;
            }
            notifyDataSetChanged();
            if (this.bir == null || this.bir.size() != 0) {
                this.eTl.Eq.setVisibility(0);
                this.eTl.eSY.setVisibility(8);
                return;
            }
            this.eTl.Eq.setVisibility(8);
            this.eTl.eSY.setVisibility(0);
        }

        public final int getCount() {
            return this.bir.size();
        }

        public final a jt(int i) {
            return (a) this.bir.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, 2130904332, null);
                c cVar2 = new c();
                cVar2.eST = (MaskLayout) view.findViewById(2131759041);
                cVar2.exG = (TextView) view.findViewById(2131759042);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                cVar2.exG.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                cVar2.eSU = (TextView) view.findViewById(2131759043);
                cVar2.eSU.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            u uVar = jt(i).euW;
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) cVar.eST.view, uVar.field_username);
            if (uVar.field_verifyFlag == 0) {
                cVar.eST.bCM();
            } else if (com.tencent.mm.model.ab.a.csb != null) {
                String eJ = com.tencent.mm.model.ab.a.csb.eJ(uVar.field_verifyFlag);
                if (eJ != null) {
                    cVar.eST.d(j.hL(eJ), com.tencent.mm.ui.base.MaskLayout.a.nZN);
                } else {
                    cVar.eST.bCM();
                }
            } else {
                cVar.eST.bCM();
            }
            CharSequence c = c(uVar);
            CharSequence charSequence = "";
            if (com.tencent.mm.i.a.ei(uVar.field_type)) {
                charSequence = uVar.bCt;
            }
            if (be.kS(charSequence)) {
                cVar.eSU.setVisibility(8);
                cVar.eSU.setText("");
            } else {
                cVar.eSU.setVisibility(0);
                cVar.eSU.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, charSequence, cVar.eSU.getTextSize()));
            }
            cVar.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, c, cVar.exG.getTextSize()));
            return view;
        }

        private String c(u uVar) {
            String a;
            if (be.kS(uVar.field_conRemark)) {
                a = SelectMemberUI.a(this.ePs, uVar.field_username);
            } else {
                a = uVar.field_conRemark;
            }
            if (be.kS(a)) {
                a = uVar.tT();
            }
            if (com.tencent.mm.i.a.ei(uVar.field_type)) {
                return a;
            }
            ak.yW();
            ba Nw = com.tencent.mm.model.c.wI().Nw(uVar.field_username);
            if (Nw == null || be.kS(Nw.field_conRemark)) {
                return a;
            }
            return Nw.field_conRemark;
        }

        private void aj(List<String> list) {
            if (list != null) {
                this.bir.clear();
                for (int i = 0; i < list.size(); i++) {
                    u LX = com.tencent.mm.model.c.wH().LX((String) list.get(i));
                    if (!LX.field_username.equals(this.eSF) || this.eTl.eTk) {
                        if (LX != null && LX.field_username.equals(this.eSF) && this.eTl.eTk) {
                            this.bir.add(0, new a(this.eTl, LX));
                        } else {
                            this.bir.add(new a(this.eTl, LX));
                        }
                    }
                }
                Collections.sort(this.bir, new Comparator<a>(this) {
                    final /* synthetic */ b eTo;

                    {
                        this.eTo = r1;
                    }

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        return com.tencent.mm.platformtools.c.lT(this.eTo.c(((a) obj).euW)).compareToIgnoreCase(com.tencent.mm.platformtools.c.lT(this.eTo.c(((a) obj2).euW)));
                    }
                });
                this.eSG = this.bir;
                notifyDataSetChanged();
            }
        }

        private void adC() {
            if (this.bir != null) {
                Object obj = null;
                int i = 0;
                for (a aVar : this.bir) {
                    String pE;
                    if (aVar.euW != null) {
                        pE = be.kS(aVar.euW.field_conRemarkPYShort) ? aVar.euW.pE() : aVar.euW.field_conRemarkPYShort;
                        pE = be.kS(pE) ? "" : pE.startsWith(this.eTm) ? "#" : pE.toUpperCase().substring(0, 1);
                        if (i == 0) {
                            this.eTn.put(pE, Integer.valueOf(i));
                        } else if (!(obj == null || pE.equals(obj))) {
                            this.eTn.put(pE, Integer.valueOf(i));
                        }
                    } else {
                        pE = null;
                    }
                    i++;
                    String str = pE;
                }
            }
        }
    }

    private static class c {
        public MaskLayout eST;
        public TextView eSU;
        public TextView exG;

        private c() {
        }
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, int i) {
        a jt = selectMemberUI.eTi.jt(i);
        if (jt == null || jt.euW == null) {
            v.e("MicroMsg.SelectMemberUI", "null == item || null == item.contact");
            return;
        }
        u uVar = jt.euW;
        final String str = uVar.field_username;
        String a = !be.kS(uVar.field_conRemark) ? uVar.field_conRemark : a(selectMemberUI.ePs, uVar.field_username);
        if (be.kS(a)) {
            a = uVar.tT();
        }
        if (!com.tencent.mm.i.a.ei(uVar.field_type)) {
            ak.yW();
            ba Nw = com.tencent.mm.model.c.wI().Nw(uVar.field_username);
            if (!(Nw == null || be.kS(Nw.field_conRemark))) {
                a = Nw.field_conRemark;
            }
        }
        g.a(selectMemberUI, !selectMemberUI.eTj ? selectMemberUI.getString(2131234671, new Object[]{a}) : selectMemberUI.getString(2131234641, new Object[]{a}), "", new OnClickListener(selectMemberUI) {
            final /* synthetic */ SelectMemberUI eTl;

            public final void onClick(DialogInterface dialogInterface, int i) {
                ak.vy().a(new n(this.eTl.eQD, str), 0);
                SelectMemberUI selectMemberUI = this.eTl;
                SelectMemberUI selectMemberUI2 = this.eTl;
                this.eTl.getString(2131231164);
                selectMemberUI.dFI = g.a(selectMemberUI2, this.eTl.getString(2131234672), false, null);
            }
        }, new OnClickListener(selectMemberUI) {
            final /* synthetic */ SelectMemberUI eTl;

            {
                this.eTl = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, String str) {
        selectMemberUI.axg();
        Intent intent = new Intent(selectMemberUI, SelectMemberChattingRecordUI.class);
        intent.putExtra("RoomInfo_Id", selectMemberUI.eQD);
        intent.putExtra("room_member", str);
        intent.putExtra("title", selectMemberUI.getString(2131234861));
        selectMemberUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.SelectMemberUI", "[onCreate]");
        this.eQD = getIntent().getStringExtra("RoomInfo_Id");
        v.i("MicroMsg.SelectMemberUI", "roomId:%s", new Object[]{this.eQD});
        this.ePs = ak.yW().wO().LD(this.eQD);
        this.eSt = getIntent().getStringExtra("Block_list");
        this.exT = getIntent().getIntExtra("frome_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.eTj = getIntent().getBooleanExtra("quit_room", false);
        this.eTk = getIntent().getBooleanExtra("is_show_owner", true);
        NI();
        if (this.exT == 2) {
            ak.vy().a(990, this);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.eTi != null) {
            this.eTi.qO(this.eSx.getText().toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.exT == 2) {
            ak.vy().b(990, this);
        }
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
    }

    protected final void NI() {
        super.NI();
        Fd(be.ma(this.mTitle));
        this.Eq = (ListView) findViewById(2131759038);
        this.eTi = new b(this, this, this.ePs, this.eQD, this.ePs.field_roomowner);
        this.Eq.setAdapter(this.eTi);
        this.eSY = findViewById(2131759039);
        this.eTh = (SelectMemberScrollBar) findViewById(2131759047);
        this.eTh.setVisibility(0);
        this.eTh.obP = new com.tencent.mm.ui.base.VerticalScrollBar.a(this) {
            final /* synthetic */ SelectMemberUI eTl;

            {
                this.eTl = r1;
            }

            public final void pC(String str) {
                if ("↑".equals(str)) {
                    this.eTl.Eq.setSelection(0);
                    return;
                }
                int intValue;
                b b = this.eTl.eTi;
                if (b.eTn.containsKey(str)) {
                    intValue = ((Integer) b.eTn.get(str)).intValue();
                } else {
                    intValue = -1;
                }
                if (intValue != -1) {
                    this.eTl.Eq.setSelection(intValue);
                }
            }
        };
        this.eSx = (MMEditText) findViewById(2131759046);
        this.eSx.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SelectMemberUI eTl;

            {
                this.eTl = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.eTl.eTi.qO(charSequence.toString());
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectMemberUI eTl;

            {
                this.eTl = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                switch (this.eTl.exT) {
                    case 1:
                        SelectMemberUI.a(this.eTl, this.eTl.eTi.jt(i).euW.field_username);
                        return;
                    case 2:
                        SelectMemberUI.a(this.eTl, i);
                        return;
                    default:
                        v.w("MicroMsg.SelectMemberUI", "mFromScene is default");
                        return;
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectMemberUI eTl;

            {
                this.eTl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eTl.setResult(0);
                this.eTl.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
        if (kVar.getType() != 990) {
            return;
        }
        if (i == 0 && i2 == 0) {
            v.i("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[]{((n) kVar).username});
            s.makeText(this, 2131234669, 1).show();
            Intent intent = new Intent();
            intent.putExtra("RoomInfo_Id", this.eQD);
            intent.putExtra("Chat_User", this.eQD);
            intent.putExtra("Is_Chatroom", true);
            intent.setFlags(67108864);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "chatroom", ".ui.ChatroomInfoUI", intent);
            finish();
            return;
        }
        s.makeText(this, 2131234668, 1).show();
        v.w("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    protected static String a(o oVar, String str) {
        if (oVar == null) {
            return null;
        }
        return oVar.er(str);
    }

    protected final int getLayoutId() {
        return 2130904333;
    }
}
