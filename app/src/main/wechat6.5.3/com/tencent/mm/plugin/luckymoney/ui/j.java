package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.ui.MMActivity;

public final class j {
    MMActivity eLn;
    int hhC;
    int hhD;

    public static final class a {
        public int dZc;
        public Drawable hhE;
        public int hhF;
        public int hhG;
        public int hhH;
        public int hhI;
    }

    public j(MMActivity mMActivity) {
        this.eLn = mMActivity;
        if (ayy()) {
            Window window = mMActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            this.hhD = window.getStatusBarColor();
        }
    }

    private static boolean ayy() {
        return VERSION.SDK_INT >= 21;
    }

    final void mL(int i) {
        if (ayy()) {
            Window window = this.eLn.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    static a z(Context context, int i) {
        a aVar = new a();
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                aVar.hhE = new ColorDrawable(resources.getColor(2131689833));
                aVar.hhF = resources.getColor(2131689834);
                aVar.hhG = resources.getColor(2131689840);
                aVar.hhH = resources.getColor(2131689840);
                aVar.hhI = 2130838521;
                aVar.dZc = resources.getColor(2131689844);
                break;
            default:
                aVar.hhE = resources.getDrawable(2130838516);
                aVar.hhF = -1;
                aVar.hhH = resources.getColor(2131689854);
                aVar.dZc = resources.getColor(2131689829);
                break;
        }
        return aVar;
    }
}
