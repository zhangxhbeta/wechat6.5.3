package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends j<ab> {
    private com.tencent.mm.ui.applet.b cHD = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ a oYC;

        {
            this.oYC = r1;
        }

        public final Bitmap iG(String str) {
            return com.tencent.mm.u.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b cHE = null;
    private String dwS;
    protected List<String> ejp = null;
    private boolean oKd = true;
    private b oYB;
    private ColorStateList[] ohl = new ColorStateList[2];
    private HashMap<String, a> ohm;

    private class a {
        public CharSequence nickName;
        public int oKA;
        public CharSequence oKy;
        public CharSequence oKz;
        final /* synthetic */ a oYC;

        private a(a aVar) {
            this.oYC = aVar;
        }
    }

    public interface b {
    }

    public static class c {
        public ImageView dtX;
        public TextView euh;
        public TextView eui;
        public TextView euj;
        public TextView eul;
        public ImageView oht;
        public ImageView ohu;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ab) obj;
        if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
            if (obj == null) {
                obj = new ab();
            }
            obj.b(cursor);
        } else if (cursor.getString(0).equals("2")) {
            ak.yW();
            com.tencent.mm.e.b.ab LS = com.tencent.mm.model.c.wH().LS(u.f(cursor));
            if (LS == null) {
                LS = new u();
                LS.b(cursor);
                ak.yW();
                com.tencent.mm.model.c.wH().K(LS);
            }
            if (obj == null) {
                obj = new ab();
            }
            obj.dh(2);
            obj.s(-1);
            obj.di(1);
            obj.setContent(this.context.getString(2131232999));
            obj.setUsername(LS.field_username);
            obj.df(0);
            obj.ct(Integer.toString(1));
        } else {
            if (obj == null) {
                obj = new ab();
            }
            obj.b(cursor);
        }
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.j.a aVar) {
        super(context, new ab());
        this.nDK = aVar;
        this.ohl[0] = com.tencent.mm.bd.a.M(context, 2131690163);
        this.ohl[1] = com.tencent.mm.bd.a.M(context, 2131690164);
        this.ohm = new HashMap();
    }

    public final void cB(List<String> list) {
        this.ejp = list;
        a(null, null);
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = ak.yW().cqW.a(m.crA, this.ejp, this.dwS);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.ejp != null && this.ejp.size() > 0) {
            arrayList.addAll(this.ejp);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                v.d("MicroMsg.SearchConversationAdapter", "block user " + string);
            } catch (Throwable e) {
                v.a("MicroMsg.SearchConversationAdapter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        cursorArr[1] = ak.yW().cqX.a(this.dwS, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.oYB == null || this.dwS == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        c cVar;
        a aVar;
        a aVar2;
        CharSequence string;
        int textSize;
        int xJ;
        String str;
        Object obj;
        int i3;
        com.tencent.mm.sdk.c.b pdVar;
        if (this.cHE == null) {
            this.cHE = new com.tencent.mm.ui.applet.b.b(this) {
                final /* synthetic */ a oYC;

                {
                    this.oYC = r1;
                }

                public final String fo(int i) {
                    if (i < 0 || i >= this.oYC.getCount()) {
                        v.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                        return null;
                    }
                    ab abVar = (ab) this.oYC.getItem(i);
                    return abVar == null ? null : abVar.field_username;
                }

                public final int EU() {
                    return this.oYC.getCount();
                }
            };
        }
        if (this.cHD != null) {
            this.cHD.a(i, this.cHE);
        }
        ab abVar = (ab) getItem(i);
        if (py(abVar.field_msgType) == 34 && abVar.field_isSend == 0 && !t.kS(abVar.field_content)) {
            String str2 = abVar.field_content;
            if (abVar.field_username.equals("qmessage") || abVar.field_username.equals("floatbottle")) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new n(str2).dhD) {
                i2 = 1;
                if (view != null) {
                    cVar = new c();
                    view = View.inflate(this.context, 2130904309, null);
                    cVar.dtX = (ImageView) view.findViewById(2131755508);
                    cVar.euh = (TextView) view.findViewById(2131756539);
                    cVar.eui = (TextView) view.findViewById(2131756540);
                    cVar.euj = (TextView) view.findViewById(2131756541);
                    cVar.eul = (TextView) view.findViewById(2131755330);
                    cVar.eul.setBackgroundResource(s.eN(this.context));
                    cVar.oht = (ImageView) view.findViewById(2131756543);
                    cVar.ohu = (ImageView) view.findViewById(2131756544);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                aVar = (a) this.ohm.get(abVar.field_username + abVar.field_content);
                if (aVar == null) {
                    aVar2 = new a();
                    aVar2.nickName = e.a(this.context, l.er(abVar.field_username), cVar.euh.getTextSize());
                    string = abVar.field_status != 1 ? this.context.getString(2131233725) : abVar.field_conversationTime != Long.MAX_VALUE ? SQLiteDatabase.KeyEmpty : o.c(this.context, abVar.field_conversationTime, true);
                    aVar2.oKy = string;
                    textSize = (int) cVar.euj.getTextSize();
                    xJ = k.xJ();
                    str = abVar.field_username;
                    ak.yW();
                    obj = t.f((Integer) com.tencent.mm.model.c.vf().get(17, null)) != 1 ? 1 : null;
                    if (str.equals("qqmail") || obj != null) {
                        ak.yW();
                        ax Nr = com.tencent.mm.model.c.wN().Nr("@t.qq.com");
                        obj = (Nr == null && Nr.aeX()) ? 1 : null;
                        if (str.equals("tmessage") || obj != null) {
                            string = (str.equals("qmessage") || ((xJ & 64) == 0 ? 1 : null) != null) ? e.a(this.context, h.a(abVar.field_isSend, abVar.field_username, abVar.field_content, py(abVar.field_msgType), this.context), textSize) : this.context.getString(2131235097);
                        } else {
                            string = this.context.getString(2131235097);
                        }
                    } else {
                        string = this.context.getString(2131235097);
                    }
                    aVar2.oKz = string;
                    if (m.dE(abVar.field_username) && i.el(abVar.field_username) == 0) {
                        aVar2.nickName = this.context.getString(2131231879);
                    }
                    switch (abVar.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = 2131165723;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = 2131165722;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    aVar2.oKA = i3;
                    this.ohm.put(abVar.field_username + abVar.field_content, aVar2);
                    aVar = aVar2;
                }
                cVar.euj.setTextColor(this.ohl[i2]);
                cVar.euh.setText(aVar.nickName);
                cVar.eui.setText(aVar.oKy);
                cVar.euj.setText(e.a(this.context, aVar.oKz.toString(), cVar.euj.getTextSize()));
                if (abVar.field_conversationTime != 0) {
                    cVar.eui.setVisibility(8);
                } else {
                    cVar.eui.setVisibility(0);
                }
                cVar.oht.setVisibility(8);
                if (m.dE(abVar.field_username)) {
                    ak.yW();
                    com.tencent.mm.e.b.ab LX = com.tencent.mm.model.c.wH().LX(abVar.field_username);
                    if (LX != null && LX.bCh == 0) {
                        cVar.oht.setVisibility(0);
                    }
                }
                com.tencent.mm.pluginsdk.ui.a.b.m(cVar.dtX, abVar.field_username);
                if (this.oKd) {
                    if (abVar.field_unReadCount > 100) {
                        cVar.eul.setText("...");
                        cVar.eul.setVisibility(0);
                    } else if (abVar.field_unReadCount <= 0) {
                        cVar.eul.setText(abVar.field_unReadCount);
                        cVar.eul.setVisibility(0);
                    } else {
                        cVar.eul.setVisibility(4);
                    }
                }
                if (ak.uz()) {
                    if (!m.a(abVar)) {
                        ak.yW();
                        com.tencent.mm.model.c.wK();
                        if (ac.g(abVar)) {
                            ak.yW();
                            com.tencent.mm.model.c.wK().f(abVar);
                        }
                    }
                    ak.yW();
                    com.tencent.mm.model.c.wK();
                    if (ac.g(abVar)) {
                        view.findViewById(2131756537).setBackgroundResource(2130838046);
                    } else {
                        view.findViewById(2131756537).setBackgroundResource(2130838045);
                    }
                }
                pdVar = new pd();
                pdVar.bqt.bqv = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                if (!(0 == ac.a(abVar, 7, 0) || abVar.field_username.equals(pdVar.bqu.bqx))) {
                    abVar.t(ac.a(abVar, 6, abVar.field_conversationTime));
                    ak.yW();
                    com.tencent.mm.model.c.wK().a(abVar, abVar.field_username, true);
                }
                if (com.tencent.mm.pluginsdk.j.a.lxG == null && com.tencent.mm.pluginsdk.j.a.lxG.CB(abVar.field_username)) {
                    cVar.ohu.setVisibility(0);
                    if (abVar.field_username.equals(pdVar.bqu.bqx)) {
                        cVar.ohu.setImageResource(2131165967);
                    } else {
                        cVar.ohu.setImageResource(2131165966);
                    }
                } else {
                    cVar.ohu.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
            cVar = (c) view.getTag();
        } else {
            cVar = new c();
            view = View.inflate(this.context, 2130904309, null);
            cVar.dtX = (ImageView) view.findViewById(2131755508);
            cVar.euh = (TextView) view.findViewById(2131756539);
            cVar.eui = (TextView) view.findViewById(2131756540);
            cVar.euj = (TextView) view.findViewById(2131756541);
            cVar.eul = (TextView) view.findViewById(2131755330);
            cVar.eul.setBackgroundResource(s.eN(this.context));
            cVar.oht = (ImageView) view.findViewById(2131756543);
            cVar.ohu = (ImageView) view.findViewById(2131756544);
            view.setTag(cVar);
        }
        aVar = (a) this.ohm.get(abVar.field_username + abVar.field_content);
        if (aVar == null) {
            aVar2 = new a();
            aVar2.nickName = e.a(this.context, l.er(abVar.field_username), cVar.euh.getTextSize());
            if (abVar.field_status != 1) {
                if (abVar.field_conversationTime != Long.MAX_VALUE) {
                }
            }
            aVar2.oKy = string;
            textSize = (int) cVar.euj.getTextSize();
            xJ = k.xJ();
            str = abVar.field_username;
            ak.yW();
            if (t.f((Integer) com.tencent.mm.model.c.vf().get(17, null)) != 1) {
            }
            if (str.equals("qqmail")) {
            }
            ak.yW();
            ax Nr2 = com.tencent.mm.model.c.wN().Nr("@t.qq.com");
            if (Nr2 == null) {
            }
            if (str.equals("tmessage")) {
            }
            if ((xJ & 64) == 0) {
            }
            if (str.equals("qmessage")) {
            }
            aVar2.oKz = string;
            aVar2.nickName = this.context.getString(2131231879);
            switch (abVar.field_status) {
                case 0:
                    i3 = -1;
                    break;
                case 1:
                    i3 = 2131165723;
                    break;
                case 2:
                    i3 = -1;
                    break;
                case 5:
                    i3 = 2131165722;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            aVar2.oKA = i3;
            this.ohm.put(abVar.field_username + abVar.field_content, aVar2);
            aVar = aVar2;
        }
        cVar.euj.setTextColor(this.ohl[i2]);
        cVar.euh.setText(aVar.nickName);
        cVar.eui.setText(aVar.oKy);
        cVar.euj.setText(e.a(this.context, aVar.oKz.toString(), cVar.euj.getTextSize()));
        if (abVar.field_conversationTime != 0) {
            cVar.eui.setVisibility(0);
        } else {
            cVar.eui.setVisibility(8);
        }
        cVar.oht.setVisibility(8);
        if (m.dE(abVar.field_username)) {
            ak.yW();
            com.tencent.mm.e.b.ab LX2 = com.tencent.mm.model.c.wH().LX(abVar.field_username);
            cVar.oht.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(cVar.dtX, abVar.field_username);
        if (this.oKd) {
            if (abVar.field_unReadCount > 100) {
                cVar.eul.setText("...");
                cVar.eul.setVisibility(0);
            } else if (abVar.field_unReadCount <= 0) {
                cVar.eul.setVisibility(4);
            } else {
                cVar.eul.setText(abVar.field_unReadCount);
                cVar.eul.setVisibility(0);
            }
        }
        if (ak.uz()) {
            if (m.a(abVar)) {
                ak.yW();
                com.tencent.mm.model.c.wK();
                if (ac.g(abVar)) {
                    ak.yW();
                    com.tencent.mm.model.c.wK().f(abVar);
                }
            }
            ak.yW();
            com.tencent.mm.model.c.wK();
            if (ac.g(abVar)) {
                view.findViewById(2131756537).setBackgroundResource(2130838045);
            } else {
                view.findViewById(2131756537).setBackgroundResource(2130838046);
            }
        }
        pdVar = new pd();
        pdVar.bqt.bqv = true;
        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
        abVar.t(ac.a(abVar, 6, abVar.field_conversationTime));
        ak.yW();
        com.tencent.mm.model.c.wK().a(abVar, abVar.field_username, true);
        if (com.tencent.mm.pluginsdk.j.a.lxG == null) {
        }
        cVar.ohu.setVisibility(8);
        return view;
    }

    private static int py(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        if (str != null && !str.equals(SQLiteDatabase.KeyEmpty) && this.ohm != null) {
            this.ohm.remove(str);
        } else if (this.ohm != null) {
            this.ohm.clear();
        }
        super.a(str, iVar);
    }

    public final void uU(String str) {
        this.dwS = str;
        avc();
        Ol();
    }
}
