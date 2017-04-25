package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class b extends a {
    private int[] cHB;
    private String dxb;
    private com.tencent.mm.ui.bindmobile.a.a ogn;
    private com.tencent.mm.ui.bindmobile.a.b ogo = new com.tencent.mm.ui.bindmobile.a.b(this) {
        final /* synthetic */ b ogp;

        {
            this.ogp = r1;
        }

        public final void c(int i, String str, int i2) {
            v.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) this.ogp.getItem(i);
            if (bVar == null) {
                v.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                return;
            }
            v.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", bVar.toString());
            if (bVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.ogp.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass1 ogq;

                    {
                        this.ogq = r1;
                    }

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        v.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.modelfriend.b iB = ah.FL().iB(str2);
                        if (iB != null) {
                            if (z) {
                                iB.username = str;
                                iB.status = 2;
                                bl.zQ().b(26, new Object[0]);
                                a.OC(str);
                            }
                            iB.cyA = 2;
                            v.d("MicroMsg.MobileFriendAdapter", "f :%s", iB.toString());
                            ah.FL().a(str2, iB);
                            this.ogq.ogp.Ol();
                            return;
                        }
                        v.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                    }
                });
                aVar.lJm = bVar.EB();
                aVar.lJl = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                aVar.b(bVar.getUsername(), linkedList, true);
                bVar.cyA = 1;
                ah.FL().a(bVar.EB(), bVar);
                this.ogp.Ol();
            }
        }
    };

    class a {
        String aZy;
        TextView cHI;
        TextView dtE;
        int ncf;
        final /* synthetic */ b ogp;
        View ogr;
        ProgressBar ogs;
        int status;

        public a(final b bVar, View view) {
            this.ogp = bVar;
            this.cHI = (TextView) view.findViewById(2131757021);
            this.ogr = view.findViewById(2131758306);
            this.dtE = (TextView) view.findViewById(2131758307);
            this.ogs = (ProgressBar) view.findViewById(2131758308);
            this.ogr.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a ogu;

                public final void onClick(View view) {
                    if (this.ogu.ogp.ogo != null) {
                        this.ogu.ogp.ogo.c(this.ogu.ncf, this.ogu.aZy, this.ogu.status);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.ui.bindmobile.a.a aVar) {
        this.ogn = aVar;
    }

    public b(Context context, com.tencent.mm.ui.j.a aVar) {
        super(context, new com.tencent.mm.modelfriend.b());
        this.nDK = aVar;
        this.context = context;
    }

    public final void uU(String str) {
        this.dxb = be.lZ(str.trim());
        avc();
        Ol();
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        avc();
        c FL = ah.FL();
        String str = this.dxb;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        ak.yW();
        str = (String) com.tencent.mm.model.c.vf().get(6, null);
        Cursor rawQuery = (str == null || str.equals(SQLiteDatabase.KeyEmpty)) ? FL.cuX.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null) : FL.cuX.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null);
        setCursor(rawQuery);
        this.cHB = new int[getCount()];
        if (!(this.ogn == null || this.dxb == null)) {
            this.ogn.vT(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, 2130904086, null);
            a aVar2 = new a(this, view);
            aVar2.cHI = (TextView) view.findViewById(2131757021);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ncf = i;
        aVar.aZy = bVar.EB();
        aVar.status = bVar.status;
        aVar.cHI.setText(bVar.ED());
        switch (bVar.status) {
            case 0:
                if (bVar.cyA != 2) {
                    aVar.ogr.setClickable(true);
                    aVar.ogr.setBackgroundResource(2130837799);
                    aVar.dtE.setText(2131232993);
                    aVar.dtE.setTextColor(this.context.getResources().getColor(com.tencent.mm.bi.a.a.white));
                    break;
                }
                aVar.ogr.setClickable(false);
                aVar.ogr.setBackgroundDrawable(null);
                aVar.dtE.setText(2131232994);
                aVar.dtE.setTextColor(this.context.getResources().getColor(2131689817));
                break;
            case 1:
            case 2:
                v.d("MicroMsg.MobileFriendAdapter", "username:%s", bVar.getUsername());
                ak.yW();
                if (!com.tencent.mm.model.c.wH().LT(bVar.getUsername()) && !k.xF().equals(bVar.getUsername())) {
                    if (bVar.cyA != 2) {
                        aVar.ogr.setClickable(true);
                        aVar.ogr.setBackgroundResource(2130837799);
                        aVar.dtE.setText(2131232991);
                        aVar.dtE.setTextColor(this.context.getResources().getColor(com.tencent.mm.bi.a.a.white));
                        break;
                    }
                    aVar.ogr.setClickable(false);
                    aVar.ogr.setBackgroundDrawable(null);
                    aVar.dtE.setText(2131232997);
                    aVar.dtE.setTextColor(this.context.getResources().getColor(2131689817));
                    break;
                }
                aVar.ogr.setClickable(false);
                aVar.ogr.setBackgroundDrawable(null);
                aVar.dtE.setText(2131232992);
                aVar.dtE.setTextColor(this.context.getResources().getColor(2131689817));
                break;
                break;
        }
        switch (bVar.cyA) {
            case 0:
            case 2:
                aVar.dtE.setVisibility(0);
                aVar.ogs.setVisibility(4);
                break;
            case 1:
                aVar.dtE.setVisibility(4);
                aVar.ogs.setVisibility(0);
                break;
        }
        return view;
    }

    private static com.tencent.mm.modelfriend.b a(com.tencent.mm.modelfriend.b bVar, Cursor cursor) {
        if (bVar == null) {
            bVar = new com.tencent.mm.modelfriend.b();
        }
        bVar.b(cursor);
        return bVar;
    }
}
