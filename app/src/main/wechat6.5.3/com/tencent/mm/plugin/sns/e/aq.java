package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.protocal.c.azr;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class aq implements e {
    public List<WeakReference<e>> jnz = new LinkedList();

    public final void a(e eVar) {
        for (WeakReference weakReference : this.jnz) {
            if (weakReference != null && weakReference.get() != null && ((e) weakReference.get()).equals(eVar)) {
                return;
            }
        }
        this.jnz.add(new WeakReference(eVar));
    }

    public final void a(int i, String str, long j, String str2, azr com_tencent_mm_protocal_c_azr, boolean z, bc bcVar) {
        for (WeakReference weakReference : this.jnz) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, com_tencent_mm_protocal_c_azr, z, bcVar);
            }
        }
    }

    public final void a(int i, String str, long j, String str2, azr com_tencent_mm_protocal_c_azr, boolean z) {
        for (WeakReference weakReference : this.jnz) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, com_tencent_mm_protocal_c_azr, z);
            }
        }
    }
}
