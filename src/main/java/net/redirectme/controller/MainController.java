package net.redirectme.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.redirectme.dto.StatsProcessDTO;
import net.redirectme.receiver.ReceiveData;
import net.redirectme.transmitter.TransmitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
@AllArgsConstructor
@Slf4j
public class MainController {

    @Autowired
    private ReceiveData receiveData;
    @Autowired
    private TransmitData transmitData;

    @PostMapping("/risk/dataEntry")
    public ResponseEntity<Boolean> dataEntry(@RequestBody StatsProcessDTO json) {
        boolean body;
        try {
            body = receiveData.receiveRiskData(json);
            if (!body) {
                throw new RuntimeException();
            }
            log.info(json.toString());
            return ResponseEntity.status(200).body(body);
        } catch (Exception e) {
            body = false;
            log.error(e.toString());
            return ResponseEntity.status(500).body(body);
        }
    }

    @GetMapping("/risk/getStatus")
    public ResponseEntity<StatsProcessDTO> getRecord() {
        StatsProcessDTO body = null;
        try {
            body = transmitData.transmitRiskData();
            return ResponseEntity.status(200).body(body);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(body);
        }
    }


}
