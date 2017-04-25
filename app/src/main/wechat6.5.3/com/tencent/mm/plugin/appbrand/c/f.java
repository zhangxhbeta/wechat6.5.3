package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Paint.Style;
import com.tencent.mm.plugin.appbrand.c.a.a;
import java.util.Stack;

public final class f {
    public a dCm = new a();
    public a dCn;
    public Stack<a> dCo;
    public Stack<a> dCp;
    public String dzg;

    public f() {
        this.dCm.setStyle(Style.STROKE);
        this.dCn = new a();
        this.dCn.setStyle(Style.FILL);
        this.dCm.setAntiAlias(true);
        this.dCn.setAntiAlias(true);
        this.dCo = new Stack();
        this.dCp = new Stack();
    }
}
