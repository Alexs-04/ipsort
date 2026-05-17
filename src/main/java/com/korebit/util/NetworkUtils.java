package com.korebit.util;

import lombok.NonNull;

public class NetworkUtils {
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

    public static String determinateClass(@NonNull String mask, int oct1) {
        if (mask.equals("255.0.0.0") && oct1 >= 1 && oct1 <= 126) {
            return "A";
        } else if (mask.equals("255.255.0.0") && oct1 >= 128 && oct1 <= 191) {
            return "B";
        } else if (mask.equals("255.255.255.0") && oct1 >= 192 && oct1 <= 223) {
            return "C";
        } else if (oct1 >= 224 && oct1 <= 239) {
            return "D";
        } else if (oct1 >= 240 && oct1 <= 255) {
            return "E";
        } else {
            return "MA";
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

    public static String createStatus(int oct) {
        if (oct == 10 || oct == 172 || oct == 192) {
            return "Privada";
        } else {
            return "Publica";
        }
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
        return oct1 >= 0 && oct1 <= 255 && oct2 >= 0
                && oct2 <= 255 && oct3 >= 0 && oct3 <= 255 && oct4 >= 0 && oct4 <= 255;

    }

    public static boolean validateOctet(int oct) {
        return oct >= 0 && oct <= 255;
    }

}
