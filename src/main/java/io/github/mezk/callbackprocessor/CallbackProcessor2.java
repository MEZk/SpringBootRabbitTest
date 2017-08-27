package io.github.mezk.callbackprocessor;

import org.springframework.stereotype.Component;

@Component("CallbackProcessor2")
public class CallbackProcessor2 implements CallbackProcessor {
    @Override
    public void process(String callback) {
        System.out.println("CallbackProcessor2 is processing callback");
    }
}
