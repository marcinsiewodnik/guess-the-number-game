package com.marcinsi.util.thymeleaf;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupledTemplateLogic {

    // == fields ==

    private final SpringResourceTemplateResolver templateResolver;

    // == constructor ==

    public DecoupledTemplateLogic(SpringResourceTemplateResolver templateResolver) {

        this.templateResolver = templateResolver;
    }

    // == init ==

    @PostConstruct
    public void init(){

        templateResolver.setUseDecoupledLogic(true);

        log.info("Decoupled template enabled");
    }
}
