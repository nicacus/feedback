package net.redirectme.receiver;

import lombok.extern.slf4j.Slf4j;
import net.redirectme.dto.StatsProcessDTO;
import net.redirectme.ioprocess.ReadWriteProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiveDataImpl implements ReceiveData {

    @Autowired
    private ReadWriteProcess readWriteProcess;


    @Override
    public boolean receiveRiskData(StatsProcessDTO statsProcessDTO) {
        return readWriteProcess.writeToFile(statsProcessDTO);
    }


}
