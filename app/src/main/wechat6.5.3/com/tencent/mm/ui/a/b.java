package com.tencent.mm.ui.a;

import android.view.View;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private final String TAG = "MicroMsg.Accessibility.Tool";
    private List<String> nHB = new ArrayList();

    public final b Of(String str) {
        this.nHB.add(str);
        return this;
    }

    public final void cy(View view) {
        if (view != null && this.nHB.size() > 0) {
            String str = SQLiteDatabase.KeyEmpty;
            CharSequence charSequence = str;
            for (String str2 : this.nHB) {
                Object obj = charSequence + str2 + ",";
            }
            view.setContentDescription(charSequence);
        }
    }
}
