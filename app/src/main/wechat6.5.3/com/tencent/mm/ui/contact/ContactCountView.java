package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.i.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;

public class ContactCountView extends FrameLayout {
    private int count = 0;
    private View fDt;
    private TextView gKl;
    int oFo = 1;
    private boolean visible = true;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ContactCountView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), 2130903406, this);
    }

    protected void onMeasure(int i, int i2) {
        v.d("MicroMsg.ContactCountView", "onMeasure");
        if (this.fDt == null) {
            this.fDt = (FrameLayout) findViewById(2131756433);
            this.gKl = (TextView) findViewById(2131756434);
        }
        bHr();
        super.onMeasure(i, i2);
    }

    public final void bHr() {
        String[] strArr = m.crG;
        if (this.oFo == 1) {
            ak.yW();
            this.count = c.wH().b(strArr, k.xF(), "weixin", "helper_entry", "filehelper");
        } else {
            int i;
            ak.yW();
            aa wH = c.wH();
            String[] strArr2 = new String[]{k.xF(), "weixin", "helper_entry", "filehelper"};
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select count(username) from rcontact where ");
            stringBuilder.append("type & ").append(a.tE()).append(" !=0 and ");
            stringBuilder.append("type & ").append(a.tH()).append(" =0 and ");
            stringBuilder.append("type & ").append(a.tF()).append(" =0 and ");
            stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
            stringBuilder.append("( username like '%@chatroom')");
            if (strArr != null && strArr.length > 0) {
                for (String append : strArr) {
                    stringBuilder.append(" and rcontact.username").append(" != '").append(append).append("'");
                }
            }
            for (i = 0; i < 4; i++) {
                stringBuilder.append(" and rcontact.username").append(" != '").append(strArr2[i]).append("'");
            }
            Cursor rawQuery = wH.cie.rawQuery(stringBuilder.toString(), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                rawQuery.close();
            } else {
                i = 0;
            }
            v.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
            this.count = i;
        }
        v.d("MicroMsg.ContactCountView", "contact count %d", Integer.valueOf(this.count));
        if (this.gKl != null) {
            if (this.oFo == 1) {
                this.gKl.setText(getContext().getResources().getQuantityString(2131361793, this.count, new Object[]{Integer.valueOf(this.count)}));
            } else {
                this.gKl.setText(getContext().getResources().getQuantityString(2131361792, this.count, new Object[]{Integer.valueOf(this.count)}));
            }
        }
        setVisible(this.visible);
    }

    public final void setVisible(boolean z) {
        this.visible = z;
        if (this.fDt != null) {
            View view = this.fDt;
            int i = (!z || this.count <= 0) ? 8 : 0;
            view.setVisibility(i);
        }
    }
}
