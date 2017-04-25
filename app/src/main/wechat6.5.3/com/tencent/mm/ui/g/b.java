package com.tencent.mm.ui.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.o;
import com.tencent.mmdb.FileUtils;

public final class b extends o {
    public long Ov = 3000;
    @SuppressLint({"HandlerLeak"})
    private ac mHandler = new ac(this) {
        final /* synthetic */ b oPI;

        {
            this.oPI = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case FileUtils.S_IRUSR /*256*/:
                    this.oPI.dismiss();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    private b(View view) {
        super(view);
    }

    public static b eJ(Context context) {
        View inflate = LayoutInflater.from(context).inflate(2130904548, null);
        ((TextView) inflate.findViewById(2131759572)).setVisibility(8);
        b bVar = new b(inflate);
        bVar.setFocusable(false);
        bVar.setContentView(inflate);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        bVar.setAnimationStyle(2131559108);
        bVar.Ov = 1200;
        return bVar;
    }

    public final void showAsDropDown(View view, int i, int i2) {
        super.showAsDropDown(view, i, i2);
        this.mHandler.removeMessages(FileUtils.S_IRUSR);
        this.mHandler.sendEmptyMessageDelayed(FileUtils.S_IRUSR, this.Ov);
    }

    public final void showAsDropDown(View view) {
        super.showAsDropDown(view);
        this.mHandler.removeMessages(FileUtils.S_IRUSR);
        this.mHandler.sendEmptyMessageDelayed(FileUtils.S_IRUSR, this.Ov);
    }

    public final void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.mHandler.removeMessages(FileUtils.S_IRUSR);
        this.mHandler.sendEmptyMessageDelayed(FileUtils.S_IRUSR, this.Ov);
    }
}
