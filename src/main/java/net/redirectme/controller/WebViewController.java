package net.redirectme.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.redirectme.config.ApplicationInfoProperties;
import net.redirectme.dto.StatsProcessDTO;
import net.redirectme.ioprocess.ReadWriteProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class WebViewController {

    @Autowired
    private ApplicationInfoProperties applicationInfoProperties;
    @Autowired
    private ReadWriteProcess readWriteProcess;

    @RequestMapping("/")
    public ModelAndView homepage() {
        ModelAndView mav = new ModelAndView("homepage");
        String feedbackApplicationVersion = applicationInfoProperties.getVersion();
        StatsProcessDTO statsProcessDTO = readWriteProcess.readFromFile();
        String lastModified = readWriteProcess.lastModifiedFile();
        mav.addObject("jobNumberInProgress", statsProcessDTO);
        mav.addObject("feedbackApplicationVersion", feedbackApplicationVersion);
        mav.addObject("lastModified", lastModified);
        return mav;
    }

}
