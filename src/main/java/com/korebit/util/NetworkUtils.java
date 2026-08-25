package com.korebit.util;

import com.korebit.model.enums.NetworkType;
import lombok.NonNull;
import com.korebit.model.enums.NetworkClass;

public final class NetworkUtils {

    private NetworkUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String createNetDirection(int oct1, int oct2, int oct3, int oct4) {
        return oct1 + "." + oct2 + "." + oct3 + "." + oct4;
    }

    public static String createMask(int prefix) {
        if (prefix < 0 || prefix > 32) {
            return "";
        }

        int[] mask = getMaskArray(prefix);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(mask[i]);
            if (i < 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static int[] getMaskArray(int prefix) {
        int[] mask = new int[4];

        for (int i = 0; i < 4; i++) {
            if (prefix >= 8) {
                mask[i] = 255;
                prefix -= 8;
            } else if (prefix > 0) {
                mask[i] = 256 - (int) Math.pow(2, 8 - prefix);
                prefix = 0;
            }
        }
        return mask;
    }

    public static int createIntegerMask(int prefix) {
        int[] mask = getMaskArray(prefix);
        return mask[3];
    }

    public static NetworkClass determinateClass(@NonNull String mask, int oct1) {
        if (mask.equals("255.0.0.0") && oct1 >= 1 && oct1 <= 126) {
            return NetworkClass.A;
        } else if (mask.equals("255.255.0.0") && oct1 >= 128 && oct1 <= 191) {
            return NetworkClass.B;
        } else if (mask.equals("255.255.255.0") && oct1 >= 192 && oct1 <= 223) {
            return NetworkClass.C;
        } else if (oct1 >= 224 && oct1 <= 239) {
            return NetworkClass.D;
        } else if (oct1 >= 240 && oct1 <= 255) {
            return NetworkClass.E;
        } else {
            return NetworkClass.AM;
        }
    }

    public static String createBroadcast(@NonNull String netDirection, @NonNull String mask) {
        String[] netDirectionParts = netDirection.split("\\.");
        String[] maskParts = mask.split("\\.");
        int[] netDirectionBytes = new int[4];
        int[] maskBytes = new int[4];

        for (int i = 0; i < 4; i++) {
            netDirectionBytes[i] = Integer.parseInt(netDirectionParts[i]);
            maskBytes[i] = Integer.parseInt(maskParts[i]);
        }

        int[] broadcastBytes = new int[4];
        for (int i = 0; i < 4; i++) {
            broadcastBytes[i] = netDirectionBytes[i] | ~maskBytes[i] & 0xFF;
        }

        return broadcastBytes[0] + "." + broadcastBytes[1] + "." + broadcastBytes[2] + "." + broadcastBytes[3];
    }

    public static NetworkType createStatus(String ip) throws NumberFormatException {
        String[] split = ip.split("\\.");
        int oct1 = Integer.parseInt(split[0]);
        int oct2 = Integer.parseInt(split[1]);

        return switch (oct1) {
            case 10 -> NetworkType.PRIVATE;
            case 172 -> (oct2 >= 16 && oct2 <= 31) ? NetworkType.PRIVATE : NetworkType.PUBLIC;
            case 192 -> (oct2 == 168) ? NetworkType.PRIVATE : NetworkType.PUBLIC;
            default -> NetworkType.PUBLIC;
        };
    }

    public static String determinateRange(String netDirection, String broadcast) {
        String[] netDirectionsParts = netDirection.split("\\.");
        int[] netDirectionBytes = new int[4];

        for (int i = 0; i < 4; i++) {
            netDirectionBytes[i] = Integer.parseInt(netDirectionsParts[i]);
        }

        netDirectionBytes[3] += 1;

        String initDirection = netDirectionBytes[0] + "." + netDirectionBytes[1] + "." + netDirectionBytes[2] + "." + netDirectionBytes[3];

        String[] broadcastPartes = broadcast.split("\\.");
        int[] broadcastBytes = new int[4];

        for (int i = 0; i < 4; i++) {
            broadcastBytes[i] = Integer.parseInt(broadcastPartes[i]);
        }

        broadcastBytes[3] -= 1;

        String finalDirection = broadcastBytes[0] + "." + broadcastBytes[1] + "." + broadcastBytes[2] + "." + broadcastBytes[3];

        return initDirection + " - " + finalDirection;
    }

    public static boolean validateOctets(int oct1, int oct2, int oct3, int oct4) {
        return validateOctet(oct1) && validateOctet(oct2) && validateOctet(oct3) && validateOctet(oct4);

    }

    public static boolean validateOctet(int oct) {
        return oct >= 0 && oct <= 255;
    }

}
