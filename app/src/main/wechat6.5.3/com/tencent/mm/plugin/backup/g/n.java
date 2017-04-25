package com.tencent.mm.plugin.backup.g;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n {
    private long beE = 0;
    boolean beg;
    private List<Object> ejC = new ArrayList();
    private Map<Integer, WeakReference<TextView>> ejD = new HashMap();
    private Map<String, Long> ejE = new HashMap();
    private LinkedList<String> ejF = new LinkedList();
    Set<String> ejG = new HashSet();
    private Set<Integer> ejH = new HashSet();
    private LinkedList<Object> ejI = new LinkedList();

    public final void cancel() {
        v.i("MicroMsg.LazerCaluateLoader", "cancel");
        this.ejF.clear();
        this.beg = true;
    }
}
