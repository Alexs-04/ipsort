package com.korebit.service;

import com.korebit.dto.NetworkAddRequest;
import com.korebit.model.Data;
import com.korebit.model.Network;
import com.korebit.util.NetworkUtils;

public class NetworkService {

    public boolean addNetwork(NetworkAddRequest networkAddRequest) {
        if(!NetworkUtils.validateOctets(networkAddRequest.netDirection())) {
            return false;
        }

        String mask = NetworkUtils.createMask(networkAddRequest.Prefix());
        String broadcast = NetworkUtils.createBroadcast(networkAddRequest.netDirection(), mask);
        String range = NetworkUtils.determinateRange(networkAddRequest.netDirection(), broadcast);
        var networkClassType = NetworkUtils.determinateClass(mask, Integer.parseInt(networkAddRequest.netDirection().split("\\.")[0]));
        var statusType = NetworkUtils.createStatus(networkAddRequest.netDirection());

        return Data.addNetwork(Network.builder()
                .identifier(networkAddRequest.identifier())
                .netDirection(networkAddRequest.netDirection())
                .mask(mask)
                .broadcast(broadcast)
                .range(range)
                .name(networkAddRequest.name())
                .networkClassType(networkClassType)
                .status(statusType)
                .prefix(networkAddRequest.Prefix())
                .build());
    }
}
