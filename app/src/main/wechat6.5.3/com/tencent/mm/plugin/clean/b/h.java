package com.tencent.mm.plugin.clean.b;

import java.util.ArrayList;

public interface h {

    public static class a {
        long beE;
        boolean cRi = false;
        long cWl;
        final String eUI;
        long eUJ;
        long eUK;
        long eUL;
        int eUM;
        ArrayList<b> eUN = new ArrayList(20);
        ArrayList<c> eUO = new ArrayList(20);

        a(String str) {
            this.eUI = str;
        }

        public final String toString() {
            return String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.eUI, Boolean.valueOf(this.cRi), Long.valueOf(this.eUJ), Long.valueOf(this.eUK), Long.valueOf(this.beE), Long.valueOf(this.eUL), Integer.valueOf(this.eUN.size()), Integer.valueOf(this.eUO.size()), Long.valueOf(this.cWl), Integer.valueOf(this.eUM)});
        }
    }

    public static class b {
        long beE;
        boolean cRi = false;
        final String eUI;
        long eUJ;
        long eUK;
        long eUL;
        final int tag;

        b(String str, int i) {
            this.eUI = str;
            this.tag = i;
        }

        public final String toString() {
            return String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.eUI, Boolean.valueOf(this.cRi), Long.valueOf(this.eUJ), Long.valueOf(this.eUK), Long.valueOf(this.beE), Long.valueOf(this.eUL)});
        }
    }

    public static class c {
        long beE;
        boolean cRi = false;
        final String eUI;
        long eUJ;
        long eUK;
        long eUL;

        c(String str) {
            this.eUI = str;
        }

        public final String toString() {
            return String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), this.eUI, Boolean.valueOf(this.cRi), Long.valueOf(this.eUJ), Long.valueOf(this.eUK), Long.valueOf(this.beE), Long.valueOf(this.eUL)});
        }
    }

    void a(int i, a aVar);
}
