/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.extranjeros.ejb;


import co.edu.uniandes.csw.extranjeros.entities.LugaresDeInteresEntity;
import co.edu.uniandes.csw.extranjeros.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.extranjeros.persistence.LugaresDeInteresPersistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author o.amaya724
 */
public class LugaresDeInteresLogic {
    
    private static final Logger LOGGER = Logger.getLogger(UniversidadLogic.class.getName());

    @Inject
    private LugaresDeInteresPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    //CREATE
    /**
     * Se encarga de crear un lugar de interes en la base de datos
     * @param entity
     * @return Objeto de LugaresDeInteresEntity con su ID y sus datos.
     * @throws BusinessLogicException 
     */
    public LugaresDeInteresEntity createLugarDeInteres(LugaresDeInteresEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de lugar de interes");
        // Verifica la regla de negocio que dice que no puede haber dos lugares de interes con el mismo nombre
        if (persistence.findByName(entity.getName()) != null) {
            throw new BusinessLogicException("Ya existe un Lugar de Interes con el nombre \"" + entity.getName() + "\"");
        }
        // Invoca la persistencia para crear el lugar de interes
        return persistence.create(entity);
    }

     //-- GET ALL
    /**
     * Obtiene la lista de los registros de Lugares de Interes.
     * @return Colección de objetos de LugaresDeInteresEntity.
     */
    public List<LugaresDeInteresEntity> getLugaresDeInteres() {
        LOGGER.info("Inicia proceso de consultar todos los lugares de interes");
        return persistence.findAll();
        
    }

    //-- GET ONE
    /**
     * Obtiene los datos de una instancia de Universidad a partir de su ID (identificador).
     * @param id Identificador de la instancia a consultar.
     * @return Instancia de UniversidadEntity con los datos del Usuario consultado.
     */
    public LugaresDeInteresEntity getLugarDeInteres(Long id) {
        return persistence.find(id);
    }

    //-- UPDATE
    /**
     * Actualiza la información de una instancia de Lugar de Interes.
     * @param entity Instancia de LugaresDeInteresEntity con los nuevos datos.
     * @return Instancia de LugaresDeInteresEntity con los datos actualizados.
     */
    public LugaresDeInteresEntity updateLugarDeInteres(LugaresDeInteresEntity entity)  {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un lugar de interes");
        return persistence.update(entity);
    }
    
    //-- DELETE
    /**
     * Elimina una instancia de Universidad de la base de datos.
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteLugarDeInteres(Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar lugar de interes con id={0}", id);    
        persistence.delete(id);
        
    }
    
}
