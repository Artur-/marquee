package com.example.application.views.helloworld;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@JsModule("./mymarq.ts")
public class HelloWorldView extends VerticalLayout {

    private TextField name;
    private Button sayHello;
    private HorizontalLayout content;
    private Span text;

    public HelloWorldView() {
        setMargin(true);

        name = new TextField("Some text");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            text.setText(name.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        Div marquee = new Div();
        marquee.getStyle().set("width", "50px");
        marquee.getStyle().set("overflow", "hidden");
        marquee.addClassName("marquee3k");
        Element e = marquee.getElement();
        e.setAttribute("data-speed", "0.25");

        content = new HorizontalLayout();
        text = new Span();
        content.add(text);
        content.add(new Image("https://ca.slack-edge.com/T026F273M-U20PQNNS2-05df3dc34549-512", ""));
        marquee.add(content);

        add(marquee);

        getElement().executeJs("setTimeout( ()=> window.initMarq(), 1);");

        add(name, sayHello);
    }

}
