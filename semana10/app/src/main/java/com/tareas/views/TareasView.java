package com.tareas.views;

import com.tareas.Tarea;
import com.tareas.TareaEditable;
import com.tareas.TareaService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "", layout = MainLayout.class)
public class TareasView extends VerticalLayout {

    private final TareaService servicio;

    private final Grid<Tarea> grid = new Grid<>(Tarea.class, false);
    private final TextField descripcion = new TextField("Descripción");
    private final Checkbox completada = new Checkbox("Completada");

    private final Binder<TareaEditable> binder =
            new Binder<>(TareaEditable.class);

    private TareaEditable tareaActual = new TareaEditable();

    public TareasView(TareaService servicio) {
        this.servicio = servicio;

        add(new H2("Lista de Tareas"));

        grid.addColumn(Tarea::id).setHeader("ID");
        grid.addColumn(Tarea::descripcion).setHeader("Descripción");
        grid.addColumn(Tarea::completada).setHeader("Completada");

        grid.addComponentColumn(tarea ->
            new RouterLink("Ver detalle", TareaDetalleView.class, tarea.id())
        ).setHeader("Detalle");

        binder.forField(descripcion)
                .bind(TareaEditable::getDescripcion,
                      TareaEditable::setDescripcion);

        binder.forField(completada)
                .bind(TareaEditable::isCompletada,
                      TareaEditable::setCompletada);

        Button guardar = new Button("Guardar", e -> guardarTarea());
        Button nuevo = new Button("Nuevo", e -> nuevaTarea());
        Button eliminar = new Button("Eliminar", e -> eliminarTarea());

        add(grid);
        add(new VerticalLayout(descripcion, completada,
                new HorizontalLayout(guardar, nuevo, eliminar)));

        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                cargarTarea(event.getValue());
            }
        });

        nuevaTarea();
        refrescarGrid();
    }

    private void guardarTarea() {
        if (!binder.writeBeanIfValid(tareaActual)) {
            Notification.show("Completa los datos correctamente");
            return;
        }

        if (tareaActual.getDescripcion() == null ||
                tareaActual.getDescripcion().isBlank()) {
            Notification.show("Escribe una descripción");
            return;
        }

        if (tareaActual.getId() == 0) {
            servicio.agregar(tareaActual.getDescripcion());
        } else {
            servicio.actualizar(new Tarea(
                    tareaActual.getId(),
                    tareaActual.getDescripcion(),
                    tareaActual.isCompletada()
            ));
        }

        Notification.show("Tarea guardada");
        nuevaTarea();
        refrescarGrid();
    }

    private void cargarTarea(Tarea tarea) {
        tareaActual = new TareaEditable();
        tareaActual.setId(tarea.id());
        tareaActual.setDescripcion(tarea.descripcion());
        tareaActual.setCompletada(tarea.completada());

        binder.setBean(tareaActual);
    }

    private void nuevaTarea() {
        tareaActual = new TareaEditable();
        binder.setBean(tareaActual);
        grid.deselectAll();
    }

    private void eliminarTarea() {
        if (tareaActual.getId() == 0) {
            Notification.show("Selecciona una tarea");
            return;
        }

        servicio.eliminar(tareaActual.getId());

        Notification.show("Tarea eliminada");
        nuevaTarea();
        refrescarGrid();
    }

    private void refrescarGrid() {
        grid.setItems(servicio.listar());
    }
}
