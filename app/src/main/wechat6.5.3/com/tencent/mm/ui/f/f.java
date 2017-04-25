package com.tencent.mm.ui.f;

import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface f {

    public static class a {
        public int cWS = 0;
        public List<String> ezU = new LinkedList();
        public List<h> iHv = null;
        public int oPn = Integer.MAX_VALUE;
        public boolean oPo = true;
        public int oPp = Integer.MAX_VALUE;
        public boolean oPq = false;
        public int oPr = 0;
    }

    public interface b {
        void a(f fVar, String str);
    }

    void a(String str, ac acVar, HashSet<String> hashSet);

    void bIJ();

    LinkedList<Integer> bIK();

    int getType();

    com.tencent.mm.ui.f.a.a pe(int i);

    void ua();

    int xY(int i);
}
