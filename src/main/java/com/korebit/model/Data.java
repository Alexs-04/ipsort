package com.korebit.model;

import com.korebit.util.NetworkUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class Data {
    private static final ArrayList<Network> NETWORKS = new ArrayList<>();
    private static final Set<Integer> NATS = new HashSet<>();

    static {
        uploadData();
    }

    private static void uploadData() {
        File data = new File(Objects.requireNonNull(Data.class.getClassLoader().getResource("data/data.txt")).getPath());

        String name, classType, mask, networkDirection, brodcast, status, range;
        int prefix, nat, finalOct, oct1, oct2, oct3;

        try (Scanner read = new Scanner(data)) {

            while (read.hasNextLine()) {
                nat = read.nextInt();
                oct1 = read.nextInt();
                oct2 = read.nextInt();
                oct3 = read.nextInt();
                finalOct = read.nextInt();
                prefix = read.nextInt();
                name = read.nextLine();

                networkDirection = NetworkUtils.createNetDirection(oct1, oct2, oct3, finalOct);
                mask = NetworkUtils.createMask(prefix);
                brodcast = NetworkUtils.createBroadcast(networkDirection, mask);
                classType = NetworkUtils.determinateClass(mask, oct1);
                status = NetworkUtils.createStatus(oct1);
                range = NetworkUtils.determinateRange(networkDirection, brodcast);

                if (NATS.add(nat)) {
                    NETWORKS.add(new Network(name, classType, mask, networkDirection, brodcast, status, range, prefix, nat));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<Network> getNetworks() {
        return NETWORKS;
    }
}
