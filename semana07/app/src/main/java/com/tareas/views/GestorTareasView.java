
package com.tareas.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class GestorTareasView extends VerticalLayout {

    private final TextField descripcion = new TextField("Descripción de la tarea");
    private final Button agregar = new Button("Agregar");
    private final Div lista = new Div();

    public GestorTareasView() {
        setSizeFull();

        agregar.addClickListener(event -> {
            String texto = descripcion.getValue().trim();

            if (texto.isEmpty()) {
                Notification.show("Escribe una tarea primero");
                return;
            }

            lista.add(new Div(texto));
            descripcion.clear();
        });

        add(descripcion, agregar, lista);
    }
}

