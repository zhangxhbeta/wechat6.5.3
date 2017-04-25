package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public Map<Integer, Map<Integer, Integer>> kzR;
    public int mState;

    public c(int i) {
        this.mState = i;
    }

    @SuppressLint({"UseSparseArrays"})
    public final void M(int i, int i2, int i3) {
        Map map;
        if (this.kzR == null) {
            this.kzR = new HashMap();
        }
        if (this.kzR.containsKey(Integer.valueOf(i))) {
            map = (Map) this.kzR.get(Integer.valueOf(i));
        } else {
            map = new HashMap();
            this.kzR.put(Integer.valueOf(i), map);
        }
        map.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final boolean sb(int i) {
        if (this.kzR == null || !this.kzR.containsKey(Integer.valueOf(this.mState))) {
            v.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[]{b.rV(this.mState)});
            return false;
        } else if (((Map) this.kzR.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(i))) {
            return true;
        } else {
            v.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[]{b.rV(this.mState), b.rV(i)});
            return false;
        }
    }
}
