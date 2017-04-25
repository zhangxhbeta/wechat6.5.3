package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.widget.MMTextView;

final class cy implements OnClickListener {
    public a onG;

    public cy(a aVar) {
        this.onG = aVar;
    }

    public final void onClick(View view) {
        v.d("MicroMsg.ChattingTranslateClickListener", "tranlsate view clicked");
        if (view instanceof ChattingTranslateView) {
            int i;
            ChattingTranslateView chattingTranslateView = (ChattingTranslateView) view;
            if (chattingTranslateView.osK == ChattingTranslateView.a.Translating) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                MMTextView mMTextView = (MMTextView) view.getTag();
                if (mMTextView != null) {
                    int i2;
                    boolean z2;
                    dl dlVar = (dl) mMTextView.getTag();
                    boolean bwu = dlVar.bmk.bwu();
                    if (chattingTranslateView.osK == ChattingTranslateView.a.Translated) {
                        i2 = 1;
                    } else {
                        z2 = false;
                    }
                    if (i2 != 0) {
                        chattingTranslateView.bEU();
                        this.onG.a(dlVar.bmk.field_msgId, ChattingTranslateView.a.NoTranslate);
                        mMTextView.setText(dlVar.bmk.field_content);
                        e.e(mMTextView, 1);
                        return;
                    }
                    if (chattingTranslateView.osK == ChattingTranslateView.a.NoTranslate) {
                        i2 = 1;
                    } else {
                        z2 = false;
                    }
                    if (i2 == 0) {
                        return;
                    }
                    if (bwu) {
                        chattingTranslateView.OR(dlVar.bmk.field_transBrandWording);
                        this.onG.a(dlVar.bmk.field_msgId, ChattingTranslateView.a.Translated);
                        mMTextView.setText(dlVar.bmk.field_transContent);
                        e.e(mMTextView, 1);
                        return;
                    }
                    chattingTranslateView.bEV();
                    b piVar = new pi();
                    piVar.bqG.bqI = false;
                    piVar.bqG.id = dlVar.bmk.field_msgId;
                    piVar.bqG.bqH = dlVar.bmk.field_content;
                    piVar.bqG.type = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(piVar);
                    this.onG.a(dlVar.bmk.field_msgId, ChattingTranslateView.a.Translating);
                }
            }
        }
    }
}
