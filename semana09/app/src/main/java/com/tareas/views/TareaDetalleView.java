package com.tareas.views;

import com.tareas.Tarea;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "tareas", layout = MainLayout.class)
public class TareaDetalleView extends VerticalLayout
        implements HasUrlParameter<Long> {

    private final H2 titulo = new H2("Detalle de tarea");
    private final Paragraph contenido = new Paragraph();

    public TareaDetalleView() {
        add(titulo, contenido);
    }

    @Override
    public void setParameter(BeforeEvent evento, Long id) {

        Tarea tarea = TareasView.buscarPorId(id);

        if (tarea == null) {
            contenido.setText("No se encontró la tarea con ID: " + id);
        } else {
            contenido.setText(
                "ID: " + tarea.id()
                + " | Descripción: " + tarea.descripcion()
                + " | Completada: " + (tarea.completada() ? "Sí" : "No")
            );
        }
    }
}
