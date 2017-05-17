package com.vaadin.addon.board.testUI;

import static com.vaadin.addon.board.testUI.UIFunctions.newInstanceStream;
import static com.vaadin.addon.board.testUI.UIFunctions.testLayout;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;

/**
 *
 */
public abstract class Dash27BasicUI extends AbstractTestUI {

    protected abstract Supplier<Class<? extends Component>> nextClass();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(
            testLayout()
                .apply(
                    newInstanceStream()
                        .apply(nextClass().get(), 3)
                        .getOrElse(Stream::of)));
    }
}
