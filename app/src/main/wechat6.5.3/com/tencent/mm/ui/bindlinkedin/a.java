package com.tencent.mm.ui.bindlinkedin;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.ui.j;

public final class a extends j<s> {
    private Context context = null;
    h ipD = null;
    private LayoutInflater nFR;
    private String ofi = null;
    a ofj = null;

    public interface a {
        void dk(int i, int i2);
    }

    private static class b {
        ImageView ofl;
        TextView ofm;
        TextView ofn;
        TextView ofo;

        private b(View view) {
            this.ofl = null;
            this.ofm = null;
            this.ofn = null;
            this.ofo = null;
            this.ofl = (ImageView) view.findViewById(2131757697);
            this.ofm = (TextView) view.findViewById(2131757698);
            this.ofn = (TextView) view.findViewById(2131757699);
            this.ofo = (TextView) view.findViewById(2131757700);
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (s) obj;
        if (obj == null) {
            obj = new s();
        }
        obj.b(cursor);
        return obj;
    }

    public a(Context context, String str) {
        super(context, new s());
        this.context = context;
        this.ofi = str;
        this.nFR = LayoutInflater.from(this.context);
        this.ipD = new h(this) {
            final /* synthetic */ a ofk;

            {
                this.ofk = r2;
            }

            protected final i d(String str, String str2, int i, int i2) {
                return new d(str, str2, i, i2);
            }
        };
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = this.nFR.inflate(2130903859, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        s sVar = (s) getItem(i);
        bVar.ofm.setText(sVar.field_name);
        bVar.ofn.setText(sVar.field_position);
        if (sVar.field_status == 1 || sVar.field_status == 2) {
            if (sVar.field_status == 1) {
                if (sVar.field_userOpStatus == 1) {
                    bVar.ofo.setText(2131233510);
                    bVar.ofo.setTextColor(2131689814);
                    bVar.ofo.setBackgroundResource(0);
                    bVar.ofo.setOnClickListener(null);
                } else {
                    bVar.ofo.setText(2131232991);
                    bVar.ofo.setTextColor(-1);
                    bVar.ofo.setBackgroundResource(2130837799);
                    bVar.ofo.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a ofk;

                        public final void onClick(View view) {
                            if (this.ofk.ofj != null) {
                                this.ofk.ofj.dk(i, 0);
                            }
                        }
                    });
                }
            } else if (sVar.field_userOpStatus == 1) {
                bVar.ofo.setText(2131232994);
                bVar.ofo.setTextColor(2131689814);
                bVar.ofo.setBackgroundResource(0);
                bVar.ofo.setOnClickListener(null);
            } else {
                bVar.ofo.setText(2131232993);
                bVar.ofo.setTextColor(2131689814);
                bVar.ofo.setBackgroundResource(2130837800);
                bVar.ofo.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a ofk;

                    public final void onClick(View view) {
                        if (this.ofk.ofj != null) {
                            this.ofk.ofj.dk(i, 1);
                        }
                    }
                });
            }
        } else if (sVar.field_status == 3) {
            bVar.ofo.setText(2131232992);
            bVar.ofo.setTextColor(2131689814);
            bVar.ofo.setBackgroundResource(0);
            bVar.ofo.setOnClickListener(null);
        }
        this.ipD.a(bVar.ofl, null, sVar.field_picUrl, 2131165440, 0, 0);
        return view;
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        t FU = ah.FU();
        String str = this.ofi;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" WHERE ( ");
        stringBuilder.append("LinkedInFriend.wechatId=?");
        stringBuilder.append(")");
        setCursor(FU.cie.rawQuery("SELECT LinkedInFriend.linkedInId,LinkedInFriend.name,LinkedInFriend.position,LinkedInFriend.picUrl,LinkedInFriend.wechatUsername,LinkedInFriend.status,LinkedInFriend.wechatId,LinkedInFriend.wechatSmallHead,LinkedInFriend.wechatBigHead,LinkedInFriend.linkedInProfileUrl,LinkedInFriend.userOpStatus,LinkedInFriend.nickname FROM LinkedInFriend  " + stringBuilder.toString(), new String[]{str}));
        super.notifyDataSetChanged();
    }
}
