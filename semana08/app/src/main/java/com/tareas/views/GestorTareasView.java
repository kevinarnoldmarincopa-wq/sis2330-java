package com.tareas.views;

import com.tareas.Tarea;
import com.tareas.TareaEditable;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class GestorTareasView extends VerticalLayout {

    private final List<Tarea> tareas = new ArrayList<>();
    private final Grid<Tarea> grid = new Grid<>(Tarea.class, false);
    private final TareaFormulario formulario = new TareaFormulario();

    private Tarea seleccionActual;
    private long siguienteId = 1;

    public GestorTareasView() {

        setSizeFull();

        grid.addColumn(Tarea::id).setHeader("ID");
        grid.addColumn(Tarea::descripcion).setHeader("Descripción");
        grid.addColumn(Tarea::completada).setHeader("Completada");

        grid.asSingleSelect().addValueChangeListener(event ->
                cargarEnFormulario(event.getValue()));

        Button nuevo = new Button("Nuevo", event ->
                cargarEnFormulario(null));

        Button guardar = new Button("Guardar", event ->
                guardarTarea());

        Button eliminar = new Button("Eliminar", event ->
                eliminarTarea());

        add(
                grid,
                formulario,
                new HorizontalLayout(nuevo, guardar, eliminar)
        );

        actualizarTabla();
        cargarEnFormulario(null);
    }

    private void cargarEnFormulario(Tarea tarea) {

        seleccionActual = tarea;

        TareaEditable editable = new TareaEditable();

        if (tarea != null) {
            editable.setId(tarea.id());
            editable.setDescripcion(tarea.descripcion());
            editable.setCompletada(tarea.completada());
        }

        formulario.setTarea(editable);
    }

    private void guardarTarea() {

        TareaEditable editable = formulario.obtenerTarea();

        if (editable == null) {
            Notification.show("La descripción es obligatoria");
            return;
        }

        if (seleccionActual == null) {
            tareas.add(new Tarea(
                    siguienteId++,
                    editable.getDescripcion(),
                    editable.isCompletada()
            ));

            Notification.show("Tarea agregada");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).id() == seleccionActual.id()) {
                    tareas.set(i, new Tarea(
                            seleccionActual.id(),
                            editable.getDescripcion(),
                            editable.isCompletada()
                    ));
                    break;
                }
            }

            Notification.show("Tarea actualizada");
        }

        actualizarTabla();
        cargarEnFormulario(null);
    }

    private void eliminarTarea() {

        if (seleccionActual == null) {
            Notification.show("Seleccione una tarea");
            return;
        }

        tareas.removeIf(tarea ->
                tarea.id() == seleccionActual.id());

        Notification.show("Tarea eliminada");

        actualizarTabla();
        cargarEnFormulario(null);
    }

    private void actualizarTabla() {
        grid.setItems(tareas);
    }
}
