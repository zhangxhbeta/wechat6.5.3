package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.loader.stub.BaseBuildInfo;

public final class e {
    public static String cmU = "d251b07e1b27e9ad27c6e8b98cac9640630b2dae";
    public static String cmV = "0x26050341";
    public static String cmX = "2017-01-05 23:43:00";
    public static String cmY = "null";
    public static String cmZ = "MicroMessenger_Android_GIT_RELEASE_GRADLE #2223";
    public static String cna = "amm_code_helper";
    public static String cnb = "null";
    public static String cnc = "origin/RB-2016-OCT@git";
    public static boolean nhT = false;

    private static class a {
        public static String dx(String str, String str2) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(str2);
            return indexOf >= 0 ? str.substring(indexOf) : str;
        }

        public static String dy(String str, String str2) {
            if (str == null) {
                return null;
            }
            if (str.equals(str2)) {
                return str;
            }
            return String.format("%s(%s)", new Object[]{str, str2});
        }
    }

    public static String bsN() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{a.dy(cmV, BaseBuildInfo.cmV)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{a.dy(cmZ, BaseBuildInfo.cmZ)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{a.dy(cna, BaseBuildInfo.cna)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{a.dy(cmY, BaseBuildInfo.cmY)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{a.dy(cmX, BaseBuildInfo.cmX)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{a.dy(cnb, BaseBuildInfo.cnb)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{a.dy(a.dx(cnc, "MicroMsg_proj"), a.dx(BaseBuildInfo.cnc, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{a.dy(cmU, BaseBuildInfo.cmU)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = BaseBuildInfo.vZ() ? BaseBuildInfo.vX() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
