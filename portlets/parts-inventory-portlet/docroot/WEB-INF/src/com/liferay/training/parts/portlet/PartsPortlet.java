package com.liferay.training.parts.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.model.impl.PartImpl;
import com.liferay.training.parts.service.PartLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * Portlet implementation class PartsPortlet
 */
public class PartsPortlet extends MVCPortlet {
	/**
	 * Adds a new part to the database.
	 * 
	 */
	public void addPart(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Part part = partFromRequest(request);
			long userId = themeDisplay.getUserId();
			PartLocalServiceUtil.addPart(part, userId);
			SessionMessages.add(request, "part-added");
			sendRedirect(request, response);

	}
	
	/**
	 * Convenience method to create a Part object out of the request. Used by
	 * the Add / Edit methods.
	 * 
	 */
	private Part partFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		int orderDateMonth = ParamUtil.getInteger(request, "orderDateMonth");
		int orderDateDay = ParamUtil.getInteger(request, "orderDateDay");
		int orderDateYear = ParamUtil.getInteger(request, "orderDateYear");

		Date orderDate = PortalUtil.getDate(orderDateMonth, orderDateDay,
				orderDateYear);
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
				request, "name");

		Part part = new PartImpl();

		part.setPartId(ParamUtil.getLong(request, "partId"));
		part.setNameMap(nameMap);
		part.setPartNumber(ParamUtil.getString(request, "partNumber"));
		part.setOrderDate(orderDate);
		part.setQuantity(ParamUtil.getInteger(request, "quantity"));
		part.setManufacturerId(ParamUtil.getLong(request, "manufacturerId"));
		part.setCompanyId(themeDisplay.getCompanyId());
		part.setGroupId(themeDisplay.getScopeGroupId());
		part.setUserId(themeDisplay.getUserId());
		
		
		return part;
	}

	private static Log _log = LogFactoryUtil.getLog(PartsPortlet.class);
	

}
