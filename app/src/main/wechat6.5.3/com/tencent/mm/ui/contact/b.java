package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View fDt = null;
    private View hFT = null;

    public enum a {
        Chatromm,
        ContactLabel,
        ContactIpCall
    }

    public b(Context context, final a aVar) {
        super(context);
        this.context = context;
        View.inflate(getContext(), 2130903089, this);
        this.fDt = findViewById(2131755326);
        this.hFT = this.fDt.findViewById(2131755327);
        this.contentView = (TextView) this.hFT.findViewById(2131755331);
        this.fDt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b oEC;

            public final void onClick(View view) {
                switch (aVar) {
                    case Chatromm:
                        Intent intent = new Intent();
                        intent.setClass(this.oEC.context, ChatroomContactUI.class);
                        this.oEC.context.startActivity(intent);
                        return;
                    case ContactLabel:
                        c.b(this.oEC.context, "label", ".ui.ContactLabelManagerUI", new Intent());
                        return;
                    case ContactIpCall:
                        c.b(this.oEC.context, "ipcall", ".ui.IPCallAddressUI", new Intent());
                        return;
                    default:
                        v.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", aVar);
                        return;
                }
            }
        });
        this.hFT.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b oEC;

            {
                this.oEC = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oEC.context instanceof MMActivity) {
                    ((MMActivity) this.oEC.context).axg();
                }
                return false;
            }
        });
        ImageView imageView = (ImageView) ((MaskLayout) this.hFT.findViewById(2131755328)).view;
        switch (aVar) {
            case Chatromm:
                this.contentView.setText(2131230838);
                d.a(getContext(), imageView, 2131165443);
                return;
            case ContactLabel:
                this.contentView.setText(2131230841);
                d.a(getContext(), imageView, 2131165444);
                return;
            case ContactIpCall:
                this.hFT.setBackgroundResource(2130838046);
                this.contentView.setText(2131230840);
                d.a(getContext(), imageView, 2131165449);
                return;
            default:
                return;
        }
    }

    public final void setVisible(boolean z) {
        this.fDt.setVisibility(z ? 0 : 8);
    }
}
