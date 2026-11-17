package com.tareas.views;

import com.tareas.TareaEditable;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;

public class TareaFormulario extends VerticalLayout {

    private final TextField descripcion = new TextField("Descripción");
    private final Checkbox completada = new Checkbox("Completada");
    private final Binder<TareaEditable> binder = new Binder<>(TareaEditable.class);

    public TareaFormulario() {
        binder.forField(descripcion)
                .asRequired("La descripción es obligatoria")
                .bind(TareaEditable::getDescripcion, TareaEditable::setDescripcion);

        binder.forField(completada)
                .bind(TareaEditable::isCompletada, TareaEditable::setCompletada);

        add(descripcion, completada);
    }

    public void setTarea(TareaEditable tarea) {
        binder.readBean(tarea);
    }

    public TareaEditable obtenerTarea() {
        TareaEditable tarea = new TareaEditable();

        if (binder.writeBeanIfValid(tarea)) {
            return tarea;
        }

        return null;
    }
}
