package net.redirectme.receiver;

import net.redirectme.dto.StatsProcessDTO;

public interface ReceiveData {
    boolean receiveRiskData(StatsProcessDTO statsProcessDTO);
}
