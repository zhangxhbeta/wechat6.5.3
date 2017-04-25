package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.j;

final class c extends j<ab> implements b {
    private final MMActivity aWn;
    protected f euc;
    protected com.tencent.mm.ui.base.MMSlideDelView.c eud;
    protected e eue;
    protected d euf = MMSlideDelView.bCp();

    public static class a {
        public ImageView dtX;
        public TextView euh;
        public TextView eui;
        public TextView euj;
        public ImageView euk;
        public TextView eul;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ab) obj;
        if (obj == null) {
            obj = new ab();
        }
        obj.cu("");
        obj.cv("");
        obj.b(cursor);
        return obj;
    }

    public c(Context context, com.tencent.mm.ui.j.a aVar) {
        super(context, new ab());
        this.nDK = aVar;
        this.aWn = (MMActivity) context;
    }

    public final void Ol() {
        ak.yW();
        ac wK = com.tencent.mm.model.c.wK();
        setCursor(wK.cie.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + be.ma(m.crC) + " order by flag desc, conversationTime" + " desc", null));
        if (this.nDK != null) {
            this.nDK.Oi();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.eue = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.eud = cVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int paddingTop;
        int paddingRight;
        int paddingLeft;
        ab abVar = (ab) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.aWn, 2130904547, null);
            aVar2.dtX = (ImageView) view.findViewById(2131755508);
            aVar2.euh = (TextView) view.findViewById(2131756539);
            aVar2.eui = (TextView) view.findViewById(2131756540);
            aVar2.euj = (TextView) view.findViewById(2131756541);
            aVar2.euk = (ImageView) view.findViewById(2131759571);
            aVar2.eul = (TextView) view.findViewById(2131755330);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.euh.setText(l.er(abVar.field_username));
        TextView textView = aVar.eui;
        CharSequence string = abVar.field_status == 1 ? this.aWn.getString(2131233725) : abVar.field_conversationTime == Long.MAX_VALUE ? "" : o.c(this.aWn, abVar.field_conversationTime, true);
        textView.setText(string);
        com.tencent.mm.pluginsdk.ui.a.b.m(aVar.dtX, abVar.field_username);
        ak.yW();
        com.tencent.mm.storage.ac.c cVar = com.tencent.mm.model.c.wK().nuA;
        if (!be.kS(abVar.field_digest)) {
            if (be.kS(abVar.field_digestUser)) {
                string = abVar.field_digest;
            } else {
                String D = (abVar.field_isSend == 0 && m.dE(abVar.field_username)) ? l.D(abVar.field_digestUser, abVar.field_username) : l.er(abVar.field_digestUser);
                try {
                    string = String.format(abVar.field_digest, new Object[]{D});
                } catch (Exception e) {
                }
            }
            aVar.euj.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, string, aVar.euj.getTextSize()));
            switch (abVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = 2131165723;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = 2131165722;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (i2 == -1) {
                aVar.euk.setBackgroundResource(i2);
                aVar.euk.setVisibility(0);
            } else {
                aVar.euk.setVisibility(8);
            }
            i2 = view.getPaddingBottom();
            paddingTop = view.getPaddingTop();
            paddingRight = view.getPaddingRight();
            paddingLeft = view.getPaddingLeft();
            if (abVar.field_unReadCount > 100) {
                aVar.eul.setText("...");
                aVar.eul.setVisibility(0);
            } else if (abVar.field_unReadCount <= 0) {
                aVar.eul.setText(abVar.field_unReadCount);
                aVar.eul.setVisibility(0);
            } else {
                aVar.eul.setVisibility(4);
            }
            view.setBackgroundResource(2130838666);
            view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
            return view;
        }
        string = cVar.a(abVar.field_isSend, abVar.field_username, abVar.field_content, py(abVar.field_msgType), this.aWn);
        aVar.euj.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, string, aVar.euj.getTextSize()));
        switch (abVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = 2131165723;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = 2131165722;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 == -1) {
            aVar.euk.setVisibility(8);
        } else {
            aVar.euk.setBackgroundResource(i2);
            aVar.euk.setVisibility(0);
        }
        i2 = view.getPaddingBottom();
        paddingTop = view.getPaddingTop();
        paddingRight = view.getPaddingRight();
        paddingLeft = view.getPaddingLeft();
        if (abVar.field_unReadCount > 100) {
            aVar.eul.setText("...");
            aVar.eul.setVisibility(0);
        } else if (abVar.field_unReadCount <= 0) {
            aVar.eul.setVisibility(4);
        } else {
            aVar.eul.setText(abVar.field_unReadCount);
            aVar.eul.setVisibility(0);
        }
        view.setBackgroundResource(2130838666);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
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

    public final void onPause() {
        if (this.euf != null) {
            this.euf.avm();
        }
    }

    protected final void Om() {
        Ol();
    }
}
