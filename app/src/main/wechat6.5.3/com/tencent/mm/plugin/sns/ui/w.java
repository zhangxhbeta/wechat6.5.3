package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b.a.d.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import java.util.List;

public interface w {
    boolean a(int i, int i2, i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5);

    boolean a(int i, Intent intent);

    boolean aVA();

    boolean aVy();

    View aVz();

    void v(Bundle bundle);

    void w(Bundle bundle);
}
