package net.redirectme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StatsProcessDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("jobExecutionCode")
    private Long jobExecutionCode;
    @JsonProperty("numberOfCompanies")
    private Long numberOfCompanies;
    @JsonProperty("numberOfProcessedCompanies")
    private Long numberOfProcessedCompanies;
    @JsonProperty("numberOfSucceed")
    private Long numberOfSucceed;
    @JsonProperty("numberOfFailed")
    private Long numberOfFailed;
    @JsonProperty("runningStatus")
    private boolean runningStatus;
}
