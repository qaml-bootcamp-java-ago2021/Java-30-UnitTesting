package com.funkos;

import exceptions.FunkoNoEncontradoException;

import java.util.ArrayList;
import java.util.Collection;

public class GestorDeFunkos {

    private Collection<Funko> funkos;

    public GestorDeFunkos(){
        this.funkos = new ArrayList<>();
    }

    public Collection<Funko> getFunkos() {
        return funkos;
    }

    // CRUD
    // Create - Agregamos un Funko a la coleccion de Funkos.
    public boolean agregarFunko(Funko funko){
        return this.funkos.add(funko);
    }

    // Read - Buscamos un Funko en la colección a través de su id.
    // Si el Funko no se encuentra, una Excepción FunkoNoEncontradoException es arrojada.
    public Funko leerFunkoPorId(int id) throws FunkoNoEncontradoException {

        var funko = funkos
                .stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if(funko == null)
            throw new FunkoNoEncontradoException("Lo siento pero el Funko con el id " + id + " no lo tenemos en la lista.");

        return funko;
    }

    // Update - Actualizamos el Nombrel de un Funko en la lista.
    public void actualizarNombreFunko(Funko funko){
        for (Funko f : funkos) {
            if(f.getId() == funko.getId()){
                f.setNombre(funko.getNombre());
            }
        }
    }

    // Delete - Borramos un Funko de la lista.
    public boolean borrarFunko(int id){
        return funkos.removeIf(funko -> funko.getId() == id);
    }
}
