package net.redirectme.ioprocess;

import net.redirectme.dto.StatsProcessDTO;

public interface ReadWriteProcess {

    boolean writeToFile(StatsProcessDTO statsProcessDTO);

    StatsProcessDTO readFromFile();

    String lastModifiedFile();
}
