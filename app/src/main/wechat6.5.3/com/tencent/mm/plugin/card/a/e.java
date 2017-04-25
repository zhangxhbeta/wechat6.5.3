package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public CardInfo eAI = null;
    public Map<String, Object> eBj = new HashMap();

    public e() {
        this.eBj.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.eBj.put(str, obj);
        }
    }

    public final Object getValue(String str) {
        if (!TextUtils.isEmpty(str) && this.eBj.containsKey(str)) {
            return this.eBj.get(str);
        }
        return null;
    }
}
