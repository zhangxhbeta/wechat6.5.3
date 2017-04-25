package com.tencent.mm.ui.bindgooglecontact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.modelfriend.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.j;

public final class a extends j<o> {
    private LayoutInflater dY = LayoutInflater.from(this.mContext);
    private Context mContext;
    private String mFilter;
    private String odQ;
    a oei;

    interface a {
        void wR(int i);
    }

    class b {
        TextView dtE;
        ImageView dtz;
        TextView dyN;
        String hWt;
        TextView oej;
        View oek;
        ProgressBar oel;
        final /* synthetic */ a oem;
        int position;

        public b(final a aVar, View view) {
            this.oem = aVar;
            this.dtz = (ImageView) view.findViewById(2131757400);
            this.dyN = (TextView) view.findViewById(2131757401);
            this.oek = view.findViewById(2131757403);
            this.dtE = (TextView) view.findViewById(2131757404);
            this.oel = (ProgressBar) view.findViewById(2131757405);
            this.oej = (TextView) view.findViewById(2131757402);
            this.oek.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b oeo;

                public final void onClick(View view) {
                    v.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
                    if (this.oeo.oem.oei != null) {
                        this.oeo.oem.oei.wR(this.oeo.position);
                    }
                }
            });
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (o) obj;
        if (obj == null) {
            obj = new o();
        }
        obj.b(cursor);
        return obj;
    }

    public a(Context context, String str) {
        super(context, new o());
        this.odQ = str;
        this.mContext = context;
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        p FT = ah.FT();
        String str = this.mFilter;
        String str2 = this.odQ;
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        } else {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            stringBuilder.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        }
        stringBuilder.append(" GROUP BY googleid,contecttype");
        stringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        setCursor(FT.cie.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    public final void uU(String str) {
        this.mFilter = be.lZ(str);
        avc();
        Ol();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = this.dY.inflate(2130903771, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        o oVar = (o) getItem(i);
        if (oVar != null) {
            bVar.position = i;
            bVar.hWt = oVar.field_googlegmail;
            Bitmap a;
            switch (oVar.field_status) {
                case 0:
                case 2:
                    if (oVar.field_small_url != null) {
                        a = com.tencent.mm.u.b.a(oVar.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        bVar.dtz.setImageBitmap(a);
                        break;
                    }
                    bVar.dtz.setImageDrawable(com.tencent.mm.bd.a.a(this.mContext, 2131165440));
                    break;
                case 1:
                    a = com.tencent.mm.u.b.gv(oVar.field_googleid);
                    if (a != null) {
                        bVar.dtz.setImageBitmap(a);
                        break;
                    }
                    bVar.dtz.setImageDrawable(com.tencent.mm.bd.a.a(this.mContext, 2131165440));
                    break;
            }
            if (TextUtils.isEmpty(oVar.field_googlename)) {
                bVar.dyN.setText(be.KU(oVar.field_googlegmail));
            } else {
                bVar.dyN.setText(oVar.field_googlename);
            }
            switch (oVar.field_status) {
                case 0:
                    bVar.oek.setClickable(true);
                    bVar.oek.setBackgroundResource(2130837799);
                    bVar.dtE.setText(2131233140);
                    bVar.dtE.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.bi.a.a.white));
                    break;
                case 1:
                    bVar.oek.setClickable(true);
                    bVar.oek.setBackgroundResource(2130837800);
                    bVar.dtE.setText(2131233148);
                    bVar.dtE.setTextColor(this.mContext.getResources().getColor(2131689817));
                    break;
                case 2:
                    bVar.oek.setClickable(false);
                    bVar.oek.setBackgroundDrawable(null);
                    bVar.dtE.setText(2131233142);
                    bVar.dtE.setTextColor(this.mContext.getResources().getColor(2131689817));
                    break;
            }
            switch (oVar.field_googlecgistatus) {
                case 0:
                    bVar.dtE.setVisibility(4);
                    bVar.oel.setVisibility(0);
                    break;
                case 1:
                    bVar.oek.setClickable(false);
                    bVar.oek.setBackgroundDrawable(null);
                    bVar.dtE.setVisibility(0);
                    bVar.oel.setVisibility(8);
                    bVar.dtE.setTextColor(this.mContext.getResources().getColor(2131689817));
                    switch (oVar.field_status) {
                        case 0:
                            bVar.dtE.setText(2131233141);
                            break;
                        case 1:
                            bVar.dtE.setText(2131233149);
                            break;
                        default:
                            break;
                    }
                case 2:
                    bVar.dtE.setVisibility(0);
                    bVar.oel.setVisibility(8);
                    switch (oVar.field_status) {
                        case 0:
                            bVar.dtE.setText(2131233140);
                            bVar.dtE.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.bi.a.a.white));
                            break;
                        case 1:
                            bVar.dtE.setText(2131233148);
                            bVar.dtE.setTextColor(this.mContext.getResources().getColor(2131689817));
                            break;
                        default:
                            break;
                    }
            }
            bVar.oej.setText(oVar.field_googlegmail);
        }
        return view;
    }
}
