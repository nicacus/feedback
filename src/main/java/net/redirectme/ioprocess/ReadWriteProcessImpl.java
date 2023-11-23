package net.redirectme.ioprocess;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.redirectme.dto.StatsProcessDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

@Service
@AllArgsConstructor
@Slf4j
public class ReadWriteProcessImpl implements ReadWriteProcess {

    @Override
    public boolean writeToFile(StatsProcessDTO statsProcessDTO) {
        try {
            String data = statsProcessDTO.toString();
            Files.write(Paths.get("./dataFiles/statsProcessDTO.txt"), data.getBytes());
        } catch (IOException e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public StatsProcessDTO readFromFile() {
        StatsProcessDTO statsProcessDTO = null;
        try {
            String file = Files.readString(Paths.get("./dataFiles/statsProcessDTO.txt"));
            statsProcessDTO = fromString(file);
            return statsProcessDTO;
        } catch (IOException e) {
            log.error(e.toString());
        }
        return statsProcessDTO;
    }

    @Override
    public String lastModifiedFile() {
        String lastModified = "";
        try {
            Path file = Paths.get("./dataFiles/statsProcessDTO.txt");
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            lastModified = attr.lastModifiedTime().toString();
        } catch (Exception e) {
            log.error(e.toString());
        }
        return lastModified;
    }


    // StatsProcessDTO(jobExecutionCode=0, numberOfCompanies=0, numberOfProcessed=0, numberOfSucceed=0, numberOfFailed=0, runningStatus=true)
    private StatsProcessDTO fromString(String string) {
        if (string.startsWith("StatsProcessDTO")) {
            StatsProcessDTO statsProcessDTO = new StatsProcessDTO();
            String prefix = "StatsProcessDTO(";
            String suffix = ")";
            String replacement = "";
            String processed = StringUtils.replace(string, prefix, replacement);
            String values = StringUtils.replace(processed, suffix, replacement);

            String[] valueList = values.split(",");
            for (String value : valueList) {
                if (value.startsWith("jobExecutionCode")) {
                    String[] vs = value.split("=");
                    for (String v : vs) {
                        if (!v.equalsIgnoreCase("jobExecutionCode")) {
                            statsProcessDTO.setJobExecutionCode(Long.parseLong(v));
                        }
                    }
                } else if (value.startsWith(" numberOfCompanies")) {
                    String[] vs = value.split("=");
                    for (String v : vs) {
                        if (!v.equalsIgnoreCase(" numberOfCompanies")) {
                            statsProcessDTO.setNumberOfCompanies(Long.parseLong(v));
                        }
                    }
                } else if (value.startsWith(" numberOfProcessedCompanies")) {
                    String[] vs = value.split("=");
                    for (String v : vs) {
                        if (!v.equalsIgnoreCase(" numberOfProcessedCompanies")) {
                            statsProcessDTO.setNumberOfProcessedCompanies(Long.parseLong(v));
                        }
                    }
                } else if (value.startsWith(" numberOfSucceed")) {
                    String[] vs = value.split("=");
                    for (String v : vs) {
                        if (!v.equalsIgnoreCase(" numberOfSucceed")) {
                            statsProcessDTO.setNumberOfSucceed(Long.parseLong(v));
                        }
                    }
                } else if (value.startsWith(" numberOfFailed")) {
                    String[] vs = value.split("=");
                    for (String v : vs) {
                        if (!v.equalsIgnoreCase(" numberOfFailed")) {
                            statsProcessDTO.setNumberOfFailed(Long.parseLong(v));
                        }
                    }
                } else if (value.startsWith(" runningStatus")) {
                    String[] vs = value.split("=");
                    for (String v : vs) {
                        if (!v.equalsIgnoreCase(" runningStatus")) {
                            statsProcessDTO.setRunningStatus(Boolean.parseBoolean(v));
                        }
                    }
                }
            }
            return statsProcessDTO;
        }
        return null;
    }


}
