package com.tencent.mm.network.a;

import com.tencent.mmdb.database.SQLiteDatabase;

public interface a {

    public static class a {
        public long beginTime = 0;
        public String clientIp = SQLiteDatabase.KeyEmpty;
        public long dcx = 0;
        public c dni;
        public boolean dnj = false;
        public long dnk = 0;
        public long dnl = 0;
        public long dnm = 0;
        public int dnn = 0;
        public int dno = 0;
        public long dnp = 0;
        public long dnq = 0;
        public long dnr = 0;
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int retryCount = 0;
        public long rtType = 0;

        public final String toString() {
            String str = "rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d";
            Object[] objArr = new Object[13];
            objArr[0] = Long.valueOf(this.rtType);
            objArr[1] = Long.valueOf(this.beginTime);
            objArr[2] = Long.valueOf(this.endTime);
            objArr[3] = Long.valueOf(this.endTime - this.beginTime);
            objArr[4] = Long.valueOf(this.dcx);
            objArr[5] = Long.valueOf(this.dnm);
            objArr[6] = this.dni == null ? "null" : this.dni.toString();
            objArr[7] = Boolean.valueOf(this.dnj);
            objArr[8] = Integer.valueOf(this.netType);
            objArr[9] = Integer.valueOf(this.errType);
            objArr[10] = Integer.valueOf(this.errCode);
            objArr[11] = Long.valueOf(this.dnk);
            objArr[12] = Long.valueOf(this.dnl);
            return String.format(str, objArr);
        }
    }
}
