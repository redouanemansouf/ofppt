package com.m2m.onousc.web.referentiel.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.m2m.onousc.business.referentiel.vo.VilleVO;
import com.m2m.onousc.web.referentiel.ReferentielSrvPresentation;
import com.m2m.technicalservices.spring.BeansLookuper;

/**
 * 
 * @author abousnane
 * 
 */
@FacesConverter("villeConverter")
public class VilleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				ReferentielSrvPresentation servicePres = (ReferentielSrvPresentation) BeansLookuper
						.lookup("referentielSrvPresentation");
				return servicePres.findVille(Long.parseLong(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erreur de conversion",
						"Veuillez choisir une ville"));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			return String.valueOf(((VilleVO) value).getId());
		} else {
			return null;
		}
	}

}
