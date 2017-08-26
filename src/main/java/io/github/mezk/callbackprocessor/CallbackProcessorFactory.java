package io.github.mezk.callbackprocessor;

public interface CallbackProcessorFactory {

    CallbackProcessor getProcessor(String callbackType);

}
