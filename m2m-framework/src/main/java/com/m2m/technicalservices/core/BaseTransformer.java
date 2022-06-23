package com.m2m.technicalservices.core;

import java.util.ArrayList;
import java.util.List;

import com.m2m.technicalservices.dao.impl.GenericEntity;

public abstract class BaseTransformer<T extends GenericEntity, V extends ValueObject>
		implements ITransformer<T, V> {

	public List<V> model2VO(List<T> models, boolean... forCombo) {
		List<V> vos = new ArrayList<V>();
		for (T model : models) {
			vos.add(model2VO(model, forCombo));
		}
		return vos;
	}

	public List<T> vo2Model(List<V> vos) {
		List<T> models = new ArrayList<T>();
		for (V vo : vos) {
			models.add(vo2Model(vo));
		}
		return models;
	}

}
