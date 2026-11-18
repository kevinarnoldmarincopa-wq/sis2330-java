package com.tareas.views;

import com.tareas.Tarea;
import com.tareas.TareaService;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "tareas", layout = MainLayout.class)
public class TareaDetalleView extends VerticalLayout
        implements HasUrlParameter<Long> {

    private final TareaService servicio;
    private final H2 titulo = new H2("Detalle de tarea");
    private final Paragraph contenido = new Paragraph();

    public TareaDetalleView(TareaService servicio) {
        this.servicio = servicio;
        add(titulo, contenido);
    }

    @Override
    public void setParameter(BeforeEvent evento, Long id) {
        Tarea tarea = servicio.buscarPorId(id);

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
