package net.redirectme.transmitter;

import lombok.extern.slf4j.Slf4j;
import net.redirectme.dto.StatsProcessDTO;
import net.redirectme.ioprocess.ReadWriteProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransmitDataImpl implements TransmitData {

    @Autowired
    private ReadWriteProcess readWriteProcess;

    @Override
    public StatsProcessDTO transmitRiskData() {
        return readWriteProcess.readFromFile();
    }
}
