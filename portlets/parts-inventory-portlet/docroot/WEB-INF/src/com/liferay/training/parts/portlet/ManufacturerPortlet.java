package com.liferay.training.parts.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.impl.ManufacturerImpl;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ManufacturerPortlet
 */
public class ManufacturerPortlet extends MVCPortlet {
 
	/**
	 * Adds a new manufacturer to the database
	 * 
	 */
	public void addManufacturer(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Manufacturer manufacturer = manufacturerFromRequest(request);
		
		long userId = themeDisplay.getUserId();
		ManufacturerLocalServiceUtil.addManufacturer(manufacturer, userId);
		SessionMessages.add(request, "manufacturer-added");
		
		sendRedirect(request, response);

	}
	
	/**
	 * Updates the database record of an existing manufacturer.
	 * 
	 */
	public void updateManufacturer(ActionRequest request,
			ActionResponse response) throws Exception {

		Manufacturer manufacturer = manufacturerFromRequest(request);
		ManufacturerLocalServiceUtil.updateManufacturer(manufacturer);
		SessionMessages.add(request, "manufacturer-updated");
		
		sendRedirect(request, response);

	}

	/**
	 * Deletes a manufacturer from the database.
	 * 
	 */
	public void deleteManufacturer(ActionRequest request,
			ActionResponse response) throws Exception {

		long manufacturerId = ParamUtil.getLong(request, "manufacturerId");
		ManufacturerLocalServiceUtil.deleteManufacturer(manufacturerId);
		
		SessionMessages.add(request, "manufacturer-deleted");
		
		sendRedirect(request, response);
		
	}	
	
	
	/**
	 * Convenience method to create a Manufacturer object out of the request.
	 * Used by the Add / Edit methods.
	 * 
	 */
	private Manufacturer manufacturerFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		ManufacturerImpl manufacturer = new ManufacturerImpl();

		manufacturer.setManufacturerId(ParamUtil.getLong(request,"manufacturerId"));
		manufacturer.setName(ParamUtil.getString(request, "name"));
		manufacturer.setEmailAddress(ParamUtil.getString(request,"emailAddress"));
		manufacturer.setWebsite(ParamUtil.getString(request, "website"));
		manufacturer.setPhoneNumber(ParamUtil.getString(request, "phoneNumber"));
		manufacturer.setCompanyId(themeDisplay.getCompanyId());
		manufacturer.setGroupId(themeDisplay.getScopeGroupId());
		manufacturer.setUserId(themeDisplay.getUserId());

		return manufacturer;
	}
	
	private static Log _log = LogFactoryUtil.getLog(ManufacturerPortlet.class);
}
