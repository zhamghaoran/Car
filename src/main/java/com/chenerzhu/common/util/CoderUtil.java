package com.chenerzhu.common.util;

import java.util.Base64;

import java.io.IOException;

public final class CoderUtil {

    private static Base64.Encoder base64Encoder;
    private static Base64.Decoder base64Decoder;

//    static {
//        base64Encoder = new Base64.Encoder();
//        base64Decoder = new Base64.Decoder
//    }

    /**
     * base64 编码
     *
     * @param data
     * @return
     */
    public static String encodeBase64(byte[] data) {
        return base64Encoder.encodeToString(data);
    }

    /**
     * base64 解码
     *
     * @param data
     * @return
     * @throws IOException
     */
    public static byte[] decodeBase64(String data) throws IOException {
        return base64Decoder.decode(data);
    }

    /**
     * 2进制数字转换为16进制字符串
     *
     * @param data
     * @return
     */
    public String encodeByteToHex(byte[] data) {
        if (data == null || data.length < 1) {
            return null;
        }

        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int h = data[i] & 0XFF;
            if (h < 16) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(h));
        }

        return hex.toString();
    }

    /**
     * 16进制字符串转换为2进制数字
     *
     * @param hex
     * @return
     */
    public byte[] decodeHex2Byte(String hex) {
        if (hex == null || "".equals(hex)) {
            return null;
        }

        int length = hex.length() >> 1;
        byte[] data = new byte[length];
        for (int i = 0; i < length; i++) {
            int n = i << 1;
            int height = Integer.valueOf(hex.substring(n, n + 1), 16);
            int low = Integer.valueOf(hex.substring(n + 1, n + 2), 16);
            data[i] = (byte) (height * 16 + low);
        }

        return data;
    }

}
