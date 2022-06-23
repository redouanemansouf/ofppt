package com.m2m.technicalservices.core;

import java.io.Serializable;

import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * L’interface IValueObject est à implémenter par les objets « value object »
 * échangés entre le client et le core métier.
 * 
 * @author Younes SOUTEH
 * 
 */
public interface ValueObject extends Serializable {
	ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer();

}
