package io.github.mezk.callbackprocessor;

import org.springframework.stereotype.Component;

@Component("CallbackProcessor1")
public class CallbackProcessor1 implements CallbackProcessor {
    @Override
    public void process(String callback) {
        System.out.println("CallbackProcessor1 is processing callback");
    }
}
