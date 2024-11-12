package com.example.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.client.ChatClient;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView(ChatClient.Builder chatClientBuilder) {
        var ai = chatClientBuilder.build();

        var header = new H1("Hey there!");

        var funButton = new Button("Click me for a joke!");
        funButton.addClickListener(e -> {
            add(new Paragraph(ai.prompt().user("Tell me a joke!").call().content()));
        });

        add(header, funButton);
    }
}
