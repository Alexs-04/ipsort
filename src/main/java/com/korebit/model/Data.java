package com.korebit.model;

import com.korebit.model.enums.NetworkClass;
import com.korebit.model.enums.NetworkType;
import com.korebit.util.NetworkUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class Data {
    private static final ArrayList<Network> NETWORKS = new ArrayList<>();
    private static final Set<Integer> IDENTIFIERS = new HashSet<>();

    static {
        uploadData();
    }

    private static void uploadData() {
        File data = new File(Objects.requireNonNull(Data.class.getClassLoader().getResource("data/data.txt")).getPath());

        String name, mask, networkDirection, brodcast, range;
        NetworkClass networkClassType;
        NetworkType statusType;
        int prefix, identifier, finalOct, oct1, oct2, oct3;

        try (Scanner read = new Scanner(data)) {

            while (read.hasNextLine()) {
                identifier = read.nextInt();
                oct1 = read.nextInt();
                oct2 = read.nextInt();
                oct3 = read.nextInt();
                finalOct = read.nextInt();
                prefix = read.nextInt();
                name = read.nextLine();

                networkDirection = NetworkUtils.createNetDirection(oct1, oct2, oct3, finalOct);
                mask = NetworkUtils.createMask(prefix);
                brodcast = NetworkUtils.createBroadcast(networkDirection, mask);
                networkClassType = NetworkUtils.determinateClass(mask, oct1);
                statusType = NetworkUtils.createStatus(networkDirection);
                range = NetworkUtils.determinateRange(networkDirection, brodcast);

                if (IDENTIFIERS.add(identifier)) {
                    NETWORKS.add(Network.builder()
                            .identifier(identifier)
                            .netDirection(networkDirection)
                            .mask(mask)
                            .broadcast(brodcast)
                            .range(range)
                            .name(name.trim())
                            .networkClassType(networkClassType)
                            .status(statusType)
                            .build());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<Network> getNetworks() {
        return NETWORKS;
    }

    public static boolean addNetwork(Network network) {
        if (IDENTIFIERS.add(network.getIdentifier())) {
            NETWORKS.add(network);
            return true;
        }
        return false;
    }

    public static int[] countStatus() {
        int[] array = {0, 0};

        array[0] = NETWORKS.stream().filter(n -> n.getStatus() == NetworkType.PRIVATE).toArray().length;
        array[1] = NETWORKS.stream().filter(n -> n.getStatus() == NetworkType.PUBLIC).toArray().length;

        return array;
    }

    public static int countClass(NetworkClass classType) {
        return NETWORKS.stream().filter(n -> n.getNetworkClassType().equals(classType)).toArray().length;
    }

    public static void printTheFirstHundredNetworks() {
        for (int i = 0; i < 100; i++) {
            System.out.println(NETWORKS.get(i));
        }
    }
}
