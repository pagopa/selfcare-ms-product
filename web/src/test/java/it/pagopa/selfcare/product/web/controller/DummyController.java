package it.pagopa.selfcare.product.web.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    public Object notVoidMethod() {
        return new Object();
    }

    public void voidMethod() {
    }

}
