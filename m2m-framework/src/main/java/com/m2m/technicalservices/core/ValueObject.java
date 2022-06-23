package com.m2m.technicalservices.core;

import java.io.Serializable;

import com.m2m.technicalservices.dao.impl.GenericEntity;

/**
 * L�interface IValueObject est � impl�menter par les objets � value object �
 * �chang�s entre le client et le core m�tier.
 * 
 * @author Younes SOUTEH
 * 
 */
public interface ValueObject extends Serializable {
	ITransformer<? extends GenericEntity, ? extends ValueObject> getTransformer();

}
